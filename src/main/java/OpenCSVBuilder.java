import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
public class OpenCSVBuilder<E> implements ICSVBuilder {
    public Iterator<E> getCSVfileIterator(Reader reader, Class csvClass) throws CSVBuilderException {
        return  this.getCsvBean(reader,csvClass).iterator();


    }

    private CsvToBean<E> getCsvBean(Reader reader, Class csvClass) throws CSVBuilderException {
        try{
            CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(csvClass);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            csvToBeanBuilder.withSkipLines(0);

            return csvToBeanBuilder.build();


        }
        catch(IllegalStateException e) {
            throw  new CSVBuilderException(CSVBuilderException.ExceptionType.INVALID_DATA,
                    e.getMessage());

        }
    }


    @Override
    public Iterator getCSVFileIterator(Reader reader, Class csvClass) throws CSVBuilderException {
        return  this.getCsvBean(reader,csvClass).iterator();
    }

    @Override
    public List<E> getCSVFileList(Reader reader, Class csvClass) throws CSVBuilderException {
        return  this.getCsvBean(reader,csvClass).parse();
    }

}
