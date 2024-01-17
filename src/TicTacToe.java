public class TicTacToe {
    public static final int size = 3;
    private final Cell[][] board = new Cell[size][size];

    public TicTacToe(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }
    public void display(){
        System.out.println("---------");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j].getRepresentation());
            }
            System.out.println("\n---------");
        }
    }
}