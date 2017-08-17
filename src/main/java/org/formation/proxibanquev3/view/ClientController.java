package org.formation.proxibanquev3.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.formation.proxibanquev3.model.Client;
import org.formation.proxibanquev3.service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Named
@SessionScoped

public class ClientController implements Serializable {

	private static final long serialVersionUID = 3774463683041113840L;

	private List<Client> clients;
	private static Logger LOGGER = LoggerFactory.getLogger(ClientController.class);


	@Inject
	private IClientService service;

	public ClientController() throws Exception {
		clients = new ArrayList<>();

	}

	@PostConstruct
	public void initService() {
		System.out.println(this.getClass().getName() + "je suis ;;construit !" + service);
	}

	public List<Client> getClients() {
		return clients;
	}

	public void loadClients() {
		System.out.println("!!!!!! V'la les clients !!!!!!!!!");

		LOGGER.debug("lister clients");
		LOGGER.info("information");

		clients.clear();

		try {

			// get all students from database
			clients = service.getClients();

		} catch (Exception exc) {
			// send this to server logs
			// LOGGER.error("Error loading students", exc);

			// add error message for JSF page
			addErrorMessage(exc);
		}
	}

	public String addClient(Client client) {

		// LOGGER.info("Adding student: " + theStudent);

		try {

			// add student to the database
			service.addClient(client);

		} catch (Exception exc) {
			// send this to server logs
			// LOGGER.error("Error adding students", exc);

			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}

		return "list-clients?faces-redirect=true";
	}

	public String loadClient(Long idClient) {

		// LOGGER.info("loading student: " + studentId);

		try {
			// get student from database
			Client client = service.getClient(idClient);

			// put in the request attribute ... so we can use it on the form
			// page
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("client", client);

		} catch (Exception exc) {
			// send this to server logs
			// LOGGER.error("Error loading student id:" + studentId, exc);

			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}

		return "update-client-form.xhtml";
	}

	public String updateClient(Client client) {

		// logger.info("updating student: " + theStudent);

		try {

			// update student in the database
			service.updateClient(client);

		} catch (Exception exc) {
			// send this to server logs
			// logger.log(Level.SEVERE, "Error updating student: " + theStudent, exc);

			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}

		return "list-clients?faces-redirect=true";
	}

	public String deleteClient(Long idClient) {

		// logger.info("Deleting student id: " + studentId);

		try {

			// delete the student from the database
			service.deleteClient(idClient);

		} catch (Exception exc) {
			// send this to server logs
			// logger.log(Level.SEVERE, "Error deleting student id: " + studentId, exc);

			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}

		return "list-clients";
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

}
