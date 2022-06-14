package main;

import Niveaux.EntreeMontagne;
import Objets.Heros;

import java.util.Scanner;

/**
 * Classe qui gère l'affichage des premiers écrans
 * On hérite de clear car c'est une classe que l'on utilisera beaucoup pour les affichages et écrans de base
 */
public class Display extends Graphics {

    public Display(){

    }

    /**
     * Fonction qui affiche le premier écran du jeu
     */
    public void displayOpening() {
        /*
        On affiche un texte pour aborder le jeu avec un peu de lore en l'attribuant à une variable pour le manipuler
         */
        String opening = "Un archipel isolé. L'Ouest lointain de Teyvat. Surpassez les éclairs intarissables d'Inazuma et faites un premier pas vers ces îles d'érables rouges et de cerisiers. Il va falloir franchir des forêts et montagnes pleines de secrets avant de pouvoir témoigner de l'Eternité poursuivie par son Excellence, la grande Raiden Shogun.";
        /*
        La fonction wrapTexte permet un affichage propre et justifié
         */
        String wrappedOpening = wrapTexte(opening);
        /*
        On affiche le texte justifié
         */
        System.out.println(wrappedOpening);
    }

    /**
     * Fonction qui affiche l'écran avec l'entrée du donjon
     * Même fonction que pour opening
     */
    public void displayBeginningMontagne() {
        String beginningM = "Vous vous approchez de la montagne. Au bout de quelques pas, vous vous rendez compte qu'une grande porte se dessine devant vous. Voila l'entrée d'un donjon. Préparez bien vos armes, il va y avoir un long chemin à parcourir avant d'atteindre la Shogun.";
        String wrappedbeginningM = wrapTexte(beginningM);
        System.out.println(wrappedbeginningM);
    }

    /**
     * Fonction qui affiche l'écran avec la sélection du héros
     */
    public Heros displaySelection() {
        /*
        On passe à un nouvel écran, on clear la console
         */
        clear();
        System.out.println("Je ne vous ai pas demandé voyageur, qui incarnerez-vous ?\n\n\n");
        /*
        On créé un objet pour la classe qui permettra la sélection du héros et on stocke le héros choisi dans premierChoix
         */
        ChoixHeros premierChoix = new ChoixHeros();
        /*
        On renvoie le héros sélectionné par l'utilisateur
         */
        return premierChoix.selection();
    }

    /**
     * Fonction qui affiche le menu principal
     * @param choisi Héros choisi lors de la première sélection et qui partira à l'aventure
     */
    public void displayMenu(Heros choisi) {
        /*
        On récupère le choix de l'utilisateur
         */
        Scanner sc = new Scanner(System.in);
        /*
        On attribuera le choix de l'utilisateur à cette variable pour le switch case
         */
        int choix;

        System.out.println("Quel sera votre choix ?");
        System.out.println("[1] - Franchir la montagne silencieuse"); //Mode de jeu Donjon
        System.out.println("[2] - Je veux changer de heros");
        System.out.println("[3] - Je veux partir. ");
        System.out.println("Taper votre choix :    ");
        choix = Integer.parseInt(sc.nextLine());
        switch (choix) {
            case 1 -> {
                clear();
                /*
                On affiche l'écran d'entrée du donjon
                 */
                displayBeginningMontagne();
                EntreeMontagne Arrivee = new EntreeMontagne();
                /*
                On envoie l'aventurier dans la montagne
                 */
                Arrivee.Montagne(choisi);
            }
            case 2 -> {
                clear();
                /*
                On relance une sélection du héros avec ChoixHeros
                 */
                ChoixHeros nouveauChoix = new ChoixHeros();
                Heros nouveauHeros;
                nouveauHeros = nouveauChoix.selection();
                /*
                Une fois le héros sélectionné, on revient sur le menu principal
                 */
                displayMenu(nouveauHeros);
            }
            case 3 -> {
                clear();
                /*
                On quitte simplement le jeu
                 */
                System.out.println("En esperant vous revoir bientot, voyageur.");
            }
            /*
            Cas où une valeur différente est tapée par l'utilisateur
             */
            default -> System.out.println("Veuillez respecter le menu!");
        }
    }

}