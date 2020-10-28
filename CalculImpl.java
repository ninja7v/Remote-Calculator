import java.rmi.*;

public class CalculImpl implements Calcul{
	public CalculImpl () {}
	private int a,b,resultat;
	public String calcul (int a,char operation, int b) throws DivisionParZero, NombreNegatif, ResultatNegatif {
	if (a<0 || b<0)  throw new NombreNegatif();//nombre negatif
		else {
		switch(operation){
		case '+' : 
			resultat = a + b;
			break;
		case '-' :
			if (a>=b){
				resultat = a - b;
			}
			else {resultat = -1;//resultat negatif
			throw new ResultatNegatif();
			}
			break;
		case '*' : 
			resultat = a * b; 
			break;
		case '/' : 
			if (b == 0){
			resultat = -1;//division par 0
			throw new DivisionParZero();
				}
			else{ 
				resultat = a / b;
			} 
			break;
		default :
			resultat = -1; 
		}
	}
	if (resultat == -1){
		return "-1 : Error exists";
	}
	//On retourne le resultat en String
	else return String.valueOf(resultat);
}
}

