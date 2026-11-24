// Ex6 mini-build: Library. Run: java core-swe/day-01/Ex6_Library.java
// INVARIANTS: a book is borrowed by at most one member; a member holds at most 3 books.
// Callers must not be able to mutate internal collections.
import java.util.List;

public class Ex6_Library {
    static final class Library {
        // TODO: private state (books, members, who borrowed what)
        void addBook(String isbn) { throw new UnsupportedOperationException("TODO"); }
        void addMember(String memberId) { throw new UnsupportedOperationException("TODO"); }
        void borrow(String memberId, String isbn) { throw new UnsupportedOperationException("TODO"); }
        void giveBack(String memberId, String isbn) { throw new UnsupportedOperationException("TODO"); }
        /** must return an unmodifiable snapshot */
        List<String> borrowedBy(String memberId) { throw new UnsupportedOperationException("TODO"); }
    }

    static int failures = 0;
    static void test(String name, Runnable r) {
        try { r.run(); System.out.println("PASS " + name); }
        catch (Throwable t) { failures++; System.out.println("FAIL " + name + " -> " + t); }
    }
    static void require(boolean c, String m) { if (!c) throw new AssertionError(m); }
    static void expect(Class<? extends Throwable> type, Runnable r) {
        try { r.run(); } catch (Throwable t) { if (type.isInstance(t)) return; throw new AssertionError("wrong exception " + t); }
        throw new AssertionError("expected " + type.getSimpleName());
    }
    static Library lib() {
        Library l = new Library();
        for (String i : List.of("b1", "b2", "b3", "b4")) l.addBook(i);
        l.addMember("m1"); l.addMember("m2");
        return l;
    }

    public static void main(String[] args) {
        test("borrow and list", () -> { Library l = lib(); l.borrow("m1", "b1"); require(l.borrowedBy("m1").equals(List.of("b1")), "list"); });
        test("book already borrowed", () -> { Library l = lib(); l.borrow("m1", "b1"); expect(IllegalStateException.class, () -> l.borrow("m2", "b1")); });
        test("limit of 3 books", () -> { Library l = lib(); l.borrow("m1", "b1"); l.borrow("m1", "b2"); l.borrow("m1", "b3"); expect(IllegalStateException.class, () -> l.borrow("m1", "b4")); });
        test("return frees the book", () -> { Library l = lib(); l.borrow("m1", "b1"); l.giveBack("m1", "b1"); l.borrow("m2", "b1"); });
        test("unknown member or book", () -> { Library l = lib(); expect(IllegalArgumentException.class, () -> l.borrow("nope", "b1")); expect(IllegalArgumentException.class, () -> l.borrow("m1", "nope")); });
        test("returned list cannot mutate internals", () -> { Library l = lib(); l.borrow("m1", "b1"); expect(UnsupportedOperationException.class, () -> l.borrowedBy("m1").add("b2")); });
        // WRITTEN ANSWER: which fields are private and why; what would break with a public List? TODO
        if (failures > 0) System.exit(1);
    }
}
