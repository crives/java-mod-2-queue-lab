public class Table {
    // Private for table class to have complete control over table number
    private int tableNum;

    public Table(int tableNum) {
        this.tableNum = tableNum;
    }

    public int getTableNum() {
        return tableNum;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }
    
    @Override
    public String toString() {
        return "Table " + tableNum;
    }
}
