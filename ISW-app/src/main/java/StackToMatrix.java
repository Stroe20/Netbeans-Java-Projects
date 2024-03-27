public class StackToMatrix {
    private FloatStack stack = new FloatStack();
    private float[][] matrix;

    public void pushToStack(float element) {
        stack.push(element);
    }

    public void buildMatrixFromStack() {
        int size = (int) Math.ceil(Math.sqrt(stack.size()));
        matrix = new float[size][size];

        int row = 0;
        int col = 0;

        while (!stack.isEmpty()) {
            matrix[row][col] = stack.pop();
            col++;

            if (col == size) {
                col = 0;
                row++;
            }
        }
    }

    public String getStackAsString() {
        FloatStack tempStack = new FloatStack();
        StringBuilder stringBuilder = new StringBuilder();

        // Reverse the order while populating the temporary stack
        while (!stack.isEmpty()) {
            float element = stack.pop();
            tempStack.push(element);
            stringBuilder.append(element).append(" ");
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return stringBuilder.toString();
    }

    public String getMatrixAsString() {
        if (matrix == null) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
