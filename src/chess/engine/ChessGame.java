package chess.engine;

import chess.ChessController;
import chess.ChessView;
import chess.PlayerColor;
import chess.engine.Piece.*;

public class ChessGame implements ChessController{
    private ChessView view;
<<<<<<< HEAD
    public Board board;
    private PlayerColor current_player;
    /**
     * Permet de lancer la partie
     */
    public ChessGame() {
        board = new Board(PlayerColor.BLACK);
=======
    public   Board board ;
   static  boolean isWhiteTurn=true;
    /**
     * Permet de lancer la partie
     */
    public ChessGame(){
        board=new Board();
    }
    private void addToBoard(Piece p) {
        view.putPiece(p.type(),p.color(),p.getX(),p.getY());
        board.add(p);
>>>>>>> 33427ae5bdfba07d64ca454828ad681b5ee528d0
    }

<<<<<<< HEAD
=======
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
>>>>>>> 33427ae5bdfba07d64ca454828ad681b5ee528d0

    @Override public void start(ChessView view) {
        this.view = view;
        view.startView();
<<<<<<< HEAD
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
=======
        newGame();
    }

    @Override public boolean move(int fromX, int fromY, int toX, int toY) {

        try {
        Piece p = board.get(fromX,fromY);

        //gestion de tour
        if(p.color()==PlayerColor.BLACK && isWhiteTurn)
            return false;
        if(p.color()==PlayerColor.WHITE && !isWhiteTurn)
            return false;

        if(p.move(toX,toY)) {
           if(p instanceof Pawn && ((Pawn)p).canPromote(toY)){
           //il manque d'afficher le message et faire la promotion
           }
            board.remove(toX,toY);
            board.remove(fromX,fromY);
            view.removePiece(fromX, fromY);
            updateView();//utilisé surtout pour Pawn prise en passant
            addToBoard(p);
            //gestion de tour
            if(p.color()==PlayerColor.WHITE && isWhiteTurn)
                isWhiteTurn=false;
            if(p.color()==PlayerColor.BLACK && !isWhiteTurn)
                isWhiteTurn=true;

>>>>>>> 33427ae5bdfba07d64ca454828ad681b5ee528d0
            return true;
        }
        return false;

    }
    private void next_turn() {
        current_player = current_player == PlayerColor.BLACK? PlayerColor.WHITE:PlayerColor.BLACK;
        view.displayMessage(current_player == PlayerColor.BLACK? "Black" : "White");
    }
    @Override public void newGame() {
<<<<<<< HEAD
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
=======
        isWhiteTurn =true;
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
    static boolean getTurn(){
        return isWhiteTurn;
    }
>>>>>>> 33427ae5bdfba07d64ca454828ad681b5ee528d0
}
