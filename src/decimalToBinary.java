import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class decimalToBinary implements ActionListener {
    ImageIcon binary = new ImageIcon("D:\\Project\\Java\\Inteliji\\Calculator\\src\\icons8-01_00-100.png");
    ImageIcon del = new ImageIcon("D:\\Project\\Java\\Inteliji\\Calculator\\src\\del.png");

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[2];
    JButton equButton, delButton, clrButton;
    JPanel panel;
    Font myFont = new Font("Digital-7", Font.PLAIN, 40);
    double decimal = 0;
    decimalToBinary(){
        //Creating frame:
        frame = new JFrame("Decimal to Binary");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(44, 44, 44));

        //Creating Textfield to display input and output:
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setForeground(Color.WHITE);
        textField.setBorder(null);
        textField.setBackground(new Color(47, 47, 47));

        //Initializing operators to buttons:

        equButton = new JButton("=");
        delButton = new JButton();
        clrButton = new JButton("AC");

        //adding buttons to functionButtons:

        functionButtons[0] =clrButton;
        functionButtons[1] =delButton;
        delButton.setIcon(del);

        //Adding actionListener to buttons with some other basic properties::
        for(int i=0;i<2;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(new Font("Lato", Font.BOLD, 40));
            functionButtons[i].setForeground(new Color(47, 47, 47));
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(new Color(192, 115, 0));
            functionButtons[i].setBorder(null);
        }
        //Adding 1 to 9  buttons with actionListener & some other basic properties:
        for(int i=0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(new Color(103, 103, 103));
            numberButtons[i].setBorder(null);
        }

        //Setting equal on frame:
        equButton.setBounds(50, 410, 300,65);
        equButton.setBackground(new Color(192, 115, 0));
        equButton.setForeground(Color.WHITE);
        equButton.setFont(myFont);
        equButton.setFocusable(false);
        equButton.setBorder(null);
        equButton.addActionListener(this);



        //Creating Panel:
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 3,10, 10));
        panel.setBackground(new Color(44, 44, 44));

        //Adding different buttons to different panels:
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(clrButton);
        panel.add(numberButtons[0]);
        panel.add(delButton);

        frame.add(panel);
        frame.add(equButton);
//        frame.add(delButton);
//        frame.add(clrButton);
        frame.add(textField);
        frame.setIconImage(binary.getImage());
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == equButton){
            String str = textField.getText();
            decimal = Double.valueOf(str);
            String ans = "";
            while(decimal > 0){
                double rem = decimal%2;
                ans = (int)rem + ans;
                decimal = decimal/2;
                if(decimal >0 && decimal <1)
                    break;
            }
            textField.setText(ans);
        }
        if(e.getSource() == clrButton){
            textField.setText("");
        }
        if(e.getSource() == delButton){
            String temp = textField.getText();
            textField.setText("");
            for(int i=0;i<temp.length()-1;i++){
                textField.setText(textField.getText()+ temp.charAt(i));
            }
        }
    }
}
