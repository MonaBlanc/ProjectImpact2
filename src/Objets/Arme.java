package Objets;

public class Arme {
    int niveau;
    String type;
    protected int attaque_arme;
    protected int pv_arme;
    protected int défense_arme;
    protected int maîtriseElem_arme;

    public Arme(int niveau, String type) {
        this.niveau = niveau;
        this.type = type;
        switch(type){
            case "arc":
                attaque_arme = 15 + (niveau-1)*10;
                pv_arme = 100+ (niveau-1)*10;
                défense_arme = 5+ (niveau-1)*10;
                maîtriseElem_arme = 30+ (niveau-1)*10;
                break;

            case "epee":
                attaque_arme = 35+ (niveau-1)*10;
                pv_arme = 120+ (niveau-1)*10;
                défense_arme = 30+ (niveau-1)*10;
                maîtriseElem_arme = 0+ (niveau-1)*10;
                break;

            case "claymore":
                attaque_arme = 40+ (niveau-1)*10;
                pv_arme = 220+ (niveau-1)*10;
                défense_arme = 50+ (niveau-1)*10;
                maîtriseElem_arme = 0+ (niveau-1)*10;
                break;

            case "lance":
                attaque_arme = 25+ (niveau-1)*10;
                pv_arme = 70+ (niveau-1)*10;
                défense_arme = 15+ (niveau-1)*10;
                maîtriseElem_arme = 20+ (niveau-1)*10;
                break;

            case "mage":
                attaque_arme = 10+ (niveau-1)*10;
                pv_arme = 50+ (niveau-1)*10;
                défense_arme = 10+ (niveau-1)*10;
                maîtriseElem_arme = 60+ (niveau-1)*10;
                break;
        }
    }
}
