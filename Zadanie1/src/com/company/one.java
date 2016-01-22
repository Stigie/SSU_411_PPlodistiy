package com.company;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by Stig on 22.01.2016.
 */
public class one {
   // GregorianCalendar c = new GregorianCalendar();
  //  int c = 0;
  //  for (int i = 1; i <= 12; i++)
  //  {
  //      DateTime dt = new DateTime(yyyy, i, 13);
   //     if (dt.DayOfWeek == DayOfWeek.Friday)
  //          c++;
  //  }
    boolean pr (Scanner q)
    {
        try {
            q.nextInt(); return true;
        } catch (Exception e) {
            System.out.println("Некоректный ввод! Попробуйте еще раз");
            return false;
        }
    }
    void getKolpyfch()
    {

        System.out.println("Введите год:");
        int year = 0;

        while (year==0) {

            Scanner in = new Scanner(System.in);
            String s = in.next();
            try {
                year = Integer.parseInt(s);
            } catch (Exception e)
            {
                System.out.println("Некоректный ввод! Попробуйте еще раз");
            }


        }
        GregorianCalendar dt = new GregorianCalendar(year, 0, 13);
        String m = "";
        for (int i = 0; i <= 11; i++)
        {
            dt.set(year, i, 13);
           // System.out.println(dt.get(Calendar.DATE));
            //System.out.println(dt.get(Calendar.DAY_OF_WEEK)-1);
           // System.out.println(DayOfWeek.FRIDAY.getValue());
           if (dt.get(Calendar.DAY_OF_WEEK)-1 == DayOfWeek.FRIDAY.getValue())
           //System.out.println(dt.DAY_OF_WEEK);
            //System.out.println(DayOfWeek.FRIDAY.getValue());
           {
             int n = dt.get(Calendar.MONTH);
            switch (n)
            {
                case 0: m+="Январе ";break;
                case 1: m+="Фервале ";break;
                case 2: m+="Марте ";break;
                case 3: m+="Апреле ";break;
                case 4: m+="Мае ";break;
                case 5: m+="Июне ";break;
                case 6: m+="Июле ";break;
                case 7: m+="Агусте ";break;
                case 8: m+="Сентябре ";break;
                case 9: m+="Октябре ";break;
                case 10: m+="Ноябре ";break;
                case 11: m+="Декабре ";break;

            }}
        }
        System.out.println("пятница 13-ое в "+Integer.toString(year)+" году в: "+m);
    }
}
