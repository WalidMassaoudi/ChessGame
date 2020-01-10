package chess.engine;

import chess.PieceType;
import chess.PlayerColor;

public class Queen extends Piece{
    public Queen(PlayerColor pc, int x, int y, Board board) {
        super(PieceType.QUEEN, pc, x, y,board);
    }
@Override
    boolean move(int x,int y) {
        //la condition de move pour la pièce Queen et la combinaison entre le move de Bishop et Rook.
        if(y == getY() || x == getX()
                || Math.abs(getX()- x) == Math.abs(getY() - y))
                return super.move(x, y);
        return false;
    }
}