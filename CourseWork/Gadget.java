/**
 * Represents a generic Gadget with common properties like model, price, and dimensions.
 */
public class Gadget {
    // Fields to store gadget information
    protected String model; // Model name of the gadget
    protected double price; // Price of the gadget in Sterling Pounds
    protected int weight; // Weight of the gadget in grams
    protected int length; // Length of the gadget in millimeters
    protected int width; // Width of the gadget in millimeters
    protected int depth; // Depth of the gadget in millimeters

    /**
     * Constructor to initialize a Gadget object with the specified parameters.
     * @param model The model name of the gadget.
     * @param price The price of the gadget.
     * @param weight The weight of the gadget in grams.
     * @param length The length of the gadget in millimeters.
     * @param width The width of the gadget in millimeters.
     * @param depth The depth of the gadget in millimeters.
     */
    public Gadget(String model, double price, int weight, int length, int width, int depth) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.depth = depth;
    }

    /**
     * Gets the model name of the gadget.
     * @return The model name of the gadget.
     */
    public String getModel() {
        return model;
    }

    /**
     * Returns a string representation of the Gadget object.
     * @return A string containing the model, price, weight, and dimensions of the gadget.
     */
    @Override
    public String toString() {
        return "Model: " + model + ", Price: £" + price + ", Weight: " + weight + " grams, Size: " +
                length + "mm x " + width + "mm x " + depth + "mm";
    }
}


