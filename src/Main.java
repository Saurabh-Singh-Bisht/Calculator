import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main implements ActionListener {
    JFrame frame;
    Font myFont = new Font("Digital-7", Font.PLAIN, 50);
    JButton btn1, btn2;
    ImageIcon icon = new ImageIcon("D:\\Project\\Java\\Inteliji\\Calculator\\src\\icons8-calculator-100.png");
    ImageIcon binary = new ImageIcon("D:\\Project\\Java\\Inteliji\\Calculator\\src\\icons8-01_00-100.png");

    Main(){
        frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(44, 44, 44));

        panel.setBounds(0, 0, 420, 500);
        panel.setLayout(new GridLayout(2, 0,0, 0));
        panel.setBackground(new Color(39, 56, 56));

        btn1 = new JButton();
        btn1.setIcon(icon);
        btn1.setForeground(new Color(255, 255, 255));
        btn1.setBackground(new Color(44, 44, 44));
        btn1.setFocusable(false);
        btn1.addActionListener(this);
        btn1.setFont(myFont);
        btn1.setBorder(null);



        btn2 = new JButton();
        btn2.setForeground(new Color(255, 255, 255));
        btn2.setBackground(new Color(204, 126, 0));
        btn2.setFocusable(false);
        btn2.addActionListener(this);
        btn2.setFont(myFont);
        btn2.setIcon(binary);
        btn2.setBorder(null);


        panel.add(btn1);
        panel.add(btn2);

        frame.setIconImage(icon.getImage());
        frame.add(panel);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Main m1 = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn1) {
            frame.dispose();
            new Calculator();
        }
        if(e.getSource() == btn2) {
            frame.dispose();
            new decimalToBinary();
        }
    }
}
