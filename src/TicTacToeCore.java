import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToeCore implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToeCore() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        frame.getContentPane().setBackground(Color.white);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text_field.setBackground(Color.white);
        text_field.setForeground(Color.DARK_GRAY);
        text_field.setFont(new Font("Arial", Font.BOLD, 45));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic-Tac-Toe");
        text_field.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 1600, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Calibri", Font.PLAIN, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(text_field);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setText("X");
                        player1_turn = false;
                        text_field.setText("O");
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setText("O");
                        player1_turn = true;
                        text_field.setText("X");
                    }
                }
                check();
            }
        }
    }

    public void firstTurn() {
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            text_field.setText("X");
        } else {
            player1_turn = false;
            text_field.setText("O");
        }
    }

    public void check() {
        // Checks the eight possible winning scenarios from top-left button[0] to bottom-right button[8]
        for (int i = 0; i < 7; i++) {
            String val = buttons[i].getText();
            switch (i) {
                case 0:
                    if (val != "") {
                        if (Objects.equals(buttons[0].getText(), buttons[1].getText())) {
                            if (Objects.equals(buttons[1].getText(), buttons[2].getText())) {
                                victoryCondition(val);
                            }
                        } else if (Objects.equals(buttons[0].getText(), buttons[3].getText())) {
                            if (Objects.equals(buttons[3].getText(), buttons[6].getText())) {
                                victoryCondition(val);
                            }
                        } else if (Objects.equals(buttons[0].getText(), buttons[4].getText())) {
                            if (Objects.equals(buttons[4].getText(), buttons[8].getText())) {
                                victoryCondition(val);
                            }
                        }
                    }
                    break;
                case 1:
                    if (val != "") {
                        if (Objects.equals(buttons[1].getText(), buttons[4].getText())) {
                            if (Objects.equals(buttons[4].getText(), buttons[7].getText())) {
                                victoryCondition(val);
                            }
                        }
                    }
                    break;
                case 2:
                    if (val != "") {
                        if (Objects.equals(buttons[2].getText(), buttons[4].getText())) {
                            if (Objects.equals(buttons[4].getText(), buttons[6].getText())) {
                                victoryCondition(val);
                            }
                        } else if (Objects.equals(buttons[2].getText(), buttons[5].getText())) {
                            if (Objects.equals(buttons[5].getText(), buttons[8].getText())) {
                                victoryCondition(val);
                            }
                        }
                    }
                    break;
                case 3:
                    if (val != "") {
                        if (Objects.equals(buttons[3].getText(), buttons[4].getText())) {
                            if (Objects.equals(buttons[4].getText(), buttons[5].getText())) {
                                victoryCondition(val);
                            }
                        }
                    }
                    break;
                case 6:
                    if (val != "") {
                        if (Objects.equals(buttons[6].getText(), buttons[7].getText())) {
                            if (Objects.equals(buttons[7].getText(), buttons[8].getText())) {
                                victoryCondition(val);
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }


    public void victoryCondition(String val) {
        text_field.setText(val + " wins");
    }

    public void oVictory(int a, int b, int c) {

    }
}
