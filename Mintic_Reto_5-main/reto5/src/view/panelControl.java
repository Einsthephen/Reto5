package view;

import controllers.RolController;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import models.RolModel;

public class panelControl extends JPanel {

    private JLabel lblRol;
    private JComboBox<RolModel> cbxRolsList;
    private JLabel lblName;
    private JTextField txtName;
    private JButton btnSearch;
    private JButton btnAddUser;
    private JTable tblResults;

    /**
     * Constructor of the ControlsPanel class.
     *
     * @param resultsPanel
     */
    public panelControl(panelResultados resultsPanel) {
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }


    private void initComponents() {
        setLayout(new GridLayout(2, 1));
        RolController dataInitial = new RolController();

        this.setTblResults(dataInitial.obtenerRoles());

        // Name patttern 
        this.lblName = new JLabel("Nombre del Usuario");
        add(this.getLblName());

        this.txtName = new JTextField();
        add(this.getTxtName());

        // Search button
        this.btnSearch = new JButton("Buscar");
        add(this.btnSearch);

        ClickEvent clickEvent = new ClickEvent(this);
        this.btnSearch.addActionListener(clickEvent);

        // Insert  button
        this.btnAddUser = new JButton("Agregar Nuevo Usuario");
        add(this.getBtnAddUser());
        this.getAddUser().addActionListener(clickEvent);
    }

   
    public JLabel getLblRol() {
        return lblRol;
    }

    public JComboBox getCbxRolsList() {
        return cbxRolsList;
    }

    public JLabel getLblName() {
        return lblName;
    }
    
    public JTextField getTxtName() {
        return txtName;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }
    
   
   public JButton getBtnAddUser(){ 
   return btnAddUser;
   } 
    
    
    public JTable getTblResults() {
        return tblResults;
    }

    public void setCbxRolsListList(ArrayList<RolModel> presentations) {
        this.cbxRolsList.setModel(new DefaultComboBoxModel<>(presentations.toArray(new RolModel[presentations.size()])));
        this.getCbxRolsList().setSelectedIndex(0);
    }


    public void setTblResults(ArrayList<RolModel> users) {
        String[] headers = {"Id Rol", "Nombre"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResults.setModel(tableModel);
        for (int i = 0; i < users.size(); i++) {
            tableModel.addRow(users.get(i).toArray());   
        }
    }

}
