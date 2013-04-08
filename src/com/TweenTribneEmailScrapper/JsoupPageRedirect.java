package com.TweenTribneEmailScrapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupPageRedirect {

	// Variables declaration
	public ArrayList<String> emailLink = new ArrayList<String>();

	String fileData = "";

	String nextPage = "";
	String containUrl = "";

	String a = "";

	// End of variables declaration

	public JsoupPageRedirect() {
		super();
		// create();

	}

	public void fetchUrl(String container1, String url1, String destination1) {
		String container = "";
		String destination = "";
		String url = "";
		String nextpageTemp = "";
		BufferedWriter bufferWritter = null;
		try {
			container = container1;

			destination = destination1.trim();
			if (nextPage != null && !nextPage.equals("")) {
				url = url1.trim() + "&&" + nextPage;
				// pageSet.add(nextPage);
				containUrl += nextPage + " ";
				// nextpageTemp = nextPage;
			} else {
				url = url1.trim();
				String[] urlString = url.split("/");
				nextpageTemp = urlString[0];
			}

			Document doc = org.jsoup.Jsoup.connect(url).timeout(1000 * 1000)
					.get();
			Elements links = doc.select(container + " a[href]");

			print("\nLinks: (%d)", links.size());

			try {
				for (Element link : links) {
					if (link.toString().contains(nextpageTemp)) {
						Document doc1 = org.jsoup.Jsoup
								.connect(link.attr("abs:href"))
								.timeout(1000 * 1000).get();
						Elements links1 = doc1.select(" a[href]");
						for (Element link1 : links1) {
							if (link1.toString().contains("mailto:")) {
								String a1 = link1.toString();
								if (a1.contains("title")) {
									fileData += a1
											.substring(a1.indexOf("mailto:"),
													a1.indexOf("title"))
											.replace("mailto:", "")
											.replace("\"", "").concat("\n");

								} else {
									fileData += a1
											.substring(a1.indexOf("mailto:"),
													a1.indexOf("\">"))
											.replace("mailto:", "")
											.concat("\n");
								}
							}

						}
					}

					print(" * a: <%s>  (%s)", link.attr("abs:href"),
							trim(link.text(), 35));

				}

			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {

			try {
				FileWriter fstream = new FileWriter(destination + "out.txt",
						true);
				bufferWritter = new BufferedWriter(fstream);
				bufferWritter.write(fileData);
				bufferWritter.close();

				JLabel errorFields = new JLabel(
						"<HTML><FONT COLOR = Blue>Success</FONT></HTML>");
				JOptionPane.showMessageDialog(null, errorFields);
			} catch (Exception e) {

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
