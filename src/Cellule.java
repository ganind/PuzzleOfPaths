public class Cellule {

    private char valeur;
    private int ligne;
    private int colonne;

    public Cellule(char valeur, int ligne, int colonne){
        this.valeur = valeur;
        this.ligne = ligne;
        this.colonne = colonne;
    }

    public char getValeur() {
        return valeur;
    }

    public int getLigne(){
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    // affichage pour la phase de test
    /* @Override
    public String toString() {
        return "Cellule{" +
                "valeur=" + valeur +
                ", ligne=" + ligne +
                ", colonne=" + colonne +
                '}';
    }
     */
}
