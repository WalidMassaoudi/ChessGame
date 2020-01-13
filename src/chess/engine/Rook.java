package chess.engine;

import chess.PieceType;
import chess.PlayerColor;

public class Rook extends Piece {

    public Rook(PlayerColor pc, int x, int y,ChessGame game) {
        super(PieceType.ROOK, pc, x, y,game);
    }
    @Override
    boolean move(int x,int y) {
        if (y == getY() || x == getX()) {
            if(!isFirstMove)
                this.isFirstMove=false;
            return  super.move(x, y) ;
        }
        return false;
    }
}
