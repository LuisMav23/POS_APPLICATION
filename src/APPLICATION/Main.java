package APPLICATION;

/* 
Arellano, Marie Chesca L.
Bautista, Noel Y.
Eslabra, Jan Kristian S.
Gabriel, Luis Maverick L.
Gopez, John Nico M.
*/

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Main{
	public static APPLICATION window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		InitializeWindow();
	}

	public static void InitializeWindow(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new APPLICATION();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}




/****************************************************************************/
/* 							MAIN APPLICATION 								*/
/****************************************************************************/

class APPLICATION extends JFrame implements ActionListener{

	/******		APPLICATION VARIABLES	  ******/
	private final static int ORDER_LIMIT = 100; 
	private int currentIndex = 0;

	private Product SelectedItem = null;
	private static Product[] OrderList = new Product[ORDER_LIMIT];

	private String PaymentMethod = null;

	private double Received = 0.00;
	private double Discount = 0.00;
	private double Total = 0.00;


	/***********	UI COMPONENTS	**********/
	private JLabel lblTitle;

	//TABLE PANEL
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel TableModel;
	
	//TABLE CONTROLS
	private JSpinner spnrQuantity;	
	private JButton btnAdd;	
	private JButton btnClear;
	private JButton btnCheckOut;

	//CUSTOMER INFO PANEL
	private JPanel panelCustInformation;
	private JTextField txtCustName;
	private JLabel lblCustName;
	private JLabel lblAddress;
	private JComboBox cmbAddress;
	private JLabel lblCustInformation;
	private JLabel lblPayMethod;
	private JRadioButton rdbtnCash;
	private JRadioButton rdbtnCreditdebitCard;
	
	//SUB TOTAL PANEL
	private JPanel panelSubTotal;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblTotalDiscount;
	private JLabel lblSubTotal;

	//TABBED PANEL FOR PRODUCTS
	private JTabbedPane tabbedPaneFoodCategories;

	//VEGETABLES PANEL
	private JPanel panelVegetables;
	private JButton btnGinger;
	private JButton btnCarrot;
	private JButton btnEggplant;
	private JButton btnGarlic;
	private JButton btnBroccoli;
	private JButton btnOnion;
	private JButton btnPotato;
	private JButton btnLettuce;
	private JButton btnSquash;
	private JButton btnTomato;
	private JPanel panelProductInformation_1;
	private JLabel lblPType_1;
	private JLabel lblCompName_1;
	private JLabel lblPTax_1;
	private JPanel panelItemInformation_1;
	private JLabel lblSelectedItem_1;
	private JLabel lblPCode_1;
	private JLabel lblPName_1;
	private JLabel lblPPrice_1;
	private JLabel lblSICode_1;
	private JLabel lblSIName_1;
	private JLabel lblSIPrice_1;

	//FRUITS PANEL
	private JPanel panelFruits;
	private JButton btnApple;
	private JButton btnAtis;
	private JButton btnKiwi;
	private JButton btnMango;
	private JButton btnOrange;
	private JButton btnAvocado;
	private JButton btnBanana;
	private JButton btnPineapple;
	private JButton btnWatermelon;
	private JButton btnGrapes;
	private JPanel panelItemInformation_2;
	private JLabel lblSelectedItem_2;
	private JLabel lblPCode_2;
	private JLabel lblPName_2;
	private JLabel lblPPrice_2;
	private JLabel lblSICode_2;
	private JLabel lblSIName_2;
	private JLabel lblSIPrice_2;
	private JPanel panelProductInformation_2;
	private JLabel lblPType_2;
	private JLabel lblCompName_2;
	private JLabel lblPTax_2;
	
	//CANNED GOODS PANEL
	private JPanel panelCannedGoods;
	private JButton btnCanBeans;
	private JButton btnCanCorn;
	private JButton btnLunMeat;
	private JButton btnSardines;
	private JButton btnSweetPineapple;
	private JButton btnCanSalmon;
	private JButton btnCanTuna;
	private JButton btnTomatoPaste;
	private JButton btnVSausage;
	private JButton btnCornedBeef;
	private JPanel panelItemInformation_3;
	private JLabel lblSelectedItem_3;
	private JLabel lblPCode_3;
	private JLabel lblPName_3;
	private JLabel lblPPrice_3;
	private JLabel lblSICode_3;
	private JLabel lblSIName_3;
	private JLabel lblSIPrice_3;
	private JPanel panelProductInformation_3;
	private JLabel lblPType_3;
	private JLabel lblCompName_3;
	private JLabel lblPTax_3;

	//MEAT AND SEAFOODS PANEL
	private JPanel panelMeatAndSeafoods;
	private JButton btnBeef;
	private JButton btnChicken;
	private JButton btnLamb;
	private JButton btnLobster;
	private JButton btnShrimp;
	private JButton btnCrab;
	private JButton btnDuck;
	private JButton btnSquid;
	private JButton btnTurkey;
	private JButton btnGoat;
	private JPanel panelItemInformation_4;
	private JLabel lblSelectedItem_4;
	private JLabel lblPCode_4;
	private JLabel lblPName_4;
	private JLabel lblPPrice_4;
	private JLabel lblSICode_4;
	private JLabel lblSIName_4;
	private JLabel lblSIPrice_4;
	private JPanel panelProductInformation_4;
	private JLabel lblPType_4;
	private JLabel lblCompName_4_1;
	private JLabel lblPTax_4;
	private JLabel lblCompName_4_2;

	//FISH PANEL
	private JPanel panelFish;
	private JButton btnAlumahan;
	private JButton btnBangus;
	private JButton btnLapuLapu;
	private JButton btnMayaMaya;
	private JButton btnTalakitok;	
	private JButton btnBlueMarlin;	
	private JButton btnDalagangBukid;
	private JButton btnTambakol;	
	private JButton btnTawilis;	
	private JButton btnDilis;	
	private JPanel panelItemInformation_5;	
	private JLabel lblSelectedItem_5;
	private JLabel lblPCode_5;	
	private JLabel lblPName_5;	
	private JLabel lblPPrice_5;	
	private JLabel lblSICode_5;	
	private JLabel lblSIName_5;	
	private JLabel lblSIPrice_5;	
	private JPanel panelProductInformation_5;	
	private JLabel lblPType_5;	
	private JLabel lblCompName_5;	
	private JLabel lblPTax_5;	

	/*********** END OF UI COMPONENTS **********/

	/**
	 * Create the application.
	 */
	public APPLICATION() {
		initialize();
	}

