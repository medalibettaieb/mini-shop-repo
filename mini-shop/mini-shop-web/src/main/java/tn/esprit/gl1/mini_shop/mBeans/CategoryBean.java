package tn.esprit.gl1.mini_shop.mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.gl1.mini_shop.persistence.Category;
import tn.esprit.gl1.mini_shop.services.CatalogServiceLocal;

@ManagedBean
@ViewScoped
public class CategoryBean {
	private Category category = new Category();
	private Category categoryChosen = new Category();
	private List<Category> categories = new ArrayList<>();

	@EJB
	private CatalogServiceLocal catalogServiceLocal;

	public String doCreateCategory() {
		catalogServiceLocal.createCategory(category);
		return "";
	}

	public String doDeleteCategory() {
		catalogServiceLocal.removeCategory(categoryChosen);
		return "";
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategories() {
		categories = catalogServiceLocal.findAllCategories();
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category getCategoryChosen() {
		return categoryChosen;
	}

	public void setCategoryChosen(Category categoryChosen) {
		this.categoryChosen = categoryChosen;
	}

}
