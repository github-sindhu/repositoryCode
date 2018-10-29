package com.epam.engx.cleancode.complextask.task1;



import com.epam.engx.cleancode.complextask.task1.thirdpartyjar.Command;
import com.epam.engx.cleancode.complextask.task1.thirdpartyjar.DataSet;
import com.epam.engx.cleancode.complextask.task1.thirdpartyjar.View;
import com.epam.engx.cleancode.complextask.task1.thirdpartyjar.DatabaseManager;

import java.util.List;


public class Print implements Command {

    private View view;
    private DatabaseManager manager;
    private String tableName;
   // private TableData tableData= new TableData();
    private List<DataSet> dataSets;
    private int rowsCount ;
    private int maxColumnSize ;
    private TableHavingData tableData= new TableHavingData();




    public Print(View view, DatabaseManager manager) {
        this.view = view;
        this.manager = manager;

    }

    public boolean canProcess(String command) {
        return command.startsWith("print ");
    }

    public void process(String input) {

        checkIfTheInputIsValidAndSetTheTableName(input);
        setTheContext();
        view.write(getTableString());

    }
    public void setTheContext()
    {
        dataSets = manager.getTableData(tableName);
        rowsCount = dataSets.size();
        int maxColumnSize = getMaxColumnSize();

    }


    private void checkIfTheInputIsValidAndSetTheTableName(String input) {
        String[] command = input.split(" ");
        if (command.length != 2) {
            throw new IllegalArgumentException("incorrect number of parameters. Expected 1, but is " + (command.length - 1));
        }
        tableName = command[1];

    }

    private String getTableString() {
        int maxColumnSize;
        maxColumnSize = getMaxColumnSize();
        if (maxColumnSize == 0) {
            return getEmptyTable(tableName);
        } else {
            return tableData.getHeaderOfTheTable() + tableData.getStringTableData();
        }
    }

    private String getEmptyTable(String tableName) {

        String result=createUpperBorderForEmptyTable()+"\n"+getEmptyTableText()+"\n"+createLowerBorderForEmptyTable();
        return result;
    }

    public String createUpperBorderForEmptyTable()
    {
        return "╔"+createLinesForEmptyTable()+"╗";

    }
    public String getEmptyTableText()
    {
        String textEmptyTable = "║ Table '" + tableName + "' is empty or does not exist ║";

        return textEmptyTable;
    }

    public String createLowerBorderForEmptyTable()
    {
        return  "╚"+createLinesForEmptyTable()+"╝\n";


    }

    public String createLinesForEmptyTable()
    {
        String EmptyLines="";
        for (int i = 0; i < getEmptytTableLength() - 2; i++) {
            EmptyLines += "═";
        }
        return EmptyLines;
    }




    public int getEmptytTableLength()
    {
        return getEmptyTableText().length();
    }




    private int getMaxColumnSize() {

        return getMaxLengthOfColumnValues(dataSets);
    }

    private int getMaxLengthOfColumnHeader(List<DataSet> dataSets) {
        int maxLength = 0;
        if (dataSets.size() > 0) {
            List<String> columnNames = dataSets.get(0).getColumnNames();
            for (String columnName : columnNames) {
                if (columnName.length() > maxLength) {
                    maxLength = columnName.length();
                }
            }

        }
        return maxLength;
    }



    private int getMaxLengthOfColumnValues(List<DataSet> dataSets)
    {
        int maxLength =getMaxLengthOfColumnHeader(dataSets) ;

        for (DataSet dataSet : dataSets) {
            List<Object> values = dataSet.getValues();
            for (Object value : values) {
//                    if (value instanceof String)
                if (String.valueOf(value).length() > maxLength) {
                    maxLength = String.valueOf(value).length();
                }
            }
        }


        return maxLength;

    }
    private int getColumnCount() {
        int result = 0;
        if (dataSets.size() > 0) {
            return dataSets.get(0).getColumnNames().size();
        }
        return result;
    }


private class TableHavingData

    {



