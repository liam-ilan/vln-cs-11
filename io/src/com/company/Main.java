package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // reads a file
    static String readFile(String name) throws IOException {
        String res = "";

        // create file stream
        FileInputStream in = new FileInputStream(name);

        // current letter in loop
        char letter;

        // write to res for each char is stream
        while((letter = (char) in.read()) != (char) -1){
            res += letter;
        }

        return res;
    }

    // converts string to arrayList by cutting on new lines
    static ArrayList<String> stringToList(String input) {
        ArrayList<String> res = new ArrayList<String>();

        // line the reader is currently looking at
        String currentLine = "";

        // for each letter
        for (char letter : input.toCharArray()) {

            // if new line, add to res and reset currentLine
            if (letter == '\n') {
                res.add(currentLine);
                currentLine = "";
            }
            else currentLine += letter;
        }

        // add last line
        res.add(currentLine);

        return res;
    }

    static ArrayList<Integer> findWordInArrayList (String word, ArrayList<String> inputList) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < inputList.size(); i += 1) {
            if (inputList.get(i).contains(word)) {
                res.add(i);
            }
         }

        return res;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a file to search in:");
        String inputFile = scanner.next();

        System.out.println("Please enter a word to search for:");
        String inputWord = scanner.next();

        String input = readFile(inputFile);
        ArrayList<String> listOfStrings = stringToList(input);

        System.out.println("The following lines (starting at 0) contain the word you asked for:");
        System.out.println(findWordInArrayList(inputWord, listOfStrings));
    }
}
