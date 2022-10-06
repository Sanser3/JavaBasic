/**
 * JavaBasic. HomeWork #9
 *
 * @author Sergey Sanzharevskiy
 * @todo 05.10.2022
 * @date 06.10.2022
 *
 */
public class HomeWork_9 {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", "red", 2);
        Dog dog = new Dog("Polkan", "black", 5);
        IAnimal[] animals = {cat, dog};

        for (IAnimal animal : animals) {
            System.out.println(animal);
            System.out.println(animal.voice());
        }
    }
}
