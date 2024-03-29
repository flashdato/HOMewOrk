package ge.edu.itvet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class MyPanel extends JPanel {
    private static int turn=0;
    JButton[] jButtons = new JButton[9];
    {
        for (int i = 0; i < 9 ; i++) {
            jButtons[i]= new JButton();
            jButtons[i].setFont(new Font("Arial",Font.BOLD,1));
            jButtons[i].setText(String.valueOf(i));
        }
        int counter =0;
        setLayout(new GridBagLayout());
        for (int i = 0; i < 3; i++) {
            for (int j=0; j < 3; j++) {
                if(counter<9){

                    add(j,i,jButtons[counter]);
                    jButtons[counter].addActionListener(this::actionPerformed);
                    jButtons[counter++].setPreferredSize(new Dimension(250,250));
                }
            }}
    }
    public void add(int x,int y,Component comp) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        add(comp,gbc);
    }
    public void actionPerformed(ActionEvent e){
        JButton button = (JButton) e.getSource();
        if (turn%2==0) button.setText("X");
        else  button.setText("O");turn++;
        button.setFont(new Font("Arial",Font.BOLD,100));
        button.setEnabled(false);
         check(turn==9);
        check(ifWon(jButtons));

    }
    public boolean ifWon(JButton[] buttons)
    {
        int i=0,j=3,k=6,i1=0,j1=1,k1=2,i2=0,j2=2;
        if( (buttons[i].getText().equals(buttons[++i].getText()) && buttons[i].getText().equals(buttons[++i].getText())) ||(buttons[j].getText().equals(buttons[++j].getText()) && buttons[j].getText().equals(buttons[++j].getText())) ||(buttons[k].getText().equals(buttons[++k].getText()) && buttons[k].getText().equals(buttons[++k].getText()))  )
            return true;
        else
        if((buttons[i1].getText().equals(buttons[i1+3].getText()) &&buttons[i1+3].getText().equals(buttons[i1+6].getText())) ||(buttons[j1].getText().equals(buttons[j1+3].getText()) &&buttons[j1+3].getText().equals(buttons[j1+6].getText())) ||(buttons[k1].getText().equals(buttons[k1+3].getText()) &&buttons[k1+3].getText().equals(buttons[k1+6].getText())))
            return true;
        else
            return (buttons[i2].getText().equals(buttons[i2 + 4].getText()) && buttons[i2 + 4].getText().equals(buttons[i2 + 8].getText())) || (buttons[j2].getText().equals(buttons[j2 + 2].getText()) && buttons[j2 + 2].getText().equals(buttons[j2 + 4].getText()));
    }
    public boolean ifWon1(JButton[] buttons)
    {
        if( (buttons[0].getText().equals(buttons[1].getText()) && buttons[1].getText().equals(buttons[2].getText())) ||(buttons[3].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[5].getText())) ||(buttons[6].getText().equals(buttons[7].getText()) && buttons[7].getText().equals(buttons[8].getText()))  )
            return true;
        else
        if((buttons[0].getText().equals(buttons[3].getText()) &&buttons[3].getText().equals(buttons[6].getText())) ||(buttons[1].getText().equals(buttons[4].getText()) &&buttons[4].getText().equals(buttons[7].getText())) ||(buttons[2].getText().equals(buttons[5].getText()) &&buttons[5].getText().equals(buttons[8].getText())))
            return true;
        else
            return (buttons[0].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[8].getText())) || (buttons[2].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[8].getText()));
    }
    public void check(boolean b)
    {
        if(b) {
            for (int i = 0; i < 9; i++)
                remove(jButtons[i]);
                revalidate();
                repaint();
            if (turn%2==0)
            JOptionPane.showMessageDialog(this,
                     "O won!", "Congratulations",
                    JOptionPane.INFORMATION_MESSAGE);

            else
            if (turn!=9)
                JOptionPane.showMessageDialog(this,
                        "X won!", "Congratulations",
                        JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(
                        this,"Game Over" , "End",
                        JOptionPane.ERROR_MESSAGE);
        }
    }
}