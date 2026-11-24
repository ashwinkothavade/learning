// Ex3: hide representation (Kelvin), expose Celsius. Run: java core-swe/day-01/Ex3_Temperature.java
public class Ex3_Temperature {
    static final class Temperature {
        // TODO: private field storing Kelvin. INVARIANT: kelvin >= 0.
        private Temperature() { }
        static Temperature fromCelsius(double c) { throw new UnsupportedOperationException("TODO"); }
        double toCelsius() { throw new UnsupportedOperationException("TODO"); }
    }

    static int failures = 0;
    static void test(String name, Runnable r) {
        try { r.run(); System.out.println("PASS " + name); }
        catch (Throwable t) { failures++; System.out.println("FAIL " + name + " -> " + t); }
    }

    public static void main(String[] args) {
        test("round trip", () -> {
            double c = Temperature.fromCelsius(25.0).toCelsius();
            if (Math.abs(c - 25.0) > 1e-9) throw new AssertionError("got " + c);
        });
        test("below absolute zero rejected", () -> {
            try { Temperature.fromCelsius(-300); throw new AssertionError("no exception"); }
            catch (IllegalArgumentException expected) { }
        });
        // WRITTEN ANSWER: change the internal unit to Fahrenheit. Which callers break? TODO
        if (failures > 0) System.exit(1);
    }
}
