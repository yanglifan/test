package yanglifan.test.others.path_process;

/**
 * @author Yang Lifan
 */
public class DoubleDotsPathProcessor extends LoopPathProcessor {
    private static final String DOUBLE_DOTS = "..";
    private static final String DOUBLE_DOTS_WITH_SLASH = SEPARATOR + DOUBLE_DOTS;

    @Override
    public boolean needProcess(String path) {
        return path.contains(DOUBLE_DOTS);
    }

    @Override
    String processOne(String path) {
        int index = path.indexOf(DOUBLE_DOTS_WITH_SLASH);
        if (index == 0) {
            return SEPARATOR + path.substring(DOUBLE_DOTS_WITH_SLASH.length());
        } else {
            String prefixPath = path.substring(0, index);
            String suffixPath = path.substring(index + DOUBLE_DOTS_WITH_SLASH.length());
            int lastSlashIndex = prefixPath.lastIndexOf(SEPARATOR);
            return SEPARATOR + prefixPath.substring(0, lastSlashIndex) + suffixPath;
        }
    }
}
