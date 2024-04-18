import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Background {

    private static ImageIcon backgroundImage;
    static JPanel panel;
    private static JPanel innerPanel1; // Declare class-level innerPanel1 variable
    static JTextField horseNameField;

    public void setBackground(JFrame frame) {
        
        String backgroundImageFilePath = "resources/race-track-image-1.png";
        backgroundImage = new ImageIcon(backgroundImageFilePath);
        int width = backgroundImage.getIconWidth();
        int height = backgroundImage.getIconHeight();
        frame.setSize(width, height);
        frame.setLayout(new BorderLayout());

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage.getImage(), 0, 0, this);
                }
            }
        };

        panel.setLayout(new GridLayout(4, 4));

        for (int i = 0; i < 12; i++) {
          JPanel emptyPanel = new JPanel();
          emptyPanel.setOpaque(false);
          panel.add(emptyPanel);
        }

        innerPanel1 = new JPanel(new GridBagLayout()); // Initialize class-level innerPanel1
        innerPanel1.setOpaque(false);
        GridBagConstraints gbc1 = new GridBagConstraints();
        JLabel chooseTrackDesignLabel = new JLabel("Choose track design:");
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        innerPanel1.add(chooseTrackDesignLabel, gbc1);
        String[] trackDesigns = {"Desert", "Water", "Race track"};
        JComboBox<String> trackDesignDropdown = new JComboBox<>(trackDesigns);

        trackDesignDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDesign = (String) trackDesignDropdown.getSelectedItem();
                // Change background image based on selection
                switch (selectedDesign) {
                    case "Desert":
                        setBackgroundImage("resources/race-track-image-1.png");
                        break;
                    case "Water":
                        setBackgroundImage("resources/race-track-image-2.png");
                        break;
                    case "Race track":
                        setBackgroundImage("resources/race-track-image-3.png");
                        break;
                }
            }
        });
        gbc1.gridx = 0;
        gbc1.gridy = 1;
        innerPanel1.add(trackDesignDropdown, gbc1);
        panel.add(innerPanel1);
        
    }

    private static void setBackgroundImage(String imagePath) {
        backgroundImage = new ImageIcon(imagePath);
        panel.repaint(); 
    }

    public static void editPanel1(int horseNumber) {
        
        innerPanel1.removeAll();
        System.out.println("Horse number: " + horseNumber);
        JLabel label = new JLabel("Horse " + horseNumber+ " name:");
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        innerPanel1.add(label, gbc2);
        // add an input field for the horse name
        horseNameField = new JTextField(10);
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        innerPanel1.add(horseNameField, gbc2);
        innerPanel1.revalidate();
        innerPanel1.repaint();
    }
}
