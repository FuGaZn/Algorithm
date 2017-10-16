import java.util.*;

public class Jose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入游戏人数");
        int len = sc.nextInt();
        System.out.println(("输入报数间隔"));
        int m = sc.nextInt();

        CyclLink cyclink = new CyclLink();
        cyclink.setLen(len);
        cyclink.createLink();
        cyclink.setK(1);
        cyclink.setM(m);
        //cyclink.show();
        cyclink.play();
    }
}

// 先建立一个子类
class Person {
    int no;
    Person nextPerson;

    public Person(int no) {
        this.no = no;
    }
}

class CyclLink {
    Person firstPerson = null;
    Person temp = null;
    int len = 0;// 长度
    int k = 0;  //开始的位置
    int m = 0;  //数到几淘汰

    // 设置m
    public void setM(int m) {
        this.m = m;
    }

    // 设置链表的大小
    public void setLen(int len) {
        this.len = len;
    }

    // 设置从第几个人开始数数
    public void setK(int k) {
        this.k = k;
    }

    // 开始
    public void play() {
        Person temp = this.firstPerson;
        // 先找到开始数数的人
        for (int i = 1; i < k; i++) {
            temp = temp.nextPerson;
        }
        while (this.len != 0) {
            for (int j = 1; j < m; j++) {
                temp = temp.nextPerson;
            }
            System.out.print(temp.no + " ");
            // 找到要淘汰的前一个人
            Person temp2 = temp;
            while (temp2.nextPerson != temp) {
                temp2 = temp2.nextPerson;
            }
            // 3.将数到m的人淘汰掉
            temp2.nextPerson = temp.nextPerson;
            // 让temp指向下一个人
            temp = temp.nextPerson;
            // this.show();
            this.len--;
        }

        // 最后一个人
       // System.out.println("胜利者" + temp.no);
    }

    // 初始化环形链表
    public void createLink() {
        for (int i = 1; i <= len; i++) {
            if (i == 1) {
                // 创建第一个人
                Person ch = new Person(i);
                this.firstPerson = ch;
                this.temp = ch;
            } else {
                if (i == len) {
                    // 创建第一个人
                    Person ch = new Person(i);
                    temp.nextPerson = ch;
                    temp = ch;
                    temp.nextPerson = this.firstPerson;
                } else {
                    // 继续创建
                    Person ch = new Person(i);
                    temp.nextPerson = ch;
                    temp = ch;
                }
            }
        }
    }

    // 打印该环形链表
    public void show() {
        Person temp = this.firstPerson;
        do {
            System.out.print(temp.no + " ");
            temp = temp.nextPerson;
        } while (temp != this.firstPerson);
    }
}
