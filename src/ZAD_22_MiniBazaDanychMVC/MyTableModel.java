package ZAD_22_MiniBazaDanychMVC;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

    private boolean DEBUG = false;


    private String[] columns = {"Imię", "Nazwisko", "Wiek", "Stanowisko", "Rocznik"};

    Pracownik pracownik1 = new Pracownik("Jan", "Kowalski", "Kierownik", 1974);
    Pracownik pracownik2 = new Pracownik("Maria", "Nowacka", "Sprzedawca", 1988);
    Pracownik pracownik3 = new Pracownik("Ewa", "Kowalska", "Doradca", 1979);
    Pracownik pracownik4 = new Pracownik("Marek", "Nowacki",  "Asystent", 1990);

    private Object[][] data = {
            pracownik1.getTab(), pracownik2.getTab(), pracownik3.getTab(), pracownik4.getTab()
    };

    MyTableModel(){

    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0,columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex==2){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(DEBUG){
            System.out.printf("Setting value at"+rowIndex+","+columnIndex
                    +" to "+aValue
                    +" (an istance of "
                    + aValue.getClass()+")");
        }

        data[rowIndex][columnIndex] = aValue;

        fireTableCellUpdated(rowIndex, columnIndex);

        if(DEBUG){
            System.out.printf("New value of data: ");
            printDebugData();
        }
    }

    private void printDebugData(){
        int intRows = getRowCount();
        int intCols = getColumnCount();

        for(int i=0; i<intRows; i++){
            System.out.print("   row "+ i + ":");
            for(int j=0; i<intCols; j++){
                System.out.print("    "+data[i][j]);
            }
            System.out.println();
        }

        System.out.println("---------------------------------");
    }
}
