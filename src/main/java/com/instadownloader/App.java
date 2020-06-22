package com.instadownloader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
	
	public static WebDriver driver;
	public static JavascriptExecutor js;
	
    public static void main( String[] args ) throws Exception {
    	
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors", "--silent");    	
    	driver = new ChromeDriver(options);
    	
    	driver.get("https://instagram.com/ferfreits/");
    	
    	js = (JavascriptExecutor) driver;
    	
    	ArrayList<String> photoCodes = new ArrayList<String>();
    	ArrayList<String> photoLinks = new ArrayList<String>();
    	
    	CodesLoader.loader(photoCodes);
    	
    	for(String a : photoCodes) {
    		photoLinks.add(CodesConsumer.ampRemover(CodesConsumer.linkSearch(a)));
    	}
    	
    	int counter = 0;
    	for(String a :photoLinks) {
    		Downloader.download(a, counter);
    		counter++;

    	}
    } 
}
