package de.tum.in.ase;

public interface MyList<T> {
    //Simplified Version of java.util.List<T>

    /**
     * @return the number of elements in this list.
     */
    int size();

    /**
     * @return true if this list contains no elements, otherwise false
     */
    boolean isEmpty();

    /**
     * Returns true if this list contains the specified element.
     * More formally, returns true if and only if this list contains
     * at least one element e such that (o==null ? e==null : o.equals(e)).
     *
     * @param o - element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    boolean contains(T o);

    /**
     * Appends the specified element to the end of this list
     *
     * @param t - element to be appended to this list
     */
    void add(T t);

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If this list does not contain the element, it is unchanged.
     *
     * @param o - element to be removed from this list, if present
     */
    void remove(T o);

    /**
     * Removes all the elements from this list
     */
    void clear();

    /**
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    T get(int index);

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the
     * right (adds one to their indices).
     *
     * @param index   - index at which the specified element is to be inserted
     * @param element - element to be inserted
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
     */
    void add(int index, T element);

    /**
     * Removes the element at the specified position in this list (optional operation).
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     *
     * @param index - the index of the element to be removed
     * @return - the element previously at the specified position
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    T remove(int index);

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element. More formally, returns the lowest index i
     * such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
     *
     * @param o - element to search for
     * @return the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element
     */
    int indexOf(T o);
}
