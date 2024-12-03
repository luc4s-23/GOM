package controller;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;

public class SistemaGerenciamentoController extends JFrame {
	private JTextField textField_Nome;
	private JTextField textField_Endereco;
	private JTextField textField_CPF;
	private JTextField textField_Email;
	private JTextField textField_Telefone;
	private JTextField textField_Ano;
	private JTextField textField_Placa;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTable tableVeiculosCliente;
	private JTable tableDevedores;

	public SistemaGerenciamentoController() {
		setTitle("Sistema de Gerenciamento de Oficinas");
		getContentPane().setBackground(new Color(0, 0, 0));
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(240, 240, 240));
		getContentPane().add(painelPrincipal);
		painelPrincipal.setLayout(new CardLayout(0, 0));

		JPanel painelVazio = new JPanel();
		painelVazio.setBackground(new Color(0, 0, 0));
		painelPrincipal.add(painelVazio, "PAINEL VAZIO");

		JPanel painelCadastroCliente = new JPanel();
		painelCadastroCliente.setBackground(new Color(0, 0, 0));
		painelCadastroCliente.setLayout(null);
		painelPrincipal.add(painelCadastroCliente, "PAINEL CADASTRO CLIENTE");

		JLabel labelInfoCliente = new JLabel("Informações do Cliente");
		labelInfoCliente.setForeground(new Color(255, 255, 255));
		labelInfoCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelInfoCliente.setBounds(279, 28, 241, 25);
		painelCadastroCliente.add(labelInfoCliente);

		textField_Nome = new JTextField();
		textField_Nome.setColumns(10);
		textField_Nome.setBounds(212, 65, 357, 25);
		painelCadastroCliente.add(textField_Nome);

		textField_Endereco = new JTextField();
		textField_Endereco.setColumns(10);
		textField_Endereco.setBounds(212, 101, 357, 25);
		painelCadastroCliente.add(textField_Endereco);

		textField_CPF = new JTextField();
		textField_CPF.setColumns(10);
		textField_CPF.setBounds(212, 137, 357, 25);
		painelCadastroCliente.add(textField_CPF);

		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(212, 173, 357, 25);
		painelCadastroCliente.add(textField_Email);

		textField_Telefone = new JTextField();
		textField_Telefone.setColumns(10);
		textField_Telefone.setBounds(212, 209, 357, 25);
		painelCadastroCliente.add(textField_Telefone);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(123, 68, 46, 14);
		painelCadastroCliente.add(lblNome);

		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setForeground(new Color(255, 255, 255));
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEndereco.setBounds(123, 104, 79, 14);
		painelCadastroCliente.add(lblEndereco);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setForeground(new Color(255, 255, 255));
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCPF.setBounds(123, 140, 46, 14);
		painelCadastroCliente.add(lblCPF);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(123, 176, 46, 14);
		painelCadastroCliente.add(lblEmail);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefone.setBounds(123, 212, 67, 14);
		painelCadastroCliente.add(lblTelefone);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setForeground(new Color(255, 255, 255));
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMarca.setBounds(123, 310, 46, 14);
		painelCadastroCliente.add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setForeground(new Color(255, 255, 255));
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModelo.setBounds(123, 347, 79, 14);
		painelCadastroCliente.add(lblModelo);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setForeground(new Color(255, 255, 255));
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAno.setBounds(123, 383, 46, 14);
		painelCadastroCliente.add(lblAno);

		textField_Ano = new JTextField();
		textField_Ano.setColumns(10);
		textField_Ano.setBounds(212, 380, 357, 25);
		painelCadastroCliente.add(textField_Ano);

		JLabel lblMotor = new JLabel("Motor:");
		lblMotor.setForeground(new Color(255, 255, 255));
		lblMotor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMotor.setBounds(123, 420, 46, 14);
		painelCadastroCliente.add(lblMotor);

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setForeground(new Color(255, 255, 255));
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPlaca.setBounds(123, 455, 67, 14);
		painelCadastroCliente.add(lblPlaca);

		textField_Placa = new JTextField();
		textField_Placa.setColumns(10);
		textField_Placa.setBounds(212, 452, 357, 25);
		painelCadastroCliente.add(textField_Placa);

		JLabel lblInfoVeiculo = new JLabel("Informações do Veículo");
		lblInfoVeiculo.setForeground(new Color(255, 255, 255));
		lblInfoVeiculo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInfoVeiculo.setBounds(281, 271, 241, 25);
		painelCadastroCliente.add(lblInfoVeiculo);

		JComboBox comboBoxMarca = new JComboBox();
		comboBoxMarca.setBounds(212, 308, 357, 25);
		painelCadastroCliente.add(comboBoxMarca);