	//INITIALIZE UI COMPONENTS
	private void initialize() {
		setTitle("Chesca's POS System");
		setBackground(new Color(72, 61, 139));
		setResizable(false);
		getContentPane().setBackground(new Color(153, 204, 255));
		setBounds(100, 100, 1350, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		panelCustInformation = new JPanel();
		panelCustInformation.setBackground(new Color(153, 255, 255));
		panelCustInformation.setBounds(30, 126, 709, 158);
		getContentPane().add(panelCustInformation);
		panelCustInformation.setLayout(null);
		
		lblCustName = new JLabel("COSTUMER NAME:");
		lblCustName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCustName.setBounds(30, 65, 121, 33);
		panelCustInformation.add(lblCustName);
		
		lblAddress = new JLabel("ADDRESS:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setBounds(30, 108, 73, 33);
		panelCustInformation.add(lblAddress);
		
		cmbAddress = new JComboBox();
		cmbAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbAddress.setModel(new DefaultComboBoxModel(
			new String[] {"Caloocan", "Las Pi\u00F1as", "Makati", "Malabon", 
			"Mandaluyon", "Manila", "Marikina", "Muntinlupa", "Navotas", "Para\u00F1que", 
			"Pasay", "Pasig", "Pateros", "Quezon City", "San Juan", "Taguig", "Valenzuela", 
			"Non-Metro Manila Resident"}));
		cmbAddress.setBounds(157, 110, 192, 28);
		panelCustInformation.add(cmbAddress);
		
		txtCustName = new JTextField();
		txtCustName.setBounds(157, 69, 212, 28);
		panelCustInformation.add(txtCustName);
		txtCustName.setColumns(10);
		
		lblCustInformation = new JLabel("COSTUMER INFORMATION:");
		lblCustInformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCustInformation.setBounds(30, 17, 319, 41);
		panelCustInformation.add(lblCustInformation);
		
		lblPayMethod = new JLabel("Payment Method:");
		lblPayMethod.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPayMethod.setBounds(436, 59, 165, 41);
		panelCustInformation.add(lblPayMethod);
		
		rdbtnCash = new JRadioButton("Cash");
		rdbtnCash.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnCash.setBackground(new Color(153, 255, 255));
		rdbtnCash.setBounds(436, 108, 73, 21);
		rdbtnCash.addActionListener(this);
		panelCustInformation.add(rdbtnCash);
		
		rdbtnCreditdebitCard = new JRadioButton("Credit/Debit Card");
		rdbtnCreditdebitCard.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnCreditdebitCard.setBackground(new Color(153, 255, 255));
		rdbtnCreditdebitCard.setBounds(511, 108, 139, 21);
		rdbtnCreditdebitCard.addActionListener(this);
		panelCustInformation.add(rdbtnCreditdebitCard);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(760, 126, 553, 463);
		getContentPane().add(scrollPane);
		
		TableModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CODE", "NAME", "QTY", "TAX", "PRICE"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setBackground(new Color(255, 255, 255));
		table.setModel(TableModel);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		scrollPane.setViewportView(table);
		
		panelSubTotal = new JPanel();
		panelSubTotal.setBackground(new Color(245, 245, 245));
		panelSubTotal.setBounds(760, 605, 553, 133);
		getContentPane().add(panelSubTotal);
		panelSubTotal.setLayout(null);
		
		lblNewLabel = new JLabel("Sub-Total:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(89, 54, 158, 56);
		panelSubTotal.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Discount:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(87, 10, 158, 50);
		panelSubTotal.add(lblNewLabel_1);
		
		lblTotalDiscount = new JLabel("0.00%");
		lblTotalDiscount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTotalDiscount.setBounds(354, 21, 111, 32);
		panelSubTotal.add(lblTotalDiscount);
		
		lblSubTotal = new JLabel("0.00");
		lblSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubTotal.setBounds(354, 70, 111, 32);
		panelSubTotal.add(lblSubTotal);
		
		tabbedPaneFoodCategories = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneFoodCategories.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabbedPaneFoodCategories.setBounds(30, 294, 589, 444);
		getContentPane().add(tabbedPaneFoodCategories);
		
		panelVegetables = new JPanel();
		panelVegetables.setBackground(new Color(46, 139, 87));
		tabbedPaneFoodCategories.addTab("Vegetables", null, panelVegetables, null);
		panelVegetables.setLayout(null);
		
		btnGinger = new JButton("Ginger");
		btnGinger.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGinger.setBackground(new Color(143, 188, 143));
		btnGinger.setBounds(460, 195, 100, 100);
		btnGinger.addActionListener(this);
		panelVegetables.add(btnGinger);
		
		btnCarrot = new JButton("Carrot");
		btnCarrot.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCarrot.setBackground(new Color(143, 188, 143));
		btnCarrot.setBounds(130, 195, 100, 100);
		btnCarrot.addActionListener(this);
		panelVegetables.add(btnCarrot);
		
		btnEggplant = new JButton("Eggplant");
		btnEggplant.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEggplant.setBackground(new Color(143, 188, 143));
		btnEggplant.setBounds(240, 195, 100, 100);
		btnEggplant.addActionListener(this);
		panelVegetables.add(btnEggplant);
		
		btnGarlic = new JButton("Garlic");
		btnGarlic.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGarlic.setBackground(new Color(143, 188, 143));
		btnGarlic.setBounds(350, 195, 100, 100);
		btnGarlic.addActionListener(this);
		panelVegetables.add(btnGarlic);
		
		btnBroccoli = new JButton("Broccoli");
		btnBroccoli.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBroccoli.setBackground(new Color(143, 188, 143));
		btnBroccoli.setBounds(20, 195, 100, 100);
		btnBroccoli.addActionListener(this);
		panelVegetables.add(btnBroccoli);
		
		btnOnion = new JButton("Onion");
		btnOnion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOnion.setBackground(new Color(143, 188, 143));
		btnOnion.setBounds(130, 305, 100, 100);
		btnOnion.addActionListener(this);
		panelVegetables.add(btnOnion);
		
		btnPotato = new JButton("Potato");
		btnPotato.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPotato.setBackground(new Color(143, 188, 143));
		btnPotato.setBounds(240, 305, 100, 100);
		btnPotato.addActionListener(this);
		panelVegetables.add(btnPotato);
		
		btnLettuce = new JButton("Lettuce");
		btnLettuce.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLettuce.setBackground(new Color(143, 188, 143));
		btnLettuce.setBounds(20, 305, 100, 100);
		btnLettuce.addActionListener(this);
		panelVegetables.add(btnLettuce);
		
		btnSquash = new JButton("Squash");
		btnSquash.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSquash.setBackground(new Color(143, 188, 143));
		btnSquash.setBounds(350, 305, 100, 100);
		btnSquash.addActionListener(this);
		panelVegetables.add(btnSquash);
		
		btnTomato = new JButton("Tomato");
		btnTomato.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTomato.setBackground(new Color(143, 188, 143));
		btnTomato.setBounds(460, 305, 100, 100);
		btnTomato.addActionListener(this);
		panelVegetables.add(btnTomato);
		
		panelProductInformation_1 = new JPanel();
		panelProductInformation_1.setBackground(new Color(143, 188, 143));
		panelProductInformation_1.setBounds(20, 23, 278, 151);
		panelVegetables.add(panelProductInformation_1);
		panelProductInformation_1.setLayout(null);
		
		lblPType_1 = new JLabel("PRODUCT TYPE: VEGETABLES");
		lblPType_1.setBackground(new Color(255, 204, 255));
		lblPType_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPType_1.setBounds(10, 16, 245, 31);
		panelProductInformation_1.add(lblPType_1);
		
		lblCompName_1 = new JLabel("COMPANY NAME: Eya's Green Goods");
		lblCompName_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCompName_1.setBounds(10, 57, 234, 31);
		panelProductInformation_1.add(lblCompName_1);
		
		lblPTax_1 = new JLabel("PRODUCT TAX: 2.00%");
		lblPTax_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPTax_1.setBounds(10, 98, 234, 31);
		panelProductInformation_1.add(lblPTax_1);
		
		panelItemInformation_1 = new JPanel();
		panelItemInformation_1.setLayout(null);
		panelItemInformation_1.setBackground(new Color(143, 188, 143));
		panelItemInformation_1.setBounds(308, 23, 252, 151);
		panelVegetables.add(panelItemInformation_1);
		
		lblSelectedItem_1 = new JLabel("SELECTED ITEM: ");
		lblSelectedItem_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSelectedItem_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectedItem_1.setBounds(10, 10, 232, 41);
		panelItemInformation_1.add(lblSelectedItem_1);
		
		lblPCode_1 = new JLabel("Code:");
		lblPCode_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPCode_1.setBounds(20, 61, 45, 13);
		panelItemInformation_1.add(lblPCode_1);
		
		lblPName_1 = new JLabel("Name:");
		lblPName_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPName_1.setBounds(20, 84, 45, 13);
		panelItemInformation_1.add(lblPName_1);
		
		lblPPrice_1 = new JLabel("Price: ");
		lblPPrice_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPPrice_1.setBounds(20, 108, 45, 13);
		panelItemInformation_1.add(lblPPrice_1);
		
		lblSICode_1 = new JLabel("None");
		lblSICode_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSICode_1.setBounds(82, 61, 70, 13);
		panelItemInformation_1.add(lblSICode_1);
		
		lblSIName_1 = new JLabel("None");
		lblSIName_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSIName_1.setBounds(82, 83, 120, 13);
		panelItemInformation_1.add(lblSIName_1);
		
		lblSIPrice_1 = new JLabel("None");
		lblSIPrice_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSIPrice_1.setBounds(82, 107, 70, 13);
		panelItemInformation_1.add(lblSIPrice_1);
		
		panelFruits = new JPanel();
		panelFruits.setBackground(new Color(153, 50, 204));
		tabbedPaneFoodCategories.addTab("Fruits", null, panelFruits, null);
		panelFruits.setLayout(null);
		
		btnApple = new JButton("Apple");
		btnApple.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnApple.setBackground(new Color(186, 85, 211));
		btnApple.setBounds(20, 195, 100, 100);
		btnApple.addActionListener(this);
		panelFruits.add(btnApple);
		
		btnAtis = new JButton("Atis");
		btnAtis.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtis.setBackground(new Color(186, 85, 211));
		btnAtis.setBounds(130, 195, 100, 100);
		btnAtis.addActionListener(this);
		panelFruits.add(btnAtis);
		
		btnKiwi = new JButton("Kiwi");
		btnKiwi.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnKiwi.setBackground(new Color(186, 85, 211));
		btnKiwi.setBounds(20, 305, 100, 100);
		btnKiwi.addActionListener(this);
		panelFruits.add(btnKiwi);
		
		btnMango = new JButton("Mango");
		btnMango.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMango.setBackground(new Color(186, 85, 211));
		btnMango.setBounds(130, 305, 100, 100);
		btnMango.addActionListener(this);
		panelFruits.add(btnMango);
		
		btnOrange = new JButton("Orange");
		btnOrange.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOrange.setBackground(new Color(186, 85, 211));
		btnOrange.setBounds(240, 305, 100, 100);
		btnOrange.addActionListener(this);
		panelFruits.add(btnOrange);
		
		btnAvocado = new JButton("Avocado");
		btnAvocado.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAvocado.setBackground(new Color(186, 85, 211));
		btnAvocado.setBounds(240, 195, 100, 100);
		btnAvocado.addActionListener(this);
		panelFruits.add(btnAvocado);
		
		btnBanana = new JButton("Banana");
		btnBanana.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBanana.setBackground(new Color(186, 85, 211));
		btnBanana.setBounds(350, 195, 100, 100);
		btnBanana.addActionListener(this);
		panelFruits.add(btnBanana);
		
		btnPineapple = new JButton("Pineapple");
		btnPineapple.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPineapple.setBackground(new Color(186, 85, 211));
		btnPineapple.setBounds(350, 305, 100, 100);
		btnPineapple.addActionListener(this);
		panelFruits.add(btnPineapple);
		
		btnWatermelon = new JButton("Watermelon");
		btnWatermelon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnWatermelon.setBackground(new Color(186, 85, 211));
		btnWatermelon.setBounds(460, 305, 100, 100);
		btnWatermelon.addActionListener(this);
		panelFruits.add(btnWatermelon);
		
		btnGrapes = new JButton("Grapes");
		btnGrapes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGrapes.setBackground(new Color(186, 85, 211));
		btnGrapes.setBounds(460, 195, 100, 100);
		btnGrapes.addActionListener(this);
		panelFruits.add(btnGrapes);
		
		panelItemInformation_2 = new JPanel();
		panelItemInformation_2.setLayout(null);
		panelItemInformation_2.setBackground(new Color(186, 85, 211));
		panelItemInformation_2.setBounds(308, 23, 252, 151);
		panelFruits.add(panelItemInformation_2);
		
		lblSelectedItem_2 = new JLabel("SELECTED ITEM: ");
		lblSelectedItem_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectedItem_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSelectedItem_2.setBounds(10, 10, 232, 41);
		panelItemInformation_2.add(lblSelectedItem_2);
		
		lblPCode_2 = new JLabel("Code:");
		lblPCode_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPCode_2.setBounds(20, 61, 45, 13);
		panelItemInformation_2.add(lblPCode_2);
		
		lblPName_2 = new JLabel("Name:");
		lblPName_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPName_2.setBounds(20, 84, 45, 13);
		panelItemInformation_2.add(lblPName_2);
		
		lblPPrice_2 = new JLabel("Price: ");
		lblPPrice_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPPrice_2.setBounds(20, 108, 45, 13);
		panelItemInformation_2.add(lblPPrice_2);
		
		lblSICode_2 = new JLabel("None");
		lblSICode_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSICode_2.setBounds(82, 61, 70, 13);
		panelItemInformation_2.add(lblSICode_2);
		
		lblSIName_2 = new JLabel("None");
		lblSIName_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSIName_2.setBounds(82, 83, 120, 13);
		panelItemInformation_2.add(lblSIName_2);
		
		lblSIPrice_2 = new JLabel("None");
		lblSIPrice_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSIPrice_2.setBounds(82, 107, 70, 13);
		panelItemInformation_2.add(lblSIPrice_2);
		
		panelProductInformation_2 = new JPanel();
		panelProductInformation_2.setLayout(null);
		panelProductInformation_2.setBackground(new Color(186, 85, 211));
		panelProductInformation_2.setBounds(20, 23, 278, 151);
		panelFruits.add(panelProductInformation_2);
		
		lblPType_2 = new JLabel("PRODUCT TYPE: FRUITS");
		lblPType_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPType_2.setBounds(10, 16, 245, 31);
		panelProductInformation_2.add(lblPType_2);
		
		lblCompName_2 = new JLabel("COMPANY NAME: Fruitivility Co.");
		lblCompName_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCompName_2.setBounds(10, 57, 234, 31);
		panelProductInformation_2.add(lblCompName_2);
		
		lblPTax_2 = new JLabel("PRODUCT TAX: 3.00%");
		lblPTax_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPTax_2.setBounds(10, 98, 234, 31);
		panelProductInformation_2.add(lblPTax_2);
		
		panelCannedGoods = new JPanel();
		panelCannedGoods.setBackground(new Color(128, 128, 128));
		tabbedPaneFoodCategories.addTab("Canned Goods", null, panelCannedGoods, null);
		panelCannedGoods.setLayout(null);
		
		btnCanBeans = new JButton("Canned Beans");
		btnCanBeans.setToolTipText("");
		btnCanBeans.setBackground(new Color(192, 192, 192));
		btnCanBeans.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCanBeans.setBounds(20, 195, 100, 100);
		btnCanBeans.addActionListener(this);
		panelCannedGoods.add(btnCanBeans);
		
		btnCanCorn = new JButton("Canned Corn");
		btnCanCorn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCanCorn.setBackground(new Color(192, 192, 192));
		btnCanCorn.setBounds(130, 195, 100, 100);
		btnCanCorn.addActionListener(this);
		panelCannedGoods.add(btnCanCorn);
		
		btnLunMeat = new JButton("Luncheon Meat");
		btnLunMeat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLunMeat.setBackground(new Color(192, 192, 192));
		btnLunMeat.setBounds(20, 305, 100, 100);
		btnLunMeat.addActionListener(this);
		panelCannedGoods.add(btnLunMeat);
		
		btnSardines = new JButton("Sardines");
		btnSardines.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSardines.setBackground(new Color(192, 192, 192));
		btnSardines.setBounds(130, 305, 100, 100);
		btnSardines.addActionListener(this);
		panelCannedGoods.add(btnSardines);
		
		btnSweetPineapple = new JButton("Sweet Pineapple");
		btnSweetPineapple.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSweetPineapple.setBackground(new Color(192, 192, 192));
		btnSweetPineapple.setBounds(240, 305, 100, 100);
		btnSweetPineapple.addActionListener(this);
		panelCannedGoods.add(btnSweetPineapple);
		
		btnCanSalmon = new JButton("Canned Salmon");
		btnCanSalmon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCanSalmon.setBackground(new Color(192, 192, 192));
		btnCanSalmon.setBounds(240, 195, 100, 100);
		btnCanSalmon.addActionListener(this);
		panelCannedGoods.add(btnCanSalmon);
		
		btnCanTuna = new JButton("Canned Tuna");
		btnCanTuna.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCanTuna.setBackground(new Color(192, 192, 192));
		btnCanTuna.setBounds(350, 195, 100, 100);
		btnCanTuna.addActionListener(this);
		panelCannedGoods.add(btnCanTuna);
		
		btnTomatoPaste = new JButton("Tomato Paste");
		btnTomatoPaste.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTomatoPaste.setBackground(new Color(192, 192, 192));
		btnTomatoPaste.setBounds(350, 305, 100, 100);
		btnTomatoPaste.addActionListener(this);
		panelCannedGoods.add(btnTomatoPaste);
		
		btnVSausage = new JButton("Vienna Sausage");
		btnVSausage.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVSausage.setBackground(new Color(192, 192, 192));
		btnVSausage.setBounds(460, 305, 100, 100);
		btnVSausage.addActionListener(this);
		panelCannedGoods.add(btnVSausage);
		
		btnCornedBeef = new JButton("Corned Beef");
		btnCornedBeef.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCornedBeef.setBackground(new Color(192, 192, 192));
		btnCornedBeef.setBounds(460, 195, 100, 100);
		btnCornedBeef.addActionListener(this);
		panelCannedGoods.add(btnCornedBeef);
		
		panelItemInformation_3 = new JPanel();
		panelItemInformation_3.setLayout(null);
		panelItemInformation_3.setBackground(new Color(192, 192, 192));
		panelItemInformation_3.setBounds(308, 23, 252, 151);
		panelCannedGoods.add(panelItemInformation_3);
		
		lblSelectedItem_3 = new JLabel("SELECTED ITEM: ");
		lblSelectedItem_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectedItem_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSelectedItem_3.setBounds(10, 10, 232, 41);
		panelItemInformation_3.add(lblSelectedItem_3);
		
		lblPCode_3 = new JLabel("Code:");
		lblPCode_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPCode_3.setBounds(20, 61, 45, 13);
		panelItemInformation_3.add(lblPCode_3);
		
		lblPName_3 = new JLabel("Name:");
		lblPName_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPName_3.setBounds(20, 84, 45, 13);
		panelItemInformation_3.add(lblPName_3);
		
		lblPPrice_3 = new JLabel("Price: ");
		lblPPrice_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPPrice_3.setBounds(20, 108, 45, 13);
		panelItemInformation_3.add(lblPPrice_3);
		
		lblSICode_3 = new JLabel("None");
		lblSICode_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSICode_3.setBounds(82, 61, 70, 13);
		panelItemInformation_3.add(lblSICode_3);
		
		lblSIName_3 = new JLabel("None");
		lblSIName_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSIName_3.setBounds(82, 83, 120, 13);
		panelItemInformation_3.add(lblSIName_3);
		
		lblSIPrice_3 = new JLabel("None");
		lblSIPrice_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSIPrice_3.setBounds(82, 107, 70, 13);
		panelItemInformation_3.add(lblSIPrice_3);
		
		panelProductInformation_3 = new JPanel();
		panelProductInformation_3.setLayout(null);
		panelProductInformation_3.setBackground(new Color(192, 192, 192));
		panelProductInformation_3.setBounds(20, 23, 278, 151);
		panelCannedGoods.add(panelProductInformation_3);
		
		lblPType_3 = new JLabel("PRODUCT TYPE: CANNED GOODS");
		lblPType_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPType_3.setBounds(10, 16, 258, 31);
		panelProductInformation_3.add(lblPType_3);
		
		lblCompName_3 = new JLabel("COMPANY NAME: Instant Magic Inc.");
		lblCompName_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCompName_3.setBounds(10, 57, 234, 31);
		panelProductInformation_3.add(lblCompName_3);
		
		lblPTax_3 = new JLabel("PRODUCT TAX: 2.00%");
		lblPTax_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPTax_3.setBounds(10, 98, 234, 31);
		panelProductInformation_3.add(lblPTax_3);
		
		panelMeatAndSeafoods = new JPanel();
		panelMeatAndSeafoods.setBackground(new Color(205, 133, 63));
		tabbedPaneFoodCategories.addTab("Meat and Seafoods", null, panelMeatAndSeafoods, null);
		panelMeatAndSeafoods.setLayout(null);
		
		btnBeef = new JButton("Beef");
		btnBeef.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBeef.setBackground(new Color(210, 180, 140));
		btnBeef.setBounds(20, 195, 100, 100);
		btnBeef.addActionListener(this);
		panelMeatAndSeafoods.add(btnBeef);
		
		btnChicken = new JButton("Chicken");
		btnChicken.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnChicken.setBackground(new Color(210, 180, 140));
		btnChicken.setBounds(130, 195, 100, 100);
		btnChicken.addActionListener(this);
		panelMeatAndSeafoods.add(btnChicken);
		
		btnLamb = new JButton("Lamb");
		btnLamb.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLamb.setBackground(new Color(210, 180, 140));
		btnLamb.setBounds(20, 305, 100, 100);
		btnLamb.addActionListener(this);
		panelMeatAndSeafoods.add(btnLamb);
		
		btnLobster = new JButton("Lobster");
		btnLobster.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLobster.setBackground(new Color(210, 180, 140));
		btnLobster.setBounds(130, 305, 100, 100);
		btnLobster.addActionListener(this);
		panelMeatAndSeafoods.add(btnLobster);
		
		btnShrimp = new JButton("Shrimp");
		btnShrimp.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnShrimp.setBackground(new Color(210, 180, 140));
		btnShrimp.setBounds(240, 305, 100, 100);
		btnShrimp.addActionListener(this);
		panelMeatAndSeafoods.add(btnShrimp);
		
		btnCrab = new JButton("Crab");
		btnCrab.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrab.setBackground(new Color(210, 180, 140));
		btnCrab.setBounds(240, 195, 100, 100);
		btnCrab.addActionListener(this);
		panelMeatAndSeafoods.add(btnCrab);
		
		btnDuck = new JButton("Duck");
		btnDuck.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDuck.setBackground(new Color(210, 180, 140));
		btnDuck.setBounds(350, 195, 100, 100);
		btnDuck.addActionListener(this);
		panelMeatAndSeafoods.add(btnDuck);
		
		btnSquid = new JButton("Squid");
		btnSquid.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSquid.setBackground(new Color(210, 180, 140));
		btnSquid.setBounds(350, 305, 100, 100);
		btnSquid.addActionListener(this);
		panelMeatAndSeafoods.add(btnSquid);
		
		btnTurkey = new JButton("Turkey");
		btnTurkey.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTurkey.setBackground(new Color(210, 180, 140));
		btnTurkey.setBounds(460, 305, 100, 100);
		btnTurkey.addActionListener(this);
		panelMeatAndSeafoods.add(btnTurkey);
		
		btnGoat = new JButton("Goat");
		btnGoat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGoat.setBackground(new Color(210, 180, 140));
		btnGoat.setBounds(460, 195, 100, 100);
		btnGoat.addActionListener(this);
		panelMeatAndSeafoods.add(btnGoat);
		
		panelItemInformation_4 = new JPanel();
		panelItemInformation_4.setLayout(null);
		panelItemInformation_4.setBackground(new Color(210, 180, 140));
		panelItemInformation_4.setBounds(308, 23, 252, 151);
		panelMeatAndSeafoods.add(panelItemInformation_4);
		
		lblSelectedItem_4 = new JLabel("SELECTED ITEM: ");
		lblSelectedItem_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectedItem_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSelectedItem_4.setBounds(10, 10, 232, 41);
		panelItemInformation_4.add(lblSelectedItem_4);
		
		lblPCode_4 = new JLabel("Code:");
		lblPCode_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPCode_4.setBounds(20, 61, 45, 13);
		panelItemInformation_4.add(lblPCode_4);
		
		lblPName_4 = new JLabel("Name:");
		lblPName_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPName_4.setBounds(20, 84, 45, 13);
		panelItemInformation_4.add(lblPName_4);
		
		lblPPrice_4 = new JLabel("Price: ");
		lblPPrice_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPPrice_4.setBounds(20, 108, 45, 13);
		panelItemInformation_4.add(lblPPrice_4);
		
		lblSICode_4 = new JLabel("None");
		lblSICode_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSICode_4.setBounds(82, 61, 70, 13);
		panelItemInformation_4.add(lblSICode_4);
		
		lblSIName_4 = new JLabel("None");
		lblSIName_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSIName_4.setBounds(82, 83, 120, 13);
		panelItemInformation_4.add(lblSIName_4);
		
		lblSIPrice_4 = new JLabel("None");
		lblSIPrice_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSIPrice_4.setBounds(82, 107, 70, 13);
		panelItemInformation_4.add(lblSIPrice_4);
		
		panelProductInformation_4 = new JPanel();
		panelProductInformation_4.setLayout(null);
		panelProductInformation_4.setBackground(new Color(210, 180, 140));
		panelProductInformation_4.setBounds(20, 23, 278, 151);
		panelMeatAndSeafoods.add(panelProductInformation_4);
		
		lblPType_4 = new JLabel("PRODUCT TYPE: MEAT AND ");
		lblPType_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPType_4.setBounds(10, 16, 258, 31);
		panelProductInformation_4.add(lblPType_4);
		
		lblCompName_4_1 = new JLabel("COMPANY NAME: Meat and Greet Inc.");
		lblCompName_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCompName_4_1.setBounds(10, 68, 234, 31);
		panelProductInformation_4.add(lblCompName_4_1);
		
		lblPTax_4 = new JLabel("PRODUCT TAX: 15.0%");
		lblPTax_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPTax_4.setBounds(10, 98, 234, 31);
		panelProductInformation_4.add(lblPTax_4);
		
		lblCompName_4_2 = new JLabel("SEA FOODS");
		lblCompName_4_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCompName_4_2.setBounds(136, 41, 92, 19);
		panelProductInformation_4.add(lblCompName_4_2);
		
		panelFish = new JPanel();
		panelFish.setBackground(new Color(70, 130, 180));
		tabbedPaneFoodCategories.addTab("Fish", null, panelFish, null);
		panelFish.setLayout(null);
		
		btnAlumahan = new JButton("Alumahan");
		btnAlumahan.setBackground(new Color(176, 196, 222));
		btnAlumahan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlumahan.setBounds(20, 195, 100, 100);
		btnAlumahan.addActionListener(this);
		panelFish.add(btnAlumahan);
		
		btnBangus = new JButton("Bangus");
		btnBangus.setBackground(new Color(176, 196, 222));
		btnBangus.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBangus.setBounds(130, 195, 100, 100);
		btnBangus.addActionListener(this);
		panelFish.add(btnBangus);
		
		btnLapuLapu = new JButton("Lapu-Lapu");
		btnLapuLapu.setBackground(new Color(176, 196, 222));
		btnLapuLapu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLapuLapu.setBounds(20, 305, 100, 100);
		btnLapuLapu.addActionListener(this);
		panelFish.add(btnLapuLapu);
		
		btnMayaMaya = new JButton("Maya-Maya");
		btnMayaMaya.setBackground(new Color(176, 196, 222));
		btnMayaMaya.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMayaMaya.setBounds(130, 305, 100, 100);
		btnMayaMaya.addActionListener(this);
		panelFish.add(btnMayaMaya);
		
		btnTalakitok = new JButton("Talakitok");
		btnTalakitok.setBackground(new Color(176, 196, 222));
		btnTalakitok.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTalakitok.setBounds(240, 305, 100, 100);
		btnTalakitok.addActionListener(this);
		panelFish.add(btnTalakitok);
		
		btnBlueMarlin = new JButton("Blue Marlin");
		btnBlueMarlin.setBackground(new Color(176, 196, 222));
		btnBlueMarlin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBlueMarlin.setBounds(240, 195, 100, 100);
		btnBlueMarlin.addActionListener(this);
		panelFish.add(btnBlueMarlin);
		
		btnDalagangBukid = new JButton("Dalagang Bukid");
		btnDalagangBukid.setBackground(new Color(176, 196, 222));
		btnDalagangBukid.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDalagangBukid.setBounds(350, 195, 100, 100);
		btnDalagangBukid.addActionListener(this);
		panelFish.add(btnDalagangBukid);
		
		btnTambakol = new JButton("Tambakol");
		btnTambakol.setBackground(new Color(176, 196, 222));
		btnTambakol.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTambakol.setBounds(350, 305, 100, 100);
		btnTambakol.addActionListener(this);
		panelFish.add(btnTambakol);
		
		btnTawilis = new JButton("Tawilis");
		btnTawilis.setBackground(new Color(176, 196, 222));
		btnTawilis.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTawilis.setBounds(460, 305, 100, 100);
		btnTawilis.addActionListener(this);
		panelFish.add(btnTawilis);
		
		btnDilis = new JButton("Dilis");
		btnDilis.setBackground(new Color(176, 196, 222));
		btnDilis.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDilis.setBounds(460, 195, 100, 100);
		btnDilis.addActionListener(this);
		panelFish.add(btnDilis);
		
		panelItemInformation_5 = new JPanel();
		panelItemInformation_5.setLayout(null);
		panelItemInformation_5.setBackground(new Color(176, 196, 222));
		panelItemInformation_5.setBounds(308, 23, 252, 151);
		panelFish.add(panelItemInformation_5);
		
		lblSelectedItem_5 = new JLabel("SELECTED ITEM: ");
		lblSelectedItem_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectedItem_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSelectedItem_5.setBounds(10, 10, 232, 41);
		panelItemInformation_5.add(lblSelectedItem_5);
		
		lblPCode_5 = new JLabel("Code:");
		lblPCode_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPCode_5.setBounds(20, 61, 45, 13);
		panelItemInformation_5.add(lblPCode_5);
		
		lblPName_5 = new JLabel("Name:");
		lblPName_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPName_5.setBounds(20, 84, 45, 13);
		panelItemInformation_5.add(lblPName_5);
		
		lblPPrice_5 = new JLabel("Price: ");
		lblPPrice_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPPrice_5.setBounds(20, 108, 45, 13);
		panelItemInformation_5.add(lblPPrice_5);
		
		lblSICode_5 = new JLabel("None");
		lblSICode_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSICode_5.setBounds(82, 61, 70, 13);
		panelItemInformation_5.add(lblSICode_5);
		
		lblSIName_5 = new JLabel("None");
		lblSIName_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSIName_5.setBounds(82, 83, 120, 13);
		panelItemInformation_5.add(lblSIName_5);
		
		lblSIPrice_5 = new JLabel("None");
		lblSIPrice_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSIPrice_5.setBounds(82, 107, 70, 13);
		panelItemInformation_5.add(lblSIPrice_5);
		
		panelProductInformation_5 = new JPanel();
		panelProductInformation_5.setLayout(null);
		panelProductInformation_5.setBackground(new Color(176, 196, 222));
		panelProductInformation_5.setBounds(20, 23, 278, 151);
		panelFish.add(panelProductInformation_5);
		
		lblPType_5 = new JLabel("PRODUCT TYPE: FISH");
		lblPType_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPType_5.setBounds(10, 16, 245, 31);
		panelProductInformation_5.add(lblPType_5);
		
		lblCompName_5 = new JLabel("COMPANY NAME: Ocean Chief Co.");
		lblCompName_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCompName_5.setBounds(10, 57, 234, 31);
		panelProductInformation_5.add(lblCompName_5);
		
		lblPTax_5 = new JLabel("PRODUCT TAX: 10.00%");
		lblPTax_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPTax_5.setBounds(10, 98, 234, 31);
		panelProductInformation_5.add(lblPTax_5);
		
		btnAdd = new JButton("ADD");
		btnAdd.setBackground(new Color(176, 196, 222));
		btnAdd.setBounds(639, 394, 100, 100);
		btnAdd.addActionListener(this);
		getContentPane().add(btnAdd);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnClear = new JButton("CLEAR");
		btnClear.setBackground(new Color(176, 196, 222));
		btnClear.setBounds(639, 504, 100, 100);
		btnClear.addActionListener(this);
		getContentPane().add(btnClear);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		spnrQuantity = new JSpinner();
		spnrQuantity.setFont(new Font("Tahoma", Font.BOLD, 15));
		spnrQuantity.setModel(new SpinnerNumberModel(0, 0, 50, 1));
		spnrQuantity.setBounds(639, 338, 100, 46);
		getContentPane().add(spnrQuantity);
		
		btnCheckOut = new JButton("CHECK-OUT");
		btnCheckOut.setBackground(new Color(176, 196, 222));
		btnCheckOut.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCheckOut.setBounds(639, 614, 100, 100);
		btnCheckOut.addActionListener(this);
		getContentPane().add(btnCheckOut);
		
		lblTitle = new JLabel("CHESCA'S WET MARKET");
		lblTitle.setFont(new Font("Stencil", Font.BOLD, 70));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 32, 1316, 71);
		getContentPane().add(lblTitle);

		setDiscount();
	}

	/***************************************************************************/



	/************************		EVENT HANDLER		************************/
	@Override
	public void actionPerformed(ActionEvent e) {

		/***** COMBO BOX EVENT *****/
		setDiscount();

		/***** PAYMENT RADIO BUTTON EVENT *****/
		if (e.getSource() == rdbtnCash){
			rdbtnCreditdebitCard.setSelected(false);
			PaymentMethod = "cash";
		}
		else if (e.getSource() == rdbtnCreditdebitCard){
			rdbtnCash.setSelected(false);
			PaymentMethod = "card";
		}
		

		/*** PRODUCT BUTTONS ***/

		var button = (JButton) e.getSource();
		
		if (button.getParent() == panelVegetables){
			SelectedItem = null;
			SelectedItem =  new Product("001", button.getText());
		}

		if (button.getParent() == panelFruits){
			SelectedItem = null;
			SelectedItem =  new Product("002", button.getText());
		}

		if (button.getParent() == panelCannedGoods){
			SelectedItem = null;
			SelectedItem =  new Product("003", button.getText());
		}

		if (button.getParent() == panelMeatAndSeafoods){
			SelectedItem = null;
			SelectedItem =  new Product("004", button.getText());
		}

		if (button.getParent() == panelFish){
			SelectedItem = null;
			SelectedItem =  new Product("005", button.getText());
		}


		/***** SELECTED ITEM LABELS *****/

		if (SelectedItem != null) {

			lblSICode_1.setText(SelectedItem.getProductCode());
			lblSICode_2.setText(SelectedItem.getProductCode());
			lblSICode_3.setText(SelectedItem.getProductCode());
			lblSICode_4.setText(SelectedItem.getProductCode());
			lblSICode_5.setText(SelectedItem.getProductCode());
	
			lblSIName_1.setText(SelectedItem.getProductName());
			lblSIName_2.setText(SelectedItem.getProductName());
			lblSIName_3.setText(SelectedItem.getProductName());
			lblSIName_4.setText(SelectedItem.getProductName());
			lblSIName_5.setText(SelectedItem.getProductName());

			lblSIPrice_1.setText(Double.toString(SelectedItem.getProductPrice()));
			lblSIPrice_2.setText(Double.toString(SelectedItem.getProductPrice()));
			lblSIPrice_3.setText(Double.toString(SelectedItem.getProductPrice()));
			lblSIPrice_4.setText(Double.toString(SelectedItem.getProductPrice()));
			lblSIPrice_5.setText(Double.toString(SelectedItem.getProductPrice()));
		}


		/***** ADD BUTTON EVENT *****/

		if (button == btnAdd){
			if (SelectedItem != null){
				var qty = (int)spnrQuantity.getValue();
				if (qty > 0) {
					SelectedItem.setQuantity(qty);
	
					OrderList[currentIndex] = SelectedItem;
					Object[] currProd = {
						SelectedItem.getProductCode(), 
						SelectedItem.getProductName(), 
						SelectedItem.getQuantity(),
						SelectedItem.getProductTax(),
						SelectedItem.getProductPrice()};
					TableModel.addRow(currProd);
						
					currentIndex++;
					emptySelectedItem();
					spnrQuantity.setValue(0);
					calculateTotal();
				}
				else {
					JOptionPane.showMessageDialog(this, "Please Enter Quantity.", "No Quantity", JOptionPane.DEFAULT_OPTION);
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Please Select an Item", "No Item Selected", JOptionPane.DEFAULT_OPTION);
			}
		}


		/***** CLEAR BUTTON EVENT *****/

		if (button == btnClear){
			if (TableModel.getValueAt(0, 0) != null){
				for (int i = TableModel.getRowCount() - 1; i >= 0; i--){
					TableModel.removeRow(i);
				}
				clearOrderList();
			}
			calculateTotal();
			currentIndex = 0;
		}

		
		/***** CHECK-OUT BUTTON EVENT *****/

		if (button == btnCheckOut){
			if (txtCustName.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please Enter Customer Name", "NO CUSTOMER NAME", JOptionPane.DEFAULT_OPTION);
				return;
			}
			else{
				if (TableModel.getRowCount() != 0){
	
					try{
						if (PaymentMethod.equals("cash")){
							try{
								var input = (String) JOptionPane.showInputDialog(this , "Enter Amount Received", "");
								Received = Double.parseDouble(input);
								if (Received < Total){
									JOptionPane.showMessageDialog(this, "Amount Entered is not Enough", "INSUFFICIENT AMOUNT", JOptionPane.DEFAULT_OPTION);
									return;
								}
	
								if (input.equals(null)){
									JOptionPane.showMessageDialog(this, "Please Enter a Valid Amount", "INVALID INPUT", JOptionPane.DEFAULT_OPTION);
									return;
								}
							}
							catch (Exception ex){
								JOptionPane.showMessageDialog(this, "Please Enter a Valid Amount", "INVALID INPUT", JOptionPane.DEFAULT_OPTION);
								return;
							}
						}
						else if (PaymentMethod.equals("card")){
							JOptionPane.showInputDialog(this , "Enter Card Pin", "");
						}
					}
					catch (Exception ex){
						JOptionPane.showMessageDialog(this, "Please Select Payment Method", "No Payment Method Selected", JOptionPane.DEFAULT_OPTION);
						return;
					}
				}
				else {
					JOptionPane.showMessageDialog(this, "Please Select Your Desired Products", "ORDERS EMPTY", JOptionPane.DEFAULT_OPTION);
					return;
				}
			}

			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Receipt frame = new Receipt();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		
	}

	/***************************** END EVENT HANDLER *****************************/

	private void emptySelectedItem(){
		SelectedItem = null;

		lblSICode_1.setText("None");
		lblSICode_2.setText("None");
		lblSICode_3.setText("None");
		lblSICode_4.setText("None");
		lblSICode_5.setText("None");

		lblSIName_1.setText("None");
		lblSIName_2.setText("None");
		lblSIName_3.setText("None");
		lblSIName_4.setText("None");
		lblSIName_5.setText("None");

		lblSIPrice_1.setText("None");
		lblSIPrice_2.setText("None");
		lblSIPrice_3.setText("None");
		lblSIPrice_4.setText("None");
		lblSIPrice_5.setText("None");
	}

	private void clearOrderList(){
		if (OrderList != null){
			for (int i = 0; i < OrderList.length; i++){
				OrderList[i] = null;
			}
		}
	}

	private void calculateTotal(){
		var t = (double) 0;
		for (Product prod : this.OrderList){
			if (prod != null){
				t += prod.getProductPrice();
			}
			else {
				break;
			}
		}
		this.Total = t;
		lblSubTotal.setText(Double.toString(Total));
	}

	private void setDiscount(){
		var add = (String) cmbAddress.getSelectedItem();
		if (add.equals("Caloocan") || add.equals("Malabon") || add.equals("Navotas") || add.equals("Valenzuela")){
			this.Discount = 0.15;
		}
		else{
			this.Discount = 0.00;
		}

		lblTotalDiscount.setText(Double.toString(this.Discount * 100) + " %");
	}




/**********************************/
/* 	    	RECEIPT CLASS		  */
/**********************************/

	public class Receipt extends JFrame implements ActionListener{

		private JPanel contentPane;
		private JTable table;
		
		private JLabel lblName_1;
		private JLabel lblAddress_1;
		
		private JLabel lblTotal_1;
		private JLabel lblCash_1;
		private JLabel lblChange_1;
		private JLabel lblDiscount_1;

		private JButton btnExit;
		private JButton btnMenu;

		private DefaultTableModel tableModel;

		/**
		 * Create the receipt frame.
		 */
		public Receipt() {
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 453, 759);
			setResizable(false);
			setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBackground(SystemColor.controlShadow);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLayeredPane layeredPane = new JLayeredPane();
			layeredPane.setBounds(10, 10, 419, 90);
			contentPane.add(layeredPane);
			
			JLabel lblChescas = new JLabel("Chesca's");
			lblChescas.setFont(new Font("Kristen ITC", Font.PLAIN, 30));
			lblChescas.setHorizontalAlignment(SwingConstants.LEFT);
			lblChescas.setVerticalAlignment(SwingConstants.TOP);
			lblChescas.setBounds(45, 2, 154, 34);
			layeredPane.add(lblChescas);
			
			JLabel lblContact = new JLabel("Contact:");
			lblContact.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
			lblContact.setBounds(318, 2, 91, 34);
			layeredPane.add(lblContact);
			
			JLabel lblWetMarket = new JLabel("WET MARKET");
			lblWetMarket.setVerticalAlignment(SwingConstants.TOP);
			lblWetMarket.setHorizontalAlignment(SwingConstants.LEFT);
			lblWetMarket.setFont(new Font("Goudy Old Style", Font.PLAIN, 12));
			lblWetMarket.setBounds(93, 41, 84, 15);
			layeredPane.add(lblWetMarket);
			
			JLabel lblContNumber = new JLabel("314-099-1235");
			lblContNumber.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 11));
			lblContNumber.setBounds(306, 22, 113, 24);
			layeredPane.add(lblContNumber);
			
			JLabel lblContEmail = new JLabel("Cwetmarket@gmail.com");
			lblContEmail.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 12));
			lblContEmail.setBounds(271, 35, 148, 24);
			layeredPane.add(lblContEmail);
			
			JLabel lblTYMessage = new JLabel("THANK YOU FOR BUYING!");
			lblTYMessage.setVerticalAlignment(SwingConstants.TOP);
			lblTYMessage.setHorizontalAlignment(SwingConstants.LEFT);
			lblTYMessage.setFont(new Font("Goudy Old Style", Font.PLAIN, 12));
			lblTYMessage.setBounds(0, 67, 167, 15);
			layeredPane.add(lblTYMessage);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 557, 419, 8);
			contentPane.add(separator);
			
