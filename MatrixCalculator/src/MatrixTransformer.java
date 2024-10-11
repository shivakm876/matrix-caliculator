/**
 * Class representing a MatrixTransformer that performs various transformations on a Matrix.
 */
public class MatrixTransformer {
    
    private Matrix matrix; // The matrix to be transformed
    
    /**
     * Constructor to initialize the MatrixTransformer with a matrix.
     * @param matrix The matrix to be transformed
     */
    public MatrixTransformer(Matrix matrix) {
        this.matrix = matrix;
    }
    
    /**
     * Method to multiply the matrix by a scalar.
     * @param scalar The scalar value to multiply the matrix by
     * @return The resulting matrix after scalar multiplication
     */
    public Matrix multiplyByScalar(double scalar) {
        return MatrixOperations.multiplyByScalar(matrix, scalar);
    }
    
    /**
     * Method to add another matrix to the current matrix.
     * @param other The matrix to be added
     * @return The resulting matrix after addition
     */
    public Matrix add(Matrix other) {
        return MatrixOperations.addMatrices(matrix, other);
    }
    
    /**
     * Method to multiply the current matrix by another matrix.
     * @param other The matrix to be multiplied with
     * @return The resulting matrix after multiplication
     */
    public Matrix multiply(Matrix other) {
        return MatrixOperations.multiplyMatrices(matrix, other);
    }
    
    /**
     * Method to transpose the current matrix.
     * @return The transposed matrix
     */




    public Matrix transpose() {
        return matrix.transpose();
    }
    
    
}
