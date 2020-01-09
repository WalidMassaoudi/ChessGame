package chess.engine;

import chess.PieceType;
import chess.PlayerColor;

import java.util.Vector;

public class Rook extends Piece {

    public Rook(PlayerColor pc, int x, int y,Vector<Vector<Piece>> board) {
        super(PieceType.ROOK, pc, x, y,board);
    }
    @Override
    boolean move(int x,int y) {
        if(y == getY() || x == getX() ) {
            return super.move(x,y);
        } else {
            return false;
        }
    }
}
