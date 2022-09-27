package cn.bravedawn.collection.list.reverselinkedlist;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/27 20:46
 */
public class ConstructLinkListExample {

    /**
     * 下面分别通过循环遍历和递归的方式，对一个单链表实现了反转
     */

    /**
     * 通过循环来构造一个简单的链表
     * Java是在函数中是引用传递
     */
    public static ListNode constructLinkedList() {
        ListNode head = null;
        ListNode tail = null;

        for (int i = 1; i <= 5; i++) {
            ListNode node = new ListNode(i);
            if (head == null) {
                head = node;
            } else {
                tail.setNext(node);
            }
            tail = node;
        }
        return head;
    }


    /**
     * 使用迭代遍历去反转链表
     */
    public static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextElement = current.getNext();
            current.setNext(previous);
            previous = current;
            current = nextElement;
        }
        return previous;
    }

    /**
     * 使用递归去反转链表
     */
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.getNext() == null) {
            return head;
        }

        ListNode node = reverseListRecursive(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return node;
    }


    public static void main(String[] args) {
        ListNode head = constructLinkedList();
        ListNode node = head;
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }


        System.out.println("\n --Reverse list--");
        node = reverseList(head);
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }

        ListNode head2 = constructLinkedList();
        System.out.println("\n --Recursive reverse list--");
        node = reverseListRecursive(head2);
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
    }
}
