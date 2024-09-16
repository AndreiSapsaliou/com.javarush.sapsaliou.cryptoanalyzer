import java.nio.file.Files;
import java.nio.file.Paths;

public class Validator {
    public static boolean isValidKey(int key) {
        return key > 0;
    }
    public static boolean isFileExists(String filePath) {
        return Files.exists(Paths.get(filePath));
    }
}
