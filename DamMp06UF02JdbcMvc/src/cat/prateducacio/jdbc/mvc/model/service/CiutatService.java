package cat.prateducacio.jdbc.mvc.model.service;

import java.util.List;

import cat.prateducacio.jdbc.mvc.model.domain.Ciutat;
import cat.prateducacio.jdbc.mvc.model.repository.CiutatRepository;

public class CiutatService {

	private CiutatService() {
		ciutatRepository = CiutatRepository.getInstance();
	}

	private static CiutatService instance;

	public static CiutatService getInstance() {
		if (instance == null) {
			instance = new CiutatService();
		}
		return instance;
	}

	CiutatRepository ciutatRepository;

	public int insert(Ciutat ciutat) {
		validaContingut(ciutat);
		return ciutatRepository.insert(ciutat);
	}

	public int update(Ciutat ciutat) {
		validaContingut(ciutat);
		validaCiutatExisteix(ciutat.getIdCiutat());

		return ciutatRepository.update(ciutat);
	}

	public int delete(int idCiutat) {
		validaCiutatExisteix(idCiutat);
		return ciutatRepository.delete(idCiutat);
	}

	public Ciutat getUnaCiutat(int idCiutat) {
		return ciutatRepository.getUnaCiutat(idCiutat);
	}

	public List<Ciutat> getAllCiutats() {
		return ciutatRepository.getAllCiutats();
	}

	private void validaContingut(Ciutat ciutat) {
		if (ciutat.getNomCiutat() == null || ciutat.getNomCiutat().length() == 0) {
			throw new RuntimeException("Error.");
		}
	}

	private void validaCiutatExisteix(int idCiutat) {
		Ciutat ciutatRetornat = ciutatRepository.getUnaCiutat(idCiutat);
		if (ciutatRetornat == null) {
			throw new RuntimeException("ID " + idCiutat + " sense existències");
		}
	}
}