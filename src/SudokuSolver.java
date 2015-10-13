
public class SudokuSolver {
	
	int[][] array = new int[9][9];
	boolean estDerniereCase = false;
	
	
	public SudokuSolver(int[][] array){
		this.array = array;
	}
	
	/**
	 * 
	 * @param x est la position en x sur la table (0..8)
	 * @param y est la position en y sur la table (0..8)
	 * @param valeur est la valeur � la position x y
	 * @return vrai si la valeur � la position donn�e ne se trouve
	 * pas sur la m�me ligne, colone ou region de la table
	 */
	public boolean estValide(int x, int y, int valeur){
		
		boolean result = true;
		
		for(int i=0; i<9; i++){
			if( i != x && valeur == array[y][i]){
				result = false;
			}
			if( i != y && valeur == array[i][x] ){
				result = false;
			}
		}
		
		for(int i=(y/3)*3; i<(y/3)*3+3; i++){
			for(int j=(x/3)*3; j<(x/3)*3+3; j++){
//				System.out.println(i+" "+j + " " + array[i][j]);
				if(i != y && j != x && array[i][j] == valeur){
					result = false;
				}
			}
		}
		
		
		return result;
	}
	 public  int[] getNextCell(int lig,int col) {
		 
		 if(lig == 8 && col == 8){
			 return null;
		 }
		 
		 int[] tempArray = new int[2];
		  // next cell => col++
		 col++;

		  // if col > 8, then col = 0, row++
		  // reached end of row, got to next row
		  if (col > 8) {
		   // goto next line
		   col = 0;
		   lig++;
		  }

		  // reached end of matrix, return null
		  if (lig > 8)
		   return null; // reached end
		  
		  tempArray[0] = lig;
		  tempArray[1] = col;
		  return tempArray;
		 }
	 
	 public boolean solve(int lig,int col) {
		 int[] tempArray = new int[2];
		 
		  //if the cell is null, we have reached the end
		 if(estDerniereCase){
			 estDerniereCase = false;
			 return true;
		 }
		  
		 if(lig == 8 && col == 8){
			 estDerniereCase = true;
			 //System.out.println(lig+"__"+col);
			 
			 //return true;
		 }
		  // if grid[cur] already has a value, there is nothing to solve here,
		  // continue on to next cell
		  if (array[lig][col] != 0) {
		   // return whatever is being returned by solve(next)
		   // i.e the state of soduku's solution is not being determined by
		   // this cell, but by other cells
		   
		   tempArray = getNextCell(lig,col);
		   
		  // System.out.println("NextCell: "+tempArray[0] + "-" + tempArray[1]);
		   return solve(tempArray[0],tempArray[1]);
		   
		  }

		  // this is where each possible value is being assigned to the cell, and
		  // checked if a solutions could be arrived at.
		  
		  // if grid[cur] doesn't have a value
		  // try each possible value
		  for (int i = 1; i <= 9; i++) {
		   // check if valid, if valid, then update
		   boolean valid = estValide(col,lig,i);

		   if (!valid) // i not valid for this cell, try other values
		    continue;

		   // assign here
		   array[lig][col] = i;

		   if(!estDerniereCase){
		   // continue with next cell
		   tempArray = getNextCell(lig,col);
		   boolean solved = solve(tempArray[0],tempArray[1]);
		   
		   // if solved, return, else try other values
		   if (solved){ 
		    return true;
		   }
		   else
		    array[lig][col] = 0; // reset
		   // continue with other possible values
		   }else{
			   estDerniereCase = false;
			   return true;
		   }
		  }

		  // if you reach here, then no value from 1 - 9 for this cell can solve
		  // return false
		  return false;
		 }


}
