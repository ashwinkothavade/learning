// Ex4: Java is pass-by-value of the reference. Predict FIRST (edit the booleans), then run.
// Run: java core-swe/day-01/Ex4_References.java
public class Ex4_References {
    static class Box { int v = 0; }
    static void reset(Box b) { b = null; }
    static void poke(Box b) { b.v += 1; }
    static void replace(Box b) { b = new Box(); b.v = 99; }

    // YOUR PREDICTIONS (replace null with true/false before running):
    static Boolean callerSeesNullAfterReset = null;    // TODO: true or false
    static Boolean vIsOneAfterPoke = null;            // TODO
    static Boolean vIs99AfterReplace = null;          // TODO

    static int failures = 0;
    static void check(String name, Boolean predicted, boolean actual) {
        boolean ok = predicted != null && predicted == actual;
        if (!ok) failures++;
        System.out.println((ok ? "PASS " : "FAIL ") + name + " (predicted " + predicted + ", actual " + actual + ")");
    }

    public static void main(String[] args) {
        Box a = new Box(); reset(a);
        check("callerSeesNullAfterReset", callerSeesNullAfterReset, a == null);
        Box b = new Box(); poke(b);
        check("vIsOneAfterPoke", vIsOneAfterPoke, b.v == 1);
        Box c = new Box(); replace(c);
        check("vIs99AfterReplace", vIs99AfterReplace, c.v == 99);
        // WRITTEN ANSWER: explain why in two sentences. TODO
        if (failures > 0) System.exit(1);
    }
}
