package chess.engine.Piece;

import chess.PieceType;
import chess.PlayerColor;
import chess.engine.Board;
import chess.engine.ChessGame;

public class Rook extends Piece {

    public Rook(PlayerColor pc) {
        super(pc,PieceType.ROOK);
    }
    @Override
    public boolean move(int fromX,int fromY,int toX,int toY,Board board) {
        if (toY == fromY|| toX == fromX) {
            return  super.move(fromX,fromY,toX,toY,board) ;

        }
        return false;
    }

    @Override public String textValue() {
        return "Rook";
    }
}
