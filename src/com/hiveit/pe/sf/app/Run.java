package com.hiveit.pe.sf.app;

import com.hiveit.pe.sf.controller.ControllerProduct;
import com.hiveit.pe.sf.model.ModelProduct;
import com.hiveit.pe.sf.view.JFProductUpdate;

public class Run {

	public static void main(String[] args) {
		JFProductUpdate viewProduct = new JFProductUpdate();
		ModelProduct modelProduct = new ModelProduct();
		ControllerProduct controllerProduct = new ControllerProduct(viewProduct, modelProduct);
		viewProduct.setVisible(true);
		viewProduct.setLocationRelativeTo(null);

	}

}
