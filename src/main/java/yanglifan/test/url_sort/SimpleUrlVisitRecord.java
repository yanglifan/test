package yanglifan.test.url_sort;

import java.util.List;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

public class SimpleUrlVisitRecord {
    private ConcurrentMap<String /* URL */, UrlVisitRecord> urlRecords = new ConcurrentHashMap<>();
    private SortedSet<UrlVisitRecord> urlRecordSortedSet = new ConcurrentSkipListSet<>();

    public void visit(String url) {
        UrlVisitRecord record = urlRecords.computeIfAbsent(url, UrlVisitRecord::new);
        record.getVisitCount().incrementAndGet();
        urlRecordSortedSet.remove(record);
        urlRecordSortedSet.add(record);
    }


    public List<String> toList() {
        return urlRecordSortedSet.stream().map(UrlVisitRecord::getUrl).collect(Collectors.toList());
    }

}
