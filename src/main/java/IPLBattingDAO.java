


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

    public IPLBattingCSV getBattingDto(){
        return new IPLBattingCSV (position ,
                player ,match ,inns ,notOut ,runs, highScore ,avg, ballFaced,
                strikeRate ,   hundred , fifty, fours ,sixes);
    }


}
