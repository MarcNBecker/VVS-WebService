package de.dhbw.vvs.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.ConcurrentMap;

import org.json.JSONException;
import org.restlet.data.Status;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.ResourceException;

import de.dhbw.vvs.application.ExceptionStatus;
import de.dhbw.vvs.application.WebServiceException;
import de.dhbw.vvs.model.Kurs;
import de.dhbw.vvs.model.Vorlesung;
import de.dhbw.vvs.model.VorlesungsKachel;
import de.dhbw.vvs.utility.JSONify;

/**
 * URI: /kurse/{kursID}/{semester}/vorlesungen
 */
public class KursSemesterVorlesungenResource extends JsonServerResource {
	
	private int kursID;
	private int semester;
	
	@Override
	protected void doInit() throws ResourceException {
		super.doInit();
		super.allowGet();
		super.allowPost();
		ConcurrentMap<String, Object> urlAttributes = getRequest().getAttributes();
		try {
			 this.kursID = Integer.parseInt(URLDecoder.decode(urlAttributes.get("kursID").toString(), "UTF-8"));
			 this.semester = Integer.parseInt(URLDecoder.decode(urlAttributes.get("semester").toString(), "UTF-8"));
		} catch (NumberFormatException | NullPointerException e) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT).toResourceException();
		} catch (UnsupportedEncodingException e) {
			throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
		}
	}
	
	@Override
	protected Object receiveGet() throws WebServiceException {
		Kurs kurs = new Kurs(getKursID());
		return VorlesungsKachel.enrich(Vorlesung.getAll(kurs, getSemester()));
	}
	
	@Override
	protected Object receivePost(JsonRepresentation json) throws JSONException, WebServiceException {
		Vorlesung vorlesung = JSONify.deserialize(json.getJsonObject().toString(), Vorlesung.class);
		vorlesung.setKursID(getKursID());
		vorlesung.setSemester(getSemester());
		return vorlesung.create();
	}
	
	public int getKursID() {
		return this.kursID;
	}
	
	public int getSemester() {
		return this.semester;
	}
	
}
