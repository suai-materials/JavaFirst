package su.pank;

import java.util.Scanner;

/**
 * Приложение, в котором для товара стоимостью a руб. b коп. при оплате за него c руб. d коп.
 * вычисляется, сколько сдачи требуется получить.
 *
 * @author Pankov Vasya (pank-su)
 *
 */
public class Main {
    public static void main(String[] args) throws Exception {
        int a, c;
        byte b, d;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите цену товара (сначала рубли, потом копейки)");
        a = sc.nextInt();
        b = sc.nextByte();
        if (b >= 100) {
            a += b / 100;
            b %= 100;
        }
        System.out.println("Введите сумму оплаты (сначала рубли, потом копейки)");
        c = sc.nextInt();
        if (c < a) throw new Exception("Суммы недостаточно для оплаты");
        d = sc.nextByte();
        if (d > 100) {
            c += d / 100;
            d %= 100;
        }
        if (c == a && d < b) throw new Exception("Суммы недостаточно для оплаты");
        boolean minus_one = b > d;
        System.out.printf("Ваша сдача: %d руб. %d к.", (minus_one ?  c - a - 1 : c - a), (minus_one ? 100 + d - b : d - b));

    }
}