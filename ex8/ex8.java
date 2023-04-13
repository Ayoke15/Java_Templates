package ex8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
// Интерфейс команды
 interface Command {
    void execute();
}

// Конкретная команда A
class ConcreteCommandA implements Command {
    private Receiver receiver;

    public ConcreteCommandA(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.actionA();
    }
}

// Конкретная команда B
 class ConcreteCommandB implements Command {
    private Receiver receiver;

    public ConcreteCommandB(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.actionB();
    }
}

// Получатель команды
 class Receiver {
    public void actionA() {
        System.out.println("Выполнение действия A");
    }

    public void actionB() {
        System.out.println("Выполнение действия B");
    }
}

// Инвокер
class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

// Клиент
class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command commandA = new ConcreteCommandA(receiver);
        Command commandB = new ConcreteCommandB(receiver);

        Invoker invoker = new Invoker();
        invoker.setCommand(commandA);
        invoker.executeCommand();

        invoker.setCommand(commandB);
        invoker.executeCommand();
    }
}


// Интерфейс коллекции
 interface Aggregate {
    Iterator<String> createIterator();
}

// Конкретная коллекция
class ConcreteAggregate implements Aggregate {
    private List<String> items;

    public ConcreteAggregate() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    @Override
    public Iterator<String> createIterator() {
        return items.iterator();
    }
}

// Клиент
public class ex8 {
    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        aggregate.addItem("Item 1");
        aggregate.addItem("Item 2");
        aggregate.addItem("Item 3");

        Iterator<String> iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}