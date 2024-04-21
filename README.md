# HorseRaceSimulator

## 1. Project Name:
Horse Race Simulator

## 2. Description:
### Part 1:
In the game, there are two versions, Part 1 and Part 2. Part 1 runs the game in the terminal. It's a game where three horses run on a track. The number of horses could be increased by creating more horse objects; check line 251 in Race.java in Part 1. They could fall, and when a horse falls, it is determined by an algorithm. If the horse moves forward, it's also determined by an algorithm. When the horse reaches the end of the track, the winner is displayed. Each horse has a confidence level, and the confidence level determines the chance of the horse falling and moving forward. If the horse falls, the confidence level decreases, and if the horse wins, the confidence level increases. There could be more than one winner. The names of the horses are not asked by the program; they must be set manually by editing lines 251-253 where horse objects are created. The program doesn't restart after we have a winner. The program will also end if all the horses fall. The track length of Part 1 could be changed by changing the value of line 250 in Race.java. The simulation is shown in the terminal where pieces or the horse symbol moves from start to end. The winner's name is displayed in the terminal, and the confidence levels are shown too.

### Part 2:
Part 2 is a GUI representation of the horse game simulator. When Part 2 is run, it opens a window where you can customise the track. It allows you to choose the terrain for the race, such as desert, racetrack, or water. Then, you can choose the number of players by changing the number of tracks using the toggle. You can change the length of the track using another toggle, setting it between 10 and 20. When you press "Next", you can customise your horse. Each player will be asked to name their horse, choose its colour, and select its type: king, queen, pawn, rook, knight, or bishop. Press "Next" to name and customise the next horse. Once all the horses are customised as desired, the game will start. For some reason, the repaint method of Swing is not working, so the game will look like it froze after the last horse has been customised and the "Next" button is clicked. You just have to wait; the game is running in the background but not showing its animation until the game ends. It will show the final positions of the horses and replace all the horses with X if they fell. It will also output the winner in the same window and statistics of each horse with the name that was set by the user. Do not click the window when it looks like it froze; just wait till the game ends, and it will show you the result.

## 3. Installation:
To run this project, follow these steps:
1. Download and install VS Code or any preferred IDE for running Java code.
   [Download VS Code](https://code.visualstudio.com/download)
2. Ensure JDK (Java Development Kit) is installed on your local machine.
   [Download JDK](https://www.oracle.com/uk/java/technologies/downloads/)
3. Download the zip file from the GitHub repository to your local machine and open it in your IDE.
4. Make sure you have the Java Swing library.
5. To run Part 1:
   - Go to `Race.java` and run the file.
6. To run Part 2:
   - Open only the `Part 2` folder in your IDE.
   - Go to `Game.java` and run the file.
7. To run the program again:
   - Close or stop the current execution and run it again.

## 4. Usage:
1. Upon running the application, choose the number of tracks and track lengths.
2. After selecting the track parameters, enter information for each horse (color and type).
3. The race will start automatically, and you can observe the race outcome on the GUI.

## 6. Contributing:
Contributions are welcome! If you'd like to contribute to this project, please follow these steps:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature-name`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add some feature'`).
5. Push to the branch (`git push origin feature/your-feature-name`).
6. Create a new Pull Request.

## Troubleshooting:
- No expected errors in Part 1.
- In Part 2, once you customize the track and horse, pressing the final "Next" button may make the game appear frozen. However, it's not frozen; the issue lies with the `repaint()` function of Swing. The game should display the animation of the horse moving, stats, and hide the "Next" button. Since `repaint()` isn't working properly, these actions occur only when the game ends, either when a horse wins or all the horses have fallen. Therefore, once you click the "Next" button, just wait for the game to end. Do not click anything else; otherwise, the game might crash. Also, avoid clicking the "Next" button multiple times. Although the "Next" button is disabled when the game starts, the intention was for it to disappear using `repaint()` to prevent unnecessary clicks once the game has started.