		JComboBox comboBoxModelo = new JComboBox();
		comboBoxModelo.setBounds(212, 344, 357, 25);
		painelCadastroCliente.add(comboBoxModelo);

		JComboBox comboBoxMotor = new JComboBox();
		comboBoxMotor.setBounds(212, 416, 357, 25);
		painelCadastroCliente.add(comboBoxMotor);

		JButton btnCadastrarCliente = new JButton("Cadastrar");
		btnCadastrarCliente.setBackground(new Color(0, 0, 0));
		btnCadastrarCliente.setForeground(new Color(255, 255, 255));
		btnCadastrarCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCadastrarCliente.setBounds(212, 501, 357, 25);
		btnCadastrarCliente.setBorder(new LineBorder(Color.white));
		painelCadastroCliente.add(btnCadastrarCliente);

		JPanel painelCadastrarVeiculo = new JPanel();
		painelCadastrarVeiculo.setBackground(new Color(0, 0, 0));
		painelCadastrarVeiculo.setLayout(null);
		painelPrincipal.add(painelCadastrarVeiculo, "PAINEL CADASTRO VEICULO");

		JLabel lblInfoVeiculo_1 = new JLabel("Informações do Veículo");
		lblInfoVeiculo_1.setForeground(new Color(255, 255, 255));
		lblInfoVeiculo_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInfoVeiculo_1.setBounds(281, 198, 241, 25);
		painelCadastrarVeiculo.add(lblInfoVeiculo_1);

		JComboBox comboBoxMarca_1 = new JComboBox();
		comboBoxMarca_1.setBounds(212, 235, 357, 25);
		painelCadastrarVeiculo.add(comboBoxMarca_1);

		JLabel lblMarca_1 = new JLabel("Marca:");
		lblMarca_1.setForeground(new Color(255, 255, 255));
		lblMarca_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMarca_1.setBounds(123, 237, 46, 14);
		painelCadastrarVeiculo.add(lblMarca_1);

		JLabel lblModelo_1 = new JLabel("Modelo:");
		lblModelo_1.setForeground(new Color(255, 255, 255));
		lblModelo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModelo_1.setBounds(123, 280, 79, 14);
		painelCadastrarVeiculo.add(lblModelo_1);

		JComboBox comboBoxModelo_1 = new JComboBox();
		comboBoxModelo_1.setBounds(212, 277, 357, 25);
		painelCadastrarVeiculo.add(comboBoxModelo_1);

		textField_Ano = new JTextField();
		textField_Ano.setColumns(10);
		textField_Ano.setBounds(212, 317, 357, 25);
		painelCadastrarVeiculo.add(textField_Ano);

		JLabel lblAno_1 = new JLabel("Ano:");
		lblAno_1.setForeground(new Color(255, 255, 255));
		lblAno_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAno_1.setBounds(123, 320, 46, 14);
		painelCadastrarVeiculo.add(lblAno_1);

		JLabel lblMotor_1 = new JLabel("Motor:");
		lblMotor_1.setForeground(new Color(255, 255, 255));
		lblMotor_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMotor_1.setBounds(123, 360, 46, 14);
		painelCadastrarVeiculo.add(lblMotor_1);

		JComboBox comboBoxMotor_1 = new JComboBox();
		comboBoxMotor_1.setBounds(212, 356, 357, 25);
		painelCadastrarVeiculo.add(comboBoxMotor_1);

		JLabel lblPlaca_1 = new JLabel("Placa:");
		lblPlaca_1.setForeground(new Color(255, 255, 255));
		lblPlaca_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPlaca_1.setBounds(123, 399, 67, 14);
		painelCadastrarVeiculo.add(lblPlaca_1);

		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(212, 396, 357, 25);
		painelCadastrarVeiculo.add(textField_17);

		JButton btnCadastrarVeiculo = new JButton("Cadastrar veículo");
		btnCadastrarVeiculo.setForeground(new Color(255, 255, 255));
		btnCadastrarVeiculo.setBackground(new Color(0, 0, 0));
		btnCadastrarVeiculo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCadastrarVeiculo.setBounds(212, 450, 357, 25);
		btnCadastrarVeiculo.setBorder(new LineBorder(Color.white));
		painelCadastrarVeiculo.add(btnCadastrarVeiculo);

		JLabel lblSelecCliente = new JLabel("Selecione o Cliente");
		lblSelecCliente.setForeground(new Color(255, 255, 255));
		lblSelecCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSelecCliente.setBounds(295, 78, 198, 25);
		painelCadastrarVeiculo.add(lblSelecCliente);

		JComboBox comboBox_Cliente = new JComboBox();
		comboBox_Cliente.setBounds(212, 114, 357, 25);
		painelCadastrarVeiculo.add(comboBox_Cliente);

