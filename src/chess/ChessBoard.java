package chess;

import chess.engine.Piece;

import java.util.Vector;

public class ChessBoard {
   private Vector<Vector<Piece>> board;

   public ChessBoard(){
      board =new Vector<>(8);
   }
}
