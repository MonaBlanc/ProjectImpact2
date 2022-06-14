package main;
import Objets.*;
import java.util.Scanner;

/**
 * Classe qui gère la sélection du Héros ainsi que son menu
 */
public class ChoixHeros extends Graphics{
    /**
     * Constructeur vide.
     */
    public ChoixHeros(){

    }

    /**
     * Fonction de création du personnage principal
     * @return On renvoie le héros choisi par l'utilisateur que l'on a créé
     */
    public Heros selection() {

        /*
        Variable locale
         */
        char classeChoisie;

        //Création des classes à attribuer à l'aide d'armes
        Arme claymoreDuDebutant = new Arme(1,"claymore");
        Arme arcDuDebutant = new Arme(1,"arc");
        Arme epeeDuDebutant = new Arme(1,"mage");
        Arme lanceDuDebutant = new Arme(1,"lance");
        Arme mageDuDebutant = new Arme(1,"mage");


        /*
        On utilise un scanner pour récupérer les entrées de l'utilisateur
         */
        Scanner selectionUtilisateur = new Scanner(System.in);

        do {
            System.out.println("\t- Ecran de selection du heros -");
            //TODO : Qualifier/Définir chacune des classes
            System.out.println("[1] - Un personnage de la classe claymore");
            System.out.println("[2] - Un personnage de la classe archer");
            System.out.println("[3] - Un personnage de la classe mage");
            System.out.println("[4] - Un personnage de la classe epeiste");
            System.out.println("[5] - Un personnage de la classe lancier");
            classeChoisie = selectionUtilisateur.nextLine().charAt(0);

            /*
            En fonction du choix de l'utilisateur, on propose des personnages avec des éléments différents
             */
            switch(classeChoisie) {
                case '1':
                    clear();
                    System.out.println("Votre personnage appartiendra a la classe claymore.\n" +
                            "Par chance, nous avons deux mages prêts à l'aventure !\n" +
                            "[1] - Chongyun, le claymore cryo.\n" +
                            "[2] - Beidou, la claymore electro.\n" +
                            "[3] - Finalement, les claymores ne m'intéressent pas.");
                    int selectionClaymore = selectionUtilisateur.nextLine().charAt(0);
                    switch (selectionClaymore) {
                        case '1' -> {
                            /*
                            Création du héros
                             */
                            Heros Chongyun = new Heros("Chongyun", 1, claymoreDuDebutant, "cryo");
                            System.out.println("Heros choisi ! Vous incarnerz Chongyn pour cette aventure.");
                            /*
                            On renvoie le héros sélectionné
                             */
                            return Chongyun;
                        }
                        case '2' -> {
                            /*
                            Création du héros
                             */
                            Heros Beidou = new Heros("Beidou", 1, claymoreDuDebutant, "electro");
                            System.out.println("Heros choisi ! Vous incarnerz Beidou pour cette aventure.");
                            /*
                            On renvoie le héros sélectionné
                             */
                            return Beidou;
                        }
                        case '3' -> {
                            System.out.println("Retour au menu de selection.");
                            /*
                            On revient à l'écran avec toutes les classes
                             */
                            selection();
                        }
                        default -> {
                            /*
                            Cas où une valeur différente est tapée par l'utilisateur
                             */
                            System.out.println("Merci de rentrer une valeur valide. Retour au menu de sélection.\n\n");
                            selection();
                        }
                    }
                    break;
                /*
                 Tous les cases fonctionnent de la même manière que le premier
                 */
                case '2':
                    clear();
                    System.out.println("Votre personnage appartiendra a la classe archer.\n" +
                            "Par chance, nous avons deux archers prêts à l'aventure !\n" +
                            "[1] - Ganyu, l'archere cryo.\n" +
                            "[2] - Yoimiya, l'archere pyro.\n" +
                            "[3] - Finalement, les archers ne m'intéressent pas.");
                    int selectionArcher = selectionUtilisateur.nextLine().charAt(0);
                    switch (selectionArcher) {
                        case '1' -> {
                            Heros Ganyu = new Heros("Ganyu", 1, arcDuDebutant, "cryo");
                            System.out.println("Heros choisi ! Vous incarnerz Ganyu pour cette aventure.");
                            return Ganyu;
                        }
                        case '2' -> {
                            Heros Yoimiya = new Heros("Yoimiya", 1, arcDuDebutant, "pyro");
                            System.out.println("Heros choisi ! Vous incarnerz Yoimiya pour cette aventure.");
                            return Yoimiya;
                        }
                        case '3' -> {
                            System.out.println("Retour au menu de selection.");
                            selection();
                        }
                        default -> {
                            System.out.println("Merci de rentrer une valeur valide. Retour au menu de sélection.\n\n");
                            selection();
                        }
                    }
                    break;
                /*
                 Tous les cases fonctionnent de la même manière que le premier
                 */
                case '3':
                    clear();
                    System.out.println("Votre personnage appartiendra a la classe mage.\n" +
                            "Par chance, nous avons deux mages prêts à l'aventure !\n" +
                            "[1] - Mona, la mage hydro.\n" +
                            "[2] - Ninguangg, la mage geo.\n" +
                            "[3] - Finalement, les mages ne m'intéressent pas.");
                    int selectionMage = selectionUtilisateur.nextLine().charAt(0);
                    switch (selectionMage) {
                        case '1' -> {
                            Heros Mona = new Heros("Mona", 1, mageDuDebutant, "hydro");
                            System.out.println("Heros choisi ! Vous incarnerz Mona pour cette aventure.");
                            return Mona;
                        }
                        case '2' -> {
                            Heros Ninguangg = new Heros("Ninguangg", 1, mageDuDebutant, "geo");
                            System.out.println("Heros choisi ! Vous incarnerz Ninguangg pour cette aventure.");
                            return Ninguangg;
                        }
                        case '3' -> {
                            System.out.println("Retour au menu de selection.");
                            selection();
                        }
                        default -> {
                            System.out.println("Merci de rentrer une valeur valide. Retour au menu de sélection.\n\n");
                            selection();
                        }
                    }
                    break;
                /*
                 Tous les cases fonctionnent de la même manière que le premier
                 */
                case '4':
                    clear();
                    System.out.println("Votre personnage appartiendra a la classe epeiste.\n" +
                            "Par chance, nous avons deux epeistes prêts à l'aventure !\n" +
                            "[1] - Xingqiu, l'epeiste hydro.\n" +
                            "[2] - Jean, l'epeiste anemo.\n" +
                            "[3] - Finalement, les epeistes ne m'intéressent pas.");
                    int selectionEpeiste = selectionUtilisateur.nextLine().charAt(0);
                    switch (selectionEpeiste) {
                        case '1' -> {
                            Heros Xingqiu = new Heros("Xingqiu", 1, epeeDuDebutant, "hydro");
                            System.out.println("Heros choisi ! Vous incarnerz Xingqiu pour cette aventure.");
                            return Xingqiu;
                        }
                        case '2' -> {
                            Heros Jean = new Heros("Jean", 1, epeeDuDebutant, "anemo");
                            System.out.println("Heros choisi ! Vous incarnerz Jean pour cette aventure.");
                            return Jean;
                        }
                        case '3' -> {
                            System.out.println("Retour au menu de selection.\n\n");
                            selection();
                        }
                        default -> {
                            System.out.println("Merci de rentrer une valeur valide. Retour au menu de sélection.\n\n");
                            selection();
                        }
                    }
                    break;
                /*
                 Tous les cases fonctionnent de la même manière que le premier
                 */
                case '5':
                    clear();
                    System.out.println("Votre personnage appartiendra a la classe lancier.\n" +
                            "Par chance, nous avons deux lanciers prêts à l'aventure !\n" +
                            "[1] - Xiao, le lancier anemo.\n" +
                            "[2] - Hu tao, la lanciere pyro.\n" +
                            "[3] - Finalement, les lanciers ne m'intéressent pas.");
                    int selectionLancier = selectionUtilisateur.nextLine().charAt(0);
                    switch (selectionLancier)  {
                        case '1' -> {
                            Heros Xiao = new Heros("Xiao", 1, lanceDuDebutant, "anemo");
                            System.out.println("Heros choisi ! Vous incarnerz Xiao pour cette aventure.");
                            return Xiao;
                        }
                        case '2' -> {
                            Heros HuTao = new Heros("HuTao", 1, lanceDuDebutant, "pyro");
                            System.out.println("Heros choisi ! Vous incarnerz Hu Tao pour cette aventure.");
                            return HuTao;
                        }
                        case '3' -> {
                            System.out.println("Retour au menu de selection.\n\n");
                            selection();
                        }
                        default -> {
                            System.out.println("Merci de rentrer une valeur valide. Retour au menu de sélection.\n\n");
                            selection();
                        }
                    }
                default :
                    /*
                    Cas où une valeur différente est tapée par l'utilisateur
                     */
                    System.out.println("Merci de rentrer une valeur valide.\n\n");

            }

        } while (classeChoisie != '1' && classeChoisie != '2' && classeChoisie != '3' && classeChoisie != '4' && classeChoisie != '5');
        /*
        On continue la boucle tant que l'utilisateur n'a pas sélectionné un héros
         */
        return null;
    }

}