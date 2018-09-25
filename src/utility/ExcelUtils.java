package utility;
/**
 * @author suman
 * @Date 27/8/2018
 * @Excel Read and write in excel sheet
 *
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
    public class ExcelUtils {
                private static XSSFSheet ExcelWSheet;
                private static XSSFWorkbook ExcelWBook;
                private static XSSFCell Cell;
                private static XSSFRow Row;
                private static FileInputStream ExcelFile=null;
                private static String filePath;
            //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
            public static void setExcelFile(String SheetName) throws Exception {
                   try {
                       // Open the Excel file
                	    FileReader reader=new FileReader("./CustomizeThings.properties");  
                	    
                	    Properties p=new Properties();  
                	    p.load(reader);
                	    String Path=p.getProperty("excelfile");
                    ExcelFile = new FileInputStream(Path);
                    // Access the required test data sheet
                    filePath=Path;
                    ExcelWBook = new XSSFWorkbook(ExcelFile);
                    ExcelWSheet = ExcelWBook.getSheet(SheetName);
                    Log4j.info("Excel sheet opened");
                    } catch (Exception e){
                    	Log4j.error("unable to open excel");
                        throw (e);
                    }
            }
            //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
            public static String getCellData(int RowNum, int ColNum) throws Exception{
                   try{
                	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                      String CellData = Cell.getStringCellValue();
                      return CellData;
                      }catch (Exception e){
                        return"";
                      }
            }
            //This method is to write in the Excel cell, Row num and Col num are the parameters
            @SuppressWarnings("static-access")
			public static void setCellData(String Result,  int RowNum) throws Exception    {
                   try{
                      Row  = ExcelWSheet.getRow(RowNum);
                    Cell = Row.getCell(Row.getLastCellNum());
                    if (Cell == null) {
                        Cell = Row.createCell(Row.getLastCellNum());
                        Cell.setCellValue(Result);
                        } else {
                            Cell.setCellValue(Result);
                        }
          // Constant variables Test Data path and Test Data file name
                          FileOutputStream fileOut = new FileOutputStream(filePath);
                          ExcelWBook.write(fileOut);
                          fileOut.flush();
                        fileOut.close();
                        }catch(Exception e){
                            throw (e);
                    }
                }
            //set cell data using rownumber,column number and data
            @SuppressWarnings("static-access")
			public static void setCellData(int RowNum,int column,String Result) throws Exception    {
                   try{
                      Row  = ExcelWSheet.getRow(RowNum);
                    Cell = Row.getCell(column, null);
                    if (Cell == null) {
                        Cell = Row.createCell(column);
                        Cell.setCellValue(Result);
                        } else {
                            Cell.setCellValue(Result);
                        }
          // Constant variables Test Data path and Test Data file name
                          FileOutputStream fileOut = new FileOutputStream(filePath);
                          ExcelWBook.write(fileOut);
                          fileOut.flush();
                        fileOut.close();
                        }catch(Exception e){
                            throw (e);
                    }
                }
            //get data using testcase name and column number
        	public static int getRowContains(String sTestCaseName, int colNum) throws Exception{
        		int i;
        		try {
        			int rowCount = ExcelUtils.getRowUsed();
        			for ( i=1 ; i<rowCount; i++){
        				if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
        					break;
        				}
        			}
        			return i;
        				}catch (Exception e){
        			Log4j.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
        			throw(e);
        			}
        		}
        	//get total number of row
        	public static int getRowUsed() throws Exception {
        		try{
        			int RowCount = ExcelWSheet.getLastRowNum();
        			Log4j.info("Total number of Row used return as < " + RowCount+1 + " >.");		
        			return RowCount+1;
        		}catch (Exception e){
        			Log4j.error("Class ExcelUtil | Method getRowUsed | Exception desc : "+e.getMessage());
        			System.out.println(e.getMessage());
        			throw (e);
        		}

        	}
        	//check the column number contains the value
        	public static int getColumnContains(String Field) throws Exception{
        		int i;
        		try {
        			Row = ExcelWSheet.getRow(0);
        			int colNum=Row.getLastCellNum();
        			for ( i=1 ; i<colNum; i++){
        				if  (ExcelUtils.getCellData(0,i).equalsIgnoreCase(Field)){
        					break;
        				}
        			}
        			return i;
        				}catch (Exception e){
        			Log4j.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
        			throw(e);
        			}
        		}
        	//get value using testcase name and column header value
        	public static String getViaTEST(String Test,String Val)
        	{
        		try {
					int Row1=ExcelUtils.getRowContains(Test, 0);
					int Col1=ExcelUtils.getColumnContains(Val);
					return ExcelUtils.getCellData(Row1, Col1);
				} catch (Exception e) {
					Log4j.error("Class ExcelUtil | Method getViaTEST | Exception desc : "+e.getMessage());
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		return "0";
        		
        	}
        	//set value using testcase name and column header value
        	@SuppressWarnings("static-access")
        	public static void setViaTEST(String Test,String field,String value)
        	{
        		try {
					int Row1=ExcelUtils.getRowContains(Test, 0);
					int Col1=ExcelUtils.getColumnContains(field);
					ExcelUtils.setCellData(Row1,Col1,value);
				} catch (Exception e) {
					Log4j.error("Class ExcelUtil | Method setViaTEST | Exception desc : "+e.getMessage());
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        		
        	}
        	
    }