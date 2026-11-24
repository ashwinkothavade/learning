// Ex0: static vs instance state, and the race condition trap.
// Run: java core-swe/day-01/Ex0_StaticCounter.java
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Ex0_StaticCounter {
    static class Employee {
        private static int count = 0;      // TODO: make this thread-safe (hint: AtomicInteger)
        private final String name;
        Employee(String name) { this.name = Objects.requireNonNull(name); count++; }
        static int getCount() { return count; }
        // TODO: inside getCount(), try to return name.length(); read the compiler error, then remove it.
    }

    public static void main(String[] args) throws Exception {
        Runnable r = () -> { for (int i = 0; i < 100_000; i++) new Employee("x"); };
        Thread t1 = new Thread(r), t2 = new Thread(r);
        t1.start(); t2.start(); t1.join(); t2.join();
        int got = Employee.getCount();
        System.out.println((got == 200_000 ? "PASS" : "FAIL") + " count=" + got + " expected=200000");
        // WRITTEN ANSWER: why was the count wrong before your fix? TODO
        if (got != 200_000) System.exit(1);
    }
}
