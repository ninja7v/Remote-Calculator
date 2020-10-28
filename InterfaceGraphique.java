//interface methodes
import java.awt.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.*;

//rmi methodes
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry ;
import java.util.Scanner;

public class InterfaceGraphique extends JFrame 
{
	public String info = "";
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;
	private JTextField textArea;
	public String input;
	Calcul objet;

	public InterfaceGraphique()
	{
		super("Calculatrice");
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		input = "";
		textArea = new JTextField(30);
		this.setLayout(new BorderLayout());
		this.getContentPane().add(textArea,BorderLayout.NORTH);

		JPanel pannel = new JPanel();
		this.getContentPane().add(pannel,BorderLayout.CENTER);
		pannel.setLayout(new GridLayout(4, 4));		
		
		String[] name = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "C", "=", "/", };
		for (int i=0;i<name.length;i++)
		{
			JButton button = new JButton(name[i]);
			//button.addActionListener(this);
			pannel.add(button);
			button.addActionListener(new MyActionListener());
			button.setBackground(Color.yellow);
		}

	}

class MyActionListener implements ActionListener
{
	public void actionPerformed (ActionEvent ev)
		{
		String actionCommand = ev.getActionCommand(); 
		if (actionCommand.equals("C"))
		{
			input = input.substring(0,input.length() - 1);
		}
		else if(actionCommand.equals("+")
			||actionCommand.equals("-")
			||actionCommand.equals("*")
			||actionCommand.equals("/"))
		{
		input += " " + actionCommand + " ";
			}
		else if(actionCommand.equals("="))
			{
			info = input;

			try {
				Registry registry = LocateRegistry.getRegistry(1099);
				Calcul objet = (Calcul) registry.lookup("Calculator");
				String[] arguments = info.split(" ");
				int number1 = Integer.parseInt(arguments[0]);
				int number2 = Integer.parseInt(arguments[2]);
				char operation = arguments[1].charAt(0);
				
				input = objet.calcul(number1, operation, number2);
										
			}catch(Exception e) {
				System.out.println("Exception de ClientCalcul : "+ e);
				input = "-1";
			}
		}
		else
		{
			input = input + actionCommand;
		}
		textArea.setText(input);

	}
}


public static void main (String[] args)
{
		InterfaceGraphique fenetre = new InterfaceGraphique();
		fenetre.setVisible(true);
}

}
