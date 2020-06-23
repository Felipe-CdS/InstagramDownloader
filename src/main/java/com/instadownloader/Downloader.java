package com.instadownloader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

public class Downloader {

	public static void download(String link, int counter) throws Exception {
		System.out.println("Loading...");
		
		File imageFile = new File(counter + ".jpg");
		
		URL imageURL = new URL(link);
		
		BufferedImage image = ImageIO.read(imageURL);
		
		ImageIO.write(image, "jpg", imageFile);
	}
}