        private String getStringTableData()
        {


            String result = "";
            if (maxColumnSize % 2 == 0) {
                maxColumnSize += 2;
            } else {
                maxColumnSize += 3;
            }
            int columnCount = getColumnCount();
            for (int row = 0; row < rowsCount; row++) {
                List<Object> values = dataSets.get(row).getValues();
                result += "║";
                for (int column = 0; column < columnCount; column++) {
                    int valuesLength = String.valueOf(values.get(column)).length();
                    if (valuesLength % 2 == 0) {
                        for (int j = 0; j < (maxColumnSize - valuesLength) / 2; j++) {
                            result += " ";
                        }
                        result += String.valueOf(values.get(column));
                        for (int j = 0; j < (maxColumnSize - valuesLength) / 2; j++) {
                            result += " ";
                        }
                        result += "║";
                    } else {
                        for (int j = 0; j < (maxColumnSize - valuesLength) / 2; j++) {
                            result += " ";
                        }
                        result += String.valueOf(values.get(column));
                        for (int j = 0; j <= (maxColumnSize - valuesLength) / 2; j++) {
                            result += " ";
                        }
                        result += "║";
                    }
                }
                //
                result += "\n";
                if (row < rowsCount - 1) {
                    result += "╠";
                    for (int j = 1; j < columnCount; j++) {
                        for (int i = 0; i < maxColumnSize; i++) {
                            result += "═";
                        }
                        result += "╬";
                    }
                    for (int i = 0; i < maxColumnSize; i++) {
                        result += "═";
                    }
                    result += "╣\n";
                }
                //
            }
            result += "╚";
            for (int j = 1; j < columnCount; j++) {
                for (int i = 0; i < maxColumnSize; i++) {
                    result += "═";
                }
                result += "╩";
            }
            for (int i = 0; i < maxColumnSize; i++) {
                result += "═";
            }
            result += "╝\n";
            return result;
        }


    private String getHeaderOfTheTable() {
        int maxColumnSize = getMaxColumnSize();
        String result = "";
        int columnCount = getColumnCount();
        if (maxColumnSize % 2 == 0) {
            maxColumnSize += 2;
        } else {
            maxColumnSize += 3;
        }
        result += "╔";
        for (int j = 1; j < columnCount; j++) {
            for (int i = 0; i < maxColumnSize; i++) {
                result += "═";
            }
            result += "╦";
        }
        for (int i = 0; i < maxColumnSize; i++) {
            result += "═";
        }
        result += "╗\n";
        List<String> columnNames = dataSets.get(0).getColumnNames();
        for (int column = 0; column < columnCount; column++) {
            result += "║";
            int columnNamesLength = columnNames.get(column).length();
            if (columnNamesLength % 2 == 0) {
                for (int j = 0; j < (maxColumnSize - columnNamesLength) / 2; j++) {
                    result += " ";
                }
                result += columnNames.get(column);
                for (int j = 0; j < (maxColumnSize - columnNamesLength) / 2; j++) {
                    result += " ";
                }
            } else {
                for (int j = 0; j < (maxColumnSize - columnNamesLength) / 2; j++) {
                    result += " ";
                }
                result += columnNames.get(column);
                for (int j = 0; j <= (maxColumnSize - columnNamesLength) / 2; j++) {
                    result += " ";
                }
            }
        }
        result += "║\n";

        //last string of the header
        if (dataSets.size() > 0) {
            result += "╠";
            for (int j = 1; j < columnCount; j++) {
                for (int i = 0; i < maxColumnSize; i++) {
                    result += "═";
                }
                result += "╬";
            }
            for (int i = 0; i < maxColumnSize; i++) {
                result += "═";
            }
            result += "╣\n";
        } else {
            result += "╚";
            for (int j = 1; j < columnCount; j++) {
                for (int i = 0; i < maxColumnSize; i++) {
                    result += "═";
                }
                result += "╩";
            }
            for (int i = 0; i < maxColumnSize; i++) {
                result += "═";
            }
            result += "╝\n";
        }
        return result;
    }
}

}
