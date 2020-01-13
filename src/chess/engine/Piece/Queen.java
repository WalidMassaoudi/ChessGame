package chess.engine.Piece;

import chess.PieceType;
import chess.PlayerColor;
import chess.engine.Board;
import chess.engine.ChessGame;

public class Queen extends Piece{
    public Queen(PlayerColor pc) {
        super(pc,PieceType.QUEEN);
    }
@Override
public boolean move(int fromX,int fromY,int toX,int toY,Board board) {
        //la condition de move pour la pièce Queen et la combinaison entre le move de Bishop et Rook.
        if(toY == fromY|| toX == fromX
                || Math.abs(fromX- toX) == Math.abs(fromY - toY)){
            return  super.move(fromX,fromY,toX, toY,board) ;
        }

        return false;
    }
    @Override public String textValue() {
        return "Queen";
    }
}