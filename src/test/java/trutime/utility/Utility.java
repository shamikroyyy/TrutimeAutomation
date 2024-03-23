package trutime.utility;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utility {
    public void getScreenshot(WebDriver driver, String methodName){

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String filePath = "testOutput"+File.separator+"Screenshots"+File.separator+methodName+".png";
        File destination = new File(filePath);
        try{
            FileUtils.copyFile(source,destination);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot for"+methodName);
        }
    }

//    public void writeToExcel(String sheetName, String cellValue, int row, int col) throws IOException {
//        String filePath = "testOutput"+File.separator+"TestReports"+File.separator+"ProgramOutput.xlsx";
//        File excelFile = new File(filePath);
//        XSSFWorkbook workbook;
//
//        if(excelFile.exists()){
//            FileInputStream inputStr = new FileInputStream(excelFile);
//            workbook = new XSSFWorkbook(inputStr);
//            inputStr.close();
//        }
//        else{
//            workbook = new XSSFWorkbook();
//        }
//
//        XSSFSheet sheet = workbook.getSheet(sheetName);
//        if(sheet==null){
//            sheet = workbook.createSheet(sheetName);
//        }
//
//        XSSFRow currentRow = sheet.getRow(row);
//        if(currentRow==null){
//            currentRow = sheet.createRow(row);
//        }
//
//        XSSFCell currentCell = currentRow.getCell(col);
//        if(currentCell==null){
//            currentCell = currentRow.createCell(col);
//        }
//        currentCell.setCellValue(cellValue);
//        FileOutputStream outputStr = new FileOutputStream(excelFile);
//        workbook.write(outputStr);
//        outputStr.close();
//
//    }

    public List<String> systemWeek()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM", Locale.getDefault());
        List<String> systemWeekDates = new ArrayList<String>();

       for (int i = 0; i < 7; i++) {
           systemWeekDates.add(dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.DATE, 1);
       }

       return systemWeekDates;
    }

    public String getCurrentDate()
    {
        String currentSystemDate = new SimpleDateFormat("EEE, dd MMM").format(new Date());
        return currentSystemDate;
    }

    public String getCurrentMonth()
    {
        String currentSystemMonth = new SimpleDateFormat("MMMM").format(new Date());
        return currentSystemMonth;
    }

    public String getCurrentYear()
    {
        String currentSystemYear = new SimpleDateFormat("YYYY").format(new Date());
        return currentSystemYear;
    }

    public String getBackDated15()
    {
        String backDate15 = new SimpleDateFormat("EEE, dd MMM").format(new Date(System.currentTimeMillis() - 15L * 24 * 60 * 60 * 1000));
        return backDate15;
    }

}
