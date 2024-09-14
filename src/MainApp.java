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
            System.out.println("Введите ключ для шифрования:");
            Scanner scanner1 = new Scanner(System.in);
            


            System.out.println("Введите текст для шифрования:");
        }
        else if (i==2) {
            System.out.println("Введите текст для дешифрования:");
        }
        else if (i==3) {
            System.out.println("Выход из программы");
        }
    }
    }
