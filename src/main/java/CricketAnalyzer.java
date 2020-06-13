import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CricketAnalyzer {
    public List<IPLBattingDAO> battingCSVList = new ArrayList<>();

    public int loadBattingData(String CsvFilePath) throws IOException, CSVBuilderException, CricketAnalyzerException {

        try {
            Reader reader = Files.newBufferedReader(Paths.get(CsvFilePath));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLBattingCSV.class);
            Iterable<IPLBattingCSV> iterable = () -> csvFileIterator;
            StreamSupport.stream(iterable.spliterator(),false).forEach(data -> battingCSVList.add(new IPLBattingDAO(data)));
            return battingCSVList.size();


        } catch (IOException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.BATTING_CSV_FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CricketAnalyzerException(e.getMessage(), e.type.name());
        } catch (RuntimeException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA);
        }
    }


    public List getAvgWiseSortedData() {
        List<IPLBattingCSV> iplBattingDto  = battingCSVList.stream()
                .sorted((data1, data2) -> data2.avg - data1.avg < 0 ? -1 : 1).map(iplLeagueDto-> iplLeagueDto.getBattingDto())
                .collect(Collectors.toList());
        for (int i = 0; i < iplBattingDto.size(); i++) {
            System.out.println("value of average" + iplBattingDto.get(i).average + " " + iplBattingDto.get(i).player);
        }
        return iplBattingDto;
    }

    public List getStrikeRateWiseSortedData() {
        List<IPLBattingCSV> iplBattingDto = battingCSVList.stream()
                .sorted((data1, data2) -> data2.strikeRate - data1.strikeRate < 0 ? -1 : 1).map(iplLeagueDto-> iplLeagueDto.getBattingDto())
                .collect(Collectors.toList());
        for (int i = 0; i < iplBattingDto.size(); i++) {
            System.out.println("value of average" + iplBattingDto.get(i).strikeRate + " " + iplBattingDto.get(i).player);
        }
        return iplBattingDto;
    }

    public List getBoundaryWiseSortedData() {
        List<IPLBattingCSV> iplBattingDto = battingCSVList.stream()
                .sorted((data1, data2) -> ((data2.sixes * 6) + (data2.fours * 4)) - ((data1.sixes * 6) + (data1.fours * 4))).map(iplBattingDAO ->  iplBattingDAO.getBattingDto())
                .collect(Collectors.toList());
        for (int i = 0; i < iplBattingDto.size(); i++) {
            System.out.println("value of average" + iplBattingDto.get(i).fours + " " + iplBattingDto.get(i).sixes + " " + battingCSVList.get(i).player);
        }
        return iplBattingDto;
    }



}
