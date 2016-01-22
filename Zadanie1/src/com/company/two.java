package com.company;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by Stig on 22.01.2016.
 */
public class two {
   void getyear ()
   {
       String[] mn = new String[12];
       mn[0] = "Январь";
       mn[1] = "Февраль";
       mn[2] = "Март";
       mn[3] = "Апрель";
       mn[4] = "Май";
       mn[5] = "Июнь";
       mn[6] = "Июль";
       mn[7] = "Август";
       mn[8] = "Сентябрь";
       mn[9] = "Октябрь";
       mn[10] = "Ноябрь";
       mn[11] = "Декабрь";

       int byear = 0;
       System.out.println("Введите год начала поиска:");
       while (byear==0) {

           Scanner in = new Scanner(System.in);
           String s = in.next();
           try {
               byear = Integer.parseInt(s);
           } catch (Exception e)
           {
               System.out.println("Некоректный ввод! Попробуйте еще раз");
           }
       }
       int eyear = 0;
       System.out.println("Введите год гонца поиска:");
       while (eyear==0) {

           Scanner in = new Scanner(System.in);
           String s = in.next();
           try {
               eyear = Integer.parseInt(s);
           } catch (Exception e)
           {
               System.out.println("Некоректный ввод! Попробуйте еще раз");
           }
       }
        int m =-1;
       System.out.println("Введите месяц(С большой буквы, в именительном падеже):");
       while (m==-1) {

           Scanner in = new Scanner(System.in);
           String s = in.next();

           for (int i = 0; i <mn.length ; i++) {
               if (mn[i].equals(s)) m=i;
               if (i==mn.length-1) System.out.println("Некоректный ввод! Попробуйте еще раз");
           }


       }

       GregorianCalendar dt = new GregorianCalendar(byear, m, 13);
       //String m = "";
       int c=0;
       System.out.println("Года в которых в "+mn[m]+" есть пятница 13:");
       for (int i = byear; i <= eyear; i++) {
           dt.set(i, m, 13);
           // System.out.println(dt.get(Calendar.DATE));
           //System.out.println(dt.get(Calendar.DAY_OF_WEEK)-1);
           // System.out.println(DayOfWeek.FRIDAY.getValue());
           if (dt.get(Calendar.DAY_OF_WEEK) - 1 == DayOfWeek.FRIDAY.getValue())
           {
               c++;

               System.out.println(i);
           }

       }System.out.println("Общее количество лет с пятницей 13 в месяце "+mn[m]+": "+c);
   }
}
