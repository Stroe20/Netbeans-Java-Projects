
import javax.swing.JTextArea;

public class LinkQueue {
    private Link first;
    private Link last;

    public LinkQueue() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    public long remove() {
        long temp = first.dData;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
    }

    public void displayQueue(JTextArea textArea) {
        Link current = first;
        while (current != null) {
            textArea.append(current.dData + " ");
            current = current.next;
        }
        textArea.append("\n");
    }

    public static LinkQueue concatenateQueue(LinkQueue queue1, LinkQueue queue2) {
        LinkQueue resultQueue = new LinkQueue();

        while (!queue1.isEmpty()) {
            long element = queue1.remove();
            resultQueue.insert(element);
        }

        while (!queue2.isEmpty()) {
            long element = queue2.remove();
            resultQueue.insert(element);
        }

        return resultQueue;
    }
}
