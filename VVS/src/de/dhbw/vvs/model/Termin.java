package de.dhbw.vvs.model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;

import de.dhbw.vvs.application.ExceptionStatus;
import de.dhbw.vvs.application.WebServiceException;
import de.dhbw.vvs.database.ConnectionPool;
import de.dhbw.vvs.database.DatabaseConnection;
import de.dhbw.vvs.utility.TypeHashMap;
import de.dhbw.vvs.utility.Utility;

/**
 * A class to represent a Termin
 */
public class Termin {
	
	private int id;
	private int vorlesungID;
	private Date datum;
	private Time startUhrzeit;
	private Time endUhrzeit;
	private int pause;
	private String raum;
	private boolean klausur;
	
	@SuppressWarnings("unused")
	private String infoString; //this is only filled if the termin is loaded as a potential conflict to show more information on the timeline
	
	/**
	 * Returns a list of all Termine for a Vorlesung
	 * @param vorlesung the vorlesung
	 * @return a list of all Termine
	 * @throws WebServiceException
	 */
	public static ArrayList<Termin> getAll(Vorlesung vorlesung) throws WebServiceException {
		vorlesung.getDirectAttributes(); //check existance
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(vorlesung.getID());
		ArrayList<TypeHashMap<String, Object>> resultList = db.doSelectingQuery("SELECT id, vorlesung, datum, startUhrzeit, endUhrzeit, pause, raum, klausur FROM termin WHERE vorlesung = ? ORDER BY datum ASC", fieldValues);
		ArrayList<Termin> terminList = new ArrayList<Termin>();
		for(TypeHashMap<String, Object> result : resultList) {
			Termin t = new Termin(result.getInt("id"));
			t.vorlesungID = result.getInt("vorlesung");
			t.datum = (Date) result.get("datum");
			t.startUhrzeit = (Time) result.get("startUhrzeit");
			t.endUhrzeit = (Time) result.get("endUhrzeit");
			t.pause = result.getInt("pause");
			t.raum = result.getString("raum");
			t.klausur = result.getBoolean("klausur");
			terminList.add(t);
		}
		return terminList;
	}
	
