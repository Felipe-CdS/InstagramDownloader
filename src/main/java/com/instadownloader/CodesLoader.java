package com.instadownloader;

import java.util.ArrayList;

public class CodesLoader {
	
	static int timerSearch() {
		
		String pageSource = App.driver.getPageSource();
		String timeString = pageSource.substring(pageSource.indexOf("seguindo,"), pageSource.indexOf("publicações"));	
		System.out.println(timeString);
		return 0;
	}

	static ArrayList<String> loader(ArrayList<String> codesList) throws Exception{
		
		
		for(int i = 0; i < 315; i++) {
			
	    	
			//get the page HTML
    		String pageSource = App.driver.getPageSource();
	
    		//search in the HTML code for a photo code and save it in the Array
    		if(i % 5 == 0) {
    			System.out.println("Loading...");
    			while(pageSource.contains("/p/")) {
    				String codeTemp = pageSource.substring(pageSource.indexOf("/p/"), pageSource.indexOf("/p/") + 14);
    				if(!codesList.contains(codeTemp)) {
    					codesList.add(codeTemp);
    				}
            		pageSource = pageSource.substring(pageSource.indexOf("/p/") + 3);
            	}
    		}
    		
    		//scroll the page going down
    		App.js.executeScript("window.scrollBy(0,150)");
    		
    		Thread.sleep(100);
    	}
		
		return codesList;
	}
}
