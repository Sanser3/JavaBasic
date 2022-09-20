import java.util.Random;
import java.util.Scanner;

/**
* JavaBasic. HomeWork #5
*
* @author Sergey Sanzarevskiy
* @todo 19.9.2022
* @date 20.9.2022
*
*/

class HomeWork_5 {
    public static void main(String[] args) {

        //task1
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String [] words = {"door", "week", "beer", "food", "tree"};
        String word = words[random.nextInt(words.length)];
        char[] mask = {'*', '*', '*', '*'};
        int counter = 0;
        int letterCounter = 0;
        do {
            counter++;
            System.out.print("Guess the word: < " + new String(mask) + " >: ");
            char letter = scanner.next().charAt(0);
            for (int i = 0; i < word.length(); i++) {
                if (letter == word.charAt(i) && mask[i] == '*') {
                    mask[i] = letter;
                    letterCounter++;
                }
            }
        } while (letterCounter < word.length());
        System.out.println("You guess the word < " + word + " >, attenpts: " + counter);
        System.out.println();

        //task2
        int otvet;
        String[] frage = {"Who ate the Kolobok?",
                          "What is Pinocchio from?",
                          "Who broke Teremok?",
                          "Who did Grandpa and Grandma make out of the snow in winter?",
                          "Who helped the lazy Emely the Fool?"};
        String[][] antwort = {{"Wolf", "Fox", "Grandfather", "Grandmother"},
                              {"Iron", "Plastic", "Glass", "Wood"},
                              {"Rooster", "Bear", "Owl", "Hippo"},
                              {"Father Christmas", "The Snowman", "The Snow Maiden", "The Ice Fortress"},
                              {"Pike", "Sheep", "Giraffe", "Cat"}};
        int[] key = {2, 4, 2, 3, 1};
        System.out.println("Guess the riddle game");
        for (int j = 0; j < frage.length; j++) {
            System.out.print((j + 1) + "-th question:");
            System.out.println(frage[j]);
            System.out.println("Answer options:");
            for (int i = 0; i < 4; i++) {
                System.out.println((i+1) + " - " + antwort[j][i]);
            }
            System.out.println("What is your answer? Enter a number.");
            otvet = scanner.nextInt();
            if (otvet == key[j]) {
                System.out.println("The answer is correct.\n");
            } else {
                System.out.println("The answer is not correct\nGame over");
                break ;
            }
        }
        System.out.println("You win.");
        scanner.close();
	}
}