package edu.wofford;
import java.lang.StringBuilder;

public class TicTacToeModel {

    public enum Mark { EMPTY, XMARK, OMARK };
    public enum Result { XWIN, OWIN, TIE, NONE };

    private Mark[][] _board;
    private boolean _xTurn = true;
    private int _numMarks = 0;

    public TicTacToeModel() {
        _board = new Mark[3][3];
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                _board[i][j] = Mark.EMPTY;
            }
        }
    }
    
    public boolean setMarkAt(int row, int col) {
        if(_board[col][row] == Mark.EMPTY && getResult() == Result.NONE){
            if(_xTurn){
                _board[col][row] = Mark.XMARK;
                _xTurn = false;
            } else {
                _board[col][row] = Mark.OMARK;
                _xTurn = true;
            }
            _numMarks++;
            return true;
        } else {
            return false;
        }
    }
    
    public Mark getMarkAt(int row, int col) {
        return _board[col][row];
    }

    private Result getResultHelperColumnRow(){
        for(int i = 0; i < 3; i++){
            if(_board[i][0] == _board[i][1] && _board[i][1] == _board[i][2]){
                if(_board[i][0] == Mark.XMARK){
                    return Result.XWIN;
                } else if (_board[i][0] == Mark.OMARK){
                    return Result.OWIN;
                }
            }
            if(_board[0][i] == _board[1][i] && _board[1][i] == _board[2][i]){
                if(_board[0][i] == Mark.XMARK){
                    return Result.XWIN;
                } else if (_board[0][i] == Mark.OMARK) {
                    return Result.OWIN;
                }
            }
        }
        return Result.NONE;
    }

    private Result getResultHelperDiagonal(){
        if(_board[0][0] == _board[1][1] && _board[1][1] == _board[2][2]){
            if(_board[0][0] == Mark.XMARK) {
                return Result.XWIN;
            } else if (_board[0][0] == Mark.OMARK){
                return Result.OWIN;
            }
        }
        if(_board[0][2] == _board[1][1] && _board[1][1] == _board[2][0]){
            if(_board[0][2] == Mark.XMARK) {
                return Result.XWIN;
            } else if (_board[0][2] == Mark.OMARK){
                return Result.OWIN;
            }
        }
        return Result.NONE;
    }

    private Result getResultHelperTie() {
        if (_numMarks == 9) {
            return Result.TIE;
        } else {
            return Result.NONE;
        }
    }

    public Result getResult() {
        Result columnRowResult = getResultHelperColumnRow();
        Result diagonalResult = getResultHelperDiagonal();
        Result tieResult = getResultHelperTie();

        if(columnRowResult != Result.NONE){
            return columnRowResult;
        }
        else if(diagonalResult != Result.NONE){
            return diagonalResult;
        }
        else{
            return tieResult;
        }
    }

    private String toStringHelper(Mark mark){
        if(mark == Mark.XMARK){
            return "X";
        } else if (mark == Mark.OMARK){
            return "O";
        } else {
            return " ";
        }
    }
    public String toString() {
        StringBuilder string = new StringBuilder();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                string.append(toStringHelper(getMarkAt(i,j)));
                if(j == 0 || j == 1){
                    string.append("|");
                }
            }
            if(i == 0 || i == 1){
                string.append("\n-----\n");
            }
        }
        return string.toString();
    }    

}