package fr.dauphine.publications_analytics.src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FenChargement extends javax.swing.JFrame {

	public FenChargement() {
		initComponents();
	}

	private void initComponents() {

		jMenu1 = new javax.swing.JMenu();
		jLabel1 = new javax.swing.JLabel();
		jLabel1.setForeground(Color.BLUE);
		jTextField1 = new javax.swing.JTextField();
		jTextField1.setBackground(Color.BLACK);
		jTextField1.setForeground(Color.GREEN);
		jButton1 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jTextArea1.setBackground(Color.BLACK);
		jTextArea1.setForeground(Color.GREEN);
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jMenu1.setText("jMenu1");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("File loading");
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		//setBackground(new java.awt.Color(0, 255, 255));
		setBounds(new java.awt.Rectangle(100, 100, 0, 0));
		//setForeground(new java.awt.Color(0, 204, 255));
		setName("chargement de fichier"); // NOI18N
		//image dauphine
		JPanel panel = (JPanel)this.getContentPane();  
        JLabel label = new JLabel();  
        label.setIcon(new ImageIcon("dauphine.gif"));
        panel.add(label);
        Dimension size = label.getPreferredSize();
        label.setBounds(10, 10, size.width, 68);
        //image XML
        JLabel label2 = new JLabel();  
        label2.setIcon(new ImageIcon("xml.jpg"));
        panel.add(label2);
        Dimension size2 = label2.getPreferredSize();
        label2.setBounds(220, 0, 128, 100);
        System.out.println (size.width +" " +size.height);
		//non redimensionnable
		setResizable(false);
		jLabel1.setText("File loading");

		//jTextField1.setText(" file name");
		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jButton1.setBackground(new java.awt.Color(102, 255, 102));
		jButton1.setText("OK");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jTextArea1.setEditable(false);
		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jButton2.setBackground(new java.awt.Color(255, 255, 51));
		jButton2.setText("Search");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setForeground(new java.awt.Color(255, 0, 51));
		jButton3.setText("next step");
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
						.addGap(39, 39, 39)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jButton3)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createSequentialGroup()
												.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(35, 35, 35)
												.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jButton1)
												.addGap(18, 18, 18)
												.addComponent(jButton2))))
												.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(38, 38, 38)
						.addComponent(jButton3)
						.addGap(27, 27, 27)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton1)
								.addComponent(jButton2))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(30, Short.MAX_VALUE))
				);

		jLabel1.getAccessibleContext().setAccessibleName("File loading");
		
		//this.getContentPane().setBackground(new Color(176,176,255));
		this.getContentPane().setBackground(Color.WHITE);
		pack();
		setLocationRelativeTo(null);
	}                   


	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
		if(evt.getSource() == jButton1){
			if(!jTextField1.getText().endsWith(".xml")){
				JOptionPane.showMessageDialog(this, "It is not a XML file !"," File format error",JOptionPane.ERROR_MESSAGE);
			}
			else{
				try{
					StringBuffer contenufic = new StringBuffer();
					InputStream ips=new FileInputStream(jTextField1.getText()); 
					InputStreamReader ipsr=new InputStreamReader(ips);
					BufferedReader br=new BufferedReader(ipsr);
					String ligne;
					while ((ligne=br.readLine())!=null){
						contenufic.append(ligne+"\n");
					}
					br.close();
					ips.close();
					ips.close();
					jTextArea1.append("\n"+contenufic.toString());
				}        
				catch (Exception e){
					System.out.println(e.toString());
				}
			} 
		}
	}                                        

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
		// TODO add your handling code here:
	}                                           

	//bouton choix de chemin du fichier
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
		if(evt.getSource() == jButton2){
			JFileChooser chooser = new JFileChooser();
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File selection = chooser.getSelectedFile();
				jTextField1.setText(selection.getAbsolutePath());          
			}
		}
	}                                        

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

		if(evt.getSource() == jButton3){
			if(jTextField1.getText().isEmpty())
				JOptionPane.showMessageDialog(this, "XML file is required to continue"," No file for work",JOptionPane.WARNING_MESSAGE);
			else{
				if(!jTextField1.getText().endsWith(".xml"))
					JOptionPane.showMessageDialog(this, "It is not a XML file !"," File format error",JOptionPane.ERROR_MESSAGE);

				else{
					this.dispose();
					this.setVisible(false);
					StringBuilder path = new StringBuilder();
					//génération de path => on enlève les ressources builder
					StringTokenizer st = new StringTokenizer(jTextField1.getText(),"\\");
					path.append("file:/");
					while(st.hasMoreElements()){
						path.append(st.nextToken()).append("/");
					}
					path.deleteCharAt(path.length()-1);
					//System.out.println(path);
					Fen2Fonctions j2 = new Fen2Fonctions(path.toString());
					j2.setVisible(true);
				}
			}
		}
	}                                        

	// Variables declaration - do not modify                     
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration    
	
	public static void main(String[] args){
		FenChargement lancement = new FenChargement();
		lancement.setVisible(true);
	}
	
}
