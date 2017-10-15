public class SingleLinkedList implements Cloneable {

    private Node head;

    public SingleLinkedList(Node head) {
        this.head = head;
    }

    /**
     * 拷贝
     *
     * @return
     */
    @Override
    public Object clone() {
        SingleLinkedList s = null;
        try {
            s = (SingleLinkedList) super.clone();
            s.head = (Node) head.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 多项式append，按指数从大到小排序
     *
     * @param coefficient
     * @param exponent
     */
    public void append(int coefficient, int exponent) {
        if (coefficient == 0) {
            return;
        }
        Node temp = head;

        //头处理
        if (exponent > head.getExponent()) {
            Node node = new Node(coefficient, exponent);
            node.setNext(head);
            head = node;
            return;
        }

        //
        while (temp.getNext() != null) {
            if (exponent < temp.getExponent() && exponent > temp.getNext().getExponent()) {//如果指数不存在相同，则添加一个
                Node node = new Node(coefficient, exponent);
                node.setNext(temp.getNext());
                temp.setNext(node);
                return;
            } else if (exponent == temp.getExponent()) {//如果存在相同的指数，系数相加
                temp.setCoefficient(temp.getCoefficient() + coefficient);
                return;
            }

            temp = temp.getNext();
        }

        //尾处理
        if (exponent == temp.getExponent()) {
            temp.setCoefficient(temp.getCoefficient() + coefficient);
            return;
        } else if (exponent < temp.getExponent()) {
            Node node = new Node(coefficient, exponent);
            temp.setNext(node);
            return;
        }

    }


    /**
     * 打印链表
     */
    public void printAll() {
        Node temp = head;
        while (temp.getNext() != null) {
            System.out.print(temp.getCoefficient() + "x^" + temp.getExponent() + (temp.getNext().getCoefficient() > 0 ? "+" : ""));
            temp = temp.getNext();
        }
        System.out.print(temp.getCoefficient() + "x^" + temp.getExponent());
        System.out.println();
    }

    /**
     * 多项式相加返回结果
     *
     * @param anotherSingleLinkedList
     * @return
     */
    public SingleLinkedList add(SingleLinkedList anotherSingleLinkedList) {
        SingleLinkedList result = (SingleLinkedList) anotherSingleLinkedList.clone();

        Node temp = head;
        while (temp != null) {
            result.append(temp.getCoefficient(), temp.getExponent());
            temp = temp.getNext();
        }
        return result;

    }

    public static void main(String[] args) {
        SingleLinkedList a = new SingleLinkedList(new Node(10, 10));
        a.append(10, 15);
        a.append(6, 8);
        a.append(-6, 3);
        a.append(8, 1);
        a.append(3, 0);

        SingleLinkedList b = new SingleLinkedList(new Node(-5, 10));
        b.append(5, 11);
        b.append(-5, 3);
        b.append(1, 9);
        b.append(6, 3);
        b.append(9, 5);

        System.out.println("相加之前：");
        a.printAll();
        b.printAll();

        System.out.println("结果：");
        a.add(b).printAll();

    }

}