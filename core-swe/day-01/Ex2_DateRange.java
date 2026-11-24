// Ex2: immutable DateRange with invariant start <= end. Run: java core-swe/day-01/Ex2_DateRange.java
import java.time.LocalDate;

public class Ex2_DateRange {
    // TODO: enforce start <= end and non-null in the compact constructor.
    record DateRange(LocalDate start, LocalDate end) {
        DateRange {
            // TODO
        }
        /** inclusive on both ends */
        boolean contains(LocalDate d) { throw new UnsupportedOperationException("TODO"); }
        /** true if the two ranges share at least one day */
        boolean overlaps(DateRange o) { throw new UnsupportedOperationException("TODO"); }
    }

    static int failures = 0;
    static void test(String name, Runnable r) {
        try { r.run(); System.out.println("PASS " + name); }
        catch (Throwable t) { failures++; System.out.println("FAIL " + name + " -> " + t); }
    }
    static void require(boolean c, String msg) { if (!c) throw new AssertionError(msg); }
    static LocalDate d(int day) { return LocalDate.of(2026, 1, day); }

    public static void main(String[] args) {
        test("rejects start after end", () -> {
            try { new DateRange(d(5), d(1)); throw new AssertionError("no exception"); }
            catch (IllegalArgumentException expected) { }
        });
        test("rejects null", () -> {
            try { new DateRange(null, d(1)); throw new AssertionError("no exception"); }
            catch (NullPointerException | IllegalArgumentException expected) { }
        });
        test("single day allowed", () -> new DateRange(d(3), d(3)));
        test("contains inclusive", () -> {
            DateRange r = new DateRange(d(1), d(5));
            require(r.contains(d(1)) && r.contains(d(5)) && !r.contains(d(6)), "contains wrong");
        });
        test("overlaps", () -> {
            DateRange r = new DateRange(d(1), d(5));
            require(r.overlaps(new DateRange(d(5), d(8))), "touching ends overlap");
            require(!r.overlaps(new DateRange(d(6), d(8))), "disjoint must not overlap");
            require(r.overlaps(new DateRange(d(2), d(3))), "contained overlaps");
        });
        // WRITTEN ANSWER: what does immutability buy you here? TODO
        if (failures > 0) System.exit(1);
    }
}
