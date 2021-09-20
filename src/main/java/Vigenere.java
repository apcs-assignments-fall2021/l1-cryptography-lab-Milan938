import java.util.Scanner;

public class Vigenere {
    public static char encryptCaesarLetter(char ch, int key) {
        key = key % 26;
        char mes = ch;
        char Akey = (char) ('A' + key);
        char akey = (char) ('a' + key);
        if (mes >= Akey && mes <= 'Z') {
            mes = (char) (mes - key);
        }
        else if (mes >= akey && mes <= 'z') {
            mes = (char) (mes - key);
        }
        else if (mes >= 'A' && mes <= 'A' + key) {
            mes = (char) (mes + (26 - key));
        }
        else {
        }
        return mes;
    }

    public static char decryptCaesarLetter(char ch, int key) {
        key = key % 26;
        char mes = ch;
        char Akey = (char) ('A' + key);
        char akey = (char) ('a' + key);
        if (mes >= Akey && mes <= 'Z') {
            mes = (char) (mes - key);
        }
        else if (mes >= akey && mes <= 'z') {
            mes = (char) (mes - key);
        }
        else if (mes >= 'A' && mes <= 'A' + key) {
            mes = (char) (mes + (26 - key));
        }
        else {
        }
        return mes;
    }


    public static String encryptVigenere(String message, String key) {
        String enc_mes = "";
        int keyindex = 0;
        for (int i = 0; i < message.length(); i++) {
            char sassy = message.charAt(i);
            char letter = key.charAt(keyindex);
            int shift = letter - 'A';
            keyindex += 1;
            enc_mes += encryptCaesarLetter(sassy, shift);
            if (keyindex == key.length()) {
                keyindex = 0;
            }
        }
        return enc_mes;
    }

    public static String decryptVigenere(String message, String key) {
        String enc_mes = "";
        int keyindex = 0;
        for (int i = 0; i < message.length(); i++) {
            char sassy = message.charAt(i);
            char letter = key.charAt(keyindex);
            int shift = letter - 'A';
            keyindex += 1;
            enc_mes += decryptCaesarLetter(sassy, shift);
            if (keyindex == key.length()) {
                keyindex = 0;
            }
        }
        return enc_mes;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
