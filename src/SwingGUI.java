import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SwingGUI {
    public Color activeColor = Color.white;
    public SwingGUI(){
        JFrame frame = new JFrame();
        JPanel droneListPanel = new JPanel();
        JPanel droneListTypes = new JPanel();
        //Drone panels
        JPanel sidePanel = new JPanel(new GridLayout(3, 1));
        sidePanel.setBorder( BorderFactory.createLineBorder(Color.black));
        sidePanel.setBackground(Color.black);
        sidePanel.setSize(125, 300);

        //Side panel - always in view
        JButton updateData = new JButton("Update data.");
        JButton listDrones = new JButton("Drone list.");
        JButton listTypes = new JButton("Drone types.");

        sidePanel.add(updateData);
        sidePanel.add(listDrones);
        sidePanel.add(listTypes);
        //Side panel Buttons

        //listDrones GUI
        //listTypes GUI

        JPanel panel = new JPanel();
        frame.setSize(400, 300);
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;

        JButton toggleNightMode = new JButton("Toggle Night Mode");
        toggleNightMode.setBackground(Color.black);
        panel.add(toggleNightMode, gbc);

        toggleNightMode.addActionListener(e -> {
            if(toggleNightMode.getBackground()== Color.white){  //invert button and panel color for contrast
                toggleNightMode.setBackground(Color.black);
                panel.setBackground(Color.white);
                //^REDUNDANT
                activeColor = Color.white;
                panel.updateUI();
                sidePanel.updateUI();
            }
            else {
                toggleNightMode.setBackground(Color.white);
                panel.setBackground(Color.black);
                //^REDUNDANT
                activeColor = Color.black;
                panel.updateUI();
                sidePanel.updateUI();
            }

        });
        // For future use: Change text with simple icon that inverts too and place it in the corner of the window.

        updateData.addActionListener(e ->  {
            try {
                APIRequest.DownloadData();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        frame.add(panel);
        frame.add(sidePanel, gbc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Drone Dynamics Monitor");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
