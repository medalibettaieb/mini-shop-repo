package tn.esprit.gl1.mini_shop.mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tn.esprit.gl1.mini_shop.persistence.Product;
import tn.esprit.gl1.mini_shop.services.CatalogServiceLocal;

@ManagedBean
@ViewScoped
public class ProductBean {
	private Product product = new Product();

	@EJB
	private CatalogServiceLocal catalogServiceLocal;

	@ManagedProperty(value = "#{categoryBean}")
	private CategoryBean categoryBean;

	public String doCreateProduct() {
		product.setCategory(categoryBean.getCategoryChosen());
		catalogServiceLocal.createProduct(product);
		return "";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CategoryBean getCategoryBean() {
		return categoryBean;
	}

	public void setCategoryBean(CategoryBean categoryBean) {
		this.categoryBean = categoryBean;
	}

}
