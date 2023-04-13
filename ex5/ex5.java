package ex5;

public class ex5{
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.sayHello();
        Singleton2 singleton2 = Singleton2.getInstance();
        singleton2.sayHello();
        Singleton3 singleton3 = Singleton3.getInstance();
        singleton3.sayHello();
    }
}

class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }

    public void sayHello() {
        System.out.println("Hello!");
    }
}
class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {}

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

    public void sayHello() {
        System.out.println("Hello!");
    }

}
class Singleton3 {
    private static volatile Singleton3 instance;

    private Singleton3() {}

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }

    public void sayHello() {
        System.out.println("Hello!");
    }

}


