package chess.engine;

import chess.PieceType;
import chess.PlayerColor;

public class Piece{
    private int x;
    private int y;
    private boolean alive;
    private PlayerColor pc;
    private PieceType pt;
    private Board board;

    public Piece( PieceType pt,PlayerColor pc, int x ,int y, Board board) {
        this.pc=pc;
        this.pt = pt;
        this.x= x;
        this.y=y;
        this.board = board;
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
    boolean move(int x,int y) {
        /*if(isOccupied(pc,x,y))
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
     * vérifier si la case souhaitée est occupée déja par une autre piece.
     * @param pc la couleur de la piece appelante.
     * @param toX l'indice x destination.
     * @param  toY lîndice y destination .
     */
    public  boolean isOccupied(PlayerColor pc,int toX,int toY){
        if(board.get(toX,toY).color()==pc){
            return true;
        }
        return  false;
    }

    public String toString() {
        return "x";
    }
}