			JLabel lblTotal = new JLabel("Total:");
			lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
			lblTotal.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
			lblTotal.setBounds(35, 597, 63, 49);
			contentPane.add(lblTotal);
			
			JLabel lblCash = new JLabel("Cash:");
			lblCash.setHorizontalAlignment(SwingConstants.CENTER);
			lblCash.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
			lblCash.setBounds(233, 557, 63, 49);
			contentPane.add(lblCash);
			
			JLabel lblChange = new JLabel("Change:");
			lblChange.setHorizontalAlignment(SwingConstants.CENTER);
			lblChange.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
			lblChange.setBounds(233, 597, 63, 49);
			contentPane.add(lblChange);
			
			lblTotal_1 = new JLabel("None");
			lblTotal_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblTotal_1.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
			lblTotal_1.setBounds(120, 597, 119, 49);
			contentPane.add(lblTotal_1);
			
			lblCash_1 = new JLabel("None");
			lblCash_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblCash_1.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
			lblCash_1.setBounds(306, 557, 123, 49);
			contentPane.add(lblCash_1);
			
			lblChange_1 = new JLabel("None");
			lblChange_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblChange_1.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
			lblChange_1.setBounds(306, 597, 123, 49);
			contentPane.add(lblChange_1);
			
			btnExit = new JButton("Exit");
			btnExit.setBackground(SystemColor.activeCaptionBorder);
			btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnExit.setBounds(234, 672, 104, 40);
			btnExit.addActionListener(this);
			contentPane.add(btnExit);
			
