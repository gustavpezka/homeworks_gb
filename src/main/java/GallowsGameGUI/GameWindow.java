package GallowsGameGUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GameWindow extends JFrame implements ActionListener{

        private String letter;
        JPanel buttonPanel;
        JLabel wordPanel;
        JLabel gallowsPanel;
        ImageIcon imageIcon;
        private String word;
        private Font font1 = new Font("Serif", Font.BOLD, 25);
        private static String[] OPEN_TEXT_ARRAY;
        private static String[] HIDDEN_TEXT_ARRAY = {"Welcome to Gallows. Prepare to Die!"};
        private static final int MAX_ATTEMPT_COUNT = 6;
        private static int counter = 0;
        private static int letterCounterToWin = 0;
        public static boolean gameEnd = false;
        private JButton generateButton, aBut, bBut, cBut, dBut, eBut, fBut, gBut,
                hBut, iBut, jBut, kBut, lBut, mBut, nBut, oBut, pBut, qBut, rBut,
                sBut, tBut, uBut, vBut, wBut, xBut, yBut, zBut;

    public GameWindow(String wordToGuess){
            this.word = wordToGuess;
            setBounds(500, 200, 600, 600);
            setTitle("Gallows");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            //Создаём текстовое поле для вывода слова
            wordPanel = new JLabel(String.join(" ", HIDDEN_TEXT_ARRAY));
            wordPanel.setHorizontalAlignment(SwingConstants.CENTER);
            wordPanel.setFont(font1);

            //Создаем панель с виселицей
            imageIcon = new ImageIcon("src/main/resources/Images/0.gif");
            gallowsPanel = new JLabel(imageIcon, JLabel.CENTER);


            //Создаём панель с кнопочками
            buttonPanel = new JPanel(new FlowLayout());
            generateButton = new JButton("Generate");
            aBut = new JButton("a");
            bBut = new JButton("b");
            cBut = new JButton("c");
            dBut = new JButton("d");
            eBut = new JButton("e");
            fBut = new JButton("f");
            gBut = new JButton("g");
            hBut = new JButton("h");
            iBut = new JButton("i");
            jBut = new JButton("j");
            kBut = new JButton("k");
            lBut = new JButton("l");
            mBut = new JButton("m");
            nBut = new JButton("n");
            oBut = new JButton("o");
            pBut = new JButton("p");
            qBut = new JButton("q");
            rBut = new JButton("r");
            sBut = new JButton("s");
            tBut = new JButton("t");
            uBut = new JButton("u");
            vBut = new JButton("v");
            wBut = new JButton("w");
            xBut = new JButton("x");
            yBut = new JButton("y");
            zBut = new JButton("z");

            //Добавляем слушателей
            generateButton.addActionListener(this);
            generateButton.setEnabled(true);
            aBut.addActionListener(this);
            aBut.setEnabled(false);
            bBut.addActionListener(this);
            bBut.setEnabled(false);
            cBut.addActionListener(this);
            cBut.setEnabled(false);
            dBut.addActionListener(this);
            dBut.setEnabled(false);
            eBut.addActionListener(this);
            eBut.setEnabled(false);
            fBut.addActionListener(this);
            fBut.setEnabled(false);
            gBut.addActionListener(this);
            gBut.setEnabled(false);
            hBut.addActionListener(this);
            hBut.setEnabled(false);
            iBut.addActionListener(this);
            iBut.setEnabled(false);
            jBut.addActionListener(this);
            jBut.setEnabled(false);
            kBut.addActionListener(this);
            kBut.setEnabled(false);
            lBut.addActionListener(this);
            lBut.setEnabled(false);
            mBut.addActionListener(this);
            mBut.setEnabled(false);
            nBut.addActionListener(this);
            nBut.setEnabled(false);
            oBut.addActionListener(this);
            oBut.setEnabled(false);
            pBut.addActionListener(this);
            pBut.setEnabled(false);
            qBut.addActionListener(this);
            qBut.setEnabled(false);
            rBut.addActionListener(this);
            rBut.setEnabled(false);
            sBut.addActionListener(this);
            sBut.setEnabled(false);
            tBut.addActionListener(this);
            tBut.setEnabled(false);
            uBut.addActionListener(this);
            uBut.setEnabled(false);
            vBut.addActionListener(this);
            vBut.setEnabled(false);
            wBut.addActionListener(this);
            wBut.setEnabled(false);
            xBut.addActionListener(this);
            xBut.setEnabled(false);
            yBut.addActionListener(this);
            yBut.setEnabled(false);
            zBut.addActionListener(this);
            zBut.setEnabled(false);


            //Добавляем кнопки на панель
            buttonPanel.add(generateButton);
            buttonPanel.add(aBut);
            buttonPanel.add(bBut);
            buttonPanel.add(cBut);
            buttonPanel.add(dBut);
            buttonPanel.add(eBut);
            buttonPanel.add(fBut);
            buttonPanel.add(gBut);
            buttonPanel.add(hBut);
            buttonPanel.add(iBut);
            buttonPanel.add(jBut);
            buttonPanel.add(kBut);
            buttonPanel.add(lBut);
            buttonPanel.add(mBut);
            buttonPanel.add(nBut);
            buttonPanel.add(oBut);
            buttonPanel.add(pBut);
            buttonPanel.add(qBut);
            buttonPanel.add(rBut);
            buttonPanel.add(sBut);
            buttonPanel.add(tBut);
            buttonPanel.add(uBut);
            buttonPanel.add(vBut);
            buttonPanel.add(wBut);
            buttonPanel.add(xBut);
            buttonPanel.add(yBut);
            buttonPanel.add(zBut);

            //Создаём сплит виселицы и слова
            JSplitPane topPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, gallowsPanel,wordPanel);

            //Создаём общий сплит
            JSplitPane allPanes = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPane, buttonPanel);
            getContentPane().add(allPanes);
            setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        letter = e.getActionCommand();
        if(letter.equals("Generate")){
            makeTextArrays(word);
            wordPanel.setText(String.join(" ", HIDDEN_TEXT_ARRAY));
            JButton buttonClicked = (JButton) e.getSource();
            buttonPanel.remove(buttonClicked);
            buttonPanel.revalidate();
            buttonPanel.repaint();
            wordPanel.revalidate();
            wordPanel.repaint();
            System.out.println(word);
            aBut.setEnabled(true);
            bBut.setEnabled(true);
            cBut.setEnabled(true);
            dBut.setEnabled(true);
            eBut.setEnabled(true);
            fBut.setEnabled(true);
            gBut.setEnabled(true);
            hBut.setEnabled(true);
            iBut.setEnabled(true);
            jBut.setEnabled(true);
            kBut.setEnabled(true);
            lBut.setEnabled(true);
            mBut.setEnabled(true);
            nBut.setEnabled(true);
            oBut.setEnabled(true);
            pBut.setEnabled(true);
            qBut.setEnabled(true);
            rBut.setEnabled(true);
            sBut.setEnabled(true);
            tBut.setEnabled(true);
            uBut.setEnabled(true);
            vBut.setEnabled(true);
            wBut.setEnabled(true);
            xBut.setEnabled(true);
            yBut.setEnabled(true);
            zBut.setEnabled(true);

        }else{
            JButton buttonClicked = (JButton) e.getSource();
            buttonPanel.remove(buttonClicked);
            checkIfLetterIsInWord(letter);
            buttonPanel.revalidate();
            buttonPanel.repaint();
        }
    }

    private void checkIfLetterIsInWord(String enteredLetter) {
        boolean guess = false;
        for (int j = 0; j < OPEN_TEXT_ARRAY.length; j++) {
            if (enteredLetter.equals(OPEN_TEXT_ARRAY[j])) {
                HIDDEN_TEXT_ARRAY[j] = OPEN_TEXT_ARRAY[j];
                wordPanel.setText(String.join(" ", HIDDEN_TEXT_ARRAY));
                wordPanel.revalidate();
                wordPanel.repaint();
                letterCounterToWin += 1;
                guess = true;
            }
        }
        if(!guess){
            counter += 1;
            drawHangman();
        }
        if (counter > MAX_ATTEMPT_COUNT || letterCounterToWin == OPEN_TEXT_ARRAY.length){
            gameEnd = true;
            if (counter>=MAX_ATTEMPT_COUNT){
                imageIcon = new ImageIcon("src/main/resources/Images/lose.gif");
                gallowsPanel.setIcon(imageIcon);
                gallowsPanel.revalidate();
                gallowsPanel.repaint();
                wordPanel.setText(String.join(" ", OPEN_TEXT_ARRAY));
                wordPanel.revalidate();
                wordPanel.repaint();
                buttonPanel.removeAll();
                Timer timer = new Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }else{
                imageIcon = new ImageIcon("src/main/resources/Images/win.gif");
                gallowsPanel.setIcon(imageIcon);
                gallowsPanel.revalidate();
                gallowsPanel.repaint();
                buttonPanel.removeAll();
                Timer timer = new Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

    private void makeTextArrays(String word) {                           //Разбиваем слово на массив букв
        String[] openTextArray = word.split("", 0);
        OPEN_TEXT_ARRAY = openTextArray;
        HIDDEN_TEXT_ARRAY = new String[openTextArray.length];
        Arrays.fill(HIDDEN_TEXT_ARRAY, "_");
    }

    private void drawHangman() {
        switch (counter) {
            case 1:
                imageIcon = new ImageIcon("src/main/resources/Images/1.gif");
                gallowsPanel.setIcon(imageIcon);
                gallowsPanel.revalidate();
                gallowsPanel.repaint();
                break;
            case 2:
                imageIcon = new ImageIcon("src/main/resources/Images/2.gif");
                gallowsPanel.setIcon(imageIcon);
                gallowsPanel.revalidate();
                gallowsPanel.repaint();
                break;
            case 3:
                imageIcon = new ImageIcon("src/main/resources/Images/3.gif");
                gallowsPanel.setIcon(imageIcon);
                gallowsPanel.revalidate();
                gallowsPanel.repaint();
                break;
            case 4:
                imageIcon = new ImageIcon("src/main/resources/Images/4.gif");
                gallowsPanel.setIcon(imageIcon);
                gallowsPanel.revalidate();
                gallowsPanel.repaint();
                break;
            case 5:
                imageIcon = new ImageIcon("src/main/resources/Images/5.gif");
                gallowsPanel.setIcon(imageIcon);
                gallowsPanel.revalidate();
                gallowsPanel.repaint();
                break;
            case 6:
                imageIcon = new ImageIcon("src/main/resources/Images/6.gif");
                gallowsPanel.setIcon(imageIcon);
                gallowsPanel.revalidate();
                gallowsPanel.repaint();
                break;
        }
    }
}
