import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingGUI {
    public SwingGUI(){
        JFrame frame = new JFrame();
        JFrame droneListPanel = new JFrame();
        JFrame droneListTypes = new JFrame();
        JFrame sidePanel = new JFrame();
        //Side panel
        JButton updateData = new JButton("Update data.");
        JButton listDrones = new JButton("Drone list.");
        JButton listTypes = new JButton("Drone types.");

        //Side panel Buttons
        JButton button = new JButton("Self-destruct");
        button.setEnabled(false);
        button.setBorderPainted(false);
        JButton lock = new JButton("Unlock Self-destruct");
        button.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        lock.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JButton toggleNightMode = new JButton("Toggle Night Mode");

        button.setBackground(Color.black);
        lock.setBackground(Color.black);
        toggleNightMode.setBackground(Color.black);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300,300,300,300));  //Set Borders in pixels
        panel.setLayout(new GridLayout(2,2));
        panel.add(button);
        panel.add(lock);
        panel.add(toggleNightMode);


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
        toggleNightMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(toggleNightMode.getBackground()== Color.white){  //invert button and panel color for contrast
                    toggleNightMode.setBackground(Color.black);
                    panel.setBackground(Color.white);
                }
                else {
                    toggleNightMode.setBackground(Color.white);
                    panel.setBackground(Color.black);
                }

            }
        });
        // For future use: Change text with simple icon that inverts too and place it in the corner of the window.
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Drone Controller");
        frame.pack();
        frame.setVisible(true);
    }
}
