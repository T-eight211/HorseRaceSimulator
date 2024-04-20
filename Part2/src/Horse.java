

/**
 * Write a description of class Horse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Horse {
    // Fields of class Horse
    private String name;
    private String type;
    private String colour;
    private int distanceTravelled;
    private boolean fallen;
    private double confidence;

    // Constructor of class Horse
    /**
     * Constructor for objects of class Horse.
     * 
     * @param horseSymbol The character used to represent the horse.
     * @param horseName The name of the horse.
     * @param horseConfidence The confidence rating of the horse (between 0 and 1).
     */
    public Horse( double horseConfidence) {
        type = "Knight";
        colour = "Black";
        name = "";
        distanceTravelled = 0;
        fallen = false;
        setConfidence(horseConfidence); // Ensure confidence is within the valid range
    }

    // Other methods of class Horse

    /**
     * Sets the horse as fallen.
     */
    public void fall() {
        fallen = true;
    }

    /**
     * Returns the confidence rating of the horse.
     * 
     * @return The confidence rating of the horse.
     */
    public double getConfidence() {
        return confidence;
    }

    /**
     * Returns the distance traveled by the horse.
     * 
     * @return The distance traveled by the horse.
     */
    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    /**
     * Returns the name of the horse.
     * 
     * @return The name of the horse.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the character used to represent the horse.
     * 
     * @return The character used to represent the horse.
     */
    public String getType() {
        return type;
    }

    // getter for colour
    public String getColour() {
        return colour;
    }

    /**
     * Resets the horse to the start of the race.
     */
    public void goBackToStart() {
        distanceTravelled = 0;
        fallen = false;
    }

    /**
     * Returns true if the horse has fallen, false otherwise.
     * 
     * @return True if the horse has fallen, false otherwise.
     */
    public boolean hasFallen() {
        return fallen;
    }

    /**
     * Increments the distance traveled by the horse by 1.
     */
    public void moveForward() {
        distanceTravelled++;
    }

    /**
     * Sets the confidence rating of the horse to the given value.
     * 
     * @param newConfidence The new confidence rating of the horse.
     */
    public void setConfidence(double newConfidence) {
        if (newConfidence >= 0 && newConfidence <= 1) {
            confidence = newConfidence;
        }
    }

    /**
     * Sets the character used to represent the horse to the given character.
     * 
     * @param newSymbol The new character used to represent the horse.
     */
    public void setType(String newType) {
        type = newType;
    }

    // setter for colour
    public void setColour(String newColour) {
        colour = newColour;
    }

    // setter for name
    public void setName(String newName) {
        name = newName;
    }

    
}