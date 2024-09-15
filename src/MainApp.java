
import java.sql.SQLOutput;
import java.util.Scanner;


public class MainApp {
    public static void main(String[] args) {
        System.out.println("Шифр Цезаря");
        System.out.println("Введите \"1\" для шифрования текста");
        System.out.println("Введите \"2\" для дешифрования текста");
        System.out.println("Введите \"3\" для выхода из программы");

        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

            if (i == 1) {
                System.out.println("Введите ключ шифрования: ");
                Cipher cipher = new Cipher(Alphabet.ALPHABET_RUS);
                Scanner scanner1 = new Scanner(System.in);
                int shift = scanner1.nextInt();
                System.out.println("Введите текст для шифрования: ");
                Scanner scanner2 = new Scanner(System.in);
                String text = scanner2.nextLine();
                System.out.println("Зашифрованный текст: ");
                System.out.println(cipher.encrypt(text, shift));

            } else if (i == 2) {
                System.out.println("Введите ключ дешифрования: ");
                Cipher cipher = new Cipher(Alphabet.ALPHABET_RUS);
                Scanner scanner1 = new Scanner(System.in);
                int shift = scanner1.nextInt();
                System.out.println("Введите текст для дешифрования: ");
                Scanner scanner2 = new Scanner(System.in);
                String text = scanner2.nextLine();
                System.out.println("Расшифрованный текст: ");
                System.out.println(cipher.decrypt(text, shift));

            } else if (i == 3) {
                System.out.println("Выход из программы");
            } else {
                System.out.println("Введено некорректное значение");
            }
        }
}

