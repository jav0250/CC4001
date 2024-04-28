import javax.swing.JOptionPane;

/**
 * Represents a mobile gadget, extending the Gadget class.
 */
public class Mobile extends Gadget {
    private int callingCredit; // Total calling credit of the mobile
    private int callingCreditRemaining; // Remaining calling credit of the mobile

    /**
     * Constructor to initialize a Mobile object with the specified parameters.
     * @param model The model name of the mobile.
     * @param price The price of the mobile.
     * @param weight The weight of the mobile in grams.
     * @param length The length of the mobile in millimeters.
     * @param width The width of the mobile in millimeters.
     * @param depth The depth of the mobile in millimeters.
     * @param callingCreditRemaining The initial calling credit remaining for the mobile.
     */
    public Mobile(String model, double price, int weight, int length, int width, int depth, int callingCreditRemaining) {
        super(model, price, weight, length, width, depth);
        this.callingCreditRemaining = callingCreditRemaining;
    }
    
    /**
     * Retrieves the remaining calling credit of the mobile.
     * @return The remaining calling credit in minutes.
     */
    public int getCredit() {
        return callingCreditRemaining;
    }

    /**
     * Initiates a call for a specified duration.
     * @param minutes The duration of the call in minutes.
     */
    public void makeCall(int minutes) {
        if (callingCredit >= minutes) {
            callingCredit -= minutes;
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient calling credit");
        }
    }

    /**
     * Adds calling credit to the mobile.
     * @param minutes The amount of calling credit to add in minutes.
     */
    public void addCredit(int minutes) {
        callingCredit += minutes;
    }

    /**
     * Returns a string representation of the Mobile object.
     * @return A string containing the model, price, weight, dimensions, and calling credit information of the mobile.
     */
    @Override
    public String toString() {
        return super.toString() + ", Calling Credit Remaining: " + callingCredit + " minutes";
    }
}

