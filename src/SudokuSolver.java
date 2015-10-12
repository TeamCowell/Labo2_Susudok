
public class SudokuSolver {
	
	int[][] array = new int[9][9];
	
	public SudokuSolver(int[][] array){
		this.array = array;
	}
	
	/**
	 * 
	 * @param x est la position en x sur la table (0..8)
	 * @param y est la position en y sur la table (0..8)
	 * @param valeur est la valeur à la position x y
	 * @return vrai si la valeur à la position donnée ne se trouve
	 * pas sur la même ligne, colone ou region de la table
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
		
		for(int i=(x/3)*3; i<(x/3)*3+3; i++){
			for(int j=(x/3)*3; j<(x/3)*3+3; j++){
				if(i != y && j != x && array[i][j] == valeur){
					result = false;
				}
			}
		}
		
		
		return result;
	}

}
