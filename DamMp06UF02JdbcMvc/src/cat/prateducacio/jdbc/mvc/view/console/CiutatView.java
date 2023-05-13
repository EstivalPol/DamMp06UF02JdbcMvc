package cat.prateducacio.jdbc.mvc.view.console;

import java.util.Scanner;

import cat.prateducacio.jdbc.mvc.model.domain.Ciutat;

public class CiutatView {

	private CiutatView() {}

	private static CiutatView instance;

	public static CiutatView getInstance() {
		if (instance == null) {
			instance = new CiutatView();
		}
		return instance;
	}

	public Ciutat getCiutatAdd() {
		Ciutat ciutat = null;

		Scanner s = new Scanner(System.in);

		System.out.println("Afegeix una ciutat:");
		String nom = s.next();
		System.out.println("Quin prefix telefònic té:");
		int prefixTel = s.nextInt();

		ciutat = new Ciutat();
		ciutat.setIdCiutat(0);
		ciutat.setNomCiutat(nom);
		ciutat.setPrefixTel(prefixTel);

		return ciutat;
	}

	public Ciutat getCiutatUpdate() {
		Ciutat ciutat = null;

		Scanner s = new Scanner(System.in);

		System.out.println("ID actualitzat de la ciutat:");
		int id = s.nextInt();

		System.out.println("Nom actualitzat de la ciutat:");
		String nom = s.next();

		ciutat = new Ciutat();
		ciutat.setIdCiutat(id);
		ciutat.setNomCiutat(nom);

		return ciutat;
	}

	public int getIdCiutatEliminar() {

		return this.getIdCiutat("ID de la ciutat a eliminar:");
	}
	
	public int getIdCiutatSeleccionar() {

		return this.getIdCiutat("ID de la ciutat a seleccionar:");
	}
	
	private int getIdCiutat(String missatge)
	{
		Scanner s = new Scanner(System.in);

		System.out.println(missatge);
		int id = s.nextInt();

		return id;
	}

	public void mostrar(String missatge, boolean error) {
		if (error) {
			System.err.println(missatge);
		} else {
			System.out.println(missatge);
		}
	}
}