package yanglifan.test.others.path_process;

/**
 * @author Yang Lifan
 */
public class LastSlashPathProcessor extends LoopPathProcessor {
    @Override
    public boolean needProcess(String path) {
        return path.length() > 1 && path.endsWith(SEPARATOR);
    }

    @Override
    String processOne(String path) {
        return path.substring(0, path.lastIndexOf(SEPARATOR));
    }
}
