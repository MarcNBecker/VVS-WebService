package de.dhbw.vvs.application;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import de.dhbw.vvs.resources.DozentFachResource;
import de.dhbw.vvs.resources.DozentFaecherResource;
import de.dhbw.vvs.resources.DozentKommentarResource;
import de.dhbw.vvs.resources.DozentKommentareResource;
import de.dhbw.vvs.resources.DozentResource;
import de.dhbw.vvs.resources.DozentenFachResource;
import de.dhbw.vvs.resources.DozentenResource;
import de.dhbw.vvs.resources.FaecherResource;
import de.dhbw.vvs.resources.FeiertagResource;
import de.dhbw.vvs.resources.FeiertageResource;
import de.dhbw.vvs.resources.GroupEResource;
import de.dhbw.vvs.resources.KursBlocklagenResource;
import de.dhbw.vvs.resources.KursBlocklagenSemesterDozentenResource;
import de.dhbw.vvs.resources.KursBlocklagenSemesterResource;
import de.dhbw.vvs.resources.KursResource;
import de.dhbw.vvs.resources.KursSemesterVorlesungDozentenResource;
import de.dhbw.vvs.resources.KursSemesterVorlesungResource;
import de.dhbw.vvs.resources.KursSemesterVorlesungTerminResource;
import de.dhbw.vvs.resources.KursSemesterVorlesungTermineResource;
import de.dhbw.vvs.resources.KursSemesterVorlesungenResource;
import de.dhbw.vvs.resources.KursVorlesungenOffenResource;
import de.dhbw.vvs.resources.KursVorlesungenResource;
import de.dhbw.vvs.resources.KursSemesterVorlesungenSondertermineResource;
import de.dhbw.vvs.resources.KurseResource;
import de.dhbw.vvs.resources.ModuleResource;
import de.dhbw.vvs.resources.ModulplaeneResource;
import de.dhbw.vvs.resources.ModulplanFachResource;
import de.dhbw.vvs.resources.ModulplanFaecherResource;
import de.dhbw.vvs.resources.ModulplanModulResource;
import de.dhbw.vvs.resources.ModulplanModuleResource;
import de.dhbw.vvs.resources.ModulplanQuickDeleteFachInstanzResource;
import de.dhbw.vvs.resources.ModulplanResource;
import de.dhbw.vvs.resources.StudiengangsleiterDashboardResource;
import de.dhbw.vvs.resources.StudiengangsleiterKollektionResource;
import de.dhbw.vvs.resources.StudiengangsleiterResource;
import de.dhbw.vvs.resources.TermineDozentResource;
import de.dhbw.vvs.resources.TermineKursResource;
import de.dhbw.vvs.resources.TermineRaumResource;
import de.dhbw.vvs.resources.UserKollektionResource;
import de.dhbw.vvs.resources.UserResource;
import de.dhbw.vvs.resources.XMLExportResource;

/**
 * Main web service application
 */
public class VVSApplication extends Application {
	
	public static final String VERSION_ONE = "/v1";
	
	/**
	 * This method routes the different URIs to their corresponding ServerResources
	 */
	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		
		//MAIN DATA
		//Dozenten
		router.attach(VERSION_ONE + "/dozenten", DozentenResource.class); //GET, POST
		router.attach(VERSION_ONE + "/dozenten/{dozentID}", DozentResource.class); //GET, PUT, DELETE
		router.attach(VERSION_ONE + "/dozenten/{dozentID}/faecher", DozentFaecherResource.class); //GET
		router.attach(VERSION_ONE + "/dozenten/{dozentID}/faecher/{fachID}", DozentFachResource.class); //PUT, DELETE
		router.attach(VERSION_ONE + "/dozenten/faecher/{fachID}", DozentenFachResource.class); //GET
		router.attach(VERSION_ONE + "/dozenten/{dozentID}/kommentare", DozentKommentareResource.class); //GET, POST
		router.attach(VERSION_ONE + "/dozenten/{dozentID}/kommentare/{kommentarID}", DozentKommentarResource.class); //DELETE

		//Kurse
		router.attach(VERSION_ONE + "/kurse", KurseResource.class); //GET, POST
		router.attach(VERSION_ONE + "/kurse/{kursID}", KursResource.class); //GET, PUT, DELETE
		router.attach(VERSION_ONE + "/kurse/{kursID}/blocklagen", KursBlocklagenResource.class); //GET
		router.attach(VERSION_ONE + "/kurse/{kursID}/blocklagen/{semester}", KursBlocklagenSemesterResource.class); //PUT
		router.attach(VERSION_ONE + "/kurse/{kursID}/blocklagen/{semester}/dozenten", KursBlocklagenSemesterDozentenResource.class); //GET
		
