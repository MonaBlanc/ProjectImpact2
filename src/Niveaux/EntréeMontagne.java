package Niveaux;
import main.Display;
import Personnages.*;

import java.util.Scanner;  // Import the Scanner class

import static main.Clear.clear;

public class EntréeMontagne {

    public EntréeMontagne(Heros Héros){
        Heros Choisi = Héros;
    }

    public void arrivee(Heros Choisi) {
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
                retourEcran.displayMenu(Choisi);
            }
            case '2' -> {
                System.out.println("Vous engagez un combat ! Que la chance soit avec vous, cher voyageur.\n\n");
                Ennemis cible = new Ennemis("blob", 2, "anemo");
                Evenement premierCombat = new Evenement(Choisi, cible, null);
                premierCombat.debutCombat(Choisi, cible);
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
                retourEcran.displayMenu(Choisi);
            }
            case '2' -> {
                clear();
                Donjon Shogun = new Donjon(Choisi);
                Shogun.PremierNiveau(Choisi);
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
                retourEcran.displayMenu(Choisi);
            }
            case '2' -> {
                clear();
                Donjon Shogun = new Donjon(Choisi);
                Shogun.DeuxiemeNiveau(Choisi);
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
                retourEcran.displayMenu(Choisi);
            }
            case '2' -> {
                clear();
                Donjon Shogun = new Donjon(Choisi);
                Shogun.TroisiemeNiveau(Choisi);
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
                retourEcran.displayMenu(Choisi);
            }
            case '2' -> {
                clear();
                Donjon Shogun = new Donjon(Choisi);
                Shogun.Shogun(Choisi);
            }
        }

    }

    public String wrapTexte(String texte) {
        final int largeurMax = 70;
        String[] separationTexte = texte.split("");
        String texteFinal = "";
        String ligne = "";

        for (String s : separationTexte) {
            if (ligne.isEmpty()) {
                ligne += s;
            } else if (ligne.length() + s.length() < largeurMax) {
                ligne += s;
            } else {
                texteFinal += ligne + "\n";
                ligne = "";
            }
        }
        return texteFinal;
    }

}