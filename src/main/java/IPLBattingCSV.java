import com.opencsv.bean.CsvBindByName;

public class IPLBattingCSV {

    @CsvBindByName(column = "POS")
    public int pos;

    @CsvBindByName(column = "PLAYER",required = true)
    public String player;

    @CsvBindByName(column = "Mat")
    public int match;

    @CsvBindByName(column = "Inns")
    public int innings;

    @CsvBindByName(column = "NO")
    public int notOut;

    @CsvBindByName(column = "Runs")
    public int runs;

    @CsvBindByName(column = "HS")
    public String highScore;

    @CsvBindByName(column = "Avg")
    public Double average;

    @CsvBindByName(column = "BF")
    public int ballFaced;

    @CsvBindByName(column = "SR")
    public Double strikeRate;

    @CsvBindByName(column = "100")
    public int hundred;

    @CsvBindByName(column = "50")
    public int fifty;

    @CsvBindByName(column = "4s")
    public int fours;

    @CsvBindByName(column = "6s")
    public int sixes;

    public IPLBattingCSV(int position, String player, int match, int inns, int notOut, int runs, String highScore, double avg, int ballFaced, double strikeRate, int hundred, int fifty, int fours, int sixes) {
            this.pos = position;
            this.player = player;
            this.match = match;
            this.innings = inns;
            this.notOut = notOut;
            this.runs = runs;
            this.highScore = highScore;
            this.average = avg;
            this.ballFaced = ballFaced;
            this.strikeRate = strikeRate ;
            this.hundred = hundred;
            this.fifty = fifty;
            this.fours = fours;
            this.sixes = sixes;

    }



    public IPLBattingCSV(){

}
    @Override
    public String toString() {
        return "IPLBattingCSV{" +
                "pos=" + pos +
                ", player='" + player + '\'' +
                ", match=" + match +
                ", innings=" + innings +
                ", notOut=" + notOut +
                ", runs=" + runs +
                ", highScore='" + highScore + '\'' +
                ", average='" + average  +
                ", ballFaced=" + ballFaced +
                ", strikeRate='" + strikeRate +
                ", hundred=" + hundred +
                ", fifty=" + fifty +
                ", fours=" + fours +
                ", sixes=" + sixes +
                '}';
    }
}
