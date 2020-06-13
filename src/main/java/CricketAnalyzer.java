import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CricketAnalyzer {

    public int loadBattingData(String CsvFilePath) throws IOException, CSVBuilderException, CricketAnalyzerException {

        try {
            Reader reader = Files.newBufferedReader(Paths.get(CsvFilePath));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<IPLBattingCSV> battingCSVList = csvBuilder.getCSVFileList(reader, IPLBattingCSV.class);
            System.out.println("value of list" + battingCSVList);
            return battingCSVList.size();

        } catch (IOException e) {
        throw new CricketAnalyzerException(e.getMessage(),CricketAnalyzerException.ExceptionType.BATTING_CSV_FILE_PATH);
        } catch (CSVBuilderException e) {
    throw new CricketAnalyzerException(e.getMessage(),e.type.name());
        }


    }
}