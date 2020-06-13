import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CricketAnalyzer {
    public List<IPLBattingCSV> battingCSVList = new ArrayList<>();

    public int loadBattingData(String CsvFilePath) throws IOException, CSVBuilderException, CricketAnalyzerException {

        try {
            Reader reader = Files.newBufferedReader(Paths.get(CsvFilePath));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            battingCSVList = csvBuilder.getCSVFileList(reader, IPLBattingCSV.class);
            System.out.println("value of list" + battingCSVList);
            return battingCSVList.size();

        }  catch (IOException e) {
            throw new CricketAnalyzerException(e.getMessage(),
            CricketAnalyzerException.ExceptionType.BATTING_CSV_FILE_PROBLEM);
        }  catch (CSVBuilderException e) {
            throw new CricketAnalyzerException(e.getMessage(), e.type.name());
        } catch (RuntimeException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA);
        }
    }


    public List<IPLBattingCSV> getAvgWiseSortedData() {
        battingCSVList=battingCSVList.stream()
                .sorted((data1,data2) -> data2.average - data1.average < 0 ? -1 : 1)
                .collect(Collectors.toList());
        for (int i=0 ; i < battingCSVList.size() ; i++){
            System.out.println("value of average"+battingCSVList.get(i).average+" "+battingCSVList.get(i).player);
        }
        return battingCSVList;
    }

    public List<IPLBattingCSV> getStrikeRateWiseSortedData() {
        battingCSVList=battingCSVList.stream()
                .sorted((data1,data2) -> data2.strikeRate - data1.strikeRate < 0 ? -1 : 1)
                .collect(Collectors.toList());
        for (int i=0 ; i < battingCSVList.size() ; i++){
            System.out.println("value of average"+battingCSVList.get(i).strikeRate+" "+battingCSVList.get(i).player);
        }
        return battingCSVList;
    }
}
