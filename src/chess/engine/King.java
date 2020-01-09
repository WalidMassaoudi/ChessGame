package chess.engine;

import chess.PieceType;
import chess.PlayerColor;

import java.util.Vector;

public class King extends Piece{

    public King(PlayerColor pc, int x, int y, Vector<Vector<Piece>> board) {
        super(PieceType.KING, pc, x, y,board);
    }
@Override
    boolean move(int x,int y) {
        if (Math.abs(getX()- x) <= 1 &&
                Math.abs(getY() - y) <= 1) {
            return  super.move(x,y);//ici on doit checker que la position dest est safe
        }
        return false;
    }

}
