package ex4;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ex4 {
    public static void main(String[] args){
        MyExecutorService executorService = new MyExecutorService(1);

        executorService.submitTask(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("We run it");
        });

        executorService.submitTask(() -> System.out.println("Start"));

        executorService.shutdown();
    }
}
class MyExecutorService {

    private final ExecutorService executorService;

    public MyExecutorService(int numThreads) {
        this.executorService = Executors.newFixedThreadPool(numThreads);
    }

    public void submitTask(Runnable task) {
        executorService.submit(task);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}