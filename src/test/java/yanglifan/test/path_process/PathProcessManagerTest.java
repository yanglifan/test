package yanglifan.test.path_process;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

/**
 * @author Yang Lifan
 */
@RunWith(Parameterized.class)
public class PathProcessManagerTest {
    private PathProcessManager pathProcessManager;

    private String path;
    private String expect;

    public PathProcessManagerTest(String path, String expect) {
        this.path = path;
        this.expect = expect;
    }

    @Parameterized.Parameters
    public static Collection<String[]> data() {
        return Arrays.asList(new String[][]{
                {null, null},
                {"", ""},
                {"/", "/"},
                {"//", "/"},
                {"/////", "/"},
                {"/home//abc", "/home/abc"},
                {"/home/./abc", "/home/abc"},
                {"/home/", "/home"}
        });
    }

    @Before
    public void setUp() throws Exception {
        pathProcessManager = new PathProcessManager();
        pathProcessManager.init();
    }

    @Test
    public void test() {
        assertEquals(expect, pathProcessManager.doProcess(path));
    }
}