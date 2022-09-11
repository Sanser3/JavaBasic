/**
* Java Basic. Home work #2
*
* @author Sergey Sanzarevskiy
* @todo 10.9.2022
* @date 7.9.2022
* @changes 11.9.2022
*
*/

class HomeWord_2 {
    public static void main(String[] args) {
        //task1
        System.out.println(checkWeather(-5));
        System.out.println(checkWeather(0));
        System.out.println(checkWeather(19));
        System.out.println(checkWeather(29));
        System.out.println();

        //task2
        System.out.println(canWalk(true, true));
        System.out.println(canWalk(true, false));
        System.out.println(canWalk(false, true));
        System.out.println(canWalk(false, false));
        System.out.println();

        //task3
        int a = 12;
        int b = 0;
        System.out.printf("%d + %d = %d\n", a, b, arithmeticA(a, b));
        System.out.printf("%d - %d = %d\n", a, b, arithmeticB(a, b));
        System.out.printf("%d * %d = %d\n", a, b, arithmeticC(a, b));
        if (b != 0) {
            System.out.printf("%d / %d = %.2f\n", a, b, arithmeticD(a, b));
        } else {
            System.out.println("Can't divide by zero");
        }
        System.out.println();

        //task4
        System.out.println(dayOfWeek(1));
        System.out.println(dayOfWeek(2));
        System.out.println(dayOfWeek(3));
        System.out.println(dayOfWeek(4));
        System.out.println(dayOfWeek(5));
        System.out.println(dayOfWeek(6));
        System.out.println(dayOfWeek(7));
        System.out.println(dayOfWeek(8));
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
        static String checkWeather(int temperature) {
            if (temperature < 0) {
                return "It's frost";
            } else if (temperature <= 18) {
                return "It's cold";
            } else if (temperature <= 28) {
                return "It's warm";
            } else {
                return "It's hot";
            }
        }

        // task2
        static String canWalk(boolean isWeekend ,boolean isRain) {
            if (isWeekend && isRain ) {
                return "You can walk";
            } else {
                return "You can't walk";
            }
        }

        // task3
        static int arithmeticA(int a, int b) {
            return (int) a + b;
        }
        static int arithmeticB(int a, int b) {
            return a - b;
        }
        static int arithmeticC(int a, int b) {
            return a * b;
        }
        static float arithmeticD(int a, int b) {
            return a / b;
        }

        //task4
        static String dayOfWeek(int args) {
            switch (args) {
                case 1:
                    return "Monday";
                case 2:
                    return "Tuesday";
                case 3:
                    return "Wednesday";
                case 4:
                    return "Thursday";
                case 5:
                    return "Friday";
                case 6:
                    return "Saturday";
                case 7 :
                    return "Sunday";
                default:
                    return "There is no such day";
                }
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
            } else if (discriminant == 0) {
                System.out.println("x = " + (double)(-b) / (2 * a));
            } else {
                System.out.println("x1 = " + (double)((-b) + Math.sqrt(discriminant)) / (2 * a));
                System.out.println("x2 = " + (double)((-b) - Math.sqrt(discriminant)) / (2 * a));
            }
        }
}