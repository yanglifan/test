package yanglifan.test.path_process;

import java.util.ServiceLoader;

/**
 * @author Yang Lifan
 */
public class PathProcessManager implements PathProcessor {
    private Iterable<PathProcessor> processors;
    private int processorNumber;

    public void init() {
        processors = ServiceLoader.load(PathProcessor.class);
        processorNumber = getProcessorNumber();
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

        while (notNeedProcessCount < processorNumber) {
            notNeedProcessCount = 0;
            for (PathProcessor processor : processors) {
                if (!processor.needProcess(path)) {
                    notNeedProcessCount++;
                    continue;
                }

                path = processor.doProcess(path);
            }
        }

        return path;
    }

    private int getProcessorNumber() {
        int number = 0;
        for (PathProcessor ignored : processors) {
            number++;
        }
        return number;
    }
}
