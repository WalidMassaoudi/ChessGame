package chess.engine;

import chess.PieceType;
import chess.PlayerColor;

public  class Piece {
    private int x;
    private int y;
    private boolean alive;
    protected boolean isFirstMove=true;

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
     * méthode pour vérifier si le chemein est vide vers l'emplacement x,y
     * il marche pas à corriger
     *
     */
    protected boolean cleanWayTo(int xTo,int yTo) {
        //vertical
        if (this.x == xTo) {
            int direction ;
                    if(getY() - yTo < 0)
                        direction =1;
                    else
                        direction=-1;
            for (int i = this.y + direction; i < yTo; i += direction) {
                if (game.board.get(x,i)!=null){
                    return false;
                }
            }
            return true;
        }
        // Horizontal
        if (this.y== yTo) {
            int one = (getX() - xTo < 0) ? 1: -1;
            for (int col = getX() + one; col < xTo; col += one) {
                if (game.board.get(col,y)!=null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

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
