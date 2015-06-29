package net.scottjulian.Waddle;


import net.scottjulian.Waddle.util.node.SingleLinkedListNode;

public final class LinkedLists {

    /**
     *
     * https://leetcode.com/problems/reverse-linked-list-ii/
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static SingleLinkedListNode reverseSingleLinkedListBetwee(SingleLinkedListNode head, int m, int n){
        if(head.next == null || n - m == 0)
            return head;

        SingleLinkedListNode tmpHead = new SingleLinkedListNode(-1);
        tmpHead.next = head;
        SingleLinkedListNode previous = tmpHead;

        for(int i = 0; i < m - 1; i++){
            previous = previous.next;
        }

        SingleLinkedListNode front = previous.next;
        SingleLinkedListNode next = front.next;

        for(int x = 0; x < n - m; x++){
            front.next = next.next;
            next.next = previous.next;
            previous.next = next;
            next = front.next;
        }
        head = tmpHead.next;

        return head;
    }
}
