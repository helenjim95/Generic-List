package de.tum.in.ase;


// make it implement the interface MyList
public class LinkedList<T> implements MyList<T> {

    private ListNode<T> first;
    private ListNode<T> last;

    public LinkedList() {
        this.first = null;
        this.last = null;
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
        int size = 0;
        while (current != null) {
            current = current.getNext();
            size += 1;
        }
        return size;
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
        while(currentNode != null) {
            if (currentNode.getValue().equals(o)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public void add(T t) {
        ListNode<T> newNode = new ListNode<>(t);
        if (this.first == null) {
            this.first = newNode;
            this.first.setPrevious(null);
            this.last = newNode;
            this.last.setNext(null);
        } else {
            this.last.setNext(newNode);
            newNode.setPrevious(this.last);
            this.last = newNode;
            this.last.setNext(null);
        }
    }

    //    TODO: need to fix
    @Override
    public void remove(T o) {
        int index = this.indexOf(o);
        ListNode<T> currentNode = this.first;
//        TODO: need to fix here
        if (this.size() > 0  && index >= 0 && index < this.size()) {
            if (currentNode != null) {
                if (index == 0) {
                    if (this.size() == 1) {
                        this.clear();
                    } else {
                        this.first = currentNode.getNext();
                        this.first.setPrevious(null);
                    }
                } else {
                    for (int i = 0; i < index; i++) {
                        currentNode = currentNode.getNext();
                    }
                    if (index == this.size() - 1) {
                        this.last = currentNode.getPrevious();
                        this.last.setNext(null);
                    } else {
                        currentNode.getPrevious().setNext(currentNode.getNext());
                        currentNode.getNext().setPrevious(currentNode.getPrevious());
                    }
                }
            }
        }
    }

    @Override
    public void clear() {
        this.first = null;
        this.last = null;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("List index is out of bound");
        }
        ListNode<T> currentNode = this.first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException {
        ListNode<T> newNode = new ListNode<>(element);
        ListNode<T> currentNode = this.first;
        if (index < 0 || index > this.size() - 1 || (this.size() == 0 && index != 0)) {
            throw new IndexOutOfBoundsException("List index is out of bound");
        } else {
//            If the list is empty, add element to index 0
            if (this.size() == 0 && index == 0) {
                this.first = newNode;
                this.first.setPrevious(null);
                this.first.setNext(null);
            } else if (currentNode != null) {
//                If the list is not 0, add element to index 0
                if (index == 0) {
                    this.first = newNode;
                    this.first.setPrevious(null);
                    this.first.setNext(currentNode);
                    currentNode.setPrevious(this.first);
                } else { // add element to index > 0
                    for (int i = 0; i < index; i++) {
                        currentNode = currentNode.getNext();
                    }
                    newNode.setNext(currentNode);
                    newNode.setPrevious(currentNode.getPrevious());
                    currentNode.getPrevious().setNext(newNode);
                    currentNode.setPrevious(newNode);
                }
//                    for (int i = 0; i < index; i++) {
//                        currentNode = currentNode.getNext();
//                    }
//                    newNode.setPrevious(currentNode.getPrevious());
//                    newNode.setNext(currentNode);
//                    currentNode.getPrevious().setNext(newNode);
//                    currentNode.setPrevious(newNode);
//                }
                    // crawl to the requested index or the last element in the list, whichever comes first
//                    for (int i = 0; i < index && currentNode.getNext() != null; i++) {
//                        // set the new node's next-node reference to this node's next-node reference
//                        newNode.setPrevious(currentNode.getPrevious());
//                        currentNode.setPrevious(newNode);
//                        newNode.setNext(currentNode);
//                        // Check if new node is added as head
//                        if (newNode.getPrevious() != null) {
//                            newNode.getPrevious().setNext(newNode);
//                        } else {
//                            this.first = newNode;
//                        }
//                    }

            }
        }
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("List index is out of bound");
        }
        T node = this.get(index);
        this.remove(node);
        return node;
    }

    @Override
    public int indexOf(T o) {
        int index = 0;
        ListNode<T> currentNode = this.first;
        if (currentNode == null || size() == 0) {
            return -1;
        }
        while (currentNode != null) {
            if(currentNode.getValue().equals(o)) {
                return index;
            }
            index += 1;
            if (currentNode.getValue() != null) {
                currentNode = currentNode.getNext();
            } else {
                break;
            }
        }
        return -1;
    }

//     The return value should consist of the toString() return of every value, separated by ,
//     (a comma followed by a single space) and encapsulated in brackets: []
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        ListNode<T> currentNode = this.first;
        while (currentNode != null) {
            str.append(currentNode.getValue().toString());
            if (currentNode.getNext() != null) {
                str.append(", ");
            }
            currentNode = currentNode.getNext();
        }
        str.append("]");
        return str.toString();
    }
}
