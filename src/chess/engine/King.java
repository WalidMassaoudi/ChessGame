package chess.engine;

import chess.PieceType;
import chess.PlayerColor;

public class King extends Piece{

    public King(PlayerColor pc, int x, int y, Board board) {
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

    public String toString() {
        return "K";
    }

}
