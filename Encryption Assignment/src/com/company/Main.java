package com.company;
import java.util.Scanner;

/*
 * Encryption Algorithim
 * Every lowercase letter becomes uppercase
 * Every uppercase letter becomes lowercase
 * Every charecter is shifted up by <randomShift>
 * If result is non-printable, shift loops back to lower ascii values
 * Adds LI. to the start
 * Adds shifter to the end
 */

public class Main {
    public static void main(String[] args) {

        // loop
        while(true) {

            // init
            Scanner input = new Scanner(System.in);
            System.out.println("*".repeat(30));

            // get input
            System.out.println("Write something to decrypt or insert and encrypted string: ('exit' to exit)");
            String userInput = input.nextLine();

            // exit
            if (userInput.equals("exit")) break;

            // decrypt
            if (userInput.startsWith("LI.")) {

                // extract string
                String toDecrypt = userInput.substring(3, userInput.length() - 1);

                // extract shifter
                int shifter = Integer.parseInt(userInput.substring(userInput.length() - 1));

                // result of decryption
                String decrypted = "";

                for (int i = 0; i < toDecrypt.length(); i++) {

                    // ascii code of letter
                    int letterCode = (int)(toDecrypt.charAt(i));

                    // shift down
                    letterCode -= shifter;

                    // correct wrapping
                    // 127 - 32 = 95 printable chars
                    // shift 32 down and 95 up to avoid negative
                    // mod to unwrap
                    // shift 32 up
                    letterCode = ((letterCode - 32 + 95) % 95 + 32);

                    // code for new char
                    int newCode = 0;

                    // flip capitalization
                    if (letterCode >= 97 && letterCode <= 122) {
                        newCode = letterCode - 32;
                    } else if (letterCode >= 65 && letterCode <= 90) {
                        newCode = letterCode + 32;
                    } else {
                        newCode = letterCode;
                    }

                    // Add char to decrypted
                    decrypted += (char) (newCode);
                }

                // print out decrypted text
                System.out.println("Here is your \"decrypted\" text:");
                System.out.println(decrypted);


            } else { //encrypt

                // encrypted string
                // must start with LI.
                String encrypted = "LI.";

                // random shifter
                // random num between 1 to 9
                int randomShift = (int)(Math.random() * 10);

                // loop over input
                for (int i = 0; i < userInput.length(); i++) {

                    // ascii code of char
                    int letterCode = (int) (userInput.charAt(i));
                    int newCode = 0;

                    // flip captialization
                    if (letterCode >= 97 && letterCode <= 122) {
                        newCode = letterCode - 32;
                    } else if (letterCode >= 65 && letterCode <= 90) {
                        newCode = letterCode + 32;
                    } else {
                        newCode = letterCode;
                    }

                    // shift
                    newCode += randomShift;
                    // wrapping
                    // 127 - 32 = 95 printable chars
                    // shift 32 down
                    // mod to wrap
                    // shift 32 up
                    newCode = (newCode - 32) % 95 + 32;

                    // add to encrypted string
                    encrypted += (char) (newCode);
                }

                // Add shift to end of string so that we can decrypt
                encrypted += randomShift;

                // output
                System.out.println("Here is your \"encrypted\" text:");
                System.out.println(encrypted);
            }
        }
    }
}
