/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.views;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import ni.edu.uni.programacion.controllers.FrmTreeController;

/**
 *
 * @author Sistemas-09
 */
public class FrmTree extends javax.swing.JFrame {
    private FrmTreeController frmTreeController;
    /**
     * Creates new form FrmTree
     */
    public FrmTree() {
        
        initComponents();
        frmTreeController = new FrmTreeController(this);
    }

    public JButton getBtnAdd() {
        return BtnAdd;
    }

    public void setBtnAdd(JButton BtnAdd) {
        this.BtnAdd = BtnAdd;
    }

    public JButton getBtnRemove() {
        return BtnRemove;
    }

    public void setBtnRemove(JButton BtnRemove) {
        this.BtnRemove = BtnRemove;
    }

    public JTree getTreeAcount() {
        return TreeAcount;
    }

    public void setTreeAcount(JTree TreeAcount) {
        this.TreeAcount = TreeAcount;
    }

    public JPopupMenu getPmnTree() {
        return pmnTree;
    }

    public JButton getBtnClear() {
        return BtnClear;
    }

    public void setBtnClear(JButton BtnClear) {
        this.BtnClear = BtnClear;
    }

    public JMenuItem getMniAdd() {
        return mniAdd;
    }

    public JMenuItem getMniClear() {
        return mniClear;
    }

    public JMenuItem getMniRemove() {
        return mniRemove;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmnTree = new javax.swing.JPopupMenu();
        mniAdd = new javax.swing.JMenuItem();
        mniRemove = new javax.swing.JMenuItem();
        mniClear = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        BtnAdd = new javax.swing.JButton();
        BtnRemove = new javax.swing.JButton();
        BtnClear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TreeAcount = new javax.swing.JTree();

        mniAdd.setText("Add");
        pmnTree.add(mniAdd);

        mniRemove.setText("Remove");
        pmnTree.add(mniRemove);

        mniClear.setText("jMenuItem1");
        pmnTree.add(mniClear);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tree Demo");

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        BtnAdd.setText("Add");
        jPanel1.add(BtnAdd);

        BtnRemove.setText("Remove");
        jPanel1.add(BtnRemove);

        BtnClear.setText("Clear");
        BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClearActionPerformed(evt);
            }
        });
        jPanel1.add(BtnClear);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.BorderLayout());

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        TreeAcount.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        TreeAcount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TreeAcountMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TreeAcount);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 416, 368);
    }// </editor-fold>//GEN-END:initComponents

    private void TreeAcountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TreeAcountMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TreeAcountMouseClicked

    private void BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTree().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnClear;
    private javax.swing.JButton BtnRemove;
    private javax.swing.JTree TreeAcount;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mniAdd;
    private javax.swing.JMenuItem mniClear;
    private javax.swing.JMenuItem mniRemove;
    private javax.swing.JPopupMenu pmnTree;
    // End of variables declaration//GEN-END:variables
}