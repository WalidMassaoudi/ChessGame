package chess.engine;

import chess.PieceType;
import chess.PlayerColor;

import java.util.Vector;

public class Piece{
    private int x;
    private int y;
    private boolean alive;
    private PlayerColor pc;
    private PieceType pt;
    private Vector<Vector<Piece>> board;

    public Piece( PieceType pt,PlayerColor pc, int x ,int y, Vector<Vector<Piece>> board) {
        this.pc=pc;
        this.pt = pt;
        this.x= x;
        this.y=y;
    }
    int getX() {
        return x;
    }
    int getY() {
        return y;
    }
    void setPos(int x, int y) {
        this.x = x;
        this.y=y;
    }
    boolean move(int x,int y) {
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
}
