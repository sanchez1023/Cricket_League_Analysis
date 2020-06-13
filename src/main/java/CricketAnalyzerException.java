public class CricketAnalyzerException extends Exception{
    enum ExceptionType{
        BATTING_CSV_FILE_PATH
    }

    ExceptionType type;

    public CricketAnalyzerException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }

    public CricketAnalyzerException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

}
