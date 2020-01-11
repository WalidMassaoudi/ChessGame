package chess.engine;

import chess.PieceType;
import chess.PlayerColor;

public class Piece {
    private int x;
    private int y;
    private boolean alive;
    protected PlayerColor pc;
    protected PieceType pt;
    protected  ChessGame game;

    public Piece(PieceType pt, PlayerColor pc, int x, int y,ChessGame g) {
        game=g;
        this.pc = pc;
        this.pt = pt;
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean move(int x, int y) {
        if (game.board.isFriendAt(x, y,pc))
            return false;
        /*if(!checkTheLine(getX(),getY(),x,y))
            return false;*/
        this.x = x;
        this.y = y;
        return true;
    }

    void die() {
        alive = false;
    }

    PlayerColor color() {
        return this.pc;
    }

    PieceType type() {
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
        if (pc == PlayerColor.WHITE) {
            //PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING
            if (pt == PieceType.PAWN)
                return "P";
            if (pt == PieceType.ROOK)
                return "R";
            if (pt == PieceType.KNIGHT)
                return "N";
            if (pt == PieceType.BISHOP)
                return "B";
            if (pt == PieceType.QUEEN)
                return "Q";
            if (pt == PieceType.KING)
                return "K";
            else
                return " ";
        } else if (pc == PlayerColor.BLACK) {
            //PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING
            if (pt == PieceType.PAWN)
                return "p";
            if (pt == PieceType.ROOK)
                return "r";
            if (pt == PieceType.KNIGHT)
                return "n";
            if (pt == PieceType.BISHOP)
                return "b";
            if (pt == PieceType.QUEEN)
                return "q";
            if (pt == PieceType.KING)
                return "k";
            else
                return " ";
        } else {
            return " ";
        }
    }
}
