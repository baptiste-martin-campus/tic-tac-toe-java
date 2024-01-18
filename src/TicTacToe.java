import java.util.Scanner;

public class TicTacToe {
    public static final int size = 3;
    private final Cell[][] board = new Cell[size][size];

    public Player player = new Player();
    public Player player2 = new Player();

    //ajout des cellules
    public TicTacToe() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    //ligne graphique pour le plateau
    public void addLine() {
        Cell cell = new Cell();
        int nbLine = cell.representation.length() * size + 1;
        String line = "-";
        System.out.println(line.repeat(nbLine));
    }

    //affichage du plateau
    public void display() {
        addLine();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j].getRepresentation());
            }
            System.out.println("|");
            addLine();
        }
    }

    //demande et récupère les coordonnées x et y d'une cellule données par le joueur
    public int[] getMoveFromPlayer() {
        System.out.println("Entrez le numéro de la ligne (entre 0 et "+ (size-1) + ")");
        Scanner demande = new Scanner(System.in);
        int x = demande.nextInt();
        System.out.println("Entrez le numéro de la colonne (entre 0 et "+ (size-1) + ")");
        demande = new Scanner(System.in);
        int y = demande.nextInt();
        System.out.println("Votre coup : \nX:" + x + "\nY:" + y);
        Cell cell = new Cell();
        if (x >= 0 && x <= size && y >= 0 && y <= size && board[x][y].getRepresentation().equals(cell.getRepresentation())) {
            return new int[]{x, y};
        }
        System.out.println("Coup invalide, veuillez recommencer");
        return getMoveFromPlayer();
    }

    //pose le charactère du joueur sur la cellule donnée
    public void setOwner(int[] coordonnees, Player player) {
        board[coordonnees[0]][coordonnees[1]].setRepresentation(player.getRepresentation());
    }

    //choisir le nombre de joueurs
    public void getNumberOfPlayer() {
        System.out.println("Choisir le nombre de joueurs (1 ou 2)");
        Scanner question = new Scanner(System.in);
        int nbPlayer = question.nextInt();
        if (isNumeric(String.valueOf(nbPlayer)) && nbPlayer > 0 && nbPlayer <= 2) {
            this.player = new Player();
            if (nbPlayer == 2) {
                this.player2 = new Player();
            }
        } else {
            System.out.println("Nombre Invalide, veuillez recommencer");
            getNumberOfPlayer();
        }
    }

    //possibilité de choisir le charactère pour jouer
    public void chooseChar() {
        System.out.println("Choisir votre votre lettre pour jouer");
        System.out.println("Joueur 1 : ");
        Scanner question = new Scanner(System.in);
        String jrStr = question.next();
        this.player.setRepresentation("| "+jrStr+" ");
        System.out.println("Joueur 2 : ");
        question = new Scanner(System.in);
        String jr2Str = question.next();
        this.player2.setRepresentation("| "+jr2Str+" ");
    }

    public Player switchPlayer(Player player, Player player2, Player currentPlayer){
        return (currentPlayer == player) ? player2 : player;
    }

    //le jeu se joue
    public void play() {
        getNumberOfPlayer();
        chooseChar();
        display();
        Player currentPlayer = player;

        while (!isOver()){
            System.out.println("Au tour du joueur suivant");
            setOwner(getMoveFromPlayer(), currentPlayer);
            display();
            currentPlayer = switchPlayer(player, player2, currentPlayer);
        }

    }
    //vérifie si la partie est finie
    public boolean isOver(){
        return isWinner(board, player) || isWinner(board, player2) || isBoardFull(board);
    }

    //vérifie si le plateau est plein
    public boolean isBoardFull(Cell[][] board){
        Cell cell = new Cell();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].getRepresentation().equals(cell.getRepresentation())){
                    return false;
                }
            }
        }
        System.out.println("Game Over ! Aucun gagnant ! \uD83D\uDE2D");
        return true;
    }

    public boolean isWinner(Cell[][]board, Player player){
        String playerSymbol = player.getRepresentation();
        boolean gagnant = false;
        // Vérification des lignes
        for (int i = 0; i < 3; i++) {
            if (board[i][0].getRepresentation().equals(playerSymbol) && board[i][1].getRepresentation().equals(playerSymbol) && board[i][2].getRepresentation().equals(playerSymbol)) {
                gagnant = true; // Le joueur a gagné sur une ligne
            }
        }

        // Vérification des colonnes
        for (int j = 0; j < 3; j++) {
            if (board[0][j].getRepresentation().equals(playerSymbol) && board[1][j].getRepresentation().equals(playerSymbol) && board[2][j].getRepresentation().equals(playerSymbol)) {
                gagnant = true; // Le joueur a gagné sur une colonne
            }
        }

        // Vérification de la diagonale principale
        if (board[0][0].getRepresentation().equals(playerSymbol) && board[1][1].getRepresentation().equals(playerSymbol) && board[2][2].getRepresentation().equals(playerSymbol)) {
            gagnant = true; // Le joueur a gagné sur la diagonale principale
        }

        // Vérification de la diagonale inverse
        if (board[0][2].getRepresentation().equals(playerSymbol) && board[1][1].getRepresentation().equals(playerSymbol) && board[2][0].getRepresentation().equals(playerSymbol)) {
            gagnant = true; // Le joueur a gagné sur la diagonale inverse
        }

        if (gagnant){
            System.out.println("Félicitations joueur "+ player.getRepresentation() +"! Tu as gagné ! \uD83D\uDC4F \uD83D\uDC4F \uD83D\uDC4F");
            return true;
        }

        return false; // Aucune condition de victoire n'est satisfaite
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}