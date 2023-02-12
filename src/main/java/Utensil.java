public class Utensil {
    protected int id;
    protected volatile int philosopher;
    volatile boolean taken = false;

    Utensil(int id) {
        this.id = id;
    }
}