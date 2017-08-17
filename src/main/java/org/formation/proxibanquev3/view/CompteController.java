package org.formation.proxibanquev3.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.formation.proxibanquev3.model.Client;
import org.formation.proxibanquev3.model.Compte;
import org.formation.proxibanquev3.service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@SessionScoped
public class CompteController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3109797512531779989L;

	private List<Compte> listeComptes;
	Client client = new Client();
	private static Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

	@PostConstruct
	public void initService() {
		System.out.println(this.getClass().getName() + "je suis ;;construit !" + service);
	}

	@Inject
	private IClientService service;

	public CompteController() throws Exception {
		listeComptes = new ArrayList<>();

	}

	public void loadComptes() {
		System.out.println("!!!!!!!  voilà les Comptes !!!!!!!!!!!");

		LOGGER.debug("lister comptes");
		LOGGER.info("information");

		listeComptes.clear();

		try {

			// get all students from database
			listeComptes = service.getComptes(client);

		} catch (Exception exc) {
			// send this to server logs
			// LOGGER.error("Error loading students", exc);

			// add error message for JSF page
			addErrorMessage(exc);
		}
	}

	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public String logOut() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		externalContext.invalidateSession();
		return "login";
	}

	//
	// DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	// Calendar dateOuverture = Calendar.getInstance();
	//
	//// Date dateOuverture;
	// switch (typeCompte) {
	//
	// case "compteCourant":
	// CompteCourant cc = new CompteCourant(dateOuverture,solde, decouvert);
	//
	// }

}
