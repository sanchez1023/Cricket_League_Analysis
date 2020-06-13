import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface ICSVBuilder<E> {
    public Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws CSVBuilderException;

    List<IPLBattingCSV> getCSVFileList(Reader reader, Class<IPLBattingCSV> iplBattingCSVClass) throws  CSVBuilderException;
}
