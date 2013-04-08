package com.TweenTribneEmailScrapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class OneLevelDeep {

	public OneLevelDeep() {
		super();
	}

	public void fetchUrl(String container1, String url1, String dest) {
		String fileData = "";
		BufferedWriter bufferWritter = null;
		try {
			String container = container1;
			String url = url1;
			String destination = dest;

			Document doc = org.jsoup.Jsoup.connect(url).timeout(10 * 1000)
					 .userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.65 Safari/535.11").get();
			Elements links = doc.select(container + " a[href]");
			print("\nLinks: (%d)", links.size());

			try {
				for (Element link : links) {
					print(" * a: <%s>  (%s)", link.attr("abs:href"),
							trim(link.text(), 35));
					boolean connected = false;
					int attempts = 0;
					while (!connected) {
						if (attempts++ == 1)
							break;
						try {
							org.jsoup.Connection connection = org.jsoup.Jsoup
									.connect(link.attr("abs:href")) .userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.65 Safari/535.11").timeout(
											10 * 1000);
							connection.followRedirects(false);
							org.jsoup.Connection.Response response = connection
									.execute();
							if (response.statusCode() == 200) {
								Document doc1 = connection.get();
								fileData += doc1.toString().concat("\n");

							}
						} catch (Exception ex) {
							System.out.println("Connection failure #"
									+ attempts + ": " + link);
							System.out.println(ex.getMessage());
						}
					}
				}
				FileWriter fstream = new FileWriter(destination + "out.txt",
						true);
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
			JLabel errorFields = new JLabel(
					"<HTML><FONT COLOR = Blue>Success</FONT></HTML>");
			JOptionPane.showMessageDialog(null, errorFields);
		}
	}

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