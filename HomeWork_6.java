import java.util.Random;
import java.util.Scanner;

/**
* JavaBasic. HomeWork #6
*
* @author Sergey Sanzarevskiy
* @todo 21.9.2022
* @date 22.9.2022
*
* @https://github.com/Sanser3/JavaBasic/blob/main/TicTacToe.java
*/

class HomeWork_6 {

    //task1
    static char [][] table = new char [3][3];
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        init();
        printTable();
        while(true) {
            turnHuman();
            if (isWin2('x')) {
                System.out.println("YOU WIN!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            turnAI();
            printTable();
            if (isWin2('o')) {
                System.out.println("YOU WIN!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
        printTable();
        System.out.println("GAME OVER");
        scanner.close();
    }

    static void init() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = '.';
            }
        }
    }

    static void printTable() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void turnHuman() {
        int x, y;
        do {
            System.out.print("Enter coordinates x and y [1..3]: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[y][x] = 'x';
    }

    static void turnAI() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        table[y][x] = 'o';
    }

    static boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x > 2 || y > 2) {
            return false;
        }
        return table[y][x] == '.';
    }

    static boolean isWin(char ch) {
        if (table[0][0] == ch && table[0][1] == ch && table[0][2] == ch) return true;
        if (table[1][0] == ch && table[1][1] == ch && table[1][2] == ch) return true;
        if (table[2][0] == ch && table[2][1] == ch && table[2][2] == ch) return true;

        if (table[0][0] == ch && table[1][0] == ch && table[2][0] == ch) return true;
        if (table[0][1] == ch && table[1][1] == ch && table[2][1] == ch) return true;
        if (table[0][2] == ch && table[1][2] == ch && table[2][2] == ch) return true;

        if (table[0][0] == ch && table[1][1] == ch && table[2][2] == ch) return true;
        if (table[0][2] == ch && table[1][1] == ch && table[2][0] == ch) return true;
        return false;
    }

    static boolean isTableFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    //task2
    static boolean isWin2(char ch) {
        for (int i = 0; i < 3; i++)
            if ((table[i][0] == ch && table[i][1] == ch && table[i][2] == ch) || (table[0][i] == ch && table[1][i] == ch && table[2][i] == ch)) return true;

        if (table[0][0] == ch && table[1][1] == ch && table[2][2] == ch) || (table[0][2] == ch && table[1][1] == ch && table[2][0] == ch) return true;
        return false;
    }

    //task3
    //https://github.com/Sanser3/JavaBasic/blob/main/TicTacToe.java
}