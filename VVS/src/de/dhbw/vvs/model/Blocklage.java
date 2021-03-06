package de.dhbw.vvs.model;

import java.sql.Date;
import java.util.ArrayList;

import de.dhbw.vvs.application.ExceptionStatus;
import de.dhbw.vvs.application.WebServiceException;
import de.dhbw.vvs.database.ConnectionPool;
import de.dhbw.vvs.database.DatabaseConnection;
import de.dhbw.vvs.utility.TypeHashMap;
import de.dhbw.vvs.utility.Utility;

/**
 * Class to represent a Blocklage
 */
public class Blocklage {

	private int kursID;
	private int semester;
	private Date startDatum;
	private Date endDatum;
	private String raum;
	
	/**
	 * Returns a list of Blocklagen for a specific Kurs
	 * @param kurs the kurs
	 * @return the list of Blocklagen
	 * @throws WebServiceException
	 */
	public static ArrayList<Blocklage> getAll(Kurs kurs) throws WebServiceException {
		if (kurs.getID() <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(kurs.getID());
		ArrayList<TypeHashMap<String, Object>> resultList = db.doSelectingQuery("SELECT kurs, semester, startDatum, endDatum, raum FROM blocklage WHERE kurs = ? ORDER BY semester ASC", fieldValues);
		ArrayList<Blocklage> blocklageList = new ArrayList<Blocklage>();
		for(TypeHashMap<String, Object> result : resultList) {
			Blocklage b = new Blocklage();
			b.kursID = result.getInt("kurs");
			b.semester = result.getInt("semester");
			b.startDatum = result.get("startDatum") != null ? (Date) result.get("startDatum") : null;
			b.endDatum = result.get("endDatum") != null ? (Date) result.get("endDatum") : null;
			b.raum = result.getString("raum");
			blocklageList.add(b);
		}
		return blocklageList;
	}
	
	/**
	 * Updates a Blocklage on the database
	 * @return the updated Blocklage
	 * @throws WebServiceException
	 */
	public Blocklage update() throws WebServiceException {
		checkDirectAttributes();
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(kursID);
		fieldValues.add(semester);
		fieldValues.add(Utility.dateString(startDatum));
		fieldValues.add(Utility.dateString(endDatum));
		fieldValues.add(raum);
		fieldValues.add(Utility.dateString(startDatum));
		fieldValues.add(Utility.dateString(endDatum));
		fieldValues.add(raum);
		int affectedRows = db.doQuery("INSERT INTO blocklage (kurs, semester, startDatum, endDatum, raum) VALUES (?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE startDatum = ?, endDatum = ?, raum = ?", fieldValues);
		if(affectedRows == 0) {
			throw new WebServiceException(ExceptionStatus.OBJECT_NOT_FOUND);
		} else {
			return this;	
		}
	}
	
	/**
	 * Checks the attributes of a Blocklage
	 * @throws WebServiceException if an attribute is invalid
	 */
	private void checkDirectAttributes() throws WebServiceException {
		if (kursID <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		} else {
			new Kurs(kursID).getDirectAttributes(); //check existance
		}
		if (semester <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_NUMBER);
		}
		if (startDatum == null && endDatum != null || startDatum != null && endDatum == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_DATE);
		} else if (startDatum != null && endDatum != null && startDatum.after(endDatum)) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_DATE);
		}
		if (raum == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_STRING);
		}
	}
	
	public void setKursID(int kursID) {
		this.kursID = kursID;
	}
	
	public int getSemester() {
		return semester;
	}
	
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	public Date getStartDatum() {
		return startDatum;
	}
	
	public Date getEndDatum() {
		return endDatum;
	}	
	
	public String getRaum() {
		return raum;
	}
	
}