		JPanel painelConsultaCliente = new JPanel();
		painelConsultaCliente.setBackground(new Color(0, 0, 0));
		painelConsultaCliente.setLayout(null);
		painelPrincipal.add(painelConsultaCliente, "PAINEL CONSULTA CLIENTE");

		JLabel labelInfoCliente_1 = new JLabel("Informações do Cliente");
		labelInfoCliente_1.setForeground(new Color(255, 255, 255));
		labelInfoCliente_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelInfoCliente_1.setBounds(272, 126, 241, 25);
		painelConsultaCliente.add(labelInfoCliente_1);

		JLabel lblEndereco_1 = new JLabel("Endereço:");
		lblEndereco_1.setForeground(new Color(255, 255, 255));
		lblEndereco_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEndereco_1.setBounds(116, 165, 79, 14);
		painelConsultaCliente.add(lblEndereco_1);

		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(205, 162, 357, 25);
		painelConsultaCliente.add(textField_18);

		JLabel lblCPF_1_1 = new JLabel("CPF:");
		lblCPF_1_1.setForeground(new Color(255, 255, 255));
		lblCPF_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCPF_1_1.setBounds(116, 201, 46, 14);
		painelConsultaCliente.add(lblCPF_1_1);

		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(205, 198, 357, 25);
		painelConsultaCliente.add(textField_19);

		JLabel lblEmail_1_1 = new JLabel("Email:");
		lblEmail_1_1.setForeground(new Color(255, 255, 255));
		lblEmail_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail_1_1.setBounds(116, 237, 46, 14);
		painelConsultaCliente.add(lblEmail_1_1);

		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(205, 234, 357, 25);
		painelConsultaCliente.add(textField_20);

		JLabel lblTelefone_1_1 = new JLabel("Telefone:");
		lblTelefone_1_1.setForeground(new Color(255, 255, 255));
		lblTelefone_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefone_1_1.setBounds(116, 273, 67, 14);
		painelConsultaCliente.add(lblTelefone_1_1);

		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(205, 270, 357, 25);
		painelConsultaCliente.add(textField_21);

		JLabel lblSelecCliente_1 = new JLabel("Selecione o Cliente");
		lblSelecCliente_1.setForeground(new Color(255, 255, 255));
		lblSelecCliente_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSelecCliente_1.setBounds(288, 48, 198, 25);
		painelConsultaCliente.add(lblSelecCliente_1);

		JComboBox comboBoxSelecCliente = new JComboBox();
		comboBoxSelecCliente.setBounds(205, 84, 357, 25);
		painelConsultaCliente.add(comboBoxSelecCliente);

		JLabel lblDivida = new JLabel("Dívida:");
		lblDivida.setForeground(new Color(255, 255, 255));
		lblDivida.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDivida.setBounds(116, 310, 67, 14);
		painelConsultaCliente.add(lblDivida);

		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(205, 307, 91, 25);
		painelConsultaCliente.add(textField_22);

		tableVeiculosCliente = new JTable();
		tableVeiculosCliente.setBounds(116, 360, 521, 112);
		painelConsultaCliente.add(tableVeiculosCliente);

		JPanel painelDevedores = new JPanel();
		painelDevedores.setLayout(null);
		painelPrincipal.add(painelDevedores, "PAINEL DEVEDORES");

		tableDevedores = new JTable();
		tableDevedores.setBounds(26, 105, 587, 326);
		painelDevedores.add(tableDevedores);

		JLabel lblDevedores = new JLabel("Lista de Devedores");
		lblDevedores.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDevedores.setBounds(218, 41, 198, 25);
		painelDevedores.add(lblDevedores);

		JButton btnNovaDivida = new JButton("Nova Dívida");
		btnNovaDivida.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNovaDivida.setBounds(46, 56, 109, 23);
		painelDevedores.add(btnNovaDivida);

		JPanel painelCadastroOS = new JPanel();
		painelCadastroOS.setBackground(new Color(0, 0, 0));
		painelCadastroOS.setLayout(null);
		painelPrincipal.add(painelCadastroOS, "PAINEL CADASTRO OS");

		JLabel lblClienteOS_1 = new JLabel("Para qual Cliente?");
		lblClienteOS_1.setForeground(new Color(255, 255, 255));
		lblClienteOS_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClienteOS_1.setBounds(54, 26, 199, 25);
		painelCadastroOS.add(lblClienteOS_1);

		JComboBox comboBoxClienteOS_1 = new JComboBox();
		comboBoxClienteOS_1.setForeground(new Color(255, 255, 255));
		comboBoxClienteOS_1.setBounds(28, 62, 317, 25);
		painelCadastroOS.add(comboBoxClienteOS_1);

