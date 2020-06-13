import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class LeagueAnalyzerTest {

    private static final String BATTING_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
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


}
