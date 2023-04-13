package ex3;

import java.util.HashMap;
import java.util.Map;

public class ex3 {
    public static void main(String[] args) throws InterruptedException {
        SemaphoreMap<String, Integer> SemaphoreMap = new SemaphoreMap<String, Integer>();
//        SemaphoreMap.put("3", 12);
//        SemaphoreMap.put("2", 12);
//        SemaphoreMap.put("1", 12);
//        System.out.println(SemaphoreMap.size());

        Thread one = new Thread(()->{
            for(int i = 0; i < 50;i++) {
                SemaphoreMap.put(Integer.toString(i), 12);
            }
        });
        Thread two = new Thread(()->{
            for(int i = 0; i < 50;i++) {
                SemaphoreMap.put(Integer.toString(i + 1000), 12);
            }
        });
        one.start();
        two.start();
        Thread.sleep(50);

        System.out.println(SemaphoreMap.size());
        LockList<Integer>  LockList = new LockList<Integer>();
        //LockList.add(3);

        Thread first = new Thread(()->{
            for(int i = 0; i < 50;i++) {
                LockList.add(12);
            }
        });
        Thread second = new Thread(()->{
            for(int i = 0; i < 50;i++) {
                LockList.add(12);
            }
        });
        first.start();
        second.start();
        Thread.sleep(50);
        System.out.println(LockList.size());
    }
}