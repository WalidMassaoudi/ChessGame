package chess.engine;

import chess.PieceType;
import chess.PlayerColor;

public class King extends Piece{
    private int castlingDirection=0;
    public King(PlayerColor pc, int x, int y, ChessGame game) {
        super(PieceType.KING, pc, x, y,game);
    }
@Override
    boolean move(int x,int y) {
        if (Math.abs(getX()- x) <= 1 &&
                Math.abs(getY() - y) <= 1) {
            if(!isFirstMove)
                this.isFirstMove=false;

            /* partie implimentée pour le castling mais ça marche pas*/
            /*******************************************************/
            if(castling(x,y)){
                if(y==0 && castlingDirection==1){
                    game.board.remove(7,0);
                    game.board.add(new Rook(pc,x+castlingDirection,y,game));
                    return super.move(x,y);
                }else if(y==0 && castlingDirection==-1){
                    game.board.remove(0,0);
                    game.board.add(new Rook(pc,x+castlingDirection,y,game));
                    return super.move(x,y);
                }else if(y==7 && castlingDirection==1) {
                    game.board.remove(7, 7);
                    game.board.add(new Rook(pc, x + castlingDirection, y, game));
                    return super.move(x, y);
                }else if(y==7 && castlingDirection==-1) {
                    game.board.remove(0, 7);
                    game.board.add(new Rook(pc, x + castlingDirection, y, game));
                    return super.move(x, y);
                }
                /***********************************************/
            }
            return  super.move(x,y);//ici on doit checker que la position dest est safe
        }
        return false;
    }
    /**
    ** fonction  test si on peut faire de castling
     */
  protected boolean castling(int x,int y){
            if(this.isFirstMove &&this.getY()==y && Math.abs(this.getX()-x)==2){
                if(y==0){
                    if(x<5){
                        if(game.board.get(0,0).isFirstMove)
                            castlingDirection=-1;
                            return true;
                    }else {
                        if(game.board.get(7,0).isFirstMove)
                            castlingDirection=1;
                            return true;
                    }
                }else if(y==7){
                    if(x<5){
                        if(game.board.get(0,7).isFirstMove)
                            castlingDirection=-1;
                            return true;
                    }else {
                        if(game.board.get(7,7).isFirstMove)
                            castlingDirection=1;
                            return true;
                    }
                }
            }
        return  false;
  }
}
