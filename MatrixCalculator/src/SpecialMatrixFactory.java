/**
 * A factory class for creating special matrices such as identity, zero, and random matrices.
 */
public class SpecialMatrixFactory {
    
    /**
     * Method to create special matrices based on type.
     * @param rows The number of rows in the matrix
     * @param cols The number of columns in the matrix
     * @param type The type of special matrix to create ("identity", "zero", or "random")
     * @return The created special matrix
     * @throws IllegalArgumentException If an invalid matrix type is provided
     */
    public Matrix createSpecialMatrix(int rows, int cols, String type) {
        switch (type) {
            case "identity":
                return createIdentityMatrix(rows, cols);
            case "zero":
                return createZeroMatrix(rows, cols);
            case "random":
                return createRandomMatrix(rows, cols);
            default:
                throw new IllegalArgumentException("Invalid matrix type");
        }
    }

    /**
     * Method to create an identity matrix.
     * @param rows The number of rows in the identity matrix
     * @param cols The number of columns in the identity matrix
     * @return The created identity matrix
     */
    private Matrix createIdentityMatrix(int rows, int cols) {
        Matrix identityMatrix = new Matrix(rows, cols);
        for (int i = 0; i < Math.min(rows, cols); i++) {
            identityMatrix.setElement(i, i, 1);
        }
        return identityMatrix;
    }

    /**
     * Method to create a zero matrix.
     * @param rows The number of rows in the zero matrix
     * @param cols The number of columns in the zero matrix
     * @return The created zero matrix
     */
    private Matrix createZeroMatrix(int rows, int cols) {
        return new Matrix(rows, cols); // Matrix constructor initializes elements to zero
    }

    /**
     * Method to create a random matrix.
     * @param rows The number of rows in the random matrix
     * @param cols The number of columns in the random matrix
     * @return The created random matrix
     */
    private Matrix createRandomMatrix(int rows, int cols) {
        Matrix randomMatrix = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                randomMatrix.setElement(i, j, Math.random());
            }
        }
        return randomMatrix;
    }
}