		//Studiengangsleiter
		router.attach(VERSION_ONE + "/studiengangsleiter", StudiengangsleiterKollektionResource.class); //GET, POST
		router.attach(VERSION_ONE + "/studiengangsleiter/{studiengangsleiterID}", StudiengangsleiterResource.class); //GET, PUT, DELETE
		
		router.attach(VERSION_ONE + "/user", UserKollektionResource.class); //GET, POST
		router.attach(VERSION_ONE + "/user/{name}", UserResource.class); //GET, POST, PUT, DELETE
		
		//Feiertage
		router.attach(VERSION_ONE + "/feiertage/{jahr}", FeiertageResource.class); //GET
		router.attach(VERSION_ONE + "/feiertage/{jahr}/{datum}", FeiertagResource.class); //PUT, DELETE
		
		//Modulplan
		router.attach(VERSION_ONE + "/faecher", FaecherResource.class); //GET
		router.attach(VERSION_ONE + "/module", ModuleResource.class); //GET
		router.attach(VERSION_ONE + "/modulplaene", ModulplaeneResource.class); //GET, POST
		router.attach(VERSION_ONE + "/modulplaene/{modulplanID}", ModulplanResource.class); //GET, PUT, DELETE
		router.attach(VERSION_ONE + "/modulplaene/{modulplanID}/module", ModulplanModuleResource.class); //GET, POST
		router.attach(VERSION_ONE + "/modulplaene/{modulplanID}/module/{modulID}", ModulplanModulResource.class); //PUT, DELETE
		router.attach(VERSION_ONE + "/modulplaene/{modulplanID}/module/{modulID}/faecher", ModulplanFaecherResource.class); //GET, POST
		router.attach(VERSION_ONE + "/modulplaene/{modulplanID}/module/{modulID}/faecher/{fachID}", ModulplanFachResource.class); //PUT, DELETE
		router.attach(VERSION_ONE + "/modulplaene/quickdelete/faecher/{fachInstanzID}", ModulplanQuickDeleteFachInstanzResource.class); //DELETE
		
		//PLANNING FUNCTIONALITY
		//Dashboard
		router.attach(VERSION_ONE + "/studiengangsleiter/{studiengangsleiterID}/dashboard", StudiengangsleiterDashboardResource.class); //GET
		
		//Kurs <-> Moduplan = Vorlesungen
		router.attach(VERSION_ONE + "/kurse/{kursID}/vorlesungen", KursVorlesungenResource.class); //GET
		router.attach(VERSION_ONE + "/kurse/{kursID}/vorlesungen/offen", KursVorlesungenOffenResource.class); //GET
		
		//Semester
		router.attach(VERSION_ONE + "/kurse/{kursID}/{semester}/vorlesungen", KursSemesterVorlesungenResource.class); //GET, POST
		router.attach(VERSION_ONE + "/kurse/{kursID}/{semester}/vorlesungen/sondertermine", KursSemesterVorlesungenSondertermineResource.class); //GET
		router.attach(VERSION_ONE + "/kurse/{kursID}/{semester}/vorlesungen/groupe", GroupEResource.class); //GET
		router.attach(VERSION_ONE + "/kurse/{kursID}/{semester}/vorlesungen/xml", XMLExportResource.class); //GET
		router.attach(VERSION_ONE + "/kurse/{kursID}/{semester}/vorlesungen/{vorlesungsID}", KursSemesterVorlesungResource.class); //GET, PUT, DELETE
		router.attach(VERSION_ONE + "/kurse/{kursID}/{semester}/vorlesungen/{vorlesungsID}/dozenten", KursSemesterVorlesungDozentenResource.class); //GET
		router.attach(VERSION_ONE + "/kurse/{kursID}/{semester}/vorlesungen/{vorlesungsID}/termine", KursSemesterVorlesungTermineResource.class); //GET, POST
		router.attach(VERSION_ONE + "/kurse/{kursID}/{semester}/vorlesungen/{vorlesungsID}/termine/{terminID}", KursSemesterVorlesungTerminResource.class); //GET, PUT, DELETE
		
		//Konflikte
		router.attach(VERSION_ONE + "/termine/{datum}/kurse/{kursID}", TermineKursResource.class); //GET
		router.attach(VERSION_ONE + "/termine/{datum}/dozenten/{dozentID}", TermineDozentResource.class); //GET
		router.attach(VERSION_ONE + "/termine/{datum}/raeume/{raum}", TermineRaumResource.class); //GET
		
		return router;
	}
}
