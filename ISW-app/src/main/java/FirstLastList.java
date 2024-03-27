
// FirstLastList.java (modificări pentru a întoarce șiruri pentru afișare)
public class FirstLastList {
    private Link first;
    private Link last;

    public FirstLastList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertLast(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    public long deleteFirst() {
        long temp = first.dData;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
    }

    public String displayList() {
        StringBuilder stringBuilder = new StringBuilder();
        Link current = first;
        while (current != null) {
            stringBuilder.append(current.dData).append(" ");
            current = current.next;
        }
        stringBuilder.append(" ");
        return stringBuilder.toString();
    }
}
