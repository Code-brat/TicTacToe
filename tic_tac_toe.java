import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        new TicTacToe();
    }
}

class TicTacToe implements ActionListener {
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textFeild = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    Random random = new Random();

    TicTacToe() {
        
        frame.setTitle("Tic-Tac-Toe");
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        textFeild.setBackground(Color.black);
        textFeild.setForeground(Color.green);
        textFeild.setFont(new Font("Cascadia code", Font.BOLD, 55));
        textFeild.setText("Tic-Tac-Toe");
        textFeild.setHorizontalAlignment(JLabel.CENTER);
        textFeild.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 600, 200);
        titlePanel.setBackground(Color.GREEN);
        
        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150, 150 , 255));
        
        for(int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(true);
            buttons[i].addActionListener(this);
            
        }

        titlePanel.add(textFeild);

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
    }

    public void firstTurn() {

        try {
            Thread.sleep(3000);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        if(random.nextInt(2) == 0) {
            player1_turn = true;
            textFeild.setText("X turn");
        }
        else {
            player1_turn = false;
            textFeild.setText("O turn");
        }
    }

    public void check() {
        // X win
        if( (buttons[0].getText() == "X") &&
            (buttons[1].getText() == "X") &&
            (buttons[2].getText() == "X")
        ) {
            xWins(0, 1, 2);
        }
        if( (buttons[3].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[5].getText() == "X")
        ) {
            xWins(3, 4, 5);
        }
        if( (buttons[6].getText() == "X") &&
            (buttons[7].getText() == "X") &&
            (buttons[8].getText() == "X")
        ) {
            xWins(6, 7, 8);
        }
        if( (buttons[0].getText() == "X") &&
            (buttons[3].getText() == "X") &&
            (buttons[6].getText() == "X")
        ) {
            xWins(0, 3, 6);
        }
        if( (buttons[1].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[7].getText() == "X")
        ) {
            xWins(1, 4, 7);
        }
        if( (buttons[2].getText() == "X") &&
            (buttons[5].getText() == "X") &&
            (buttons[8].getText() == "X")
        ) {
            xWins(2, 5, 8);
        }
        if( (buttons[0].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[8].getText() == "X")
        ) {
            xWins(0, 4, 8);
        }
        if( (buttons[2].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[6].getText() == "X")
        ) {
            xWins(2, 4, 6);
        }

        //O wins
        if( (buttons[0].getText() == "O") &&
            (buttons[1].getText() == "O") &&
            (buttons[2].getText() == "O")
        ) {
            oWins(0, 1, 2);
        }
        if( (buttons[3].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[5].getText() == "O")
        ) {
            oWins(3, 4, 5);
        }
        if( (buttons[6].getText() == "O") &&
            (buttons[7].getText() == "O") &&
            (buttons[8].getText() == "O")
        ) {
            oWins(6, 7, 8);
        }
        if( (buttons[0].getText() == "O") &&
            (buttons[3].getText() == "O") &&
            (buttons[6].getText() == "O")
        ) {
            oWins(0, 3, 6);
        }
        if( (buttons[1].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[7].getText() == "O")
        ) {
            oWins(1, 4, 7);
        }
        if( (buttons[2].getText() == "O") &&
            (buttons[5].getText() == "O") &&
            (buttons[8].getText() == "O")
        ) {
            oWins(2, 5, 8);
        }
        if( (buttons[0].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[8].getText() == "O")
        ) {
            oWins(0, 4, 8);
        }
        if( (buttons[2].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[6].getText() == "O")
        ) {
            oWins(2, 4, 6);
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textFeild.setText("X Won");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textFeild.setText("O Won");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 9; i++) {
            if(e.getSource() == buttons[i]) {
                if(player1_turn) {
                    if(buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.red);
                        buttons[i].setText("X");
                        player1_turn = false;
                        textFeild.setText("O turn");
                        check();
                    }
                }
                else {
                    if(buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.blue);
                        buttons[i].setText("O");
                        player1_turn = true;
                        textFeild.setText("X turn");
                        check();
                    }
                }
            }
        }
    }
}