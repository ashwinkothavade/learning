// Day 1 LLD: Money, Account, transfer, and a requirements-to-classes Cart.
// Run: java lld/day-01/LldDay01.java
import java.util.Currency;
import java.util.List;

public class LldDay01 {
    // ---------- 1. Money: immutable value type ----------
    // TODO: record or final class; fields minorUnits (long) and Currency; plus/minus throw on currency mismatch or overflow; compareTo.
    static final class Money implements Comparable<Money> {
        static Money of(long minorUnits, String currencyCode) { throw new UnsupportedOperationException("TODO"); }
        long minorUnits() { throw new UnsupportedOperationException("TODO"); }
        Money plus(Money o) { throw new UnsupportedOperationException("TODO"); }
        Money minus(Money o) { throw new UnsupportedOperationException("TODO"); }
        @Override public int compareTo(Money o) { throw new UnsupportedOperationException("TODO"); }
    }

    // ---------- 2. Account ----------
    // INVARIANT: balance >= 0, currency fixed for life.
    static final class Account {
        Account(String id, Money opening) { throw new UnsupportedOperationException("TODO"); }
        Money getBalance() { throw new UnsupportedOperationException("TODO"); }
        void deposit(Money m) { throw new UnsupportedOperationException("TODO"); }
        void withdraw(Money m) { throw new UnsupportedOperationException("TODO"); }
    }

    // ---------- 3. transfer: choose member or service and justify below ----------
    static void transfer(Account from, Account to, Money amount) { throw new UnsupportedOperationException("TODO"); }

    // ---------- 4. Requirements-to-classes drill: Cart ----------
    // "A shopping cart holds items with quantities. A user can add or remove items, apply one coupon, and check out.
    //  Quantity must be positive; the total cannot be negative; an empty cart cannot be checked out."
    // TODO: design CartItem and Cart using Money. Add tests in main below.

    // ---------- Tests ----------
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
    static Money inr(long p) { return Money.of(p, "INR"); }

    public static void main(String[] args) {
        test("1 invalid construction (negative opening)", () -> expect(IllegalArgumentException.class, () -> new Account("a", inr(-1))));
        test("2 withdraw exactly the balance", () -> { Account a = new Account("a", inr(100)); a.withdraw(inr(100)); require(a.getBalance().minorUnits() == 0, "balance"); });
        test("3 overdraft rejected", () -> { Account a = new Account("a", inr(100)); expect(IllegalStateException.class, () -> a.withdraw(inr(101))); require(a.getBalance().minorUnits() == 100, "changed"); });
        test("4 currency mismatch", () -> { Account a = new Account("a", inr(100)); expect(IllegalArgumentException.class, () -> a.deposit(Money.of(5, "USD"))); });
        test("5 self transfer rejected", () -> { Account a = new Account("a", inr(100)); expect(IllegalArgumentException.class, () -> transfer(a, a, inr(10))); });
        test("6 overflow rejected", () -> { Account a = new Account("a", inr(Long.MAX_VALUE)); expect(ArithmeticException.class, () -> a.deposit(inr(1))); });
        test("7 failed transfer leaves both unchanged", () -> {
            Account a = new Account("a", inr(10)), b = new Account("b", inr(5));
            expect(IllegalStateException.class, () -> transfer(a, b, inr(50)));
            require(a.getBalance().minorUnits() == 10 && b.getBalance().minorUnits() == 5, "changed");
        });
        test("8 Money is immutable (plus returns new object)", () -> {
            Money m = inr(10); Money n = m.plus(inr(5));
            require(m.minorUnits() == 10 && n.minorUnits() == 15, "mutated");
        });
        // Add Cart tests here.

        if (failures > 0) System.exit(1);
    }

    /* WRITTEN ANSWERS
     * Invariants in Money vs Account (5 sentences incl. concurrency plan): TODO
     * Why transfer lives where it does: TODO
     * Cart: classes, fields, invariants, and one thing deliberately left out: TODO
     */
}
