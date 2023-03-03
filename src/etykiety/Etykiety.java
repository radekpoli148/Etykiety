package etykiety;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Etykiety extends JFrame{

    public Etykiety()
    {
        super("Zegarek");
        this.setBounds(300, 320, 300, 200);
        
        initComponents();
        //this.pack();
        this.setDefaultCloseOperation(3);
    }
    
    public void initComponents()
    {
        panel.add(etykieta);
        panel.add(czas);
        
        ActionListener stoper = new Zegar();
        
        Timer zegar = new Timer(1000, stoper);
        
        zegar.start();
        
        this.getContentPane().add(panel);
    }
    JPanel panel = new JPanel();
    JLabel etykieta = new JLabel("Czas: ");
    JLabel czas = new JLabel(pobierzCzas());
    
    private class Zegar implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            czas.setText(pobierzCzas());
        }
    }
    
    public String pobierzCzas()
    {
        GregorianCalendar kalendarzyk = new GregorianCalendar();
            
        String h = ""+kalendarzyk.get(Calendar.HOUR_OF_DAY);
        String m = ""+kalendarzyk.get(Calendar.MINUTE);
        String s = ""+kalendarzyk.get(Calendar.SECOND);

        if(Integer.parseInt(h)<10)
            h = "0"+h;
        if(Integer.parseInt(m)<10)
            m = "0"+m;
        if(Integer.parseInt(s)<10)
            s = "0"+s;
        
        return h+":"+m+":"+s;
    }
    public static void main(String[] args) {
        new Etykiety().setVisible(true);
    }
    
}
