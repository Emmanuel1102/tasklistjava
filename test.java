import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.event.*;
public class test extends JFrame {
	
	static JTextArea area = new JTextArea();
	
	   static String line;
	   private static PrintStream standardOut;
	
	  
	public test() {
		
		
		JFrame ventana = new JFrame();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(700,700);
		
	//	area.setEditable(false);
		JScrollPane scroll = new JScrollPane(area);
		ventana.getContentPane().add(scroll, BorderLayout.CENTER);
		ventana.add(scroll);
	
		ventana.setVisible(true);
		
	 
       
	 
	}
	
	
	public static void mostrar() {
	PrintStream printStream = new PrintStream(new CustomOutputStream(area));
		
		  standardOut = System.out;
	         
	        // re-assigns standard output stream and error output stream
	        System.setOut(printStream);
	        System.setErr(printStream);
		
		  try
		    {
//			 
//			    System.out.println("Enter username");
//			    Scanner myObj = new Scanner(System.in); 
//			    String userName = myObj.nextLine(); 
			  JFrame f=new JFrame();  
			  
			  //poner tasklist,msinfo32,IPCONFIG,SYSTEMINFO, help en caso de windows
			  //poner "ps -ef" en caso de linux
			  String name=JOptionPane.showInputDialog(f,"INGRESA TU COMANDO");   
			  
			  String line;
		        Process p = Runtime.getRuntime().exec(name);
		        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		        while ((line = input.readLine()) != null)
		        {  
		        	///line.format(line, getOwnerlessWindows());
		        	//System.out.println("\n"+"            ");
		        	System.out.format("%-10s ", "\n");
		        	System.out.format("%-10s",line);
		        	//System.out.printf(" %1$s, %1$s, %2$s",line);
		        	
		        }
		        input.close();
		    }
		    catch (Exception err)
		    {
		        err.printStackTrace();
		    }
		
	}
	

	public static void main(String args[]) throws Exception
	{
		test prueba = new test();
	
		prueba.mostrar();
	}

}