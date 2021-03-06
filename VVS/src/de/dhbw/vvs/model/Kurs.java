package de.dhbw.vvs.model;

import java.util.ArrayList;

import de.dhbw.vvs.application.ExceptionStatus;
import de.dhbw.vvs.application.WebServiceException;
import de.dhbw.vvs.database.ConnectionPool;
import de.dhbw.vvs.database.DatabaseConnection;
import de.dhbw.vvs.utility.TypeHashMap;
import de.dhbw.vvs.utility.Utility;

/**
 * A class to represent a Kurs
 */
public class Kurs {

	private int id;
	private String kursname;
	private String kursmail;
	private int modulplanID;
	private int studentenAnzahl;
	private String kurssprecherVorname;
	private String kurssprecherName;
	private String kurssprecherMail;
	private String kurssprecherTelefon;
	private int studiengangsleiterID;
	private String sekretariatName;
	
	/**
	 * Returns a list of all Kurse
	 * @return a list of all Kurse
	 * @throws WebServiceException
	 */
	public static ArrayList<Kurs> getAll() throws WebServiceException {
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<TypeHashMap<String, Object>> resultList = db.doSelectingQuery("SELECT id, kursname, kursMail, modulplan, studentenAnzahl, kurssprecherVorname, kurssprecherName, kurssprecherMail, kurssprecherTelefon, studiengangsleiter, sekretariatName FROM kurs ORDER BY kursname DESC", null);
		ArrayList<Kurs> kursList = new ArrayList<Kurs>();
		for(TypeHashMap<String, Object> result : resultList) {
			Kurs k = new Kurs(result.getInt("id"));
			k.kursname = result.getString("kursname");
			k.kursmail = result.getString("kursMail");
			k.modulplanID = result.getInt("modulplan");
			k.studentenAnzahl = result.getInt("studentenAnzahl");
			k.kurssprecherVorname = result.getString("kurssprecherVorname");
			k.kurssprecherName = result.getString("kurssprecherName");
			k.kurssprecherMail = result.getString("kurssprecherMail");
			k.kurssprecherTelefon = result.getString("kurssprecherTelefon");
			k.studiengangsleiterID = result.getInt("studiengangsleiter");
			k.sekretariatName = result.getString("sekretariatName");
			kursList.add(k);
		}
		return kursList;
	}
	
