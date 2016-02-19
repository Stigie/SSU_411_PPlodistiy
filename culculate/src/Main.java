import jdk.nashorn.internal.runtime.ParserException;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        //Scanner input = new Scanner(System.in);

        Scanner in = new Scanner(System.in);
        int a = 0;
        System.out.println("1. Вычислить");
        System.out.println("2. выход");
        a = in.nextInt();
        while (a != 2) {
            switch (a) {
                case 1:
                    System.out.println("Введите выражение для вычислений:");
                    Scanner expresion = new Scanner(System.in);
                    String n = expresion.next();
                    if (!n.contains("/0") && !n.contains("/+0") && !n.contains("/-0")) {
                        Calculator calc = new Calculator("(" + n + ")");
                        //int leng = n.length()+2;
                        String rex = "[\\d\\-\\*\\+\\/\\^\\(\\)]{" + n.length() + "}";
                        Pattern regexp = Pattern.compile(rex);
                        Matcher m = regexp.matcher(n);
                        boolean b = m.matches();
                        int countl = 0;
                        int countr = 0;
                        char[] st = n.toCharArray();
                        for (int i = 0; i < st.length; i++) {
                            if (st[i]=='(') countl++;
                            if (st[i]==')') countr++;
                        }
                        //System.out.println(b);
                        try {
                            if (b&&(countl==countr)) {
                                calc.action();
                                System.out.println(calc.getInputExpr());
                            } else System.out.println("Error! Ошибка при вводе!");
                        }
                        catch (NullPointerException e){System.out.println("Error! Ошибка при вводе!");}
                        catch (ParserException e){System.out.println("Error! Ошибка при вводе!");}

                    } else {
                        System.out.println("Error! Деление на ноль!");
                    }

                    break;
                case 2:
                    break;

            }
            System.out.println();
            System.out.println("1. Вычислить");
            System.out.println("2. Выход");
            a = in.nextInt();
        }
    }
}
