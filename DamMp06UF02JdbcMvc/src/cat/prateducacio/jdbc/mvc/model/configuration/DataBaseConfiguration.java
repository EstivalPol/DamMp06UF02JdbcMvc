package cat.prateducacio.jdbc.mvc.model.configuration;

import java.io.FileReader;
import java.util.Properties;

public class DataBaseConfiguration {

	private DataBaseConfiguration() {
		carregaProperties();
	}

	private static DataBaseConfiguration instance;

	public static DataBaseConfiguration getInstance() {
		if (instance == null) {
			instance = new DataBaseConfiguration();
		}
		return instance;
	}

	public DataBaseParameters getDataBaseParameters() {
		DataBaseParameters parametres = new DataBaseParameters();

		String dbActiva = properties.getProperty("db_activa");

		if (dbActiva.equals("h2")) {
			parametres.setCadenaConnexio(properties.getProperty("db_h2_cadena_connexio"));
			parametres.setNomUsuari(properties.getProperty("db_h2_username"));
			parametres.setPassword(properties.getProperty("db_h2_password"));
			parametres.setNomDriver(properties.getProperty("db_h2_driverName"));
			parametres.setMissatgeConnexio(properties.getProperty("db_h2_missatge_connexio"));

		} else if (dbActiva.equals("mysql")) {
			parametres.setCadenaConnexio(properties.getProperty("db_mysql_cadena_connexio"));
			parametres.setNomUsuari(properties.getProperty("db_mysql_username"));
			parametres.setPassword(properties.getProperty("db_mysql_password"));
			parametres.setNomDriver(properties.getProperty("db_mysql_driverName"));
			parametres.setMissatgeConnexio(properties.getProperty("db_mysql_missatge_connexio"));
		}
		return parametres;
	}

	private Properties properties;

	private void carregaProperties() {
		properties = new Properties();

		try {
			FileReader fileReader = new FileReader("configurations/database.properties");
			properties.load(fileReader);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}