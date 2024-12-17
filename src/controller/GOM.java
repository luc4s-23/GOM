package controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import model.Cliente;
import model.Fabricante;
import model.Modelo;
import model.Veiculo;
import modelDAO.ClienteDAO;
import modelDAO.FabricanteDAO;
import modelDAO.ModeloDAO;
import modelDAO.VeiculoDAO;

public class GOM extends JFrame{
	private JTextField textField_NomeCliente;
	private JTextField textField_EnderecoCliente;
	private JTextField textField_CPFCliente;
	private JTextField textField_EmailCliente;
	private JTextField textField_TelefoneCliente;
	private JTextField textField_Ano;
	private JTextField textField_Ano_CadastroVeiculo;
	private JTextField textField_Placa;
	private JTextField textField_Placa_CadastroVeiculo;
	private JTextField textField_Endereco_consulta;
	private JTextField textField_CPF_consulta;
	private JTextField textField_emial_consulta;
	private JTextField textField_telefone_consulta;
	private JTable tableVeiculosCliente;
	private JComboBox comboBoxSelecCliente;
	private JTextField textField_Motor;

	private ClienteDAO cDAO;
	private VeiculoDAO vDAO;
	private ModeloDAO mDAO;
	private FabricanteDAO fDAO;
	private JTextField textFieldDescricao;
	private JTextField textFieldValor;
	private JTextField textFieldQuant;
	private JTextField textFieldSubTotal;
	private JTextField textField_Nome_Cliente_consulta;
	private JComboBox<Modelo> comboBoxModelo_CadastroVeiculo;
	private JTable tableVeiculos;
	private JTextField textField_Motor_CadastroVeiculo;
	private JLabel label_excluirCliente;