			btnMenu = new JButton("Back to Menu");
			btnMenu.setBackground(SystemColor.activeCaptionBorder);
			btnMenu.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnMenu.setBounds(57, 672, 164, 40);
			btnMenu.addActionListener(this);
			contentPane.add(btnMenu);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 211, 419, 336);
			contentPane.add(scrollPane);
		
			tableModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"                  Product Name", "             Qty.", "                Price"
				}
			);
			table = new JTable();
			table.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
			table.setModel(tableModel);
			table.getColumnModel().getColumn(0).setPreferredWidth(130);
			table.getColumnModel().getColumn(1).setPreferredWidth(50);
			scrollPane.setViewportView(table);
			
			JPanel panel = new JPanel();
			panel.setBounds(10, 110, 419, 90);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Customer Name: ");
			lblNewLabel.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
			lblNewLabel.setBounds(10, 10, 133, 23);
			panel.add(lblNewLabel);
			
			JLabel lblAddress = new JLabel("Address: ");
			lblAddress.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
			lblAddress.setBounds(10, 43, 133, 23);
			panel.add(lblAddress);
			
			lblName_1 = new JLabel("None");
			lblName_1.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
			lblName_1.setBounds(136, 11, 273, 20);
			panel.add(lblName_1);
			
			lblAddress_1 = new JLabel("None");
			lblAddress_1.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
			lblAddress_1.setBounds(136, 43, 273, 20);
			panel.add(lblAddress_1);
			
			JLabel lblDiscountl = new JLabel("Discount:");
			lblDiscountl.setHorizontalAlignment(SwingConstants.LEFT);
			lblDiscountl.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
			lblDiscountl.setBounds(35, 557, 79, 49);
			contentPane.add(lblDiscountl);
			
			lblDiscount_1 = new JLabel("None");
			lblDiscount_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblDiscount_1.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
			lblDiscount_1.setBounds(120, 557, 120, 49);
			contentPane.add(lblDiscount_1);

			setReceiptInfo();
		}

		private void setReceiptInfo(){

			lblName_1.setText(txtCustName.getText());
			lblAddress_1.setText((String)cmbAddress.getSelectedItem());

			for (Product prod : OrderList) {
				if (prod != null){
					
					Object[] product = {prod.getProductName(), prod.getQuantity(), prod.getProductPrice()};
					tableModel.addRow(product);
				}
			}

			lblTotal_1.setText(Double.toString(Total));
			lblDiscount_1.setText(Double.toString(Discount * 100) + " %");

			if (PaymentMethod.equals("cash")){
				lblCash_1.setText(Double.toString(Received));
				lblChange_1.setText(Double.toString(Received - Total));
			}
			else if(PaymentMethod.equals("card")){
				lblCash_1.setText("PAID WITH CARD");
				lblChange_1.setText("None");
			}

		}

		public void actionPerformed(ActionEvent e){
			if (e.getSource() == btnMenu) {
				this.dispose();
				Main.window.dispose();
				Main.InitializeWindow();
				Total = 0;
			}

			if(e.getSource() == btnExit){
				System.exit(0);
			}

		}
	}
}






