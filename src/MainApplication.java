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
		SudokuSolver solver = new SudokuSolver( array );
		
		
		for (int i = 0; i < 9; i++) {
			   for (int j = 0; j < 9; j++){
			    System.out.print(solver.array[i][j]);
			   }
			   System.out.println();
			  }
		System.out.println(solver.estValide(3,0,3));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		long startTime = System.nanoTime();
		if(!solver.solve(0, 0)){
			System.out.println("Le sudoku n'a pas de solution.");
		}
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
		
		
		for (int i = 0; i < 9; i++) {
			   for (int j = 0; j < 9; j++)
			    System.out.print(solver.array[i][j]);
			   System.out.println();
			  }
		System.out.println(duration/1000000+" ms");
//		System.out.println(array[6][5]); //array[y][x]
//		System.out.println(solver.estValide(6, 6, 8));

	}

}
