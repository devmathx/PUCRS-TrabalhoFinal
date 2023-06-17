import javax.swing.*;
import java.awt.Color;


public class App{
    public static void main(String[] args) {
        //Declaração de cores
        Color vermelhoEscuro = new Color(235,50,50);

        JFrame myScreen = new JFrame();
        JButton myFirstButton = new JButton("Click");
        myFirstButton.setBounds(130, 100, 50, 40);
        myFirstButton.setBackground(vermelhoEscuro);

        myScreen.add(myFirstButton);//adding button in JFrame  
          
        myScreen.setSize(400,500);//400 width and 500 height  
        myScreen.setLayout(null);//using no layout managers  
        myScreen.setVisible(true);//making the frame visible
    }
}