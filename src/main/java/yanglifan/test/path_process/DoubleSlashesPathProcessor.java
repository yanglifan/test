package yanglifan.test.path_process;

/**
 * @author Yang Lifan
 */
public class DoubleSlashesPathProcessor extends LoopPathProcessor {
    private static final String DOUBLE_SLASHES = SEPARATOR + SEPARATOR;
    @Override
    public boolean needProcess(String path) {
        return path.contains(DOUBLE_SLASHES);
    }

    @Override
    String processOne(String path) {
        return path.replace(DOUBLE_SLASHES, SEPARATOR);
    }
}
