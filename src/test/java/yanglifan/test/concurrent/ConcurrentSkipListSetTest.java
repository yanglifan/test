package yanglifan.test.concurrent;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

import org.junit.Test;

/**
 * @author Yang Lifan
 */
public class ConcurrentSkipListSetTest {
    private Set<String> concurrentHashSet = Collections.newSetFromMap(new ConcurrentHashMap<>());
    private Set<String> concurrentSkipListSet = new ConcurrentSkipListSet<>();

    @Test
    public void test() {

    }

    private void add(String value) {
        concurrentHashSet.add(value);
        concurrentSkipListSet.add(value);
    }
}
