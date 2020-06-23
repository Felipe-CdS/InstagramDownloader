package com.instadownloader;

import java.util.ArrayList;

public class CodesLoader {
	
	private static int photosCounter;
	
	static void timerSearch() {
		
		String pageSource = App.driver.getPageSource();
		String timeString;
		
		try {
			int a = pageSource.indexOf("Instagram profile has");
			int b = pageSource.indexOf("photos and videos.");
			timeString = pageSource.substring(a+22, b-1);	
		}
		catch(StringIndexOutOfBoundsException e) {
			int a = pageSource.indexOf("Following,");
			int b = pageSource.indexOf("Posts ");
			timeString = pageSource.substring(a+11, b-1);	
		}

		photosCounter = Integer.parseInt(timeString);
		System.out.println(photosCounter);
	}

	static ArrayList<String> loader(ArrayList<String> codesList) throws Exception{
		
		timerSearch();
			
		for(int i = 0; i < photosCounter; i++) {
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
