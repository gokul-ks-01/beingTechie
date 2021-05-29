package myproject.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class TestReport implements ITestListener {
	
	
	 String filePath = "D:\\Being a Techie\\selenium-maven\\src\\test\\java\\myproject\\results\\Report.pdf"; 
	 static Document doc  ;
	 Font para_font = FontFactory.getFont(FontFactory.TIMES_ROMAN,10,BaseColor.BLACK);
	 Font error_font=FontFactory.getFont(FontFactory.TIMES_ROMAN,10,BaseColor.RED);
	 Font skip_font=FontFactory.getFont(FontFactory.TIMES_ROMAN,10,BaseColor.YELLOW);
	 Font pass_font=FontFactory.getFont(FontFactory.TIMES_ROMAN,10,BaseColor.GREEN);
	 Font heading_font = FontFactory.getFont(FontFactory.TIMES_ROMAN,12,BaseColor.BLACK);
	@Override
	public void onStart(ITestContext arg0) {

		System.out.println("Start of TestSuite  : "+ arg0.getName());
		System.out.println("Host : " +arg0.getHost());
		doc = new Document () ;
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(filePath));
			doc.open();
			doc.addCreationDate();
			doc.addHeader("page header", "Test Report");
			doc.add(new Paragraph(new Chunk("Test Run Starting : "+ arg0.getName(),para_font)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("Test Started : " + arg0.getName());
		try {
			doc.add(new Paragraph(new Chunk("Test Case : " + arg0.getName(),para_font)));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Test Pass : " + arg0.getName() );
		try {
			doc.add(new Paragraph(new Chunk("Test Passed",pass_font)));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("Test Failed : " + arg0.getName() );
		try {
			doc.add(new Paragraph(new Chunk("Test Failed",error_font)));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Test Skipped : " + arg0.getName() );
		try {
			doc.add(new Paragraph(new Chunk("Test Skipped",skip_font)));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("End of TestSuite : " + arg0.getName());
	
		System.out.println("Passed Tests : " + arg0.getPassedTests());	
		System.out.println("Failed Tests : " +arg0.getFailedTests());
		System.out.println("Skipped Tests : " +arg0.getSkippedTests());
		System.out.println("Report directory : " +arg0.getOutputDirectory());
		try {
			doc.add(new Paragraph(new Chunk("Test Run completed : " + arg0.getName(),para_font)));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doc.close();
		
		
	}
	
	
	public static void onCustomAction(String textToBeOnReport) throws DocumentException {
		 Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN,10,BaseColor.BLACK);
			doc.add(new Paragraph(new Chunk(textToBeOnReport,font)));
		
	}


	

	/*
	 * @Override public void onTestFailedButWithinSuccessPercentage(ITestResult
	 * arg0) {
	 * 
	 * }
	 */
}
