package Niveaux;

public enum Artefacts {

    SACRIFICIEUR("Sacrifieur"), INSTRUCTEUR("Instructeur"), ERUDIT("Érudit"), BERSERKER("Berserker"), EXILE("Exilé"), COEURDUGARDIEN("Coeur du Gardien");

    private String nom ;

    private Artefacts(String nom) {
        this.nom = nom ;
    }

    public String getNom() {
        return  this.nom ;
    }
}
