package yanglifan.test.path_process;

/**
 * @author Yang Lifan
 */
public class LastSlashPathProcessor implements PathProcessor {
    @Override
    public boolean needProcess(String path) {
        return path.length() > 1 && path.endsWith("/");
    }

    @Override
    public String doProcess(String path) {
        return path.substring(0, path.lastIndexOf("/"));
    }
}
