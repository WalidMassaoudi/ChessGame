package chess.engine;

import chess.PieceType;
import chess.PlayerColor;

import java.util.Vector;

public class Knight extends Piece{

    public Knight(PlayerColor pc, int x, int y,Vector<Vector<Piece>> board) {
        super(PieceType.KNIGHT, pc, x, y,board);
    }
    public boolean move(int x, int y) {
       if((Math.abs(getX() - x ) == 1 && Math.abs(getY() - y) == 2) ||
               (Math.abs(getX() - x ) == 2 && Math.abs(getY() - y) == 1)) {
           return super.move(x,y);
       }
       else {
           return false;
       }
    }
}
