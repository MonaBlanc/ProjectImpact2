package Niveaux;
import main.Display;
import Personnages.*;

import java.util.Scanner;  // Import the Scanner class

public class EntréeMontagne {

    public EntréeMontagne(Heros Héros){
        Heros Choisi = Héros;
    }

    public void arrivee(Heros Choisi) {
        int choix;
        Scanner selectionUser = new Scanner(System.in);  // Create a Scanner object
        String arriveeM = "Une fois la porte franchie, vous sentez une ambiance lourde qui tire votre corps vers l'arrière. Gardez votre détermination ! La shogun se trouve surement ici. Il est d'ailleurs important de rester concentré, une ombre s'avance à toute vitesse sur vous !";
        String wrappedarriveeM = wrapTexte(arriveeM);
        System.out.println(wrappedarriveeM);
        System.out.println("Qu'allez vous faire ?\n" +
                "[1] - Fuir\n" +
                "[2] - Combattre\n");
        choix = selectionUser.nextLine().charAt(0);
        switch (choix) {
            case '1':
                System.out.println("Vous vous enfuyez ! Vous voilà de retour au menu de départ. N'hésitez pas à prendre une pause :)\n\n");
                Display retourEcran = new Display();
                retourEcran.displayMenu(Choisi);
                break;
            case '2':
                System.out.println("Vous engagez un combat ! Que la chance soit avec vous, cher voyageur.\n\n");
                Ennemis cible = new Ennemis("blob", 2, "anemo");
                Evenement premierCombat = new Evenement(Choisi, cible);
                premierCombat.debutCombat(Choisi, cible);
        }

        String finCombat1 = "Vous sentez que  Gardez votre détermination ! La shogun se trouve surement ici. Il est d'ailleurs important de rester concentré, une ombre s'avance à toute vitesse sur vous !";
        String wrappedfinCombat1 = wrapTexte(finCombat1);
        System.out.println(wrappedfinCombat1);



    }

    public String wrapTexte(String texte) {
        final int largeurMax = 70;
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
        return texteFinal;
    }

}