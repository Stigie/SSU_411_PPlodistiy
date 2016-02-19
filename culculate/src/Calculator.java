import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.lang.reflect.Array;
import java.util.Arrays;

import static java.lang.Math.*;


/**
 * Created by Stig on 29.01.2016.
 */
public class Calculator {
    public StringBuilder getInputExpr() {
        return inputExpr;
    }

    private StringBuilder inputExpr;

    public Calculator(String input) {
        if (!input.contains("/0") && !input.contains("/+0") && !input.contains("/-0"))
            inputExpr = new StringBuilder(input);
        else {
            System.out.println("Деление на 0");
        }
    }

    public String stringParserBracker() {
        int firstBrack = inputExpr.lastIndexOf("(");
        int lastBrack = inputExpr.indexOf(")", firstBrack);
        try {
            return inputExpr.substring(firstBrack + 1, lastBrack);
        } catch (Exception e) {
            return "-1";
        }
    }

    public void action() {
        while (inputExpr.indexOf("(") != -1 && inputExpr.indexOf(")") != -1) {
            int firstBrack = inputExpr.lastIndexOf("(");
            int lastBrack = inputExpr.indexOf(")", firstBrack);
            //String q = calcInBracks(stringParserBracker());
            ///String w = inputExpr.substring(firstBrack, lastBrack+1);
            //System.out.println(q);
            inputExpr.replace(firstBrack, lastBrack+1, calcInBracks(stringParserBracker()));
        }
    }
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    public String calcInBracks(String input) {
        //= inputExpr.toString();
        float rez = -1;
        input = input.replaceAll("\\^\\+", "^");

        //Обработка символа ^

        while (input.contains("^")) {
            int left[] = new int[4];

            int right[] = new int[4];

            left[0] = input.substring(0, input.lastIndexOf("^")).lastIndexOf("-");
            left[1] = input.substring(0, input.lastIndexOf("^")).lastIndexOf("+");
            left[2] = input.substring(0, input.lastIndexOf("^")).lastIndexOf("*") + 1;
            left[3] = input.substring(0, input.lastIndexOf("^")).lastIndexOf("/") + 1;

            try {
                float q = Float.valueOf(input.substring(input.lastIndexOf("^") + 1, input.lastIndexOf("^") + 2));
                right[0] = input.indexOf("-", input.lastIndexOf("^"));
                right[1] = input.indexOf("+", input.lastIndexOf("^"));
                right[2] = input.indexOf("*", input.lastIndexOf("^"));
                right[3] = input.indexOf("/", input.lastIndexOf("^"));
            } catch (Exception e) {
                right[0] = input.indexOf("-", input.lastIndexOf("^") + 2);
                right[1] = input.indexOf("+", input.lastIndexOf("^") + 2);
                right[2] = input.indexOf("*", input.lastIndexOf("^") + 2);
                right[3] = input.indexOf("/", input.lastIndexOf("^") + 2);
            }

            for (int i = 0; i < left.length; i++) {
                if (left[i] == -1) left[i] = 0;
            }
            for (int i = 0; i < right.length; i++) {
                if (right[i] == -1) right[i] = input.length();
            }
            Arrays.sort(right);
            Arrays.sort(left);
            float lft = Float.valueOf(input.substring(left[3], input.lastIndexOf("^")));
            float rght = Float.valueOf(input.substring(input.lastIndexOf("^") + 1, right[0]));
            rez = (float) Math.pow(lft, rght);
            String s;
            if (rez > 0) s = "+" + String.valueOf(rez);
            else s = String.valueOf(rez);
            String rr;
            String rex;
            if (lft < 0) rr = input.substring(left[3], input.lastIndexOf("^"));
            else {
                if (!input.substring(left[3], left[3] + 1).equals("+"))
                    rr = input.substring(left[3], input.lastIndexOf("^"));
                else
                    rr = "\\" + input.substring(left[3], input.lastIndexOf("^"));
            }
            String rl = input.substring(input.lastIndexOf("^") + 1, right[0]);
            rex = rr + "\\^" + rl;
            input = input.replaceAll(rex, s);
        }
        input = input.replaceAll("--", "\\+");
        input = input.replaceAll("\\+-", "-");
        input = input.replaceAll("-\\+", "-");
        input = input.replaceAll("\\+\\+", "\\+");

        //Обработка символа / и *

/*        while (input.contains("/") || input.contains("*")) {

            float lft;
            float rght;
            String rr;
            String rex;
            int t1 = input.indexOf("/");
            if (t1 == -1) t1 = input.length();
            int t2 = input.indexOf("*");
            if (t2 == -1) t2 = input.length();
            if (t1 < t2) {

                int a1 = input.indexOf("-", input.indexOf("/"));
                if (a1 == input.indexOf("/") + 1) a1 = input.indexOf("-", input.indexOf("/") + 2);
                int a2 = input.indexOf("+", input.indexOf("/"));
                if (a2 == input.indexOf("/") + 1) a2 = input.indexOf("+", input.indexOf("/") + 2);

                int a;
                if (a1 != -1 && a2 != -1) {
                    a = min(a1, a2);
                } else {
                    if (a1 == -1) a = a2;
                    else a = a1;
                }
                if (a2 == -1 && a1 == -1) a = input.length();

                int b1 = input.substring(0, input.indexOf("/")).lastIndexOf("-");

                int b2 = input.substring(0, input.indexOf("/")).lastIndexOf("+");


                int b;
                if (b1 != -1 && b2 != -1) {
                    b = max(b1, b2);
                } else {
                    if (b1 == -1) b = b2;
                    else b = b1;
                }
                if (b2 == -1 && b1 == -1) b = 0;
                lft = Float.valueOf(input.substring(b, input.indexOf("/")));
                rght = Float.valueOf(input.substring(input.indexOf("/") + 1, a));


                if (lft < 0) rr = input.substring(b, input.indexOf("/"));
                else {
                    if (!input.substring(b, b + 1).equals("+"))
                        rr = input.substring(b, input.indexOf("/"));
                    else
                        rr = "\\" + input.substring(b, input.indexOf("/"));
                }

                String rl = input.substring(input.indexOf("/") + 1, a);
                if (rl.substring(0, 1).equals("+")) rl = "\\" + rl;
                rex = rr + "/" + rl;
                if (rght == 0)
                    System.out.println("Деление на 0");
                else rez = lft / rght;

            } else {

                int a1 = input.indexOf("-", input.indexOf("*"));
                if (a1 == input.indexOf("*") + 1) a1 = input.indexOf("-", input.indexOf("*") + 2);
                int a2 = input.indexOf("+", input.indexOf("*"));
                if (a2 == input.indexOf("*") + 1) a2 = input.indexOf("+", input.indexOf("*") + 2);

                int a;
                if (a1 != -1 && a2 != -1) {
                    a = min(a1, a2);
                } else {
                    if (a1 == -1) a = a2;
                    else a = a1;
                }
                if (a2 == -1 && a1 == -1) a = input.length();

                int b1 = input.substring(0, input.indexOf("*")).lastIndexOf("-");

                int b2 = input.substring(0, input.indexOf("*")).lastIndexOf("+");


                int b;
                if (b1 != -1 && b2 != -1) {
                    b = max(b1, b2);
                } else {
                    if (b1 == -1) b = b2;
                    else b = b1;
                }
                if (b2 == -1 && b1 == -1) b = 0;

                lft = Float.valueOf(input.substring(b, input.indexOf("*")));
                rght = Float.valueOf(input.substring(input.indexOf("*") + 1, a));


                if (lft < 0) rr = input.substring(b, input.indexOf("*"));
                else {
                    if (!input.substring(b, b + 1).equals("+"))
                        rr = input.substring(b, input.indexOf("*"));
                    else
                        rr = "\\" + input.substring(b, input.indexOf("*"));
                }
                String rl = input.substring(input.indexOf("*") + 1, a);
                if (rl.substring(0, 1).equals("+")) rl = "\\" + rl;
                rex = rr + "\\*" + rl;
                rez = lft * rght;
            }

            String s;
            if (rez > 0) s = "+" + String.valueOf(rez);
            else s = String.valueOf(rez);


            input = input.replaceAll(rex, s);
        }*/

        String rez1 = null;
        try {
            rez1 = engine.eval(input).toString();

            //System.out.println(rez1);

        } catch (ScriptException e) {
            e.printStackTrace();
            //System.out.println("Error! Ошибка при вводе!");
        }
        //System.out.println(input);
        //if (!input.equals("")) rez = Float.valueOf(input);
        rez = Float.valueOf(rez1);
        return rez1;
    }

}
