import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CricketAnalyzer {




    public  enum ComparatorType{
        AVERAGE,
        STRIKERATE,
        SIXESANDFOUR,
        STRIKEFOURSIXES
    }
    public List<IPLBattingDAO> battingCSVList = new ArrayList<>();

    public int loadBattingData(String CsvFilePath) throws  CricketAnalyzerException {
        System.out.println("value of string"+CsvFilePath);

        try {
            Reader reader = Files.newBufferedReader(Paths.get(CsvFilePath));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator csvFileIterator = csvBuilder.getCSVFileIterator(reader,
                    IPLBattingCSV.class);
            Iterable<IPLBattingCSV> iterable = () -> csvFileIterator;
            StreamSupport.stream(iterable.spliterator(),false).forEach(data -> battingCSVList.add(new IPLBattingDAO(data)));
            System.out.println("batting-->"+battingCSVList);
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
//
        getSortedData(ComparatorType.AVERAGE);
        return battingCSVList;
    }

    public List getStrikeRateWiseSortedData() {
       getSortedData(ComparatorType.STRIKERATE);
        return battingCSVList;



    }

    public List getBoundaryWiseSortedData() {
        getSortedData(ComparatorType.SIXESANDFOUR);
        return battingCSVList;

    }
    public List<IPLBattingDAO> strikeRateFoursixWiseSort() {
        getSortedData(ComparatorType.STRIKEFOURSIXES);
        return battingCSVList;
    }



    public void getSortedData(ComparatorType comparatorType) {
        Sorting sorting =new Sorting();
        battingCSVList.sort(sorting.getComparator(comparatorType));

    }


}
