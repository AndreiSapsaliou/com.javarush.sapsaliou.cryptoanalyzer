
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {
    public String readFile(String filePath) {

        String str = "";

        try {
            str = new String(
                    Files.readAllBytes(Paths.get(filePath)));
        }
        catch (IOException e) {

            e.printStackTrace();
        }

        return str;
    }// Логика чтения файла
    }
// public void writeFile(String content, String filePath) {
        // Логика записи файла
   // }