	/**
	 * Returns a list of Termine on a given Date for a given Kurs, which are potential conflicts
	 * @param datum the datum
	 * @param kurs the kurs
	 * @param includeFeiertageForConflicts convert Feiertage on that date and add them to the list
	 * @return a list of Termine with potential conflicts
	 * @throws WebServiceException
	 */
	public static ArrayList<Termin> getAllForKursOnDate(Date datum, Kurs kurs, boolean includeFeiertageForConflicts) throws WebServiceException {
		if(datum == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_DATE);
		}
		kurs.getDirectAttributes(); //check existance
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(kurs.getID());
		fieldValues.add(Utility.dateString(datum));
		ArrayList<TypeHashMap<String, Object>> resultList = db.doSelectingQuery("SELECT termin.id, vorlesung, datum, startUhrzeit, endUhrzeit, pause, raum, klausur FROM termin INNER JOIN vorlesung ON termin.vorlesung = vorlesung.id WHERE vorlesung.kurs = ? AND termin.datum = ? ORDER BY startUhrzeit ASC", fieldValues);
		ArrayList<Termin> terminList = new ArrayList<Termin>();
		for(TypeHashMap<String, Object> result : resultList) {
			Termin t = new Termin(result.getInt("id"));
			t.vorlesungID = result.getInt("vorlesung");
			t.datum = (Date) result.get("datum");
			t.startUhrzeit = (Time) result.get("startUhrzeit");
			t.endUhrzeit = (Time) result.get("endUhrzeit");
			t.pause = result.getInt("pause");
			t.raum = result.getString("raum");
			t.klausur = result.getBoolean("klausur");
			t.infoString = new Vorlesung(t.vorlesungID).getInfoString();
			terminList.add(t);
		}
		if(includeFeiertageForConflicts) {
			terminList.addAll(getFeiertageAsTermin(datum));
		}
		return terminList;
	}
	
	/**
	 * Returns a list of Termine on a given Date for a given Dozent, which are potential conflicts
	 * @param datum the datum
	 * @param dozent the dozent
	 * @param includeFeiertageForConflicts convert Feiertage on that date and add them to the list
	 * @return a list of Termine with potential conflicts
	 * @throws WebServiceException
	 */
	public static ArrayList<Termin> getAllForDozentOnDate(Date datum, Dozent dozent, boolean includeFeiertageForConflicts) throws WebServiceException {
		if(datum == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_DATE);
		}
		dozent.getDirectAttributes(); //check existance
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(dozent.getID());
		fieldValues.add(Utility.dateString(datum));
		ArrayList<TypeHashMap<String, Object>> resultList = db.doSelectingQuery("SELECT termin.id, vorlesung, datum, startUhrzeit, endUhrzeit, pause, raum, klausur FROM termin INNER JOIN vorlesung ON termin.vorlesung = vorlesung.id WHERE vorlesung.dozent = ? AND termin.datum = ? ORDER BY startUhrzeit ASC", fieldValues);
		ArrayList<Termin> terminList = new ArrayList<Termin>();
		for(TypeHashMap<String, Object> result : resultList) {
			Termin t = new Termin(result.getInt("id"));
			t.vorlesungID = result.getInt("vorlesung");
			t.datum = (Date) result.get("datum");
			t.startUhrzeit = (Time) result.get("startUhrzeit");
			t.endUhrzeit = (Time) result.get("endUhrzeit");
			t.pause = result.getInt("pause");
			t.raum = result.getString("raum");
			t.klausur = result.getBoolean("klausur");
			t.infoString = new Vorlesung(t.vorlesungID).getInfoString();
			terminList.add(t);
		}
		if(includeFeiertageForConflicts) {
			terminList.addAll(getFeiertageAsTermin(datum));
		}
		return terminList;
	}
	
	/**
	 * Returns a list of Termine on a given Date for a given Raum, which are potential conflicts
	 * @param datum the datum
	 * @param raum the raum
	 * @param includeFeiertageForConflicts convert Feiertage on that date and add them to the list
	 * @return a list of Termine with potential conflicts
	 * @throws WebServiceException
	 */
	public static ArrayList<Termin> getAllForRaumOnDate(Date datum, String raum, boolean includeFeiertageForConflicts) throws WebServiceException {
		if(datum == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_DATE);
		}
		if(raum == null || (raum = raum.trim()).isEmpty()) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_STRING);
		}
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(raum);
		fieldValues.add(Utility.dateString(datum));
		ArrayList<TypeHashMap<String, Object>> resultList = db.doSelectingQuery("SELECT termin.id, vorlesung, datum, startUhrzeit, endUhrzeit, pause, raum, klausur FROM termin WHERE raum = ? AND termin.datum = ? ORDER BY startUhrzeit ASC", fieldValues);
		ArrayList<Termin> terminList = new ArrayList<Termin>();
		for(TypeHashMap<String, Object> result : resultList) {
			Termin t = new Termin(result.getInt("id"));
			t.vorlesungID = result.getInt("vorlesung");
			t.datum = (Date) result.get("datum");
			t.startUhrzeit = (Time) result.get("startUhrzeit");
			t.endUhrzeit = (Time) result.get("endUhrzeit");
			t.pause = result.getInt("pause");
			t.raum = result.getString("raum");
			t.klausur = result.getBoolean("klausur");
			t.infoString = new Vorlesung(t.vorlesungID).getInfoString();
			terminList.add(t);
		}
		if(includeFeiertageForConflicts) {
			terminList.addAll(getFeiertageAsTermin(datum));
		}
		return terminList;
	}
	
	/**
	 * Returns a list of Feiertage converted as a Termin
	 * Time is from 00:00 to 23:59 and the id is -999999
	 * The name of the Feiertag is in infoString
	 * @param datum the datum
	 * @return a list of Feiertage converted as a Termin
	 * @throws WebServiceException
	 */
	public static ArrayList<Termin> getFeiertageAsTermin(Date datum) throws WebServiceException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(datum);
		ArrayList<Feiertag> feiertagList = Feiertag.getAll(calendar.get(Calendar.YEAR));
		ArrayList<Termin> terminList = new ArrayList<Termin>();
		for(Feiertag f : feiertagList) {
			//Skip Feiertag on another day
			if(!Utility.dateString(datum).equals(Utility.dateString(f.getDatum()))) {
				continue;
			}
			Termin t = new Termin();
			t.id = -999999;
			t.datum = f.getDatum();
			t.vorlesungID = 0;
			t.startUhrzeit = Utility.getComparableTime(datum, 0, 0);
			t.endUhrzeit = Utility.getComparableTime(datum, 23, 59);
			t.pause = 0;
			t.raum = null;
			t.klausur = false;
			t.infoString = f.getName();
			terminList.add(t);
		}
		return terminList;
	}
	
	/**
	 * Constructs a Termin
	 * @param id the id
	 * @throws WebServiceException
	 */
	public Termin(int id) throws WebServiceException {
		if (id <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		this.id = id;
	}
	
	/**
	 * Constructs a Termin
	 * {@link #Termin(int)} is preferred
	 */
	private Termin() {
		//lazy and no check
	}
	
	/**
	 * Gets all direct attributes of a Termin
	 * @return the Termin with all attributes set
	 * @throws WebServiceException
	 */
	public Termin getDirectAttributes() throws WebServiceException {
		if (id <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(id);
		ArrayList<TypeHashMap<String, Object>> resultList = db.doSelectingQuery("SELECT vorlesung, datum, startUhrzeit, endUhrzeit, pause, raum, klausur FROM termin WHERE id = ?", fieldValues);
		if(resultList.isEmpty()) {
			throw new WebServiceException(ExceptionStatus.OBJECT_NOT_FOUND);
		}
		TypeHashMap<String, Object> result = resultList.get(0);
		vorlesungID = result.getInt("vorlesung");
		datum = (Date) result.get("datum");
		startUhrzeit = (Time) result.get("startUhrzeit");
		endUhrzeit = (Time) result.get("endUhrzeit");
		pause = result.getInt("pause");
		raum = result.getString("raum");
		klausur = result.getBoolean("klausur");
		return this;
	}
	
	/**
	 * Checks if a Termin has a conflict (Dozent, Raum, Kurs, Feiertag)
	 * @param kurs Kurs with which a conflict may occur
	 * @param dozent Dozent with which a conflict may occur
	 * @return true if the termin has a conflict
	 * @throws WebServiceException
	 */
	public boolean hasConflicts(Kurs kurs, Dozent dozent) throws WebServiceException {
		checkDirectAttributes();
		startUhrzeit = Utility.getComparableTime(datum, startUhrzeit);
		endUhrzeit = Utility.getComparableTime(datum, endUhrzeit);
		ArrayList<Termin> potentialConflicts = Termin.getAllForKursOnDate(datum, kurs, true);
		if(dozent != null) {
			potentialConflicts.addAll(Termin.getAllForDozentOnDate(datum, dozent, false));	
		}
		potentialConflicts.addAll(Termin.getAllForRaumOnDate(datum, raum, false));
		for (Termin potentialConflict : potentialConflicts) {
			if(id == potentialConflict.id) {
				continue;
			}
			Time pcStartUhrzeit = Utility.getComparableTime(datum, potentialConflict.getStartUhrzeit());
			Time pcEndUhrzeit = Utility.getComparableTime(datum, potentialConflict.getEndUhrzeit());
			if(!(startUhrzeit.compareTo(pcEndUhrzeit) >= 0 || endUhrzeit.compareTo(pcStartUhrzeit) <= 0)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Creates a Termin
	 * @return the created Termin
	 * @throws WebServiceException
	 */
	public Termin create() throws WebServiceException {
		if (id != 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		checkDirectAttributes();
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(vorlesungID);
		fieldValues.add(Utility.dateString(datum));
		fieldValues.add(Utility.timeString(startUhrzeit));
		fieldValues.add(Utility.timeString(endUhrzeit));
		fieldValues.add(pause);
		fieldValues.add(raum);
		if (klausur) {
			fieldValues.add("1");
		} else {
			fieldValues.add("0");
		}
		this.id = db.doQuery("INSERT INTO termin (vorlesung, datum, startUhrzeit, endUhrzeit, pause, raum, klausur) VALUES (?, ?, ?, ?, ?, ?, ?)", fieldValues);
		return this;
	}
	
	/**
	 * Updates a Termin
	 * @return the updated Termin
	 * @throws WebServiceException
	 */
	public Termin update() throws WebServiceException {
		if (id <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		checkDirectAttributes();
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(vorlesungID);
		fieldValues.add(Utility.dateString(datum));
		fieldValues.add(Utility.timeString(startUhrzeit));
		fieldValues.add(Utility.timeString(endUhrzeit));
		fieldValues.add(pause);
		fieldValues.add(raum);		
		if (klausur) {
			fieldValues.add("1");
		} else {
			fieldValues.add("0");
		}
		fieldValues.add(id);
		int affectedRows = db.doQuery("UPDATE termin SET vorlesung = ?, datum = ?, startUhrzeit = ?, endUhrzeit = ?, pause = ?, raum = ?, klausur = ? WHERE id = ?", fieldValues);
		if(affectedRows == 0) {
			throw new WebServiceException(ExceptionStatus.OBJECT_NOT_FOUND);
		} else {
			return this;
		}
	}
	
	/**
	 * Deletes a Termin
	 * @throws WebServiceException
	 */
	public void delete() throws WebServiceException {
		if (id <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		}
		DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
		ArrayList<Object> fieldValues = new ArrayList<Object>();
		fieldValues.add(id);
		db.doQuery("DELETE FROM termin WHERE id = ?", fieldValues);
	}
	
	/**
	 * Checks all attributes of a Termin
	 * @throws WebServiceException if an attribute is invalid
	 */
	public void checkDirectAttributes() throws WebServiceException {
		Vorlesung vorlesung;
		if (vorlesungID <= 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_ID);
		} else {
			vorlesung = new Vorlesung(vorlesungID).getDirectAttributes(); //check existance
		}
		if (datum == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_DATE);
		}
		if (startUhrzeit == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_DATE);
		}
		if (endUhrzeit == null) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_DATE);
		}
		if (startUhrzeit.after(endUhrzeit)) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_DATE);
		}
		if (pause < 0) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_NUMBER);
		}
		if (raum == null || (raum = raum.trim()).isEmpty()) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT_STRING);
		}
		//Allow only one klausur = true Termin
		if (klausur && vorlesung.getKeineKlausur()) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT);
		} else if (klausur) {
			DatabaseConnection db = ConnectionPool.getConnectionPool().getConnection();
			ArrayList<Object> fieldValues = new ArrayList<Object>();
			fieldValues.add(vorlesungID);
			ArrayList<TypeHashMap<String, Object>> resultList = db.doSelectingQuery("SELECT id FROM termin WHERE vorlesung = ? AND klausur = 1", fieldValues);
			if(!resultList.isEmpty()) {
				if(resultList.get(0).getInt("id") != id) {
					throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT);	
				}
			}
			
		}
	}
	
	public void setVorlesungID(int vorlesungID) {
		this.vorlesungID = vorlesungID;
	}
	
	public Date getDatum() {
		return datum;
	}
	
	public Time getStartUhrzeit() {
		return startUhrzeit;
	}
	
	public Time getEndUhrzeit() {
		return endUhrzeit;
	}
	
	public String getRaum() {
		return raum;
	}
	
	public int getPause() {
		return pause;
	}
	
	public boolean getKlausur() {
		return klausur;
	}
	
}
