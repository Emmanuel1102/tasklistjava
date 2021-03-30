import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class test extends JFrame {
	
	static JTextArea area = new JTextArea();
	
	   static String line;
	   private static PrintStream standardOut;
	
	  
	public test() {
		
		
		JFrame ventana = new JFrame();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(700,700);
		area.setEditable(false);
		JScrollPane scroll = new JScrollPane(area);
		ventana.getContentPane().add(scroll, BorderLayout.CENTER);
		ventana.add(scroll);
	
		ventana.setVisible(true);
		
	 
       
	 
	}
	
	
	public static void mostrar() {
	PrintStream printStream = new PrintStream(new CustomOutputStream(area));
		
		  standardOut = System.out;
	         
	       
	        System.setOut(printStream);
	        System.setErr(printStream);
		
		  try
		    {
 
			  JFrame f=new JFrame();  
			  
			  //poner en el joptionpane tasklist,msinfo32,IPCONFIG,SYSTEMINFO, help en caso de windows
			  //poner "ps -ef" en caso de linux
			  String name=JOptionPane.showInputDialog(f,"INGRESA TU COMANDO");   
			  
			  String line;
		        Process p = Runtime.getRuntime().exec(name);
		        BufferedReader input;
                         input = new BufferedReader(new InputStreamReader(p.getInputStream(),StandardCharsets.UTF_8));
                     
		        while ((line = input.readLine()) != null)
		        {  
                            
                                 
		        	System.out.format("%-10s ", "\n");
		        	System.out.format("%-10s",line);
		        	
		        	
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
