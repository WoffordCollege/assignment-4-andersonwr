package edu.wofford;


public class TicTacToeModel {

    public enum Mark { EMPTY, XMARK, OMARK };
    public enum Result { XWIN, OWIN, TIE, NONE };

    public TicTacToeModel() {

    }
    
    public boolean setMarkAt(int row, int col) {
        return false;
    }
    
    public Mark getMarkAt(int row, int col) {
        return Mark.EMPTY;
    }

    public Result getResult() {
        return Result.NONE;
    }
    
    public String toString() {
        return "";
    }    

}