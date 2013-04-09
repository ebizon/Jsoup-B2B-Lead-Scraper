package com.TweenTribneEmailScrapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClickToGet {
    public ClickToGet() {
	super();
    }

    public void fetchUrl(String container1, String url1, String dest) {
	String fileData = "";
	BufferedWriter bufferWritter = null;
	try {
	    String container = container1.trim();
	    String url = url1;
	    String destination = dest;

	    Document doc = org.jsoup.Jsoup.connect(url).timeout(10 * 1000).userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.65 Safari/535.11").get();

	    Elements links = doc.select(container + " a[href]");
	    print("\nLinks: (%d)", links.size());

	    try {
		for (Element link : links) {
		    print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
		    if (link.toString().contains("getEmail")) {
			String temp = link.toString().substring(link.toString().indexOf("('"), link.toString().indexOf("')")).replace("('", "");
			String temp1 = temp.replace("'", "");
			String params[] = temp1.split(",");
			fileData += getEmail(params[0], params[1], params[2]).concat("\n");
		    }
		}
		FileWriter fstream = new FileWriter(destination + "out.txt", true);
		bufferWritter = new BufferedWriter(fstream);
		bufferWritter.write(fileData);
	    } catch (Exception e) {
		System.err.println("Error: " + e.getMessage());
	    }
	} catch (Exception e) {
	    System.err.println("Error: " + e.getMessage());
	} finally {
	    try {
		bufferWritter.close();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    JLabel errorFields = new JLabel("<HTML><FONT COLOR = Blue>Success</FONT></HTML>");
	    JOptionPane.showMessageDialog(null, errorFields);
	}
    }

    private static void print(String msg, Object... args) {
	System.out.println(String.format(msg, args));
    }

    public String getEmail(String id, String user, String site) {

	String tempUser = "";

	int userCount = user.indexOf("*");
	user = user.substring(0, userCount);
	String reverse = new StringBuffer(user).reverse().toString();
	reverse = reverse + tempUser + '@' + site;
	return reverse;
    }

    private static String trim(String s, int width) {
	if (s.length() > width)
	    return s.substring(0, width - 1) + ".";
	else
	    return s;
    }
}