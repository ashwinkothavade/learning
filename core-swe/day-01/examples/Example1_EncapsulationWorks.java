// WORKED EXAMPLE 1: a class protecting its rule (invariant). Run: java Example1_EncapsulationWorks.java
public class Example1_EncapsulationWorks {
    static class Wallet {
        private long rupees;                       // RULE: never negative
        Wallet(long opening) {
            if (opening < 0) throw new IllegalArgumentException("opening must be >= 0");
            this.rupees = opening;
        }
        void spend(long amount) {
            if (amount <= 0) throw new IllegalArgumentException("amount must be positive");
            if (amount > rupees) throw new IllegalStateException("not enough money");
            rupees -= amount;
        }
        long getRupees() { return rupees; }
    }

    public static void main(String[] args) {
        Wallet w = new Wallet(100);
        w.spend(30);
        System.out.println("after spending 30: " + w.getRupees());
        try { w.spend(500); } catch (IllegalStateException e) { System.out.println("spend 500 rejected: " + e.getMessage()); }
        System.out.println("still: " + w.getRupees() + " (a failed call changed nothing)");
        try { new Wallet(-5); } catch (IllegalArgumentException e) { System.out.println("bad wallet never created: " + e.getMessage()); }
        // w.rupees = -999;   // <- will not compile outside the class, because rupees is private
    }
}
