package view;

import access.RolDAO;
import controllers.Click;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import models.RolModel;

public class AddUser extends JFrame implements ActionListener {
    private JLabel                     lblId;
    private JTextField                 txtId;
    private JLabel                     lblName;
    private JTextField                 txtName;
    private JLabel                     lblType;
    private JTextField                 txtType;
    private JLabel                     lblPrice;
    private JTextField                 txtPrice;
    private JLabel                     lblExhibition;
    private JLabel                     lblOnPresentation;
    private JCheckBox                  chbOnPresentation;
    private JLabel                     lblMuseums;
    private JComboBox<RolModel>     cbxMuseums;
    private JLabel                     lblPresentation;
    private JTextField                 txtPresentation;
    private JButton                    btnInsertUser;
    
    public AddUser(){
        initComponents();
    }
    
    public void initComponents(){
        setTitle("Roles - Agregar Usuario");
        setLayout(new GridLayout(8,2));
        
        this.lblId = new JLabel("Id del usuario");
        add(this.lblId);
        this.txtId = new JTextField();
        add(this.txtId);
       
        this.lblType = new JLabel("Tipo del usuario");
        add(this.lblType);
        this.txtType = new JTextField();
        add(this.txtType);
        
        
        this.lblMuseums = new JLabel("Seleccione Id:");
        this.cbxMuseums = new JComboBox<>();
        
        this.lblPresentation = new JLabel("Escriba Presentación");
        this.txtPresentation = new JTextField();
        
        this.btnInsertUser = new JButton("Agregar a B.D.");
        add(this.btnInsertUser);
        
        this.btnInsertUser.addActionListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.btnInsertUser) {
            int    id = Integer.parseInt( (String)this.txtId.getText()); 
            String type = (String)this.txtType.getText(); 
    
            RolModel user = new RolModel(id, type);
            RolDAO artPieceDAO = new RolDAO();
            artPieceDAO.agregarRol(user);
        }
    }
}