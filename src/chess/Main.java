package chess;


import chess.engine.ChessGame;
import chess.views.gui.*;




public class Main {
    public static void main(String[] args) {
        ChessController controller = new ChessGame();
        ChessView view = new GUIView(controller);
        controller.start(view);

    }

}