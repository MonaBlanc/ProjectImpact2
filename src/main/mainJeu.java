package main;

import Personnages.Heros;
import main.*;
import static main.Clear.clear;
import java.util.Scanner;


public class mainJeu {

    public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            clear();
            Display EcranTitre = new Display();
            EcranTitre.displayOpening();
            scanner.nextLine();
            Heros selection = EcranTitre.displaySelection();
            EcranTitre.displayMenu(selection);

        clear();

            }
        }