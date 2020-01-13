package chess.engine;

import chess.PlayerColor;
<<<<<<< HEAD
import chess.engine.Piece.*;
=======
>>>>>>> 33427ae5bdfba07d64ca454828ad681b5ee528d0

public class Board {
    private Piece[][] board;
    private PlayerColor top_player;
    private PlayerColor bottom_player;

    /**
     * ALlow to create custom board size
     * @param board the board of piece
     */
    public Board(Piece[][] board, PlayerColor top_player) {
        this.board = board;
        this.top_player = top_player;
        this.bottom_player = top_player == PlayerColor.BLACK ?
                PlayerColor.WHITE :
                PlayerColor.BLACK;
    }

    /**
     * Default constructor for standard board size
     */
    public Board(PlayerColor top_player) {
        this(new Piece[8][8], top_player);
    }
    void initBoard(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j]=null;
            }
        }
    }

    void initBoard() {
        board[0][0] = new Rook(top_player);
        board[1][0] = new Knight(top_player);
        board[2][0] = new Bishop(top_player);
        board[3][0] = new Queen(top_player);
        board[4][0] = new King(top_player);
        board[5][0] = new Bishop(top_player);
        board[6][0] = new Knight(top_player);
        board[7][0] = new Rook(top_player);

        board[0][7] = new Rook(bottom_player);
        board[1][7] = new Knight(bottom_player);
        board[2][7] = new Bishop(bottom_player);
        board[4][7] = new Queen(bottom_player);
        board[3][7] = new King(bottom_player);
        board[5][7] = new Bishop(bottom_player);
        board[6][7] = new Knight(bottom_player);
        board[7][7] = new Rook(bottom_player);

        for(int i=0;i<8;++i) {
            board[i][1] = new Pawn(top_player,top_player);
            board[i][6] = new Pawn(bottom_player,top_player);
        }

    }

    void add(Piece p,int x, int y) {
        board[x][y] = p;
    }

    public Piece get(int x, int y) {
        return board[x][y];
    }
    /**
     * @brief permet de retirer une piece du board
     * @param x , y les cordonnées
     * @return la piece qu'il y'avait a cet emplacement (peut etre utile)
     */
    public void remove(int x, int y) {
        board[x][y] = null;
    }
<<<<<<< HEAD

=======
>>>>>>> 33427ae5bdfba07d64ca454828ad681b5ee528d0
    /**
     * vérifier si la case souhaitée est occupée déja par une autre piece.
     *
     * @param pc  la couleur de la piece appelante.
     * @param xTo l'indice x destination.
     * @param yTo l'indice y destination .
     */
<<<<<<< HEAD
    public boolean isFriendAt(int xTo, int yTo, PlayerColor pc) {
        return (board[xTo][yTo] != null && board[xTo][yTo].color() == pc);
    }

    public boolean isEnemyAt(int xTo, int yTo, PlayerColor pc) {
        return (board[xTo][yTo] != null && board[xTo][yTo].color() != pc);
    }

    /**
     * Checks if piece is at a specificed location.
     *
=======

    public boolean isFriendAt(int xTo, int yTo, PlayerColor pc) {
        return (board[xTo][yTo]!=null && board[xTo][yTo].color()==pc);
    }
    public boolean isEnemyAt(int xTo, int yTo, PlayerColor pc) {
        return (board[xTo][yTo]!=null && board[xTo][yTo].color()!=pc);
    } /**
     * Checks if piece is at a specificed location.
>>>>>>> 33427ae5bdfba07d64ca454828ad681b5ee528d0
     * @param x Row of the location.
     * @param y Col of the location.
     * @return Boolean of if theres a piece on location or not.
     */
    public boolean isOccupied(int x, int y) {
        return board[x][y] != null;
    }
<<<<<<< HEAD
=======
        void displayBoard() {

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[0].length; j++) {
                try {
                    System.out.print(board[j][i].toString());
                } catch(Exception e) {
                    System.out.print(" ");
                }
                System.out.print("|");
            }
            System.out.println("");
        }

        System.out.println("");


            }
>>>>>>> 33427ae5bdfba07d64ca454828ad681b5ee528d0

}
