//// Imports necessary packages from javax.swing and java.awt.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

///Main class that extends JFrame for the main window
public class Main extends JFrame {
    ////Declares instance variables for components like buttons and panels.

    // Fields for matrix and vector input text fields
    private JTextField[][] matrixFields1;
    private JTextField[][] matrixFields2;
    private JTextField[][] vectorFields1;
    private JTextField[][] vectorFields2;

    // Buttons for different operations
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton determinantButton;
    private JButton inverseButton;
    private JButton dotProductButton;
    private JButton magnitudeButton;
    private JButton normalizeButton;
    private JButton angleBetweenButton;
    private JButton scalarMultiplyButton;
    private JButton addVectorButton;
    private JButton subtractVectorButton;

    // Panels to organize components
    private JPanel matrixPanel1;
    private JPanel matrixPanel2;
    private JPanel vectorPanel1;
    private JPanel vectorPanel2;
    private JPanel resultPanel;

    // Label to display messages
    private JLabel messageLabel;

    // Factory to create matrices
    private UserMatrixFactory matrixFactory;

    // Enum to differentiate between matrix and vector operations
    private enum OperationType {
        MATRIX, VECTOR
    }
     // //Initializes the frame and components in the constructor based on the operation type.

    // Constructor to initialize the frame
    public Main(OperationType operationType) {
        // Set frame properties
        setTitle(operationType == OperationType.MATRIX ? "Matrix Operations" : "Vector Operations");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 500); // Increased size
        setLocationRelativeTo(null);

        // Initialize matrix factory
        matrixFactory = new UserMatrixFactory();
  // //the left panel is customized with a background image using a custom paintComponent method.

        // Initialize panels and message label
        JPanel leftPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image bgImage = new ImageIcon("background.gif").getImage();
                g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        leftPanel.setPreferredSize(new Dimension(400, 500)); // Adjusted width
        matrixPanel1 = new JPanel();
        matrixPanel2 = new JPanel();
        vectorPanel1 = new JPanel();
        vectorPanel2 = new JPanel();
        resultPanel = new JPanel(new GridLayout(5, 1));
        messageLabel = new JLabel("");

        //// Buttons for different operations are initializedd


        // Initialize buttons for different operations
       // Creating buttons with custom font style and size
Font customFont = new Font("PWJoyeuxNoel", Font.PLAIN, 26); // Customize the font style and size

addButton = new JButton("Add");
addButton.setFont(customFont); // Set the custom font
subtractButton = new JButton("Subtract");
subtractButton.setFont(customFont); // Set the custom font
multiplyButton = new JButton("Multiply");
multiplyButton.setFont(customFont); // Set the custom font
determinantButton = new JButton("Determinant");
determinantButton.setFont(customFont); // Set the custom font
inverseButton = new JButton("Inverse");
inverseButton.setFont(customFont); // Set the custom font
dotProductButton = new JButton("Dot Product");
dotProductButton.setFont(customFont); // Set the custom font
magnitudeButton = new JButton("Magnitude");
magnitudeButton.setFont(customFont); // Set the custom font
normalizeButton = new JButton("Normalize");
normalizeButton.setFont(customFont); // Set the custom font
angleBetweenButton = new JButton("Angle Between");
angleBetweenButton.setFont(customFont); // Set the custom font
scalarMultiplyButton = new JButton("Scalar Multiply");
scalarMultiplyButton.setFont(customFont); // Set the custom font
addVectorButton = new JButton("Add Vector");
addVectorButton.setFont(customFont); // Set the custom font
subtractVectorButton = new JButton("Subtract Vector");
subtractVectorButton.setFont(customFont); // Set the custom font

   ////// action listeners are added to perform operations when clicked.


            
        // Add action listeners to buttons
        addButton.addActionListener(e -> performOperation(operationType == OperationType.MATRIX ? MatrixOperation.ADD : VectorOperation.ADD_VECTOR));
        subtractButton.addActionListener(e -> performOperation(operationType == OperationType.MATRIX ? MatrixOperation.SUBTRACT : VectorOperation.SUBTRACT_VECTOR));
        multiplyButton.addActionListener(e -> performOperation(operationType == OperationType.MATRIX ? MatrixOperation.MULTIPLY : VectorOperation.SCALAR_MULTIPLY));
        scalarMultiplyButton.addActionListener(e -> performOperation(operationType == OperationType.MATRIX ? MatrixOperation.MULTIPLY : VectorOperation.SCALAR_MULTIPLY));

