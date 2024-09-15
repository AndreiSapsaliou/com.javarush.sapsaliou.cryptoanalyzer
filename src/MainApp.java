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

        if (i==1) {
            System.out.println("Введите ключ: ");
            Scanner scanner1 = new Scanner(System.in);
            Cipher cipher = new Cipher(Alphabet.ALPHABET_RUS);
            int shift = scanner1.nextInt();
            System.out.println("Введите текст: ");
            String text = scanner1.nextLine();
            cipher.encrypt(text, shift);

            // shift = scanner1.nextInt();

            // text = scanner1.nextLine();
            // cipher.encrypt(scanner1.nextLine(), scanner1.nextInt());
            // System.out.println("Введите ключ для шифрования: ");
            // int shift = scanner1.nextInt();
            // System.out.println("Введите текст для шифрования: ");
            // String str = scanner1.nextLine();
            // String text = scanner1.toString();
            // cipher.encrypt(scanner1.toString(), scanner1.nextInt());



        }
        else if (i==2) {
            System.out.println("Введите текст для дешифрования:");

        }
        else if (i==3) {
            System.out.println("Выход из программы");
        } else {
            System.out.println("Введено некорректное значение");
        }
    }
    }
