import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class CdpCommand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		DevTools devTool = driver.getDevTools();
		devTool.createSession();
		Map deviceMetrics = new HashMap();
		deviceMetrics.put("width", 600);
		deviceMetrics.put("height", 1000);
		deviceMetrics.put("deviceScaleFactor", 50);
		deviceMetrics.put("mobile", true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
	}

}
