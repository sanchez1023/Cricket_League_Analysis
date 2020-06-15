import java.util.Comparator;

public class Sorting {


    public Comparator<IPLBattingDAO> getComparator(CricketAnalyzer.ComparatorType comparatorType) {
        switch (comparatorType) {
            case AVERAGE:


                return (IPLBattingDAO player1, IPLBattingDAO player2) -> (int) (player2.getAvg() - (player1.getAvg()));

            case STRIKERATE:


                return (IPLBattingDAO player1, IPLBattingDAO player2) -> (int) (player2.getStrikeRate() - (player1.getStrikeRate()));


            case SIXESANDFOUR:
                return (IPLBattingDAO player1, IPLBattingDAO player2) ->
                        ((player2.getSixes() * 6) + (player2.getFours() * 4)) -
                                ((player1.getSixes() * 6) + (player1.getFours() * 4));
            case STRIKEFOURSIXES:
                    return getComparator(CricketAnalyzer.ComparatorType.SIXESANDFOUR).
                            thenComparing(getComparator(CricketAnalyzer.ComparatorType.STRIKERATE))
                        ;
            case STRIKEAVERAGE:
                return getComparator(CricketAnalyzer.ComparatorType.AVERAGE.AVERAGE).
                        thenComparing(getComparator(CricketAnalyzer.ComparatorType.STRIKERATE));
            case MAXRUNS:
                return (IPLBattingDAO player1, IPLBattingDAO player2) ->  player2.getRuns() - (player1.getRuns());
            case MAXRUNSAVERAGE:
                return getComparator(CricketAnalyzer.ComparatorType.MAXRUNS).thenComparing(getComparator(CricketAnalyzer.ComparatorType.AVERAGE));

            default:
                return null;
        }
    }
}
