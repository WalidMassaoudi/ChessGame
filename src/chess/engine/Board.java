package chess.engine;

public class Board {
    private Piece[][] board;

    /**
     * ALlow to create custom board size
     * @param board the board of piece
     */
    public Board(Piece[][] board) {
        this.board = board;
    }

    /**
     * Default constructor for standard board size
     */
    public Board() {
        this(new Piece[8][8]);
    }

    void add(Piece p) {
        board[p.getX()][p.getY()] = p;
    }

    Piece get(int x,int y) {
        return board[x][y];
    }
    /**
     * @brief permet de retirer une piece du board
     * @param x , y les cordonnées
     * @return la piece qu'il y'avait a cet emplacement (peut etre utile)
     */
    void remove(int x, int y) {
        board[x][y] = null;
    }
}
