package yanglifan.test.path_process;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yang Lifan
 */
public class PathProcessManager implements PathProcessor {
    private List<PathProcessor> processors = new ArrayList<>();

    public void init() {
        processors.add(new LastSlashPathProcessor()); // /home/ -> /home
        processors.add(new DoubleSlashesPathProcessor()); // /home//abc/ -> /home/abc/
        processors.add(new SingleDotPathProcessor()); // /home/./abc/ -> /home/abc/
    }

    @Override
    public boolean needProcess(String path) {
        return true;
    }

    @Override
    public String doProcess(String path) {
        if (path == null) {
            return path;
        }

        int notNeedProcessCount = 0;

        String currentPath = path;
        while (notNeedProcessCount < processors.size()) {
            notNeedProcessCount = 0;
            for (PathProcessor processor : processors) {
                if (!processor.needProcess(currentPath)) {
                    notNeedProcessCount++;
                    continue;
                }

                currentPath = processor.doProcess(currentPath);
            }
        }

        return currentPath;
    }
}
