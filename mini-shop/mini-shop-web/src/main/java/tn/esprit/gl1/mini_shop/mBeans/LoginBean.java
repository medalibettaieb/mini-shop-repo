package tn.esprit.gl1.mini_shop.mBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginBean {
	private String login;
	private String password;

	public String doLogin() {
		System.out.println("the login is : " + login);
		System.out.println("the pwd is : " + password);
		return "";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
