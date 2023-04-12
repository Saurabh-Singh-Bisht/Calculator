import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    ImageIcon icon = new ImageIcon("D:\\Project\\Java\\Inteliji\\Calculator\\src\\icons8-calculator-100.png");
    ImageIcon del = new ImageIcon("D:\\Project\\Java\\Inteliji\\Calculator\\src\\del.png");

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    Font myFont = new Font("Digital-7", Font.PLAIN, 40);
    double num1 =0, num2 =0, result =0;
    char operator;
    //LineBorder lineBorder;
    Calculator(){
        //Creating frame:
        frame = new JFrame("Calculator");
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
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton();
        clrButton = new JButton("AC");
        negButton = new JButton("(-)");

        //adding buttons to functionButtons:
        functionButtons[0] =addButton;
        functionButtons[1] =subButton;
        functionButtons[2] =mulButton;
        functionButtons[3] =divButton;
        functionButtons[4] =decButton;
        functionButtons[5] =equButton;
        functionButtons[6] =delButton;
        functionButtons[7] =clrButton;
        functionButtons[8] =negButton;

        //Adding actionListener to buttons with some other basic properties::
        for(int i=0;i<9;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setForeground(Color.WHITE);
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

        //Setting negButton, delButton, clrButtons on frame:
        clrButton.setBounds(50,430,99,50);
        clrButton.setFont(new Font("Lato", Font.BOLD, 40));
        clrButton.setForeground(new Color(44, 44, 44));
        negButton.setBounds(150,430,99,50);
        delButton.setBounds(250,430,99,50);
        delButton.setIcon(del);

        //Creating Panel:
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4,10, 10));
        panel.setBackground(new Color(44, 44, 44));

        //Adding different buttons to different panels:
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
        frame.add(textField);
        frame.setIconImage(icon.getImage());
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        //Constructor Calling:
        Calculator cal = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equButton){
            num2 = Double.parseDouble((textField.getText()));
            switch(operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
        }
        if(e.getSource() == clrButton){
            textField.setText("");
        }
        if(e.getSource() == delButton){
            String temp = textField.getText();
            textField.setText("");
            for(int i=0;i< temp.length()-1;i++){
                textField.setText(textField.getText()+temp.charAt(i));
            }
        }
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
