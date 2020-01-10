package chess.engine;

import chess.PieceType;
import chess.PlayerColor;

public class Rook extends Piece {

    public Rook(PlayerColor pc, int x, int y,Board board) {
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
