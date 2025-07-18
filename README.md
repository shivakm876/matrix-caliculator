


   # 🧮 Matrix Calculator – Java Desktop Application

A Java-based desktop application that performs matrix and vector computations through an intuitive graphical interface. Built using Swing and object-oriented programming principles, this tool simplifies complex linear algebra tasks for students and professionals.

---

## 🚀 Features

- Perform core matrix operations:
  - Addition, Multiplication
  - Transpose, Scalar Multiplication
  - Inverse, Determinant Calculation
- Vector operations:
  - Dot Product, Normalization, Scalar Multiplication
- Support for custom matrix input via UI
- Clean, modular class structure (`Matrix`, `RowVector`, `Vector`, etc.)
- Responsive Swing-based interface for interactive use

---

## 🗂️ Project Structure

```
MatrixCalculator/
├── Main.java                    # Entry point of the application
├── Matrix.java                  # Matrix class with core logic
├── RowVector.java               # Row vector operations
├── Vector.java                  # General vector operations
├── MatrixTransformer.java       # Matrix transformations like add, multiply, transpose
├── InverseCalculator.java       # Calculates inverse of a matrix
├── DeterminantCalculator.java   # Calculates determinant
├── EigenvalueDecomposer.java    # Decomposes matrix to find eigenvalues
├── UserMatrixFactory.java       # Builds matrix objects from UI inputs
```

---

## 🛠️ Tech Stack

- **Java** (Core logic)
- **Swing** (GUI)
- **OOP** (Modular, maintainable structure)

---

## 🖥️ How to Run

1. **Clone the Repository**
   ```bash
   git clone https://github.com/shivakm876/matrix-caliculator.git
   ```
2. **Open the Project in VS Code**
   - Launch Visual Studio Code.
   - Open the cloned folder (`matrix-caliculator`) in VS Code.

3. **Compile the Java Code**
   - Open the integrated terminal in VS Code.
   - Navigate to the directory containing your Java files.
   - Run the following command to compile:
     ```bash
     javac <YourMainClass>.java
     ```
     Replace `<YourMainClass>` with the name of your main Java file (the one with the `main` method).

4. **Run the Program**
   ```bash
   java <YourMainClass>
   ```
   Again, replace `<YourMainClass>` with the actual class name containing the `main` method.

---

## 📦 Requirements

- Java JDK (8 or above)
- Visual Studio Code (recommended for development)
- No external dependencies required

---

## 👤 Author

- [shivakm876](https://github.com/shivakm876)

---

Feel free to contribute or raise issues if you find any problems!

```
📝 License
This project is licensed under the MIT License.
