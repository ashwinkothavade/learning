// WORKED EXAMPLE 3: static is shared; shared + changing + threads = bugs. Run: java Example3_StaticAndRace.java
import java.util.concurrent.atomic.AtomicInteger;

public class Example3_StaticAndRace {
    static class Student {
        private final String name;                       // one per student
        static int plainCount = 0;                       // one per class, NOT thread-safe
        static final AtomicInteger safeCount = new AtomicInteger();  // one per class, thread-safe
        Student(String name) { this.name = name; plainCount++; safeCount.incrementAndGet(); }
        String getName() { return name; }
    }

    public static void main(String[] args) throws Exception {
        new Student("Asha"); new Student("Ravi");
        System.out.println("single thread: plain=" + Student.plainCount + " safe=" + Student.safeCount.get());

        Student.plainCount = 0; Student.safeCount.set(0);
        Runnable r = () -> { for (int i = 0; i < 2_000_000; i++) new Student("x"); };
        Thread t1 = new Thread(r), t2 = new Thread(r);
        t1.start(); t2.start(); t1.join(); t2.join();
        System.out.println("two threads, expected 4000000: safe=" + Student.safeCount.get());
        System.out.println("plain is usually LESS than 4000000 (lost updates); this run: " + (Student.plainCount < 4_000_000 ? "less" : "lucky, equal"));
    }
}
