
public class Philospher extends Thread {
    protected int id;
    Utensil left;
    Utensil right;

    @Override
    public void run() {
        System.out.println("Hello from Thread # " + this.id + " | left: " + left.id + " | right: " + right.id);
    }

    Philospher(int id) {
        this.id = id;
    }
}