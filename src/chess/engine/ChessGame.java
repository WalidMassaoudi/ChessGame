package chess.engine;

import chess.ChessController;
import chess.ChessView;
import chess.PieceType;
import chess.PlayerColor;


import java.util.Vector;

public class ChessGame implements ChessController{
    private ChessView view;
    public   Board board ;

    /**
     * Permet de lancer la partie
     */
    public ChessGame(){
        board=new Board();
    }
    private void addToBoard(Piece p) {
        view.putPiece(p.type(),p.color(),p.getX(),p.getY());
        board.add(p);
    }
    private void initFirstLine(PlayerColor color, int line){

        addToBoard(new Rook(  color, 0, line,this));
        addToBoard(new Knight( color, 1, line,this));
        addToBoard(new Bishop( color, 2, line,this
        ));
        if(color == PlayerColor.BLACK) {
            addToBoard(new Queen(color, 3, line,this));
            addToBoard(new King(color, 4, line,this));
        } else {
            addToBoard(new Queen(color, 4, line,this));
            addToBoard(new King( color, 3, line,this));
        }
        addToBoard(new Bishop( color, 5, line,this));
        addToBoard(new Knight(  color, 6, line,this));
        addToBoard(new Rook(  color, 7, line,this));
    }

    @Override public void start(ChessView view) {
        this.view = view;
        view.startView();
        newGame();
    }

    @Override public boolean move(int fromX, int fromY, int toX, int toY) {
        try {
        Piece p = board.get(fromX,fromY);
        if(p.move(toX,toY)) {
           if(p instanceof Pawn && ((Pawn)p).canPromote(toY)){
           //il manque d'afficher le message et faire la promotion
           }
            board.remove(toX,toY);
            board.remove(fromX,fromY);
            view.removePiece(fromX, fromY);
            updateView();//utilisé surtout pour Pawn prise en passant
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
        board.initBoard();
        initFirstLine(PlayerColor.WHITE,0);
        initFirstLine(PlayerColor.BLACK,7);
        for (int i = 0; i < 8; i++) {
            addToBoard(new Pawn(PlayerColor.WHITE,i,1,this));
            addToBoard(new Pawn(PlayerColor.BLACK,i,6,this));
        }
    }
    public void updateView() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board.get(i,j)== null)
                    view.removePiece(i,j);
            }
        }
    }
}
