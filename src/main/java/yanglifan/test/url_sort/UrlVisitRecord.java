package yanglifan.test.url_sort;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

class UrlVisitRecord implements Comparable<UrlVisitRecord> {
    private String url;
    private AtomicInteger visitCount;

    public UrlVisitRecord(String url) {
        this.url = url;
        visitCount = new AtomicInteger();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlVisitRecord that = (UrlVisitRecord) o;
        return url.equals(that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }

    @Override
    public int compareTo(UrlVisitRecord o) {
        if (visitCount.intValue() == o.visitCount.intValue()) {
            return this.url.compareTo(o.url);
        }
        return this.visitCount.intValue() - o.visitCount.intValue();
    }

    public String getUrl() {
        return url;
    }

    public AtomicInteger getVisitCount() {
        return visitCount;
    }
}
