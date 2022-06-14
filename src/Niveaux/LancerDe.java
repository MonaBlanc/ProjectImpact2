package Niveaux;

import java.util.Random;

/**
 * Classe qui gère l'aléatoire à l'aide d'un lancer de dé
 */
public class LancerDe {
    /**
     * Constructeur vide
     */
    public LancerDe() {

    }

    /**
     * Fonction random qui génère l'aléatoire
     */
    private static final Random random = new Random();

    /**
     * On simule un lancer entre 1 et max
     * @param max Valeur maximum désirée
     * @return On renvoie la valeur obtenue
     */
    public static int lancer(int max) {
        return 1 + random.nextInt(max);
    }

    /**
     * On simule un lancer entre 1 et 6
     * @return On renvoie la valeur obtenue
     */
    public static int lancer6(){
        return lancer(6);
    }
}