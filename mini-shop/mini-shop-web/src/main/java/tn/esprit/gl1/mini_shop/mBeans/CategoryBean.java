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
	private String findWord;
	private Boolean displyTable = false;

	@EJB
	private CatalogServiceLocal catalogServiceLocal;

	public String doCreateCategory() {
		catalogServiceLocal.saveCategory(categoryChosen);
		displyTable = false;
		return "";
	}

	public String doDeleteCategory() {
		catalogServiceLocal.removeCategory(categoryChosen);
		categoryChosen = new Category();
		displyTable = false;
		return "";
	}

	public String doFindCategoryByName() {
		System.out.println(catalogServiceLocal.findCategoryByName(findWord)
				.getId());
		return "";
	}

	public void doSomething() {
		System.out.println(categoryChosen.getName());
	}

	public void doSelect() {
		displyTable = true;
	}

	public void doDisplayTable() {
		displyTable = true;
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

	public String getFindWord() {
		return findWord;
	}

	public void setFindWord(String findWord) {
		this.findWord = findWord;
	}

	public Boolean getDisplyTable() {
		return displyTable;
	}

	public void setDisplyTable(Boolean displyTable) {
		this.displyTable = displyTable;
	}

	public Category doFindCategoryByNameBis(String string) {
		return catalogServiceLocal.findCategoryByName(string);
	}

}
