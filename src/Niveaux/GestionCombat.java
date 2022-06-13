package Niveaux;
import Personnages.*;

//Utile si implémentation d'un mode de jeu en version Aventure
public interface GestionCombat {
    void monterExp(final int exp, final Heros NomHeros);
    boolean estVaincu(final String camp, final Heros NomHeros);
    double faiblesse(final String element, final String element_ennemi);
    void degat(final int degatInflige, final String camp, final Heros NomHeros, final Ennemis cible);
    boolean attaque(final Heros NomHeros, final Ennemis cible);

}