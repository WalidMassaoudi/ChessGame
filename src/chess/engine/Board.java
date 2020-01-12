package chess.engine;

import chess.PlayerColor;

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
    void initBoard(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j]=null;
            }
        }
    }

    void add(Piece p) {
        board[p.getX()][p.getY()] = p;
        displayBoard();
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
    /**
     * vérifier si la case souhaitée est occupée déja par une autre piece.
     *
     * @param pc  la couleur de la piece appelante.
     * @param xTo l'indice x destination.
     * @param yTo l'indice y destination .
     */

    public boolean isFriendAt(int xTo, int yTo, PlayerColor pc) {
        return (board[xTo][yTo]!=null && board[xTo][yTo].color()==pc);
    }
    public boolean isEnemyAt(int xTo, int yTo, PlayerColor pc) {
        return (board[xTo][yTo]!=null && board[xTo][yTo].color()!=pc);
    } /**
     * Checks if piece is at a specificed location.
     * @param x Row of the location.
     * @param y Col of the location.
     * @return Boolean of if theres a piece on location or not.
     */
    public boolean isOccupied(int x, int y) {
        return board[x][y] != null;
    }
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

}
