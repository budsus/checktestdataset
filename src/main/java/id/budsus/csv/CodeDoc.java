package id.budsus.csv;

import java.io.Serializable;
import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CodeDoc implements Serializable {
    private @Getter @Setter int lineNo;
    @CsvBindByPosition(position = 0)
    private @Getter @Setter String language;
    @CsvBindByPosition(position = 1)
    private @Getter @Setter String query;
    @CsvBindByPosition(position = 2)
    private @Getter @Setter String giturl;
    @CsvBindByPosition(position = 3)
    private @Getter @Setter String Relevance;
    @CsvBindByPosition(position = 4)
    private @Getter @Setter String Notes;

    public void fromString(int line, String[] data) {
        lineNo = line;
        language = data[0];
        query = data[1];
        giturl = data[2];
        Relevance = data[3];
        Notes = data[4];
    }
}
