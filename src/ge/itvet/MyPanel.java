package ge.itvet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyPanel extends JPanel {
    private static int turn = 0;
    JLabel label = new JLabel("End");
    JButton[] jButtons = new JButton[9];

    /*
     * აქ მგონი შეიძლება ერთი for-ის გამოტოვება,
     * @see this.alternativeOfTheInitializationBlock
     */ {
        for (int i = 0; i < 9; i++) {
            jButtons[i] = new JButton();
            // აქ ყოველ კლიკზე ტექსტი რომ არ ცვალო, ახალი ფონტი არ შექმნა მინიმუმ 9ჯერ და მაქსიმუმ 18ჯერ, ხომ არ ჯობდა jButtons[counter].setName(String.valueOf(counter)); გამოგეყენებინა?
            jButtons[i].setFont(new Font("Arial", Font.BOLD, 1));
            jButtons[i].setText(String.valueOf(i));
        }
        int counter = 0;
        setLayout(new GridBagLayout());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (counter < 9) {
                    add(j, i, jButtons[counter]);
                    jButtons[counter].addActionListener(this::actionPerformed);
                    jButtons[counter++].setPreferredSize(new Dimension(250, 250));
                }
            }
        }
    }


    private void alternativeOfTheInitializationBlock() {
        int counter = 0;

        setLayout(new GridBagLayout());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (counter < 9) {
                    jButtons[counter] = new JButton();
                    jButtons[counter].setFont(new Font("Arial", Font.BOLD, 1));
                    jButtons[counter].setText(String.valueOf(counter));
                    add(j, i, jButtons[counter]);
                    jButtons[counter].addActionListener(this::actionPerformed);
                    jButtons[counter++].setPreferredSize(new Dimension(250, 250));
                }
            }
        }
    }

    public void add(int x, int y, Component comp) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        add(comp, gbc);
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if ((turn & 1) == 0) button.setText("X");
        else button.setText("O"); // აქ ყოველ კლიკზე ტექსტი რომ არ ცვალო, ახალი ფონტი არ შექმნა, ხომ არ ჯობდა ინიცლიალიზაციის დროს სახელი დაგერქმია ინდექსი და არა ტექსტი?
        turn++;
        button.setFont(new Font("Arial", Font.BOLD, 100));
        button.setEnabled(false);
        if (turn == 9) check(true); // check(turn == 9); არა?
        check(ifWon(jButtons));

    }

    /*
     * 1. აქ პარამეტრად რატომ გადასცემ JButton[] buttons? jButtons-ზე წვდომა ისედაც აქვს ?
     * 2. აქ ლამაზი ხომ არ იქნებოდა ესეთი მეთოდი დაგემატებინა?
     *   private boolean compareButtonText(int index1, int index2) {
     *       return jButtons[index1].getText().equals( jButtons[index2].getText());
     *   }
     */
    public boolean ifWon(JButton[] buttons) {
        int i = 0, j = 3, k = 6, i1 = 0, j1 = 1, k1 = 2, i2 = 0, j2 = 2;
        if ((buttons[i].getText().equals(buttons[++i].getText()) && buttons[i].getText().equals(buttons[++i].getText())) || (buttons[j].getText().equals(buttons[++j].getText()) && buttons[j].getText().equals(buttons[++j].getText())) || (buttons[k].getText().equals(buttons[++k].getText()) && buttons[k].getText().equals(buttons[++k].getText())))
            return true;
        else if ((buttons[i1].getText().equals(buttons[i1 + 3].getText()) && buttons[i1 + 3].getText().equals(buttons[i1 + 6].getText())) || (buttons[j1].getText().equals(buttons[j1 + 3].getText()) && buttons[j1 + 3].getText().equals(buttons[j1 + 6].getText())) || (buttons[k1].getText().equals(buttons[k1 + 3].getText()) && buttons[k1 + 3].getText().equals(buttons[k1 + 6].getText())))
            return true;
        else
            return (buttons[i2].getText().equals(buttons[i2 + 4].getText()) && buttons[i2 + 4].getText().equals(buttons[i2 + 8].getText())) || (buttons[j2].getText().equals(buttons[j2 + 2].getText()) && buttons[j2 + 2].getText().equals(buttons[j2 + 4].getText()));
    }

    private boolean compareButtonText(int index1, int index2) {
        return jButtons[index1].getText().equals( jButtons[index2].getText());
    }

    public boolean ifWon1(JButton[] buttons) {
        int j1 = 1, k1 = 2;
        if ((buttons[0].getText().equals(buttons[1].getText()) && buttons[1].getText().equals(buttons[2].getText())) || (buttons[3].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[5].getText())) || (buttons[6].getText().equals(buttons[7].getText()) && buttons[7].getText().equals(buttons[8].getText())))
            return true;
        else if ((buttons[0].getText().equals(buttons[3].getText()) && buttons[3].getText().equals(buttons[6].getText())) || (buttons[j1].getText().equals(buttons[j1 + 3].getText()) && buttons[j1 + 3].getText().equals(buttons[j1 + 6].getText())) || (buttons[k1].getText().equals(buttons[k1 + 3].getText()) && buttons[k1 + 3].getText().equals(buttons[k1 + 6].getText())))
            return true;
        else if ((buttons[0].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[8].getText())) || (buttons[2].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[8].getText())))
            return true;

        return false;
    }

    public void check(boolean b) {
        if (b) {
            label.setFont(new Font("Arial", Font.BOLD, 100));

            for (int i = 0; i < 9; i++)
                remove(jButtons[i]);
            revalidate();
            repaint();

            if (turn % 2 == 0)
                label.setText("O Won");
            else if (turn != 9)
                label.setText("X Won");
            add(label);
        }
    }
}
