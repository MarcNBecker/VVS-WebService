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
import de.dhbw.vvs.utility.JSONify;

/**
 * URI: /kurse/{kursID}
 */
public class KursResource extends JsonServerResource {
	
	private int kursID;
	
	@Override
	protected void doInit() throws ResourceException {
		super.doInit();
		super.allowGet();
		super.allowPut();
		super.allowDelete();
		ConcurrentMap<String, Object> urlAttributes = getRequest().getAttributes();
		try {
			 this.kursID = Integer.parseInt(URLDecoder.decode(urlAttributes.get("kursID").toString(), "UTF-8"));
		} catch (NumberFormatException | NullPointerException e) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT).toResourceException();
		} catch (UnsupportedEncodingException e) {
			throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
		}
	}
	
	@Override
	protected Object receiveGet() throws WebServiceException {
		return new Kurs(getKursID()).getDirectAttributes();
	}
	
	@Override
	protected Object receivePut(JsonRepresentation json) throws JSONException, WebServiceException {
		Kurs kurs = JSONify.deserialize(json.getJsonObject().toString(), Kurs.class);
		kurs.setID(getKursID());
		return kurs.update();
	}
	
	@Override
	protected void receiveDelete() throws WebServiceException {
		new Kurs(getKursID()).delete();
	}
	
	public int getKursID() {
		return this.kursID;
	}
	
}
