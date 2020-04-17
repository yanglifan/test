package yanglifan.test.url_sort;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

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

        assertThat(record.toList().get(0)).isEqualTo("c");
        assertThat(record.toList().get(1)).isEqualTo("d");
        assertThat(record.toList().get(2)).isEqualTo("a");
        assertThat(record.toList().get(3)).isEqualTo("b");
    }

    @Test
    public void perf() throws InterruptedException {
        SimpleUrlVisitRecord record = new SimpleUrlVisitRecord();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        long start = System.currentTimeMillis();
        int times = 100;
        CountDownLatch countDownLatch = new CountDownLatch(times);
        for (int i = 0; i < times; i++) {
            executor.execute(() -> {
                String url = ThreadLocalRandom.current().nextInt(1000) + "";
                record.visit(url);
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println(System.currentTimeMillis() - start);
    }
}