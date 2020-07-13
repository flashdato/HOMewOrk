package ge.edu.itvet;

import javax.swing.*;

class Main {
    public static void main(String[] arg) {
        MyPanel myPanel = new MyPanel();
        JFrame jframe = new JFrame();
        jframe.add(myPanel);
        jframe.pack();
        jframe.setTitle("TicTacToe");
        jframe.doLayout();
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setResizable(true);
        jframe.setVisible(true);
    }
}