	public GOM() {
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

		JLabel lblMarca = new JLabel("Fabricante:");
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
				Cliente cliente = cDAO.inserir(textField_NomeCliente.getText(), textField_EnderecoCliente.getText(),
						textField_CPFCliente.getText(), textField_EmailCliente.getText(),
						textField_TelefoneCliente.getText());

				Modelo modelo = (Modelo) comboBoxModelo.getSelectedItem();

				VeiculoDAO.inserirVeiculo(textField_Placa.getText(), textField_Motor.getText(), cliente.getId_cliente(),
						modelo.getId_modelo(), textField_Ano.getText());

				resetarCampos(painelCadastroCliente);

				if (cliente == null) {
					JOptionPane.showMessageDialog(null,
							"Erro ao cadastrar o cliente. Verifique os dados e tente novamente.");
					return;
				} else if (cliente != null) {
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
				}

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
		lblInfoVeiculo_1.setBounds(279, 188, 241, 25);
		painelCadastrarVeiculo.add(lblInfoVeiculo_1);

		JComboBox<Fabricante> comboBoxFabricante_CadastroVeiculo = new JComboBox<Fabricante>();
		fDAO.carregarComboBoxFabricante(comboBoxFabricante_CadastroVeiculo);

		comboBoxFabricante_CadastroVeiculo.setBounds(212, 224, 357, 25);
		comboBoxFabricante_CadastroVeiculo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Fabricante fabricante = (Fabricante) comboBoxFabricante_CadastroVeiculo.getSelectedItem();
				ModeloDAO.carregarModelo(comboBoxModelo_CadastroVeiculo, fabricante.getId_fabricante());

			}
		});
		painelCadastrarVeiculo.add(comboBoxFabricante_CadastroVeiculo);

		JLabel lblMarca_1 = new JLabel("Fabricante:");
		lblMarca_1.setForeground(new Color(255, 255, 255));
		lblMarca_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMarca_1.setBounds(123, 226, 79, 14);
		painelCadastrarVeiculo.add(lblMarca_1);

		JLabel lblModelo_1 = new JLabel("Modelo:");
		lblModelo_1.setForeground(new Color(255, 255, 255));
		lblModelo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModelo_1.setBounds(123, 269, 79, 14);
		painelCadastrarVeiculo.add(lblModelo_1);

		comboBoxModelo_CadastroVeiculo = new JComboBox();
		comboBoxModelo_CadastroVeiculo.setBounds(212, 266, 357, 25);
		painelCadastrarVeiculo.add(comboBoxModelo_CadastroVeiculo);

		textField_Ano_CadastroVeiculo = new JTextField();
		textField_Ano_CadastroVeiculo.setColumns(10);
		textField_Ano_CadastroVeiculo.setBounds(212, 306, 357, 25);
		painelCadastrarVeiculo.add(textField_Ano_CadastroVeiculo);

		JLabel lblAno_1 = new JLabel("Ano:");
		lblAno_1.setForeground(new Color(255, 255, 255));
		lblAno_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAno_1.setBounds(123, 309, 46, 14);
		painelCadastrarVeiculo.add(lblAno_1);

		JLabel lblMotor_1 = new JLabel("Motor:");
		lblMotor_1.setForeground(new Color(255, 255, 255));
		lblMotor_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMotor_1.setBounds(123, 349, 46, 14);
		painelCadastrarVeiculo.add(lblMotor_1);

		JLabel lblPlaca_1 = new JLabel("Placa:");
		lblPlaca_1.setForeground(new Color(255, 255, 255));
		lblPlaca_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPlaca_1.setBounds(123, 388, 67, 14);
		painelCadastrarVeiculo.add(lblPlaca_1);

		textField_Placa_CadastroVeiculo = new JTextField();
		textField_Placa_CadastroVeiculo.setColumns(10);
		textField_Placa_CadastroVeiculo.setBounds(212, 385, 357, 25);
		painelCadastrarVeiculo.add(textField_Placa_CadastroVeiculo);

		JLabel lblSelecCliente = new JLabel("Selecione o Cliente");
		lblSelecCliente.setForeground(new Color(255, 255, 255));
		lblSelecCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSelecCliente.setBounds(295, 78, 198, 25);
		painelCadastrarVeiculo.add(lblSelecCliente);

		JComboBox<Cliente> comboBox_Cliente_CadastroVeiculo = new JComboBox<Cliente>();
		ClienteDAO.carregarComboBoxCliente(comboBox_Cliente_CadastroVeiculo);
		comboBox_Cliente_CadastroVeiculo.setBounds(212, 114, 357, 25);
		painelCadastrarVeiculo.add(comboBox_Cliente_CadastroVeiculo);

		JButton btnCadastrarVeiculo = new JButton("Cadastrar veículo");
		btnCadastrarVeiculo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Cliente cliente = (Cliente) comboBox_Cliente_CadastroVeiculo.getSelectedItem();

				Modelo modelo = (Modelo) comboBoxModelo_CadastroVeiculo.getSelectedItem();

				Veiculo veiculo = vDAO.inserirVeiculo(
						textField_Placa_CadastroVeiculo.getText(),
						textField_Motor_CadastroVeiculo.getText(), 
						cliente.getId_cliente(), 
						modelo.getId_modelo(),
						textField_Ano_CadastroVeiculo.getText());
				resetarCampos(painelCadastrarVeiculo);
			}
		});
		btnCadastrarVeiculo.setForeground(new Color(255, 255, 255));
		btnCadastrarVeiculo.setBackground(new Color(0, 0, 0));
		btnCadastrarVeiculo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCadastrarVeiculo.setBounds(212, 439, 357, 25);
		btnCadastrarVeiculo.setBorder(new LineBorder(Color.white));
		painelCadastrarVeiculo.add(btnCadastrarVeiculo);

		textField_Motor_CadastroVeiculo = new JTextField();
		textField_Motor_CadastroVeiculo.setColumns(10);
		textField_Motor_CadastroVeiculo.setBounds(212, 345, 357, 25);
		painelCadastrarVeiculo.add(textField_Motor_CadastroVeiculo);

		JPanel painelConsultaCliente = new JPanel();
		painelConsultaCliente.setBackground(new Color(0, 0, 0));
		painelConsultaCliente.setLayout(null);
		painelPrincipal.add(painelConsultaCliente, "PAINEL CONSULTA CLIENTE");

		JLabel labelInfoCliente_1 = new JLabel("Informações do Cliente");
		labelInfoCliente_1.setForeground(new Color(255, 255, 255));
		labelInfoCliente_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelInfoCliente_1.setBounds(272, 143, 241, 25);
		painelConsultaCliente.add(labelInfoCliente_1);

		JLabel lblEndereco_1 = new JLabel("Endereço:");
		lblEndereco_1.setForeground(new Color(255, 255, 255));
		lblEndereco_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEndereco_1.setBounds(116, 216, 79, 14);
		painelConsultaCliente.add(lblEndereco_1);

		textField_Endereco_consulta = new JTextField();
		textField_Endereco_consulta.setColumns(10);
		textField_Endereco_consulta.setBounds(205, 213, 357, 25);
		painelConsultaCliente.add(textField_Endereco_consulta);

		JLabel lblCPF_1_1 = new JLabel("CPF:");
		lblCPF_1_1.setForeground(new Color(255, 255, 255));
		lblCPF_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCPF_1_1.setBounds(116, 252, 46, 14);
		painelConsultaCliente.add(lblCPF_1_1);

		textField_CPF_consulta = new JTextField();
		textField_CPF_consulta.setColumns(10);
		textField_CPF_consulta.setBounds(205, 249, 357, 25);
		painelConsultaCliente.add(textField_CPF_consulta);

		JLabel lblEmail_1_1 = new JLabel("Email:");
		lblEmail_1_1.setForeground(new Color(255, 255, 255));
		lblEmail_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail_1_1.setBounds(116, 288, 46, 14);
		painelConsultaCliente.add(lblEmail_1_1);

		textField_emial_consulta = new JTextField();
		textField_emial_consulta.setColumns(10);
		textField_emial_consulta.setBounds(205, 285, 357, 25);
		painelConsultaCliente.add(textField_emial_consulta);

		JLabel lblTelefone_1_1 = new JLabel("Telefone:");
		lblTelefone_1_1.setForeground(new Color(255, 255, 255));
		lblTelefone_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefone_1_1.setBounds(116, 324, 67, 14);
		painelConsultaCliente.add(lblTelefone_1_1);

		textField_telefone_consulta = new JTextField();
		textField_telefone_consulta.setColumns(10);
		textField_telefone_consulta.setBounds(205, 321, 357, 25);
		painelConsultaCliente.add(textField_telefone_consulta);

		JLabel lblSelecCliente_1 = new JLabel("Selecione o Cliente");
		lblSelecCliente_1.setForeground(new Color(255, 255, 255));
		lblSelecCliente_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSelecCliente_1.setBounds(288, 48, 198, 25);
		painelConsultaCliente.add(lblSelecCliente_1);

		comboBoxSelecCliente = new JComboBox();
		ClienteDAO.carregarComboBoxCliente(comboBoxSelecCliente);
		comboBoxSelecCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Cliente clienteSelecionado = (Cliente) comboBoxSelecCliente.getSelectedItem();
				int idCliente = clienteSelecionado.getId_cliente();
				Cliente cliente = ClienteDAO.consultarCliente(idCliente);

				textField_Nome_Cliente_consulta.setText(cliente.getNome_cliente());
				textField_Endereco_consulta.setText(cliente.getEndereco_cliente());
				textField_CPF_consulta.setText(cliente.getCpf_cliente());
				textField_emial_consulta.setText(cliente.getEmail_cliente());
				textField_telefone_consulta.setText(cliente.getTelefone_cliente());

				List<Veiculo> veiculos = VeiculoDAO.buscarVeiculosPorCliente(idCliente);

				DefaultTableModel modeloTabela = (DefaultTableModel) tableVeiculos.getModel();
				modeloTabela.setRowCount(0);

				for (Veiculo veiculo : veiculos) {
					modeloTabela.addRow(new Object[] { veiculo.getId_modelo(), veiculo.getAno(), veiculo.getMotor(),
							veiculo.getPlaca() });
				}

			}
		});
		comboBoxSelecCliente.setBounds(205, 84, 357, 25);
		painelConsultaCliente.add(comboBoxSelecCliente);
		comboBoxSelecCliente.setBounds(205, 84, 357, 25);
		painelConsultaCliente.add(comboBoxSelecCliente);

		JButton btnSalvarAlteracoes = new JButton("Salvar Alterações");
		btnSalvarAlteracoes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvarAlteracoes.setBounds(205, 576, 357, 25);
		painelConsultaCliente.add(btnSalvarAlteracoes);

		textField_Nome_Cliente_consulta = new JTextField();
		textField_Nome_Cliente_consulta.setColumns(10);
		textField_Nome_Cliente_consulta.setBounds(205, 177, 357, 25);
		painelConsultaCliente.add(textField_Nome_Cliente_consulta);

		JLabel lblEndereco_1_1 = new JLabel("Nome:");
		lblEndereco_1_1.setForeground(Color.WHITE);
		lblEndereco_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEndereco_1_1.setBounds(116, 180, 79, 14);
		painelConsultaCliente.add(lblEndereco_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 368, 632, 188);
		painelConsultaCliente.add(scrollPane);

		tableVeiculos = new JTable();
		DefaultTableModel modeloTabela = new DefaultTableModel();
		tableVeiculos.setModel(modeloTabela);

		modeloTabela.addColumn("Modelo");
		modeloTabela.addColumn("Ano");
		modeloTabela.addColumn("Motor");
		modeloTabela.addColumn("placa");

		tableVeiculos.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Modelo", "Ano", "Motor", "placa" }));


		scrollPane.setViewportView(tableVeiculos);

		ImageIcon iconDelete = new ImageIcon("img/delete.png");
		JLabel label_foto = new JLabel(
				new ImageIcon(iconDelete.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT)));
		label_foto.setBackground(new Color(255, 255, 255));
		label_foto.setBounds(580, 84, 25, 25);
		label_foto.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				label_excluirCliente.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				label_excluirCliente.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente clienteSelecionado = (Cliente) comboBoxSelecCliente.getSelectedItem();
				
				if (clienteSelecionado != null) { // Verifica se um cliente foi selecionado
					int id = clienteSelecionado.getId_cliente();

					// Tenta excluir o cliente
					boolean sucesso = ClienteDAO.deletarCliente(id);

					if (sucesso) {
						JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso.");
						ClienteDAO.carregarComboBoxCliente(comboBoxSelecCliente); // Recarrega o ComboBox
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao excluir o cliente.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum cliente selecionado.");
				}

			}
		});
		painelConsultaCliente.add(label_foto);

		label_excluirCliente = new JLabel("Excluir cliente");
		label_excluirCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_excluirCliente.setForeground(new Color(255, 255, 255));
		label_excluirCliente.setBounds(612, 84, 79, 13);
		label_excluirCliente.setVisible(false);
		painelConsultaCliente.add(label_excluirCliente);

		JPanel painelCadastroOS = new JPanel();
		painelCadastroOS.setBackground(new Color(0, 0, 0));
		painelCadastroOS.setLayout(null);
		painelPrincipal.add(painelCadastroOS, "PAINEL CADASTRO OS");

		JLabel lblClienteOS_1 = new JLabel("Para qual Cliente?");
		lblClienteOS_1.setForeground(new Color(255, 255, 255));
		lblClienteOS_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClienteOS_1.setBounds(54, 26, 199, 25);
		painelCadastroOS.add(lblClienteOS_1);

		JComboBox<String> comboBoxVeiculoOS_1 = new JComboBox();

		
		JComboBox<Cliente> comboBoxClienteOS_1 = new JComboBox();
		ClienteDAO.carregarComboBoxCliente(comboBoxClienteOS_1);
		

		JComboBox<Cliente> comboBoxClienteOS_11 = new JComboBox();
		ClienteDAO.carregarComboBoxCliente(comboBoxClienteOS_1);
		comboBoxClienteOS_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente = (Cliente) comboBoxClienteOS_1.getSelectedItem();
				VeiculoDAO.carregarNomesVeiculo(comboBoxVeiculoOS_1, cliente.getId_cliente());
			}
		});
		comboBoxClienteOS_1.setForeground(new Color(0, 0, 0));
		comboBoxClienteOS_1.setBounds(28, 62, 317, 25);
		painelCadastroOS.add(comboBoxClienteOS_1);

		JLabel lblVeiculoOS_1 = new JLabel("Qual Veículo?");
		lblVeiculoOS_1.setForeground(new Color(255, 255, 255));
		lblVeiculoOS_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVeiculoOS_1.setBounds(509, 26, 146, 25);
		painelCadastroOS.add(lblVeiculoOS_1);

		comboBoxVeiculoOS_1.setBounds(444, 62, 317, 25);
		painelCadastroOS.add(comboBoxVeiculoOS_1);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabbedPane_1.setBounds(54, 128, 323, 313);
		painelCadastroOS.add(tabbedPane_1);

		JPanel painelPecas = new JPanel();
		tabbedPane_1.addTab("Peças", null, painelPecas, null);
		painelPecas.setLayout(null);

		TextArea textAreaOS = new TextArea();
		textAreaOS.setBounds(383, 148, 351, 293);
		painelCadastroOS.add(textAreaOS);
		
		JButton btnCadastrarOS = new JButton("Cadastrar");
		
		btnCadastrarOS.addActionListener(new ActionListener() {
			final double[] totalAcumulado = {0.0};
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
                    // Recuperando os valores
                    String descricao = textFieldDescricao.getText();
                    double valor = Double.parseDouble(textFieldValor.getText());
                    int quantidade = Integer.parseInt(textFieldQuant.getText());

                    // Calculando o subtotal e atualizando o total acumulado
                    double subtotal = valor * quantidade;
                    totalAcumulado[0] += subtotal;

                    // Limpando o textArea para atualizar com os valores novos
                    String textoAtual = textAreaOS.getText();

                    // Adicionando os novos dados ao textArea
                    textoAtual += "Descrição: " + descricao 
                                + " | Valor: " + valor 
                                + " | Quantidade: " + quantidade 
                                + " | Subtotal: " + String.format("%.2f", subtotal) + "\n";

                    // Adicionando a linha ao textArea
                    textAreaOS.setText(textoAtual);

                    // Atualizando o valor total no textFieldSubTotal
                    textFieldSubTotal.setText(String.format("%.2f", totalAcumulado[0]));

                    // Limpando os campos após adicionar
                    textFieldDescricao.setText("");
                    textFieldValor.setText("");
                    textFieldQuant.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos!", 
                                                  "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                }
            }
		});
		
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

		

		JButton btnCriarOS = new JButton("Criar O.S");
		btnCriarOS.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCriarOS.setBounds(297, 578, 221, 25);
		painelCadastroOS.add(btnCriarOS);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal.setForeground(new Color(255, 255, 255));
		lblTotal.setBounds(486, 456, 60, 14);
		painelCadastroOS.add(lblTotal);

		textFieldSubTotal = new JTextField();
		textFieldSubTotal.setBounds(588, 454, 146, 20);
		painelCadastroOS.add(textFieldSubTotal);
		textFieldSubTotal.setColumns(10);
		textFieldSubTotal.setEditable(false);

		JComboBox comboBoxParcelas = new JComboBox();
		comboBoxParcelas.addItem("1x");
		comboBoxParcelas.addItem("2x");
		comboBoxParcelas.addItem("3x");
		comboBoxParcelas.addItem("4x");
		comboBoxParcelas.addItem("5x");
		comboBoxParcelas.addItem("6x");
		comboBoxParcelas.addItem("7x");
		comboBoxParcelas.addItem("8x");
		comboBoxParcelas.addItem("9x");
		comboBoxParcelas.addItem("10x");
		comboBoxParcelas.addItem("11x");
		comboBoxParcelas.addItem("12x");
		
		comboBoxParcelas.setBounds(588, 518, 146, 22);
		painelCadastroOS.add(comboBoxParcelas);
		
		JComboBox comboBox_FormaPagamento = new JComboBox();
		comboBox_FormaPagamento.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if (comboBox_FormaPagamento.getSelectedItem().equals("Cartão de Crédito")) {
		            comboBoxParcelas.setEnabled(true);  // Ativa a comboBox de parcelas
		            comboBoxParcelas.addItem("1x");
		            comboBoxParcelas.addItem("2x");
		            comboBoxParcelas.addItem("3x");
		            comboBoxParcelas.addItem("4x");
		            comboBoxParcelas.addItem("5x");
		            comboBoxParcelas.addItem("6x");
		            comboBoxParcelas.addItem("7x");
		            comboBoxParcelas.addItem("8x");
		            comboBoxParcelas.addItem("9x");
		            comboBoxParcelas.addItem("10x");
		            comboBoxParcelas.addItem("11x");
		            comboBoxParcelas.addItem("12x");
		        } else {
		            comboBoxParcelas.setEnabled(false); // Desativa a comboBox de parcelas
		            comboBoxParcelas.removeAllItems(); // Limpa as opções de parcelas
		            
		        }
		    }
		});
		comboBox_FormaPagamento.addItem("Dinheiro");
        comboBox_FormaPagamento.addItem("Cartão de Crédito");
        comboBox_FormaPagamento.addItem("Cartão de Débito");
        comboBox_FormaPagamento.addItem("Pix");
        
		comboBox_FormaPagamento.setBounds(588, 485, 146, 22);
		painelCadastroOS.add(comboBox_FormaPagamento);

		JLabel lblNewLabel_2 = new JLabel("Pagamento:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(486, 489, 92, 14);
		painelCadastroOS.add(lblNewLabel_2);

		JLabel lblParcelas = new JLabel("Parcelas: ");
		lblParcelas.setForeground(Color.WHITE);
		lblParcelas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblParcelas.setBounds(486, 517, 102, 14);
		painelCadastroOS.add(lblParcelas);

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));

		getContentPane().add(panel, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel(
				"Copyright©2024, Gerenciamento Oficina Mecânica. Todos os direitos reservados.");
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
	
		menuConsulta.add(menuItemConsultarCliente);

		setSize(800, 723);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);

		ImageIcon fav = new ImageIcon("img/favicon.png");
		setIconImage(fav.getImage());

	}

	public static void resetarCampos(JPanel painel) {
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
		new GOM();
	}
}
