package swing;

import javax.swing.*; 

import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JButton;

public class Translator extends JFrame implements ActionListener {
	
	public static final int WIDTH = 700; 
    public static final int HEIGHT = 300;
	private static final String COLOR_WHITE = null;
    
    public static JTextArea jt,jt2; 
	
	static JPanel jpanel;
	static JButton jbutton;
	static JFrame frame;
	
	
	Translator(){
		
	frame = new JFrame();
	jpanel = new JPanel();
	
		
	frame.setLocationRelativeTo(null);;
	frame.setSize(WIDTH,HEIGHT);
	frame.setTitle("Translate language");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(new FlowLayout( )); 
	
	 
	JLabel label1 = new JLabel("English");
    frame.add(label1);
    
    jt = new JTextArea("Type here",1,30);
    Font font = new Font("Courier New", Font.BOLD, 12);
    jt.setFont(font);
    jt.setForeground(Color.BLUE);
    jt.setLineWrap(true);
    JScrollPane scroll= new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    jpanel.add(scroll);
    jt.setWrapStyleWord(true);
    frame.add(jt);
    
  
    jbutton = new JButton("Translate");
    frame.add(jbutton);
    jbutton.addActionListener( this);
    jbutton.setToolTipText("Press it!");
  
    
    
    JLabel label2 = new JLabel("Pig Latin");
    frame.add(label2);
    
    jt2 = new JTextArea(1,30);
    jt2.setEditable(false);
    jt2.setLineWrap(true);
	jt2.setWrapStyleWord(true);
	jt2.setFont(font);
    jt2.setForeground(Color.RED);
    frame.add(jt2);
    
	
	
	frame.setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent e)
    {
	Scanner scan = new Scanner(jt.getText());
	String output = "";
	jt.grabFocus();

	while (scan.hasNext())
		output = output+ transformator(scan.next()) + " ";

	jt2.setText(output);
    }
	
	 

 
	
	public static String transformator (String inputWord)
	{
		
		
		String outWord="";    //cannot use null

		if (consonantCheck(inputWord.charAt(0)))   //if vowels it will just add "way" at the end
			outWord = inputWord + "way";
		else
		{
			for (int i=1; i<inputWord.length(); i++)     // if consonant it will take first character and drops it to the end plus add "ay" 
				outWord = outWord + inputWord.charAt(i);

			outWord = outWord + inputWord.charAt(0) + "ay";
		}

		return outWord;
	}

	public static boolean consonantCheck (char ch)
	{
		

	     if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' 
	    		 || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
	         return(true);
	     else
	         return(false);
		
	}
	
	public static void main(String[] args) {
		
		Translator tr = new Translator();
		tr.setVisible(true);
		
	}
	
}
