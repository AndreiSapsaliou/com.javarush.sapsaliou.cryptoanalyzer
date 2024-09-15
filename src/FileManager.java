
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {
    public String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
  public void writeFile(String filePath, String content) throws IOException {
      Files.write(Paths.get(filePath), content.getBytes());
         }
     }
