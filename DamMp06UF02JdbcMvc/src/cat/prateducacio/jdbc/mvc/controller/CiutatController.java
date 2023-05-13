package cat.prateducacio.jdbc.mvc.controller;

import java.util.List;

import cat.prateducacio.jdbc.mvc.model.domain.Ciutat;
import cat.prateducacio.jdbc.mvc.model.service.CiutatService;
import cat.prateducacio.jdbc.mvc.view.console.CiutatView;

public class CiutatController {

	private CiutatController() {}

	private static CiutatController instance;

	public static CiutatController getInstance() {
		if (instance == null) {
			instance = new CiutatController();
		}
		return instance;
	}

	public void addCiutat() {
		try {
			Ciutat ciutat = CiutatView.getInstance().getCiutatAdd();
			int filesAfectades = CiutatService.getInstance().insert(ciutat);
			CiutatView.getInstance().mostrar(" Files afectades " + filesAfectades, false);
		} catch (Exception e) {
			CiutatView.getInstance().mostrar(e.getMessage(), true);
		}
	}

	public void updateCiutat() {
		try {
			Ciutat ciutat = CiutatView.getInstance().getCiutatUpdate();
			int filesAfectades = CiutatService.getInstance().update(ciutat);
			CiutatView.getInstance().mostrar(" Files afectades " + filesAfectades, false);
		} catch (Exception e) {
			CiutatView.getInstance().mostrar(e.getMessage(), true);
		}
	}

	public void deleteCiutat() {
		try {
			int id = CiutatView.getInstance().getIdCiutatEliminar();
			int filesAfectades = CiutatService.getInstance().delete(id);
			CiutatView.getInstance().mostrar(" Files afectades " + filesAfectades, false);
		} catch (Exception e) {
			CiutatView.getInstance().mostrar(e.getMessage(), true);
		}
	}

	public void getOneCiutat() {
		try {
			int id = CiutatView.getInstance().getIdCiutatSeleccionar();
			Ciutat ciutat = CiutatService.getInstance().getUnaCiutat(id);
			if (ciutat != null) {
				CiutatView.getInstance().mostrar(ciutat.toString(), false);
			} else {
				CiutatView.getInstance().mostrar("La ciutat que has sol·licitat no té cap existència", false);
			}
		} catch (Exception e) {
			CiutatView.getInstance().mostrar(e.getMessage(), true);
		}
	}

	public void getTotesLesCiutats() {
		try {
			List<Ciutat> ciutats = CiutatService.getInstance().getAllCiutats();
			if (ciutats != null) {
				CiutatView.getInstance().mostrar(ciutats.toString(), false);
			} else {
				CiutatView.getInstance().mostrar("No obtenim cap existència dintre de la base de dades sobre ninguna ciutat", false);
			}
		} catch (Exception e) {
			CiutatView.getInstance().mostrar(e.getMessage(), true);
		}
	}
}