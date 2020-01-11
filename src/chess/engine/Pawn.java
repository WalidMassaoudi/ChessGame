package chess.engine;

import chess.PieceType;
import chess.PlayerColor;

public class Pawn extends Piece {
    private boolean isFirstMove;
    private int direction;//les pions noir se déplacent vers le bas mais les blancs se déplacent vers le haut.
    public boolean isInPassing = false;
    public Pawn(PlayerColor pc, int x, int y,ChessGame game) {
        super(PieceType.PAWN, pc, x, y, game);
        isFirstMove = true;
        if (pc == PlayerColor.BLACK) {
            direction = -1;
        } else if(pc == PlayerColor.WHITE){
            direction = 1;
        }
    }
@Override
    boolean move(int x, int y) {
        if (getX() == x) {
            if (y - getY() == direction) {
                if (isFirstMove)
                    isFirstMove = false;
                    return super.move(x, y);

            }else if (isFirstMove && (y - getY() == (direction * 2))) {
                isFirstMove = false;
                isInPassing=true;
                 return  super.move(x, y) ;
            }
        } else if (Math.abs(x - getX()) == 1 && game.board.isEnemyAt(x,y,pc) ) {//se déplacer à coté
            if (y - getY() == direction) {
                if (isFirstMove) {
                    isFirstMove = false;
                }
                return super.move(x, y);
            }
        }else if((captureInPassing(getX()-1,getY())||captureInPassing(getX()+1,getY())) &&
                (Math.abs(x - getX()) == 1 && game.board.get(x,y)==null )){
              game.board.remove(x,y-1);
             return super.move(x, y);
    }
        return false;
    }
    /**
     * Checks if the pawn can capture another pawn by en passant
     * @param x location of the other pawn
     * @return true if can be captured
     */
    private boolean captureInPassing( int x,int y) {
        Piece p = game.board.get(x,y);
        if(p != null)
            if (p instanceof Pawn && p.color() !=pc)
                if (((Pawn)p).isInPassing)
                    return true;
        return false;
    }
    public boolean canPromote(int yTo) {
        //pion noir attient le niveau bas de board
        if(pc == PlayerColor.BLACK)
            return yTo == 0;
        //pion noir attient le niveau haut de board
        if(pc== PlayerColor.WHITE)
            return yTo == 7;
        return false;
    }
}