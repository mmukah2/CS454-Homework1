import java.util.Random;

public class Philosopher extends Thread {
    protected int id;
    Utensil left;
    Utensil right;

    synchronized boolean tryToEat() {
        if (!left.taken && !right.taken) {
            if (left.philosopher == this.id || right.philosopher == this.id) {
                return false; // give someone else a chance
            }

            left.taken = true;
            left.philosopher = this.id;
            right.taken = true;
            right.philosopher = this.id;

            System.out.println("Philosopher #" + this.id + " is now eating using utensils " + left.id + " and " + right.id);
            return true;
        }
        return false;
    }

    void eatAndFinish() {
        Random rand = new Random();
        int time = rand.nextInt(Dining.MAX_EATING_TIME);
        
        System.out.println("Thread #" + this.id + " eating for " + time + " seconds");
        try {
            Thread.sleep(time * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Thread #" + this.id + " shutting down due to unexpected interruption");
            System.exit(1);
        }

        left.taken = false;
        right.taken = false;
    }

    @Override
    public void run() {
        System.out.println("Hello from Thread # " + this.id + " | left: " + left.id + " | right: " + right.id);

        int i = 0;
        while (i < Dining.MAX_TIMES_TO_EAT) {
            if (tryToEat()) {
                eatAndFinish();
                i++;
                System.out.println("Philosopher #" + this.id + " has eaten " + i + " times.");
            }
        }
    }

    Philosopher(int id) {
        this.id = id;
    }
}