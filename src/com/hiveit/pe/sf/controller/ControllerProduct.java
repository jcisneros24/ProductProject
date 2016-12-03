package com.hiveit.pe.sf.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.hiveit.pe.eai.productservice.service.ProductServiceImpl;
import com.hiveit.pe.sf.model.ModelProduct;
import com.hiveit.pe.sf.view.JFProductUpdate;

public class ControllerProduct implements ActionListener {
	JFProductUpdate viewProduct = new JFProductUpdate();
	ModelProduct modelProduct = new ModelProduct();
	ProductServiceImpl request = new ProductServiceImpl();
	
	public ControllerProduct(JFProductUpdate viewProduct, ModelProduct modelProduct){
		this.viewProduct = viewProduct;
		this.modelProduct = modelProduct;
		this.viewProduct.btnUpdate.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		String rptaUpdate = null;
		try {

			if(e.getSource() == viewProduct.btnUpdate){
				if(validarcampos()==true){															
										
					rptaUpdate = modelProduct.getModelProduct().actualizarCodigo(viewProduct.txtReferenceOld.getText(), viewProduct.txtReferenceNew.getText());
					 					
					if(rptaUpdate != null){
						JOptionPane.showMessageDialog(null, rptaUpdate);
					}else{
						JOptionPane.showMessageDialog(null, "No se pudo actualizar el producto");
					}	
				}
			}					
		} catch (Exception ex) {		
			JOptionPane.showMessageDialog(null, "Error BD: " + rptaUpdate);
		}
		limpiarCasillas();
	    viewProduct.txtReferenceOld.requestFocus();
	}
    private void limpiarCasillas(){
        viewProduct.txtReferenceOld.setText("");
        viewProduct.txtReferenceNew.setText("");
    }
    private boolean validarcampos(){
    	boolean flag=true;
    	if(viewProduct.txtReferenceOld.getText().equals("") || viewProduct.txtReferenceNew.getText().equals("")){
    		JOptionPane.showMessageDialog(null, "Error en el flujo: " + "Ingresar valor en los campos");
    		viewProduct.txtReferenceOld.requestFocus();
    		flag=false;
    	}
    	return flag;
    }
}
