//JDBC import문
import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;


public class UserInterface extends JFrame {

	private JPanel contentPane;
	private JTextField head;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public UserInterface() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("\uB2E8\uBB34\uC9C0\uC870 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 426);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 86, 313, 134);
		contentPane.add(scrollPane);
		
		JTextArea resultField = new JTextArea();
		resultField.setLineWrap(true);
		scrollPane.setViewportView(resultField);
		
		head = new JTextField();
		head.setBounds(78, 10, 313, 66);
		head.setFont(new Font("휴먼매직체", Font.PLAIN, 12));
		head.setHorizontalAlignment(SwingConstants.CENTER);
		head.setText("\u2665 \uD589\uBCF5 \uCF58\uC11C\uD2B8 \uD2F0\uCF13\uC7A5 \u2665");
		contentPane.add(head);
		head.setColumns(5);
		
		////////////////////////////////////////////////////
		/* Application menus and queries 부분*/
		JButton insertButton = new JButton("Insert");
		insertButton.setBounds(23, 294, 95, 23);
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				////////////
				
				/* 이곳에 menu SQL 구현 */
				
				////////////
		
				resultField.setText("");//수정x 
				resultField.append("응애");//이곳 수정: 이곳에 결과 텍스트 출력
			}
		});
		insertButton.setFont(new Font("휴먼매직체", Font.PLAIN, 12));
		contentPane.add(insertButton);
		
		JButton selectButtonVersionA = new JButton("Select(version A)");
		selectButtonVersionA.setBounds(23, 261, 211, 23);
		selectButtonVersionA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				////////////
				
				/* 이곳에 menu SQL 구현 */
				
				////////////
				resultField.setText("");//수정x 
				resultField.append("응애");//이곳 수정: 이곳에 결과 텍스트 출력

			}
		});
		selectButtonVersionA.setFont(new Font("휴먼매직체", Font.PLAIN, 12));
		contentPane.add(selectButtonVersionA);
		
		JButton selectButtonVersionB = new JButton("Select(version B)");
		selectButtonVersionB.setBounds(246, 261, 202, 23);
		selectButtonVersionB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				////////////
				
				/* 이곳에 menu SQL 구현 */
				
				////////////
				resultField.setText("");//수정x 
				resultField.append("응애");//이곳 수정: 이곳에 결과 텍스트 출력

			}
		});
		selectButtonVersionB.setFont(new Font("휴먼매직체", Font.PLAIN, 12));
		contentPane.add(selectButtonVersionB);
		
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				////////////
				
				/* 이곳에 menu SQL 구현 */
				
				////////////
				resultField.setText("");//수정x 
				resultField.append("응애");//이곳 수정: 이곳에 결과 텍스트 출력

			}
		});
		updateButton.setBounds(195, 294, 95, 23);
		updateButton.setFont(new Font("휴먼매직체", Font.PLAIN, 12));
		contentPane.add(updateButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				////////////
				
				/* 이곳에 menu SQL 구현 */
				
				////////////
				resultField.setText("");//수정x 
				resultField.append("응애");//이곳 수정: 이곳에 결과 텍스트 출력

			}
		});
		deleteButton.setBounds(353, 294, 95, 23);
		deleteButton.setFont(new Font("휴먼매직체", Font.PLAIN, 12));
		contentPane.add(deleteButton);
		////////////////////////////////////////////////////
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(124, 10, 429, 369);
		lblNewLabel.setIcon(new ImageIcon("E:\\3\uD559\uB1442\uD559\uAE30\\\uB370\uBCA0\\TeamProject\\Database_2024_1\\Images\\\uC778\uC0C1\uD53C\uC790\uD558\uD558\uD558\uD558.png"));
		contentPane.add(lblNewLabel);
		
		
	}
}
