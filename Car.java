public class Car {
    String color;
    String brand;
    int age;
    boolean ignition;
    boolean clutch;
    boolean gas;
    boolean brake;

    public Car(String brand, String color, int age) {
        this.brand = brand;
        this.color = color;
        this.age = age;
        this.ignition = false;
        this.brake = true;
        this.clutch = true;
        this.gas = false;
    }

    public void ignition() {
        ignition = true;
    }

    public void brake() {
        brake = false;
    }

    public void clutch() {
        clutch = false;
    }

    public void gas() {
        gas = true;
    }
    public String go() {
        if (ignition && !clutch && gas && !brake) {
            ignition = false;
            brake = true;
            clutch = true;
            gas = false;
            return "Hooray we went, it all worked out. :)";
        } else {
            return "We can't go!\n" + check();
        }
    }
    public String check() {
        String check = null;
        if (ignition) {
            if (brake) {
                check = "You have to release the brake to drive!!!";
            } else if (clutch) {
                check = "The clutch must be released to drive!!!";
            } else if (!gas){
                check = "You have to step on the throttle to drive!!!";
            }
        } else {
            check = "You have to switch on the ignition to drive!!!";
        }
        return check;
    }

    public String toString() {
        return "Car: " + brand + ", color: " + color + ", age: " + age;
    }
}
