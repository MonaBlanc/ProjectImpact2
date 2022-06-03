package Niveaux;

import java.util.Random;

public class LancerDe {
    public LancerDe() {

    }
    private static final Random random = new Random();
    public static int lancer(int max) {
        return 1 + random.nextInt(max);
    }
    public static int lancer6(){
        return lancer(6);
    }
}