package tn.esprit.gl1.mini_shop.mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import tn.esprit.gl1.mini_shop.persistence.Category;
import tn.esprit.gl1.mini_shop.services.CatalogServiceLocal;

@ManagedBean
@ViewScoped
public class CategoryBean {
	private Category category = new Category();
	private List<Category> categories = new ArrayList<>();
	private DataModel<Category> datamodel = new ListDataModel<>();

	@EJB
	private CatalogServiceLocal catalogServiceLocal;

	public String doCreateCategory() {
		catalogServiceLocal.createCategory(category);
		return "";
	}
	public String doDeleteCategory(){
		Category categoryChosen=datamodel.getRowData();
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

	public DataModel<Category> getDatamodel() {
		datamodel.setWrappedData(catalogServiceLocal.findAllCategories());
		return datamodel;
	}

	public void setDatamodel(DataModel<Category> datamodel) {
		this.datamodel = datamodel;
	}

}
