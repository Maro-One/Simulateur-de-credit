package metier;

public class TestMetier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreditMetierImpl metier = new CreditMetierImpl();
		double capital=200000;
		int duree=240;
		double taux=4.5;
		
		double m = metier.calculerMensualiteCredit(capital, taux, duree);
		
		System.out.println(m);

	}

}
