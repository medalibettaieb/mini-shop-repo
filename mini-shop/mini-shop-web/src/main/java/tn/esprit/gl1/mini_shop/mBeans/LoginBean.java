package tn.esprit.gl1.mini_shop.mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.gl1.mini_shop.persistence.Admin;
import tn.esprit.gl1.mini_shop.persistence.Customer;
import tn.esprit.gl1.mini_shop.persistence.User;
import tn.esprit.gl1.mini_shop.services.UserServiceLocal;

@ManagedBean
@SessionScoped
public class LoginBean {
	// Model
	private User user = new User();
	// injection of the proxy
	@EJB
	private UserServiceLocal userServiceLocal;

	// Methods
	public String doLogin() {
		User userLoggedIn = userServiceLocal.authenticate(user.getLogin(),
				user.getPassword());
		if (userLoggedIn instanceof Admin) {
			System.out.println("welcom Admin");
		} else if (userLoggedIn instanceof Customer) {
			System.out.println("welcom customer");
		} else {
			System.out.println("rawa7 ldarkom ...");
		}

		return "";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
