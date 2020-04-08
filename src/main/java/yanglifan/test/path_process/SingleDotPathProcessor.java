package yanglifan.test.path_process;

/**
 * @author Yang Lifan
 */
public class SingleDotPathProcessor implements PathProcessor {
    @Override
    public boolean needProcess(String path) {
        return path.contains("/./");
    }

    @Override
    public String doProcess(String path) {
        return path.replace("/./", "/");
    }
}
