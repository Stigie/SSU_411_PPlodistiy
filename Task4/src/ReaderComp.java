import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stig on 11.02.2016.
 */
public class ReaderComp {
    public Map<Integer, Company> getComp() {
        return comp;
    }
    private Map<Integer, Company> comp = new HashMap<Integer, Company>();
    public ReaderComp(){
        try {

            CsvReader companis = new CsvReader("information.csv");

            companis.readHeaders();

            while (companis.readRecord())
            {
                String compName = companis.get("Name Company");
                String count = companis.get("Count");
                String balance = companis.get("Balance");
                // perform program logic here
                Company cNew = new Company(compName, Integer.valueOf(count), Integer.valueOf(balance));
                comp.put(Integer.parseInt(count),cNew);
                //System.out.println(compName + ":" + balance );
            }

            companis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
