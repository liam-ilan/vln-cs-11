package com.company;
import java.util.Scanner;

/*
* Simple Rock Paper Scissors game allowing one game per run.
* Ask user for input using single letters: 'r', 'p', 's'.
* Validate user input. Any other than above will output error.
* Generate random choice for bot.
* Play user against bot.
* Output result.
* Exit.
*/

public class Main {

    public static void main(String[] args) {

        // init
        Scanner input = new Scanner(System.in);
        String[] choices = {"rock", "paper", "scissors"};

        // user input
        System.out.println("Choose rock paper or scissors.\t'r' for rock, 'p' for paper and 's' for scissors.");
        String user = input.nextLine(); // nextLine catches spaces

        // validate
        if (!(user.equals("r") || user.equals("p") || user.equals("s"))) {
            System.out.println("Invalid selection please play again.");
            return;
        }

        // map user input to game choices
        // note: code easier to read when strings are used, instead of array reference
        if (user.equals("r")) {
            user = "rock";
        } else if (user.equals("p")) {
            user = "paper";
        } else {
            user = "scissors";
        }

        // bot input
        String bot = choices[(int)(Math.random() * 3)];

        // play
        // note: code easier to read when strings are used, instead of array reference
        Boolean winningCondition =
                user.equals("paper") && bot.equals("rock") ||
                user.equals("scissors") && bot.equals("paper") ||
                user.equals("rock") && bot.equals("scissors");

        if (user.equals(bot)) {
            System.out.println("Draw!");
        } else if (winningCondition) {
            System.out.println("You Win!");
        } else {
            System.out.println("You Lose!");
        }

        System.out.println("Computer choice: " + bot + "\tPlayer choice: " + user);
    }
}
