package tn.esprit.gl1.mini_shop.mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.gl1.mini_shop.persistence.Admin;
import tn.esprit.gl1.mini_shop.persistence.Customer;
import tn.esprit.gl1.mini_shop.persistence.User;
import tn.esprit.gl1.mini_shop.services.UserServiceLocal;

@ManagedBean
@SessionScoped
public class LoginBean {
	// Model
	private User user = new User();
	private Boolean loggedInAsAdmin = false;
	private Boolean loggedInAsCustomer = false;
	// injection of the proxy
	@EJB
	private UserServiceLocal userServiceLocal;

	// Methods
	public String doLogin() {
		User userLoggedIn = userServiceLocal.authenticate(user.getLogin(),
				user.getPassword());
		user = userLoggedIn;
		String navigateTo = null;
		if (userLoggedIn instanceof Admin) {
			loggedInAsAdmin = true;
			navigateTo = "pages/adminHome/adminHome";
		} else if (userLoggedIn instanceof Customer) {
			loggedInAsCustomer = true;
			navigateTo = "pages/customerHome/customerHome";
		} else {
			navigateTo = "error";
		}

		return navigateTo;
	}

	public String logOut() {
		user = new User();
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "./login?faces-redirect=true";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedInAsAdmin() {
		return loggedInAsAdmin;
	}

	public void setLoggedInAsAdmin(Boolean loggedInAsAdmin) {
		this.loggedInAsAdmin = loggedInAsAdmin;
	}

	public Boolean getLoggedInAsCustomer() {
		return loggedInAsCustomer;
	}

	public void setLoggedInAsCustomer(Boolean loggedInAsCustomer) {
		this.loggedInAsCustomer = loggedInAsCustomer;
	}

}
