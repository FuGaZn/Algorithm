import java.util.*;

public class Josephus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入游戏人数");
        int n = sc.nextInt();
        System.out.println(("输入报数间隔"));
        int m = sc.nextInt();
        Josephus jose = new Josephus(n, 1, m);
        jose.calcLoop();
        jose.show();

    }

    //n为环中人数，m为每次报数的间隔，k为报数的起始位置
    int n, m, k;
    int[] persons;
    int[] seq;

    Josephus(int n, int k, int m) {
        this.n = n;
        this.m = m;
        this.k = k;
        persons = new int[n];
        seq = new int[n];

    }

    public void show() {
        for (int x : seq) {
            System.out.print(x + " ");
        }
    }

    public void calcLoop() {
        for (int j = 0; j < n; j++) {
            int index = k;
            for (int i = 0; i < m; index++) {
                if (persons[index % n] == 0) {
                    i++;
                }
            }
            persons[(index - 1) % n] = 1;//开始位置
            seq[j] = (index - 1) % n;//淘汰的人
            k = (index) % n;
        }
    }

}
