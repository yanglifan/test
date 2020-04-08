package yanglifan.test.path_process;

/**
 * @author Yang Lifan
 */
public interface PathProcessor {
    String SEPARATOR = "/";

    boolean needProcess(String path);

    String doProcess(String path);
}
