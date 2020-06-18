import java.util.Comparator;

public class Sorting {


    public Comparator<IPLBattingDAO> getComparator(CricketAnalyzer.ComparatorType comparatorType) {
        switch (comparatorType) {
            case AVERAGE:


                return (IPLBattingDAO player1, IPLBattingDAO player2) -> (int) (player2.getBattingAvg() - (player1.getBattingAvg()));

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
                return (IPLBattingDAO,iplBattingDAO)->{
                            double strikeRate = ((IPLBattingDAO.fours * 4) + (IPLBattingDAO.sixes * 6))*100 / IPLBattingDAO.ballFaced;
                     return (int) strikeRate;
                        };
//
            case MAXRUNS:
                return (IPLBattingDAO player1, IPLBattingDAO player2) ->  player2.getRuns() - (player1.getRuns());
            case MAXRUNSAVERAGE:
                return getComparator(CricketAnalyzer.ComparatorType.MAXRUNS).thenComparing(getComparator(CricketAnalyzer.ComparatorType.AVERAGE));
            case BOWLINGAVERAGE:
                return (IPLBattingDAO player1, IPLBattingDAO player2) -> (int) (player2.getBowlingavg() - (player1.getBowlingavg()));
            case ECONOMY:
                return (IPLBattingDAO  player1,IPLBattingDAO player2)-> (int) (player2.getEcon()-(player1.getEcon()));
            case STRIKERATE5W4W:
                return (IPLBattingDAO,iplBowlingDAO)-> {
                    double batAvgSR = (iplBowlingDAO.getOver() * 6 / (iplBowlingDAO.getFiveWickets() * 5 + iplBowlingDAO.getFourWickets() * 4));
                    return (int) batAvgSR;

                };
            case AVERAGES_STRIKERATE:
                return getComparator(CricketAnalyzer.ComparatorType.STRIKERATE).
                        thenComparing(getComparator(CricketAnalyzer.ComparatorType.BOWLINGAVERAGE));
            case MAXWICKETS:
                return (IPLBattingDAO  player1,IPLBattingDAO player2)-> (int) (player2.getWickets()-(player1.getWickets()));


            case WICKETS_AVERAGES:
                return getComparator(CricketAnalyzer.ComparatorType.MAXWICKETS).
                        thenComparing(getComparator(CricketAnalyzer.ComparatorType.BOWLINGAVERAGE));
                default:
                return null;
        }
    }
}
