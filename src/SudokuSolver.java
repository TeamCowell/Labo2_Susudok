
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
	/*public boolean estValide(int x, int y, int valeur){

		boolean result = true;

		// si il a deja un nombre
		  if (array[x][y] != 0) {
		   throw new RuntimeException(
		     "Il y a deja un nombre a cette position");
		  }

		for(int i=0; i<9; i++){
			//row detection
			if( i != x && valeur == array[y][i]){
				result = false;
			}
			//col detection
			if( i != y && valeur == array[i][x] ){
				result = false;
			}
		}
		//Grid detection
		for(int i=(y/3)*3; i<(y/3)*3+3; i++){
			for(int j=(x/3)*3; j<(x/3)*3+3; j++){
//				System.out.println(i+" "+j + " " + array[i][j]);
				if(i != y && j != x && array[i][j] == valeur){
					result = false;
				}
			}
		}


		return true;
	}*/
/**
 * methode pour regarder si la valeur qu'on place est valide pour le sudoku
 * @param cell
 * @param valeur
 * @return
 */
	public boolean estValide(Cellule cell, int valeur){

		boolean result = true;

		// si il a deja un nombre
		if (array[cell.ligne][cell.colonne] != 0) {
			throw new RuntimeException(
					"Il y a deja un nombre a cette position");
		}

		for(int i=0; i<9; i++){
			//detection lignes
			if( array[cell.ligne][i] == valeur){
				result = false;
			}
			//detection colonne
			if( array[i][cell.colonne] == valeur ){
				result = false;
			}
		}
		//Detection grille
		
		for(int i=(cell.ligne/3)*3; i<(cell.ligne/3)*3+3; i++){
			for(int j=(cell.colonne/3)*3; j<(cell.colonne/3)*3+3; j++){
				//				System.out.println(i+" "+j + " " + array[i][j]);
				if(array[i][j] == valeur){
					result = false;
				}
			}
		}


		return true;
	}
	
	/**
	 * methode pour aller a la prochaine cellule
	 * @param cell
	 * @return
	 */
	public Cellule getProchaineCellule(Cellule cell){
		  int ligne = cell.ligne;
		  int colonne = cell.colonne++; // prochainne colonne

		  // si la colonne >8 alors colonne = 0 
		  //et ligne ++
		  if (colonne > 8) {
		   colonne = 0;
		   ligne++;
		  }

		  // si la ligne > 8, nous avons atteint la fin
		  if (ligne > 8)
		   return null;

		  Cellule prochaineCellule = new Cellule(ligne, colonne);
		  return prochaineCellule;	
	}


}
