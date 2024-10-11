import java.util.List;

public class EigenvalueDecomposer {

    
    // Matrix for which eigenvalues will be decomposed
    private Matrix matrix;

    // Constructor to initialize the EigenvalueDecomposer with a matrix
    public EigenvalueDecomposer(Matrix matrix) {
        this.matrix = matrix;
    }

    // Method to decompose eigenvalues of the matrix
    public List<Double> decomposeEigenvalues() {
        // Implement the logic to decompose eigenvalues
        return MatrixOperations.decomposeEigenvalues(matrix);
    }
}
