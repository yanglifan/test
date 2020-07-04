package yanglifan.test.others.path_process;

/**
 * @author Yang Lifan
 */
public abstract class LoopPathProcessor implements PathProcessor {

    @Override
    public String doProcess(String path) {
        while (needProcess(path)) {
            path = processOne(path);
        }
        return path;
    }

    abstract String processOne(String path);
}
