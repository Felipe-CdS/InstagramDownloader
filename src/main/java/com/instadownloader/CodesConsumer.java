package com.instadownloader;

public class CodesConsumer {

	public static String linkSearch(String photoCode) {
		System.out.println("Loading...");
		
		App.driver.get("https://instagram.com" + photoCode);
		
		String pageSource = App.driver.getPageSource();
		
		int indexStart = (pageSource.indexOf("og:image") + 19);
		int indexEnd = (pageSource.indexOf("og:description") - 23);
		
		String photoLink = pageSource.substring(indexStart, indexEnd);
		
		return photoLink;
	}
	
	public static String ampRemover(String photoLinkWithAmp) {
		
		String temp = photoLinkWithAmp.replace("amp;", "");
		return temp;
	}
}
