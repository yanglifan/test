package yanglifan.test.path_process;

/**
 * @author Yang Lifan
 */
public class DoubleDotsPathProcessor implements PathProcessor {
    @Override
    public boolean needProcess(String path) {
        return path.contains("..");
    }

    @Override
    public String doProcess(String path) {
        return null;
    }
}
