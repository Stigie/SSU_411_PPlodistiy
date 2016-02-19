import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Stig on 22.01.2016.
 */
public class main {

    public static void main(String[] args) throws Exception {
        Korzina k = new Korzina();
        Scanner in = new Scanner(System.in);
        int a = 0;
        System.out.println("1. Добавить товар");
        System.out.println("2. Удалить товар");
        System.out.println("3. Изменить количество");
        System.out.println("4. Очистить корзину");
        System.out.println("5. Товары в корзине");
        System.out.println("6. Количество товара в корзине");
        System.out.println("7. Выход");
        a = in.nextInt();
        while (a != 7) {
            switch (a) {
                case 1:
                    System.out.println("Введите наименование товара:");
                    Scanner name = new Scanner(System.in);
                    String n = name.next();
                    System.out.println("Введите количество товара:");
                    int ko = name.nextInt();
                    k.addProduct(n, ko);
                    break;
                case 2:
                    System.out.println("Введите наименование товара:");
                    name = new Scanner(System.in);
                    n = name.next();
                    System.out.println("Введите количество товара:");
                    k.removeProduct(n);

                    break;
                case 3:
                    System.out.println("Введите наименование товара:");
                    name = new Scanner(System.in);
                    n = name.next();
                    System.out.println("Введите количество товара:");
                    ko = name.nextInt();
                    k.udateProductQuantity(n, ko);

                    break;
                case 4:
                    k.clear();
                    break;
                case 5:
                    List<String> q;
                    q = k.getProducts();
                    if (!q.isEmpty())
                        System.out.println("В корзине находятся товары: " + q.toString());
                    else System.out.println("Корзина пуста");
                    break;
                case 6:
                    System.out.println("Введите наименование товара:");
                    name = new Scanner(System.in);
                    n = name.next();
                    System.out.println("В корзине " + k.getProductQuantity(n) + " единиц товара " + name);

                    break;
                case 7:
                    break;
            }
            System.out.println();
            System.out.println("1. Добавить товар");
            System.out.println("2. Удалить товар");
            System.out.println("3. Изменить количество");
            System.out.println("4. Очистить корзину");
            System.out.println("5. Товары в корзине");
            System.out.println("6. Количество товара в корзине");
            System.out.println("7. Выход");
            a = in.nextInt();
        }
    }
}
