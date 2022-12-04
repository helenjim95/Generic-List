package de.tum.in.ase;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        first.setPrevious(null);
        first.setNext(second);
        second.setPrevious(first);
        second.setNext(third);
        third.setPrevious(second);
        third.setNext(forth);
        forth.setPrevious(third);
        forth.setNext(fifth);
        fifth.setPrevious(forth);
        fifth.setNext(null);
        list.setFirst(first);
        list.setLast(fifth);
        System.out.println(list);
    }
}
