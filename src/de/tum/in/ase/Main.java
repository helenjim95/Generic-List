package de.tum.in.ase;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        ListNode first = new ListNode("one");
        ListNode second = new ListNode("two");
        ListNode third = new ListNode("three");
        ListNode forth = new ListNode("two");
        ListNode fifth = new ListNode("five");
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
        list.remove("three");
        System.out.println(list);

        ListNode first2 = new ListNode("one");
        LinkedList<String> list2 = new LinkedList<>();
        System.out.println(list2);
        list2.setFirst(first2);
        list2.remove("one");
        System.out.println(list2);
    }
}
