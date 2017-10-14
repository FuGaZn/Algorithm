import java.util.*;

/**
 * DSA Chapter01 Combination
 * 找出从自然数 1, 2, …, n 中任取r个数的所有组合, 编一个递归算法.
 * 例子: n = 5 1 2 3 4 5
 *      r = 3 5 4 3
 *      5 4 2
 *      5 4 1
 *      5 3 2
 *      5 3 1
 *      5 2 1
 *      4 3 2
 *      4 3 1
 *      4 2 1
 *      3 2 1
 * 思路：先确定一个数字，然后求剩下的n-1个数字中取k-1个数字的组合。
 */


public class Combinations {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println("Input n:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Input r:");
        int k = sc.nextInt();
        sc.close();
        combine(list, n, k, 1);
    }

    public static void combine(ArrayList<Integer> list, int n, int k, int start) {
        if (list.size() == k) {//组合的集合长度等于要输出的字符串长度
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }
            System.out.println();
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            combine(list, n, k, i + 1);//求剩下的n-start个数字中取k-start个数字的组合
            list.remove(list.size() - 1);
        }
    }
}