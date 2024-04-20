import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.lang.Math;

/**
 * A three-horse race, each horse running in its own lane
 * for a given distance
 * 
 * @author McFarewell
 * @version 1.0
 */
public class Race
{
    private int raceLength;
    private List<Horse> horses;
    private  List<Horse> winners = new ArrayList<>();
    List<Horse> fallenHorses = new ArrayList<>();

    /**
     * Constructor for objects of class Race1
     * 
     * @param distance the length of the racetrack (in metres/yards...)
     */
    public Race(int distance){
        raceLength = distance;
        horses = new ArrayList<>();     
    }

    // get winners
    public List<Horse> getWinners() {
        return winners;
    }
    
    /**
     * Adds a horse to the race
     * 
     * @param theHorse the horse to be added to the race
     */
    public void addHorse(Horse theHorse)
    {
        horses.add(theHorse);
    }

    public int getRaceLength() {
        return raceLength;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public List<Horse> getFallenHorses() {
        return fallenHorses;
    }
    
    /**
     * Start the race
     * The horse are brought to the start and
     * then repeatedly moved forward until the 
     * race is finished
     */
    public void startRace()
    {

        for (Horse horse : horses) {
            horse.goBackToStart();
        }
        boolean finished = false;
        
        while (!finished)
        {
             
            for (Horse horse : horses) {
                moveHorse(horse);
                if (horse.hasFallen() && !fallenHorses.contains(horse)) {
                    fallenHorses.add(horse);
                }

                if (raceWonBy(horse)){
                    finished = true;
                    winners.add(horse);
                    horse.setConfidence(Math.round((horse.getConfidence() + 0.1) * 10.0) / 10.0);
                }
                else if (fallenHorses.size() == horses.size()) {
                    finished = true;
                   
                }
                GameWorld.printRace(horse);
            }
            
            // Wait for 100 milliseconds
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
     
    }
  
    /**
     * Randomly make a horse move forward or fall depending
     * on its confidence rating
     * A fallen horse cannot move
     * 
     * @param theHorse the horse to be moved
     */
    private void moveHorse(Horse theHorse)
    {
        if (!theHorse.hasFallen()) {

            if (Math.random() < theHorse.getConfidence()) {
               theHorse.moveForward();
            }
            
            if (Math.random() < (0.1 * theHorse.getConfidence() * theHorse.getConfidence())) {
                theHorse.fall();
                theHorse.setConfidence(Math.round((theHorse.getConfidence() - 0.1) * 10.0) / 10.0);
            }
        }
    }
        
    /** 
     * Determines if a horse has won the race
     *
     * @param theHorse The horse we are testing
     * @return true if the horse has won, false otherwise.
     */
    public boolean raceWonBy(Horse theHorse)
    {
        return theHorse.getDistanceTravelled() >= raceLength;
    }

    
}
