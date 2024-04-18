import javax.swing.*;
import java.awt.*;
public class Game {
    public static void main(String[] args) {
      JFrame frame = new JFrame("Horse Game");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      GameWorld gameWorld = new GameWorld();
      gameWorld.addComponents(frame);
      frame.add(Background.panel, BorderLayout.CENTER);
      frame.setVisible(true); // Makes the frame visible
    }
}