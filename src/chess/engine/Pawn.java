package chess.engine;

import chess.PieceType;
import chess.PlayerColor;

public class Pawn extends Piece {
    private boolean isFirstMove;
    private int direction;//les pions noir se déplacent vers le bas mais les blancs se déplacent vers le haut.

    public Pawn(PlayerColor pc, int x, int y, Board board) {
        super(PieceType.PAWN, pc, x, y, board);
        isFirstMove = true;
        if (pc == PlayerColor.BLACK) {
            direction = -1;
        } else if(pc == PlayerColor.WHITE){
            direction = 1;
        }
    }
@Override
    boolean move(int x, int y) {
        if (getY() == y) {
            if (x - getX() == direction) {
                if (isFirstMove) {
                    isFirstMove = false;
                    return super.move(x, y);
                }

            } else if (isFirstMove && (x - getX() == (direction * 2))) {
                isFirstMove = false;
                return super.move(x, y);
            }
        } else if (Math.abs(y - getY()) == 1) {//se déplacer à coté
            if (x - getX() == direction) {
                if (isFirstMove) {
                    isFirstMove = false;
                }
                return super.move(x, y);
            }
        }
        return false;
    }

    public String toString() {
        return "P";
    }
}