public class Labyrinth {

    //champs de l'objet Labyrinth
    private int nbLignes;
    private int nbColonnes;
    private String row;
    private Cellule valCellule[][];  //tab 2D du type cellule

    /*      Méthodes    */

    // Constructeur : construir un nouveau objet valCellule de type array2D de cellules
    public Labyrinth(int nbLignes, int nbColonnes, String row) {
        //System.out.println(row);
        this.nbLignes = 0;
        this.nbColonnes = 0;
        this.row = "";
        valCellule = new Cellule[nbLignes][nbColonnes];
        int index = 0;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                valCellule[i][j] = new Cellule(row.charAt(index++), i, j) ; // Iterate over characters of a String
                System.out.println(valCellule[i][j].toString());
            }
        }
    }

    //le cerveau du programme qui va trouver les chemins
    //sans parametre car le départ et l'arrivé sont tjrs les mêmes (0,0) et (N-1, M-1)
    public void pathFinder() {

    }

}
