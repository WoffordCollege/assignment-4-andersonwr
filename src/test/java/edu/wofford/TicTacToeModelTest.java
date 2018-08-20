package edu.wofford;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeModelTest {
	private TicTacToeModel model;
    
    @Before
    public void setUp() {
        model = new TicTacToeModel();
    }
    
    @Test
	public void testInitialBoardIsEmpty() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                assertEquals(TicTacToeModel.Mark.EMPTY, model.getMarkAt(i, j));
            }
        }
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
        model.setMarkAt(0, 2);
        assertEquals(TicTacToeModel.Mark.XMARK, model.getMarkAt(0, 2));
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
        model.setMarkAt(0, 2);
        model.setMarkAt(2, 0);
        assertEquals(TicTacToeModel.Mark.OMARK, model.getMarkAt(2, 0));
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
        model.setMarkAt(0, 2);
        assertEquals(TicTacToeModel.Mark.XMARK, model.getMarkAt(0, 2));
        model.setMarkAt(0, 2);
        assertEquals(TicTacToeModel.Mark.XMARK, model.getMarkAt(0, 2));
        model.setMarkAt(2, 0);
        assertEquals(TicTacToeModel.Mark.OMARK, model.getMarkAt(2, 0));
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
        model.setMarkAt(0, 2);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
	}
	
    @Test
    public void testToStringWorksCorrectly() {
        String board = " | |O\n-----\nX|X| \n-----\n | |O";
        model.setMarkAt(1, 1);
        model.setMarkAt(2, 2);
        model.setMarkAt(1, 0);
        model.setMarkAt(0, 2);
        assertEquals(board, model.toString());
    }
    
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
        model.setMarkAt(0, 0);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(1, 1);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(0, 1);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(1, 0);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(0, 2);
        assertEquals(TicTacToeModel.Result.XWIN, model.getResult());
	}
	
	@Test
	public void testGameIsWonByOVerticallyAcrossMiddleColumn() {
        model.setMarkAt(0, 0);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(1, 1);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(1, 2);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(0, 1);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(0, 2);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(2, 1);
        assertEquals(TicTacToeModel.Result.OWIN, model.getResult());
	}
	
	@Test
	public void testGameIsWonByXReverseDiagonally() {
        model.setMarkAt(2, 0);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(1, 0);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(1, 1);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(0, 0);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(0, 2);
        assertEquals(TicTacToeModel.Result.XWIN, model.getResult());
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
        model.setMarkAt(0, 0);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(0, 1);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(0, 2);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(2, 0);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(2, 1);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(2, 2);
        model.setMarkAt(1, 0);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(1, 1);
        assertEquals(TicTacToeModel.Result.NONE, model.getResult());
        model.setMarkAt(1, 2);
        assertEquals(TicTacToeModel.Result.TIE, model.getResult());
	}
	
	@Test
	public void testNoNewMarksAfterGameIsOver() {
	    model.setMarkAt(0, 0);
	    model.setMarkAt(0, 1);
	    model.setMarkAt(1, 1);
	    model.setMarkAt(0, 2);
	    model.setMarkAt(2, 2);
        assertEquals(TicTacToeModel.Result.XWIN, model.getResult());
	    assertEquals(TicTacToeModel.Mark.EMPTY, model.getMarkAt(2, 0));
	    model.setMarkAt(2, 0);
	    assertEquals(TicTacToeModel.Mark.EMPTY, model.getMarkAt(2, 0));
	}
    
}