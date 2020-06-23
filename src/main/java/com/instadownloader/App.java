package com.instadownloader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
	
	public static WebDriver driver;
	public static JavascriptExecutor js;
	
    public static void main( String[] args ) throws Exception {
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter the profile name: ");
    	String profile = sc.nextLine();

    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors", "--silent");    	
    	driver = new ChromeDriver(options);
    	
    	driver.get("https://instagram.com/" + profile + "/?hl=en");
    	
    	if(driver.getTitle().contains("Page Not Found")) {
    		System.out.println("Profile not found. Closing the program.");
    		System.exit(1);
    	}
    	
    	js = (JavascriptExecutor) driver;
    	
    	ArrayList<String> photoCodes = new ArrayList<String>();
    	ArrayList<String> photoLinks = new ArrayList<String>();
    	
    	
    	//loading the photoCodes list
    	CodesLoader.loader(photoCodes);
    	
    	//Removing "amp;" from the links
    	for(String a : photoCodes) {
    		photoLinks.add(CodesConsumer.ampRemover(CodesConsumer.linkSearch(a)));
    	}

    	//Downloading
    	for(int counter = 0; counter < photoLinks.size(); counter++) {
    		Downloader.download(photoLinks.get(counter), counter);
    	}
    	
    	System.out.println("Done");
    	
    } 
}
