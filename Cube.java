public class Cube {

    private Face front;
    private Face back;
    private Face top;
    private Face bottom;
    private Face left;
    private Face right;

    private int size; 

    // Initialize cube
    public Cube(int size) {
        this.size = size;

        front = new Face(size, Face.Tile.GREEN);
        back = new Face(size, Face.Tile.BLUE);
        top = new Face(size, Face.Tile.WHITE);
        bottom = new Face(size, Face.Tile.YELLOW);
        left = new Face(size, Face.Tile.ORANGE);
        right = new Face(size, Face.Tile.RED);
    }

    public int getSize() {
        return this.size;
    }

    // Function to reverse array; needed when dealing with the back face
    private Face.Tile[] reverseArr(Face.Tile[] arr) {
        Face.Tile[] rev = new Face.Tile[arr.length];

        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length-1-i];
        }
        return rev;
    }

    // Method to rotate row CCW; rotations are done from the perspective of the front face
    // Rotations are based on the front face
    public void rotateRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= size) {
            throw new IllegalArgumentException("Invalid row index");
        }

        // Save front face's row to temp
        Face.Tile[] temp = front.getRow(rowIndex);

        // Move left face row to front
        front.setRow(rowIndex, left.getRow(rowIndex));

        // Move back face row to left
        left.setRow(rowIndex, back.getRow(rowIndex));

        // Move right face row to back
        back.setRow(rowIndex, right.getRow(rowIndex));

        // Move front face row to right
        right.setRow(rowIndex, temp);
    }




    // Method to rotate column CCW
    public void rotateCol(int colIndex) {
        if (colIndex < 0 || colIndex >= size) {
            throw new IllegalArgumentException("Invalid column index");
        }

        // Save col in top face to temp
        Face.Tile[] temp = top.getCol(colIndex);

        // Move front col to top
        top.setCol(colIndex, front.getCol(colIndex));

        // Move bottom col to front
        front.setCol(colIndex, bottom.getCol(colIndex));

        // Move back col to bottom
        Face.Tile[] reversedBackCol = reverseArr(back.getCol(colIndex)); // Reverse to keep its orientation
        bottom.setCol(colIndex, reversedBackCol);

        // Move top col to back
        back.setCol(colIndex, reverseArr(temp));
    }


    public void printCube() {
        System.out.println("Top face:");
        top.printFace();
        System.out.println("\nFront face:");
        front.printFace();
        System.out.println("\nRight face:");
        right.printFace();
        System.out.println("\nBack face:");
        back.printFace();
        System.out.println("\nLeft face:");
        left.printFace();
        System.out.println("\nBottom face:");
        bottom.printFace();
    }

    // Function to change orientation of the cube's front face
    public void flip(int newFront) {
        switch (newFront) {
            case 1:  // Make top face the front face
                Face tempFront = front;
                front = top;
                top = back;
                back = bottom;
                bottom = tempFront;
                break;

            case 2:  // Make bottom face the front face
                tempFront = front;
                front = bottom;
                bottom = back;
                back = top;
                top = tempFront;
                break;

            case 3:  // Make left face the front face
                tempFront = front;
                front = left;
                left = back;
                back = right;
                right = tempFront;
                break;

            case 4:  // Make right face the front face
                tempFront = front;
                front = right;
                right = back;
                back = left;
                left = tempFront;
                break;

            case 5:  // Make back face the front face
                tempFront = front;
                front = back;
                back = tempFront;  // Swap back and front
                break;

            default:
                System.out.println("Invalid option");
                break;
        }
    }
}