		JLabel lblVeiculoOS_1 = new JLabel("Qual Veículo?");
		lblVeiculoOS_1.setForeground(new Color(255, 255, 255));
		lblVeiculoOS_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVeiculoOS_1.setBounds(509, 26, 146, 25);
		painelCadastroOS.add(lblVeiculoOS_1);

		JComboBox comboBoxVeiculoOS_1 = new JComboBox();
		comboBoxVeiculoOS_1.setBounds(444, 62, 317, 25);
		painelCadastroOS.add(comboBoxVeiculoOS_1);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabbedPane_1.setBounds(81, 128, 422, 377);
		painelCadastroOS.add(tabbedPane_1);

		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(509, 153, 164, 352);
		painelCadastroOS.add(textArea_1);
		
		JButton btnNewButton = new JButton("Criar O.S");
		btnNewButton.setBounds(294, 542, 221, 25);
		painelCadastroOS.add(btnNewButton);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new LineBorder(Color.BLACK));
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(new Color(0, 0, 0));
		setJMenuBar(menuBar);

		JMenu menuCadastro = new JMenu("Cadastrar");
		menuCadastro.setBorder(new LineBorder(Color.black));
		menuCadastro.setForeground(new Color(255, 255, 255));
		menuCadastro.setBackground(new Color(240, 240, 240));
		menuBar.add(menuCadastro);

		JMenuItem menuItemCadastrarCliente = new JMenuItem("Cadastrar Cliente");
		menuItemCadastrarCliente.setBorder(new LineBorder(Color.black));
		menuItemCadastrarCliente.setForeground(new Color(255, 255, 255));
		menuItemCadastrarCliente.setBackground(new Color(0, 0, 0));

		menuItemCadastrarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				CardLayout cl = (CardLayout) painelPrincipal.getLayout();
				cl.show(painelPrincipal, "PAINEL CADASTRO CLIENTE");
			}
		});

		menuCadastro.add(menuItemCadastrarCliente);

		JMenuItem menuItemCadastrarVeiculo = new JMenuItem("Cadastrar Veículo");
		menuItemCadastrarVeiculo.setBorder(new LineBorder(Color.black));
		menuItemCadastrarVeiculo.setForeground(new Color(255, 255, 255));
		menuItemCadastrarVeiculo.setBackground(new Color(0, 0, 0));
		menuItemCadastrarVeiculo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) painelPrincipal.getLayout();
				cl.show(painelPrincipal, "PAINEL CADASTRO VEICULO");

			}
		});

		menuCadastro.add(menuItemCadastrarVeiculo);

		JMenuItem menuItemCadastrarOS = new JMenuItem("Cadastrar Ordem de Serviço");
		menuItemCadastrarOS.setBorder(new LineBorder(Color.black));
		menuItemCadastrarOS.setForeground(new Color(255, 255, 255));
		menuItemCadastrarOS.setBackground(new Color(0, 0, 0));
		menuItemCadastrarOS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) painelPrincipal.getLayout();
				cl.show(painelPrincipal, "PAINEL CADASTRO OS");

			}
		});
		menuCadastro.add(menuItemCadastrarOS);

		JMenu menuConsulta = new JMenu("Consultar");
		menuConsulta.setForeground(new Color(255, 255, 255));
		menuBar.add(menuConsulta);

		JMenuItem menuItemConsultarCliente = new JMenuItem("Consultar Cliente");
		menuItemConsultarCliente.setForeground(new Color(255, 255, 255));
		menuItemConsultarCliente.setBackground(new Color(0, 0, 0));
		menuItemConsultarCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) painelPrincipal.getLayout();
				cl.show(painelPrincipal, "PAINEL CONSULTA CLIENTE");

			}
		});
		menuConsulta.add(menuItemConsultarCliente);

		JMenu menuDevedores = new JMenu("Devedores");
		menuDevedores.setForeground(new Color(255, 255, 255));

		menuBar.add(menuDevedores);

		JMenuItem menuItemDevedores = new JMenuItem("Lista de Devedores");
		menuItemDevedores.setForeground(new Color(255, 255, 255));
		menuItemDevedores.setBackground(new Color(0, 0, 0));
		menuItemDevedores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) painelPrincipal.getLayout();
				cl.show(painelPrincipal, "PAINEL DEVEDORES");

			}
		});
		menuDevedores.add(menuItemDevedores);

		setSize(800, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);

		ImageIcon fav = new ImageIcon("img/favicon.png");
		setIconImage(fav.getImage());

	}
	public static void main(String[] args) {
		new SistemaGerenciamentoController();
	}
}
