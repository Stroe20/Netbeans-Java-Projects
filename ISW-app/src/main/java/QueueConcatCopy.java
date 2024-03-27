
import javax.swing.JTextArea;

public class QueueConcatCopy {
    public static void main(String[] args) {
        LinkQueue queue1 = new LinkQueue();
        queue1.insert(20);
        queue1.insert(40);
        queue1.insert(60);
        queue1.insert(80);

        JTextArea textArea1 = new JTextArea();
        queue1.displayQueue(textArea1);
        System.out.println("Queue 1:");
        System.out.println(textArea1.getText());

        LinkQueue queue2 = new LinkQueue();
        queue2.insert(100);
        queue2.insert(102);
        queue2.insert(104);
        queue2.insert(106);
        queue2.insert(108);

        JTextArea textArea2 = new JTextArea();
        queue2.displayQueue(textArea2);
        System.out.println("Queue 2:");
        System.out.println(textArea2.getText());

        LinkQueue concatenatedQueue = LinkQueue.concatenateQueue(queue1, queue2);

        JTextArea textAreaConcatenated = new JTextArea();
        concatenatedQueue.displayQueue(textAreaConcatenated);
        System.out.println("Concatenated Queue:");
        System.out.println(textAreaConcatenated.getText());
    }
}
