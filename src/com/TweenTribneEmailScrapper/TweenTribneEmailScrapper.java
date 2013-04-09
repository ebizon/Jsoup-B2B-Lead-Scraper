package com.TweenTribneEmailScrapper;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

@SuppressWarnings("serial")
public class TweenTribneEmailScrapper extends JFrame {
    // Variables declaration

    public ArrayList<String> emailLink = new ArrayList<String>();
    private JLabel labelContent, labelUrl, labelFileDest, labelSearch, labelSite, labelType, jLabelTitle;
    private JTextField jTextField1, jTextField2, jTextField3, jTextField4, jTextField5;
    private JLabel labelKey, labelValue;
    private JTextField key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7, key8, value8, key9, value9, key10, value10;
    private JButton jButton1,fetchbtn,exportbtn;
    private JPanel contentPane;
    private JComboBox selectTypeBox;
    private HashMap<String, String> hashMap = new HashMap<String, String>();
    private ArrayList<String> arrayList = new ArrayList<String>();
    // for second panel code starts here
    private JLabel jl1, jl2, jl3, jl4;
    private JTextField jtf1, jtf2, jtf3, jtf4;
    private JButton jb1;
    private JPanel jp1;
    private JCheckBox []cbox=new JCheckBox[20];
    //for second panel code end
    String fileData = "", typeString = "";
    String nextPage = "";
    String containUrl = "";
    String a = "";

    public TweenTribneEmailScrapper() {
        super();
        create();
        this.setVisible(true);
        this.setSize(500, 500);
    }

    private void create() {
        labelContent = new JLabel();
        labelUrl = new JLabel();
        labelFileDest = new JLabel();
        labelSearch = new JLabel();
        labelSite = new JLabel();
        labelType = new JLabel();
        labelKey = new JLabel();
        labelValue = new JLabel();

        jLabelTitle = new JLabel();
        String course[] = {"select type", "1 level deep", "click to getEmail", "profile", "recursive", "redirect", "1 level deep(post)", "click to getEmail(post)"};
        selectTypeBox = new JComboBox(course);
        selectTypeBox.setBackground(Color.CYAN);
        selectTypeBox.setForeground(Color.blue);
        selectTypeBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent paramActionEvent) {
                String type = (String) selectTypeBox.getSelectedItem();
                if (type.equalsIgnoreCase("1 level deep(post)")
                        || type.equalsIgnoreCase("click to getEmail(post)")) {
                    key1.setVisible(true);
                    value1.setVisible(true);
                    key2.setVisible(true);
                    value2.setVisible(true);
                    key3.setVisible(true);
                    value3.setVisible(true);
                    key4.setVisible(true);
                    value4.setVisible(true);
                    key5.setVisible(true);
                    value5.setVisible(true);
                    key6.setVisible(true);
                    value6.setVisible(true);
                    key7.setVisible(true);
                    value7.setVisible(true);
                    key8.setVisible(true);
                    value8.setVisible(true);
                    key9.setVisible(true);
                    value9.setVisible(true);
                    key10.setVisible(true);
                    value10.setVisible(true);
                    labelKey.setVisible(true);
                    labelValue.setVisible(true);
                } else {
                    key1.setVisible(false);
                    value1.setVisible(false);
                    key2.setVisible(false);
                    value2.setVisible(false);
                    key3.setVisible(false);
                    value3.setVisible(false);
                    key4.setVisible(false);
                    value4.setVisible(false);
                    key5.setVisible(false);
                    value5.setVisible(false);
                    key6.setVisible(false);
                    value6.setVisible(false);
                    key7.setVisible(false);
                    value7.setVisible(false);
                    key8.setVisible(false);
                    value8.setVisible(false);
                    key9.setVisible(false);
                    value9.setVisible(false);
                    key10.setVisible(false);
                    value10.setVisible(false);
                    labelKey.setVisible(false);
                    labelValue.setVisible(false);
                }
            }
        });

        //---start

        jl1 = new JLabel("Value 1 ");
        jl2 = new JLabel("Value 2 ");
        jl3 = new JLabel("Value 3 ");
        jl4 = new JLabel("Value 4 ");
        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);
        jtf3 = new JTextField(10);
        jtf4 = new JTextField(10);
        jb1 = new JButton("Press Me");
        jp1 = new JPanel();
        //---end
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        key1 = new JTextField();
        value1 = new JTextField();
        key2 = new JTextField();
        value2 = new JTextField();
        key3 = new JTextField();
        value3 = new JTextField();
        key4 = new JTextField();
        value4 = new JTextField();
        key5 = new JTextField();
        value5 = new JTextField();
        key6 = new JTextField();
        value6 = new JTextField();
        key7 = new JTextField();
        value7 = new JTextField();
        key8 = new JTextField();
        value8 = new JTextField();
        key9 = new JTextField();
        value9 = new JTextField();
        key10 = new JTextField();
        value10 = new JTextField();

        jButton1 = new JButton();
        contentPane = (JPanel) this.getContentPane();

        //labelContent.setHorizontalAlignment(SwingConstants.LEFT);
        //labelContent.setForeground(new Color(0, 0, 255));
        //labelContent.setText("Content:");

        labelUrl.setHorizontalAlignment(SwingConstants.LEFT);
        labelUrl.setForeground(new Color(0, 0, 255));
        labelUrl.setText("Search URL:");

        //labelSite.setHorizontalAlignment(SwingConstants.LEFT);
        //labelSite.setForeground(new Color(0, 0, 255));
        //labelSite.setText("Search Site:");

        labelSearch.setHorizontalAlignment(SwingConstants.LEFT);
        labelSearch.setForeground(new Color(0, 0, 255));
        labelSearch.setText("Search String:");

        //labelFileDest.setHorizontalAlignment(SwingConstants.LEFT);
        //labelFileDest.setForeground(new Color(0, 0, 255));
        //labelFileDest.setText("File Destination:");

        //labelType.setHorizontalAlignment(SwingConstants.LEFT);
        //labelType.setForeground(new Color(0, 0, 255));
        //labelType.setText("Type");

        //labelKey.setHorizontalAlignment(SwingConstants.LEFT);
        //labelKey.setForeground(new Color(0, 0, 255));
        //labelKey.setText("Key");
        //labelKey.setVisible(false);

        //labelValue.setHorizontalAlignment(SwingConstants.LEFT);
        //labelValue.setForeground(new Color(0, 0, 255));
        //labelValue.setText("Value");
        //labelValue.setVisible(false);

        //jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
