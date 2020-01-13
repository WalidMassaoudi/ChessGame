package chess.engine.Piece;

import chess.PieceType;
import chess.PlayerColor;
import chess.engine.Board;
import chess.engine.ChessGame;

public class Knight extends Piece{

    public Knight(PlayerColor pc) {
        super(pc,PieceType.KNIGHT);
    }
    public boolean move(int fromX,int fromY,int toX,int toY,Board board) {
       if((Math.abs(fromX -toX ) == 1 && Math.abs(fromY - toY) == 2) ||
               (Math.abs(fromX - toX ) == 2 && Math.abs(fromY - toY) == 1)) {
           return super.move(fromX,fromY,toX,toY,board);
       }
       else {
           return false;
       }
    }
    @Override public String textValue() {
        return "Knight";
    }
}
