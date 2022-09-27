package cn.bravedawn.collection.list.reverselinkedlist;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/27 20:42
 */
public class ListNode {

    private int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
