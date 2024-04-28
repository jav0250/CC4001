import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GadgetShop extends JFrame {
    // ArrayLists to store mobiles and MP3 players
    private ArrayList<Mobile> mobiles;
    private ArrayList<MP3Player> mp3Players;
    
    // JTextAreas for displaying mobiles and MP3 players
    private JTextArea mobileDisplayArea, mp3DisplayArea;
    
    // JTextFields for input fields related to mobiles
    private JTextField mobileModelField, mobilePriceField, mobileWeightField, mobileLengthField, mobileWidthField, mobileDepthField, mobileCreditField;
    
    // JTextFields for input fields related to MP3 players
    private JTextField mp3ModelField, mp3PriceField, mp3WeightField, mp3LengthField, mp3WidthField, mp3DepthField, mp3MemoryField;
    
    // JButtons for mobile operations
    private JButton makeCallButton, addCreditButton, saveMobileButton, clearMobileFieldsButton;
    
    // JButtons for MP3 player operations
    private JButton downloadMusicButton, deleteMusicButton, saveMP3Button, clearMP3FieldsButton;
    
    // JPanels for organizing mobile and MP3 player sections
    private JPanel mobileInputPanel, mp3InputPanel;

    // Constructor
    public GadgetShop() {
        // Initialize ArrayLists
        mobiles = new ArrayList<>();
        mp3Players = new ArrayList<>();
        
        // Set frame properties
        setTitle("Gadget Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        // Main panel with a grid layout
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        // Mobile section
        JPanel mobilePanel = new JPanel(new BorderLayout());
        mobilePanel.setBorder(BorderFactory.createTitledBorder("Mobile"));

        // Panel for mobile input fields
        mobileInputPanel = new JPanel(new GridLayout(8, 2));
        addMobileFields();
        mobilePanel.add(mobileInputPanel, BorderLayout.CENTER);

        // Panel for mobile operation buttons
        JPanel mobileButtonPanel = new JPanel(new FlowLayout());
        saveMobileButton = new JButton("Save");
        makeCallButton = new JButton("Make Call");
        addCreditButton = new JButton("Add Credit");
        clearMobileFieldsButton = new JButton("Clear Fields"); // Clear button for mobile section
        saveMobileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveMobile();
                displayMobiles();
            }
        });
        makeCallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeCall();
                displayMobiles();
            }
        });
        addCreditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCredit();
                displayMobiles();
            }
        });
        clearMobileFieldsButton.addActionListener(new ActionListener() { // Action listener for clear button
            @Override
            public void actionPerformed(ActionEvent e) {
                clearMobileFields();
            }
        });

        // Add mobile buttons to panel
        mobileButtonPanel.add(saveMobileButton);
        mobileButtonPanel.add(makeCallButton);
        mobileButtonPanel.add(addCreditButton);
        mobileButtonPanel.add(clearMobileFieldsButton); // Add clear button to mobile button panel
        mobilePanel.add(mobileButtonPanel, BorderLayout.NORTH);

        // Display area for mobiles
        mobileDisplayArea = new JTextArea();
        mobileDisplayArea.setEditable(false);
        mobileDisplayArea.setRows(10); // Setting the number of rows
        mobileDisplayArea.setColumns(20); // Setting the number of columns
        mobilePanel.add(new JScrollPane(mobileDisplayArea), BorderLayout.SOUTH);

        // Add mobile panel to main panel
        mainPanel.add(mobilePanel);

        // MP3 section
        JPanel mp3Panel = new JPanel(new BorderLayout());
        mp3Panel.setBorder(BorderFactory.createTitledBorder("MP3 Player"));

        // Panel for MP3 input fields
        mp3InputPanel = new JPanel(new GridLayout(8, 2));
        addMP3Fields();
        mp3Panel.add(mp3InputPanel, BorderLayout.CENTER);

        // Panel for MP3 operation buttons
        JPanel mp3ButtonPanel = new JPanel(new FlowLayout());
        saveMP3Button = new JButton("Save");
        downloadMusicButton = new JButton("Download Music");
        deleteMusicButton = new JButton("Delete Music");
        clearMP3FieldsButton = new JButton("Clear Fields"); // Clear button for MP3 section
        saveMP3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveMP3();
                displayMP3Players();
            }
        });
        downloadMusicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downloadMusic();
                displayMP3Players();
            }
        });
        deleteMusicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteMusic();
                displayMP3Players();
            }
        });
        clearMP3FieldsButton.addActionListener(new ActionListener() { // Action listener for clear button
            @Override
            public void actionPerformed(ActionEvent e) {
                clearMP3Fields();
            }
        });
        
        // Add MP3 buttons to panel
        mp3ButtonPanel.add(saveMP3Button);
        mp3ButtonPanel.add(downloadMusicButton);
        mp3ButtonPanel.add(deleteMusicButton);
        mp3ButtonPanel.add(clearMP3FieldsButton); // Add clear button to MP3 button panel
        mp3Panel.add(mp3ButtonPanel, BorderLayout.NORTH);

        // Display area for MP3 players
        mp3DisplayArea = new JTextArea();
        mp3DisplayArea.setEditable(false);
        mp3DisplayArea.setRows(10); // Setting the number of rows
        mp3DisplayArea.setColumns(20); // Setting the number of columns
        mp3Panel.add(new JScrollPane(mp3DisplayArea), BorderLayout.SOUTH);

        // Add MP3 panel to main panel
        mainPanel.add(mp3Panel);

        // Add main panel to frame and make it visible
        add(mainPanel);
        setVisible(true);
    }

    // Method to add input fields for mobiles
    private void addMobileFields() {
        mobileInputPanel.removeAll(); // Clear existing fields
        mobileInputPanel.add(new JLabel("Model:"));
        mobileModelField = new JTextField();
        mobileInputPanel.add(mobileModelField);

        mobileInputPanel.add(new JLabel("Price:"));
        mobilePriceField = new JTextField();
        mobileInputPanel.add(mobilePriceField);

        mobileInputPanel.add(new JLabel("Weight:"));
        mobileWeightField = new JTextField();
        mobileInputPanel.add(mobileWeightField);

        mobileInputPanel.add(new JLabel("Length (mm):"));
        mobileLengthField = new JTextField();
        mobileInputPanel.add(mobileLengthField);

        mobileInputPanel.add(new JLabel("Width (mm):"));
        mobileWidthField = new JTextField();
        mobileInputPanel.add(mobileWidthField);

        mobileInputPanel.add(new JLabel("Depth (mm):"));
        mobileDepthField = new JTextField();
        mobileInputPanel.add(mobileDepthField);

        mobileInputPanel.add(new JLabel("Calling Credit (minutes):"));
        mobileCreditField = new JTextField();
        mobileInputPanel.add(mobileCreditField);

        revalidate(); // Revalidate the panel to update changes
        repaint(); // Repaint the panel to reflect changes
    }

    // Method to add input fields for MP3 players
    private void addMP3Fields() {
        mp3InputPanel.removeAll(); // Clear existing fields
        mp3InputPanel.add(new JLabel("Model:"));
        mp3ModelField = new JTextField();
        mp3InputPanel.add(mp3ModelField);

        mp3InputPanel.add(new JLabel("Price:"));
        mp3PriceField = new JTextField();
        mp3InputPanel.add(mp3PriceField);

        mp3InputPanel.add(new JLabel("Weight:"));
        mp3WeightField = new JTextField();
        mp3InputPanel.add(mp3WeightField);

        mp3InputPanel.add(new JLabel("Length (mm):"));
        mp3LengthField = new JTextField();
        mp3InputPanel.add(mp3LengthField);

        mp3InputPanel.add(new JLabel("Width (mm):"));
        mp3WidthField = new JTextField();
        mp3InputPanel.add(mp3WidthField);

        mp3InputPanel.add(new JLabel("Depth (mm):"));
        mp3DepthField = new JTextField();
        mp3InputPanel.add(mp3DepthField);

        mp3InputPanel.add(new JLabel("Available Memory (GB):"));
        mp3MemoryField = new JTextField();
        mp3InputPanel.add(mp3MemoryField);

        revalidate(); // Revalidate the panel to update changes
        repaint(); // Repaint the panel to reflect changes
    }

    // Method to clear input fields for mobiles
    private void clearMobileFields() {
        mobileModelField.setText("");
        mobilePriceField.setText("");
        mobileWeightField.setText("");
        mobileLengthField.setText("");
        mobileWidthField.setText("");
        mobileDepthField.setText("");
        mobileCreditField.setText("");
    }

    // Method to clear input fields for MP3 players
    private void clearMP3Fields() {
        mp3ModelField.setText("");
        mp3PriceField.setText("");
        mp3WeightField.setText("");
        mp3LengthField.setText("");
        mp3WidthField.setText("");
        mp3DepthField.setText("");
        mp3MemoryField.setText("");
    }

    // Method to display mobiles in the JTextArea
    private void displayMobiles() {
        StringBuilder sb = new StringBuilder();
        for (Mobile mobile : mobiles) {
            sb.append(mobile).append("\n");
        }
        mobileDisplayArea.setText(sb.toString());
    }

    // Method to display MP3 players in the JTextArea
    private void displayMP3Players() {
        StringBuilder sb = new StringBuilder();
        for (MP3Player mp3Player : mp3Players) {
            sb.append(mp3Player).append("\n");
        }
        mp3DisplayArea.setText(sb.toString());
    }

    // Method to save mobile details
    private void saveMobile() {
        try {
            String model = mobileModelField.getText();
            double price = Double.parseDouble(mobilePriceField.getText());
            int weight = Integer.parseInt(mobileWeightField.getText());
            int length = Integer.parseInt(mobileLengthField.getText());
            int width = Integer.parseInt(mobileWidthField.getText());
            int depth = Integer.parseInt(mobileDepthField.getText());
            int credit = Integer.parseInt(mobileCreditField.getText());

            Mobile mobile = new Mobile(model, price, weight, length, width, depth, credit);
            mobiles.add(mobile);
            displayMobiles();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter numeric values for price, weight, length, width, depth, and credit.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to save MP3 player details
    private void saveMP3() {
        try {
            String model = mp3ModelField.getText();
            double price = Double.parseDouble(mp3PriceField.getText());
            int weight = Integer.parseInt(mp3WeightField.getText());
            int length = Integer.parseInt(mp3LengthField.getText());
            int width = Integer.parseInt(mp3WidthField.getText());
            int depth = Integer.parseInt(mp3DepthField.getText());
            double memory = Double.parseDouble(mp3MemoryField.getText());

            MP3Player mp3Player = new MP3Player(model, price, weight, length, width, depth, memory);
            mp3Players.add(mp3Player);
            displayMP3Players();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter numeric values for price, weight, length, width, depth, and memory.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to initiate making a call
    private void makeCall() {
        if (mobiles.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No mobiles available to make a call.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Mobile selectedMobile = mobiles.get(mobiles.size() - 1); // Select the last mobile added
        String phoneNumber = JOptionPane.showInputDialog(this, "Enter the phone number:");
        if(phoneNumber == null || phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Phone number cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int minutes = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter minutes for the call:"));
        if(minutes <= 0) {
            JOptionPane.showMessageDialog(this, "Invalid call duration.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        selectedMobile.makeCall(minutes);
        displayMobiles();
        // Display the call information in the display area
        mobileDisplayArea.append("You called " + phoneNumber + " for " + minutes + " minutes.\n");
        mobileDisplayArea.append("Your calling credit remaining is " + selectedMobile.getCredit() + " minutes.\n\n");
    }

    // Method to add credit to the selected mobile
    private void addCredit() {
        if (mobiles.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No mobiles available to add credit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Mobile selectedMobile = mobiles.get(mobiles.size() - 1); // Select the last mobile added
        int creditToAdd = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter credit to add:"));
        selectedMobile.addCredit(creditToAdd);
        displayMobiles();
    }

    // Method to download music to the selected MP3 player
    private void downloadMusic() {
        if (mp3Players.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No MP3 players available to download music.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        MP3Player selectedMP3 = mp3Players.get(mp3Players.size() - 1); // Select the last MP3 player added
        int memoryToAdd = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter memory to add (GB):"));
        selectedMP3.downloadMusic(memoryToAdd);
        displayMP3Players();
    }

    // Method to delete music from the selected MP3 player
    private void deleteMusic() {
        if (mp3Players.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No MP3 players available to delete music.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        MP3Player selectedMP3 = mp3Players.get(mp3Players.size() - 1); // Select the last MP3 player added
        int memoryToDelete = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter memory to delete (GB):"));
        selectedMP3.deleteMusic(memoryToDelete);
        displayMP3Players();
    }

    // Main method to start the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GadgetShop();
            }
        });
    }
}

