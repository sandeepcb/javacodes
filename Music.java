package com.the.machine;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
	
	public class Music {
		public static void main(String[] args) {
			String url="http://musicpleer.cc/#!";
			if(args.length==1){
				url =url+args[0];
			}
			if(args.length==2){
				url =url+args[0]+"+"+args[1]+"";
			}
			if(args.length==3){
				url =url+args[0]+"+"+args[1]+"+"+args[2];
			}	
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
			                "/usr/local/share/phantomjs-1.9.8-linux-x86_64/bin/phantomjs");                  
			WebDriver driver = new PhantomJSDriver(caps);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			for(int j=1;j<6;j++){
				driver.get(url);
				driver.findElement(By.xpath("//*[@id='searchResults']/ul/li["+j+"]/a")).click();
				String comm=(driver.findElement(By.xpath("//*[@id='searchResults-player']/a")).getAttribute("href"));
				String fin ="wget \""+comm+"\" -O /home/cbsandeep10/sandeep/"+j+".mp3";
				System.out.println(fin);
				try {
					Process q = Runtime.getRuntime().exec(fin);
					q.waitFor();
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			}
			driver.close();
			
		}
	}