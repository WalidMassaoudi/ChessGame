package chess.engine;

import chess.ChessView;
import chess.views.gui.GUIView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessGameTest {

    private Board b;
    @BeforeEach void setUp() {
        b = new Board();
        ChessGame cg = new ChessGame();
        ChessView view = new GUIView(cg);
        cg.start(view);
        cg.newGame();;
    }

    @Test void start() {
    }

    @Test void move() {
    }

    @Test void newGame() {
    }
}