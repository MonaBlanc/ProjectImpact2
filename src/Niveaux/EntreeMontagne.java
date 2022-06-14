package Niveaux;
import main.*;
import Objets.*;

import java.util.Scanner;

import static main.Graphics.clear;

/**
 * Classe qui gère les écrans dans le Donjon
 */
public class EntreeMontagne {

    /**
     * Constructeur vide
     */
    public EntreeMontagne(){
    }

    /**
     * Ecran du donjon à afficher qui gère l'introduction à celui-ci ainsi que les choix de l'utilisateur
     * @param heros Aventurier sélectionné par l'utilisateur
     */
    public void Montagne(Heros heros) {

        Donjon shogun = new Donjon();
        int choix;
        int choixNiveau1;
        int choixNiveau2;
        int choixNiveau3;
        int choixNiveauBoss;

        Scanner validation = new Scanner(System.in);
        Scanner selectionUser = new Scanner(System.in);  // Create a Scanner object
        String arriveeM = "Une fois la porte franchie, vous sentez une ambiance lourde qui tire votre corps vers l'arrière. Gardez votre détermination ! La shogun se trouve surement ici. Il est d'ailleurs important de rester concentré, une ombre s'avance à toute vitesse sur vous !";
        String wrappedarriveeM = wrapTexte(arriveeM);
        System.out.println(wrappedarriveeM);
        System.out.println("Qu'allez vous faire ?\n" +
                "[1] - Fuir\n" +
                "[2] - Combattre\n");
        choix = selectionUser.nextLine().charAt(0);
        switch (choix) {
            case '1' -> {
                System.out.println("Vous vous enfuyez ! Vous voilà de retour au menu de départ. N'hésitez pas à prendre une pause :)\n\n");
                Display retourEcran = new Display();
                retourEcran.displayMenu(heros);
            }
            case '2' -> {
                System.out.println("Vous engagez un combat ! Que la chance soit avec vous, cher voyageur.\n\n");
                Ennemis cible = new Ennemis("blob", 2, "anemo");
                Evenement premierCombat = new Evenement(heros, cible, null);
                premierCombat.debutCombat(heros, cible);
            }
            default -> {
                System.out.println("Merci de faire un choix !\n");
            }
        }

        System.out.println("Vous sentez qu'une force commence à vous donner du courage ! La Shogun \nvous regarde surement, du haut de la montagne, avec mépris. N'ayez crainte \nvoyageur, le donjon d'entraînement est là pour ça !");
        System.out.println("[APPUYER SUR ENTREE]");
        validation.nextLine();
        System.out.println("\nQu'allez vous faire ?\n" +
                "[1] - Revenir sur mes pas\n" +
                "[2] - Accéder au premier niveau\n");
        choixNiveau1 = selectionUser.nextLine().charAt(0);
        switch (choixNiveau1) {
            case '1' -> {
                System.out.println("Vous vous enfuyez ! Vous voilà de retour au menu de départ. N'hésitez pas à prendre une pause :)\n\n");
                Display retourEcran = new Display();
                retourEcran.displayMenu(heros);
            }
            case '2' -> {
                clear();
                shogun.PremierNiveau(heros);
            }
            default -> {
                System.out.println("Merci de faire un choix !\n");
            }
        }

        System.out.println("Cette force que vous sentiez plus tot... elle grandit ! La Shogun \nn'a qu'a bien se tenir, continuew les efforts, voyageur,\n nous n'en sommes qu'au début !");
        System.out.println("[APPUYER SUR ENTREE]");
        validation.nextLine();
        System.out.println("\nQu'allez vous faire ?\n" +
                "[1] - Revenir sur mes pas\n" +
                "[2] - Accéder au deuxieme niveau\n");
        choixNiveau2 = selectionUser.nextLine().charAt(0);
        switch (choixNiveau2) {
            case '1' -> {
                System.out.println("Vous vous enfuyez ! Vous voilà de retour au menu de départ. N'hésitez pas à prendre une pause :)\n\n");
                Display retourEcran = new Display();
                retourEcran.displayMenu(heros);
            }
            case '2' -> {
                clear();
                shogun.DeuxiemeNiveau(heros);
            }
            default -> {
                System.out.println("Merci de faire un choix !\n");
            }
        }

        System.out.println("Déjà la moitié du chemin... Le nombre ne fait pas la force voyageur ! \nVos adversaires ne seront que plus robustes !");
        System.out.println("[APPUYER SUR ENTREE]");
        validation.nextLine();
        System.out.println("\nQu'allez vous faire ?\n" +
                "[1] - Revenir sur mes pas\n" +
                "[2] - Accéder au troisieme niveau\n");
        choixNiveau3 = selectionUser.nextLine().charAt(0);
        switch (choixNiveau3) {
            case '1' -> {
                System.out.println("Vous vous enfuyez ! Vous voilà de retour au menu de départ. N'hésitez pas à prendre une pause :)\n\n");
                Display retourEcran = new Display();
                retourEcran.displayMenu(heros);
            }
            case '2' -> {
                clear();
                shogun.TroisiemeNiveau(heros);
            }
            default -> {
                System.out.println("Merci de faire un choix !\n");
            }
        }

        System.out.println("C'était le dernier combat d'entrainement... Plus que quelques marches avant \nd'atteindre votre but initial et d'avoir l'honneur d'affronter\nla grande Shogun !");
        System.out.println("[APPUYER SUR ENTREE]");
        validation.nextLine();
        System.out.println("\nQu'allez vous faire ?\n" +
                "[1] - Revenir sur mes pas\n" +
                "[2] - Accéder au niveau final\n");
        choixNiveauBoss = selectionUser.nextLine().charAt(0);
        switch (choixNiveauBoss) {
            case '1' -> {
                System.out.println("Vous vous enfuyez ! Vous voilà de retour au menu de départ. N'hésitez pas à prendre une pause :)\n\n");
                Display retourEcran = new Display();
                retourEcran.displayMenu(heros);
            }
            case '2' -> {
                clear();
                shogun.Shogun(heros);
            }
            default -> {
                System.out.println("Merci de faire un choix !\n");
            }
        }

    }
    public String wrapTexte(String texte) {
        //On peut modifier la largeur de la justification avec largeurMax
        int largeurMax = 99;

        //On créé un tableau qui va stocker et séparer notre texte
        String[] separationTexte = texte.split("");
        //Valeur finale renvoyée
        String texteFinal = "";
        String ligne = "";

        //On parcourt notre texte tant qu'il n'est pas fini
        for (int i = 0; i < separationTexte.length; i++) {
            if (ligne.isEmpty()) {
                ligne += separationTexte[i];
            } else if (ligne.length() + separationTexte[i].length() <= largeurMax) { //On sépare le texte dès que l'on dépasse la largeur indiquée
                ligne += separationTexte[i];
            } else {
                texteFinal += ligne + "\n"; //On remplit texte final tant que la fonction n'est pas finie
                ligne = "";
            }
        }
        if(!ligne.isEmpty()){
            texteFinal += ligne + "\n"; //On ajoute la dernère ligne
        }
        /*
        On renvoie la version finale du texte justifié
         */
        return texteFinal;
    }
}