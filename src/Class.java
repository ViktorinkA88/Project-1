import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Class {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";
        int key = 4;
        try {
            System.out.println("Введите путь к файлу для шифровки/расшифровки:");
            File file = new File(scanner.nextLine());
            InputStreamReader fileInputStream = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            int i;
            while ((i = fileInputStream.read()) != -1) {
                text += (char) i;
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        while (true) {
            printMenu();
            int number = scanner.nextInt();
            if (number == 1) {
                Encryption(text, key);
            } else if (number == 2) {
                Decryption(text, key);
            } else if (number == 3) {
                System.out.println("Выход");
                break;
            } else System.out.println("Не верная команда, повторите еще");
        }
    }

    private static void Encryption(String text, int key) {
        char[] ch = text.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isLetter(text.charAt(i)) && Character.isUpperCase(text.charAt(i))) {
                ch[i] = (char) (ch[i] + key);
            } else if (Character.isLetter(text.charAt(i)) && Character.isLowerCase(text.charAt(i))) {
                ch[i] = (char) (ch[i] + key);
            } else {
                ch[i] = text.charAt(i);
            }
        }
        System.out.println(ch);
    }

    private static void Decryption(String encrypt, int key) {
        char[] ch = encrypt.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isLetter(encrypt.charAt(i)) && Character.isUpperCase(encrypt.charAt(i))) {
                ch[i] = (char) (ch[i] - key);
            } else if (Character.isLetter(encrypt.charAt(i)) && Character.isLowerCase(encrypt.charAt(i))) {
                ch[i] = (char) (ch[i] - key);
            }
        }
        System.out.println(ch);
    }

    private static void printMenu() {
        System.out.println("Введите команду:");
        System.out.println("1.Шифровка; \n" +
                "2.Расшифровка;\n" +
                "3.Выход.");
    }
}
