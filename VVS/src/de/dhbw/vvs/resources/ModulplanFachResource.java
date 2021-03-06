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
import de.dhbw.vvs.model.FachInstanz;
import de.dhbw.vvs.model.ModulInstanz;
import de.dhbw.vvs.utility.JSONify;

/**
 * URI: /modulplaene/{modulplanID}/module/{modulID}/faecher/{fachID}
 */
public class ModulplanFachResource extends JsonServerResource {
	
	private int modulplanID;
	private int modulID;
	private int fachID;
	
	@Override
	protected void doInit() throws ResourceException {
		super.doInit();
		super.allowPut();
		super.allowDelete();
		ConcurrentMap<String, Object> urlAttributes = getRequest().getAttributes();
		try {
			 this.modulplanID = Integer.parseInt(URLDecoder.decode(urlAttributes.get("modulplanID").toString(), "UTF-8"));
			 this.modulID = Integer.parseInt(URLDecoder.decode(urlAttributes.get("modulID").toString(), "UTF-8"));
			 this.fachID = Integer.parseInt(URLDecoder.decode(urlAttributes.get("fachID").toString(), "UTF-8"));
		} catch (NumberFormatException | NullPointerException e) {
			throw new WebServiceException(ExceptionStatus.INVALID_ARGUMENT).toResourceException();
		} catch (UnsupportedEncodingException e) {
			throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
		}
	}

	@Override
	protected Object receivePut(JsonRepresentation json) throws JSONException, WebServiceException {
		FachInstanz fachInstanz = JSONify.deserialize(json.getJsonObject().toString(), FachInstanz.class);
		fachInstanz.setModulInstanzID(ModulInstanz.getSingle(getModulplanID(), getModulID()).getID());
		fachInstanz.getFach().setID(getFachID());
		return fachInstanz.create();
	}
	
	@Override
	protected void receiveDelete() throws WebServiceException {
		FachInstanz.getSingle(ModulInstanz.getSingle(getModulplanID(), getModulID()), getFachID()).delete();
	}
	
	public int getModulplanID() {
		return this.modulplanID;
	}
	
	public int getModulID() {
		return this.modulID;
	}
	
	public int getFachID() {
		return this.fachID;
	}
	
}
