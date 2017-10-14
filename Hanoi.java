import java.util.Scanner;
import java.util.LinkedList;

/**
 * DSA Chapter01 Hanoi
 * 思路：把前n-1个从A通通移到C（中转）,把第n个移到B,然后把其它从C移动B（A中转）
 */
public class Hanoi {
    /**
     * @param n    数量
     * @param from 移动的起始点
     * @param to   移动的终点
     * @param aux  移动的中转点
     */
    public static void moveDISKs(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("move " + n + " from " + from + " to " + to);// 把最后一个盘子移到终点
        } else {
            moveDISKs(n - 1, from, aux, to);//把前n-1个移到中转点（A->C)
            System.out.println("move " + n + " from " + from + " to " + to);// 把第n个盘子移到终点
            moveDISKs(n - 1, aux, to, from);//把剩下的n-1个盘子再移到终点（C->B)
        }
    }

    public static void main(String[] args) {
        // LinkedList<Integer> list = new LinkedList<Integer>();
        System.out.println("Input n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        moveDISKs(n, 'A', 'B', 'C');
    }
}
