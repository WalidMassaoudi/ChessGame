package chess.engine;

import chess.ChessController;
import chess.ChessView;
import chess.PlayerColor;
import chess.engine.Piece.*;

public class ChessGame implements ChessController{
    private ChessView view;
    public Board board;
    private PlayerColor current_player;
    /**
     * Permet de lancer la partie
     */
    public ChessGame() {
        board = new Board(PlayerColor.BLACK);
    }


    @Override public void start(ChessView view) {
        this.view = view;
        view.startView();
        current_player = PlayerColor.BLACK;

    }

    @Override public boolean move(int fromX, int fromY, int toX, int toY) {
        Piece p = board.get(fromX,fromY);
        if(p == null || p.color() != current_player) {
            return false;
        }

        if(p.move(fromX,fromY,toX,toY,board)) {
            if (p instanceof Pawn && ((Pawn) p)
                    .canPromote(toY)) { // TODO couleur (après tour joueur)
                p = view.askUser("Promotion", "Choisir la piece ",
                        new Rook(current_player), new Knight(current_player),
                        new Queen(current_player), new Bishop(current_player));
                board.add(p,toX,toY);
            }
            board.add(p,toX,toY);
            board.remove(fromX,fromY);
            updateView();//utilisé surtout pour Pawn prise en passant
            next_turn();
            return true;
        }
        return false;

    }
    private void next_turn() {
        current_player = current_player == PlayerColor.BLACK? PlayerColor.WHITE:PlayerColor.BLACK;
        view.displayMessage(current_player == PlayerColor.BLACK? "Black" : "White");
    }
    @Override public void newGame() {
        board.initBoard();
        updateView();

    }

    public void updateView() {
        for (int x = 0; x < 8; ++x) {
            for (int y = 0; y < 8; ++y) {
                Piece p = board.get(x, y);
                if(p != null) {
                    view.putPiece(p.type(), p.color(), x, y);
                } else {
                    view.removePiece(x,y);
                }
            }
        }
    }
}
