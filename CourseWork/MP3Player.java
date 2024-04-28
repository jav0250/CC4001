import javax.swing.JOptionPane;

/**
 * Represents an MP3 player gadget, extending the Gadget class.
 */
public class MP3Player extends Gadget {
    private double availableMemory; // Available memory space in the MP3 player in GB

    /**
     * Constructor to initialize an MP3Player object with the specified parameters.
     * @param model The model name of the MP3 player.
     * @param price The price of the MP3 player.
     * @param weight The weight of the MP3 player in grams.
     * @param length The length of the MP3 player in millimeters.
     * @param width The width of the MP3 player in millimeters.
     * @param depth The depth of the MP3 player in millimeters.
     * @param availableMemory The available memory space in the MP3 player in GB.
     */
    public MP3Player(String model, double price, int weight, int length, int width, int depth, double availableMemory) {
        super(model, price, weight, length, width, depth);
        this.availableMemory = availableMemory;
    }

    /**
     * Downloads music to the MP3 player, reducing available memory space.
     * @param spaceNeeded The amount of memory space needed to download the music in GB.
     */
    public void downloadMusic(double spaceNeeded) {
        if (availableMemory >= spaceNeeded) {
            availableMemory -= spaceNeeded;
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient memory space");
        }
    }

    /**
     * Deletes music from the MP3 player, increasing available memory space.
     * @param spaceToDelete The amount of memory space to be freed by deleting music in GB.
     */
    public void deleteMusic(double spaceToDelete) {
        availableMemory += spaceToDelete;
    }

    /**
     * Returns a string representation of the MP3Player object.
     * @return A string containing the model, price, weight, dimensions, and available memory information of the MP3 player.
     */
    @Override
    public String toString() {
        return super.toString() + ", Available Memory: " + availableMemory + " GB";
    }
}

