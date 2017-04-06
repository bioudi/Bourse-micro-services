package bourse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledScraping {
	
	private boolean firstTime = true;
	
	@Scheduled(fixedRate = 300000)
    public void reportCurrentTime() throws IOException, InterruptedException {
		if(firstTime == true)
		{
			System.out.println("Running");
			Process p = Runtime.getRuntime().exec("python intializeH2DB.py");
			p.waitFor();
			System.out.println("process for the first time terminated");
			firstTime = false;
		}
		else
		{
			Process p = Runtime.getRuntime().exec("python refreshH2DB.py");
			p.waitFor();
			System.out.println("process for the real time terminated");
		}
    }
	
}