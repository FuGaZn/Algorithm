public class Node implements Cloneable {


    private int coefficient;//系数
    private int exponent;//指数
    private Node next;

    public Node(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    //get系数
    public int getCoefficient() {
        return coefficient;
    }

    //系数赋值
    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    //指数赋值
    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * 拷贝；链表
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Node node = null;
        node = (Node) super.clone();
        if (node.next != null) {
            node.next = (Node) node.next.clone();
        }

        return node;
    }

}