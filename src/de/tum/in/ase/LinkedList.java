package de.tum.in.ase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// make it implement the interface MyList
public class LinkedList<T> implements MyList<T> {

    private ListNode<T> first;
    private ListNode<T> last;

    public LinkedList() {
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
        ListNode<T> current = this.first;
        if (current.getNext() == null) {
            return 0;
        } else {
            int count = 0;
            while (current.getNext() != null) {
                count += 1;
                current = current.getNext();
            }
            return count;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.getFirst() == null;
    }

    @Override
    public boolean contains(T o) {
        if (this.isEmpty()) {
            return false;
        }

        ListNode<T> currentNode = this.first;
        while(currentNode.getNext() != null) {
            if (currentNode.getValue() == o) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
//        for (int i = 0; i < this.size(); i++) {
//            if (this.get(i).equals(o)) {
//                return true;
//            }
//        }
//        return false;
    }

//    TODO: need to fix
    @Override
    public void add(T t) {
        if (this.first == null) {
            this.first = new ListNode<>(t);
        } else {
            ListNode<T> newNode = new ListNode<>(t);
            ListNode<T> currentNode = this.first;
            // Let's check for NPE before iterate over crunchifyCurrent
            if (currentNode != null) {
                // starting at the head node, crawl to the end of the list and then add element after last node
                while (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                }
                // the last node's "next" reference set to our new node
                currentNode.setNext(newNode);
            }

        }
    }
//            ListNode<T> oldLast = last;
//            this.last = new ListNode<>(t, oldLast, null);
//            oldLast.setNext(this.last);

//        if (!this.isEmpty()) {
//            ListNode<T> newNode = new ListNode<>(t, this.getLast(), null);
//            this.getLast().setNext(newNode);
//        } else {
//            ListNode<T> newNode = new ListNode<>(t, null, null);
//        }

    //    TODO: need to fix
    @Override
    public void remove(T o) {
        int index = this.indexOf(o);
        if (index >= 0 || index < size()) {
            if (this.first != null) {
                ListNode<T> currentNode = this.first;
                for (int i = 0; i < index; i++) {
                    if (currentNode.getNext() == null)
                        break;
                    currentNode = currentNode.getNext();
                }
                currentNode.setNext(currentNode.getNext().getNext());
                // decrement the number of elements variable
            }
        }
    }

//        if (this.contains(o)) {
////            removes the first node (if it exists) with the value equal to the method parameter.
//            int index = indexOf(o);
//            remove(index);
//        }


//        TODO: how to implement this?
    @Override
    public void clear() {
        if (!this.isEmpty()) {
            this.first.setNext(null);
//            this.last.setPrevious(null);
        }
    }

    //    TODO: need to fix
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("List index is out of bound");
        }
        ListNode<T> currentNode = null;
        currentNode = this.first.getNext();
        for (int i = 0; i < index; i++) {
            if (currentNode.getNext() == null) {
                return null;
            }
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

//            int count = 0;
//            while (currentNode.getNext() != null) {
//                if (count == index) {
//                    return currentNode.getValue();
//                }
//                count += 1;
//                currentNode = currentNode.getNext();
//            }
//            return null;

//    TODO: need to fix
    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException {
        ListNode<T> newNode = new ListNode<>(element);
        ListNode<T> currentNode = this.first;
        if (index > this.size() - 1) {
            throw new IndexOutOfBoundsException("List index is out of bound");
        } else {
            if (currentNode != null) {
                // crawl to the requested index or the last element in the list, whichever comes first
                for (int i = 0; i < index && currentNode.getNext() != null; i++) {
                    currentNode = currentNode.getNext();
                }
            }
            // set the new node's next-node reference to this node's next-node reference
            newNode.setNext(currentNode.getNext());
            // now set this node's next-node reference to the new node
            currentNode.setNext(newNode);

        }
    }
//            for (int i = this.size() - 1; i >= index; i--) {
//                if (i == this.size() - 1) {
//                    ListNode<T> newNode = new ListNode<>(element, getLast(), null);
//                    getLast().setNext(newNode);
//                } else if (i == 0) {
//                    ListNode<T> newNode = new ListNode<>(element, null, getFirst());
//                    getFirst().setPrevious(newNode);
//                } else {
//                    ListNode<T> newNode = new ListNode<>(element);
//                    ListNode<T> previousNode = new ListNode<>(this.get(i - 1));
//                    ListNode<T> currentNode = new ListNode<>(this.get(i));
//                    newNode.setPrevious(previousNode);
//                    newNode.setNext(currentNode);
//                    previousNode.setNext(newNode);
//                    currentNode.setPrevious(newNode);
//                }
//            }


//    TODO: need to change
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
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
        int count = 0;
        ListNode<T> currentNode = this.first;
        if (currentNode == null) {
            return -1;
        }
        while (currentNode.getNext() != null) {
            if (currentNode.getValue() == o) {
                return count;
            }
            count += 1;
            currentNode = currentNode.getNext();
        }
        return -1;
    }

//     The return value should consist of the toString() return of every value, separated by ,
//     (a comma followed by a single space) and encapsulated in brackets: []
    @Override
    public String toString() {
        String output = "";
        if (this.first != null) {
            ListNode<T> currentNode = this.first.getNext();
            while (currentNode != null) {
                output += "[" + currentNode.getValue().toString() + "]";
                currentNode = currentNode.getNext();
            }
        }
        return output;
    }


//        List<T> elements = new ArrayList<>();
//        if (this.isEmpty()) {
//            return "[]";
//        } else {
//            if (this.size() == 1) {
//                T value = get(0);
//                return this.value.toString();
//            } else {
//            // iterate through list and add value as string to list
//                int count = 0;
//                ListNode<T> currentNode = this.first;
//                if (currentNode == null) {
//                    return "[]";
//                }
//                while(currentNode.getNext() != null) {
//                    elements.add(currentNode.getValue());
//                    count += 1;
//                    currentNode = currentNode.getNext();
//                }
//                return "[" + elements.stream().map(String::valueOf).collect(Collectors.joining(",")) + "]";
//            }
//        }
//    }

}
