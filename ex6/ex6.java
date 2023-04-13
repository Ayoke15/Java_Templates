package ex6;
import java.util.HashMap;
import java.util.Map;
interface Animal {
    void speak();
}

class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}
class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}

abstract class AnimalFactory {
    public abstract Animal createAnimal();
}

class DogFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}

class FactoryMethodExample {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        AnimalFactory catFactory = new CatFactory();

        Animal dog = dogFactory.createAnimal();
        Animal cat = catFactory.createAnimal();

        dog.speak();
        cat.speak();
    }
}

interface Chair {
    void sitOn();
}

class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a modern chair.");
    }
}

class VintageChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a vintage chair.");
    }
}

interface Table {
    void use();
}

class ModernTable implements Table {
    @Override
    public void use() {
        System.out.println("Using a modern table.");
    }
}

class VintageTable implements Table {
    @Override
    public void use() {
        System.out.println("Using a vintage table.");
    }
}

interface FurnitureFactory {
    Chair createChair();
    Table createTable();
}

class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }
}

class VintageFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VintageChair();
    }

    @Override
    public Table createTable() {
        return new VintageTable();
    }
}

class AbstractFactoryExample {
    public static void main(String[] args) {
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        FurnitureFactory vintageFactory = new VintageFurnitureFactory();

        Chair modernChair = modernFactory.createChair();
        Table modernTable = modernFactory.createTable();

        modernChair.sitOn();
        modernTable.use();

        Chair vintageChair = vintageFactory.createChair();
        Table vintageTable = vintageFactory.createTable();

        vintageChair.sitOn();
        vintageTable.use();
    }
}
class Computer {
    private String cpu;
    private int ram;
    private int storage;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }
}

interface ComputerBuilder {
    ComputerBuilder setCpu(String cpu);
    ComputerBuilder setRam(int ram);
    ComputerBuilder setStorage(int storage);
    Computer build();
}

class BasicComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public BasicComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public ComputerBuilder setCpu(String cpu) {
        computer.setCpu(cpu);
        return this;
    }

    @Override
    public ComputerBuilder setRam(int ram) {
        computer.setRam(ram);
        return this;
    }

    @Override
    public ComputerBuilder setStorage(int storage) {
        computer.setStorage(storage);
        return this;
    }

    @Override
    public Computer build() {
        return computer;
    }
}

class AdvancedComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public AdvancedComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public ComputerBuilder setCpu(String cpu) {
        computer.setCpu(cpu);
        return this;
    }

    @Override
    public ComputerBuilder setRam(int ram) {
        computer.setRam(ram);
        return this;
    }

    @Override
    public ComputerBuilder setStorage(int storage) {
        computer.setStorage(storage * 2);
        return this;
    }

    @Override
    public Computer build() {
        return computer;
    }
}

class BuilderExample {
    public static void main(String[] args) {
        ComputerBuilder basicBuilder = new BasicComputerBuilder();
        basicBuilder.setCpu("Intel Core i3")
                .setRam(8)
                .setStorage(256);

        Computer basicComputer = basicBuilder.build();
        System.out.println(basicComputer.getCpu());
        System.out.println(basicComputer.getRam());
        System.out.println(basicComputer.getStorage());

        ComputerBuilder advancedBuilder = new AdvancedComputerBuilder();
        advancedBuilder.setCpu("Intel Core i7")
                .setRam(16)
                .setStorage(512);

        Computer advancedComputer = advancedBuilder.build();
        System.out.println(advancedComputer.getCpu());
        System.out.println(advancedComputer.getRam());
        System.out.println(advancedComputer.getStorage());
    }
}


// Интерфейс Prototype, который будет реализован всеми прототипами
interface Prototype {
    Prototype clone();
}

// Конкретный прототип - класс Car
class Car implements Prototype {
    private String model;
    private String color;
    private int year;

    public Car(String model, String color, int year) {
        this.model = model;
        this.color = color;
        this.year = year;
    }

    @Override
    public Car clone() {
        return new Car(model, color, year);
    }

    @Override
    public String toString() {
        return "Car [model=" + model + ", color=" + color + ", year=" + year + "]";
    }
}

// Класс PrototypeRegistry для управления прототипами
class PrototypeRegistry {
    private Map<String, Prototype> prototypes = new HashMap<>();

    public void addPrototype(String key, Prototype prototype) {
        prototypes.put(key, prototype);
    }

    public Prototype getPrototype(String key) {
        Prototype prototype = prototypes.get(key);
        return (prototype != null) ? prototype.clone() : null;
    }
}

class PrototypePatternDemo {
    public static void main(String[] args) {
        PrototypeRegistry registry = new PrototypeRegistry();

        Car car1 = new Car("Tesla", "Red", 2021);
        registry.addPrototype("car1", car1);

        Car car2 = (Car) registry.getPrototype("car1");
        System.out.println(car1);
        System.out.println(car2);

        Car car3 = new Car("BMW", "Blue", 2020);
        registry.addPrototype("car2", car3);
        Car car4 = (Car) registry.getPrototype("car2");
        System.out.println(car3);
        System.out.println(car4);

        Car car5 = (Car) registry.getPrototype("nonexistent");
        System.out.println(car5);
    }
}
