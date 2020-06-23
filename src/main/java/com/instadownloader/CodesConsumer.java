package com.instadownloader;

public class CodesConsumer {
	
	//In this method we inject the photo code, enter in that photo URL and 
	//search for the original photo link.
	public static String linkSearch(String photoCode) {
		System.out.println("Loading...");
		
		App.driver.get("https://instagram.com" + photoCode);
		
		String pageSource = App.driver.getPageSource();
		
		int indexStart = (pageSource.indexOf("og:image") + 19);
		int indexEnd = (pageSource.indexOf("og:description") - 23);
		
		String photoLink = pageSource.substring(indexStart, indexEnd);
		
		return photoLink;
	}
	
	
	//It looks like HTML needs to write amp; after every "&" and this breaks the URL.
	//This method removes every amp; from the original link making it usable.
	public static String ampRemover(String photoLinkWithAmp) {	
		String temp = photoLinkWithAmp.replace("amp;", "");
		return temp;
	}
}
