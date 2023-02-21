import java.util.ArrayList;
import java.util.List;

abstract class Animal {

}

class Wolf extends Animal {
    private String name; 
    public Wolf(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

interface AnimalCage {
    void addAnimal(Animal animal);

    void removeAnimal(Animal animal);

    Animal getFirstAnimal();
}

class WolfCage implements AnimalCage {
    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public Animal getFirstAnimal() {
        if (animals.size() == 0) {
            return null;
        }
        return animals.get(0);
    }
}

public class Program {

    public static void main(String args[]) {
        Wolf wolf = new Wolf("Серый волк");

        WolfCage wolfCage = new WolfCage();

        wolfCage.addAnimal(wolf);

        Animal animal = wolfCage.getFirstAnimal();
        if (animal instanceof Wolf) {
            Wolf wolfFromCage = (Wolf) animal;
            System.out.println("Получен волк: " + wolfFromCage.getName());
        }

        wolfCage.removeAnimal(wolf);
    }
}