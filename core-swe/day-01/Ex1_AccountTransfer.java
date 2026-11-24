// Ex1: Account with transfer. Run: java core-swe/day-01/Ex1_AccountTransfer.java
public class Ex1_AccountTransfer {
    static final class Account {
        // INVARIANT: balance >= 0
        private long balance;
        Account(long openingPaise) {
            if (openingPaise < 0) throw new IllegalArgumentException("negative opening balance");
            this.balance = openingPaise;
        }
        long getBalance() { return balance; }
        void deposit(long paise) {
            if (paise <= 0) throw new IllegalArgumentException("deposit must be positive");
            this.balance = Math.addExact(balance, paise);
        }
        void withdraw(long paise) {
            if (paise <= 0) throw new IllegalArgumentException("withdraw must be positive");
            if (paise > balance) throw new IllegalStateException("insufficient funds");
            this.balance -= paise;
        }
        /** TODO: move amount from this to 'to'. Self-transfer must throw IllegalArgumentException.
         *  If anything fails, BOTH balances must be unchanged. */
        void transfer(Account to, long amount) {
            throw new UnsupportedOperationException("TODO");
        }
    }

    static int failures = 0;
    static void test(String name, Runnable r) {
        try { r.run(); System.out.println("PASS " + name); }
        catch (Throwable t) { failures++; System.out.println("FAIL " + name + " -> " + t); }
    }
    static void require(boolean c, String msg) { if (!c) throw new AssertionError(msg); }

    public static void main(String[] args) {
        test("normal transfer", () -> {
            Account a = new Account(100), b = new Account(50);
            a.transfer(b, 30);
            require(a.getBalance() == 70 && b.getBalance() == 80, "balances wrong");
        });
        test("self transfer rejected", () -> {
            Account a = new Account(100);
            try { a.transfer(a, 10); throw new AssertionError("no exception"); }
            catch (IllegalArgumentException expected) { }
            require(a.getBalance() == 100, "balance changed");
        });
        test("insufficient funds leaves both unchanged", () -> {
            Account a = new Account(10), b = new Account(5);
            try { a.transfer(b, 50); throw new AssertionError("no exception"); }
            catch (IllegalStateException expected) { }
            require(a.getBalance() == 10 && b.getBalance() == 5, "state changed");
        });
        test("deposit overflow leaves source unchanged", () -> {
            Account a = new Account(100), b = new Account(Long.MAX_VALUE - 5);
            try { a.transfer(b, 50); throw new AssertionError("no exception"); }
            catch (ArithmeticException expected) { }
            require(a.getBalance() == 100 && b.getBalance() == Long.MAX_VALUE - 5, "state changed");
        });
        // WRITTEN ANSWERS: which invariants matter for transfer? What if two threads transfer A->B and B->A? TODO
        if (failures > 0) System.exit(1);
    }
}
