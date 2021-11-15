// Client side

// Abstract Window Toolkit
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
// API Toolkit
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JButton;
// Remote Method Invocation
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry ;
import java.util.Scanner;

public class GUI extends JFrame {
	public String info = "";
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	private JTextField textArea;
	public String input;
	Calculation objet;

	public GUI() {
		// Set title
		super("Remote Calculator");
		// Define window
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		input = "";
		// Create text box
		textArea = new JTextField(30);
		this.setLayout(new BorderLayout());
		this.getContentPane().add(textArea,BorderLayout.NORTH);
		// Create pannel
		JPanel pannel = new JPanel();
		this.getContentPane().add(pannel,BorderLayout.CENTER);
		pannel.setLayout(new GridLayout(4, 4));		
		// Create buttons
		String[] name = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "x", "0", "c", "=", "/", };
		for (int i=0;i<name.length;i++) {
			JButton button = new JButton(name[i]);
			pannel.add(button);
			button.addActionListener(new MyActionListener());
			button.setFont(new Font("Arial", Font.PLAIN, 40));  
			if (name[i] == "=" || name[i] == "c")
				button.setBackground(Color.gray);
			else if (name[i] == "+" || name[i] == "-" || name[i] == "x" || name[i] == "/")
				button.setBackground(Color.yellow);
			else button.setBackground(Color.white);
		}
		// We write on the client side
		System.out.println("Server ready.");
	}

	class MyActionListener implements ActionListener {
		public void actionPerformed (ActionEvent ev) {
			String actionCommand = ev.getActionCommand(); 
			if (actionCommand.equals("c"))
				//input = input.substring(0,input.length() - 1); // To remove one character
				input = ""; // To remove all
			else if(actionCommand.equals("+")
				||actionCommand.equals("-")
				||actionCommand.equals("x")
				||actionCommand.equals("/"))
				input += " " + actionCommand + " ";
			else if(actionCommand.equals("="))
				{
				info = input;

				try {
					Registry registry = LocateRegistry.getRegistry(1099);
					Calculation objet = (Calculation) registry.lookup("Remote_Calculator");
					String[] arguments = info.split(" ");
					int number1 = Integer.parseInt(arguments[0]);
					int number2 = Integer.parseInt(arguments[2]);
					char operation = arguments[1].charAt(0);
					
					input = objet.Calculation(number1, operation, number2);
											
				}catch(Exception e) {
					System.out.println("Exception from client : "+ e);
					input = "Error";
				}
			}
			else input = input + actionCommand;
			textArea.setText(input);
		}
	}

	public static void main (String[] args) {
			GUI window = new GUI();
			window.setVisible(true);
	}

}
