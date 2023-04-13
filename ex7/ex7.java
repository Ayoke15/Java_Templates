package ex7;

import java.util.ArrayList;
import java.util.List;
// Абстракция
abstract class Abstraction {
    protected Implementation implementation;

    public Abstraction(Implementation implementation) {
        this.implementation = implementation;
    }

    public abstract void operation();
}

// Реализация
interface Implementation {
    void operationImpl();
}

// Конкретная абстракция
class ConcreteAbstraction extends Abstraction {

    public ConcreteAbstraction(Implementation implementation) {
        super(implementation);
    }

    @Override
    public void operation() {
        implementation.operationImpl();
    }
}

// Конкретная реализация
class ConcreteImplementationA implements Implementation {
    @Override
    public void operationImpl() {
        System.out.println("ConcreteImplementationA");
    }
}

class ConcreteImplementationB implements Implementation {
    @Override
    public void operationImpl() {
        System.out.println("ConcreteImplementationB");
    }
}

// Компонент
interface Component {
    void operation();
}

// Лист
class Leaf implements Component {
    @Override
    public void operation() {
        System.out.println("Leaf");
    }
}

// Композит
class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite");
        for (Component component : components) {
            component.operation();
        }
    }
}
public class ex7 {
    public static void main(String[] args) {
        // Bridge
        Implementation implA = new ConcreteImplementationA();
        Abstraction abstractionA = new ConcreteAbstraction(implA);
        abstractionA.operation();

        Implementation implB = new ConcreteImplementationB();
        Abstraction abstractionB = new ConcreteAbstraction(implB);
        abstractionB.operation();

        // Composite
        Composite composite = new Composite();
        composite.addComponent(new Leaf());
        composite.addComponent(new Leaf());

        Composite innerComposite = new Composite();
        innerComposite.addComponent(new Leaf());
        innerComposite.addComponent(new Leaf());

        composite.addComponent(innerComposite);
        composite.operation();
    }
}
