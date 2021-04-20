/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.views;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ni.edu.uni.programacion.backend.dao.implementation.JsonVehicleDaoImpl;
import ni.edu.uni.programacion.backend.pojo.Vehicle;
import ni.edu.uni.programacion.controllers.PnlVehicleShowController;
import ni.edu.uni.programacion.models.VehicleTableModel;
import ni.edu.uni.programacion.views.panels.DialogVehicle;
import ni.edu.uni.programacion.views.panels.PnlShow;

/**
 *
 * @author JADPA26
 */
public class IFrmVehicle extends javax.swing.JInternalFrame {

    PnlShow pnlShow;
    PnlVehicleShowController pnlShowController;
    DialogVehicle dialogVehicle;

    /**
     * Creates new form IFrmVehicle
     */
    public IFrmVehicle() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlButton = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        pnlTable = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("View Vehicle");

        pnlButton.setBackground(new java.awt.Color(255, 204, 204));

        btnNew.setBackground(new java.awt.Color(255, 255, 255));
        btnNew.setForeground(new java.awt.Color(0, 0, 0));
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        pnlButton.add(btnNew);

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnlButton.add(btnUpdate);

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pnlButton.add(btnDelete);

        getContentPane().add(pnlButton, java.awt.BorderLayout.PAGE_END);

        pnlTable.setBackground(new java.awt.Color(153, 204, 255));
        pnlTable.setLayout(new java.awt.BorderLayout());

        pnlShow=new PnlShow();
        pnlShowController = new PnlVehicleShowController(pnlShow);

        pnlTable.add(pnlShow, BorderLayout.CENTER);
        getContentPane().add(pnlTable, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        dialogVehicle = new DialogVehicle(null, true);
        dialogVehicle.addObserver(pnlShowController.getTblViewModel());
        dialogVehicle.setVisible(true);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (pnlShow.getTblShow().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Porfavor seleccione una fila.",
                    "Updating message", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        dialogVehicle= new DialogVehicle(null, true);
        dialogVehicle.setPnlShowReference(pnlShow, pnlShowController);
        //dialogVehicle.addObserver(pnlShowController.getTblViewModel());
        dialogVehicle.setVisible(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(pnlShow.getTblShow().getSelectedRow() == -1)
        {
            JOptionPane.showMessageDialog(null, "Select a vehicle to delete.",
                    "Delete message",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int op = JOptionPane.showConfirmDialog(null, "Are you sure?","Delete", JOptionPane.YES_NO_OPTION);
        
        if(op == JOptionPane.NO_OPTION)
            return;
        
        int row = pnlShow.getTblShow().getSelectedRow();
        int vehicleId = pnlShowController.getVehicles().get(row).getId();

        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleId);
        JsonVehicleDaoImpl jsonVehicleDaoImpl;
        try
        {
            jsonVehicleDaoImpl = new JsonVehicleDaoImpl();
            jsonVehicleDaoImpl.delete(vehicle);
            
            VehicleTableModel modelo =  (VehicleTableModel) pnlShow.getTblShow().getModel(); 
            modelo.removeRow(row);
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(IFrmVehicle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(IFrmVehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "The vehicle was sucessfully deleted",
                "Delete message",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnDeleteActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlTable;
    // End of variables declaration//GEN-END:variables
}