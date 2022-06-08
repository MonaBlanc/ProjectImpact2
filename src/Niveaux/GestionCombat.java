package Niveaux;
import Personnages.*;

public interface GestionCombat {
    int recupNiveau();
    void setNiveau(final int level);
    int monterNiveau();
    boolean estVaincu(final String camp);
    int recupHP(final String camp);
    int recupHPmax(final String camp);
    double faiblesse(final String element, final String element_ennemi);
    void degat(final int degatInflige, final String camp);
    boolean attaque(final Heros Héros, final Ennemis cible);

}