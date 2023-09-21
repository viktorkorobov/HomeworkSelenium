package UI.Selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table extends BaseMethod{
    WebElement elementTable;
    public Table (WebElement elementTable){
        this.elementTable=elementTable;
    }
    public List<WebElement> getRows(){
        List<WebElement> rows = elementTable.findElements(By.xpath(".//div[@role='rowgroup']"));
        return rows;
    }
    public List<List<WebElement>> getRowsAndColumns(){
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsAndColumns = new ArrayList<>();
        for (WebElement row:rows){
            List<WebElement> columns = row.findElements(By.xpath(".//div[@role='gridcell']"));
            rowsAndColumns.add(columns);
        }
        return rowsAndColumns;
    }
    public String getValue(int row, int column){
        List<List<WebElement>> rowsAndColumn = getRowsAndColumns();
        WebElement cell = rowsAndColumn.get(row-1).get(column-1);
        return cell.getText();
    }
}
