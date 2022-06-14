package Niveaux;
import Objets.*;

/**
 * Interface permettant la gestion du combat
 * Utile si implémentation d'un mode de jeu aventure
 */
public interface GestionCombat {
    /**
     * Fonction qui monte l'expérience du héros
     * @param exp Expérience gagné
     * @param heros On envoie l'aventurier à monter
     */
    void monterExp(final int exp, final Heros heros);

    /**
     * Fonction qui test si un des camps est vaincu ou non
     * @param camp On envoie le camp que l'on teste
     * @param heros On envoie l'aventurier à tester
     * @return renvoie l'état du participant
     */
    boolean estVaincu(final String camp, final Heros heros);

    /**
     * Fonction qui test les faiblesses entre les deux camps
     * @param element Element du héros à tester
     * @param element_ennemi Element de l'ennemi à tester
     * @return on renvoit un facteur qui sera appliqué lors du calcul des dégats
     */
    double faiblesse(final String element, final String element_ennemi);

    /**
     * Fonction qui applique les dats au camp choisi
     * @param degatInflige Dégâts déjà calculés à appliquer
     * @param camp Camp auquel on applique les dégâts
     * @param heros Héros participant au combat
     * @param cible Ennemi envoyé au combat
     */
    void degat(final int degatInflige, final String camp, final Heros heros, final Ennemis cible);

    /**
     * Gestion de l'attaque du héros envers l'ennemi
     * @param heros Héros participant au combat
     * @param cible Ennemi envoyé au combat
     */
    void attaque(final Heros heros, final Ennemis cible);

    /**
     * Gestion de l'attaque de l'ennemi envers le héros
     * @param heros Héros participant au combat
     * @param cible Ennemi envoyé au combat
     */
    void défense(Heros heros, Ennemis cible);


}