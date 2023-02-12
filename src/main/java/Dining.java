public class Dining {
    protected static final int NUM_PHILOSOPHERS = 5;
    protected static final int MAX_EATING_TIME = 5; // seconds
    protected static final int MAX_TIMES_TO_EAT = 5;

    public static void main(String[] args) {
        Philosopher[] diningTable = new Philosopher[NUM_PHILOSOPHERS];
        Utensil[] utensils = new Utensil[NUM_PHILOSOPHERS];

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            utensils[i] = new Utensil(i);
        }

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            diningTable[i] = new Philosopher(i);
            
            diningTable[i].left = utensils[i];
            if (i != NUM_PHILOSOPHERS - 1)
                diningTable[i].right = utensils[i+1];
            else
                diningTable[i].right = utensils[0];

            diningTable[i].start();
        }
    }
}
