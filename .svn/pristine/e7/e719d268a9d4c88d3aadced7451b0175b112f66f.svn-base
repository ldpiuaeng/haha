package com.util.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static List<Object[]> readXls(File excelFile) throws Exception {
		List<Object[]> list = new ArrayList<Object[]>();
		Object[] obj = null;
		FileInputStream is = null;
		Workbook wb = null;
		boolean is972003 = is972003Excel(excelFile);
		try {
			is = new FileInputStream(excelFile);
			wb = is972003 ? new HSSFWorkbook(is) : new XSSFWorkbook(is);
			Sheet sheet = wb.getSheetAt(0);

			for (int j = 0; j <= sheet.getLastRowNum(); j++) {
				Row row = sheet.getRow(j);
				if (row != null) {
					obj = new Object[row.getLastCellNum()];
					for (int k = 0; k < row.getLastCellNum(); k++) {
						Cell cell = row.getCell(k);
						if (null != cell) {
							switch (cell.getCellType()) {
							case HSSFCell.CELL_TYPE_NUMERIC: // 数字
								obj[k] = cell.getNumericCellValue();
								break;
							case HSSFCell.CELL_TYPE_STRING: // 字符串
								obj[k] = cell.getStringCellValue();
								break;
							case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
								obj[k] = cell.getBooleanCellValue();
								break;
							case HSSFCell.CELL_TYPE_FORMULA: // 公式
								obj[k] = cell.getCellFormula();
								break;
							case HSSFCell.CELL_TYPE_BLANK: // 空值
								obj[k] = null;
								break;
							case HSSFCell.CELL_TYPE_ERROR: // 故障
								obj[k] = null;
								break;
							default:
								obj[k] = null;
								break;
							}
						}
					}
					list.add(obj);
				}
			}
		} finally {
			if (wb != null)
				wb.close();
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

		}
		return list;
	}

	public static boolean is972003Excel(File excelFile) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelFile);
			new HSSFWorkbook(fis);
		} catch (Exception e) {
			return false;
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	public static boolean is2010Excel(File excelFile) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelFile);
			new XSSFWorkbook(fis);
		} catch (Exception e) {
			return false;
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		File f2010 = new File("C:\\a.xlsx");
		File f972003 = new File("C:\\a.xls");
		List list = readXls(f2010);
		List list2 = readXls(f972003);

	}
}
