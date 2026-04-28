package utilities;


	import java.io.FileInputStream;
	import java.io.IOException;

	import org.apache.poi.xssf.usermodel.*;

	public class ExcelUtility {

	    private XSSFWorkbook workbook;
	    private XSSFSheet sheet;

	    public ExcelUtility(String filePath, String sheetName) throws IOException {
	        FileInputStream fis = new FileInputStream(filePath);
	        workbook = new XSSFWorkbook(fis);
	        sheet = workbook.getSheet(sheetName);
	    }

	    public int getRowCount() {
	        return sheet.getLastRowNum();
	    }

	    public int getColCount(int rowNum) {
	        return sheet.getRow(rowNum).getLastCellNum();
	    }

	    public String getCellData(int rowNum, int colNum) {
	        XSSFCell cell = sheet.getRow(rowNum).getCell(colNum);

	        if (cell == null) return "";

	        switch (cell.getCellType()) {
	            case STRING:
	                return cell.getStringCellValue();

	            case NUMERIC:
	                return String.valueOf(cell.getNumericCellValue());

	            case BOOLEAN:
	                return String.valueOf(cell.getBooleanCellValue());

	            default:
	                return "";
	        }
	    }

	    public void close() throws IOException {
	        workbook.close();
	    }
	}


