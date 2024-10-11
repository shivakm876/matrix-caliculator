import javax.swing.JTextField;

/**
 * Factory class to create matrices from user input.
 */
public class UserMatrixFactory {

    /**
     * Method to create a matrix from user input.
     * @param matrixFields The array of JTextFields containing matrix elements
     * @return The created matrix
     */
    public Matrix createMatrixFromUserInput(JTextField[][] matrixFields) {
        // Get the dimensions of the matrix from the number of rows and columns of the matrixFields array
        int rows = matrixFields.length;
        int cols = matrixFields[0].length;

        // Create a new matrix with the given dimensions
        Matrix matrix = new Matrix(rows, cols);

        // Extract the elements from the text fields
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Get the text from the JTextField
                String text = matrixFields[i][j].getText();
                // Parse the text to get the element value
                double element = Double.parseDouble(text);
                // Set the element in the matrix
                matrix.setElement(i, j, element);
            }
        }

        return matrix;
    }
}