	/**
	 * Returns a list of all Kurse that are organized by a Studiengangsleiter
	 * @param s the studiengangsleiter
	 * @return a list of Kurse
	 * @throws WebServiceException
	 */
	public static ArrayList<Kurs> getAllForStudiengangsleiter(Studiengangsleiter s) throws WebServiceException {
		if(s == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_OBJECT);
		}
		s.getDirectAttributes(); //check existances
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(s.getID());
		ArrayList<TypeHashMap<String, Object>> resultList = db.doSelectingQuery("SELECT id, kursname FROM kurs WHERE studiengangsleiter = ? ORDER BY kursname DESC", fieldValues);
		ArrayList<Kurs> kursList = new ArrayList<Kurs>();
		for(TypeHashMap<String, Object> result : resultList) {
			Kurs k = new Kurs(result.getInt("id"));
			k.kursname = result.getString("kursname");
			kursList.add(k);
		}
		return kursList;
	}
	
	/**
	 * Constructs a Kurs
	 * @param id the id
	 * @throws WebServiceException
	 */
	public Kurs(int id) throws WebServiceException {
		if(id <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		this.id = id;
	}
	
	/**
	 * Gets all attributes of a Kurs
	 * @return the Kurs with all attributes set
	 * @throws WebServiceException
	 */
	public Kurs getDirectAttributes() throws WebServiceException {
		if (id <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(id);
		ArrayList<TypeHashMap<String, Object>> resultList = db.doSelectingQuery("SELECT kursname, kursMail, modulplan, studentenAnzahl, kurssprecherVorname, kurssprecherName, kurssprecherMail, kurssprecherTelefon, studiengangsleiter, sekretariatName FROM kurs WHERE id = ?", fieldValues);
		if(resultList.isEmpty()) {
			throw new WebServiceException(ExceptionStatus.OBJECT_NOT_FOUND);
		}
		TypeHashMap<String, Object> result = resultList.get(0);
		kursname = result.getString("kursname");
		kursmail = result.getString("kursMail");
		modulplanID = result.getInt("modulplan");
		studentenAnzahl = result.getInt("studentenAnzahl");
		kurssprecherVorname = result.getString("kurssprecherVorname");
		kurssprecherName = result.getString("kurssprecherName");
		kurssprecherMail = result.getString("kurssprecherMail");
		kurssprecherTelefon = result.getString("kurssprecherTelefon");
		studiengangsleiterID = result.getInt("studiengangsleiter");
		sekretariatName = result.getString("sekretariatName");
		return this;
	}
	
	public ArrayList<Blocklage> getBlocklageList() throws WebServiceException {
		return Blocklage.getAll(this);
	}
	
	public Kurs create() throws WebServiceException {
		if (id != 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		checkDirectAttributes();
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(kursname);
		fieldValues.add(kursmail);
		fieldValues.add(modulplanID);
		fieldValues.add(studentenAnzahl);
		fieldValues.add(kurssprecherVorname);
		fieldValues.add(kurssprecherName);
		fieldValues.add(kurssprecherMail);
		fieldValues.add(kurssprecherTelefon);
		fieldValues.add(studiengangsleiterID);
		fieldValues.add(sekretariatName);
		this.id = db.doQuery("INSERT INTO kurs (kursname, kursMail, modulplan, studentenAnzahl, kurssprecherVorname, kurssprecherName, kurssprecherMail, kurssprecherTelefon, studiengangsleiter, sekretariatName) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", fieldValues);
		return this;
	}
	
	/**
	 * Updates a Kurs
	 * @return the updated Kurs
	 * @throws WebServiceException
	 */
	public Kurs update() throws WebServiceException {
		if (id <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		checkDirectAttributes();
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(kursname);
		fieldValues.add(kursmail);
		fieldValues.add(modulplanID);
		fieldValues.add(studentenAnzahl);
		fieldValues.add(kurssprecherVorname);
		fieldValues.add(kurssprecherName);
		fieldValues.add(kurssprecherMail);
		fieldValues.add(kurssprecherTelefon);
		fieldValues.add(studiengangsleiterID);
		fieldValues.add(sekretariatName);
		fieldValues.add(id);
		int affectedRows = db.doQuery("UPDATE kurs SET kursname = ?, kursMail = ?, modulplan = ?, studentenAnzahl = ?, kurssprecherVorname = ?, kurssprecherName = ?, kurssprecherMail = ?, kurssprecherTelefon = ?, studiengangsleiter = ?, sekretariatName = ? WHERE id = ?", fieldValues);
		if(affectedRows == 0) {
			throw new WebServiceException(ExceptionStatus.OBJECT_NOT_FOUND);
		} else {
			return this;	
		}
	}
	
	/**
	 * Updates a Blocklage
	 * @param blocklage the blocklage
	 * @return the updated blocklage
	 * @throws WebServiceException
	 */
	public Blocklage updateBlocklage(Blocklage blocklage) throws WebServiceException {
		blocklage.setKursID(id);
		return blocklage.update();
	}
	
	/**
	 * Deletes a Kurs
	 * @throws WebServiceException
	 */
	public void delete() throws WebServiceException {
		if (id <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(id);
		db.doQuery("DELETE FROM kurs WHERE id = ?", fieldValues);
	}
	
	/**
	 * Checks all attributes of a Kurs
	 * @throws WebServiceException if an attribute is invalid
	 */
	private void checkDirectAttributes() throws WebServiceException {
		if (kursname == null || (kursname = kursname.trim()).isEmpty()) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_STRING);
		}
		if (kursmail == null || (!(kursmail = kursmail.trim()).isEmpty() && !Utility.checkEmail(kursmail))) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_MAIL);
		}
		if (modulplanID <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		} else {
			new Modulplan(modulplanID).getDirectAttributes(); //check existance
		}
		if (studentenAnzahl < 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_NUMBER);
		}
		if (kurssprecherName == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_STRING);
		}
		if (kurssprecherVorname == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_STRING);
		}
		if (kurssprecherMail == null || (!(kurssprecherMail = kurssprecherMail.trim()).isEmpty() && !Utility.checkEmail(kurssprecherMail))) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_MAIL);
		}
		if (kurssprecherTelefon == null || (!(kurssprecherTelefon = kurssprecherTelefon.trim()).isEmpty() && !Utility.checkPhone(kurssprecherTelefon))) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_PHONE);
		}
		if (studiengangsleiterID <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		} else {
			new Studiengangsleiter(studiengangsleiterID).getDirectAttributes(); //check existance
		}
		if (sekretariatName == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_STRING);
		}
	}
	
	public int getID() {
		return id;
	}
	
	public String getKursname() {
		return kursname;
	}
	
	public int getModulplanID() {
		return modulplanID;
	}
	
	public int getStudiengangsleiterID() {
		return studiengangsleiterID;
	}
	
	public int getStudentenAnzahl() {
		return studentenAnzahl;
	}
	
	public String getSekretariatName() {
		return sekretariatName;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
}