// jLabelTitle.setForeground(Color.MAGENTA);
        //jLabelTitle.setText("Ebizon Email Scraper");
        //jLabelTitle.setFont(new Font("Serif", Font.BOLD, 15));

        //jTextField1.setForeground(new Color(0, 0, 255));
        //jTextField1.setSelectedTextColor(new Color(0, 0, 255));
        //jTextField1.setToolTipText("Enter your Container");

        jTextField2.setForeground(new Color(0, 0, 255));
        jTextField2.setToolTipText("Enter your URL");

        //jTextField3.setForeground(new Color(0, 0, 255));
        //jTextField3.setToolTipText("Enter your Destination file path");

       // key1.setForeground(new Color(0, 0, 255));
        //key1.setToolTipText("key1");
        //key1.setVisible(false);

        //value1.setForeground(new Color(0, 0, 255));
        //value1.setToolTipText("value1");
        //value1.setVisible(false);

        //key2.setForeground(new Color(0, 0, 255));
        //key2.setToolTipText("key2");
        //key2.setVisible(false);

        /*value2.setForeground(new Color(0, 0, 255));
        value2.setToolTipText("value2");
        value2.setVisible(false);

        key3.setForeground(new Color(0, 0, 255));
        key3.setToolTipText("key3");
        key3.setVisible(false);

        value3.setForeground(new Color(0, 0, 255));
        value3.setToolTipText("value3");
        value3.setVisible(false);

        key4.setForeground(new Color(0, 0, 255));
        key4.setToolTipText("key4");
        key4.setVisible(false);

        value4.setForeground(new Color(0, 0, 255));
        value4.setToolTipText("value4");
        value4.setVisible(false);

        key5.setForeground(new Color(0, 0, 255));
        key5.setToolTipText("key5");
        key5.setVisible(false);

        value5.setForeground(new Color(0, 0, 255));
        value5.setToolTipText("value5");
        value5.setVisible(false);

        key6.setForeground(new Color(0, 0, 255));
        key6.setToolTipText("key6");
        key6.setVisible(false);

        value6.setForeground(new Color(0, 0, 255));
        value6.setToolTipText("value6");
        value6.setVisible(false);
        key7.setForeground(new Color(0, 0, 255));
        key7.setToolTipText("key7");
        key7.setVisible(false);

        value7.setForeground(new Color(0, 0, 255));
        value7.setToolTipText("value7");
        value7.setVisible(false);
        key8.setForeground(new Color(0, 0, 255));
        key8.setToolTipText("key8");
        key8.setVisible(false);

        value8.setForeground(new Color(0, 0, 255));
        value8.setToolTipText("value8");
        value8.setVisible(false);
        key9.setForeground(new Color(0, 0, 255));
        key9.setToolTipText("key9");
        key9.setVisible(false);

        value9.setForeground(new Color(0, 0, 255));
        value9.setToolTipText("value9");
        value9.setVisible(false);
        key10.setForeground(new Color(0, 0, 255));
        key10.setToolTipText("key10");
        key10.setVisible(false);

        value10.setForeground(new Color(0, 0, 255));
        value10.setToolTipText("value10");
        value10.setVisible(false);*/
        jButton1.setBackground(new Color(204, 204, 204));
        jButton1.setForeground(new Color(0, 0, 255));
        jButton1.setText("Enter");
        jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
