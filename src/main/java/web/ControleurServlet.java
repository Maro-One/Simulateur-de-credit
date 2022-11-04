package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetierImpl;
import metier.ICreditMetier;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.php" })
public class ControleurServlet extends HttpServlet {

	private ICreditMetier metier;

	public void init() throws ServletException {
		metier = new CreditMetierImpl();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("creditModel", new CreditModel());
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * Lire les données de la requête
		 */

		double montant = Double.parseDouble(request.getParameter("montant"));
		double taux = Double.parseDouble(request.getParameter("taux"));
		int duree = Integer.parseInt(request.getParameter("duree"));

		/*
		 * Valider les données
		 */
		/*
		 * Stocker les données saisies dans le modèle
		 */
		CreditModel model = new CreditModel();
		model.setMensualite(montant);
		model.setTaux(taux);
		model.setDuree(duree);
		/*
		 * Faire appel à la couche métier pour effectuer les traitements
		 */
		double res = metier.calculerMensualiteCredit(montant, taux, duree);
		/*
		 * Stocker les résultats dans le modèle
		 */
		model.setMensualite(res);
		/*
		 * Stocker le modèle dans l'objet request
		 */
		request.setAttribute("creditModel", model);

		/*
		 * Faire un forward vers la vue JSP
		 */
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);

	}

}
