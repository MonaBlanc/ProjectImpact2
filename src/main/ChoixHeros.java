package main;
import Personnages.*;
import java.util.Scanner;  // Import the Scanner class

import static main.Clear.clear;


public class ChoixHeros {

    public ChoixHeros(){

    }
    public Heros selection() {
        char classeChoisie;
        String displayNom = "";

        Arme claymoreDuDebutant = new Arme(1,"claymore");
        Arme arcDuDebutant = new Arme(1,"arc");
        Arme epeeDuDebutant = new Arme(1,"mage");
        Arme lanceDuDebutant = new Arme(1,"lance");
        Arme mageDuDebutant = new Arme(1,"mage");



        Scanner selectionUser = new Scanner(System.in);  // Create a Scanner object

        do {
            System.out.println("'c' pour la classe claymore");
            System.out.println("'a' pour la classe archer");
            System.out.println("'m' pour la classe mage");
            System.out.println("'e' pour la classe epeiste");
            System.out.println("'l' pour la classe lancier");
            classeChoisie = selectionUser.nextLine().charAt(0);
            switch(classeChoisie) {
                case 'c':
                    clear();
                    System.out.println("Votre personnage appartiendra a la classe claymore.\n " +
                            "Par chance, nous avons deux mages prêts à l'aventure !\n" +
                            "[1] - Chongyun, le claymore cryo.\n" +
                            "[2] - Beidou, la claymore electro.\n" +
                            "[3] - Finalement, les claymores ne m'intéressent pas.");
                    int selectionClaymore = selectionUser.nextLine().charAt(0);
                    switch (selectionClaymore) {
                        case '1':
                            Heros Chongyun = new Heros("Chongyun", 1, claymoreDuDebutant, "cryo");
                            System.out.println("Heros choisi ! ");
                            displayNom = "Chongyun";
                            return Chongyun;
                        case '2':
                            Heros Beidou = new Heros("Beidou", 1, claymoreDuDebutant, "electro");
                            System.out.println("Heros choisi ! ");
                            displayNom = "Beidou";
                            return Beidou;
                        case '3':
                            System.out.println("Retour au menu de selection.");
                            selection();
                            break;
                        default :
                            System.out.println("Merci de rentrer une valeur valide. Retour au menu de sélection.\n\n");
                            selection();
                            break;
                    }
                    break;
                case 'a':
                    clear();
                    System.out.println("Votre personnage appartiendra a la classe archer.\n " +
                            "Par chance, nous avons deux archers prêts à l'aventure !\n" +
                            "[1] - Ganyu, l'archere cryo.\n" +
                            "[2] - Yoimiya, l'archere pyro.\n" +
                            "[3] - Finalement, les archers ne m'intéressent pas.");
                    int selectionArcher = selectionUser.nextLine().charAt(0);
                    switch (selectionArcher) {
                        case '1':
                            Heros Ganyu = new Heros("Ganyu", 1, arcDuDebutant, "cryo");
                            System.out.println("Heros choisi ! ");
                            displayNom = "Ganyu";
                            return Ganyu;
                        case '2':
                            Heros Yoimiya = new Heros("Yoimiya", 1, arcDuDebutant, "pyro");
                            System.out.println("Heros choisi ! ");
                            displayNom = "Yoimiya";
                            return Yoimiya;
                        case '3':
                            System.out.println("Retour au menu de selection.");
                            selection();
                            break;
                        default :
                            System.out.println("Merci de rentrer une valeur valide. Retour au menu de sélection.\n\n");
                            selection();
                            break;
                    }
                    break;
                case 'm':
                    clear();
                    System.out.println("Votre personnage appartiendra a la classe mage.\n " +
                            "Par chance, nous avons deux mages prêts à l'aventure !\n" +
                            "[1] - Mona, la mage hydro.\n" +
                            "[2] - Ninguangg, la mage geo.\n" +
                            "[3] - Finalement, les mages ne m'intéressent pas.");
                    int selectionMage = selectionUser.nextLine().charAt(0);
                    switch (selectionMage) {
                        case '1':
                            Heros Mona = new Heros("Mona", 1, mageDuDebutant, "hydro");
                            System.out.println("Heros choisi ! ");
                            displayNom = "Mona";
                            return Mona;
                        case '2':
                            Heros Ninguangg = new Heros("Ninguangg", 1, mageDuDebutant, "geo");
                            System.out.println("Heros choisi ! ");
                            displayNom = "Ninguangg";
                            return Ninguangg;

                        case '3':
                            System.out.println("Retour au menu de selection.");
                            selection();
                            break;
                        default :
                            System.out.println("Merci de rentrer une valeur valide. Retour au menu de sélection.\n\n");
                            selection();
                            break;
                    }
                    break;
                case 'e':
                    clear();
                    System.out.println("Votre personnage appartiendra a la classe epeiste.\n " +
                            "Par chance, nous avons deux epeistes prêts à l'aventure !\n" +
                            "[1] - Xingqiu, l'epeiste hydro.\n" +
                            "[2] - Jean, l'epeiste anemo.\n" +
                            "[3] - Finalement, les epeistes ne m'intéressent pas.");
                    int selectionEpeiste = selectionUser.nextLine().charAt(0);
                    switch (selectionEpeiste) {
                        case '1':
                            Heros Xingqiu = new Heros("Xingqiu", 1, epeeDuDebutant, "hydro");
                            System.out.println("Heros choisi ! ");
                            displayNom = "Xingqiu";
                            return Xingqiu;
                        case '2':
                            Heros Jean = new Heros("Jean", 1, epeeDuDebutant, "anemo");
                            System.out.println("Heros choisi ! ");
                            displayNom = "Jean";
                            return Jean;

                        case '3':
                            System.out.println("Retour au menu de selection.\n\n");
                            selection();
                            break;
                        default :
                            System.out.println("Merci de rentrer une valeur valide. Retour au menu de sélection.\n\n");
                            selection();
                            break;
                    }
                    break;
                case 'l':
                    clear();
                    System.out.println("Votre personnage appartiendra a la classe lancier.\n " +
                            "Par chance, nous avons deux lanciers prêts à l'aventure !\n" +
                            "[1] - Xiao, le lancier anemo.\n" +
                            "[2] - Hu tao, la lanciere pyro.\n" +
                            "[3] - Finalement, les lanciers ne m'intéressent pas.");
                    int selectionLancier = selectionUser.nextLine().charAt(0);
                    switch (selectionLancier) {
                        case '1':
                            Heros Xiao = new Heros("Xiao", 1, lanceDuDebutant, "anemo");
                            System.out.println("Heros choisi ! ");
                            displayNom = "Xiao";
                            return Xiao;
                        case '2':
                            Heros HuTao = new Heros("HuTao", 1, lanceDuDebutant, "pyro");
                            System.out.println("Heros choisi ! ");
                            displayNom = "HuTao";
                            return HuTao;
                        case '3':
                            System.out.println("Retour au menu de selection.\n\n");
                            selection();
                            break;
                        default :
                            System.out.println("Merci de rentrer une valeur valide. Retour au menu de sélection.\n\n");
                            selection();
                            break;
                    }
                default :
                    System.out.println("Merci de rentrer une valeur valide.\n\n");

            }

        } while (classeChoisie != 'c' && classeChoisie != 'a' && classeChoisie != 'm' && classeChoisie != 'e' && classeChoisie != 'l');
        System.out.println("Vous incarnerez " + displayNom + " pour cette aventure.\n\n");

        return null;
    }

}