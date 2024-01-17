import java.util.Objects;
import java.util.Scanner;

public class TicTacToe {
    public static final int size = 3;
    private final Cell[][] board = new Cell[size][size];

    public Player player = new Player();

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
        getMoveFromPlayer();
    }

    public void getMoveFromPlayer() {
        System.out.println("Entrez le numéro de la ligne");
        Scanner demande = new Scanner(System.in);
        int x = demande.nextInt();
        System.out.println("Entrez le numéro la colonne");
        demande = new Scanner(System.in);
        int y = demande.nextInt();
        System.out.println("Votre coup : \nX:" + x + "\nY:" + y);
        Cell cell = new Cell();
        if (x >= 0 && x <= size && y >= 0 && y <= size && Objects.equals(board[x][y].getRepresentation(), cell.getRepresentation())) {
            setOwner(x,y);
        } else {
            System.out.println("Coup invalide, veuillez recommencer");
            getMoveFromPlayer();
        }
    }

    public void setOwner(int x,int y) {
        board[x][y].setRepresentation(player.getRepresentation());
        display();
    }
}