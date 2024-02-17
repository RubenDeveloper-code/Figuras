package figuritas;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class ControlFigura {

    private final int buffSize = 2048;
    Figura figuras[] = new Figura[buffSize];

    ControlFigura() {

    }

    public boolean agregarFigura(Figura figura) {
        if(buscarFigura(figura.nombreFigura))return false;
        int index = spaceToPlaceFigura();
        figuras[index] = figura;
        return index != -1 ? true : false;
    }

    public boolean eliminarFigura(int index) {
        int skip = 0;
        for (int i = 0; i < buffSize - 1; i++) {
            if (i == index) {
                skip = 1;
            }
            figuras[i] = figuras[i + skip];
        }
        return skip == 1;//odio java
    }

    public boolean buscarFigura(String nombreFigura) {
        for (Figura fig : figuras) {
            if(fig==null)break;
            if (fig.nombreFigura.compareTo(nombreFigura) == 0) {
                return true;
            }
        }
        return false;
    }

    private int spaceToPlaceFigura() {
        for (int i = 0; i < buffSize; i++) {
            if (figuras[i] == null) {
                return i;
            }
        }
        return -1;
    }

    //Yo no entiendos
    private int getIndexFromName(String name) {
        for (int i = 0; i < buffSize; i++) {
             if(figuras[i]==null)break;
            if (figuras[i].nombreFigura.compareTo(name) == 0) {
                return i;
            }
        }
        return -1;
    }
    
    public DefaultTableModel obtenerItem(String nombre) {
        if (buscarFigura(nombre)) {
            int index = getIndexFromName(nombre);
            DefaultTableModel dtm = new DefaultTableModel();
            Object datos[] = new Object[4];
            dtm.addColumn("NOMBRE");
            dtm.addColumn("AREA");
            dtm.addColumn("VOLUMEN");
            dtm.addColumn("IMPRIMIR");
            datos[0] = figuras[index].obtenerNombre();
            datos[1] = figuras[index].obtenerArea();
            datos[2] = figuras[index].obtenerVolumen();
            datos[3] = figuras[index].imprimir();
            dtm.addRow(datos);
            return dtm;
        } else {
            return null;
        }
    }

    public DefaultTableModel obtenerItemVolumenArea(String nombre) {
        if (buscarFigura(nombre)) {
            int index = getIndexFromName(nombre);
            DefaultTableModel dtm = new DefaultTableModel();
            Object datos[] = new Object[4];
            dtm.addColumn("NOMBRE");
            dtm.addColumn("AREA");
            dtm.addColumn("VOLUMEN");
            datos[0] = figuras[index].obtenerNombre();
            datos[1] = figuras[index].obtenerArea();
            datos[2] = figuras[index].obtenerVolumen();
            dtm.addRow(datos);
            return dtm;
        } else {
            return null;
        }
    }

    public DefaultTableModel obtenerlista() {
        DefaultTableModel dtm = new DefaultTableModel();
        Object datos[] = new Object[4];
        dtm.addColumn("NOMBRE");
        dtm.addColumn("AREA");
        dtm.addColumn("VOLUMEN");
        dtm.addColumn("IMPRIMIR");

        for (int i = 0; i < buffSize; i++) {
            if (figuras[i] == null) {
                break;
            }
            datos[0] = figuras[i].obtenerNombre();
            datos[1] = figuras[i].obtenerArea();
            datos[2] = figuras[i].obtenerVolumen();
            datos[3] = figuras[i].imprimir();
            dtm.addRow(datos);
        }
        return dtm;
    }

    public DefaultListModel obtenerListaNombres() {
        DefaultListModel dlm = new DefaultListModel();
        for (Figura fig : figuras) {
            if (fig == null) {
                break;
            }
            dlm.addElement(fig.nombreFigura);
        }
        return dlm;
    }

}
