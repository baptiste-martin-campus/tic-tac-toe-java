import java.util.Scanner;

public class TicTacToe {
    public static final int size = 3;
    private final Cell[][] board = new Cell[size][size];

    public Player player;
    public Player player2;

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

    //demande et récupère les coordonnées x et y d'une cellule donnée par le joueur
    public int[] getMoveFromPlayer(Player currentPlayer) {
        boolean error = false;
        int x = -1;
        int y = -1;
        while (!error) {
            if (currentPlayer instanceof HumanPlayer) {

                try {
                    System.out.println("Entrez le numéro de la ligne (entre 0 et " + (size - 1) + ")");
                    Scanner demande = new Scanner(System.in);
                    x = demande.nextInt();
                } catch (Exception e) {
                    error = true;
                }

                try {
                    System.out.println("Entrez le numéro de la colonne (entre 0 et " + (size - 1) + ")");
                    Scanner demande = new Scanner(System.in);
                    y = demande.nextInt();
                } catch (Exception e) {
                    error = true;
                }

            } else {
                try{
                    ArtificialPlayer ap = (ArtificialPlayer) currentPlayer;
                    x = ap.getRandom(0, size);
                    y = ap.getRandom(0, size);
                } catch(Exception e) {
                    error = true;
                }
            }
            if (x >= 0 && x <= size && y >= 0 && y <= size && board[x][y].isEmpty() && isNumeric(Integer.toString(y)) && isNumeric(Integer.toString(x))) {
                System.out.println("Votre coup : \nX:" + x + "\nY:" + y);
                return new int[]{x, y};
            }else{
                System.out.println("Coup invalide, veuillez recommencer");
            }
        }
        return getMoveFromPlayer(currentPlayer);
    }


    //pose le caractère du joueur sur la cellule donnée
    public void setOwner(int[] cord, Player player) {
        board[cord[0]][cord[1]].setRepresentation(player.getRepresentation());
        board[cord[0]][cord[1]].setEmpty(false);
    }

    //choisir le nombre de joueurs
    public void getNumberOfPlayer() {
        System.out.println("Choisir le nombre de joueurs (entre 0 et 2)");
        Scanner question = new Scanner(System.in);
        int nbPlayer = question.nextInt();
        if (isNumeric(String.valueOf(nbPlayer)) && nbPlayer >= 0 && nbPlayer <= 2) {
            if (nbPlayer == 0) {
                this.player = new ArtificialPlayer();
                this.player2 = new ArtificialPlayer();
            } else if (nbPlayer == 1) {
                this.player = new HumanPlayer();
                this.player2 = new ArtificialPlayer();
            } else {
                this.player = new HumanPlayer();
                this.player2 = new HumanPlayer();
            }
        } else {
            System.out.println("Nombre invalide, veuillez recommencer");
            getNumberOfPlayer();
        }
    }

    //possibilité de choisir le caractère pour jouer
    public void chooseChar() {
        String jrStr;
        String jr2Str;
        if (this.player instanceof HumanPlayer) {
            System.out.println("Choisir votre votre lettre pour jouer");
            System.out.println("Joueur 1 : ");
            Scanner question = new Scanner(System.in);
            jrStr = question.next();
        } else {
            jrStr = "A";
        }
        if (this.player2 instanceof HumanPlayer) {
            System.out.println("Joueur 2 : ");
            Scanner question = new Scanner(System.in);
            jr2Str = question.next();
        } else {
            jr2Str = "A²";
        }
        if (jrStr.equals(jr2Str)) {
            System.out.println("Erreur ! Les noms sont identiques, on recommence les petits malins");
            chooseChar();
        }
        this.player.setRepresentation("| " + jrStr + " ");
        this.player2.setRepresentation("| " + jr2Str + " ");
    }

    public Player switchPlayer(Player player, Player player2, Player currentPlayer) {
        return (currentPlayer == player) ? player2 : player;
    }

    //le jeu se joue
    public void play() {
        getNumberOfPlayer();
        chooseChar();
        display();
        Player currentPlayer = this.player;

        while (!isOver()) {
            System.out.println("Au tour du joueur suivant");
            setOwner(getMoveFromPlayer(currentPlayer), currentPlayer);
            display();
            currentPlayer = switchPlayer(this.player, this.player2, currentPlayer);
        }

    }

    //vérifie si la partie est finie
    public boolean isOver() {
        return isWinner(board, player) || isWinner(board, player2) || isBoardFull(board);
    }

    //vérifie si le plateau est plein
    public boolean isBoardFull(Cell[][] board) {
        Cell cell = new Cell();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].getRepresentation().equals(cell.getRepresentation())) {
                    return false;
                }
            }
        }
        System.out.println("Game Over ! Aucun gagnant ! \uD83D\uDE2D");
        return true;
    }

    public boolean isWinner(Cell[][] board, Player player) {
        String playerSymbol = player.getRepresentation();
        boolean gagnant = false;
        // Vérification des lignes
        for (int i = 0; i < 3; i++) {
            if (board[i][0].getRepresentation().equals(playerSymbol) && board[i][1].getRepresentation().equals(playerSymbol) && board[i][2].getRepresentation().equals(playerSymbol)) {
                gagnant = true; // Le joueur a gagné sur une ligne
                break;
            }
        }

        // Vérification des colonnes
        for (int j = 0; j < 3; j++) {
            if (board[0][j].getRepresentation().equals(playerSymbol) && board[1][j].getRepresentation().equals(playerSymbol) && board[2][j].getRepresentation().equals(playerSymbol)) {
                gagnant = true; // Le joueur a gagné sur une colonne
                break;
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

        if (gagnant) {
            System.out.println("Félicitations joueur " + player.getRepresentation() + "! Tu as gagné ! \uD83D\uDC4F \uD83D\uDC4F \uD83D\uDC4F");
            return true;
        }

        return false; // Aucune condition de victoire n'est satisfaite.
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