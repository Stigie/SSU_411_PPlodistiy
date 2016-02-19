import com.csvreader.CsvReader;

import java.io.*;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Stig on 12.02.2016.
 */
public class Transaction {

    private File folder = new File("C:\\Users\\Stig\\IdeaProjects\\Task4\\");
    final Pattern p = Pattern.compile("Transactions_[\\d]+\\.csv");

    public Queue<String> getFiles() {
        return filesQueue;
    }

    private Queue<String> filesQueue = new PriorityQueue<String>();

    public Transaction() {
        folder.list(new FilenameFilter() {

            @Override
            public boolean accept(File folder, String name) {
                Matcher m = p.matcher(name);
                if (m.matches()) {
                    filesQueue.add(name);
                    return true;
                }
                return false;
            }

        });
    }

    //public ReaderComp getListComp() {
   //     return listComp;
   // }

   // private ReaderComp listComp = new ReaderComp();

    public void makeAllTransaction(ReaderComp listComp){
        while (!filesQueue.isEmpty()){
            makeTransaction(listComp);
        }
    }
    public void makeTransaction(ReaderComp listComp) {
       // for (Map.Entry entry : listComp.getComp().entrySet()) {
     //       System.out.println("Key: " + entry.getKey() + " Value: "
      //              + ((Company) entry.getValue()).getNameComp());
     //   }
        for(Map.Entry i : listComp.getComp().entrySet())
            ((Company)i.getValue()).setMoneyAllCash(0);
        try {
            CsvReader input = new CsvReader(filesQueue.poll());
            input.readHeaders();
            while (input.readRecord()) {
                String sendName = input.get("Sender name");
                String sendCount = input.get("Sender count");
                String getName = input.get("Receiver name");
                String getCount = input.get("Receiver count");
                try {
                    //System.out.println((listComp.getComp().get(Integer.parseInt(sendCount))).getNameComp());
                    if (!(listComp.getComp().get(Integer.parseInt(sendCount))).getNameComp().equals(sendName)){
                        System.out.println("Не совпадает название компании отправителя и номер её расчетный счет");
                        break;
                    }
                    else {
                        //System.out.println((listComp.getComp().get(Integer.parseInt(sendCount))).getNameComp());

                        try {
                            //System.out.println((listComp.getComp().get(Integer.parseInt(sendCount))).getNameComp());
                            if (!(listComp.getComp().get(Integer.parseInt(getCount))).getNameComp().equals(getName)){
                                System.out.println("Не совпадает название компании получателя и номер её расчетный счет");
                                break;
                            }

                            else {
                                //System.out.println((listComp.getComp().get(Integer.parseInt(getCount))).getNameComp());
                                String summ = input.get("Summa");
                                if (listComp.getComp().get(Integer.parseInt(sendCount)).checkMoneyAll(-Integer.parseInt(summ))) {
                                    listComp.getComp().get(Integer.parseInt(sendCount)).setMoneyAllCash(-Integer.parseInt(summ));
                                    listComp.getComp().get(Integer.parseInt(getCount)).setMoneyAllCash(Integer.parseInt(summ));
                                    //System.out.println(listComp.getComp().get(Integer.parseInt(sendCount)).checkMoneyAll(-Integer.parseInt(summ)));
                                }
                                else {
                                    System.out.println("У компании отправителя недостаточно средств");
                                    for(Map.Entry i : listComp.getComp().entrySet())
                                        ((Company)i.getValue()).setMoneyAllCash(0);
                                    break;
                                }
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Нет компании с таким лицевым счётом");
                            break;
                        }
                    }
                } catch (NullPointerException e) {
                    System.out.println("Нет компании с таким лицевым счётом");
                    break;
                }
                listComp.getComp().get(Integer.parseInt(sendCount)).makeTransaction();
                listComp.getComp().get(Integer.parseInt(getCount)).makeTransaction();

                //System.out.println(listComp.getComp().get(Integer.parseInt(getCount)).checkMoneyAll(Integer.parseInt(summ)));
            }

            input.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
