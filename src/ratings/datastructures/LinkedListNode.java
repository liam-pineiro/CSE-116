package ratings.datastructures;

public class LinkedListNode<T> {

    private T value;
    private LinkedListNode<T> next;

    public LinkedListNode(T val, LinkedListNode<T> next) {
        this.value = val;
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }

    public void setNext(LinkedListNode<T> node) {
        this.next = node;
    }

    public LinkedListNode<T> getNext() {
        return this.next;
    }

    public int size() {
        if (this.next == null) {
            return 1;
        } else {
            return 1 + this.next.size();
        }
    }

    public String toString() {
        String out = "";
        out += this.value;
        if (this.next != null) {
            out += this.next.toString() + " ";
        }
        return out;
    }

    public LinkedListNode<T> getElement(T value) {
        if (this.value.equals(value)) {
            return this;
        } else if (this.next == null) {
            return null;
        } else {
            return this.next.getElement(value);
        }
    }

    public void append(T value) {
        if (this.next == null) {
            this.next = new LinkedListNode<>(value, null);
        } else {
            this.next.append(value);
        }
    }

    public void insert(T value, int loc) {
        if (loc == 0) {
            this.next = new LinkedListNode<>(this.value, this.next);
            this.value = value;
        } else {
            this.next.insert(value, loc - 1);
        }
    }

    public static boolean areLinkedListsEqual(LinkedListNode<ratings.Rating> list1, LinkedListNode<ratings.Rating> list2) {
        while (list1 != null && list2 != null) {
            if (!(list1.getValue().getRating() == list2.getValue().getRating())) {
                return false;
            }
            list1 = list1.getNext();
            list2 = list2.getNext();
        }

        return list1 == null && list2 == null;
    }
}
