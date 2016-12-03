package com.hiveit.pe.sf.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.hiveit.pe.sf.model.ModelProduct;
import com.hiveit.pe.sf.view.JFProductUpdate;

public class ControllerProduct implements ActionListener {
	JFProductUpdate viewProduct = new JFProductUpdate();
	ModelProduct modelProduct = new ModelProduct();
	
	public ControllerProduct(JFProductUpdate viewProduct, ModelProduct modelProduct){
		this.viewProduct = viewProduct;
		this.modelProduct = modelProduct;
		this.viewProduct.btnUpdate.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		String rptaServicio = null;
		try {

			if(e.getSource() == viewProduct.btnUpdate){
				if(validarcampos()==true){															
					
					rptaServicio = modelProduct.modelProduct(viewProduct.txtReferenceOld.getText(), viewProduct.txtReferenceNew.getText());
					 					
					if(rptaServicio != null){
						JOptionPane.showMessageDialog(null, rptaServicio);
					}
				}
			}					
		} catch (Exception ex) {	
			rptaServicio = "Error Inesperado: " + ex.getMessage();
			JOptionPane.showMessageDialog(null,rptaServicio);
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
    		JOptionPane.showMessageDialog(null, "Error en el aplicativo: " + "Ingresar valor en los campos");
    		viewProduct.txtReferenceOld.requestFocus();
    		flag=false;
    	}
    	return flag;
    }
}
