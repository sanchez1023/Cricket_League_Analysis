import com.opencsv.bean.CsvBindByName;

public class IPLBowlingCSV {

//    POS	PLAYER	Mat	Inns	Ov	Runs	Wkts	BBI	Avg	Econ	SR	4w	5w



    @CsvBindByName(column = "POS", required = true)
    public int pos;

    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;

    @CsvBindByName(column = "Mat", required = true)
    public int matches;

    @CsvBindByName(column = "Inns", required = true)
    public int innings;

    @CsvBindByName(column = "Ov", required = true)
    public double overs;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "Wkts", required = true)
    public int wickets;

    @CsvBindByName(column = "Avg", required = true)
    public double average;

    @CsvBindByName(column = "BBI", required = true)
    public int bbi;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "Econ", required = true)
    public double economeyRate;

    @CsvBindByName(column = "4w", required = true)
    public int fourWicket;

    @CsvBindByName(column = "5w", required = true)
     public int fiveWicket;

    public IPLBowlingCSV() {

    }

    public IPLBowlingCSV(int pos, String playerName, int matches, int innings, double overs, int runs,
                  int wickets,  double average, int bbi,
                  double strikeRate, double economeyRate,
                  int fourWicket, int fiveWicket) {
        this.pos = pos;
        this.playerName = playerName;
        this.matches = matches;
        this.innings = innings;
        this.overs = overs;
        this.runs = runs;
        this.wickets = wickets;
        this.average = average;
        this.bbi = bbi;
        this.strikeRate = strikeRate;
        this.economeyRate = economeyRate;
        this.fourWicket = fourWicket;
        this.fiveWicket = fiveWicket;
    }

    @Override
    public String toString() {
        return "IPLBowlingCSV{" +
                "pos=" + pos +
                ", playerName='" + playerName + '\'' +
                ", matches=" + matches +
                ", innings=" + innings +
                ", overs=" + overs +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", average=" + average +
                ", bbi=" + bbi +
                ", strikeRate=" + strikeRate +
                ", economeyRate=" + economeyRate +
                ", fourWicket=" + fourWicket +
                ", fiveWicket=" + fiveWicket +
                '}';
    }
}
