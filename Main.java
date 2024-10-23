import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Testing with a 3x3 cube; uses size NxN so can be used with other sizes
        Cube cube = new Cube(3);

        System.out.println("Initial State:");
        cube.printCube();


        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Rotate a row");
            System.out.println("2. Rotate a column");
            System.out.println("3. Change the cube orientation");
            System.out.println("4. Exit");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:  // Rotate a row
                    System.out.print("Select a row to rotate (1 to " + (cube.getSize()) + ") ");
                    int rowIndex = scanner.nextInt() - 1;
                        cube.rotateRow(rowIndex);  // Rotate row CCW
                    break;

                case 2:  // Rotate a column
                    System.out.print("Select a column to rotate (1 to " + (cube.getSize() ) + ") ");
                    int colIndex = scanner.nextInt() - 1;
                        cube.rotateCol(colIndex);  // Rotate column CCW
                    break;

                case 3:  // Change the cube's orientation
                    System.out.println("Select a face orientation to bring to the front");
                    System.out.println("1. Top");
                    System.out.println("2. Bottom");
                    System.out.println("3. Left");
                    System.out.println("4. Right");
                    System.out.println("5. Back");
                    int newFront = scanner.nextInt();
                    cube.flip(newFront);  // Update the front face 
                    break;

                case 4:  
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option");
                    break;
            }

            System.out.println("\nUpdated cube:");
            cube.printCube();
        }
    }
}


