import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;

public class Interface {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Interfață 1");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton openButton = new JButton("Deschide Interfața 2");
            JButton openThirdButton = new JButton("Deschide Interfața 3");

            JPanel panel = new JPanel();
            panel.add(openButton);
            panel.add(openThirdButton);

            frame.getContentPane().add(panel, BorderLayout.CENTER);
            frame.setSize(400, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            openButton.addActionListener(e -> openSecondInterface());
            openThirdButton.addActionListener(e -> openThirdInterface());
        });
    }

    private static void openSecondInterface() {
        SwingUtilities.invokeLater(() -> {
            JFrame secondFrame = new JFrame("Interfața 2");
            secondFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            StackToMatrix stackToMatrix = new StackToMatrix();

            JTextField inputField = new JTextField(10);
            JButton pushButton = new JButton("Push to Stack");
            JTextArea stackArea = new JTextArea(10, 20);
            stackArea.setEditable(false);

            pushButton.addActionListener(e -> {
                try {
                    float element = Float.parseFloat(inputField.getText().trim());
                    stackToMatrix.pushToStack(element);
                    updateStackField(stackToMatrix, stackArea);
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(secondFrame, "Introduceți un număr valid!");
                }
            });

            JButton buildMatrixButton = new JButton("Construiește Matricea");
            JTextArea matrixArea = new JTextArea(10, 20);
            matrixArea.setEditable(false);

            buildMatrixButton.addActionListener(e -> {
                stackToMatrix.buildMatrixFromStack();
                updateMatrixField(stackToMatrix, matrixArea);
            });

            JButton closeButton = new JButton("Close");
            closeButton.addActionListener(e -> secondFrame.dispose());

            JPanel inputPanel = new JPanel();
            inputPanel.add(new JLabel("Introduceți un număr: "));
            inputPanel.add(inputField);
            inputPanel.add(pushButton);

            JPanel displayPanel = new JPanel();
            displayPanel.add(new JLabel("Stivă: "));
            displayPanel.add(stackArea);
            displayPanel.add(buildMatrixButton);
            displayPanel.add(new JLabel("Matricea patratică rezultată: "));
            displayPanel.add(matrixArea);

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(closeButton);

            secondFrame.getContentPane().add(inputPanel, BorderLayout.NORTH);
            secondFrame.getContentPane().add(displayPanel, BorderLayout.CENTER);
            secondFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
            secondFrame.setSize(400, 400);
            secondFrame.setLocationRelativeTo(null);
            secondFrame.setVisible(true);
        });
    }

    private static void openThirdInterface() {
        SwingUtilities.invokeLater(() -> {
            JFrame thirdFrame = new JFrame("Interfața 3");
            thirdFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            LinkQueue linkQueue1 = new LinkQueue();
            LinkQueue linkQueue2 = new LinkQueue();

            JTextField inputField1 = new JTextField(10);
            JTextField inputField2 = new JTextField(10);
            JButton enqueueButton1 = new JButton("Enqueue to Queue 1");
            JButton enqueueButton2 = new JButton("Enqueue to Queue 2");
            JTextArea queueArea1 = new JTextArea(10, 20);
            JTextArea queueArea2 = new JTextArea(10, 20);
            queueArea1.setEditable(false);
            queueArea2.setEditable(false);

            enqueueButton1.addActionListener(e -> {
                try {
                    long element = Long.parseLong(inputField1.getText().trim());
                    linkQueue1.insert(element);
                    updateQueueField(linkQueue1, queueArea1);
                    inputField1.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(thirdFrame, "Introduceți un număr valid!");
                }
            });

            enqueueButton2.addActionListener(e -> {
                try {
                    long element = Long.parseLong(inputField2.getText().trim());
                    linkQueue2.insert(element);
                    updateQueueField(linkQueue2, queueArea2);
                    inputField2.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(thirdFrame, "Introduceți un număr valid!");
                }
            });

            JButton concatenateButton = new JButton("Concatenează Cozi");
            JTextArea concatenatedQueueArea = new JTextArea(10, 20);
            concatenatedQueueArea.setEditable(false);

            concatenateButton.addActionListener(e -> {
                LinkQueue concatenatedQueue = LinkQueue.concatenateQueue(linkQueue1, linkQueue2);
                updateQueueField(concatenatedQueue, concatenatedQueueArea);
            });

            JButton closeButton = new JButton("Close");
            closeButton.addActionListener(e -> thirdFrame.dispose());

            JPanel inputPanel = new JPanel();
            inputPanel.add(new JLabel("Introduceți un număr pentru Coada 1: "));
            inputPanel.add(inputField1);
            inputPanel.add(enqueueButton1);
            inputPanel.add(new JLabel("Introduceți un număr pentru Coada 2: "));
            inputPanel.add(inputField2);
            inputPanel.add(enqueueButton2);

            JPanel displayPanel = new JPanel();
            displayPanel.add(new JLabel("Coada 1: "));
            displayPanel.add(queueArea1);
            displayPanel.add(new JLabel("Coada 2: "));
            displayPanel.add(queueArea2);
            displayPanel.add(concatenateButton);
            displayPanel.add(new JLabel("Coada Concatenată: "));
            displayPanel.add(concatenatedQueueArea);

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(closeButton);

            thirdFrame.getContentPane().add(inputPanel, BorderLayout.NORTH);
            thirdFrame.getContentPane().add(displayPanel, BorderLayout.CENTER);
            thirdFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
            thirdFrame.setSize(400, 400);
            thirdFrame.setLocationRelativeTo(null);
            thirdFrame.setVisible(true);
        });
    }

private static void updateQueueField(LinkQueue queue, JTextArea queueArea) {
    queueArea.setText("");  // Clear the JTextArea
    queue.displayQueue(queueArea);
}


    private static void updateStackField(StackToMatrix stackToMatrix, JTextArea stackArea) {
        stackArea.setText(stackToMatrix.getStackAsString());
    }

    private static void updateMatrixField(StackToMatrix stackToMatrix, JTextArea matrixArea) {
        matrixArea.setText(stackToMatrix.getMatrixAsString());
    }
}
