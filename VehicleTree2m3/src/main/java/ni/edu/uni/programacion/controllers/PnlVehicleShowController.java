/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import ni.edu.uni.programacion.backend.dao.implementation.JsonVehicleDaoImpl;
import ni.edu.uni.programacion.backend.pojo.Vehicle;
import ni.edu.uni.programacion.models.VehicleTableModel;
import ni.edu.uni.programacion.views.panels.PnlShow;

/**
 *
 * @author Usuario
 */
public class PnlVehicleShowController {

    private PnlShow pnlShow;
    private JsonVehicleDaoImpl jsonVehicleDaoImpl;
    private VehicleTableModel tblViewModel;
    private List<Vehicle> vehicles;
    private String[] HEADERS = new String[]{"StockNumber", "Year", "Make", "Model", "Style",
        "Vin", "Exterior color", "Interior color", "Miles", "Price", "Transmission", "Engine", "Image", "Status"};
    private TableRowSorter<VehicleTableModel> tblRowSorter;

    public PnlVehicleShowController(PnlShow pnlShow) {
        this.pnlShow = pnlShow;
        initComponent();
    }
    
    public VehicleTableModel getTblViewModel() {
        return tblViewModel;
    }
    
    private void initComponent() {
        try {
            jsonVehicleDaoImpl = new JsonVehicleDaoImpl();

            loadTable();

            pnlShow.getTxtSearch().addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    txtFinderKeyTyped(e);
                }
            });

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PnlVehicleShowController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PnlVehicleShowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void txtFinderKeyTyped(KeyEvent e) {
        RowFilter<VehicleTableModel, Object> rf = null;
        rf = RowFilter.regexFilter(pnlShow.getTxtSearch().getText(), 0, 1, 2, 3, 4, 5, 6, 7, 8);
        tblRowSorter.setRowFilter(rf);
    }

    private void loadTable() throws IOException {
        vehicles = jsonVehicleDaoImpl.getAll().stream().collect(Collectors.toList());
        tblViewModel = new VehicleTableModel(vehicles, HEADERS) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 13) {
                    return true;
                } else {
                    return false;
                }
            }

        };

        tblRowSorter = new TableRowSorter<VehicleTableModel>(tblViewModel) {
            @Override
            public boolean isSortable(int column) {
                return false;
                
            }

        };

        pnlShow.getTblShow().setModel(tblViewModel);
        pnlShow.getTblShow().setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        pnlShow.getTblShow().setRowSorter(tblRowSorter);
    }

    private Object[][] getData() throws IOException {
        vehicles = jsonVehicleDaoImpl.getAll().stream().collect(Collectors.toList());
        Object data[][] = new Object[vehicles.size()][vehicles.get(0).asArray().length];

        IntStream.range(0, vehicles.size()).forEach(i
                -> {
            data[i] = vehicles.get(i).asArray();
        });

        return data;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

}
