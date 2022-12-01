package de.tum.in.ase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// make it implement the interface MyList
public class LinkedList<T> implements MyList<T> {

    private ListNode<T> first;
    private ListNode<T> last;

    public LinkedList() {
        ListNode<T> firstListNode = new ListNode<T>();
        ListNode<T> lastListNode = new ListNode<T>();
        this.first = new ListNode<>(firstListNode.getValue(), firstListNode.getPrevious(), firstListNode.getNext());
        this.last = new ListNode<>(lastListNode.getValue(), lastListNode.getPrevious(), lastListNode.getNext());
    }

    public ListNode<T> getFirst() {
        return first;
    }

    public void setFirst(ListNode<T> first) {
        this.first = first;
    }

    public ListNode<T> getLast() {
        return last;
    }

    public void setLast(ListNode<T> last) {
        this.last = last;
    }

    @Override
    public int size() {
        if (getLast() == null) {
            return 0;
        } else {
            int count = 0;
            ListNode<T> current = getFirst();
            while (current != null) {
                count += 1;
                current = current.getNext();
            }
            return count;
        }
    }

    @Override
    public boolean isEmpty() {
        return getFirst().getNext() == null;
    }

    @Override
    public boolean contains(T o) {
        if (this.isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T t) {
        if (!this.isEmpty()) {
            ListNode<T> newNode = new ListNode<>(t, this.getLast(), null);
            this.getLast().setNext(newNode);
        } else {
            ListNode<T> newNode = new ListNode<>(t, null, null);
        }
    }

    @Override
    public void remove(T o) {
        if (this.contains(o)) {
//            removes the first node (if it exists) with the value equal to the method parameter.
            int index = indexOf(o);
            remove(index);
        }
    }

    @Override
    public void clear() {
        if (!this.isEmpty()) {
            getFirst().setNext(null);
            getLast().setPrevious(null);
        }
    }

    @Override
    public T get(int index) {
        if (getFirst() == null || getFirst().getNext() == null || index > this.size() - 1) {
            throw new IndexOutOfBoundsException("List index is out of bound");
        } else if (index == this.size() - 1) {
            return getLast().getValue();
        } else {
            int count = 0;
            ListNode<T> current = getFirst();
            while(count < index) {
                count += 1;
                current = current.getNext();
            }
            return current.getValue();
        }
    }

    @Override
    public void add(int index, T element) {
        ListNode<T> listNodeElement = new ListNode<>(element);
        if (index > this.size() - 1) {
            throw new IndexOutOfBoundsException("List index is out of bound");
        } else {
            for (int i = this.size() - 1; i >= index; i--) {
                if (i == this.size() - 1) {
                    ListNode<T> newNode = new ListNode<>(element, getLast(), null);
                    getLast().setNext(newNode);
                } else if (i == 0) {
                    ListNode<T> newNode = new ListNode<>(element, null, getFirst());
                    getFirst().setPrevious(newNode);
                } else {
                    ListNode<T> newNode = new ListNode<>(element);
                    ListNode<T> previousNode = new ListNode<>(this.get(i - 1));
                    ListNode<T> currentNode = new ListNode<>(this.get(i));
                    newNode.setPrevious(previousNode);
                    newNode.setNext(currentNode);
                    previousNode.setNext(newNode);
                    currentNode.setPrevious(newNode);
                }
            }
        }
    }

//    TODO: need to change
    @Override
    public T remove(int index) {
        return get(index);
    }
//        if (index < 0 || index > this.size() - 1) {
//            throw new IndexOutOfBoundsException("List index is out of bound");
//        } else if (isEmpty()) {
//            return null;
//        } else {
//            int count = index;
//            ListNode<T> current = node0;
//            while (count < this.size() - 1) {
//                if (count == 0) {
//                    T node = node0.getValue();
//                    node0.setNext(null);
//                    return node;
//                } else {
//                    if (count == this.size() - 1) {
//                        T node = node2.getValue();
//                        node2.setPrevious(null);
//                        ListNode<T> previousNode = new ListNode<>(this.get(count - 1));
//                        previousNode.setNext(null);
//                        return node;
//                    } else {
//                        ListNode<T> previousNode = new ListNode<>(this.get(count - 1));
//                        ListNode<T> currentNode = new ListNode<>(this.get(count));
//                        ListNode<T> nextNode = new ListNode<>(this.get(count + 1));
//                        previousNode.setNext(nextNode);
//                        nextNode.setPrevious(previousNode);
//                        return currentNode.getValue();
//                    }
//                    count += 1;
//                    current = current.getNext();
//                }
//            }
//        }
//    }

//
//            for (int i = index; i < this.size() - 1; i++) {
//                if (i == this.size() - 1) {
//                    T node = node2.getValue();
//                    node2.setPrevious(null);
//                    ListNode<T> previousNode = new ListNode<>(this.get(i - 1));
//                    previousNode.setNext(null);
//                    return node;
//                } else if (i == 0) {
//                    T node = node0.getValue();
//                    node0.setNext(null);
//                    return node;
//                } else {
//                    ListNode<T> previousNode = new ListNode<>(this.get(i - 1));
//                    ListNode<T> currentNode = new ListNode<>(this.get(i));
//                    ListNode<T> nextNode = new ListNode<>(this.get(i + 1));
//                    previousNode.setNext(nextNode);
//                    nextNode.setPrevious(previousNode);
//                    return currentNode.getValue();
//                }
//            }
//            return node;


    @Override
    public int indexOf(T o) {
        if (this.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).equals(o)) {
                return i;
            }
        }
        return -1;
    }

//     The return value should consist of the toString() return of every value, separated by ,
//     (a comma followed by a single space) and encapsulated in brackets: []
    @Override
    public String toString() {
//        Need to change this?
        List<T> elements = new ArrayList<>();
        if (isEmpty()) {
            return "[]";
        } else {
            if (size() == 1) {
                T value = get(0);
                return value.toString();
            } else {
            // iterate through list and add value as string to list
                int count = 0;
                ListNode<T> current = getFirst();
                while(count < this.size()) {
                    elements.add(current.getValue());
                    count += 1;
                    current = current.getNext();
                }
                return "[" + elements.stream().map(String::valueOf).collect(Collectors.joining(",")) + "]";
            }
        }
    }

}
