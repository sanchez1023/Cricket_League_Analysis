

public class IPLBattingDAO {
    public int position;
    public String player;
    public int match;
    public int inns;
    public int notOut;
    public int runs;
    public String highScore;
    public double avg;
    public int ballFaced;
    public double strikeRate;
    public int hundred;
    public int fifty;
    public int fours;
    public int sixes;

    public IPLBattingDAO() {
    }

    public IPLBattingDAO(IPLBattingCSV iplBattingCSV) {
        position = iplBattingCSV.pos;
        player = iplBattingCSV.player;
        match = iplBattingCSV.match;
        inns = iplBattingCSV.innings;
        notOut = iplBattingCSV.notOut;
        runs = iplBattingCSV.runs;
        highScore = iplBattingCSV.highScore;
        avg = iplBattingCSV.average;
        ballFaced = iplBattingCSV.ballFaced;
        strikeRate = iplBattingCSV.strikeRate;
        hundred = iplBattingCSV.hundred;
        fifty = iplBattingCSV.fifty;
        fours = iplBattingCSV.fours;
        sixes = iplBattingCSV.sixes;
    }




    public IPLBattingCSV getIplDto(){
        return new IPLBattingCSV (position ,
                player ,match ,inns ,notOut ,runs, highScore ,avg, ballFaced,
                strikeRate ,   hundred , fifty, fours ,sixes);
    }

    public int getPosition() {
        return position;
    }

    public String getPlayer() {
        return player;
    }

    public int getMatch() {
        return match;
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

    public double getAvg() {
        return avg;
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
                ", match=" + match +
                ", inns=" + inns +
                ", notOut=" + notOut +
                ", runs=" + runs +
                ", highScore='" + highScore + '\'' +
                ", avg=" + avg +
                ", ballFaced=" + ballFaced +
                ", strikeRate=" + strikeRate +
                ", hundred=" + hundred +
                ", fifty=" + fifty +
                ", fours=" + fours +
                ", sixes=" + sixes +
                '}';
    }
}
