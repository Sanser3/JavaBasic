import java.util.Random;
import java.util.Scanner;

/**
* JavaBasic. HomeWork #4
*
* @author Sergey Sanzarevskiy
* @todo 14.9.2022
* @date 18.9.2022
*
*/

class HomeWork_4 {
    public static void main(String[] args) {

        //task1
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        int guess = -1;
        do {
            number = random.nextInt(10);
            for (int i = 0; i < 3; i++) {
                System.out.print("Guess the number (0..9): ");
                guess = scanner.nextInt();
                if (guess < number) {
                    System.out.println("Your number is less");
                } else if (guess > number) {
                    System.out.println("Your number is bigger");
                } else {
                    System.out.println("You guess my number.\nYou WIN !!!");
                    break;
                }
            }
            if (number != guess) {
                System.out.println("You Lose.");
                System.out.println("The number given was: " + number);
            }
            System.out.println("Repeat game? Yes - 1, No - 0: ");
        } while (scanner.nextInt() == 1);

        //task2
        Scanner scann = new Scanner(System.in);
        do {
            number = random.nextInt(10);
            for (int i = 0; i < 3; i++) {
                System.out.print("Guess the number (0..9): ");
                guess = scanner.nextInt();
                if (guess < number) {
                    System.out.println("Your number is less");
                } else if (guess > number) {
                    System.out.println("Your number is bigger");
                } else {
                    System.out.println("You guess my number.\nYou WIN !!!");
                    break;
                }
            }
            if (number != guess) {
                System.out.println("You Lose.");
                System.out.println("The number given was: " + number);
            }
            System.out.println("Repeat game?:  Y/N: ");
        } while (scann.nextLine().equals("Y"));

        //task3
        Scanner sc = new Scanner(System.in);
        Scanner sca = new Scanner(System.in);
        String[] array1 = {"rock", "scissors", "paper"};
        int computer = -1;
        int player = -1;
        int computerO = 0;
        int playerO = 0;
        do {
            System.out.println("The game continues until 3 wins");
            do {
                number = random.nextInt(3);
                System.out.println("Enter what you thought: rock (R), scissors (S), paper (P)");
                switch (sca.nextLine()){
                    case "R":
                        player = 0;
                        break;
                    case "S":
                        player = 1;
                        break;
                    case "P":
                        player = 2;
                        break;
                    default:
                        System.out.println("Enter only: rock (R), scissors (S), paper (P)");
                        continue;
                }
                System.out.println("The computer guessed: " + array1[number]);
                if (number == player) {
                    System.out.println("Dead heat");
                } else if ((number == 0 && player == 2 )||(number == 1 && player == 0)||(number == 2 && player == 1)) {
                    System.out.println("Player won this round");
                    playerO++;
                } else {
                    System.out.println("Computer won this round");
                    computerO++;
                }
                System.out.printf("Player - Computer: %d - %d\n", playerO, computerO);
            } while (computerO != 3 && playerO != 3);
            if (computerO == 3) {
                System.out.println("Computer WIN");
            } else {
                System.out.println("Player WIN");
            }
            System.out.println("Repeat game?:  Y/N: ");
        } while (sc.nextLine().equals("Y"));
    }
}