/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import view.panelControl;
import models.RolModel;
import access.RolDAO;
import view.AddUser;

public class Click implements ActionListener{
    

    private panelControl controlsPanel;
    
    /**
     * Constructor of the class
     * @param controlsPanel 
     */
    public Click(panelControl controlsPanel){
        this.controlsPanel = controlsPanel;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.controlsPanel.getBtnSearch()) {
            int idRol        = ((RolModel)this.controlsPanel.getCbxRolsList().getSelectedItem()).getId();
            String userName  = (String)this.controlsPanel.getTxtName().getText();
            
            RolDAO userDAO  = new RolDAO();
            ArrayList<RolModel> user  = userDAO.agregarRol(idRol, userName);
            this.controlsPanel.setTblResults(user);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getBtnAddUser()) {
            AddUser addUserView = new AddUser ();
            addUserView.setVisible(true);
    }   }
}