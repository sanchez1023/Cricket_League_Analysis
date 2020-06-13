import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.List;

public class LeagueAnalyzerTest {

    private static final String BATTING_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WRONG_BATTING_CSV_FILE_PATH = "/home/admin1/Documents/CricketLeagueAnalyzer/src/main/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WRONG_BATTING_CSV_FILE_TYPE = "./src/test/resources/IPL2019FactsheetMostRuns.txt";
    private static final String BATTING_CSV_FILE_WITH_WRONG_DELIMETER = "./src/test/resources/IPL2019FactsheetMostRunsDelimeter.csv";
    @Test
    public void givenBattingCsvFile_ShouldReturnCsvFileData() throws IOException ,CSVBuilderException  {
        try {

            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            int numberOfRecords = cricketAnalyzer.loadBattingData(BATTING_CSV_FILE_PATH);
            Assert.assertEquals(101, numberOfRecords);
        }
        catch (CricketAnalyzerException e){

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void givenBattingCSVFile_WithWrongFilePath_ShouldThrowException() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketAnalyzerException.class);
            cricketAnalyzer.loadBattingData(WRONG_BATTING_CSV_FILE_PATH);
        } catch (CricketAnalyzerException e){
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.BATTING_CSV_FILE_PROBLEM, e.type);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenBattingCSVFile_WithWrongFileType_ShouldThrowException() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketAnalyzerException.class);
            cricketAnalyzer.loadBattingData(WRONG_BATTING_CSV_FILE_TYPE);
        } catch (CricketAnalyzerException e){
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.BATTING_CSV_FILE_PROBLEM, e.type);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenBattingCSVFile_WithWrongDelimeter_ShouldThrowException() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketAnalyzerException.class);
            cricketAnalyzer.loadBattingData(BATTING_CSV_FILE_WITH_WRONG_DELIMETER);
        } catch (CricketAnalyzerException e) {
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA, e.type);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenBattingCSVFile_WhenSortedOnAvg_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadBattingData(BATTING_CSV_FILE_PATH);
            List<IPLBattingCSV> avgWiseSortedData = cricketAnalyzer.getAvgWiseSortedData();
            System.out.println("average"+avgWiseSortedData.get(0));
            Assert.assertEquals(83.2, avgWiseSortedData.get(0).average, 0);
        } catch (CricketAnalyzerException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenBattingCSVFile_WhenSortedOnSR_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadBattingData(BATTING_CSV_FILE_PATH);
            List<IPLBattingCSV> strikeRateWiseSortedData = cricketAnalyzer.getStrikeRateWiseSortedData();
            Assert.assertEquals(333.33, strikeRateWiseSortedData.get(0).strikeRate, 0);
            System.out.println("strike rate"+strikeRateWiseSortedData.get(0));

        } catch (CricketAnalyzerException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

}
