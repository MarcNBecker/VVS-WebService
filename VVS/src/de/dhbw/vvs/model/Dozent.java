package de.dhbw.vvs.model;

import java.sql.Timestamp;
import java.util.ArrayList;

import de.dhbw.vvs.application.ExceptionStatus;
import de.dhbw.vvs.application.WebServiceException;
import de.dhbw.vvs.database.ConnectionPool;
import de.dhbw.vvs.database.DatabaseConnection;
import de.dhbw.vvs.utility.TypeHashMap;
import de.dhbw.vvs.utility.Utility;

public class Dozent {

	private int id;
	
	//Direct Attributes
	private String titel;
	private String name;
	private String vorname;
	private Geschlecht geschlecht;
	private String strasse;
	private String wohnort;
	private String postleitzahl;
	private String mail;
	private String telefonPrivat;
	private String telefonMobil;
	private String telefonGeschaeftlich;
	private String fax;
	private String arbeitgeber;
	private Status status;
	@SuppressWarnings("unused")
	private Timestamp angelegt;
	@SuppressWarnings("unused")
	private Timestamp geaendert;
	@SuppressWarnings("unused")
	private int maxFachJahr; //This is only filled at times, when the dozent is loaded in context with a fach information
	
	public static ArrayList<Dozent> getAll() throws WebServiceException {
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<TypeHashMap<String, Object>> resultList = db.doSelectingQuery("SELECT id, titel, name, vorname FROM dozent ORDER BY name ASC", null);
		ArrayList<Dozent> dozentList = new ArrayList<Dozent>();
		for(TypeHashMap<String, Object> result : resultList) {
			Dozent d = new Dozent(result.getInt("id"));
			d.titel = result.getString("titel");
			d.name = result.getString("name");
			d.vorname = result.getString("vorname");
			dozentList.add(d);
		}
		return dozentList;
	}
	
