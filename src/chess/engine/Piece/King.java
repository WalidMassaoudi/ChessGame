package chess.engine.Piece;

import chess.PieceType;
import chess.PlayerColor;
import chess.engine.Board;
import chess.engine.ChessGame;

public class King extends Piece{

    public King(PlayerColor pc) {
        super(pc,PieceType.KING);
    }
@Override
public boolean move(int fromX,int fromY,int toX,int toY,Board board) {
        if (Math.abs(fromX- toX) <= 1 &&
                Math.abs(fromY - toY) <= 1) {
            return  super.move(fromX,fromY,toX, toY,board) ;//TODO ici on doit checker que la position dest est safe
        }
        return false;
    }
    @Override public String textValue() {
        return "King";
    }
}
