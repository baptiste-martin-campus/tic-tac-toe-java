import java.util.Scanner;

public class TicTacToe {
    public static final int size = 3;
    private final Cell[][] board = new Cell[size][size];

    public Player player = new Player();
    public Player player2 = new Player();

    public TicTacToe() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public void addLine() {
        Cell cell = new Cell();
        int nbLine = cell.representation.length() * size + 1;
        String line = "-";
        System.out.println(line.repeat(nbLine));
    }

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

    public void setOwner(int[] coordonnees, Player player) {
        board[coordonnees[0]][coordonnees[1]].setRepresentation(player.getRepresentation());
    }

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

    public void play() {
        int nbCellBoard = size * size;
        getNumberOfPlayer();
        chooseChar();
        display();
        Player currentPlayer = player;

        while (nbCellBoard > 0){
            System.out.println("Au tour du joueur suivant");
            setOwner(getMoveFromPlayer(), currentPlayer);
            display();
            nbCellBoard--;
            currentPlayer = switchPlayer(player, player2, currentPlayer);
        }
        System.out.println("Game Over ! Aucun gagnant ! \uD83D\uDE2D");
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