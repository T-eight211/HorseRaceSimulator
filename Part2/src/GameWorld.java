import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWorld {

  public static JPanel innerPanel2;
  public static JPanel innerPanel3;
  public static JPanel innerPanel4;
  public static JLabel chooseTrackLengthsLabel;
  public static Race race;
  public static JButton nextButton1 = new JButton("Next");
  public static JComboBox<String> colorDropdown;
  public static JComboBox<String> horseTypeDropdown;
  public static int count = 0;

  public void addComponents(JFrame frame) {
    Background background = new Background();
    background.setBackground(frame);

    innerPanel2 = new JPanel(new GridBagLayout());
    innerPanel2.setOpaque(false);
    GridBagConstraints gbc2 = new GridBagConstraints();

    JLabel chooseNumberOfTracksLabel = new JLabel("Choose number of tracks:");
    gbc2.gridx = 0;
    gbc2.gridy = 0;
    innerPanel2.add(chooseNumberOfTracksLabel, gbc2);

    JSpinner numberOfTracksSpinner = new JSpinner(new SpinnerNumberModel(2, 2, 8, 1));
    JSpinner.NumberEditor editor = new JSpinner.NumberEditor(numberOfTracksSpinner, "#");
    numberOfTracksSpinner.setEditor(editor);
    editor.getTextField().setEnabled(false);
    gbc2.gridx = 0;
    gbc2.gridy = 1;
    innerPanel2.add(numberOfTracksSpinner, gbc2);
    Background.panel.add(innerPanel2);

    
    innerPanel3 = new JPanel(new GridBagLayout());
    innerPanel3.setOpaque(false);
    GridBagConstraints gbc3 = new GridBagConstraints();
    chooseTrackLengthsLabel = new JLabel("Choose track lengths:");
    gbc3.gridx = 0;
    gbc3.gridy = 0;
    
    innerPanel3.add(chooseTrackLengthsLabel , gbc3);
    JSpinner trackLengthsSpinner = new JSpinner(new SpinnerNumberModel(10, 10, 100, 1));
    JSpinner.NumberEditor editor2 = new JSpinner.NumberEditor(trackLengthsSpinner, "#");
    trackLengthsSpinner.setEditor(editor2);
    editor2.getTextField().setEnabled(false);
    gbc3.gridx = 0;
    gbc3.gridy = 1;
    innerPanel3.add(trackLengthsSpinner , gbc3);
    Background.panel.add(innerPanel3);

    innerPanel4 = new JPanel(new GridBagLayout());
    innerPanel4.setOpaque(false);
    GridBagConstraints gbc4 = new GridBagConstraints();
    JButton nextButton = new JButton("Next");
    gbc4.gridx = 0;
    gbc4.gridy = 0;
    innerPanel4.add(nextButton, gbc4);
    Background.panel.add(innerPanel4);

    nextButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          // Get the selected track length
          int trackLength = (int) trackLengthsSpinner.getValue();

          // Get the number of tracks
          int numberOfTracks = (int) numberOfTracksSpinner.getValue();

          // Create a Race object with the selected track length
          race = new Race(trackLength);

          // Create Horse objects based on the number of tracks
          for (int i = 0; i < numberOfTracks; i++) {
              Horse horse = new Horse(0.6); // You need to implement the Horse class
              race.addHorse(horse);
          } 

          getHorseInfo(1); 
      }
    });

    if (nextButton1 != null) {
      nextButton1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          race.getHorses().get(count).setName( Background.horseNameField.getText());
          race.getHorses().get(count).setColour(colorDropdown.getSelectedItem().toString());
          race.getHorses().get(count).setType(horseTypeDropdown.getSelectedItem().toString());
          count++;
          if (count < race.getHorses().size()){
            getHorseInfo(count+1);
          }
          else {
            System.out.println("All horses have been created");
            // disable next button
            nextButton1.setEnabled(false);
          }
          
        }
      }); 
    }
    

  
      

  }

  public static void getHorseInfo (int horseNumber){
    Background.editPanel1(horseNumber);
    editPanel2(innerPanel2, "Choose horse color:");
    editPanel3(innerPanel3, "Choose horse type:");
    innerPanel4.removeAll();
    
    GridBagConstraints gbc4 = new GridBagConstraints();
    gbc4.gridx = 0;
    gbc4.gridy = 0;
    innerPanel4.add(nextButton1, gbc4);
    innerPanel4.revalidate();
    innerPanel4.repaint();
  }

 
  public static void editPanel2(JPanel panel, String labelMessage) {
   
    panel.removeAll();
    JLabel label = new JLabel(labelMessage);
    GridBagConstraints gbc5 = new GridBagConstraints();
    gbc5.gridx = 0;
    gbc5.gridy = 0;
    panel.add(label, gbc5);

    //  add a dropdown menu with values Black and white
    String[] colors = {"Black", "White"};
    colorDropdown = new JComboBox<>(colors);
    gbc5.gridx = 0;
    gbc5.gridy = 1;
    panel.add(colorDropdown, gbc5);
    panel.revalidate();
    panel.repaint(); 
  }

  public static void editPanel3(JPanel panel, String labelMessage) {
    panel.removeAll();
    JLabel label = new JLabel(labelMessage);
    GridBagConstraints gbc6 = new GridBagConstraints();
    gbc6.gridx = 0;
    gbc6.gridy = 0;
    panel.add(label, gbc6);
    String[] horseType = {"Pawn", "Knight", "Bishop", "Rook", "Queen", "King", "Horse"};
    horseTypeDropdown = new JComboBox<>(horseType);
    gbc6.gridx = 0;
    gbc6.gridy = 1;
    panel.add(horseTypeDropdown, gbc6);
    panel.revalidate();
    panel.repaint(); 
  }
}