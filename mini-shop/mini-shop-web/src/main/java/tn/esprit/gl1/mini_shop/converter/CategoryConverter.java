package tn.esprit.gl1.mini_shop.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import tn.esprit.gl1.mini_shop.mBeans.CategoryBean;
import tn.esprit.gl1.mini_shop.persistence.Category;

@FacesConverter("cc")
public class CategoryConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String string) {
		if (string == null) {
			return null;
		}
		CategoryBean categoryBean = context.getApplication()
				.evaluateExpressionGet(context, "#{categoryBean}",
						CategoryBean.class);
		Category category = categoryBean.doFindCategoryByNameBis(string);
		return category;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		String string = null;
		if (object instanceof Category) {
			string = ((Category) object).getName();
		}
		return string;
	}

}
