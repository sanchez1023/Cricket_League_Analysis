import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.List;

public class LeagueAnalyzerTest {
    private static final String BOWLING_CSV_FILE_PATH = "./src/test/resources/wicket.csv";

    private static final String BATTING_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WRONG_BATTING_CSV_FILE_PATH = "/home/admin1/Documents/CricketLeagueAnalyzer/src/main/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WRONG_BATTING_CSV_FILE_TYPE = "./src/test/resources/IPL2019FactsheetMostRuns.txt";
    private static final String BATTING_CSV_FILE_WITH_WRONG_DELIMETER = "./src/test/resources/IPL2019FactsheetMostRunsDelimeter.csv";

    @Test
    public void givenBattingCsvFile_ShouldReturnCsvFileData() throws CricketAnalyzerException {
        try {

            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            int numberOfRecords = cricketAnalyzer.loadBattingData(BATTING_CSV_FILE_PATH);
            System.out.println("num of recoreds" + numberOfRecords);
            Assert.assertEquals(101, numberOfRecords);
        } catch (CricketAnalyzerException e) {

        }

    }

    @Test
    public void givenBattingCSVFile_WithWrongFilePath_ShouldThrowException() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketAnalyzerException.class);
            cricketAnalyzer.loadBattingData(WRONG_BATTING_CSV_FILE_PATH);
        } catch (CricketAnalyzerException e) {
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.IPL_FILE_PROBLEM, e.type);

        }
    }

    @Test
    public void givenBattingCSVFile_WithWrongFileType_ShouldThrowException() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketAnalyzerException.class);
            cricketAnalyzer.loadBattingData(WRONG_BATTING_CSV_FILE_TYPE);
        } catch (CricketAnalyzerException e) {
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.BATTING_CSV_FILE_PROBLEM, e.type);

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

        }
    }

    @Test
    public void givenBattingCSVFile_WhenSortedOnAvg_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadBattingData(BATTING_CSV_FILE_PATH);
            List<IPLBattingDAO> avgWiseSortedData = cricketAnalyzer.getAvgWiseSortedData();
            System.out.println("average" + avgWiseSortedData.get(0));
            Assert.assertEquals(83.2, avgWiseSortedData.get(0).battingavg, 0);
        } catch (CricketAnalyzerException e) {
        }

    }

    @Test
    public void givenBattingCSVFile_WhenSortedOnSR_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadBattingData(BATTING_CSV_FILE_PATH);
            List<IPLBattingDAO> strikeRateWiseSortedData = cricketAnalyzer.getStrikeRateWiseSortedData();
            Assert.assertEquals(333.33, strikeRateWiseSortedData.get(0).strikeRate, 0);
            System.out.println("strike rate" + strikeRateWiseSortedData.get(0));

        } catch (CricketAnalyzerException e) {

        }
    }

    @Test
    public void givenBattingCSVFile_WhenSortedOn_Max6sAnd4s_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadBattingData(BATTING_CSV_FILE_PATH);
            List<IPLBattingDAO> FoursixWiseSortedData = cricketAnalyzer.getBoundaryWiseSortedData();
            System.out.println("value of 4 and 6" + FoursixWiseSortedData.get(0));
            Assert.assertEquals("Andre Russell", FoursixWiseSortedData.get(0).player);
        } catch (CricketAnalyzerException e) {

        }

    }

    @Test
    public void whenGivenIplMostRunsCsvData_ShouldSortDataByStrikingRateAndSixesAndFour() {
        try {


            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadBattingData(BATTING_CSV_FILE_PATH);
            List<IPLBattingDAO> strikeRateFoursixWiseSortedData = cricketAnalyzer.strikeRateFoursixWiseSort();
            System.out.println("value of 4 and 6" + strikeRateFoursixWiseSortedData.get(0));
            Assert.assertEquals("Andre Russell", strikeRateFoursixWiseSortedData.get(0).player);
        } catch (CricketAnalyzerException e) {

        }
    }

    @Test
    public void whenGivenIplMostRunsCsvData_ShouldSortDataByStrikingRateAndAverage() {
        try {


            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadBattingData(BATTING_CSV_FILE_PATH);
            List<IPLBattingDAO> strikeRateFoursixWiseSortedData = cricketAnalyzer.strikeRateAverageWiseSort();
            System.out.println("value of 4 and 6" + strikeRateFoursixWiseSortedData.get(0));
            Assert.assertEquals("David Warner ", strikeRateFoursixWiseSortedData.get(0).player);
        } catch (CricketAnalyzerException e) {

        }
    }

    @Test
    public void whenGivenIplMostRunsCsvData_SholdSortDataBaseOnMaximumRunsAndAverage() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadBattingData(BATTING_CSV_FILE_PATH);
            List<IPLBattingDAO> maximumRunsAverageWiseSortedData = cricketAnalyzer.maximumRunsAverageWiseSort();
            System.out.println("value of 4 and 6" + maximumRunsAverageWiseSortedData.get(0));
            Assert.assertEquals("David Warner ", maximumRunsAverageWiseSortedData.get(0).player);
        } catch (CricketAnalyzerException e) {

        }
    }

    @Test
    public void givenBowlingCSVFile_ShouldReturnCSVFileData() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            int numOfRecords = cricketAnalyzer.loadBowlingDataFile(BOWLING_CSV_FILE_PATH);
            System.out.println("value in test" + numOfRecords);
            Assert.assertEquals(99, numOfRecords);
        } catch (CricketAnalyzerException e) {

        }
    }

    @Test
    public void givenBowlingCSVFile_whenSortedBowlingAveragewise() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadBowlingDataFile(BOWLING_CSV_FILE_PATH);
            List<IPLBattingDAO> bowlingAverageWiseSortedData = cricketAnalyzer.bowlingAverageWiseSort();
            Assert.assertEquals("Anukul Roy", bowlingAverageWiseSortedData.get(0).player);
        } catch (CricketAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenBowlingCSVFile_WhenSortedOnSR_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadBowlingDataFile(BOWLING_CSV_FILE_PATH);
            List<IPLBattingDAO> strikeRateWiseSortedData = cricketAnalyzer.getStrikeRateWiseSortedData();
            System.out.println("sorted data" + strikeRateWiseSortedData.get(0));
            Assert.assertEquals("Alzarri Joseph", strikeRateWiseSortedData.get(0).player);
        } catch (CricketAnalyzerException e) {

        }
    }

    @Test
    public void givenBowlingCSVFile_WhenSortedOnEconomy_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadBowlingDataFile(BOWLING_CSV_FILE_PATH);
            List<IPLBattingDAO> sortedData = cricketAnalyzer.getEcnomywiseSort();
            sortedData.forEach(System.out::println);
            Assert.assertEquals("Shivam Dube", sortedData.get(0).player);
        } catch (CricketAnalyzerException e) {
        }
    }

    @Test
    public void givenBowlingCSVFile_WhenSortedOnStrikeRate_With5wAnd4w_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadBowlingDataFile(BOWLING_CSV_FILE_PATH);
            List<IPLBattingDAO> sortedData = cricketAnalyzer.getSR5w4w();
            sortedData.forEach(System.out::println);
            Assert.assertEquals("Kagiso Rabada", sortedData.get(0).player);
        } catch (CricketAnalyzerException e) {

        }
    }

    @Test
    public void givenBowlingCSVFile_WhenSortedOnAverages_WithStrikeRate_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadBowlingDataFile(BOWLING_CSV_FILE_PATH);
            List<IPLBattingDAO> sortedData = cricketAnalyzer.getStrikeRateAndAverage();
//            sortedData.forEach(System.out::println);
            Assert.assertEquals("Anukul Roy", sortedData.get(0).player);
        } catch (CricketAnalyzerException e) {
        }

    }

    @Test
    public void givenBowlingCSVFile_WhenSortedOnMaxWkts_WithBestAvg_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadBowlingDataFile(BOWLING_CSV_FILE_PATH);
            List<IPLBattingDAO> sortedData = cricketAnalyzer.bestAverageandMaxwickets();

            Assert.assertEquals("Imran Tahir", sortedData.get(0).player);
        } catch (CricketAnalyzerException e) {

        }
    }

    @Test
    public void givenCSVFIle_WhenSortedOn_BattingAndBowlingAvgs_ShouldReturnSortedResult() throws CricketAnalyzerException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        cricketAnalyzer.loadFileData(CricketAnalyzer.CSVtype.ALLROUNDER, BATTING_CSV_FILE_PATH, BOWLING_CSV_FILE_PATH);
        List<IPLBattingDAO> sortedData = cricketAnalyzer.getBowlingandBattingAverage();
        Assert.assertEquals(49, sortedData.size());
    }

}
