package GallowsGameGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame implements ActionListener{

    private String letter;
        public String word = "Welcome to Gallows. Abandon all Hope";

        public GameWindow(){
            setBounds(500, 200, 600, 600);
            setTitle("Gallows");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Font font = new Font("Serif", Font.BOLD, 15);
            Font font1 = new Font("Serif", Font.ITALIC, 25);

            //Create a text area.
            JTextArea gallowsTextArea = new JTextArea(
                    "GUESS OR DIE!\n" +
                            "         _|____ \n" +
                            "           |   /  | \n" +
                            "           | /    \n" +
                            "           |     \n" +
                            "           |     \n" +
                            "           |     \n" +
                            "         _|_____");
            gallowsTextArea.setFont(font);
            gallowsTextArea.setEditable(false);
            add(gallowsTextArea, BorderLayout.CENTER);

            //Создаём текстовое поле для вывода слова
            JLabel label = new JLabel(word);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setFont(font1);

            //Создаём панель с кнопочками
            JPanel buttonPanel = new JPanel(new FlowLayout());
            JButton aButton = new JButton("a");
            JButton bButton = new JButton("b");
            JButton cButton = new JButton("c");
            JButton dButton = new JButton("d");

            //Создаем группу кнопочек
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(aButton);
            buttonGroup.add(bButton);
            buttonGroup.add(cButton);
            buttonGroup.add(dButton);

            //Добавляем слушателей
            aButton.addActionListener(this);


            //Добавляем кнопки на панель
            buttonPanel.add(aButton);
            buttonPanel.add(bButton);
            buttonPanel.add(cButton);
            buttonPanel.add(dButton);

            //Создаём сплит виселицы и слова
            JSplitPane top = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, gallowsTextArea,label);

            //Создаём общий сплит
            JSplitPane allPanes = new JSplitPane(JSplitPane.VERTICAL_SPLIT, top, buttonPanel);

            getContentPane().add(allPanes);
            setVisible(true);
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        letter = e.getActionCommand();
        System.out.println(letter);
        JButton buttonClicked = (JButton) e.getSource();
        Container parent = (Container) e.getSource();
        getContentPane().remove(buttonClicked);
        parent.remove(buttonClicked);
        parent.revalidate();
        parent.repaint();
    }

    public static void main(String[] args) {
        new GameWindow();
    }
}
