package controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.Cliente;
import model.Fabricante;
import model.Modelo;
import model.Veiculo;
import model.DAO.ClienteDAO;
import model.DAO.FabricanteDAO;
import model.DAO.ModeloDAO;
import model.DAO.VeiculoDAO;

public class SistemaGerenciamentoController extends JFrame {
	private JTextField textField_NomeCliente;
	private JTextField textField_EnderecoCliente;
	private JTextField textField_CPFCliente;
	private JTextField textField_EmailCliente;
	private JTextField textField_TelefoneCliente;
	private JTextField textField_Ano;
	private JTextField textField_Placa;
	private JTextField textField_17;
	private JTextField textField_Endereco;
	private JTextField textField_CPF;
	private JTextField textField_emial;
	private JTextField telefone;
	private JTextField textField_divida;
	private JTable tableVeiculosCliente;
	private JTable tableDevedores;
	private JComboBox comboBoxSelecCliente;
	private JTextField textField_Motor;

	private ClienteDAO cDAO;
	private VeiculoDAO vDAO;
	private ModeloDAO mDAO;
	private FabricanteDAO fDAO;
	private JTextField textFieldDescricao;
	private JTextField textFieldValor;
	private JTextField textFieldQuant;
	private JTextField textField;

	public SistemaGerenciamentoController() {
		this.cDAO = new ClienteDAO();
		this.vDAO = new VeiculoDAO();
		
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

		// CLIENTE
		JPanel painelCadastroCliente = new JPanel();
		painelCadastroCliente.setBackground(new Color(0, 0, 0));
		painelCadastroCliente.setLayout(null);
		painelPrincipal.add(painelCadastroCliente, "PAINEL CADASTRO CLIENTE");

		JLabel labelInfoCliente = new JLabel("Informações do Cliente");
		labelInfoCliente.setForeground(new Color(255, 255, 255));
		labelInfoCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelInfoCliente.setBounds(279, 28, 241, 25);
		painelCadastroCliente.add(labelInfoCliente);

		textField_NomeCliente = new JTextField();
		textField_NomeCliente.setColumns(10);
		textField_NomeCliente.setBounds(212, 65, 357, 25);
		painelCadastroCliente.add(textField_NomeCliente);

		textField_EnderecoCliente = new JTextField();
		textField_EnderecoCliente.setColumns(10);
		textField_EnderecoCliente.setBounds(212, 101, 357, 25);
		painelCadastroCliente.add(textField_EnderecoCliente);

		textField_CPFCliente = new JTextField();
		textField_CPFCliente.setColumns(10);
		textField_CPFCliente.setBounds(212, 137, 357, 25);
		painelCadastroCliente.add(textField_CPFCliente);

		textField_EmailCliente = new JTextField();
		textField_EmailCliente.setColumns(10);
		textField_EmailCliente.setBounds(212, 173, 357, 25);
		painelCadastroCliente.add(textField_EmailCliente);

		textField_TelefoneCliente = new JTextField();
		textField_TelefoneCliente.setColumns(10);
		textField_TelefoneCliente.setBounds(212, 209, 357, 25);
		painelCadastroCliente.add(textField_TelefoneCliente);

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
		// CLIENTE

		JLabel lblMarca = new JLabel("Fabricanta:");
		lblMarca.setForeground(new Color(255, 255, 255));
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMarca.setBounds(123, 310, 79, 14);
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

		JComboBox<Fabricante> comboBoxFabricante = new JComboBox<Fabricante>();
		fDAO.carregarComboBoxFabricante(comboBoxFabricante);
		
		
		JComboBox<Modelo> comboBoxModelo = new JComboBox<Modelo>();
		comboBoxModelo.setBounds(212, 344, 357, 25);
		painelCadastroCliente.add(comboBoxModelo);

		comboBoxFabricante.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Fabricante fabricante = (Fabricante) comboBoxFabricante.getSelectedItem();
				System.out.println(fabricante.getNome_fabricante()+" - "+fabricante.getId_fabricante());
				ModeloDAO.carregarModelo(comboBoxModelo, fabricante.getId_fabricante());
				
			}
		});
		comboBoxFabricante.setBounds(212, 308, 357, 25);
		painelCadastroCliente.add(comboBoxFabricante);

		JButton btnCadastrarCliente = new JButton("Cadastrar");
		btnCadastrarCliente.setBackground(new Color(0, 0, 0));
		btnCadastrarCliente.setForeground(new Color(255, 255, 255));   
		btnCadastrarCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCadastrarCliente.setBounds(212, 501, 357, 25);
		btnCadastrarCliente.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnCadastrarCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = cDAO.inserir(
						textField_NomeCliente.getText(), 
						textField_EnderecoCliente.getText(),
						textField_CPFCliente.getText(), 
						textField_EmailCliente.getText(),
						textField_TelefoneCliente.getText(),
						comboBoxSelecCliente
						);
				
				Modelo modelo = (Modelo) comboBoxModelo.getSelectedItem();
				if(vDAO != null) {
					Veiculo veiculo = vDAO.inserirVeiculo(
							textField_Placa.getText(), 
							textField_Motor.getText(), 
							cliente.getId_cliente(),
							modelo.getId_modelo());
				}
				
				resetarCampos(painelCadastroCliente);
			}
		});
		painelCadastroCliente.add(btnCadastrarCliente);

		textField_Motor = new JTextField();
		textField_Motor.setBounds(212, 416, 357, 25);
		painelCadastroCliente.add(textField_Motor);
		textField_Motor.setColumns(10);

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

		textField_Endereco = new JTextField();
		textField_Endereco.setColumns(10);
		textField_Endereco.setBounds(205, 162, 357, 25);
		painelConsultaCliente.add(textField_Endereco);

		JLabel lblCPF_1_1 = new JLabel("CPF:");
		lblCPF_1_1.setForeground(new Color(255, 255, 255));
		lblCPF_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCPF_1_1.setBounds(116, 201, 46, 14);
		painelConsultaCliente.add(lblCPF_1_1);

		textField_CPF = new JTextField();
		textField_CPF.setColumns(10);
		textField_CPF.setBounds(205, 198, 357, 25);
		painelConsultaCliente.add(textField_CPF);

		JLabel lblEmail_1_1 = new JLabel("Email:");
		lblEmail_1_1.setForeground(new Color(255, 255, 255));
		lblEmail_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail_1_1.setBounds(116, 237, 46, 14);
		painelConsultaCliente.add(lblEmail_1_1);

		textField_emial = new JTextField();
		textField_emial.setColumns(10);
		textField_emial.setBounds(205, 234, 357, 25);
		painelConsultaCliente.add(textField_emial);

		JLabel lblTelefone_1_1 = new JLabel("Telefone:");
		lblTelefone_1_1.setForeground(new Color(255, 255, 255));
		lblTelefone_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefone_1_1.setBounds(116, 273, 67, 14);
		painelConsultaCliente.add(lblTelefone_1_1);

		telefone = new JTextField();
		telefone.setColumns(10);
		telefone.setBounds(205, 270, 357, 25);
		painelConsultaCliente.add(telefone);

		JLabel lblSelecCliente_1 = new JLabel("Selecione o Cliente");
		lblSelecCliente_1.setForeground(new Color(255, 255, 255));
		lblSelecCliente_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSelecCliente_1.setBounds(288, 48, 198, 25);
		painelConsultaCliente.add(lblSelecCliente_1);

		comboBoxSelecCliente = new JComboBox();
		cDAO.carregarComboBoxCliente(comboBoxSelecCliente);
		comboBoxSelecCliente.setBounds(205, 84, 357, 25);
		painelConsultaCliente.add(comboBoxSelecCliente);
		comboBoxSelecCliente.setBounds(205, 84, 357, 25);
		painelConsultaCliente.add(comboBoxSelecCliente);

		JLabel lblDivida = new JLabel("Dívida:");
		lblDivida.setForeground(new Color(255, 255, 255));
		lblDivida.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDivida.setBounds(116, 310, 67, 14);
		painelConsultaCliente.add(lblDivida);

		textField_divida = new JTextField();
		textField_divida.setColumns(10);
		textField_divida.setBounds(205, 307, 91, 25);
		painelConsultaCliente.add(textField_divida);

		tableVeiculosCliente = new JTable();
		tableVeiculosCliente.setBounds(116, 360, 521, 112);
		painelConsultaCliente.add(tableVeiculosCliente);

		JButton btnSalvarAlteracoes = new JButton("Salvar Alterações");
		btnSalvarAlteracoes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvarAlteracoes.setBounds(205, 493, 357, 25);
		painelConsultaCliente.add(btnSalvarAlteracoes);

		JPanel painelDevedores = new JPanel();
		painelDevedores.setBackground(new Color(0, 0, 0));
		painelDevedores.setLayout(null);
		painelPrincipal.add(painelDevedores, "PAINEL DEVEDORES");

		tableDevedores = new JTable();
		tableDevedores.setBounds(95, 102, 587, 326);
		painelDevedores.add(tableDevedores);

		JLabel lblDevedores = new JLabel("Lista de Devedores");
		lblDevedores.setForeground(new Color(255, 255, 255));
		lblDevedores.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDevedores.setBounds(294, 52, 198, 25);
		painelDevedores.add(lblDevedores);

		JButton btnNovaDivida = new JButton("Nova Dívida");
		btnNovaDivida.setForeground(new Color(255, 255, 255));
		btnNovaDivida.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnNovaDivida.setBackground(new Color(0, 0, 0));
		btnNovaDivida.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNovaDivida.setBounds(95, 52, 157, 25);
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
		tabbedPane_1.setBounds(54, 128, 422, 313);
		painelCadastroOS.add(tabbedPane_1);
		
		JPanel painelPecas = new JPanel();
		tabbedPane_1.addTab("Peças", null, painelPecas, null);
		painelPecas.setLayout(null);
		
		JButton btnCadastrarOS = new JButton("Cadastrar");
		btnCadastrarOS.setBounds(162, 229, 89, 23);
		painelPecas.add(btnCadastrarOS);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(13, 76, 276, 20);
		painelPecas.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);
		
		textFieldValor = new JTextField();
		textFieldValor.setColumns(10);
		textFieldValor.setBounds(13, 145, 276, 20);
		painelPecas.add(textFieldValor);
		
		textFieldQuant = new JTextField();
		textFieldQuant.setColumns(10);
		textFieldQuant.setBounds(13, 206, 276, 20);
		painelPecas.add(textFieldQuant);
		
		JLabel lblDescricao = new JLabel("Descrição: ");
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescricao.setBounds(13, 62, 105, 14);
		painelPecas.add(lblDescricao);
		
		JLabel lblValor = new JLabel("Valor: ");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblValor.setBounds(13, 126, 54, 14);
		painelPecas.add(lblValor);
		
		JLabel lblQuantidade = new JLabel("Quantidade: ");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuantidade.setBounds(13, 188, 105, 14);
		painelPecas.add(lblQuantidade);
		
		JPanel painelPagamento = new JPanel();
		tabbedPane_1.addTab("Pagamento", null, painelPagamento, null);

		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(482, 148, 252, 293);
		painelCadastroOS.add(textArea_1);

		JButton btnNewButton = new JButton("Criar O.S");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(297, 578, 221, 25);
		painelCadastroOS.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Subtotal:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(486, 456, 60, 14);
		painelCadastroOS.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(588, 454, 146, 20);
		painelCadastroOS.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox_FormaPagamento = new JComboBox();
		comboBox_FormaPagamento.setBounds(588, 485, 146, 22);
		painelCadastroOS.add(comboBox_FormaPagamento);
		
		JLabel lblNewLabel_2 = new JLabel("F. Pagamento:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(486, 489, 92, 14);
		painelCadastroOS.add(lblNewLabel_2);
		
		JLabel lblParcelas = new JLabel("Parcelas: ");
		lblParcelas.setForeground(Color.WHITE);
		lblParcelas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblParcelas.setBounds(486, 517, 102, 14);
		painelCadastroOS.add(lblParcelas);
		
		JComboBox comboBox_FormaPagamento_1 = new JComboBox();
		comboBox_FormaPagamento_1.setBounds(588, 518, 146, 22);
		painelCadastroOS.add(comboBox_FormaPagamento_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("Copyright©2024, Gerenciamento Oficina Mecânica. Todos os direitos reservados.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);

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

		setSize(800, 723);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);

		ImageIcon fav = new ImageIcon("img/favicon.png");
		setIconImage(fav.getImage());

	}

	private void resetarCampos(JPanel painel) {
		for (Component comp : painel.getComponents()) {
			if (comp instanceof JTextField) {
				((JTextField) comp).setText(""); // Limpa o texto dos JTextFields
			} else if (comp instanceof JPasswordField) {
				((JPasswordField) comp).setText(""); // Limpa o JPasswordField, se houver
			}
			// Adicione mais tipos de componentes conforme necessário
		}
	}

	public static void main(String[] args) {
		new SistemaGerenciamentoController();
	}
}
