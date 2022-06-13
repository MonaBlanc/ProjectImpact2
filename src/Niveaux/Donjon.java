package Niveaux;

import Personnages.Ennemis;
import Personnages.Heros;

import java.util.Scanner;

public class Donjon {

    public String artefactChoisi;

    public Donjon() {
    }

    public void PremierNiveau(Heros NomHeros) {
        LancerDe LancerDé = new LancerDe();
        int Lancer6 = LancerDé.lancer6();
                System.out.println("Vous vous engagez dans le premier niveau ! Plus que 3 avant de rencontrer la Shogun..\n\n");
                Ennemis sbire1 = new Ennemis("sbire", 3, "geo");
                Evenement premierCombat = new Evenement(NomHeros, sbire1, null);
                premierCombat.debutCombat(NomHeros, sbire1);
                System.out.println("\nPremier sbire vaincu ! Restez sur vos gardes, un autre approche...\n\n");
                Ennemis sbire2 = new Ennemis("sbire", 3, "geo");
                Evenement deuxiemeCombat = new Evenement(NomHeros, sbire2, null);
                deuxiemeCombat.debutCombat(NomHeros, sbire2);

        System.out.println("Vous êtes venu à bout du premier niveau ! Avec plus d'expériences votre puissance augmente !");
        System.out.println("\nUn coffre se cache avant la prochaine porte, vous y trouvez un set d'artefacts avec une inscription : ");
        Scanner selectionUser = new Scanner(System.in);

        if (Lancer6 == 6) {
            System.out.println("SACRIFICIEUR\n");
            System.out.println("Le set du sacrificieur vous offrera 50 d'attaque en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi = "SACRIFICIEUR";
                    break;
                case 2:
                    NomHeros.setPV(NomHeros.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 5) {
            System.out.println("SACRIFICIEUR\n");
            System.out.println("Le set du sacrificieur vous offrera 50 d'attaque en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi = "SACRIFICIEUR";
                    break;
                case 2:
                    NomHeros.setPV(NomHeros.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 4) {
            System.out.println("COEURDUGARDIEN\n");
            System.out.println("Le set du coeur du gardien vous offrera 400PV en échange de la moitié de 20 points d'attaque.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi = "COEURDUGARDIEN";
                    break;
                case 2:
                    NomHeros.setPV(NomHeros.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 3) {
            System.out.println("COEURDUGARDIEN\n");
            System.out.println("Le set du coeur du gardien vous offrera 400PV en échange de la moitié de 20 points d'attaque.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi = "COEURDUGARDIEN";
                    break;
                case 2:
                    NomHeros.setPV(NomHeros.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 2) {
            System.out.println("ERUDIT\n");
            System.out.println("Le set de l'érudit vous offrera 40 de maitrise élémentaire en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi =  "ERUDIT";
                    break;
                case 2:
                    NomHeros.setPV(NomHeros.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 1) {
            System.out.println("ERUDIT\n");
            System.out.println("Le set de l'érudit vous offrera 40 de maitrise élémentaire en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi =  "ERUDIT";
                    break;
                case 2:
                    NomHeros.setPV(NomHeros.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        }
    }

    public void DeuxiemeNiveau(Heros Choisi) {
        LancerDe LancerDé = new LancerDe();
        int Lancer6 = LancerDé.lancer6();
        System.out.println("Vous vous engagez dans le deuxieme niveau ! Plus que 2 avant de rencontrer la Shogun..\n\n");
        Ennemis fatui1 = new Ennemis("fatui", 10, "geo");
        Evenement premierCombat = new Evenement(Choisi, fatui1, artefactChoisi);
        premierCombat.debutCombat(Choisi, fatui1);
        System.out.println("\nPremier Fatui vaincu ! Restez sur vos gardes, cette fois il en reste deux...\n\n");
        Ennemis fatui2 = new Ennemis("fatui", 10, "geo");
        Evenement deuxiemeCombat = new Evenement(Choisi, fatui2, artefactChoisi);
        deuxiemeCombat.debutCombat(Choisi, fatui2);
        System.out.println("\nLe dernier Fatui approche...\n\n");
        Ennemis fatui3 = new Ennemis("sbire", 10, "geo");
        Evenement troisiemeCombat = new Evenement(Choisi, fatui3, artefactChoisi);
        troisiemeCombat.debutCombat(Choisi, fatui3);

        //TODO : Gestion Défaite + Récompenses
        System.out.println("Vous êtes venu à bout du deuxieme niveau ! Avec plus d'expériences votre puissance augmente !");
        System.out.println("\nUn coffre se cache avant la prochaine porte, vous y trouvez un set d'artefacts avec une inscription : ");
        Scanner selectionUser = new Scanner(System.in);
        if (Lancer6 == 6) {
            System.out.println("SACRIFICIEUR\n");
            System.out.println("Le set du sacrificieur vous offrera 50 d'attaque en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi = "SACRIFICIEUR";
                    break;
                case 2:
                    Choisi.setPV(Choisi.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 5) {
            System.out.println("SACRIFICIEUR\n");
            System.out.println("Le set du sacrificieur vous offrera 50 d'attaque en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi = "SACRIFICIEUR";
                    break;
                case 2:
                    Choisi.setPV(Choisi.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 4) {
            System.out.println("COEURDUGARDIEN\n");
            System.out.println("Le set du coeur du gardien vous offrera 400PV en échange de la moitié de 20 points d'attaque.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi = "COEURDUGARDIEN";
                    break;
                case 2:
                    Choisi.setPV(Choisi.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 3) {
            System.out.println("COEURDUGARDIEN\n");
            System.out.println("Le set du coeur du gardien vous offrera 400PV en échange de la moitié de 20 points d'attaque.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi = "COEURDUGARDIEN";
                    break;
                case 2:
                    Choisi.setPV(Choisi.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 2) {
            System.out.println("ERUDIT\n");
            System.out.println("Le set de l'érudit vous offrera 40 de maitrise élémentaire en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi =  "ERUDIT";
                    break;
                case 2:
                    Choisi.setPV(Choisi.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 1) {
            System.out.println("ERUDIT\n");
            System.out.println("Le set de l'érudit vous offrera 40 de maitrise élémentaire en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi =  "ERUDIT";
                    break;

                case 2:
                    Choisi.setPV(Choisi.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        }

    }

    public void TroisiemeNiveau(Heros Choisi) {
        LancerDe LancerDé = new LancerDe();
        int Lancer6 = LancerDé.lancer6();
        System.out.println("Vous vous engagez dans le troisieme niveau ! Le dernier avant de rencontrer la Shogun..\n\n");
        Ennemis hyposthase1 = new Ennemis("hyposthase", 15, "geo");
        Evenement premierCombat = new Evenement(Choisi, hyposthase1, artefactChoisi);
        premierCombat.debutCombat(Choisi, hyposthase1);
        System.out.println("Vous êtes venu à bout du troisieme niveau ! Avec plus d'expériences votre puissance augmente !");
        System.out.println("\nUn coffre se cache avant la prochaine porte, vous y trouvez un set d'artefacts avec une inscription : ");
        Scanner selectionUser = new Scanner(System.in);
        if (Lancer6 == 6) {
            System.out.println("SACRIFICIEUR\n");
            System.out.println("Le set du sacrificieur vous offrera 50 d'attaque en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi = "SACRIFICIEUR";
                    break;
                case 2:
                    Choisi.setPV(Choisi.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 5) {
            System.out.println("SACRIFICIEUR\n");
            System.out.println("Le set du sacrificieur vous offrera 50 d'attaque en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi = "SACRIFICIEUR";
                    break;
                case 2:
                    Choisi.setPV(Choisi.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 4) {
            System.out.println("COEURDUGARDIEN\n");
            System.out.println("Le set du coeur du gardien vous offrera 300PV en échange de 20 points d'attaque.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi = "COEURDUGARDIEN";
                    break;
                case 2:
                    Choisi.setPV(Choisi.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 3) {
            System.out.println("COEURDUGARDIEN\n");
            System.out.println("Le set du coeur du gardien vous offrera 300PV en échange de 20 points d'attaque.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi = "COEURDUGARDIEN";
                    break;
                case 2:
                    Choisi.setPV(Choisi.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 2) {
            System.out.println("ERUDIT\n");
            System.out.println("Le set de l'érudit vous offrera 40 de maitrise élémentaire en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi =  "ERUDIT";
                    break;
                case 2:
                    Choisi.setPV(Choisi.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 1) {
            System.out.println("ERUDIT\n");
            System.out.println("Le set de l'érudit vous offrera 40 de maitrise élémentaire en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi =  "ERUDIT";
                    break;
                case 2:
                    Choisi.setPV(Choisi.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        }

    }

    public void Shogun(Heros Choisi) {
        LancerDe LancerDé = new LancerDe();
        int Lancer6 = LancerDé.lancer6();
        System.out.println("Vous sentez une ambiance électrifiante... Cette derniere vous glace le sang ! vous allez rencontrer la Shogun..\n\n");
        Ennemis shogunRaiden = new Ennemis("Boss", 30, "electro");
        Evenement premierCombat = new Evenement(Choisi, shogunRaiden, artefactChoisi);
        premierCombat.debutCombat(Choisi, shogunRaiden);
        System.out.println("Vous êtes venu à bout de la grande Shogun ! C'est malheureusement la fin de notre aventure...");
        System.out.println("\nCe fut un plaisir, voyageur. Merci d'avoir joué avec nous.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n[APPUYER SUR ENTREE]");
        scanner.nextLine();
    }

    }

