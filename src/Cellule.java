
public class Cellule {

	int ligne,colonne;
	
	public Cellule(int ligne , int colonne){
		this.ligne = ligne;
		this.colonne = colonne;
	}
	
	@Override
	public String toString(){
		return "Cellule [ligne=" +ligne+", colonne="+colonne +"]";
	}
}
