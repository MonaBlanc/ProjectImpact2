package main;

import Personnages.Heros;
import java.util.Scanner;


public class mainJeu extends Clear{

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