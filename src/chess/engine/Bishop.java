package chess.engine;

import chess.PieceType;
import chess.PlayerColor;

import java.util.Vector;

public class Bishop extends Piece{
    public Bishop(PlayerColor pc, int x, int y, Vector<Vector<Piece>> board) {
        super(PieceType.BISHOP, pc, x, y,board);
    }
@Override
    boolean move(int x,int y) {
        if (Math.abs(getX()- x) ==
                Math.abs(getY() - y)) {
            return  super.move(x,y);
        }
        return false;
    }
}
