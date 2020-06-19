import java.util.ArrayList;
import java.util.List;

public class IPLAdapterFactory {

    public List<IPLBattingDAO> battingList = new ArrayList<>();
    public List<IPLBattingDAO> playerList = new ArrayList<>();

        public List<IPLBattingDAO> getFileData(CricketAnalyzer.CSVtype csvFileType,
                                               String... csvFilePath) throws CricketAnalyzerException {
            if (csvFileType.equals(CricketAnalyzer.CSVtype.BATTING))
                return new IPLBattingAdapter().loadFileData(csvFilePath[0]);
            if (csvFileType.equals(CricketAnalyzer.CSVtype.BOWLING)) {
                return new IPLBowlingAdapter().loadFileData(csvFilePath[0]);

            }
            if (csvFileType.equals(CricketAnalyzer.CSVtype.ALLROUNDER)) {
                battingList = new IPLBattingAdapter().loadFileData(csvFilePath[0]);
                new IPLBowlingAdapter().loadFileData(csvFilePath[1]).forEach(player -> {
                    battingList.forEach(batsman -> {
                        if ( batsman.player.equals(player.player)){
                            batsman.bowlingavg = player.bowlingavg;
                            playerList.add(batsman);
                        }
                    });
                });
            }
            return playerList;
        }

    }

