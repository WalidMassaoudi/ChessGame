package chess.engine;

import chess.ChessController;
import chess.ChessView;
import chess.PieceType;
import chess.PlayerColor;

import java.util.Vector;

public class ChessGame implements ChessController{
    private ChessView view;
    private Vector<Vector<Piece>>  board = new Vector<>(8);
    /**
     * Permet de lancer la partie
     */
    private void init() {

        for(int i = 0; i < 8; ++i) {
            this.board.add(new Vector<>(8));
            for (int j = 0; j < 8; j++) {
            this.board.get(i).add(null);
            }
        }
       initFirstLine(PlayerColor.WHITE,0);
       initFirstLine(PlayerColor.BLACK,7);
        for (int i = 0; i < 8; i++) {
            addToBoard(new Pawn(PlayerColor.WHITE,i,1,board));
            addToBoard(new Pawn(PlayerColor.BLACK,i,6,board));
        }
    }
    private void addToBoard(Piece p) {
        view.putPiece(p.type(),p.color(),p.getX(),p.getY());
        board.get(p.getX()).add(p.getY(),p);
    }
    private void initFirstLine(PlayerColor color, int line){

        addToBoard(new Rook(  color, 0, line,board));
        addToBoard(new Knight( color, 1, line,board));
        addToBoard(new Bishop( color, 2, line,board));
        if(color == PlayerColor.BLACK) {
            addToBoard(new Queen(color, 3, line,board));
            addToBoard(new King(color, 4, line,board));
        } else {
            addToBoard(new Queen(color, 4, line,board));
            addToBoard(new King( color, 3, line,board));
        }
        addToBoard(new Bishop( color, 5, line,board));
        addToBoard(new Knight(  color, 6, line,board));
        addToBoard(new Rook(  color, 7, line,board));
    }

    @Override public void start(ChessView view) {
        this.view = view;
        view.startView();
        init();
    }

    @Override public boolean move(int fromX, int fromY, int toX, int toY) {
        try {
        Piece p = board.get(fromX).get(fromY);
        if(p.move(toX,toY)) {
           // board.get(fromX).remove(fromY); remplacer par l'instruction suivante
            board.get(fromX).setElementAt(null,fromY);
            view.removePiece(fromX, fromY);
            //p.move(toX, toY); duplication déja tester dans le if
            addToBoard(p);
            return true;
        } else {
            return false;
        }
         }
        catch(NullPointerException np) {
            return false;
        }
    }

    @Override public void newGame() {
             init();
    }
    /*
    public  void printBoard(){
        for (int i = 0; i < 8; i++) {
            System.out.println("[");
            for (int j = 0; j < 8; j++) {
                if(this.board.get(i).get(j)==null)
                    System.out.println("0");
                else {
                    System.out.println("X");
                }
            }
            System.out.println("]\n");
        }
    }

     */

}
