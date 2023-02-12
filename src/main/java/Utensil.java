public class Utensil {
    int id;
    volatile int philosopher;
    volatile boolean taken = false;

    Utensil(int id) {
        this.id = id;
    }
}