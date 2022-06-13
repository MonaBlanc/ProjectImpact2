package main;

import Niveaux.EntréeMontagne;
import Personnages.Heros;

import java.util.Scanner;


public class Display extends Clear {

    public Display(){

    }

    public void displayOpening() {
        String opening = "Un archipel isolé. L'Ouest lointain de Teyvat. Surpassez les éclairs intarissables d'Inazuma et faites un premier pas vers ces îles d'érables rouges et de cerisiers. Il va falloir franchir des forêts et montagnes pleines de secrets avant de pouvoir témoigner de l'Eternité poursuivie par son Excellence, la grande Raiden Shogun.";
        String wrappedOpening = wrapTexte(opening);
        System.out.println(wrappedOpening);
    }

    public void displayBeginningMontagne() {
        String beginningM = "Vous vous approchez de la montagne. Au bout de quelques pas, vous vous rendez compte qu'une grande porte se dessine devant vous. Voila l'entrée d'un donjon. Préparez bien vos armes, il va y avoir un long chemin à parcourir avant d'atteindre la Shogun.";
        String wrappedbeginningM = wrapTexte(beginningM);
        System.out.println(wrappedbeginningM);
    }

    public Heros displaySelection() {
        clear();
        System.out.println("Je ne vous ai pas demandé voyageur, qui incarnerez-vous ?\n\n\n");
        ChoixHeros premierChoix = new ChoixHeros();
        return premierChoix.selection();
    }

        public String wrapTexte(String texte) {
        final int largeurMax = 99;
        String[] separationTexte = texte.split("");
        String texteFinal = "";
        String ligne = "";

        for (int i = 0; i < separationTexte.length; i++) {
            if (ligne.isEmpty()) {
                ligne += separationTexte[i];
            } else if (ligne.length() + separationTexte[i].length() < largeurMax) {
                ligne += separationTexte[i];
            } else {
                texteFinal += ligne + "\n";
                ligne = "";
            }
        }

        if(!ligne.isEmpty()){
            texteFinal += ligne + "\n";
        }

        return texteFinal;
    }


    public void displayMenu(Heros Choisi) {
        Scanner sc = new Scanner(System.in);
        int choix = 0;

        System.out.println("Quel sera votre choix ?");
        System.out.println("[1] - Franchir la montagne silencieuse"); //donjon
        System.out.println("[2] - Je veux changer de heros");
        System.out.println("[3] - Je veux partir. ");
        System.out.println("Taper votre choix :                                       ");
        choix = Integer.parseInt(sc.nextLine());// <--- ligne modifiée
        switch (choix) {
            case 1 -> {
                clear();
                displayBeginningMontagne();
                EntréeMontagne Arrivée = new EntréeMontagne(Choisi);
                Arrivée.arrivee(Choisi);
            }
            case 2 -> {
                clear();
                System.out.println("Ecran de selection du heros");
                ChoixHeros premierChoix = new ChoixHeros();
                Choisi = premierChoix.selection();

                displayMenu(Choisi);
            }
            case 3 -> {
                clear();
                System.out.println("En esperant vous revoir bientot, voyageur.");
            }
            default -> System.out.println("Veuillez respecter le menu!");
        }
    }

}