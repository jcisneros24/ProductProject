package com.hiveit.pe.sf.model;

import com.hiveit.pe.eai.productservice.service.ProductServiceImpl;

public class ModelProduct {
	ProductServiceImpl modelProduct = new ProductServiceImpl();

	public ProductServiceImpl getModelProduct() {
		return modelProduct;
	}

	public void setModelProduct(ProductServiceImpl modelProduct) {
		this.modelProduct = modelProduct;
	}
	
}
