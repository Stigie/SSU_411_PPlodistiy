import java.util.Map;

public class Main {

    public static void main(String[] args) {
       // System.out.println("Hello World!");
       // Company c = new Company("Byak", 111, 322);
       // System.out.println(c.getNameComp());
      //  System.out.println(c.getCountId());
       // System.out.println(c.getMoneyAll());

       // Transaction t = new Transaction();
       // for (String f : t.getFiles())
           // System.out.println(f);
        //t.makeAllTransaction();
        ReaderComp k = new ReaderComp();
        new Transaction().makeAllTransaction(k);
        new WriteResult(k);

    }
}
