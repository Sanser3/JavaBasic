public class Cat {
    String name;
    String color;
    int age;

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String voice() {
        return name + ": meow!";
    }

    public String toString() {
        return "Cat: " + name + ", color: " + color + ", age: " + age;
    }
}
