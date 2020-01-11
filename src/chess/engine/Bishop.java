package chess.engine;

import chess.PieceType;
import chess.PlayerColor;

public class Bishop extends Piece{
    public Bishop(PlayerColor pc, int x, int y,ChessGame game) {
        super(PieceType.BISHOP, pc, x, y,game);
    }
@Override
    boolean move(int x,int y) {
        if (Math.abs(getX()- x) ==
                Math.abs(getY() - y)) {
            return  super.move(x, y) ;
        }
        return false;
    }
}
