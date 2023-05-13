package cat.prateducacio.jdbc.app;

import cat.prateducacio.jdbc.mvc.controller.CiutatController;

public class Main {

	public static void main(String[] args) {
		CiutatController.getInstance().addCiutat();
		CiutatController.getInstance().getTotesLesCiutats();
		CiutatController.getInstance().updateCiutat();
		CiutatController.getInstance().getTotesLesCiutats();
		CiutatController.getInstance().deleteCiutat();
		CiutatController.getInstance().getTotesLesCiutats();
		
	}
}