        addVectorButton.addActionListener(e -> performOperation(VectorOperation.ADD_VECTOR));
        subtractVectorButton.addActionListener(e -> performOperation(VectorOperation.SUBTRACT_VECTOR));

        determinantButton.addActionListener(e -> performOperation(MatrixOperation.DETERMINANT));
        inverseButton.addActionListener(e -> performOperation(MatrixOperation.INVERSE));
        dotProductButton.addActionListener(e -> performOperation(VectorOperation.DOT_PRODUCT));
        magnitudeButton.addActionListener(e -> performOperation(VectorOperation.MAGNITUDE));
        normalizeButton.addActionListener(e -> performOperation(VectorOperation.NORMALIZE));
        angleBetweenButton.addActionListener(e -> performOperation(VectorOperation.ANGLE_BETWEEN));

        // Prompt the user to enter the number of rows and columns
        int rows = Integer.parseInt(JOptionPane.showInputDialog("Enter number of rows:"));
        int cols = Integer.parseInt(JOptionPane.showInputDialog("Enter number of columns:"));

        // Initialize matrix or vector fields based on operation type
        if (operationType == OperationType.MATRIX) {
            matrixFields1 = new JTextField[rows][cols];
            matrixFields2 = new JTextField[rows][cols];
            addMatrixFields(matrixPanel1, matrixFields1);
            addMatrixFields(matrixPanel2, matrixFields2);
            // Add matrix panels to the left panel
            leftPanel.add(matrixPanel1);
            leftPanel.add(matrixPanel2);
            // Add matrix operation buttons to the result panel
            resultPanel.add(addButton);
            resultPanel.add(subtractButton);
            resultPanel.add(multiplyButton);
            resultPanel.add(determinantButton);
            resultPanel.add(inverseButton);
        } else {
            vectorFields1 = new JTextField[rows][1];
            vectorFields2 = new JTextField[rows][1];
            addMatrixFields(vectorPanel1, vectorFields1);
            addMatrixFields(vectorPanel2, vectorFields2);
            // Add vector panels to the left panel
            leftPanel.add(vectorPanel1);
            leftPanel.add(vectorPanel2);
            // Add vector operation buttons to the result panel
            resultPanel.add(dotProductButton);
            resultPanel.add(magnitudeButton);
            resultPanel.add(normalizeButton);
            resultPanel.add(angleBetweenButton);
            resultPanel.add(scalarMultiplyButton);
            resultPanel.add(addVectorButton);
            resultPanel.add(subtractVectorButton);
        }
        // Add message label to the result panel
        resultPanel.add(messageLabel);

        // Set frame layout based on operation type
        getContentPane().setLayout(new GridLayout(1, 2));
        getContentPane().add(leftPanel);
        getContentPane().add(resultPanel);

