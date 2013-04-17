package com.TweenTribneEmailScrapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@SuppressWarnings("serial")
public class JSoupRecursive extends JFrame {

    public ArrayList<String> emailLink = new ArrayList<String>();
    private String fileData = "";
    private String nextPage = "";
    private String containUrl = "";

    public JSoupRecursive() {
	super();
    }

    public void fetchUrl(String container1, String url1, String destination1) {
	String a = "";
	String destination = "";
	String url = "";
	String nextpageTemp = "no";
	String container = "";
	BufferedWriter bufferWritter = null;
	try {
	    container = container1;
	    destination = destination1.trim();
	    if (nextPage != null && !nextPage.equals("")) {
		url = url1.trim() + "&" + nextPage;
		containUrl += nextPage + " ";
	    } else {
		url = url1.trim();
	    }
	    Document doc = org.jsoup.Jsoup.connect(url).timeout(1000 * 1000).userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.65 Safari/535.11").get();
	    Elements links = doc.select(container + " a[href]");
	    print("\nLinks: (%d)", links.size());

	    try {
		for (Element link : links) {
		    if (link.toString().contains("page=") && link.toString().contains(">Next")) {
			nextPage = link.toString();
			nextPage = nextPage.substring(nextPage.indexOf("page="), nextPage.indexOf(">Next")).replace("\"", "").trim();
			nextpageTemp = "yes";
		    }

		    if (link.toString().contains("mailto")) {
			a = link.toString();
			fileData += a.substring(a.indexOf("mailto:"), a.indexOf(">Email")).replace("mailto:", "").replace("\"", "").concat("\n");
		    }
		    print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
		}

	    } catch (Exception e) {
		nextpageTemp = "no";
		System.err.println("Error: " + e.getMessage());
	    }

	} catch (Exception e) {
	    nextpageTemp = "no";
	    System.err.println("Error: " + e.getMessage());
	} finally {
	    if (nextPage.equals("") || nextpageTemp.equals("no")) {
		try {
		    FileWriter fstream = new FileWriter(destination + "out.txt", true);
		    bufferWritter = new BufferedWriter(fstream);
		    bufferWritter.write(fileData);
		    bufferWritter.close();

		    JLabel errorFields = new JLabel("<HTML><FONT COLOR = Blue>Success</FONT></HTML>");
		    JOptionPane.showMessageDialog(null, errorFields);
		} catch (Exception e) {
		}
	    } else {
		fetchUrl(container, url, destination);
	    }
	}
    }

    // ////////////////////////////Method for Jsoup
    private static void print(String msg, Object... args) {
	System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
	if (s.length() > width)
	    return s.substring(0, width - 1) + ".";
	else
	    return s;
    }
}