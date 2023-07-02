import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        try {

            TicTacToe ticTacToe = new TicTacToe();
            ticTacToe.setTitle("Tic-Tac-Toe");
            ticTacToe.setSize(350, 350);
            ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ticTacToe.setVisible(true);

        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
}

