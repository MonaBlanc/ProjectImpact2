package Niveaux;
import Personnages.*;

public interface GestionCombat {
    void monterExp(final int exp);
    boolean estVaincu(final String camp);
    int recupHP(final String camp);
    double faiblesse(final String element, final String element_ennemi);
    void degat(final int degatInflige, final String camp);
    boolean attaque(final Heros Héros, final Ennemis cible);

}