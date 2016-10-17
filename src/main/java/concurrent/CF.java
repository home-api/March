package concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CF {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("s1", "s2", "s3");

        strings.forEach(s -> CompletableFuture.supplyAsync(() -> {
            System.out.println("supply" + s + " - " + Thread.currentThread().getName());
            sleep();
            return s;
        }).thenAccept(s2 -> {
            System.out.println("accept " + s2 + " - " + Thread.currentThread().getName());
            sleep();
        }));

        System.out.println(Thread.currentThread().getName());

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
