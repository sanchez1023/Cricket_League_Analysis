public class CricketAnalyzerException extends Exception{
    enum ExceptionType{
        BATTING_CSV_FILE_PATH,
        BATTING_CSV_FILE_PROBLEM,



        INCORRECT_FILE_DATA ;
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
