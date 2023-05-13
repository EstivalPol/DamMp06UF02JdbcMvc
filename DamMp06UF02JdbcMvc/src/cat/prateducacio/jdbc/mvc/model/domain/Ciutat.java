package cat.prateducacio.jdbc.mvc.model.domain;

public class Ciutat {

	private int IdCiutat;
	private String nomCiutat;
	private int prefixTel;

	public int getIdCiutat() {
		return IdCiutat;
	}

	public void setIdCiutat(int idCiutat) {
		IdCiutat = idCiutat;
	}

	public String getNomCiutat() {
		return nomCiutat;
	}

	public void setNomCiutat(String nomCiutat) {
		this.nomCiutat = nomCiutat;
	}

	public int getPrefixTel() {
		return prefixTel;
	}

	public void setPrefixTel(int prefixTelefonic) {
		this.prefixTel = prefixTelefonic;
	}

	@Override
	public String toString() {
		return "Ciutat [IdCiutat=" + IdCiutat + ", nomCiutat=" + nomCiutat + ", PrefixTelefònic=" + prefixTel + "]";
	}
}