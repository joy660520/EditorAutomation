package utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	public static ExtentReports getInstance() {
		ExtentReports extent;
		String Path = "/Users/joyshen/Documents/autotestingReport/regressionTest.html";
		extent = new ExtentReports(Path, true);//false不覆蓋報告
		return extent;

	}
}
