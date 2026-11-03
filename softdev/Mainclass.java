package project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MainClass extends JFrame implements ActionListener{
	private JButton button1 = new JButton("show");
	private JButton button2 = new JButton("hide");
	private JTextField textfield = new JTextField();
	private String text = "";
	
	public MainClass(ArrayList<Phone> phones) {
		super();
		
		phones.forEach(phone ->{
			text = text + phone.toString();
		});
		textfield.setText(text);
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		getContentPane().setLayout(gridbag);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridx = 0;
		c.gridy = 0;
		gridbag.setConstraints(button1, c);
		getContentPane().add(button1);
		
		c.gridx = 1;
		c.gridy = 0;
		gridbag.setConstraints(button2, c);
		getContentPane().add(button2);
		
		c.gridx = 2;
		c.gridy = 0;
		gridbag.setConstraints(textfield, c);
		getContentPane().add(textfield);
		
		setVisible(true);
		pack();	

		button1.addActionListener(this);         
		button2.addActionListener(this);    
	
		
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Phone p1 = new Phone("Sony","Experia X",32,12.5,4.6,"Yes",150);
		Phone p2 = new Phone("Sony","Experia Z",64,14.2,5.6,"Yes",175);
		Phone p3 = new Phone("Samsung","Galaxy M",64,14.5,5.4,"Yes",180);
		Phone p4 = new Phone("Nokia","3330",16,13.2,2.3,"No",90);
		Phone p5 = new Phone("Motorola","M1",8,11.3,4.9,"Yes",100);
		Phone p6 = new Phone("IPhone","6",32,13.5,6.4,"Yes",250);
		Phone p7 = new Phone("Alcatel","A3",8,9.3,2.4,"No",50);
		
		ArrayList<Phone> phones = new ArrayList<>();
		phones.add(p1);
		phones.add(p2);
		phones.add(p3);
		phones.add(p4);
		phones.add(p5);
		phones.add(p6);
		phones.add(p7);
		phones.remove(6);
		
		Phone newPhone = new Phone("Sony","Experia X",32,12.5,4.6,"Yes",200);
		
		phones.add(newPhone);
	
		try {
			
			FileInputStream fileIn = new FileInputStream("phone.ser");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);

			Phone newPhone1 = (Phone) objectIn.readObject();
			Phone newPhone2 = (Phone) objectIn.readObject();
			Phone newPhone3 = (Phone) objectIn.readObject();
			Phone newPhone4 = (Phone) objectIn.readObject();
			Phone newPhone5 = (Phone) objectIn.readObject();
			Phone newPhone6 = (Phone) objectIn.readObject();
			Phone newPhone7 = (Phone) objectIn.readObject();

			objectIn.close();
			
			

			
		}catch (FileNotFoundException e){
		
			
			FileOutputStream fileOut = new FileOutputStream("phone.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			
			objectOut.writeObject(p1);
			objectOut.writeObject(p2);
			objectOut.writeObject(p3);
			objectOut.writeObject(p4);
			objectOut.writeObject(p5);
			objectOut.writeObject(p6);
			objectOut.writeObject(p7);

			
			objectOut.close();
		}
		
		new MainClass(phones);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(button1)) {
        	textfield.setVisible(true);
        }else if(e.getSource().equals(button2)){
        	textfield.setVisible(false);
        }
    }
}