        setVisible(true);
    }

    //The performOperation method handles the execution of selected operations based on user input.

    // Method to perform the selected operation
    private void performOperation(Operation operation) {
        try {
            if (operation instanceof MatrixOperation) {
                Matrix matrix1 = matrixFactory.createMatrixFromUserInput(matrixFields1);
                Matrix matrix2 = matrixFactory.createMatrixFromUserInput(matrixFields2);
                Matrix result = null;

                switch ((MatrixOperation) operation) {
                    case ADD:
                        result = MatrixOperations.addMatrices(matrix1, matrix2);
                        break;
                    case SUBTRACT:
                        result = MatrixOperations.subtractMatrices(matrix1, matrix2);
                        break;
                    case MULTIPLY:
                        result = MatrixOperations.multiplyMatrices(matrix1, matrix2);
                        break;
                    case DETERMINANT:
                        double determinant1 = MatrixOperations.calculateDeterminant(matrix1);
                        double determinant2 = MatrixOperations.calculateDeterminant(matrix2);
                        messageLabel.setText("Determinant of Matrix 1: " + determinant1 + ", Determinant of Matrix 2: " + determinant2);
                        break;
                    case INVERSE:
                        Matrix inverseMatrix1 = MatrixOperations.calculateInverse(matrix1);
                        Matrix inverseMatrix2 = MatrixOperations.calculateInverse(matrix2);
                        displayResult(inverseMatrix1);
                        displayResult(inverseMatrix2);
                        break;
                }
                if (result != null) {
                    displayResult(result);
                }
            } else if (operation instanceof VectorOperation) {
                Vector vector1 = createVectorFromUserInput(vectorFields1);
                Vector vector2 = createVectorFromUserInput(vectorFields2);
                switch ((VectorOperation) operation) {
                    case DOT_PRODUCT:
                        double dotProduct = vector1.dotProduct(vector2);
                        messageLabel.setText("Dot Product: " + dotProduct);
                        break;
                    case MAGNITUDE:
                        double magnitude1 = vector1.magnitude();
                        double magnitude2 = vector2.magnitude();
                        messageLabel.setText("Magnitude of Vector 1: " + magnitude1 + ", Magnitude of Vector 2: " + magnitude2);
                        break;
                    case NORMALIZE:
                        Vector normalizedVector1 = vector1.normalize();
                        Vector normalizedVector2 = vector2.normalize();
                        displayResult(normalizedVector1);
                        displayResult(normalizedVector2);
                        break;
                    case ANGLE_BETWEEN:
                        double angleBetween = vector1.angleBetween(vector2);
                        messageLabel.setText("Angle Between Vectors: " + angleBetween);
                        break;
                    case SCALAR_MULTIPLY:
                        double scalar = Double.parseDouble(JOptionPane.showInputDialog("Enter scalar value:"));
                        Vector scaledVector1 = vector1.scalarMultiply(scalar);
                        Vector scaledVector2 = vector2.scalarMultiply(scalar);
                        displayResult(scaledVector1);
                        displayResult(scaledVector2);
                        break;
                    case ADD_VECTOR:
                        Vector sumVector = vector1.add(vector2);
                        displayResult(sumVector);
                        break;
                    case SUBTRACT_VECTOR:
                        Vector differenceVector = vector1.subtract(vector2);
                        displayResult(differenceVector);
                        break;
                }
            }
        } catch (IllegalArgumentException ex) {
            messageLabel.setText("Error: " + ex.getMessage());
        }
    }


    // Method to create a vector from user input
    private Vector createVectorFromUserInput(JTextField[][] vectorFields) {
        int dimensions = vectorFields.length;
        Vector vector = new Vector(dimensions);
        for (int i = 0; i < dimensions; i++) {
            double value = Double.parseDouble(vectorFields[i][0].getText());
            vector.setElement(i, value);
        }
        return vector;
    }

    // Method to add text fields for matrix input to a panel
    private void addMatrixFields(JPanel panel, JTextField[][] matrixFields) {
        panel.setBorder(BorderFactory.createTitledBorder("Matrix/Vector"));
        panel.setLayout(new GridLayout(matrixFields.length, matrixFields[0].length));
        for (int i = 0; i < matrixFields.length; i++) {
            for (int j = 0; j < matrixFields[0].length; j++) {
                JTextField textField = new JTextField();
                textField.setPreferredSize(new Dimension(30, 20)); // Adjusted size
                matrixFields[i][j] = textField;
                panel.add(textField);
            }
        }
    }
//    }
// Methods are defined to display result matrices or vectors in a message dialog.

    // Method to display result matrix
    private void displayResult(Matrix result) {
        JTextArea resultArea = new JTextArea(result.toString());
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        JOptionPane.showMessageDialog(this, scrollPane, "Result", JOptionPane.PLAIN_MESSAGE);
    }

    // Method to display result vector
    private void displayResult(Vector result) {
        JTextArea resultArea = new JTextArea(result.toString());
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setPreferredSize(new Dimension(100, 100));
        JOptionPane.showMessageDialog(this, scrollPane, "Result", JOptionPane.PLAIN_MESSAGE);
    }
////main methood promotes user to select operation type(vector /matri
    // Main method to start the application
    public static void main(String[] args) {
        Object[] options = {"Matrix", "Vector"};
        int choice = JOptionPane.showOptionDialog(null, "Select operation type:", "Operation Type", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        OperationType operationType = choice == 0 ? OperationType.MATRIX : OperationType.VECTOR;
        SwingUtilities.invokeLater(() -> new Main(operationType));
    }
}

// Enum for MatrixOperation
enum MatrixOperation implements Operation {
    ADD, SUBTRACT, MULTIPLY, DETERMINANT, INVERSE;
}

// Enum for VectorOperation
enum VectorOperation implements Operation {
    DOT_PRODUCT, MAGNITUDE, NORMALIZE, ANGLE_BETWEEN, SCALAR_MULTIPLY, ADD_VECTOR, SUBTRACT_VECTOR;
}
 
//operation interfacei is common interface  for MatrixOperation and VectorOperation

interface Operation {
}

                        