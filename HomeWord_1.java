/**
* Java Basic. Home work #1
*
* @author Sergey Sanzarevskiy
* @version 6.9.2022
*
*/
class HomeWord_1 {
    public static void main(String[] args) {
        int var1 = (int) (Math.random() * 10 + 1);
        int var2 = (int) (Math.random() * 10 + 1);
        System.out.println("Random number 1 = " + var1);
        System.out.println("Random number 2 = " + var2);
        System.out.println("Perimeter = " + (var1 + var2) * 2);
        System.out.println("Square = " + var1 * var2);
        System.out.println();
        
        int var3 = 5;
        int var4 = 3;
        System.out.println(var3 + var4);
        System.out.println(var3 - var4);
        System.out.println(var3 * var4);
        System.out.println(var3 / var4);
        System.out.println();
        
        int[] array1 = new int[5];
        array1[0] = (int) (Math.random() * 10);
        array1[1] = (int) (Math.random() * 10);
        array1[2] = (int) (Math.random() * 10);
        array1[3] = (int) (Math.random() * 10);
        array1[4] = (int) (Math.random() * 10);
        System.out.println(array1[0]);
        System.out.println(array1[1]);
        System.out.println(array1[2]);
        System.out.println(array1[3]);
        System.out.println(array1[4]);
        System.out.println();
        
        int var5 =(int) (Math.random() * 10 + 5);
        System.out.println("Pizza diameter = " + var5 + " cm");
        double var6 = (Math.PI * (var5 / 2f) * 0.5) * 40;
        System.out.println("Calorie content of pizza = " + var6 + " call");
    }
}