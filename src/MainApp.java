
import java.sql.SQLOutput;
import java.util.Scanner;
import java.io.*;

  public class MainApp {

      public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          Cipher cipher = new Cipher();
          FileManager fileProcessor = new FileManager();
          Validator inputValidator = new Validator();

          // Запрос режима работы
          System.out.println("Шифр Цезаря");
          System.out.println("Введите \"1\" для шифрования текста");
          System.out.println("Введите \"2\" для дешифрования текста");
          System.out.println("Введите \"3\" для выхода из программы");
          int i = scanner.nextInt();
          scanner.nextLine();
          if  (i < 1) {
              System.out.println("Введено некорректное значение!!!");
              return;
          } else if (i > 3) {
              System.out.println("Введено некорректное значение!!!");
              return;
          }

          if (i == 3) {
              System.out.println("Выход из программы");
              return;
          }

          // Запрос пути к файлу
          System.out.println("Введите путь к файлу:");
          String filePath = scanner.nextLine();

          if (!Validator.isFileExists(filePath)) {
              System.out.println("Ошибка: Файл не существует. Проверьте путь.");
              return;
          }

          // Запрос алфавита
          System.out.println("Выберите алфавит: ");
          System.out.println("Введите \"rus\" чтобы использовать Русский алфавит: ");
          System.out.println("Введите \"eng\" чтобы использовать Английский алфавит: ");
          String language = scanner.next().toLowerCase();


          // Запрос ключа
          System.out.println("Введите ключ (целое число):");
          int key = scanner.nextInt();
          if (!inputValidator.isValidKey(key)) {
              System.out.println("Ошибка: ключ должен быть неотрицательным.");
              return;
          }

          try {
              String content = fileProcessor.readFile(filePath);
              String result;

              if (i == 1) {
                  result = cipher.encrypt(content, key, language);
                  fileProcessor.writeFile("зашифрованный текст.txt", result);
                  System.out.println("Текст зашифрован и сохранён в 'зашифрованный текст.txt'.");
              } else if (i == 2) {
                  result = cipher.decrypt(content, key, language);
                  fileProcessor.writeFile("расшифрованный текст.txt", result);
                  System.out.println("Текст расшифрован и сохранён в 'расшифрованный текст.txt'.");
              } else {
                  System.out.println("Упс, что-то пошло не так.. . Проверьте правильность введенных данных.");
              }
          } catch (IOException e) {
              System.out.println("Ошибка при обработке файла: " + e.getMessage());
          } finally {
              scanner.close();
          }

      }
  }
