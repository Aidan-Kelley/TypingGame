package Main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game {
    private JFrame window;
    private JLabel text;
    private char currentLetter;
    private String displayString;

    public Game() {
        initGameWindow();
        initText();

    }

    private void initText() {
        text = new JLabel();
        text.setFont(new Font("Calibri", 1, 50));
        displayString = "";
        for (int i = 0; i < 44; i++) {
            displayString += (char) (Math.random() * 26 + 'a');
        }
        text.setText(displayString);
        nextLetter();
        window.getContentPane().add(text);
    }

    private void nextLetter() {
        displayString = displayString.substring(1) + (char) (Math.random() * 26 + 'a');
        currentLetter = displayString.charAt(0);
        text.setText(displayString);
    }

    private void initGameWindow() {
        window = new JFrame("Typing");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 400);
        window.setResizable(false);
        window.setVisible(true);
        window.addKeyListener(new Listener());
    }

    private class Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == currentLetter)
                nextLetter();
        }
    }

}
