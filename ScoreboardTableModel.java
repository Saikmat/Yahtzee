import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ScoreboardTableModel extends AbstractTableModel {


    private final Object[][] dataTable;
    private final String[] colNames;

    public ScoreboardTableModel(@NotNull Object[][] dataTable, @NotNull String[] colNames){
        this.dataTable = new Object[dataTable.length][dataTable[0].length];
        for (int i = 0; i < dataTable.length; i++) {
            System.arraycopy(dataTable[i], 0, this.dataTable[i], 0, dataTable[0].length);
        }
        this.colNames = new String[colNames.length];
        System.arraycopy(colNames, 0, this.colNames, 0, this.colNames.length);
    }

    @Override
    public String getColumnName(int col){
        return colNames[col];
    }

    @Override
    public int getRowCount() {
        return dataTable.length;
    }

    @Override
    public int getColumnCount() {
        return dataTable[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return dataTable[rowIndex][columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIdx, int colIdx){
        return false;
    }


}

class JTableButtonRenderer implements TableCellRenderer {

    private final TableCellRenderer defaultRenderer;

    public JTableButtonRenderer(TableCellRenderer renderer) {
        defaultRenderer = renderer;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof Component) {
            return (Component) value;
        }

        return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
