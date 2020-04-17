package yanglifan.test.url_sort;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleUrlVisitRecordTest {

    @Test
    public void basic() {
        SimpleUrlVisitRecord record = new SimpleUrlVisitRecord();
        record.visit("a");
        record.visit("b");
        record.visit("c");
        record.visit("b");
        record.visit("a");
        record.visit("b");
        record.visit("b");
        record.visit("d");

        assertThat(record.toUrlList().get(0)).isEqualTo("c");
        assertThat(record.toUrlList().get(1)).isEqualTo("d");
        assertThat(record.toUrlList().get(2)).isEqualTo("a");
        assertThat(record.toUrlList().get(3)).isEqualTo("b");
    }

    @Test
    public void perf() throws InterruptedException {
        SimpleUrlVisitRecord record = new SimpleUrlVisitRecord();
        ExecutorService executor = Executors.newFixedThreadPool(200);

        long start = System.currentTimeMillis();
        int times = 10_000_000;
        CountDownLatch countDownLatch = new CountDownLatch(times);
        for (int i = 0; i < times; i++) {
            executor.execute(() -> {
                String url = ThreadLocalRandom.current().nextInt(10000) + "";
                String url2 = ThreadLocalRandom.current().nextInt(1000) + "";
                String url3 = ThreadLocalRandom.current().nextInt(100) + "";
                record.visit(url);
                record.visit(url2);
                record.visit(url3);
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        UrlVisitRecord last;
        UrlVisitRecord current = null;
        for (UrlVisitRecord urlVisitRecord : record.toList()) {
            last = current;
            current = urlVisitRecord;
            if (last != null) {
                assertThat(last.getVisitCount().intValue() <= current.getVisitCount().incrementAndGet());
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}