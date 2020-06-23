# InstagramDownloader

## About me
This is just a test, one of my first projects and I'm still working on it.
I'm still learning how git works so probably there isn't anything really interesting here.

## About the Program
The initial idea is to download all the media content from a profile. If you are looking for a already done and full functional program that do this you should check the InstaLoader ( https://github.com/instaloader/instaloader.git ). I got the idea from them and their project is light-years ahead from mine. I'm just trying to do something that looks like their project without looking at their code and with a diferent language to see if I'm capable.
There is a lot of things I still have to do like downloading videos and downloading photos that are hidden in this little albums that instagram let you do.
The program is written in java and it is very simple. I didn't want to use the instagram API for a lot of reasons so every thing is done in a headless browser searching in the page source HTML. It's divided in a few parts.

### Part 1: Initialization
In the main class (App.java) i start the browser and go to a instagram profile.

### Part 2: Codes loader
In instagram feed we can go to a single photo page. Every photo in instagram has a code that leads to this page of that photo, it's something like this: /p/Bo-UptMlESU/. So if you go to instagram.com/p/Bo-UptMlESU/ you have that photo page. The idea of this part of the code is to search for all this codes in the HTML page and save it in a Array.

### Part 3: Search for the photo URL
Now with every photo code of that profile we can go in each page, search in that page for that photo link and save every link in a list. Something like this: https://instagram.fsdu8-2.fna.fbcdn.net/v/t51.2885-15/e35/43686656_152132442407995_5952106954367489511_n.jpg?_nc_ht=instagram.fsdu8-2.fna.fbcdn.net&amp;_nc_cat=107&amp;_nc_ohc=sdWTp0kzQjAAX8vMU4g&amp;oh=afb88659ea8e639135765a96c74a01e4&amp;oe=5F1BFF47

### Part 4: Prepare the link to download
For a reason that I don't know, when you save a page HTML every "&" will come with a "amp;" after it. This is bad because the original link doesn't have it so for each photo link we have to remove the "amp;"

### Part 5: Download
Now with every link of each photo we just have to download each one. Easy.


