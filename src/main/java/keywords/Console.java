package keywords;


import java.io.*;
import java.util.*;
import java.util.regex.*;
import edu.wofford.*;


public class Console {
    private String inputString;
    private String outputString;

    public void theGameHasStarted() {
        inputString = "";
        outputString = "";
    }
    
    public void thePlayerMarks(Integer int1, Integer int2) {
        inputString += int1 + " " + int2 + "\n";
    }
    
    public void thePlayerViewsTheBoard() {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        try {
            System.setIn(new ByteArrayInputStream(inputString.getBytes()));
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            try {
                ConsoleMain.main(null);
            } catch (NoSuchElementException e) { }
            outputString = outContent.toString();
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    private String getLastGrid(String s) {
        String regex = "(?s).*[ XO]\\|[ XO]\\|[ XO]\\R-----\\R[ XO]\\|[ XO]\\|[ XO]\\R-----\\R[ XO]\\|[ XO]\\|[ XO]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        String value = "";
        if (matcher.find()) {
            value = matcher.group().substring(matcher.end() - 29, matcher.end());
        }
        return value;
    }

    private String getLocationAt(String s, int row, int col) {
        int charnum = row * 12 + col * 2;
        return s.substring(charnum, charnum + 1);
    }
    
    public String getMarkAtLocation(Integer int1, Integer int2) {
        String lastGrid = getLastGrid(outputString);
        return getLocationAt(lastGrid, int1, int2);
    }

    public String getGameResult() {
        String s = outputString.trim();
        return s.substring(s.lastIndexOf("\n"));
    }
}