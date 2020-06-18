

public class IPLBattingDAO {
    public Double over;
    public int wickets;
    public int bbi;
    public Double econ;
    public int fourWickets;
    public int fiveWickets;
    public int position;
    public String player;
    public int matches;
    public int inns;
    public int notOut;
    public int runs;
    public String highScore;
    public double battingavg;
    public double bowlingavg;
    public int ballFaced;
    public double strikeRate;
    public int hundred;
    public int fifty;
    public int fours;
    public int sixes;
    public int innings;


    public IPLBattingDAO(IPLBattingCSV iplBattingCSV) {
        player=iplBattingCSV.player;
        matches=iplBattingCSV.matches;
        innings=iplBattingCSV.innings;
        notOut = iplBattingCSV.notOut;
        runs = iplBattingCSV.runs;
        highScore = iplBattingCSV.highScore;
        battingavg = iplBattingCSV.average;
        ballFaced = iplBattingCSV.ballFaced;
        strikeRate = iplBattingCSV.strikeRate;
        hundred = iplBattingCSV.hundred;
    }

    public Double getOver() {
        return over;
    }

    public void setOver(Double over) {
        this.over = over;
    }

    public IPLBattingDAO(IPLBowlingCSV iplBowlingCSV) {

//        System.out.println("inside dao"+iplBowlingCSV);
        player=iplBowlingCSV.playerName;
        matches=iplBowlingCSV.matches;
        innings=iplBowlingCSV.innings;
        fiveWickets=iplBowlingCSV.fiveWicket;
        wickets = iplBowlingCSV.wickets;
        over=iplBowlingCSV.overs;
        bbi = iplBowlingCSV.bbi;
        bowlingavg = iplBowlingCSV.average;
        econ = iplBowlingCSV.economeyRate;
        strikeRate = iplBowlingCSV.strikeRate;
        fourWickets = iplBowlingCSV.fourWicket;
    }



    public IPLBattingCSV getIplDto() {
        return new IPLBattingCSV(position,
                player, matches, inns, notOut, runs, highScore, battingavg, ballFaced,
                strikeRate, hundred, fifty, fours, sixes);

    }


//    public  IPLBowlingCSV getBowlingDto(){
//        return  new IPLBowlingCSV(position,player,matches,innings,over,runs,wickets,bowlingavg,bbi,strikeRate,econ,fourWickets,fiveWickets);
//    }

    public int getFiveWickets() {
        return fiveWickets;
    }

    public int getWickets() {
        return wickets;
    }

    public int getFourWickets() {
        return fourWickets;
    }

    public Double getEcon() {
        return econ;
    }

    public int getPosition() {
        return position;
    }

    public String getPlayer() {
        return player;
    }

    public int getMatch() {
        return matches;
    }

    public int getInns() {
        return inns;
    }

    public int getNotOut() {
        return notOut;
    }

    public int getRuns() {
        return runs;
    }

    public String getHighScore() {
        return highScore;
    }

    public double getBattingAvg() {
        return battingavg;
    }

    public double getBowlingavg() {
        return bowlingavg;
    }

    public int getBallFaced() {
        return ballFaced;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public int getHundred() {
        return hundred;
    }

    public int getFifty() {
        return fifty;
    }

    public int getFours() {
        return fours;
    }

    public int getSixes() {
        return sixes;
    }

    @Override
    public String toString() {
        return "IplLeagueDAO{" +
                "position=" + position +
                ", player='" + player + '\'' +
                ", match=" + matches +
                ", inns=" + inns +
                ", notOut=" + notOut +
                ", runs=" + runs +
                ", highScore='" + highScore + '\'' +
                ", avg=" + battingavg +
                ".bowligavg="+bowlingavg+
                ", ballFaced=" + ballFaced +
                ", strikeRate=" + strikeRate +
                ", hundred=" + hundred +
                ", fifty=" + fifty +
                ", fours=" + fours +
                ", sixes=" + sixes +
                ", over=" + over +
                ", wickets=" + wickets +
                ", bbi=" + bbi +
                ", econ=" + econ +
                ", fourWickets=" + fourWickets +
                ", fiveWickets=" + fiveWickets +
                '}';
    }
}
