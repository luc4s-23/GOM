package view;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.Scrollbar;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import java.awt.Choice;
import java.awt.List;
import java.awt.TextArea;
import javax.swing.JCheckBox;

public class SistemaView extends JFrame {
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtCPF;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField txtDivida;
	private JTable tableVeiculosCliente;
	private JTable tableDevedores;
	private JTextField txtProblema;
	private JTextField textField_3;

	public SistemaView() {
		getContentPane().setLayout(new CardLayout(0, 0));

		JPanel painelVazio = new JPanel();
		getContentPane().add(painelVazio, "name_133964548283699");

		JPanel painelCadastroCliente = new JPanel();
		getContentPane().add(painelCadastroCliente, "name_134063272851900");
		painelCadastroCliente.setLayout(null);

		JLabel labelInfoCliente = new JLabel("Informações do Cliente");
		labelInfoCliente.setBounds(200, 21, 241, 25);
		labelInfoCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		painelCadastroCliente.add(labelInfoCliente);

		txtNome = new JTextField();
		txtNome.setBounds(133, 58, 357, 20);
		painelCadastroCliente.add(txtNome);
		txtNome.setColumns(10);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(133, 89, 357, 20);
		txtEndereco.setColumns(10);
		painelCadastroCliente.add(txtEndereco);

		txtCPF = new JTextField();
		txtCPF.setBounds(133, 120, 357, 20);
		txtCPF.setColumns(10);
		painelCadastroCliente.add(txtCPF);

		txtEmail = new JTextField();
		txtEmail.setBounds(133, 152, 357, 20);
		txtEmail.setColumns(10);
		painelCadastroCliente.add(txtEmail);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(133, 183, 357, 20);
		txtTelefone.setColumns(10);
		painelCadastroCliente.add(txtTelefone);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(44, 61, 46, 14);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		painelCadastroCliente.add(lblNome);

		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(44, 92, 79, 14);
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 13));
		painelCadastroCliente.add(lblEndereco);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(44, 123, 46, 14);
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 13));
		painelCadastroCliente.add(lblCPF);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(44, 155, 46, 14);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		painelCadastroCliente.add(lblEmail);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(44, 186, 67, 14);
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 13));
		painelCadastroCliente.add(lblTelefone);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(44, 264, 46, 14);
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 13));
		painelCadastroCliente.add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(44, 295, 79, 14);
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 13));
		painelCadastroCliente.add(lblModelo);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(44, 326, 46, 14);
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 13));
		painelCadastroCliente.add(lblAno);

		textField_2 = new JTextField();
		textField_2.setBounds(133, 323, 357, 20);
		textField_2.setColumns(10);
		painelCadastroCliente.add(textField_2);

		JLabel lblMotor = new JLabel("Motor:");
		lblMotor.setBounds(44, 358, 46, 14);
		lblMotor.setFont(new Font("Tahoma", Font.BOLD, 13));
		painelCadastroCliente.add(lblMotor);

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(44, 389, 67, 14);
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 13));
		painelCadastroCliente.add(lblPlaca);

		textField_4 = new JTextField();
		textField_4.setBounds(133, 386, 357, 20);
		textField_4.setColumns(10);
		painelCadastroCliente.add(textField_4);

		JLabel lblInfoVeiculo = new JLabel("Informações do Veículo");
		lblInfoVeiculo.setBounds(202, 225, 241, 25);
		lblInfoVeiculo.setFont(new Font("Tahoma", Font.BOLD, 20));
		painelCadastroCliente.add(lblInfoVeiculo);

		JComboBox comboBoxMarca = new JComboBox();
		comboBoxMarca.setBounds(133, 262, 357, 20);
		painelCadastroCliente.add(comboBoxMarca);

		JComboBox comboBoxModelo = new JComboBox();
		comboBoxModelo.setBounds(133, 292, 357, 20);
		painelCadastroCliente.add(comboBoxModelo);

		JComboBox comboBoxMotor = new JComboBox();
		comboBoxMotor.setBounds(133, 354, 357, 20);
		painelCadastroCliente.add(comboBoxMotor);

		JButton btnCadastrarCliente = new JButton("Cadastrar");
		btnCadastrarCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCadastrarCliente.setBounds(263, 440, 105, 25);
		painelCadastroCliente.add(btnCadastrarCliente);

		JPanel painelCadastrarVeiculo = new JPanel();
		getContentPane().add(painelCadastrarVeiculo, "name_87398631969900");
		painelCadastrarVeiculo.setLayout(null);

		JLabel lblInfoVeiculo_1 = new JLabel("Informações do Veículo");
		lblInfoVeiculo_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInfoVeiculo_1.setBounds(221, 192, 241, 25);
		painelCadastrarVeiculo.add(lblInfoVeiculo_1);

		JComboBox comboBoxMarca_1 = new JComboBox();
		comboBoxMarca_1.setBounds(152, 229, 357, 20);
		painelCadastrarVeiculo.add(comboBoxMarca_1);

		JLabel lblMarca_1 = new JLabel("Marca:");
		lblMarca_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMarca_1.setBounds(63, 231, 46, 14);
		painelCadastrarVeiculo.add(lblMarca_1);

		JLabel lblModelo_1 = new JLabel("Modelo:");
		lblModelo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModelo_1.setBounds(63, 262, 79, 14);
		painelCadastrarVeiculo.add(lblModelo_1);

		JComboBox comboBoxModelo_1 = new JComboBox();
		comboBoxModelo_1.setBounds(152, 259, 357, 20);
		painelCadastrarVeiculo.add(comboBoxModelo_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(152, 290, 357, 20);
		painelCadastrarVeiculo.add(textField);

		JLabel lblAno_1 = new JLabel("Ano:");
		lblAno_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAno_1.setBounds(63, 293, 46, 14);
		painelCadastrarVeiculo.add(lblAno_1);

		JLabel lblMotor_1 = new JLabel("Motor:");
		lblMotor_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMotor_1.setBounds(63, 325, 46, 14);
		painelCadastrarVeiculo.add(lblMotor_1);

		JComboBox comboBoxMotor_1 = new JComboBox();
		comboBoxMotor_1.setBounds(152, 321, 357, 20);
		painelCadastrarVeiculo.add(comboBoxMotor_1);

		JLabel lblPlaca_1 = new JLabel("Placa:");
		lblPlaca_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPlaca_1.setBounds(63, 356, 67, 14);
		painelCadastrarVeiculo.add(lblPlaca_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(152, 353, 357, 20);
		painelCadastrarVeiculo.add(textField_1);

		JButton btnCadastrarVeiculo = new JButton("Cadastrar");
		btnCadastrarVeiculo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCadastrarVeiculo.setBounds(282, 407, 105, 25);
		painelCadastrarVeiculo.add(btnCadastrarVeiculo);

		JLabel lblSelecCliente = new JLabel("Selecione o Cliente");
		lblSelecCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSelecCliente.setBounds(235, 23, 198, 25);
		painelCadastrarVeiculo.add(lblSelecCliente);

		JComboBox comboBoxMarca_1_1 = new JComboBox();
		comboBoxMarca_1_1.setBounds(152, 59, 357, 20);
		painelCadastrarVeiculo.add(comboBoxMarca_1_1);

		JPanel painelConsultaCliente = new JPanel();
		getContentPane().add(painelConsultaCliente, "name_87931813309000");
		painelConsultaCliente.setLayout(null);

		JLabel labelInfoCliente_1 = new JLabel("Informações do Cliente");
		labelInfoCliente_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelInfoCliente_1.setBounds(218, 96, 241, 25);
		painelConsultaCliente.add(labelInfoCliente_1);

		JLabel lblEndereco_1 = new JLabel("Endereço:");
		lblEndereco_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEndereco_1.setBounds(62, 135, 79, 14);
		painelConsultaCliente.add(lblEndereco_1);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(151, 132, 357, 20);
		painelConsultaCliente.add(textField_5);

		JLabel lblCPF_1 = new JLabel("CPF:");
		lblCPF_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCPF_1.setBounds(62, 166, 46, 14);
		painelConsultaCliente.add(lblCPF_1);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(151, 163, 357, 20);
		painelConsultaCliente.add(textField_6);

		JLabel lblEmail_1 = new JLabel("Email:");
		lblEmail_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail_1.setBounds(62, 198, 46, 14);
		painelConsultaCliente.add(lblEmail_1);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(151, 195, 357, 20);
		painelConsultaCliente.add(textField_7);

		JLabel lblTelefone_1 = new JLabel("Telefone:");
		lblTelefone_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefone_1.setBounds(62, 229, 67, 14);
		painelConsultaCliente.add(lblTelefone_1);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(151, 226, 357, 20);
		painelConsultaCliente.add(textField_8);

		JLabel lblSelecCliente_1 = new JLabel("Selecione o Cliente");
		lblSelecCliente_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSelecCliente_1.setBounds(234, 18, 198, 25);
		painelConsultaCliente.add(lblSelecCliente_1);

		JComboBox comboBoxMarca_1_1_1 = new JComboBox();
		comboBoxMarca_1_1_1.setBounds(151, 54, 357, 20);
		painelConsultaCliente.add(comboBoxMarca_1_1_1);

		JLabel lblDivida = new JLabel("Dívida:");
		lblDivida.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDivida.setBounds(62, 257, 67, 14);
		painelConsultaCliente.add(lblDivida);

		txtDivida = new JTextField();
		txtDivida.setColumns(10);
		txtDivida.setBounds(151, 254, 91, 20);
		painelConsultaCliente.add(txtDivida);

		tableVeiculosCliente = new JTable();
		tableVeiculosCliente.setBounds(62, 330, 521, 112);
		painelConsultaCliente.add(tableVeiculosCliente);

		JPanel painelDevedores = new JPanel();
		getContentPane().add(painelDevedores, "name_88506026789900");
		painelDevedores.setLayout(null);

		tableDevedores = new JTable();
		tableDevedores.setBounds(26, 105, 587, 326);
		painelDevedores.add(tableDevedores);

		JLabel lblDevedores = new JLabel("Lista de Devedores");
		lblDevedores.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDevedores.setBounds(218, 41, 198, 25);
		painelDevedores.add(lblDevedores);

		JPanel painelCadastroOS = new JPanel();
		getContentPane().add(painelCadastroOS, "name_88809402198400");
		painelCadastroOS.setLayout(null);

		JLabel lblClienteOS = new JLabel("Para qual Cliente?");
		lblClienteOS.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClienteOS.setBounds(54, 26, 199, 25);
		painelCadastroOS.add(lblClienteOS);

		JComboBox comboBoxClienteOS = new JComboBox();
		comboBoxClienteOS.setBounds(28, 62, 257, 20);
		painelCadastroOS.add(comboBoxClienteOS);

		JLabel lblVeiculoOS = new JLabel("Qual Veículo?");
		lblVeiculoOS.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVeiculoOS.setBounds(379, 26, 146, 25);
		painelCadastroOS.add(lblVeiculoOS);

		JComboBox comboBoxVeiculoOS = new JComboBox();
		comboBoxVeiculoOS.setBounds(314, 62, 268, 20);
		painelCadastroOS.add(comboBoxVeiculoOS);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabbedPane.setBounds(28, 115, 422, 377);
		painelCadastroOS.add(tabbedPane);

		JPanel painelProblema = new JPanel();
		tabbedPane.addTab("Problema", null, painelProblema, null);
		painelProblema.setLayout(null);

		JLabel lblProblema = new JLabel("Dê uma descrição do Problema");
		lblProblema.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProblema.setBounds(10, 27, 235, 25);
		painelProblema.add(lblProblema);

		txtProblema = new JTextField();
		txtProblema.setBounds(10, 52, 386, 69);
		painelProblema.add(txtProblema);
		txtProblema.setColumns(10);

		JPanel painelServicos = new JPanel();
		tabbedPane.addTab("Serviços", null, painelServicos, null);
		painelServicos.setLayout(null);

		JPanel painelPagamento = new JPanel();
		tabbedPane.addTab("Pagamento", null, painelPagamento, null);
		painelPagamento.setLayout(null);

		JLabel lblFormaDePagamento = new JLabel("Forma de Pagamento");
		lblFormaDePagamento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFormaDePagamento.setBounds(10, 11, 164, 25);
		painelPagamento.add(lblFormaDePagamento);

		JCheckBox chckbxDinheiro = new JCheckBox("Dinheiro");
		chckbxDinheiro.setBounds(10, 43, 97, 23);
		painelPagamento.add(chckbxDinheiro);

		JCheckBox chckbxPix = new JCheckBox("Pix");
		chckbxPix.setBounds(10, 69, 97, 23);
		painelPagamento.add(chckbxPix);

		JCheckBox chckbxCarto = new JCheckBox("Cartão");
		chckbxCarto.setBounds(124, 43, 97, 23);
		painelPagamento.add(chckbxCarto);

		JCheckBox chckbxOutro = new JCheckBox("Outro");
		chckbxOutro.setBounds(124, 69, 97, 23);
		painelPagamento.add(chckbxOutro);

		textField_3 = new JTextField();
		textField_3.setBounds(238, 46, 156, 46);
		painelPagamento.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblObservacoes = new JLabel("Observações");
		lblObservacoes.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblObservacoes.setBounds(238, 11, 164, 25);
		painelPagamento.add(lblObservacoes);

		TextArea textArea = new TextArea();
		textArea.setBounds(456, 140, 164, 352);
		painelCadastroOS.add(textArea);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuCadastro = new JMenu("Cadastrar");
		menuBar.add(menuCadastro);

		JMenuItem menuItemCadastrarCliente = new JMenuItem("Cadastrar Cliente");
		menuCadastro.add(menuItemCadastrarCliente);

		JMenuItem menuItemCadastrarVeiculo = new JMenuItem("Cadastrar Veículo");
		menuCadastro.add(menuItemCadastrarVeiculo);

		JMenuItem menuItemCadastrarOS = new JMenuItem("Cadastrar Ordem de Serviço");
		menuCadastro.add(menuItemCadastrarOS);

		JMenu menuConsulta = new JMenu("Consultar");
		menuBar.add(menuConsulta);

		JMenuItem menuItemConsultarCliente = new JMenuItem("Consultar Cliente");
		menuConsulta.add(menuItemConsultarCliente);

		JMenu menuDevedores = new JMenu("Devedores");
		menuBar.add(menuDevedores);

		JMenuItem menuItemDevedores = new JMenuItem("Lista de Devedores");
		menuDevedores.add(menuItemDevedores);

	}

	public static void main(String[] args) {
		new SistemaView();
	}
}
