import java.util.List;

public class IPLAdapterFactory {


        public List<IPLBattingDAO> getFileData(CricketAnalyzer.CSVtype csvFileType,
                                               String... csvFilePath) throws CricketAnalyzerException {
            if (csvFileType.equals(CricketAnalyzer.CSVtype.BATTING))
                return new IPLBattingAdapter().loadFileData(csvFilePath);
            if (csvFileType.equals(CricketAnalyzer.CSVtype.BOWLING))
                return new IPLBowlingAdapter().loadFileData(csvFilePath);
            throw new CricketAnalyzerException("Unknown Data", CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA);

        }
    }

