package com.hiveit.pe.sf.model;

import com.hiveit.pe.eai.productservice.service.ProductServiceImpl;

public class ModelProduct {
	ProductServiceImpl productServiceImpl = new ProductServiceImpl();
	
	public String modelProduct(String codOld, String codNew){
		return productServiceImpl.actualizarCodigo(codOld, codNew);
	}
	
}
