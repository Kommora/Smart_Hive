package smart_hive.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import smart_hive.client.Client;
import smart_hive.client.Observer;
import smart_hive.client.ReceiveHives;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class ClientView extends JFrame implements Observer {

	private JFrame frame;

	ReceiveHives clientExecution = new ReceiveHives();
	//Definindo as colunas da tabela
	private final String colunas[] = {"Id Colmeia","Weigh","In Temper", "Ex Temper", "Location", "Moment"};
	//Manipular os dados vindos do socket via json em um array
	private String dataHive[][] = new String[5000][6];
	public DefaultTableModel modeloTable;
	private ReceiveHives modelReceiveHives;
	private int cont = 0;

	
//	private static

	private JTable tableInfoHive;

	/**
	 * Launch the application.
	 */
	public void abrirView(){
		setVisible(true);

	}

	/**
	 * Create the application.
	 */
	public ClientView() {

		//initialize();
	}

	public ClientView(String[] info,  ReceiveHives RH) {
		this.modelReceiveHives = RH;

		atualizaInfo(info);

		initialize();
		update();
	}

	public void atualizaInfo(String[] info){
		dataHive[this.cont][0] = info[0].replace("}","").split(":")[1];
		dataHive[this.cont][1] = info[1].replace("{","").split(":")[1];
		dataHive[this.cont][2] = info[2].split(":")[1];
		dataHive[this.cont][3] = info[3].split(":")[1];
		dataHive[this.cont][4] = info[4].split(":")[1];
		dataHive[this.cont][5] = info[5].split(":")[1];

		this.cont++;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setLayout(new FlowLayout());
		setSize(1000, 400);
		setLocationRelativeTo(null);
		setTitle("Informações Colméia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		modeloTable = new DefaultTableModel();
		modeloTable.setColumnIdentifiers(colunas);

//		tableInfoHive = new JTable(dataHive, colunas);
		tableInfoHive = new JTable(modeloTable);
		tableInfoHive.setPreferredScrollableViewportSize(new Dimension(800,800));
		tableInfoHive.setFillsViewportHeight(true);
		tableInfoHive.setAutoscrolls(true);
		JScrollPane scrollPane=new JScrollPane(tableInfoHive);
		add(scrollPane);

		//modeloTable.insertRow(0, dataHive[0]);

	}


	@Override
	public void update() {
//		modeloTable.setRowCount(0);
//
//		for(int i = 0;i < this.cont;i++){
//            modeloTable.insertRow(i, dataHive[i]);
//            modeloTable.insertRow(0, dataHive[i]);
//        }

		modeloTable.insertRow(0,dataHive[0]);



	}
}
