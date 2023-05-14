import org.jetbrains.annotations.NotNull;

import javax.swing.table.AbstractTableModel;

public class ScoreboardTableModel extends AbstractTableModel {


    private final Object[][] dataTable;

    public ScoreboardTableModel(@NotNull Object[][] dataTable){
        this.dataTable = new Object[dataTable.length][dataTable[0].length];
        for (int i = 0; i < dataTable.length; i++) {
            System.arraycopy(dataTable[i], 0, this.dataTable[i], 0, dataTable[0].length);
        }
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
