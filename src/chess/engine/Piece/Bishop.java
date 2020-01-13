package chess.engine.Piece;

import chess.PieceType;
import chess.PlayerColor;
import chess.engine.Board;
import chess.engine.ChessGame;

public class Bishop extends Piece{
    public Bishop(PlayerColor pc) {
        super(pc,PieceType.BISHOP);
    }
@Override
public boolean move(int fromX,int fromY,int toX,int toY,Board board) {
        if (Math.abs(fromX- toX) ==
                Math.abs(fromY - toY)) {
            return  super.move(fromX,fromY,toX, toY,board) ;
        }
        return false;
    }
    @Override public String textValue() {
        return "Bishop";
    }
}
