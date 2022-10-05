public class Cat extends Animal implements IAnimal {
    public Cat(String name, String color, int age) {
        super(name, color, age);
    }

    public String voice() {
        return "meow";
    }
}
