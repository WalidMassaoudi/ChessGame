package chess.engine.Piece;

import chess.PieceType;
import chess.PlayerColor;
import chess.engine.Board;

public class Pawn extends Piece {
    private boolean isFirstMove;
    private int direction;//les pions noir se déplacent vers le bas mais les blancs se déplacent vers le haut.
    private boolean isInPassing = false;

    public Pawn(PlayerColor pc, PlayerColor top_player) {
        super(pc, PieceType.PAWN);
        isFirstMove = true;
        if (pc == top_player) {
            direction = 1;
        } else if (pc != top_player) {
            direction = -1;
        }

    }

    @Override public boolean move(int fromX, int fromY, int toX, int toY,
            Board board) {
        if (fromX == toX) {
            if (toY - fromY == direction) {
                if (isFirstMove)
                    isFirstMove = false;
                return super.move(fromX, fromY, toX, toY, board);

            } else if (isFirstMove && (toY - fromY == (direction * 2))) {
                isFirstMove = false;
                isInPassing = true;
                return super.move(fromX, fromY, toX, toY, board);
            }
        } else if (Math.abs(toX - fromX) == 1 && board
                .isEnemyAt(toX, toY, pc)) {//se déplacer à coté
            if (toY - fromY == direction) {
                if (isFirstMove) {
                    isFirstMove = false;
                }
                return super.move(fromX, fromY, toX, toY, board);
            }
        } else if (
                (captureInPassing(fromX - 1, fromY, board) || captureInPassing(
                        fromX + 1, fromY, board)) &&
                        // TODO peut créer une array out of bound exception
                        (Math.abs(toX - fromX) == 1
                                && board.get(toX, toY) == null)) {
            board.remove(toX, toY - 1);
            return super.move(fromX, fromY, toX, toY, board);
        }
        return false;
    }

    /**
     * Checks if the pawn can capture another pawn by en passant
     *
     * @param x location of the other pawn
     * @return true if can be captured
     */
    private boolean captureInPassing(int x, int y, Board board) {
        Piece p = board.get(x, y);
        if (p != null)
            if (p instanceof Pawn && p.color() != pc)
                return ((Pawn) p).isInPassing;
        return false;
    }

    //TODO adapter pour que suivant le top_player et bottom_player on calcule juste
    public boolean canPromote(int yTo) {
        //pion noir attient le niveau bas de board
        if (pc == PlayerColor.BLACK)
            return yTo == 0;
        //pion noir attient le niveau haut de board
        if (pc == PlayerColor.WHITE)
            return yTo == 7;
        return false;
    }

    @Override public String textValue() {
        return "Pawn";
    }
}