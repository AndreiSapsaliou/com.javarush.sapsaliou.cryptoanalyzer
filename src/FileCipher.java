
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

    public class FileCipher {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Запрос режима работы
            System.out.println("Выберите режим: 1 - Шифрование, 2 - Расшифровка");
            int mode = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            // Запрос пути к файлу
            System.out.println("Введите путь к файлу:");
            String filePath = scanner.nextLine();
            if (!Files.exists(Paths.get(filePath))) {
                System.out.println("Ошибка: Файл не существует. Проверьте путь.");
                return;
            }

            // Запрос ключа
            System.out.println("Введите ключ (целое число):");
            int key = scanner.nextInt();
            if (key < 0) {
                System.out.println("Ошибка: Ключ должен быть неотрицательным.");
                return;
            }

            try {
                // Шифрование или расшифровка в зависимости от выбранного режима
                if (mode == 1) {
                    encryptFile(filePath, key);
                    System.out.println("Текст зашифрован и сохранен в 'encrypted.txt'.");
                } else if (mode == 2) {
                    decryptFile(filePath, key);
                    System.out.println("Текст расшифрован и сохранен в 'decrypted.txt'.");
                } else {
                    System.out.println("Ошибка: Неверный режим.");
                }
            } catch (IOException e) {
                System.out.println("Ошибка при обработке файла: " + e.getMessage());
            } finally {
                scanner.close();
            }
        }

        // Функция для шифрования текста
        public static void encryptFile(String filePath, int key) throws IOException {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
                 BufferedWriter writer = new BufferedWriter(new FileWriter("encrypted.txt"))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(encrypt(line, key));
                    writer.newLine();
                }
            }
        }

        // Функция для расшифровки текста
        public static void decryptFile(String filePath, int key) throws IOException {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
                 BufferedWriter writer = new BufferedWriter(new FileWriter("decrypted.txt"))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(decrypt(line, key));
                    writer.newLine();
                }
            }
        }

        // Алгоритм шифрования текста
        public static String encrypt(String text, int key) {
            StringBuilder encrypted = new StringBuilder();
            for (char character : text.toCharArray()) {
                if (Character.isLetter(character)) {
                    char base = Character.isLowerCase(character) ? 'a' : 'A';
                    char shifted = (char) ((character - base + key) % 26 + base);
                    encrypted.append(shifted);
                } else {
                    encrypted.append(character);
                }
            }
            return encrypted.toString();
        }

        // Алгоритм расшифровки текста
        public static String decrypt(String text, int key) {
            return encrypt(text, 26 - (key % 26)); // Используем функцию encrypt с инвертированным ключом
        }
    }

