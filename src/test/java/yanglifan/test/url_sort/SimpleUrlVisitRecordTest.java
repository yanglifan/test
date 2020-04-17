package yanglifan.test.url_sort;

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

        assertThat(record.toList().get(2)).isEqualTo("b");
    }
}