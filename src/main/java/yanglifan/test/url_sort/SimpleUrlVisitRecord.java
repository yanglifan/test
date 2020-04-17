package yanglifan.test.url_sort;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

class SimpleUrlVisitRecord {
    private ConcurrentMap<String /* URL */, Lock> urlLocks = new ConcurrentHashMap<>();
    private ConcurrentMap<String /* URL */, UrlVisitRecord> urlRecords = new ConcurrentHashMap<>();
    private SortedSet<UrlVisitRecord> urlRecordSortedSet = new ConcurrentSkipListSet<>();

    void visit(String url) {
        UrlVisitRecord record = urlRecords.computeIfAbsent(url, UrlVisitRecord::new);
        Lock lock = urlLocks.computeIfAbsent(url, u -> new ReentrantLock());
        lock.lock();
        try {
            urlRecordSortedSet.remove(record);
            record.getVisitCount().incrementAndGet();
            urlRecordSortedSet.add(record);
        } finally {
            lock.unlock();
        }
    }

    List<String> toUrlList() {
        return urlRecordSortedSet.stream().map(UrlVisitRecord::getUrl).collect(Collectors.toList());
    }

    List<UrlVisitRecord> toList() {
        return new ArrayList<>(urlRecordSortedSet);
    }

}
