import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.StreamSupport;

public class CricketAnalyzer {




    public enum ComparatorType {
        AVERAGE,
        STRIKERATE,
        SIXESANDFOUR,
        STRIKEFOURSIXES,
        STRIKEAVERAGE,
        MAXRUNS,
        MAXRUNSAVERAGE,
        BOWLINGAVERAGE,
        ECONOMY,
        STRIKERATE5W4W,
        FIVEWICKET,
        FOURWICKET,
        AVERAGES_STRIKERATE,
        MAXWICKETS,
        WICKETS_AVERAGES,
        BATTING_BOWLING_AVERAGE,
        MOST_RUNS_WKTS
    }

    public enum CSVtype {
        BATTING,
        BOWLING,
        ALLROUNDER
    }

    public List<IPLBattingDAO> csvList = new ArrayList<>();

    public int loadBattingData(String CsvFilePath) throws CricketAnalyzerException {
        System.out.println("value of string" + CsvFilePath);

//        try {
//            Reader reader = Files.newBufferedReader(Paths.get(CsvFilePath));
//            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
//            Iterator csvFileIterator = csvBuilder.getCSVFileIterator(reader,
//                    IPLBattingCSV.class);
//            Iterable<IPLBattingCSV> iterable = () -> csvFileIterator;
//            StreamSupport.stream(iterable.spliterator(),false).forEach(data -> csvList.add(new IPLBattingDAO(data)));
//            System.out.println("batting-->"+csvList);
//            return csvList.size();
//
//
//        } catch (IOException e) {
//
//            throw new CricketAnalyzerException(e.getMessage(),
//                    CricketAnalyzerException.ExceptionType.BATTING_CSV_FILE_PROBLEM);
//        } catch (CSVBuilderException e) {
//            throw new CricketAnalyzerException(e.getMessage(), e.type.name());
//        } catch (RuntimeException e) {
//            throw new CricketAnalyzerException(e.getMessage(),
//                    CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA);
//        }
        return loadFileData(  CSVtype.BATTING,CsvFilePath);
    }


    public List getAvgWiseSortedData() {
//
        getSortedData(ComparatorType.AVERAGE);
        return csvList;
    }

    public List getStrikeRateWiseSortedData() {
        getSortedData(ComparatorType.STRIKERATE);
        return csvList;


    }

    public List getBoundaryWiseSortedData() {
        getSortedData(ComparatorType.SIXESANDFOUR);
        return csvList;

    }

    public List<IPLBattingDAO> strikeRateFoursixWiseSort() {
        getSortedData(ComparatorType.STRIKEFOURSIXES);
        return csvList;
    }

    public List<IPLBattingDAO> strikeRateAverageWiseSort() {
        getSortedData(ComparatorType.STRIKEAVERAGE);
        return csvList;
    }

    public List<IPLBattingDAO> maximumRunsAverageWiseSort() {
        getSortedData(ComparatorType.MAXRUNSAVERAGE);
        return csvList;

    }

    public void getSortedData(ComparatorType comparatorType) {
        Sorting sorting = new Sorting();
        csvList.sort(sorting.getComparator(comparatorType));

    }

    public int loadBowlingDataFile(String csvFilePath) throws CricketAnalyzerException {
        System.out.println("inloading bowlinfg data" + csvFilePath);
//        try {
//            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
//            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
//            Iterator csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLBowlingCSV.class);
//            System.out.println("in load bowling"+csvFileIterator.next());
//
//            Iterable<IPLBowlingCSV> iterable;
//
//            iterable = () -> csvFileIterator;
//            StreamSupport.stream(iterable.spliterator(), false).forEach(data -> csvList.add(new IPLBattingDAO(data)));
//            System.out.println("bowling-->"+csvList);
//
//            System.out.println("value of size"+csvList.size());
//            return csvList.size();
//        } catch (IOException e) {
//
//            throw new CricketAnalyzerException(e.getMessage(),
//                    CricketAnalyzerException.ExceptionType.IPL_BOWLING_FILE_PROBLEM);
//        } catch (CSVBuilderException e) {
//            throw new CricketAnalyzerException(e.getMessage(), e.type.name());
//        } catch (RuntimeException e) {
//            System.out.println(e);
//            throw new CricketAnalyzerException("in runt ime "+e.getMessage(),
//                    CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA);
//        }
        return loadFileData(  CSVtype.BOWLING,csvFilePath);
    }

    public List<IPLBattingDAO> bowlingAverageWiseSort() {
        getSortedData(ComparatorType.BOWLINGAVERAGE);
        return csvList;
    }

    public List<IPLBattingDAO> getEcnomywiseSort() {
        getSortedData(ComparatorType.ECONOMY);
        return csvList;
    }

    public List<IPLBattingDAO> getSR5w4w() {
        getSortedData(ComparatorType.STRIKERATE5W4W);
        return csvList;
    }

    public List<IPLBattingDAO> getStrikeRateAndAverage() {
        getSortedData(ComparatorType.AVERAGES_STRIKERATE);
        return csvList;
    }

    public List<IPLBattingDAO> bestAverageandMaxwickets() {
        getSortedData(ComparatorType.WICKETS_AVERAGES);
        return csvList;
    }
    public List<IPLBattingDAO> getBowlingandBattingAverage() {
        getSortedData(ComparatorType.BATTING_BOWLING_AVERAGE);
        return csvList;
    }
    public List<IPLBattingDAO> getMostRunsAndWicket() {
        getSortedData(ComparatorType.MOST_RUNS_WKTS);
        return csvList;
    }

    public  <E> int loadFileData( CSVtype csvType, String... csvFilePath) throws CricketAnalyzerException {
        csvList = new IPLAdapterFactory().getFileData(csvType, csvFilePath);
        int listSize = csvList.size();

        return listSize;
    }
}
