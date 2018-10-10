package pack2;
import  pack1.*;

public class AnimalTest {
    public static void main(String[] args) {
        Elephant elephant = new Elephant();
        Lion     lion     = new Lion();
        Zebra    zebra    = new Zebra();
        Animal   animal;

        animal = elephant;
        animal.eat();
        animal.run();

        animal = lion;
        animal.eat();
        animal.run();

        animal = zebra;
        animal.eat();
        animal.run();

    }
}
