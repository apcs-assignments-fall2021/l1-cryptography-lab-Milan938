import java.util.Scanner;

public class Caesar {
    // Given a String, encrypts the String with the Caesar cipher
    // and returns the encrypted String
    // Ex. encryptCaesar("Hello, World!") => "Khoor, Zruog!"
    public static String encryptCaesar(String message) {
        String none = "";
        for (int i = 0; i < message.length(); i++) {
            char mes = message.charAt(i);
            if (mes >= 'A' && mes <= 'W') {
                mes = (char) (mes + 3);
                none = none + mes;
            }
            else if (mes >= 'a' && mes <= 'w') {
                mes = (char) (mes + 3);
                none = none + mes;
            }
            else if (mes == 'X') {
                none = none + "A";
            }
            else if (mes == 'Y') {
                none = none + "B";
            }
            else if (mes == 'Z') {
                none = none + "C";
            }
            else if (mes == 'x') {
                none = none + "a";
            }
            else if (mes == 'y') {
                none = none + "b";
            }
            else if (mes == 'z') {
                none = none + "c";
            }
            else {
                none = none + mes;
            }
        }
        return none;
    }

    // Given a String, decrypts the String with the Caesar cipher
    // and returns the original String
    // Ex. decryptCaesar("Khoor, Zruog!") => "Hello, World!"
    public static String decryptCaesar(String message) {
        String none = "";
        for (int i = 0; i < message.length(); i++) {
            char mes = message.charAt(i);
            if (mes >= 'D' && mes <= 'Z') {
                mes = (char) (mes - 3);
                none = none + mes;
            }
            else if (mes >= 'd' && mes <= 'z') {
                mes = (char) (mes - 3);
                none = none + mes;
            }
            else if (mes == 'A') {
                none = none + "X";
            }
            else if (mes == 'B') {
                none = none + "Y";
            }
            else if (mes == 'C') {
                none = none + "Z";
            }
            else if (mes == 'a') {
                none = none + "x";
            }
            else if (mes == 'b') {
                none = none + "y";
            }
            else if (mes == 'c') {
                none = none + "z";
            }
            else {
                none = none + mes;
            }
        }
        return none;
    }

    // Given a String and a key corresponding to a shift, encrypts
    // the String using the given key and returns the encrypted String
    // Ex. encryptCaesarKey("Hello, World!", 5) => "Mjqqt, Btwqi!".
    public static String encryptCaesarKey(String message, int key) {
        String enc_mes = "";
        key = key % 26;
        for (int i = 0; i < message.length(); i++) {
            char mes = message.charAt(i);
            char Zkey = (char) ('Z' - key);
            char zkey = (char) ('z' - key);
            if (mes >= 'A' && mes <= Zkey) {
                mes = (char) (mes + key);
                enc_mes += mes;
            }
            else if (mes >= 'a' && mes <= zkey) {
                mes = (char) (mes + key);
                enc_mes += mes;
            }
            else if (mes == 'Z' - key) {
                return "A";
            }
            else if (mes >='Z' - key && mes <= 'Z' - key) {
                mes = (char) (mes + key);
                enc_mes += mes;
            }
            else {
                enc_mes += mes;
            }
        }
        return enc_mes;
    }

    // Given a String and a key corresponding to a shift, decrypts
    // the String using the given key and returns the original String
    // Ex. decryptCaesarKey("Mjqqt, Btwqi!", 5) => "Hello, World!"
    public static String decryptCaesarKey(String message, int key) {
        String enc_mes = "";
        key = key % 26;
        for (int i = 0; i < message.length(); i++) {
            char mes = message.charAt(i);
            char Akey = (char) ('A' + key);
            char akey = (char) ('a' + key);
            if (mes >= Akey && mes <= 'Z') {
                mes = (char) (mes + key);
                enc_mes += mes;
            }
            else if (mes >= akey && mes <= 'z') {
                mes = (char) (mes + key);
                enc_mes += mes;
            }
        }
        return enc_mes;
    }


    // The main method is already provided for you
    // You do not need to edit this code until Part 2
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else if (command.equals("encryptCaesar")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("What key would you like to use?: ");
            int key = scan.nextInt();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesarKey(message, key));
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
