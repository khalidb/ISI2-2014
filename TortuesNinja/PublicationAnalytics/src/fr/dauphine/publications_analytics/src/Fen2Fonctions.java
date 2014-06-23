package fr.dauphine.publications_analytics.src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Fen2Fonctions extends javax.swing.JFrame {
	private String file_name;//just the file name 
	//constructor
	public Fen2Fonctions(String file_name) {
		this.file_name = file_name;
		//get All authors and their co-author
		FunctionsTask4 xml = new FunctionsTask4();
		authors = xml.NamesOfCoAuthors(file_name, "*", 0, 0);
		authors.put("all", null);
		//get all year in the file
		FunctionsTask3 x = new FunctionsTask3();
		ArrayList<String> yearsString =  x.get_all_years_in_file(file_name,"*");
		System.out.println("ici");
		years = new ArrayList<Integer>();
		for (int j=0;j<yearsString.size();j++){
			years.add(Integer.parseInt(yearsString.get(j)));
		}
		years.add(0);
		Collections.sort(years);// sort years
		System.out.println(years.toString());
		initComponents();//init other components

		// initit the standard options
		jRadioButton1.setSelected(true);
		jButton1.setVisible(true);
		jButton2.setVisible(true);
		jButton4.setVisible(true);
		jComboBox2.setVisible(false);
		jLabel1.setText("Author");
		jLabel2.setVisible(false);
		label1.setText("Display options");

	}
	
	//init components
	private void initComponents() {
		//Jradio Button and button Group
		buttonGroup5 = new javax.swing.ButtonGroup();
		jRadioButton1 = new javax.swing.JRadioButton();
		jRadioButton1.setBackground(new Color(255,0,127));
		jRadioButton2 = new javax.swing.JRadioButton();
		jRadioButton2.setBackground(new Color(255,0,127));
		jRadioButton3 = new javax.swing.JRadioButton();
		jRadioButton3.setBackground(new Color(255,0,127));
		//init the Button
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		//init the Combox
		jComboBox1 = new javax.swing.JComboBox();
		jComboBox2 = new javax.swing.JComboBox();
		//init label
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		//init JtetxtArea with  it scroll pane
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		label1 = new java.awt.Label();
		// add the third button
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		//frame option and title
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Result");
		//attach radiobuttons to buttonGroup
		buttonGroup5.add(jRadioButton1);
		//init first option and it listener
		jRadioButton1.setText("Co-AuthorName");
		jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton1ActionPerformed(evt);
			}
		});
		//init second option and it listener
		buttonGroup5.add(jRadioButton2);
		jRadioButton2.setText("Co-Author name by year");
		jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton2ActionPerformed(evt);
			}
		});
		//init third option and it listener
		buttonGroup5.add(jRadioButton3);
		jRadioButton3.setText("Co-Author name by publication");
		jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton3ActionPerformed(evt);
			}
		});
		//init the button run(execute button)
		jButton1.setText("Run");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonRun(evt);
			}
		});
		//init the button for download file
		jButton2.setText("Download CSV file");
		jButton2.setBackground(Color.GREEN);
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonDownload(evt);
			}
		});
		//init the combox1 with all the authors in the file
		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(authors.keySet().toArray(new String[authors.size()])));
		
		//init the scroll pane with it jTextArea
		jTextArea1.setEditable(false);
		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		//image XML
		JPanel panel = (JPanel)this.getContentPane();  
		JLabel label2 = new JLabel();  
		label2.setIcon(new ImageIcon("dauphin_023.gif"));
		panel.add(label2);
		Dimension size2 = label2.getPreferredSize();
		label2.setBounds(0, 500, size2.width, size2.height);
		//label2.setBounds(0, 300, 120, 120);

		label1.setName("Request"); 
		jButton4.setForeground(new java.awt.Color(255, 0, 51));
		jButton3.setForeground(new java.awt.Color(255, 0, 51));
		jButton3.setText("back");
		jButton4.setText("Network");
		
		
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}

			
		});
		
		
		
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(53, 53, 53)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(layout.createSequentialGroup()
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jRadioButton1)
																		.addComponent(jRadioButton3)
																		.addComponent(jRadioButton2))
																		.addGap(9, 9, 9)
																		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																				.addGroup(layout.createSequentialGroup()
																						.addComponent(jLabel2)
																						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																						.addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(layout.createSequentialGroup()
																								.addComponent(jLabel1)
																								.addGap(18, 18, 18)
																								.addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
																								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																										.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
																										.addComponent(jButton4)
																										.addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
																										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGap(44, 44, 44))))
																										.addGroup(layout.createSequentialGroup()
																												.addContainerGap()
																												.addComponent(jButton3)
																												
																												.addGap(0, 0, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jButton3)
						.addComponent(jButton4)
						.addGap(1, 1, 1)
						.addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jRadioButton1)
								.addComponent(jButton1)
								.addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jRadioButton2)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jRadioButton3))
												.addGroup(layout.createSequentialGroup()
														.addGap(15, 15, 15)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(jButton2)
										
																.addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jLabel2))))
																.addGap(18, 18, 18)
																.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addContainerGap(30, Short.MAX_VALUE))
				);
		//this.getContentPane().setBackground(new Color(176,176,255));
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(255,0,127));
		//this.getContentPane().setBackground(Color.WHITE);
		pack();
		setLocationRelativeTo(null);
	}                      

	private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
		if(evt.getSource()==jRadioButton1){
			if(jRadioButton1.isSelected()){
				jButton1.setVisible(true);
				jButton2.setVisible(true);
				jComboBox2.setVisible(false);
				jLabel1.setText("Author");
				jLabel2.setVisible(false);
			}
		}
	}                                             

	private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                              
		if(evt.getSource()==jRadioButton2){
			if(jRadioButton2.isSelected()){
				jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(years.toArray()));
				jButton1.setVisible(true);
				jButton2.setVisible(true);
				jComboBox2.setVisible(true);
				jLabel1.setText("Author");
				jLabel2.setText("Year");
				jLabel2.setVisible(true);
				
			}
		}
	}                                             

	private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                              
		if(evt.getSource()==jRadioButton3){
			if(jRadioButton3.isSelected()){
				jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"publications","inproceedings","article","book","incollection"}));
				jButton1.setVisible(true);
				jButton2.setVisible(true);
				jComboBox2.setVisible(true);
				jLabel1.setText("Author");
				jLabel2.setText("Publication Type");
				jLabel2.setVisible(true);
			}
		}
	}

	private void jButtonDownload(java.awt.event.ActionEvent evt){
		if(evt.getSource() == jButton2){
			System.out.println("test");
			StringBuilder sb = new StringBuilder();
			JFileChooser chooser = new JFileChooser();
			int retrival = chooser.showSaveDialog(null);
			if(retrival == JFileChooser.APPROVE_OPTION){
				try{
					FileWriter f = new FileWriter(chooser.getSelectedFile()+".csv");
					f.write(jTextArea1.getText());
					f.close();
				}
				catch (Exception e){
				}
			}
		}
	}

	private void jButtonRun(java.awt.event.ActionEvent evt){//button run
		if(evt.getSource() == jButton1){
			//case 1
			if(jRadioButton1.isSelected()){
				//for all the authors
				if(jComboBox1.getSelectedItem().equals("all")){
					authors.remove("all");
					StringBuilder result = new StringBuilder();
					result.append("Authors;[Co-Authors]\n");
					Set<String> keys = authors.keySet();  //get all keys
					for(String i: keys)
					{
						result.append(i +"("+ authors.get(i).size()+ ")");
						result.append(";");
						ArrayList a = authors.get(i);
						for(int y = 0;y<a.size();y++){
							result.append(a.get(y)+"("+authors.get(a.get(y)).size()+")");
							result.append(";");
						}	
						result.append("\n");
					}
					jTextArea1.setText(result.toString());
				}
				//one author
				else{
					StringBuilder result = new StringBuilder();
					result.append("The co-author(s) of " + jComboBox1.getSelectedItem()+"("+ authors.get(jComboBox1.getSelectedItem()).size()+ ")" +":\n");
					ArrayList resultat = authors.get(jComboBox1.getSelectedItem() );
					for(int i =0;i<resultat.size();i++){
						result.append(resultat.get(i) +"(" +authors.get(resultat.get(i)).size()+")" +"\n");
					}
					jTextArea1.setText(result.toString());	 
				}
			}
			//cas 2
			if(jRadioButton2.isSelected()){
				jTextArea1.setText(new String());
				if(jComboBox1.getSelectedItem().equals("all") && (Integer)jComboBox2.getSelectedItem()==0){
					System.out.println("ICICICICICI");
					FunctionsTask3 x = new FunctionsTask3();
					FunctionsTask4 x2 = new FunctionsTask4();
					ArrayList<String> yearsString =  x.get_all_years_in_file(file_name, "*");
					ArrayList<Integer> years = new ArrayList<Integer>();
					for (int j=0;j<yearsString.size();j++){
						years.add(Integer.parseInt(yearsString.get(j)));
					}
					Collections.sort(years);
					for(int i =years.get(0); i <= years.get(years.size()-1); i++){
						jTextArea1.append(i+" : \n"+ x2.AffichageNameOfCoAuthorsByYears(x2.NamesOfCoAuthors(file_name,  "*", i, 0)));
						//NamesOfCoAuthors(file_name, balise_name, i, 0));
					}
				}
				else {
					FunctionsTask4 xml = new FunctionsTask4();
					StringBuilder result = new StringBuilder();
					Map<String, ArrayList> resultat = xml.NamesOfCoAuthors(file_name,"*",(Integer)jComboBox2.getSelectedItem(), 0);
					if(resultat.containsKey(jComboBox1.getSelectedItem())){

						result.append("The co-author(s) of " + jComboBox1.getSelectedItem() +"("+ resultat.get(jComboBox1.getSelectedItem()).size() +")"+ " in " + jComboBox2.getSelectedItem()+ ":\n");

						//System.out.println(resultat.toString());

						ArrayList l = resultat.get(jComboBox1.getSelectedItem());
						if(l.size()>0){
							for(int i = 0;i< l.size();i++)
								result.append(l.get(i)+ "(" +resultat.get(l.get(i)).size() +")\n");
							jTextArea1.setText(result.toString());	 
						}
					}
					else {
						result.append("No co-author in "+ jComboBox2.getSelectedItem()+ " for " + jComboBox1.getSelectedItem());
						jTextArea1.setText(result.toString());	
					}
				}

			}
			//cas 3
			if(jRadioButton3.isSelected()){
				FunctionsTask4 xml = new FunctionsTask4();
				StringBuilder result = new StringBuilder();
				String choice =  jComboBox2.getSelectedItem().toString();
				if(choice.equals("publications"))
					choice = "*";
				Map<String, ArrayList> resultat = xml.NamesOfCoAuthors(file_name,choice,0, 0);
				if(resultat.containsKey(jComboBox1.getSelectedItem())){

					result.append("The co-author(s) of " + jComboBox1.getSelectedItem() +"("+ resultat.get(jComboBox1.getSelectedItem()).size() +")"+ " for " + jComboBox2.getSelectedItem()+ ":\n");

					//System.out.println(resultat.toString());

					ArrayList l = resultat.get(jComboBox1.getSelectedItem());
					if(l.size()>0){
						for(int i = 0;i< l.size();i++)
							result.append(l.get(i)+ "(" +resultat.get(l.get(i)).size() +")\n");
						jTextArea1.setText(result.toString());	 
					}
				}
				else {
					result.append("No co-author for "+ jComboBox2.getSelectedItem()+ " for " + jComboBox1.getSelectedItem());
					jTextArea1.setText(result.toString());	
				}

			}

		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         

		if(evt.getSource() == jButton3){
			this.dispose();
			this.setVisible(false);
			FenChargement f1 = new FenChargement();
			f1.setVisible(true);
		}
	}       
	
	private void jButton4ActionPerformed(ActionEvent evt) {
		if(evt.getSource()==jButton4){
			if(!"all".equals((String)jComboBox1.getSelectedItem())){
			FenAuthor aut = new FenAuthor((String)jComboBox1.getSelectedItem(),authors.get((String)jComboBox1.getSelectedItem()),null,authors);
			aut.setVisible(true);
		}
		}
	}

	// Variables declaration - do not modify                     
	private javax.swing.ButtonGroup buttonGroup5;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JRadioButton jRadioButton3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private java.awt.Label label1;
	private Map<String, ArrayList> authors;
	private ArrayList<Integer> years;
	
	
	// End of variables declaration                   


}