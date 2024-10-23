public class Face {

    private Tile[][] grid;  
    private int size;       

    public enum Tile {
        RED, BLUE, GREEN, YELLOW, WHITE, ORANGE
    }

    // Initialize face with color
    public Face(int size, Tile color) {
        this.size = size;
        grid = new Tile[size][size];
        for (int i = 0; i < size; i++) { // Loop thru each tile 
            for (int j = 0; j < size; j++) { // Set tile to color
                grid[i][j] = color;
            }
        }
    }

    public void printFace() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j< size; j++) {
                System.out.print(grid[i][j].toString().charAt(0) + " "); 
            }
            System.out.println();
        }
    }

    //Getters and setters for row/col
    public Tile[] getRow(int rowIndex) {
        Tile[] row = new Tile[size];
        for (int i = 0; i < size; i++) {
            row[i] = grid[rowIndex][i];
        }
        return row;
    }

    public void setRow(int rowIndex, Tile[] newRow) {
        for (int i = 0; i < size; i++) {
            grid[rowIndex][i] = newRow[i];
        }
    }

    public Tile[] getCol(int colIndex) {
        Tile[] col = new Tile[size];
        for (int i = 0; i < size; i++) {
            col[i] = grid[i][colIndex];
        }
        return col;
    }

    public void setCol(int colIndex, Tile[] newCol) {
        for (int i = 0; i < size; i++) {
            grid[i][colIndex] = newCol[i];
        }
    }
}
