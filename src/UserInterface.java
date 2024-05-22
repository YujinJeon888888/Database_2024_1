import databases.*;
import Dao.*;
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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;

public class UserInterface extends JFrame {

	private JPanel contentPane;
	private JTextField head;

	/**
	 * Launch the application.
	 */
	private static void printTable(ArrayList<?> list) {
		for (Object dto : list) {
			System.out.println(dto);
			
		}
	}

	public static void main(String[] args) {
		//////////
		// db���� test

		/*
		 * SalesLocationDao dao = new SalesLocationDao();
		 * 
		 * System.out.println("=====��ü��ȸ====="); //��ü ��ȸ�ؼ� list�� ���
		 * ArrayList<SalesLocation> list = dao.selectList(); printTable(list);
		 */

		//////////
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
		head.setFont(new Font("�޸ո���ü", Font.PLAIN, 12));
		head.setHorizontalAlignment(SwingConstants.CENTER);
		head.setText("\u2665 \uD589\uBCF5 \uCF58\uC11C\uD2B8 \uD2F0\uCF13\uC7A5 \u2665");
		contentPane.add(head);
		head.setColumns(5);

		////////////////////////////////////////////////////
		/* Application menus and queries �κ� */
		JButton insertButton = new JButton("Insert");
		insertButton.setBounds(23, 263, 95, 23);
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				////////////

				/* �̰��� menu SQL ���� */

				////////////

				resultField.setText("");// ����x
				resultField.append("����");// �̰� ����: �̰��� ��� �ؽ�Ʈ ���
			}
		});
		insertButton.setFont(new Font("�޸ո���ü", Font.PLAIN, 12));
		contentPane.add(insertButton);

		JButton selectButtonVersionA = new JButton("Select(version A)");
		selectButtonVersionA.setBounds(23, 230, 211, 23);
		selectButtonVersionA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				////////////

				/* �̰��� menu SQL ���� */

				////////////
				resultField.setText("");// ����x
				resultField.append("����");// �̰� ����: �̰��� ��� �ؽ�Ʈ ���

			}
		});
		selectButtonVersionA.setFont(new Font("�޸ո���ü", Font.PLAIN, 12));
		contentPane.add(selectButtonVersionA);

		JButton selectButtonVersionB = new JButton("Select(version B)");
		selectButtonVersionB.setBounds(246, 230, 202, 23);
		selectButtonVersionB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				////////////

				/* �̰��� menu SQL ���� */

				////////////
				resultField.setText("");// ����x
				resultField.append("����");// �̰� ����: �̰��� ��� �ؽ�Ʈ ���

			}
		});
		selectButtonVersionB.setFont(new Font("�޸ո���ü", Font.PLAIN, 12));
		contentPane.add(selectButtonVersionB);

		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				////////////

				/* �̰��� menu SQL ���� */

				////////////
				resultField.setText("");// ����x
				resultField.append("����");// �̰� ����: �̰��� ��� �ؽ�Ʈ ���

			}
		});
		updateButton.setBounds(195, 263, 95, 23);
		updateButton.setFont(new Font("�޸ո���ü", Font.PLAIN, 12));
		contentPane.add(updateButton);

		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				////////////

				/* �̰��� menu SQL ���� */

				////////////
				resultField.setText("");// ����x
				resultField.append("����");// �̰� ����: �̰��� ��� �ؽ�Ʈ ���

			}
		});
		deleteButton.setBounds(353, 263, 95, 23);
		deleteButton.setFont(new Font("�޸ո���ü", Font.PLAIN, 12));
		contentPane.add(deleteButton);
		////////////////////////////////////////////////////
		JLabel smileImage = new JLabel("");
		smileImage.setBounds(124, 10, 240, 303);
		smileImage.setIcon(new ImageIcon(
				"E:\\3\uD559\uB1442\uD559\uAE30\\\uB370\uBCA0\\TeamProject\\Database_2024_1\\Images\\\uC778\uC0C1\uD53C\uC790\uD558\uD558\uD558\uD558.png"));
		contentPane.add(smileImage);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(23, 306, 425, 52);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JRadioButton selectSALES_LOCATION = new JRadioButton("SalesLocation");
		selectSALES_LOCATION.setFont(new Font("����", Font.PLAIN, 10));
		layeredPane.add(selectSALES_LOCATION);

		JRadioButton selectCUSTOMER = new JRadioButton("Customer");
		selectCUSTOMER.setFont(new Font("����", Font.PLAIN, 10));
		layeredPane.add(selectCUSTOMER);

		JRadioButton selectAREA = new JRadioButton("Area");
		selectAREA.setFont(new Font("����", Font.PLAIN, 10));
		layeredPane.add(selectAREA);

		JRadioButton selectCASHIER = new JRadioButton("Cashier");
		selectCASHIER.setFont(new Font("����", Font.PLAIN, 10));
		layeredPane.add(selectCASHIER);

		JRadioButton selectSEAT = new JRadioButton("Seat");
		selectSEAT.setFont(new Font("����", Font.PLAIN, 10));
		layeredPane.add(selectSEAT);

		JRadioButton selectVENUE = new JRadioButton("Venue");
		selectVENUE.setFont(new Font("����", Font.PLAIN, 10));
		layeredPane.add(selectVENUE);

		JRadioButton selectCONCERT_SHOWING = new JRadioButton("ConcertShowing");
		selectCONCERT_SHOWING.setFont(new Font("����", Font.PLAIN, 10));
		layeredPane.add(selectCONCERT_SHOWING);

		JRadioButton selectTICKET = new JRadioButton("Ticket");
		selectTICKET.setFont(new Font("����", Font.PLAIN, 10));
		layeredPane.add(selectTICKET);

		ArrayList<JRadioButton> ratioButtons = new ArrayList<JRadioButton>();
		ratioButtons.add(selectSALES_LOCATION);
		ratioButtons.add(selectCUSTOMER);
		ratioButtons.add(selectAREA);
		ratioButtons.add(selectCASHIER);
		ratioButtons.add(selectSEAT);
		ratioButtons.add(selectVENUE);
		ratioButtons.add(selectCONCERT_SHOWING);
		ratioButtons.add(selectTICKET);

		JButton printTable = new JButton("printTable");
		printTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JRadioButton button : ratioButtons) {
					if (button.isSelected()) {
						// ���õƾ��!
						// System.out.println("���õƴٽø���"); 
						String s = button.getText();// ���ڿ� ������ �����ϰ� ���� �Ҵ�
						switch (s) {
						    case "Area": // �� ���ڿ��� ���
						    	AreaDao dao = new AreaDao();
								System.out.println("=====��ü��ȸ====="); //��ü ��ȸ�ؼ� list�� ���
								ArrayList<Area> list = dao.selectList(); printTable(list);
								
						        break;
						    case "Cashier": // �� ���ڿ��� ���
						    	CashierDao dao2 = new CashierDao();
								System.out.println("=====��ü��ȸ====="); //��ü ��ȸ�ؼ� list�� ���
								ArrayList<Cashier> list2 = dao2.selectList(); printTable(list2);

						        break;
						    case "ConcertShowing": // �� ���ڿ��� ���
						    	ConcertShowingDao dao3 = new ConcertShowingDao();
								System.out.println("=====��ü��ȸ====="); //��ü ��ȸ�ؼ� list�� ���
								ArrayList<ConcertShowing> list3 = dao3.selectList(); printTable(list3);
						        break;
						    case "Customer": // �� ���ڿ��� ���
						    	CustomerDao dao4 = new CustomerDao();
								System.out.println("=====��ü��ȸ====="); //��ü ��ȸ�ؼ� list�� ���
								ArrayList<Customer> list4 = dao4.selectList(); printTable(list4);

						        break;
						    case "SalesLocation": // �� ���ڿ��� ���
						    	SalesLocationDao dao5 = new SalesLocationDao();
								System.out.println("=====��ü��ȸ====="); //��ü ��ȸ�ؼ� list�� ���
								ArrayList<SalesLocation> list5 = dao5.selectList(); printTable(list5);
						        break;
						    case "Seat": // �� ���ڿ��� ���
						    	SeatDao dao6 = new SeatDao();
								System.out.println("=====��ü��ȸ====="); //��ü ��ȸ�ؼ� list�� ���
								ArrayList<Seat> list6 = dao6.selectList(); printTable(list6);
						        break;
						    case "Ticket": // �� ���ڿ��� ���
						    	TicketDao dao7 = new TicketDao();
								System.out.println("=====��ü��ȸ====="); //��ü ��ȸ�ؼ� list�� ���
								ArrayList<Ticket> list7 = dao7.selectList(); printTable(list7);
						        break;
						    case "Venue": // �� ���ڿ��� ���
						    	VenueDao dao8 = new VenueDao();
								System.out.println("=====��ü��ȸ====="); //��ü ��ȸ�ؼ� list�� ���
								ArrayList<Venue> list8 = dao8.selectList(); printTable(list8);
						        break;
						    // �ٸ� case ���� �߰� ����
						    default:
						        break; // �⺻ ����
						}

						
					}
				}
			}
		});
		printTable.setFont(new Font("�޸�����ü", Font.BOLD, 12));
		printTable.setBounds(195, 366, 95, 23);
		contentPane.add(printTable);

		JLabel rainbowImage = new JLabel("");
		rainbowImage.setIcon(new ImageIcon(
				"E:\\3\uD559\uB1442\uD559\uAE30\\\uB370\uBCA0\\TeamProject\\Database_2024_1\\Images\\rainbow.png"));
		rainbowImage.setBounds(302, 248, 202, 158);
		contentPane.add(rainbowImage);

		JLabel rainbowImage2 = new JLabel("");
		rainbowImage2.setIcon(new ImageIcon(
				"E:\\3\uD559\uB1442\uD559\uAE30\\\uB370\uBCA0\\TeamProject\\Database_2024_1\\Images\\rainbow.png"));
		rainbowImage2.setBounds(0, 231, 202, 158);
		contentPane.add(rainbowImage2);

	}
}
