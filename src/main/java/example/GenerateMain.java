package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;
import java.nio.file.Path;
import java.util.concurrent.Callable;

public class GenerateMain implements Callable<Integer>{
    @CommandLine.Parameters(
            index = "0",
            description = "The path to the target Maven project")
    private Path projectPath;

    private static final Logger logger = LoggerFactory.getLogger(GenerateMain.class);

    @Override
    public Integer call() throws Exception {
        new GenerateLauncher(projectPath).processWithSpoon();
        return null;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new GenerateMain()).execute(args);
        System.exit(exitCode);
    }

}
