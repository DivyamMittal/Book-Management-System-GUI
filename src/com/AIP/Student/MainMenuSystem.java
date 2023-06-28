package com.AIP.Student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;
import java.awt.event.WindowAdapter;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.UIManager;

public class MainMenuSystem {

	private JFrame frame;
	private JTextField titleInput;
	private JTextField authorInput;
	private JTextField publisherInput;
	private JTextField priceInput;
	private JTextField stockInput;
	private JTextField modifyBookTitle;
	private JTextField newBookTitle;
	private JTextField newAuthor;
	private JTextField newPublisher;
	private JTextField newPrice;
	private JTextField newStock;
	private JTextField delBookTitle;
	private JTextField titleIssue;
	private JTable displaytable;
	private JTextField authorIssue;
	private JTextField copyIssue;
	private JTextField delAuthor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuSystem window = new MainMenuSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenuSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
			}
		});
		frame.setBounds(100, 100, 1253, 681);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPaneMenu = new JLayeredPane();
		layeredPaneMenu.setBackground(new Color(255, 127, 80));
		layeredPaneMenu.setBounds(0, 0, 1239, 644);
		frame.getContentPane().add(layeredPaneMenu);
		
		JPanel panel_6 = new JPanel();
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
//				Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
				System.exit(0);
			}
		});
		panel_6.setBackground(new Color(255, 127, 80));
		panel_6.setBounds(30, 573, 263, 46);
		layeredPaneMenu.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel createPanel = new JPanel();
		layeredPaneMenu.setLayer(createPanel, 0);
		createPanel.setBackground(new Color(255, 160, 122));
		createPanel.setBounds(328, 10, 901, 624);
		layeredPaneMenu.add(createPanel);
		createPanel.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("New Book Entry");
		lblNewLabel_6.setForeground(SystemColor.desktop);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblNewLabel_6.setBounds(319, 28, 295, 45);
		createPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Book Title :");
		lblNewLabel_7.setForeground(SystemColor.desktop);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(100, 132, 123, 37);
		createPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("Author Name :");
		lblNewLabel_9.setForeground(SystemColor.desktop);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_9.setBounds(99, 202, 161, 37);
		createPanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Price :");
		lblNewLabel_10.setForeground(SystemColor.desktop);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_10.setBounds(100, 336, 94, 37);
		createPanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_12 = new JLabel("Publisher Name :");
		lblNewLabel_12.setForeground(SystemColor.desktop);
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_12.setBounds(100, 269, 191, 37);
		createPanel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_14 = new JLabel("Stock :");
		lblNewLabel_14.setForeground(SystemColor.desktop);
		lblNewLabel_14.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_14.setBounds(100, 402, 143, 37);
		createPanel.add(lblNewLabel_14);
		
		titleInput = new JTextField();
		titleInput.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		titleInput.setBounds(299, 135, 486, 32);
		createPanel.add(titleInput);
		titleInput.setColumns(10);
		
		authorInput = new JTextField();
		authorInput.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		authorInput.setColumns(10);
		authorInput.setBounds(299, 205, 486, 32);
		createPanel.add(authorInput);
		
		publisherInput = new JTextField();
		publisherInput.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		publisherInput.setColumns(10);
		publisherInput.setBounds(299, 272, 486, 32);
		createPanel.add(publisherInput);
		
		priceInput = new JTextField();
		priceInput.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		priceInput.setColumns(10);
		priceInput.setBounds(299, 339, 204, 32);
		createPanel.add(priceInput);
		
		stockInput = new JTextField();
		stockInput.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		stockInput.setColumns(10);
		stockInput.setBounds(299, 405, 204, 32);
		createPanel.add(stockInput);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = titleInput.getText();
				String author = authorInput.getText();
				String publisher = publisherInput.getText();
				String price = priceInput.getText();
				String stock = stockInput.getText();
				DBConnection.inserData(title,author,publisher,price,stock);
				JOptionPane.showMessageDialog(null, "Data Inserted Successful!", "Insert", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(391, 525, 112, 37);
		createPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				titleInput.setText("");
				authorInput.setText("");
				publisherInput.setText("");
				priceInput.setText("");
				stockInput.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnNewButton_1.setBounds(751, 528, 94, 32);
		createPanel.add(btnNewButton_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(74, 83, 756, 2);
		createPanel.add(separator_1);
		
		JPanel searchPanel = new JPanel();
		layeredPaneMenu.setLayer(searchPanel, 0);
		searchPanel.setBackground(new Color(255, 160, 122));
		searchPanel.setBounds(329, 10, 901, 624);
		layeredPaneMenu.add(searchPanel);
		searchPanel.setLayout(null);
		
		JLabel lblNewLabel_6_2 = new JLabel("Book Issue");
		lblNewLabel_6_2.setForeground(SystemColor.desktop);
		lblNewLabel_6_2.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblNewLabel_6_2.setBounds(360, 10, 204, 47);
		searchPanel.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_8_2 = new JLabel("Book Title :");
		lblNewLabel_8_2.setForeground(SystemColor.desktop);
		lblNewLabel_8_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_8_2.setBounds(87, 360, 129, 36);
		searchPanel.add(lblNewLabel_8_2);
		
		titleIssue = new JTextField();
		titleIssue.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		titleIssue.setColumns(10);
		titleIssue.setBounds(243, 363, 544, 32);
		searchPanel.add(titleIssue);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displaytable.setModel(new DefaultTableModel(null, new String[]{"Book Title","Author Name","Publication","Price","Stock"}));
				String iTitle = titleIssue.getText();
				String iAuthor = authorIssue.getText();
				try {
					// Load the drivers
					Class.forName("oracle.jdbc.OracleDriver");
					// connection establish
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "shadow");
					String query = "select * from libraryBooks where title=? and author=?";
					PreparedStatement prst = con.prepareStatement(query);
					prst.setString(1, iTitle);
					prst.setString(2, iAuthor);
					ResultSet rs = prst.executeQuery();
					while(rs.next())
					{
						String tbData[] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
						DefaultTableModel tbModel = (DefaultTableModel)displaytable.getModel();
						tbModel.addRow(tbData);
					}
					con.close();
				} 
				catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
			}
		});
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnSearch.setBounds(292, 485, 112, 37);
		searchPanel.add(btnSearch);
		
		JButton btnDisplayAll = new JButton("Display All");
		btnDisplayAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displaytable.setModel(new DefaultTableModel(null, new String[]{"Book Title","Author Name","Publication","Price","Stock"}));
				try {
					// Load the drivers
					Class.forName("oracle.jdbc.OracleDriver");
					// connection establish
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "shadow");
					String query = "select * from libraryBooks";
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					while(rs.next())
					{
						String tbData[] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
						DefaultTableModel tbModel = (DefaultTableModel)displaytable.getModel();
						tbModel.addRow(tbData);
					}
					con.close();
				} 
				catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
			}
		});
		btnDisplayAll.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnDisplayAll.setBounds(392, 553, 152, 37);
		searchPanel.add(btnDisplayAll);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 103, 811, 196);
		searchPanel.add(scrollPane);
		
		displaytable = new JTable();
		displaytable.setBackground(SystemColor.control);
		displaytable.setForeground(SystemColor.desktop);
		displaytable.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane.setViewportView(displaytable);
		displaytable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "D.O.B", "Gender", "Class"
			}
		));
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(0, 0, 0));
		separator_1_1.setBounds(66, 67, 756, 2);
		searchPanel.add(separator_1_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(66, 331, 756, 2);
		searchPanel.add(separator_1_1_1);
		
		JLabel lblNewLabel_8_2_1 = new JLabel("Author :");
		lblNewLabel_8_2_1.setForeground(Color.BLACK);
		lblNewLabel_8_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_8_2_1.setBounds(87, 413, 129, 36);
		searchPanel.add(lblNewLabel_8_2_1);
		
		authorIssue = new JTextField();
		authorIssue.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		authorIssue.setColumns(10);
		authorIssue.setBounds(243, 417, 189, 32);
		searchPanel.add(authorIssue);
		
		JLabel lblNewLabel_8_2_1_1 = new JLabel("Copies :");
		lblNewLabel_8_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_8_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_8_2_1_1.setBounds(496, 413, 89, 36);
		searchPanel.add(lblNewLabel_8_2_1_1);
		
		copyIssue = new JTextField();
		copyIssue.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		copyIssue.setColumns(10);
		copyIssue.setBounds(598, 417, 189, 32);
		searchPanel.add(copyIssue);
		
		JButton btnIssue = new JButton("Buy");
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seTitle = titleIssue.getText();
				String seAuthor = authorIssue.getText();
				String seCopyStock =  copyIssue.getText();
				long result = DBConnection.stockAvailable(seTitle, seAuthor);
				if(Integer.parseInt(seCopyStock)<result)
				{
					long pprice = DBConnection.priceBooks(seTitle, seAuthor, seCopyStock);
					String val = "Total Price is: "+String.valueOf(pprice);
					JOptionPane.showMessageDialog(null, val, "Issue", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Insufficent Stock!", "Issue", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnIssue.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnIssue.setBounds(520, 485, 112, 37);
		searchPanel.add(btnIssue);
		
		JPanel modifyPanel = new JPanel();
		layeredPaneMenu.setLayer(modifyPanel, 0);
		modifyPanel.setBackground(new Color(255, 160, 122));
		modifyPanel.setBounds(327, 10, 901, 624);
		layeredPaneMenu.add(modifyPanel);
		modifyPanel.setLayout(null);
		
		JLabel lblNewLabel_6_1 = new JLabel("Modify Book Record");
		lblNewLabel_6_1.setForeground(SystemColor.desktop);
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblNewLabel_6_1.setBounds(294, 18, 372, 47);
		modifyPanel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Book Title :");
		lblNewLabel_7_1.setForeground(SystemColor.desktop);
		lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_7_1.setBounds(99, 219, 130, 37);
		modifyPanel.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("Enter Book Title :");
		lblNewLabel_8_1.setForeground(SystemColor.desktop);
		lblNewLabel_8_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_8_1.setBounds(99, 113, 182, 36);
		modifyPanel.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("Author Name :");
		lblNewLabel_9_1.setForeground(SystemColor.desktop);
		lblNewLabel_9_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_9_1.setBounds(98, 274, 152, 37);
		modifyPanel.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_12_1 = new JLabel("Publisher Name :");
		lblNewLabel_12_1.setForeground(SystemColor.desktop);
		lblNewLabel_12_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_12_1.setBounds(99, 327, 182, 37);
		modifyPanel.add(lblNewLabel_12_1);
		
		JLabel lblNewLabel_14_1 = new JLabel("Price :");
		lblNewLabel_14_1.setForeground(SystemColor.desktop);
		lblNewLabel_14_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_14_1.setBounds(99, 379, 71, 37);
		modifyPanel.add(lblNewLabel_14_1);
		
		JLabel lblNewLabel_15_1 = new JLabel("Stock :");
		lblNewLabel_15_1.setForeground(SystemColor.desktop);
		lblNewLabel_15_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_15_1.setBounds(99, 432, 100, 43);
		modifyPanel.add(lblNewLabel_15_1);
		
		modifyBookTitle = new JTextField();
		modifyBookTitle.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		modifyBookTitle.setColumns(10);
		modifyBookTitle.setBounds(304, 116, 353, 32);
		modifyPanel.add(modifyBookTitle);
		
		newBookTitle = new JTextField();
		newBookTitle.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		newBookTitle.setColumns(10);
		newBookTitle.setBounds(304, 222, 482, 32);
		modifyPanel.add(newBookTitle);
		
		newAuthor = new JTextField();
		newAuthor.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		newAuthor.setColumns(10);
		newAuthor.setBounds(304, 277, 482, 32);
		modifyPanel.add(newAuthor);
		
		newPublisher = new JTextField();
		newPublisher.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		newPublisher.setColumns(10);
		newPublisher.setBounds(304, 330, 482, 32);
		modifyPanel.add(newPublisher);
		
		newPrice = new JTextField();
		newPrice.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		newPrice.setColumns(10);
		newPrice.setBounds(304, 382, 190, 32);
		modifyPanel.add(newPrice);
		
		newStock = new JTextField();
		newStock.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		newStock.setColumns(10);
		newStock.setBounds(304, 438, 190, 32);
		modifyPanel.add(newStock);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String modifySearchTitle = modifyBookTitle.getText();
				String nTitle = newBookTitle.getText();
				String nAuthor = newAuthor.getText();
				String nPublisher = newPublisher.getText();
				String nPrice = newPrice.getText();
				String nStock = newStock.getText();
				DBConnection.updateData(nTitle, nAuthor, nPublisher, nPrice, nStock,modifySearchTitle);
				JOptionPane.showMessageDialog(null, "Data Updated Successful!", "Modify", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnModify.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnModify.setBounds(401, 535, 112, 37);
		modifyPanel.add(btnModify);
		
		JLabel lblNewLabel_16 = new JLabel("Enter Updated Record");
		lblNewLabel_16.setForeground(SystemColor.desktop);
		lblNewLabel_16.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_16.setBounds(98, 166, 340, 32);
		modifyPanel.add(lblNewLabel_16);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifyBookTitle.setText("");
				newBookTitle.setText("");
				newAuthor.setText("");
				newPublisher.setText("");
				newPrice.setText("");
				newStock.setText("");
			}
		});
		
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnReset.setBounds(743, 535, 94, 37);
		modifyPanel.add(btnReset);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(0, 0, 0));
		separator_1_2.setBounds(82, 75, 736, 2);
		modifyPanel.add(separator_1_2);
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sTitle = modifyBookTitle.getText();
				try {
//					Attributes: Name, DOB, Mobile no., address, pan no, password
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "shadow");
					String query = "select * from libraryBooks where title = ?";
					PreparedStatement prst = con.prepareStatement(query);
					prst.setString(1, sTitle);
					prst.executeUpdate();
					ResultSet rs = prst.executeQuery();
					while(rs.next()) {
						newBookTitle.setText(rs.getString(1));
						newAuthor.setText(rs.getString(2));
						newPublisher.setText(rs.getString(3));
						newPrice.setText(rs.getString(4));
						newStock.setText(rs.getString(5));
						rs.close();
						
					}
					con.close();
				} 
				catch (Exception ee) {
					// TODO: handle exception
					ee.printStackTrace();
				}
			}
		});
		btnSearch_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnSearch_1.setBounds(689, 112, 112, 37);
		modifyPanel.add(btnSearch_1);
		
		JPanel deletePanel = new JPanel();
		layeredPaneMenu.setLayer(deletePanel, 1);
		deletePanel.setBackground(new Color(255, 160, 122));
		deletePanel.setBounds(328, 10, 901, 624);
		layeredPaneMenu.add(deletePanel);
		deletePanel.setLayout(null);
		
		JLabel lblNewLabel_17 = new JLabel("Delete Book Record");
		lblNewLabel_17.setForeground(SystemColor.desktop);
		lblNewLabel_17.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblNewLabel_17.setBounds(294, 20, 359, 47);
		deletePanel.add(lblNewLabel_17);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("Enter Book Title :");
		lblNewLabel_8_1_1.setForeground(SystemColor.desktop);
		lblNewLabel_8_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_8_1_1.setBounds(171, 232, 193, 36);
		deletePanel.add(lblNewLabel_8_1_1);
		
		delBookTitle = new JTextField();
		delBookTitle.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		delBookTitle.setColumns(10);
		delBookTitle.setBounds(392, 235, 359, 32);
		deletePanel.add(delBookTitle);
		
		JButton btnNewButton_2_1 = new JButton("Delete");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dTitle = delBookTitle.getText();
				String dAuthor = delAuthor.getText();
				DBConnection.deleteData(dTitle, dAuthor);
				JOptionPane.showMessageDialog(null, "Data Deletion Successful!", "Delete", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_2_1.setBounds(392, 523, 112, 37);
		deletePanel.add(btnNewButton_2_1);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setForeground(new Color(0, 0, 0));
		separator_1_3.setBounds(74, 82, 756, 2);
		deletePanel.add(separator_1_3);
		
		JLabel lblNewLabel_8_1_1_1 = new JLabel("Enter Author Name :");
		lblNewLabel_8_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_8_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_8_1_1_1.setBounds(171, 294, 211, 36);
		deletePanel.add(lblNewLabel_8_1_1_1);
		
		delAuthor = new JTextField();
		delAuthor.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		delAuthor.setColumns(10);
		delAuthor.setBounds(392, 298, 359, 32);
		deletePanel.add(delAuthor);

		JPanel welcomePanel = new JPanel();
		layeredPaneMenu.setLayer(welcomePanel, 1);
		welcomePanel.setLayout(null);
		welcomePanel.setBackground(new Color(255, 160, 122));
		welcomePanel.setBounds(328, 10, 901, 624);
		layeredPaneMenu.add(welcomePanel);
		
		JLabel lblNewLabel_2_3 = new JLabel("WELCOME");
		lblNewLabel_2_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		lblNewLabel_2_3.setBounds(331, 147, 231, 58);
		welcomePanel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("TO");
		lblNewLabel_2_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		lblNewLabel_2_4.setBounds(331, 215, 231, 58);
		welcomePanel.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("BOOK SHOP MANAGEMENT SYSTEM");
		lblNewLabel_2_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_5.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		lblNewLabel_2_5.setBounds(71, 283, 749, 58);
		welcomePanel.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_5_1 = new JLabel("Developed by :- Divyam Mittal");
		lblNewLabel_2_5_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_2_5_1.setBounds(242, 370, 417, 58);
		welcomePanel.add(lblNewLabel_2_5_1);
		
		createPanel.setVisible(false);
		searchPanel.setVisible(false);
		modifyPanel.setVisible(false);
		deletePanel.setVisible(false);
		welcomePanel.setVisible(true);
		
		JLabel lblNewLabel_5 = new JLabel("Exit");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_5.setBounds(115, 10, 123, 26);
		panel_6.add(lblNewLabel_5);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createPanel.setVisible(false);
				searchPanel.setVisible(false);
				modifyPanel.setVisible(false);
				deletePanel.setVisible(true);
				welcomePanel.setVisible(false);
			}
		});
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(255, 127, 80));
		panel_5.setBounds(30, 505, 263, 46);
		layeredPaneMenu.add(panel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Delete Record");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_4.setBounds(70, 10, 183, 26);
		panel_5.add(lblNewLabel_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createPanel.setVisible(false);
				searchPanel.setVisible(false);
				modifyPanel.setVisible(true);
				deletePanel.setVisible(false);
				welcomePanel.setVisible(false);
			}
		});
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(255, 127, 80));
		panel_4.setBounds(30, 436, 263, 46);
		layeredPaneMenu.add(panel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Modify Record");
		
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(66, 10, 187, 26);
		panel_4.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createPanel.setVisible(false);
				searchPanel.setVisible(true);
				modifyPanel.setVisible(false);
				deletePanel.setVisible(false);
				welcomePanel.setVisible(false);
			}
		});
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 127, 80));
		panel_2.setBounds(30, 366, 263, 46);
		layeredPaneMenu.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Buy Book");
		lblNewLabel_1.setBackground(SystemColor.textHighlightText);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(81, 10, 172, 26);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createPanel.setVisible(true);
				searchPanel.setVisible(false);
				modifyPanel.setVisible(false);
				deletePanel.setVisible(false);
				welcomePanel.setVisible(false);
			}
		});
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 127, 80));
		panel_1.setBounds(30, 293, 263, 46);
		layeredPaneMenu.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("New Record");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel.setBounds(79, 10, 174, 26);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("BOOK SHOP");
		lblNewLabel_2.setForeground(new Color(255, 127, 80));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(45, 21, 248, 58);
		layeredPaneMenu.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("MANAGEMENT");
		lblNewLabel_2_1.setForeground(new Color(255, 127, 80));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		lblNewLabel_2_1.setBounds(10, 89, 308, 58);
		layeredPaneMenu.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("SYSTEM");
		lblNewLabel_2_2.setForeground(new Color(255, 127, 80));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		lblNewLabel_2_2.setBounds(47, 156, 231, 58);
		layeredPaneMenu.add(lblNewLabel_2_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(75, 249, 175, 10);
		layeredPaneMenu.add(separator);
		
		
		
	}
}
