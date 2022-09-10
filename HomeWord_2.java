/**
* Java Basic. Home work #2
*
* @author Sergey Sanzarevskiy
* @todo 10.9.2022
* @date 7.9.2022
*
*/

class HomeWord_2 {
    public static void main(String[] args) {
        //task1
        checkWeather(-5);
        checkWeather(0);
        checkWeather(19);
        checkWeather(29);
        System.out.println();

        //task2
        System.out.println(canWalk(true, true));
        System.out.println(canWalk(true, false));
        System.out.println(canWalk(false, true));
        System.out.println(canWalk(false, false));
        System.out.println();

        //task3
        System.out.println("12 + 3 = " + arithmeticA(12, 3));
        System.out.println("12 - 3 = " + arithmeticB(12, 3));
        System.out.println("12 * 3 = " + arithmeticC(12, 3));
        System.out.println("12 / 3 = " + arithmeticD(12, 3));
        System.out.println();

        //task4
        dayOfWeek(1);
        dayOfWeek(2);
        dayOfWeek(3);
        dayOfWeek(4);
        dayOfWeek(5);
        dayOfWeek(6);
        dayOfWeek(7);
        dayOfWeek(8);
        System.out.println();

        //task5
        canBuyFood(true, true);
        canBuyFood(true, false);
        canBuyFood(false, true);
        canBuyFood(false, false);
        System.out.println();

        //task6
/**
* 3x2 — 4x + 94 = 0
* корней нет

* −4x2 + 28x — 49 = 0
* x = 3.5

* x2 + 4x + 3 = 0
* x1 = -4 + 2 / 2 = -1
* x2 = -4 - 2 / 2 = -3
*/
        quadraticEquation(3, 4, 94);
        quadraticEquation(-4, 28, -49);
        quadraticEquation(1, 4, 3);
    }

        // task1
        static void checkWeather(int temperature) {
            if (temperature < 0) {
                System.out.println("It's frost");
            } else if (0 <= temperature && temperature <= 18) {
                System.out.println("It's cold");
            } else if (19 <= temperature && temperature <= 28) {
                System.out.println("It's warm");
            } else if (29 <= temperature)
                System.out.println("It's hot");
        }

        // task2
        static boolean canWalk(boolean isWeekend ,boolean isRain) {
            if (isWeekend == true && isRain == true) {
                return true;
            } else {
                return false;
            }
        }

        // task3
        static int arithmeticA(int a, int b) {
            return a + b;
        } static int arithmeticB(int a, int b) {
            return a - b;
        } static int arithmeticC(int a, int b) {
            return a * b;
        } static double arithmeticD(int a, int b) {
            return a / b;
        }

        //task4
        static int dayOfWeek(int args) {
            switch (args) {
                case 1:
                    System.out.println("Monday");
                    break;
                case 2:
                    System.out.println("Tuesday");
                    break;
                case 3:
                    System.out.println("Wednesday");
                    break;
                case 4:
                    System.out.println("Thursday");
                    break;
                case 5:
                    System.out.println("Friday");
                    break;
                case 6:
                    System.out.println("Saturday");
                    break;
                case 7 :
                    System.out.println("Sunday");
                    break;
                default:
                    System.out.println("There is no such day");
                }
            return args;
            }

        //task5
        static boolean canBuyFood(boolean isLidlOpen, boolean isTescoOpen) {
            if (isLidlOpen == true && isTescoOpen == true) {
                System.out.println("I can buy food in Lidl end Tesco");
                return true;
            } else if (isLidlOpen == true ) {
                System.out.println("I can buy food in Lidl");
                return true;
            } else if (isTescoOpen == true) {
                System.out.println("I can buy food in Tesco");
                return true;
            } else {
                System.out.println("I can’t buy food");
                return false;
            }
        }

        //task6
        static void quadraticEquation(double a, double b, double c) {
            double discriminant = b * b - 4 * a * c;
            if (discriminant < 0) {
                System.out.println("No root");
            } else if ((int)discriminant < 2) {
                System.out.println("x = " + (double)(-b) / (2 * a));
            } else {
                System.out.println("x1 = " + (double)((-b) + Math.sqrt(discriminant)) / (2 * a));
                System.out.println("x2 = " + (double)((-b) - Math.sqrt(discriminant)) / (2 * a));
            }
        }
}