/*************************************************/
/*				   PRODUCT CLASS			     */
/*************************************************/

class Product {
	private String ProductCode;
    private String ProductName;
    private double ProductPrice;
    private double ProductTax;
    private int Quantity;
	
	public Product(String PCode, String PName) {
		setProductCode(PCode);
		setProductName(PName);
		setProductPrice(PCode, PName);
		setProductTax(PCode);
    }

	/* GETTERS */

	public String getProductCode() {
        return this.ProductCode;
    }

    public String getProductName() {
        return this.ProductName;
    }

    public double getProductPrice() {
        return this.ProductPrice;
    }

	public double getProductTax() {
		return this.ProductTax;
	}

    public int getQuantity() {
        return this.Quantity;
    }

	/* SETTERS */

	private void setProductCode(String PCode) {
		this.ProductCode = PCode;
	}

	private void setProductName(String PName) {
		this.ProductName = PName;
	}

	private void setProductPrice(String PCode, String PName) {
		switch(PCode){
			case "001":
				switch(PName){
					case "Broccoli":
						this.ProductPrice = 130;
						break;
					case "Carrot":
						this.ProductPrice = 95;
						break;
					case "Eggplant":
						this.ProductPrice = 100;
						break;
					case "Garlic":
						this.ProductPrice = 150;
						break;
					case "Ginger":
						this.ProductPrice = 185;
						break;
					case "Lettuce":
						this.ProductPrice = 100;
						break;
					case "Onion":
						this.ProductPrice = 150;
						break;
					case "Potato":
						this.ProductPrice = 80;
						break;
					case "Squash":
						this.ProductPrice = 50;
						break;
					case "Tomato":
						this.ProductPrice = 125;
						break;
				}
				break;
			case "002":
				switch(PName){
					case "Apple":
						this.ProductPrice = 154;
						break;
					case "Atis":
						this.ProductPrice = 230;
						break;
					case "Avocado":
						this.ProductPrice = 120;
						break;
					case "Banana":
						this.ProductPrice = 80;
						break;
					case "Grapes":
						this.ProductPrice = 280;
						break;
					case "Kiwi":
						this.ProductPrice = 330;
						break;
					case "Mango":
						this.ProductPrice = 159;
						break;
					case "Orange":
						this.ProductPrice = 40;
						break;
					case "Pinaple":
						this.ProductPrice = 300;
						break;
					case "Watermelon":
						this.ProductPrice = 350;
						break;
				}
				break;
			case "003":
				switch(PName){
					case "Canned Beans":
						this.ProductPrice = 65;
						break;
					case "Canned Corn":
						this.ProductPrice = 34;
						break;
					case "Canned Salmon":
						this.ProductPrice = 159;
						break;
					case "Canned Tuna":
						this.ProductPrice = 32;
						break;
					case "Corned Beef":
						this.ProductPrice = 29;
						break;
					case "Luncheon Meat":
						this.ProductPrice = 95;
						break;
					case "Sardines":
						this.ProductPrice = 25;
						break;
					case "Sweet Pineapple":
						this.ProductPrice = 53;
						break;
					case "Tomato Paste":
						this.ProductPrice = 34;
						break;
					case "Vienna Sausage":
						this.ProductPrice = 60;
						break;
				}
				break;
			case "004":
				switch(PName){
					case "Beef":
						this.ProductPrice = 280;
						break;
					case "Chicken":
						this.ProductPrice = 200;
						break;
					case "Crab":
						this.ProductPrice = 550;
						break;
					case "Duck":
						this.ProductPrice = 200;
						break;
					case "Goat":
						this.ProductPrice = 270;
						break;
					case "Lamb":
						this.ProductPrice = 1500;
						break;
					case "Lobster":
						this.ProductPrice = 720;
						break;
					case "Shrimp":
						this.ProductPrice = 500;
						break;
					case "Squid":
						this.ProductPrice = 550;
						break;
					case "Turkey":
						this.ProductPrice = 380;
						break;
				}
				break;
			case "005":
				switch(PName){
					case "Alumahan":
						this.ProductPrice = 280;
						break;
					case "Bangus":
						this.ProductPrice = 200;
						break;
					case "Blue Marlin":
						this.ProductPrice = 750;
						break;
					case "Dalagang Bukid":
						this.ProductPrice = 300;
						break;
					case "Dilis":
						this.ProductPrice = 240;
						break;
					case "Lapu-Lapu":
						this.ProductPrice = 370;
						break;
					case "Maya-Maya":
						this.ProductPrice = 350;
						break;
					case "Talakitok":
						this.ProductPrice = 760;
						break;
					case "Tambakol":
						this.ProductPrice = 330;
						break;
					case "Tawilis":
						this.ProductPrice = 220;
						break;
				}
				break;
		}
	}

	private  void setProductTax(String PCode) {
		switch(PCode){
			case "001":
				this.ProductTax = 0.02;
				break;
			case "002":
				this.ProductTax = 0.03;
				break;
			case "003":
				this.ProductTax = 0.02;
				break;
			case "004":
				this.ProductTax = 0.15;
				break;
			case "005":
				this.ProductTax = 0.10;
				break;
		}
	}

	public void setQuantity(int qty){
		this.Quantity = qty;
		var tax = this.ProductPrice * this.ProductTax;
		var taxedPrice = this.ProductPrice + tax;
		this.ProductPrice = qty * taxedPrice;
	}
}

