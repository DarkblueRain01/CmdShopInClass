import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadProductExcel {
    public Product[] getAllProducts(File file) {
        Product products[] = null;
        try {
            XSSFWorkbook xw = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet xs = xw.getSheetAt(0);
            products = new Product[xs.getLastRowNum()];
            for (int j = 1; j <= xs.getLastRowNum(); j++) {
                XSSFRow row = xs.getRow(j);
                Product p = new Product();//每循环一次就把电子表格的一行的数据给对象赋值
                for (int k = 0; k <= row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);
                    if (cell == null)
                        continue;
                    if (k == 0) {
                        p.setPID(this.getValue(cell));//给username属性赋值
                    } else if (k == 1) {
                        p.setPname(this.getValue(cell));//给password属性赋值
                    } else if (k == 2) {
                        p.setPrice(this.getValue(cell));//给address属性赋值
                    } else if (k == 3) {
                        p.setIntro(this.getValue(cell));//给phone属性赋值
                    }
                }
                products[j-1] = p;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getProductById(String SID,File file) {
        Product products[] = null;
        try {
            XSSFWorkbook xw = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet xs = xw.getSheetAt(0);
            products = new Product[xs.getLastRowNum()];
            for (int j = 1; j <= xs.getLastRowNum(); j++) {
                XSSFRow row = xs.getRow(j);
                Product p = new Product();//每循环一次就把电子表格的一行的数据给对象赋值
                for (int k = 0; k <= row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);
                    if (cell == null)
                        continue;
                    if (k == 0) {
                        p.setPID(this.getValue(cell));//给username属性赋值
                    } else if (k == 1) {
                        p.setPname(this.getValue(cell));//给password属性赋值
                    } else if (k == 2) {
                        p.setPrice(this.getValue(cell));//给address属性赋值
                    } else if (k == 3) {
                        p.setIntro(this.getValue(cell));//给phone属性赋值
                    }
                }
                products[j - 1] = p;
                if (SID.equals(p.getPID())){
                    return p;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getValue(XSSFCell cell) {
        String value;
        CellType type = cell.getCellTypeEnum();

        switch (type) {
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BLANK:
                value = "";
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue() + "";
                break;
            case NUMERIC:
                value = cell.getNumericCellValue() + "";
                break;
            case FORMULA:
                value = cell.getCellFormula();
                break;
            case ERROR:
                value = "非法字符";
                break;
            default:
                value = "";
                break;
        }
        return value;
    }
}
