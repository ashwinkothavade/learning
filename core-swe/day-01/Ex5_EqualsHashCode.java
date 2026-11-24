// Ex5: mutable keys break HashMap. Run: java core-swe/day-01/Ex5_EqualsHashCode.java
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Ex5_EqualsHashCode {
    static class MutablePoint {
        int x, y;
        MutablePoint(int x, int y) { this.x = x; this.y = y; }
        // TODO: override equals and hashCode based on x and y.
    }
    // TODO: make this an immutable record (replace the line below)
    record ImmutablePoint(int x, int y) { }

    static int failures = 0;
    static void test(String name, Runnable r) {
        try { r.run(); System.out.println("PASS " + name); }
        catch (Throwable t) { failures++; System.out.println("FAIL " + name + " -> " + t); }
    }
    static void require(boolean c, String m) { if (!c) throw new AssertionError(m); }

    public static void main(String[] args) {
        test("equal points are equal and hash the same", () -> {
            MutablePoint p = new MutablePoint(1, 2), q = new MutablePoint(1, 2);
            require(p.equals(q) && p.hashCode() == q.hashCode(), "equals/hashCode not implemented");
        });
        test("mutating a key loses the entry (demonstrates the bug)", () -> {
            Map<MutablePoint, String> m = new HashMap<>();
            MutablePoint k = new MutablePoint(1, 2);
            m.put(k, "v");
            k.x = 10;
            require(m.get(k) == null, "expected lookup to fail after mutation");
            require(m.get(new MutablePoint(1, 2)) == null, "old hash bucket holds key that no longer equals");
        });
        test("immutable key is safe", () -> {
            Map<ImmutablePoint, String> m = new HashMap<>();
            m.put(new ImmutablePoint(1, 2), "v");
            require("v".equals(m.get(new ImmutablePoint(1, 2))), "lookup failed");
        });
        // WRITTEN ANSWER: why does the map lose the entry after mutation? TODO
        if (failures > 0) System.exit(1);
    }
}
