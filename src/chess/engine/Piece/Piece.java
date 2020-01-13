package chess.engine.Piece;

import chess.ChessView;
import chess.PieceType;
import chess.PlayerColor;
import chess.engine.Board;
import chess.engine.ChessGame;

public abstract class Piece implements ChessView.UserChoice {
    private int x;
    private int y;
    private boolean alive;
    PlayerColor pc; // TODO changer et mettre getter -> pas sur que facon elegente de faire les moves
    PieceType pt;


    public Piece(PlayerColor pc,PieceType pt) {
        this.pc = pc;
        this.pt = pt;
    }



    public boolean move(int fromX, int fromY, int toX, int toY,Board board) {
        if (board.isFriendAt(toX, toY,pc))
            return false;
        /*if(!checkTheLine(getX(),getY(),x,y))
            return false;*/
        this.x = toX;
        this.y = toY;
        return true;
    }


    public PlayerColor color() {
        return this.pc;
    }


    public PieceType type() {
        return this.pt;
    }
    /**
     * Checks for the line of sight of the move.
     * @param
     * @param
     * @return

     */
    /*
    protected boolean checkTheLine(int xTo,int yTo){
        // Vertical
        if (y == yTo) {
            int one= (x - xTo < 0) ? 1: -1;
            for (int row = x + one; row < xTo; row += one) {
                if (game.board.isOccupied(row, y)) {
                    return false;
                }
            }
            return true;
        }
        // Horizontal
        if (x == xTo) {
            int one = (y - yTo < 0) ? 1: -1;
            for (int col = y+ one; col < yTo; col += one) {
                if (game.board.isOccupied(x, col)) {
                    return false;
                }
            }
            return true;
        }
        // Diagonal
        // Case 1 : Slope -1
        // Case 2 : Slope 1
        int xFrom=x;
        int yFrom=y;
        if (yFrom - yTo ==

                xFrom - xTo) {

            int one = (xFrom - xTo < 0) ? 1: -1;
            for (int inc = one; Math.abs(inc) < Math.abs(xFrom - xTo); inc += one) {
                if (game.board.isOccupied(xFrom + inc, yFrom + inc)) {
                    return false;
                }
            }
            return true;
        } else if (yFrom - yTo * -1 ==
                xFrom - yTo) {

            int one = (xFrom - xTo < 0) ? 1: -1;
            int negOne = one * -1;
            for (int inc = one; Math.abs(inc) < Math.abs(xFrom - xTo); inc += one) {
                if (game.board.isOccupied(xFrom + inc, yFrom + (inc * negOne))) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
*/

    public String toString() {
        return this.textValue();
    }


}