	public static ArrayList<Dozent> getAllForFach(Fach fach) throws WebServiceException {
		if(fach == null || fach.getID() <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(fach.getID());
		ArrayList<TypeHashMap<String, Object>> resultList = db.doSelectingQuery("SELECT id, titel, name, vorname FROM dozent INNER join dozentfach ON dozent.id = dozentfach.dozent WHERE fach = ? ORDER BY name ASC", fieldValues);
		ArrayList<Dozent> dozentList = new ArrayList<Dozent>();
		for(TypeHashMap<String, Object> result : resultList) {
			Dozent d = new Dozent(result.getInt("id"));
			d.titel = result.getString("titel");
			d.name = result.getString("name");
			d.vorname = result.getString("vorname");
			dozentList.add(d);
		}
		return dozentList;
	}
	
	public static ArrayList<Dozent> getAllForVorlesung(Vorlesung vorlesung) throws WebServiceException {
		if(vorlesung == null || vorlesung.getID() <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		vorlesung.getDirectAttributes();
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(vorlesung.getKursID());
		fieldValues.add(vorlesung.getFachInstanz().getFach().getID());
		ArrayList<TypeHashMap<String, Object>> resultList = db.doSelectingQuery("SELECT id, titel, name, vorname FROM dozent WHERE id IN (SELECT dozent FROM vorlesung WHERE kurs IN (SELECT id FROM kurs WHERE studiengangsleiter = (SELECT studiengangsleiter FROM kurs WHERE id = ?)) AND fachInstanz IN (SELECT id FROM fachInstanz WHERE fach = ?)) ORDER BY name ASC", fieldValues);
		ArrayList<Dozent> dozentList = new ArrayList<Dozent>();
		for(TypeHashMap<String, Object> result : resultList) {
			Dozent d = new Dozent(result.getInt("id"));
			d.titel = result.getString("titel");
			d.name = result.getString("name");
			d.vorname = result.getString("vorname");
			dozentList.add(d);
		}
		return dozentList;
	}
	
	public static ArrayList<Dozent> getAllForKursSemester(Kurs kurs, int semester) throws WebServiceException {
		if(kurs == null || kurs.getID() <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		if(semester <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_NUMBER);
		}
		kurs.getDirectAttributes(); //check existance
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(kurs.getID());
		fieldValues.add(semester);
		ArrayList<TypeHashMap<String, Object>> resultList = db.doSelectingQuery("SELECT id, titel, name, vorname FROM dozent WHERE id IN (SELECT dozent FROM vorlesung WHERE kurs = ? AND semester = ?) ORDER BY name ASC", fieldValues);
		ArrayList<Dozent> dozentList = new ArrayList<Dozent>();
		for(TypeHashMap<String, Object> result : resultList) {
			Dozent d = new Dozent(result.getInt("id"));
			d.titel = result.getString("titel");
			d.name = result.getString("name");
			d.vorname = result.getString("vorname");
			dozentList.add(d);
		}
		return dozentList;
	}
	
	public Dozent(int id) throws WebServiceException {
		if (id <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		this.id = id;
	}
	
	public Dozent getDirectAttributes() throws WebServiceException {
		if (id <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(id);
		ArrayList<TypeHashMap<String, Object>> resultList = db.doSelectingQuery("SELECT titel, name, vorname, geschlecht, strasse, wohnort, postleitzahl, mail, telefonPrivat, telefonMobil, telefonGeschaeftlich, fax, arbeitgeber, status, angelegt, geaendert FROM dozent WHERE id = ?", fieldValues);
		if(resultList.isEmpty()) {
			throw new WebServiceException(ExceptionStatus.OBJECT_NOT_FOUND);
		}
		TypeHashMap<String, Object> result = resultList.get(0);
		titel = result.getString("titel");
		name = result.getString("name");
		vorname = result.getString("vorname");
		geschlecht = Geschlecht.getFromOrdinal(result.getInt("geschlecht"));
		strasse = result.getString("strasse");
		wohnort = result.getString("wohnort");
		postleitzahl = result.getString("postleitzahl");
		mail = result.getString("mail");
		telefonPrivat = result.getString("telefonPrivat");
		telefonMobil = result.getString("telefonMobil");
		telefonGeschaeftlich = result.getString("telefonGeschaeftlich");
		fax = result.getString("fax");
		arbeitgeber = result.getString("arbeitgeber");
		status = Status.getFromOrdinal(result.getInt("status"));
		angelegt = (Timestamp) result.get("angelegt");
		geaendert = (Timestamp) result.get("geaendert");
		return this;
	}
	
	public void lastHeld(Fach fach, boolean setOnFach) throws WebServiceException {
		if (id <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		if(fach == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_OBJECT);
		} else {
			fach.getDirectAttributes(); //check existance
		}
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(id);
		fieldValues.add(fach.getID());
		ArrayList<TypeHashMap<String, Object>> resultList = db.doSelectingQuery("SELECT MAX(YEAR(termin.datum)) AS maxJahr FROM termin INNER JOIN vorlesung ON termin.vorlesung = vorlesung.id WHERE vorlesung.dozent = ? AND vorlesung.fachInstanz IN (SELECT id FROM fachInstanz WHERE fach = ?) GROUP BY vorlesung.dozent", fieldValues);
		if(resultList.isEmpty()) {
			if(setOnFach) {
				fach.setMaxJahr(0);
			} else {
				maxFachJahr = 0;	
			}
		} else {
			if(setOnFach) {
				fach.setMaxJahr(resultList.get(0).getInt("maxJahr"));
			} else {
				maxFachJahr = resultList.get(0).getInt("maxJahr");	
			}	
		}	
	}
	
	public ArrayList<Fach> getFachList() throws WebServiceException {
		return Fach.getAllForDozent(this);
	}
	
	public ArrayList<Kommentar> getKommentarList() throws WebServiceException {
		return Kommentar.getAll(this);
	}
	
	public Dozent create() throws WebServiceException {
		if (id != 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		checkDirectAttributes();
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(titel);
		fieldValues.add(name);
		fieldValues.add(vorname);
		fieldValues.add(geschlecht);
		fieldValues.add(strasse);
		fieldValues.add(wohnort);
		fieldValues.add(postleitzahl);
		fieldValues.add(mail);
		fieldValues.add(telefonPrivat);
		fieldValues.add(telefonMobil);
		fieldValues.add(telefonGeschaeftlich);
		fieldValues.add(fax);
		fieldValues.add(arbeitgeber);
		fieldValues.add(status);
		this.id = db.doQuery("INSERT INTO dozent (titel, name, vorname, geschlecht, strasse, wohnort, postleitzahl, mail, telefonPrivat, telefonMobil, telefonGeschaeftlich, fax, arbeitgeber, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", fieldValues);
		return this.getDirectAttributes(); //Get Timestamps
	}
	
	public Dozent update() throws WebServiceException {
		if (id <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		checkDirectAttributes();
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(titel);
		fieldValues.add(name);
		fieldValues.add(vorname);
		fieldValues.add(geschlecht);
		fieldValues.add(strasse);
		fieldValues.add(wohnort);
		fieldValues.add(postleitzahl);
		fieldValues.add(mail);
		fieldValues.add(telefonPrivat);
		fieldValues.add(telefonMobil);
		fieldValues.add(telefonGeschaeftlich);
		fieldValues.add(fax);
		fieldValues.add(arbeitgeber);
		fieldValues.add(status);
		fieldValues.add(id);
		int affectedRows = db.doQuery("UPDATE dozent SET titel = ?, name = ?, vorname = ?, geschlecht = ?, strasse = ?, wohnort = ?, postleitzahl = ?, mail = ?, telefonPrivat = ?, telefonMobil = ?, telefonGeschaeftlich = ?, fax = ?, arbeitgeber = ?, status = ? WHERE id = ?", fieldValues);
		if(affectedRows == 0) {
			throw new WebServiceException(ExceptionStatus.OBJECT_NOT_FOUND);
		} else {
			return this.getDirectAttributes(); //Get Timestamps
		}
	}
	
	public Fach addFach(Fach fach) throws WebServiceException {
		if (id <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		if (fach.getID() <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);	
		}
		fach.getDirectAttributes(); //check existance
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(id);
		fieldValues.add(fach.getID());
		db.doQuery("INSERT INTO dozentfach (dozent, fach) VALUES (?, ?) ON DUPLICATE KEY UPDATE dozent = dozent, fach = fach", fieldValues);
		return fach;
	}
	
	public Kommentar addKommentar(Kommentar kommentar) throws WebServiceException {
		kommentar.setDozentID(id);
		return kommentar.create();
	}
	
	public void delete() throws WebServiceException {
		if (id <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(id);
		db.doQuery("DELETE FROM dozent WHERE id = ?", fieldValues);
	}
	
	public void deleteFach(Fach fach) throws WebServiceException {
		if (id <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		if (fach.getID() <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);	
		}
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(id);
		fieldValues.add(fach.getID());
		db.doQuery("DELETE FROM dozentfach WHERE dozent = ? AND fach = ?", fieldValues);
		if (fach.getInstanzenCount() == 0 && Dozent.getAllForFach(fach).isEmpty()) {
			fach.delete();	
		}
	}
	
	public void deleteKommentar(Kommentar kommentar) throws WebServiceException {
		kommentar.setDozentID(id);
		kommentar.delete();
	}
	
	private void checkDirectAttributes() throws WebServiceException {
		if (titel == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_STRING);
		}
		if (name == null || (name = name.trim()).isEmpty()) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_STRING);
		}
		if (vorname == null || (vorname = vorname.trim()).isEmpty()) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_STRING);
		}
		if (geschlecht == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ENUM);
		}
		if (strasse == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_STRING);
		}
		if (wohnort == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_STRING);
		}
		if (postleitzahl == null || (!(postleitzahl = postleitzahl.trim()).isEmpty() && !Utility.checkNumeric(postleitzahl))) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_NUMBER);
		}
		if (mail == null || (!(mail = mail.trim()).isEmpty() && !Utility.checkEmail(mail))) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_MAIL);
		}
		if (telefonPrivat == null || (!(telefonPrivat = telefonPrivat.trim()).isEmpty() && !Utility.checkPhone(telefonPrivat))) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_PHONE);
		}
		if (telefonMobil == null || (!(telefonMobil = telefonMobil.trim()).isEmpty() && !Utility.checkPhone(telefonMobil))) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_PHONE);
		}
		if (telefonGeschaeftlich == null || (!(telefonGeschaeftlich = telefonGeschaeftlich.trim()).isEmpty() && !Utility.checkPhone(telefonGeschaeftlich))) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_PHONE);
		}
		if (fax == null || (!(fax = fax.trim()).isEmpty() && !Utility.checkPhone(fax))) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_PHONE);
		}
		if (arbeitgeber == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_STRING);
		}
		if (status == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ENUM);
		}
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) throws WebServiceException {
		this.id = id;
	}
}
