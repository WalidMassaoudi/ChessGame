package test;

import chess.PlayerColor;
import chess.engine.Board;
import chess.engine.Knight;
import chess.engine.Piece;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test void test_move() {
        Knight k = new Knight(PlayerColor.BLACK,0,0,new Board());
        // invalide move
        assert(!k.move(0,0));

        assert(!k.move(0,-1));
        assert(!k.move(0,-2));
        assert(!k.move(0,1));
        assert(!k.move(0,2));

        assert(!k.move(1,0));
        assert(!k.move(1,1));
        assert(!k.move(1,-1));
        assert(!k.move(1,3));
        assert(!k.move(2,2));
        assert(!k.move(2,0));


        // valid move
        assert(k.move(1,2));
        Knight k1 = new Knight(PlayerColor.BLACK,0,0,new Board());
        assert(k1.move(2,1));
        Knight k2 = new Knight(PlayerColor.BLACK,0,0,new Board());
        assert(k2.move(-1,2));
        Knight k3 = new Knight(PlayerColor.BLACK,0,0,new Board());
        assert(k3.move(-2,1));
    }
}