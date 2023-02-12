public class Dining {
    private static final int NUM_PHILOSPHERS = 5;

    public static void main(String[] args) {
        Philospher[] diningTable = new Philospher[NUM_PHILOSPHERS];
        Utensil[] utensils = new Utensil[NUM_PHILOSPHERS];

        for (int i = 0; i < NUM_PHILOSPHERS; i++) {
            utensils[i] = new Utensil(i);
        }

        for (int i = 0; i < NUM_PHILOSPHERS; i++) {
            diningTable[i] = new Philospher(i);
            
            diningTable[i].left = utensils[i];
            if (i != NUM_PHILOSPHERS - 1)
                diningTable[i].right = utensils[i+1];
            else
                diningTable[i].right = utensils[0];

            diningTable[i].start();
        }
    }
}
