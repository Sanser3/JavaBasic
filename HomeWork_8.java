
/**
 * JavaBasic. HomeWork #8
 *
 * @author Sergey Sanzharevskiy
 * @todo 28.9.2022
 * @date 02.10.2022
 *
 */

public class HomeWork_8 {
    public static void main(String[] args) {
        //task1
        System.out.println("\n//task1");
        Cat cat = new Cat ("Barsic", "red", 2);
        System.out.println(cat);
        System.out.println(cat.voice());

        //task2
        System.out.println("\n//task2");
        Car car = new Car ("BMW", "red", 3);
        System.out.println(car);
        System.out.println("Try to go: " + car.go());
        car.ignition();
        System.out.println("Try to go: " + car.go());
        car.brake();
        System.out.println("Try to go: " + car.go());
        car.clutch();
        System.out.println("Try to go: " + car.go());
        car.gas();
        System.out.println("Try to go: " + car.go());

    }
}