package yanglifan.test.others.good_topn;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GoodTopNFinderTest {
    @Test
    public void basic() {
        GoodTopNFinder finder = new GoodTopNFinder();
        SortedSet<Good> goods = finder.find("test1000.csv", 100);
        List<Good> results = new ArrayList<>(goods);
        assertThat(results.get(0).getName()).isEqualTo("1000");
    }
}