package yanglifan.test.others.path_process;

/**
 * @author Yang Lifan
 */
public class SingleDotPathProcessor extends LoopPathProcessor {
    private static final String SINGLE_DOT = SEPARATOR + ".";
    private static final String SINGLE_DOT_ENDS_WITH_SLASH = SEPARATOR + "." + SEPARATOR;

    @Override
    public boolean needProcess(String path) {
        return path.contains(SINGLE_DOT_ENDS_WITH_SLASH) || !SINGLE_DOT.equals(path) && path.endsWith(SINGLE_DOT);
    }

    @Override
    public String processOne(String path) {
        if (path.contains(SINGLE_DOT_ENDS_WITH_SLASH)) {
            path = path.replace(SINGLE_DOT_ENDS_WITH_SLASH, SEPARATOR);
        }

        if (!SINGLE_DOT.equals(path) && path.endsWith(SINGLE_DOT)) {
            path = path.substring(0, path.length() - SINGLE_DOT.length() + 1);
        }

        return path;
    }
}
