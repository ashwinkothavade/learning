// WORKED EXAMPLE 2: variables hold addresses, not objects. Run: java Example2_References.java
public class Example2_References {
    static class Counter { int value = 0; }
    static void addOne(Counter c) { c.value++; }          // changes the object
    static void swapInside(Counter c) { c = new Counter(); c.value = 99; }  // repoints only the local copy of the address

    public static void main(String[] args) {
        Counter a = new Counter();
        Counter b = a;                       // copies the address: same object
        b.value = 5;
        System.out.println("a.value = " + a.value + " (changed through b)");
        System.out.println("a == b: " + (a == b));
        Counter c = new Counter();
        c.value = 5;
        System.out.println("a == c: " + (a == c) + " (different objects, even with same contents)");
        addOne(a);
        System.out.println("after addOne(a): " + a.value);
        swapInside(a);
        System.out.println("after swapInside(a): " + a.value + " (the caller's variable was not repointed)");
    }
}
