import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Sudoku Solver 1.0");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter .sud file path:");
		String path = br.readLine();
		
		System.out.println("reading " + path + "...");
		int[][] array = new FileReader(path).readSudFile();
		SudokuSolver solver = new SudokuSolver(array);
		System.out.println("LOADING SOLUTION...");
		boolean solutionner = solver.solve(new Cellule(0,0));
		
		if(solutionner == true){
			System.out.println("LE SUDOKU A ETE SOLUTIONNER!");
		}
		else{
			System.out.println("LE SUDOKU EST IMPOSSIBLE");
		}
		for (int i = 0; i < 9; i++) {
			   for (int j = 0; j < 9; j++){
			    System.out.print(array[i][j]);
			   }
			   System.out.println();
			  }
//		System.out.println(array[6][5]); //array[y][x]
//		System.out.println(solver.estValide(6, 7, 8));

	}

}
