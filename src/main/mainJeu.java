package main;

import Objets.Heros;
import java.util.Scanner;

/**
 * Classe comprenant le scripte principal de notre jeu
 */
public class mainJeu extends Graphics {
    /**
     * Main du jeu dans lequel on va appeler les différents écrans
     * @param args Paramètres habituels
     */
    public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            clear();
            Display EcranTitre = new Display();
            EcranTitre.displayOpening();
            System.out.println("\n[APPUYER SUR ENTREE]");
            scanner.nextLine();
            Heros selection = EcranTitre.displaySelection();
            EcranTitre.displayMenu(selection);

        clear();

    }
}