//String msg=jTextField1.getText()+" // "+jTextField2.getText()+" // "+jTextField3.getText()+" // "+jTextField4.getText()+" // "+jTextField5.getText();
                //              JOptionPane.showMessageDialog(null, msg, "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
                //              jButton1_actionPerformed(e);
                jButton1_actionPerformed(e);

            }
        });
// contentPane

        contentPane.setLayout(null);
        contentPane.setBorder(BorderFactory.createEtchedBorder());
        contentPane.setBackground(new Color(204, 204, 204));
        //addComponent(contentPane, jLabelTitle, 85, 5, 206, 35);
        //addComponent(contentPane, labelContent, 45, 40, 106, 18);
        addComponent(contentPane, labelUrl, 65, 77, 97, 18);
        //addComponent(contentPane, labelSite, 45, 114, 106, 18);
        addComponent(contentPane, labelSearch, 65, 150, 130, 18);
        //addComponent(contentPane, labelFileDest, 45, 185, 130, 18);
        //addComponent(contentPane, labelType, 45, 225, 106, 18);
        //addComponent(contentPane, jTextField1, 165, 40, 183, 22);
        addComponent(contentPane, jTextField2, 185, 75, 183, 22);

        //addComponent(contentPane, jTextField5, 165, 110, 183, 22);
        addComponent(contentPane, jTextField4, 185, 145, 183, 22);
        //addComponent(contentPane, jTextField3, 165, 180, 183, 22);

        //addComponent(contentPane, labelKey, 150, 150, 183, 22);
        //addComponent(contentPane, labelValue, 350, 150, 183, 22);
        //addComponent(contentPane, key1, 150, 190, 183, 22);
        //addComponent(contentPane, value1, 350, 190, 183, 22);
        //addComponent(contentPane, key2, 150, 230, 183, 22);
        //addComponent(contentPane, value2, 350, 230, 183, 22);
        //addComponent(contentPane, key3, 150, 270, 183, 22);
        //addComponent(contentPane, value3, 350, 270, 183, 22);
        //addComponent(contentPane, key4, 150, 310, 183, 22);
        //addComponent(contentPane, value4, 350, 310, 183, 22);
        //addComponent(contentPane, key5, 150, 350, 183, 22);
        //addComponent(contentPane, value5, 350, 350, 183, 22);
        //addComponent(contentPane, key6, 150, 390, 183, 22);
        //addComponent(contentPane, value6, 350, 390, 183, 22);
        //addComponent(contentPane, key7, 150, 430, 183, 22);
        //addComponent(contentPane, value7, 350, 430, 183, 22);
        //addComponent(contentPane, key8, 150, 470, 183, 22);
        //addComponent(contentPane, value8, 350, 470, 183, 22);
        //addComponent(contentPane, key9, 150, 510, 183, 22);
        //addComponent(contentPane, value9, 350, 510, 183, 22);
        //addComponent(contentPane, key10, 150, 550, 183, 22);
        //addComponent(contentPane, value10, 350, 550, 183, 22);
        //addComponent(contentPane, selectTypeBox, 165, 225, 150, 30);
        addComponent(contentPane, jButton1, 195, 275, 83, 28);

        this.setTitle("Java Scraping Tool");
        this.setLocation(new Point(300, 30));
        this.setSize(new Dimension(700, 700));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    /** Add Component Without a Layout Manager (Absolute Positioning) */
    private void addComponent(Container container, Component c, int x, int y, int width, int height) {
        c.setBounds(x, y, width, height);
        container.add(c);
    }

    private void jButton1_actionPerformed(ActionEvent e) {
       // typeString = (String) selectTypeBox.getSelectedItem();
        //String container = new String(jTextField1.getText());
        String url = new String(jTextField2.getText());
        
        //String destination = new String(jTextField3.getText());
        //String item = (String) selectTypeBox.getSelectedItem();
        String searchstring = new String(jTextField4.getText());
        searchstring+="(site:linkedin.com/pub OR site:linkedin.com/in) -\"pub/dir\"";
        //String searchsite = new String(jTextField5.getText());
        String final_serachurl = url + "/search?q=" + URLEncoder.encode(searchstring);
/*
        if (container.equals("") || url.equals("") || destination.equals("") || searchstring.equals("") || searchsite.equals("")) {
            jButton1.setEnabled(false);
            JLabel errorFields = new JLabel("<HTML><FONT COLOR = Blue>You must enter all blank fields.</FONT></HTML>");
            JOptionPane.showMessageDialog(null, errorFields);
            jButton1.setEnabled(true);
            this.setVisible(true);
        } else if (item.equals("select type")) {
            */ 
        if(url.equals("")||searchstring.equals(""))
        {
        jButton1.setEnabled(false);
            JLabel errorFields = new JLabel("<HTML><FONT COLOR = Blue>You must enter all blank fields.</FONT></HTML>");
            JOptionPane.showMessageDialog(null, errorFields);
            jButton1.setEnabled(true);
            this.setVisible(true);
        }
        else
        {
        try {
                
                int i,total_item=0,total,serialn;
                String Cname[]=new String[12];
                Document doc;
                 
                //doc = Jsoup.connect("http://google.com/search?q=rajcomics").userAgent("Mozilla").get();
                doc = Jsoup.connect(final_serachurl).userAgent("Mozilla").get();
                //doc = Jsoup.connect("http://google.com").userAgent("Mozilla").get();
                //String title = doc.title();
                //System.out.println("title : " + title);
                Elements links = doc.select("a[href]");
                System.out.println("Total = "+links.size());
                total_item=links.size();
                
                
                String name="";
                
                fetchbtn=new JButton(" Fetch E-Mail ");
                exportbtn=new JButton(" Export ");
                  fetchbtn.setBounds(150,550,150,25);
                
                JLabel label[]=new JLabel[total_item];
               // cbox=new JCheckBox[20];
                i=0;total=0;serialn=0;
                 jp1.setLayout(null);
               String str1,str2="";
                for (Element link : links) {
                //Get the value from href attribute
                    if(link.text().equalsIgnoreCase("Similar"))
                        break;
                    if(i>=37 && !link.text().equalsIgnoreCase("Cached"))
                    {
                        str2="";
                     // label[serialn]=new JLabel();
                      cbox[serialn]=new JCheckBox();
                      str1=link.text();
                      for(int j=0;j<str1.length();j++)
                      {
                          if(str1.charAt(j)=='-'||str1.charAt(j)=='|')
                              break;
                          str2+=str1.charAt(j);
                      }
                      //label[i-37].setText(str2); //link.text());
                      Cname[total]=str2;
                      total++;
                      //label[i-37].setBounds(100,50+(25*(i-37)),200,20);
                      cbox[serialn].setBounds(50, 50+(25*(i-37)), 250, 20);
                      cbox[serialn].setText(str2);
                      jp1.add(cbox[serialn]);
                      //jp1.add(label[i-37]);
                      if(serialn==10)
                          break;
                      serialn++;
                      
                    } i++;
                }
                    
                    exportbtn.setBounds(350,550,100,25);
                exportbtn.addActionListener(
                        
                                                new ActionListener() 
                                                {

                                                   public void actionPerformed(ActionEvent paramActionEvent) 
                                                   {

                                                       //.xlsx creation starts here
                                                      try
                                                      {
                                                       Workbook wb = null;
		//System.out.print("Type xlsx i.e 2007+ if u wan2 create xlsx file (default xls) => ");
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
                String location=JOptionPane.showInputDialog(null, "Enter File URL.","",1);
                                                                                    
                String xlsx = "xls";
		if (xlsx.equalsIgnoreCase("xlsx"))
			wb = new XSSFWorkbook();
		else
			wb = new HSSFWorkbook();

		Sheet sheet = wb.createSheet("Email Scrapper");
                int k=1;
		// row numbering starts from 0
		Row row[]=new Row[12];
                Cell cell[]=new Cell[12];
                //Cell cell;
                for(int z=0;z<10;z++)
                {
                    if(cbox[z].isSelected() && !cbox[z].getText().isEmpty())
                    {
                        
                   row[k] = sheet.createRow((short) k);
		   cell[k] = row[k].createCell(0);
		   cell[k].setCellValue(cbox[z].getText());
                    /*
                        Row row = sheet.createRow((short) 1);
		Cell cell = row.createCell(0);
		cell.setCellValue("SHIVA");
*/
                        k++;
                    }
                }
                
		String excelFileName = "EmailScrapperContacts.xls";
		if (wb instanceof XSSFWorkbook)
			excelFileName += "x";
                //java.io.File fs =new java.io.File("c:\")
		FileOutputStream fos = new FileOutputStream(location+"/"+excelFileName);
		wb.write(fos);
		fos.flush();
		fos.close();
                                              
                                                       JOptionPane.showMessageDialog(null, "File has been exported.");
                                                      }
                                                      catch(Exception exc)
                                                      {
                                                  JOptionPane.showMessageDialog(null, "Export Fails : "+exc.getMessage());
                                                          
                                                      }
                                                       
                                                       
                                                       
                                                       //.xlsx creation ends here
        
                                                   }
                                                }
                                            );
               
                    
                    
                    
                    jp1.add(fetchbtn);
                    jp1.add(exportbtn);
                   // name += link.text()+"\n";
                   // System.out.println("\nlink : " + link.attr("href"));
                    //System.out.println("text : " + link.text());
                    //i++;
                //}
                //System.out.println("Total 2 = "+total_item);
                this.setVisible(false);
                contentPane = (JPanel) this.getContentPane();
                this.remove(contentPane);
               /* jl1.setBounds(10, 10, 50, 20);
                jl1.setText(name);
                jl2.setBounds(10, 40, 50, 20);
                jl3.setBounds(10, 70, 50, 20);
                jl4.setBounds(10, 100, 50, 20);
                jtf1.setBounds(100, 10, 50, 20);
                jtf2.setBounds(100, 40, 50, 20);
                jtf3.setBounds(100, 50, 50, 20);
                jtf4.setBounds(100, 100, 50, 20);
                jb1.setBounds(50, 130, 20, 20);
                jp1.add(jl1);
                jp1.add(jl2);
                jp1.add(jl3);
                jp1.add(jl4);
                jp1.add(jtf1);
                jp1.add(jtf2);
                jp1.add(jtf3);
                jp1.add(jtf4);
                jp1.add(jb1); */
                this.setVisible(false);
                JFrame jf1 = new JFrame();
                jf1.add(jp1);
                jf1.setVisible(true);

                jf1.setTitle("Tween Tribne E-mail Scrapper Tool");
                jf1.setLocation(new Point(300, 30));
                jf1.setSize(new Dimension(600, 650));
                jf1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//this.setResizable(true);
                //org.jsoup.Connection conn=null;
                //try
                //{
                //conn=Jsoup.connect("http://www.exchangeandmart.co.uk/used-cars-for-sale");
                //}
                //catch(Exception ex2)
                //{
                //JOptionPane.showMessageDialog(null,"Error 123 : "+ex2.getMessage());
                //}
                //try
                //{
                //doc = conn.post();   //Jsoup.connect("http://www.google.com/")
                //}
                //catch(Exception exx)
                //{
                //JOptionPane.showMessageDialog(null,"Error 3 : "+exx.getMessage());
                //}
                //.userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                //          .timeout(10000)
                //        .get();

                //Elements element = doc.select("a");
//String title = doc.title();

                //Document doc1 = Jsoup.connect("http://www.google.com/search?q=hello").get();
                //String st=(String) doc1.toString();
                //  Document doc2 = Jsoup.parse(st);
                //Elements newsHeadlines1 = doc.select("title");

                //JOptionPane.showMessageDialog(null, doc); //+"// "+title+" //  "+element);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error  :  " + ex.getMessage());
            }
        }
        /*
        else if (item.equals("click to getEmail")) {
        ClickToGet clicktoget = new ClickToGet();
        clicktoget.fetchUrl(container, url, destination);
        } else if (item.equals("profile")) {
        JsoupProfile jsoup2 = new JsoupProfile();
        jsoup2.fetchUrl(container, url, destination);
        } else if (item.equals("recursive")) {
        JSoupRecursive jsoup = new JSoupRecursive();
        jsoup.fetchUrl(container, url, destination);
        } else if (item.equals("redirect")) {
        JsoupPageRedirect jsoup1 = new JsoupPageRedirect();
        jsoup1.fetchUrl(container, url, destination);
        } else if (item.equals("1 level deep")) {
        OneLevelDeep jsoup1 = new OneLevelDeep();
        jsoup1.fetchUrl(container, url, destination);
        } else if (item.equalsIgnoreCase("1 level deep(post)")) {
        getValues();
        oneLevelDeepPost(container, url, destination);
        } else if (item.equalsIgnoreCase("click to getEmail(post)")) {
        getValues();
        clickToGetPost(container, url, destination);
        }
         *
         */
    }
    /* private void jButton1_actionPerformed_new(ActionEvent e) {
    typeString = (String) selectTypeBox.getSelectedItem();
    System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
    String container = new String(jTextField1.getText());
    String url = new String(jTextField2.getText());
    String destination = new String(jTextField3.getText());
    String item = (String) selectTypeBox.getSelectedItem();
    String searchstring = new String(jTextField4.getText());
    String searchsite = new String(jTextField5.getText());

    //Implementation of google search api.
    String final_serachurl = url+"/search?q="+searchstring;
    //Document doc = Jsoup.connect(url).get();
    ///Elements links = doc.select("a[href]");
    //Elements media = doc.select("[src]");
    //Elements imports = doc.select("link[href]");

    clickToGetPost(container, final_serachurl, destination);

    //JLabel errorFields123 = new JLabel(final_serachurl);
    //JOptionPane.showMessageDialog(null, errorFields123);

    if (container.equals("") || url.equals("") || destination.equals("") || item.equals("select type") || searchstring.equals("select type") || searchsite.equals("select type")) {
    //jButton1.setEnabled(false);
    //JLabel errorFields = new JLabel("<HTML><FONT COLOR = Blue>You must enter all blank fields.</FONT></HTML>");
    //JOptionPane.showMessageDialog(null, errorFields);
    //jButton1.setEnabled(true);
    //this.setVisible(true);
    } else if (item.equals("click to getEmail")) {
    ClickToGet clicktoget = new ClickToGet();
    clicktoget.fetchUrl(container, url, destination);
    } else if (item.equals("profile")) {
    JsoupProfile jsoup2 = new JsoupProfile();
    jsoup2.fetchUrl(container, url, destination);
    } else if (item.equals("recursive")) {
    JSoupRecursive jsoup = new JSoupRecursive();
    jsoup.fetchUrl(container, url, destination);
    } else if (item.equals("redirect")) {
    JsoupPageRedirect jsoup1 = new JsoupPageRedirect();
    jsoup1.fetchUrl(container, url, destination);
    } else if (item.equals("1 level deep")) {
    OneLevelDeep jsoup1 = new OneLevelDeep();
    jsoup1.fetchUrl(container, url, destination);
    } else if (item.equalsIgnoreCase("1 level deep(post)")) {
    getValues();
    oneLevelDeepPost(container, url, destination);
    } else if (item.equalsIgnoreCase("click to getEmail(post)")) {
    getValues();
    clickToGetPost(container, url, destination);
    }
    }*/

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            System.out.println("Failed loading L&F: ");
            System.out.println(ex);
        }
        new TweenTribneEmailScrapper();
    }

    ;

    public void actionPerformed(ActionEvent arg0) {
    }

    public void clickToGetPost(String container1, String url1, String dest) {
        String fileData = "";
        BufferedWriter bufferWritter = null;
        try {
            String container = container1.trim();
            String url = url1;
            String destination = dest;



            Document doc = postUrl(url);
            Elements links = doc.select(container + " a[href]");

            //JLabel errorFields123 = new JLabel(destination);
            //JOptionPane.showMessageDialog(null, errorFields123);

            print("\nLinks: (%d)", links.size());
            //System.out.println(links);

            try {
                for (Element link : links) {
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
                e.printStackTrace();
            }
            JLabel errorFields = new JLabel("<HTML><FONT COLOR = Blue>Success</FONT></HTML>");
            JOptionPane.showMessageDialog(null, errorFields);

        }
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private void getValues() {
        String paramKey1 = key1.getText().trim();
        String paramValue1 = value1.getText().trim();
        String paramKey2 = key2.getText().trim();
        String paramValue2 = value2.getText().trim();
        String paramKey3 = key3.getText().trim();
        String paramValue3 = value3.getText().trim();
        String paramKey4 = key4.getText().trim();
        String paramValue4 = value4.getText().trim();
        String paramKey5 = key5.getText().trim();
        String paramValue5 = value5.getText().trim();
        String paramKey6 = key6.getText().trim();
        String paramValue6 = value6.getText().trim();
        String paramKey7 = key7.getText().trim();
        String paramValue7 = value7.getText().trim();
        String paramKey8 = key8.getText().trim();
        String paramValue8 = value8.getText().trim();
        String paramKey9 = key9.getText().trim();
        String paramValue9 = value9.getText().trim();
        String paramKey10 = key10.getText().trim();
        String paramValue10 = value10.getText().trim();



        if (!paramKey1.equalsIgnoreCase("")) {
            arrayList.add(paramKey1);
        }
        if (!paramKey2.equalsIgnoreCase("")) {
            arrayList.add(paramKey2);
        }
        if (!paramKey3.equalsIgnoreCase("")) {
            arrayList.add(paramKey3);
        }
        if (!paramKey4.equalsIgnoreCase("")) {
            arrayList.add(paramKey4);
        }
        if (!paramKey5.equalsIgnoreCase("")) {
            arrayList.add(paramKey5);
        }
        if (!paramKey6.equalsIgnoreCase("")) {
            arrayList.add(paramKey6);
        }
        if (!paramKey7.equalsIgnoreCase("")) {
            arrayList.add(paramKey7);
        }
        if (!paramKey8.equalsIgnoreCase("")) {
            arrayList.add(paramKey8);
        }
        if (!paramKey9.equalsIgnoreCase("")) {
            arrayList.add(paramKey9);
        }
        if (!paramKey10.equalsIgnoreCase("")) {
            arrayList.add(paramKey10);
        }
        for (int i = 0; i <= arrayList.size() - 1; i++) {
            if (i == 0) {
                hashMap.put(arrayList.get(i), paramValue1);
            }
            if (i == 1) {
                hashMap.put(arrayList.get(i), paramValue2);
            }
            if (i == 2) {
                hashMap.put(arrayList.get(i), paramValue3);
            }
            if (i == 3) {
                hashMap.put(arrayList.get(i), paramValue4);
            }
            if (i == 4) {
                hashMap.put(arrayList.get(i), paramValue5);
            }
            if (i == 5) {
                hashMap.put(arrayList.get(i), paramValue6);
            }
            if (i == 6) {
                hashMap.put(arrayList.get(i), paramValue7);
            }
            if (i == 7) {
                hashMap.put(arrayList.get(i), paramValue8);
            }
            if (i == 8) {
                hashMap.put(arrayList.get(i), paramValue9);
            }
            if (i == 9) {
                hashMap.put(arrayList.get(i), paramValue10);
            }
        }
    }

    public String getEmail(String id, String user, String site) {
        String tempUser = "";
        int userCount = user.indexOf("*");
        user = user.substring(0, userCount);
        String reverse = new StringBuffer(user).reverse().toString();
        reverse = reverse + tempUser + '@' + site;
        return reverse;
    }

    public void oneLevelDeepPost(String container1, String url1, String dest) {
        String fileData = "";
        BufferedWriter bufferWritter = null;
        try {
            String container = container1;
            String url = url1;
            String destination = dest;

            Document doc = postUrl(url);
            Elements links = doc.select(container + " a[href]");
            print("\nLinks: (%d)", links.size());

            try {
                for (Element link : links) {
                    boolean connected = false;
                    int attempts = 0;
                    while (!connected) {
                        if (attempts++ == 1) {
                            break;
                        }
                        try {
                            org.jsoup.Connection connection = org.jsoup.Jsoup.connect(link.attr("abs:href")).timeout(10 * 1000);
                            connection.followRedirects(false);
                            org.jsoup.Connection.Response response = connection.execute();
                            if (response.statusCode() == 200) {
                                Document doc1 = connection.get();
                                fileData += doc1.toString().concat("\n");

                            }
                        } catch (Exception ex) {
                            System.out.println("Connection failure #" + attempts + ": " + link);
                            System.out.println(ex.getMessage());
                        }
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
                e.printStackTrace();
            }
            JLabel errorFields = new JLabel("<HTML><FONT COLOR = Blue>Success</FONT></HTML>");
            JOptionPane.showMessageDialog(null, errorFields);
        }
    }

    public Document postUrl(String url) {
        int sizeOfData = arrayList.size();
        Document doc = null;
        try {
            if (sizeOfData == 1) {
                doc = org.jsoup.Jsoup.connect(url).timeout(10 * 1000).userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.65 Safari/535.11").data(arrayList.get(0), hashMap.get(arrayList.get(0))).post();
            }
            if (sizeOfData == 2) {
                doc = org.jsoup.Jsoup.connect(url).timeout(10 * 1000).userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.65 Safari/535.11").data(arrayList.get(0), hashMap.get(arrayList.get(0))).data(arrayList.get(1), hashMap.get(arrayList.get(1))).post();
            }
            if (sizeOfData == 3) {
                doc = org.jsoup.Jsoup.connect(url).timeout(10 * 1000).userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.65 Safari/535.11").data(arrayList.get(0), hashMap.get(arrayList.get(0))).data(arrayList.get(1), hashMap.get(arrayList.get(1))).data(arrayList.get(2), hashMap.get(arrayList.get(2))).post();
            }
            if (sizeOfData == 4) {
                doc = org.jsoup.Jsoup.connect(url).timeout(10 * 1000).userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.65 Safari/535.11").data(arrayList.get(0), hashMap.get(arrayList.get(0))).data(arrayList.get(1), hashMap.get(arrayList.get(1))).data(arrayList.get(2), hashMap.get(arrayList.get(2))).data(arrayList.get(3), hashMap.get(arrayList.get(3))).post();
            }
            if (sizeOfData == 5) {
                doc = org.jsoup.Jsoup.connect(url).timeout(10 * 1000).userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.65 Safari/535.11").data(arrayList.get(0), hashMap.get(arrayList.get(0))).data(arrayList.get(1), hashMap.get(arrayList.get(1))).data(arrayList.get(2), hashMap.get(arrayList.get(2))).data(arrayList.get(3), hashMap.get(arrayList.get(3))).data(arrayList.get(4), hashMap.get(arrayList.get(4))).post();
            }
            if (sizeOfData == 6) {
                doc = org.jsoup.Jsoup.connect(url).timeout(10 * 1000).userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.65 Safari/535.11").data(arrayList.get(0), hashMap.get(arrayList.get(0))).data(arrayList.get(1), hashMap.get(arrayList.get(1))).data(arrayList.get(2), hashMap.get(arrayList.get(2))).data(arrayList.get(3), hashMap.get(arrayList.get(3))).data(arrayList.get(4), hashMap.get(arrayList.get(4))).data(arrayList.get(5), hashMap.get(arrayList.get(5))).post();
            }
            if (sizeOfData == 6) {
                doc = org.jsoup.Jsoup.connect(url).timeout(10 * 1000).userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.65 Safari/535.11").data(arrayList.get(0), hashMap.get(arrayList.get(0))).data(arrayList.get(1), hashMap.get(arrayList.get(1))).data(arrayList.get(2), hashMap.get(arrayList.get(2))).data(arrayList.get(3), hashMap.get(arrayList.get(3))).data(arrayList.get(4), hashMap.get(arrayList.get(4))).data(arrayList.get(5), hashMap.get(arrayList.get(5))).post();
            }
            if (sizeOfData == 7) {
                doc = org.jsoup.Jsoup.connect(url).timeout(10 * 1000).userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.65 Safari/535.11").data(arrayList.get(0), hashMap.get(arrayList.get(0))).data(arrayList.get(1), hashMap.get(arrayList.get(1))).data(arrayList.get(2), hashMap.get(arrayList.get(2))).data(arrayList.get(3), hashMap.get(arrayList.get(3))).data(arrayList.get(4), hashMap.get(arrayList.get(4))).data(arrayList.get(5), hashMap.get(arrayList.get(5))).data(arrayList.get(5), hashMap.get(arrayList.get(5))).data(arrayList.get(6), hashMap.get(arrayList.get(6))).post();
            }
            if (sizeOfData == 8) {
                doc = org.jsoup.Jsoup.connect(url).timeout(10 * 1000).userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.65 Safari/535.11").data(arrayList.get(0), hashMap.get(arrayList.get(0))).data(arrayList.get(1), hashMap.get(arrayList.get(1))).data(arrayList.get(2), hashMap.get(arrayList.get(2))).data(arrayList.get(3), hashMap.get(arrayList.get(3))).data(arrayList.get(4), hashMap.get(arrayList.get(4))).data(arrayList.get(5), hashMap.get(arrayList.get(5))).data(arrayList.get(6), hashMap.get(arrayList.get(6))).data(arrayList.get(7), hashMap.get(arrayList.get(7))).post();
            }
            if (sizeOfData == 9) {
                doc = org.jsoup.Jsoup.connect(url).timeout(10 * 1000).userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.65 Safari/535.11").data(arrayList.get(0), hashMap.get(arrayList.get(0))).data(arrayList.get(1), hashMap.get(arrayList.get(1))).data(arrayList.get(2), hashMap.get(arrayList.get(2))).data(arrayList.get(3), hashMap.get(arrayList.get(3))).data(arrayList.get(4), hashMap.get(arrayList.get(4))).data(arrayList.get(5), hashMap.get(arrayList.get(5))).data(arrayList.get(6), hashMap.get(arrayList.get(6))).data(arrayList.get(7), hashMap.get(arrayList.get(7))).data(arrayList.get(8), hashMap.get(arrayList.get(8))).post();
            }
            if (sizeOfData == 10) {
                doc = org.jsoup.Jsoup.connect(url).timeout(10 * 1000).userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.65 Safari/535.11").data(arrayList.get(0), hashMap.get(arrayList.get(0))).data(arrayList.get(1), hashMap.get(arrayList.get(1))).data(arrayList.get(2), hashMap.get(arrayList.get(2))).data(arrayList.get(3), hashMap.get(arrayList.get(3))).data(arrayList.get(4), hashMap.get(arrayList.get(4))).data(arrayList.get(5), hashMap.get(arrayList.get(5))).data(arrayList.get(6), hashMap.get(arrayList.get(6))).data(arrayList.get(7), hashMap.get(arrayList.get(7))).data(arrayList.get(8), hashMap.get(arrayList.get(8))).data(arrayList.get(9), hashMap.get(arrayList.get(9))).post();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }
}
