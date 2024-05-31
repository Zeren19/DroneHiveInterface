import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingGUI {
    public SwingGUI(){
        JFrame frame = new JFrame();

        JButton button = new JButton("Self-destruct");
        button.setEnabled(false);
        button.setBorderPainted(false);
        JButton lock = new JButton("Unlock Self-destruct");
        button.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        lock.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        lock.setAlignmentX(220);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300,300,300,300));  //Set Borders in pixels
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(lock);

        lock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!button.isEnabled()){
                    button.setEnabled(true);
                    lock.setText("Lock Self-destruct");
                }
                else{
                    button.setEnabled(false);
                    lock.setText("Unlock Self-destruct");
                }
            }
        });
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {frame.dispose();
                }
            }
        );

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Drone Controller");
        frame.pack();
        frame.setLocation(400,80);
        frame.setVisible(true);
    }
}
