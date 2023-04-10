// GUI and main program for the Training Record updated by shermina on 12.24
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

	private JTextField name = new JTextField(30);
	private JTextField day = new JTextField(2);
	private JTextField month = new JTextField(2);
	private JTextField year = new JTextField(4);
	private JTextField hours = new JTextField(2);
	private JTextField mins = new JTextField(2);
	private JTextField secs = new JTextField(2);
	private JTextField dist = new JTextField(4);
	private JTextField terrain = new JTextField(8);
	private JTextField tempo = new JTextField(8);
	private JTextField Repetitions = new JTextField(2);
	private JTextField Recovery = new JTextField(2);
	private JTextField where = new JTextField(7);
	
	private JLabel labn = new JLabel(" Name:");
	private JLabel labd = new JLabel(" Day:");
	private JLabel labm = new JLabel(" Month:");
	private JLabel laby = new JLabel(" Year:");
	private JLabel labh = new JLabel(" Hours:");
	private JLabel labmm = new JLabel(" Mins:");
	private JLabel labs = new JLabel(" Secs:");
	private JLabel labdist = new JLabel(" Distance (km):");
	private JLabel labt = new JLabel(" Terrain:");
	private JLabel labte = new JLabel(" Tempo:");
	private JLabel labp = new JLabel(" Where:");
	private JLabel labge = new JLabel(" Recovery:");
	private JLabel labnum = new JLabel(" Repetitions:");
	
	private JButton add = new JButton("Add");
	private JButton lookUpByDate = new JButton("Look Up");
	private JButton findallbydate = new JButton("Find all by date");
	private JButton removebydate = new JButton("Remove Record");

	private TrainingRecord myAthletes = new TrainingRecord();

	private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
    	super("Training Record");
		setLayout(new FlowLayout());
		add(labn);
		add(name);
		name.setEditable(true);
		add(labd);
		add(day);
		day.setEditable(true);
		add(labm);
		add(month);
		month.setEditable(true);
		add(laby);
		add(year);
		year.setEditable(true);
		add(labh);
		add(hours);
		hours.setEditable(true);
		add(labmm);
		add(mins);
		mins.setEditable(true);
		add(labs);
		add(secs);
		secs.setEditable(true);
		add(labdist);
		add(dist);
		dist.setEditable(true);
		
		add(labt);
		add(terrain);
		terrain.setEditable(true);
		add(labte);
		add(tempo);
		tempo.setEditable(true);
		
		add(labge);
		add(Recovery);
		Recovery.setEditable(true);
		add(labnum);
		add(Repetitions);
		Repetitions.setEditable(true);
			
		add(labp);
		add(where);
		where.setEditable(true);
				
		add(add);
		add.addActionListener(this);
		add(lookUpByDate);
		lookUpByDate.addActionListener(this);
		add(findallbydate);
		findallbydate.addActionListener(this);
		add(removebydate);
		removebydate.addActionListener(this);
		add(outputArea);
		outputArea.setEditable(false);
		setSize(720, 200);
		setVisible(true);
		blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
    	String message = "";
		if (event.getSource() == add) {
			message = addEntry("generic");
		}
			if (event.getSource() == lookUpByDate) {
			message = lookup();
		}
			if (event.getSource() == findallbydate) {
				message = lookupall();
			}
		if (event.getSource() == removebydate) {
			message = removeall();
		}
		outputArea.setText(message);
		blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
    	
    	Entry e;      
        String message = "Record added\n";
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
      
      	String ter = terrain.getText();
        String tem = tempo.getText();
      	int rec = Integer.parseInt(Recovery.getText());
      	int rep = Integer.parseInt(Repetitions.getText());
      	String wh = where.getText();
      	    	  		
      	 if (!wh.isEmpty())
      		e = new SwimEntry(n, d, m, y, h, mm, s, km, wh);
      	else if (!tem.isEmpty() && !ter.isEmpty())
      		e = new CycleEntry(n, d, m, y, h, mm, s, km, ter, tem);
      	else if (!Recovery.getText().isEmpty() && !Repetitions.getText().isEmpty())
      		e = new SprintEntry(n, d, m, y, h, mm, s, km, rec, rep);
      	else 
     		e = new Entry(n, d, m, y, h, mm, s, km);
          myAthletes.addEntry(e);
    	
         return message;
    }
    
       
    public String lookup() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    public String lookupall() {
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		outputArea.setText("looking up all records ...");
		String message = myAthletes.lookupEntries(d, m, y);
		return message;
	}
	
	public String removeall() {
		String n = name.getText();
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		outputArea.setText("removing record ...");
		String message = myAthletes.removeEntry(n, d, m, y);
		return message;
	}

	public void blankDisplay() {
		name.setText("");
		day.setText("");
		month.setText("");
		year.setText("");
		hours.setText("");
		mins.setText("");
		secs.setText("");
		dist.setText("");
		terrain.setText("");
		tempo.setText("");
		Recovery.setText("");
		Repetitions.setText("");
		where.setText("");

	}// blankDisplay
		// Fills the input fields on the display for testing purposes only

	public void fillDisplay(Entry ent) {
		name.setText(ent.getName());
		day.setText(String.valueOf(ent.getDay()));
		month.setText(String.valueOf(ent.getMonth()));
		year.setText(String.valueOf(ent.getYear()));
		hours.setText(String.valueOf(ent.getHour()));
		mins.setText(String.valueOf(ent.getMin()));
		secs.setText(String.valueOf(ent.getSec()));
		dist.setText(String.valueOf(ent.getDistance()));
	
	}

} // TrainingRecordGUI
