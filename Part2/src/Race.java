import java.util.ArrayList;
import java.util.List;

public class Race {
    private int raceLength;
    private List<Horse> horses;

    // Constructor with parameter
    public Race(int distance) {
        raceLength = distance;
        horses = new ArrayList<Horse>();
    }

    public Race() {
        raceLength = 0;
        horses = new ArrayList<Horse>();
    }

    // Other methods as needed
    public void addHorse(Horse theHorse) {
        horses.add(theHorse);
    }

    public int getRaceLength() {
        return raceLength;
    }

    public List<Horse> getHorses() {
        return horses;
    }
}
