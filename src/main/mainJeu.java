package main;

import Personnages.Heros;
import main.*;
import static main.Clear.clear;


public class mainJeu {

    public static void main(String[] args){
            clear();
            Display EcranTitre = new Display();
            EcranTitre.displayOpening();
            Heros selection = EcranTitre.displaySelection();
            EcranTitre.displayMenu(selection);

        clear();

            }
        }