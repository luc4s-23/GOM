package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import modelDAO.UsuarioDAO;
import util.Conexao;

public class TelaDeLogin_Definitivo extends JFrame {

	private JTextField textoLogin = new JTextField();
	private JPasswordField passwordSenha = new JPasswordField();

	private JLabel labelLogin = new JLabel("Login:");
	private JLabel labelSenha = new JLabel("Senha:");

	private JPanel painelPrincipal = new JPanelComImagem("img/gom2s.png");

	public TelaDeLogin_Definitivo() {
		super("Sistema de Gerenciamento de Oficinas");

		JPanel painelBotao = new JPanel();
		painelBotao.setBackground(new Color(0, 0, 0));
		painelBotao.setBounds(395, 49, 341, 267);

		JButton botaoSair = new JButton("Sair");
		botaoSair.setForeground(new Color(255, 255, 255));
		botaoSair.setBackground(new Color(0, 0, 0));
		botaoSair.setFont(new Font("SansSerif", Font.BOLD, 13));
		botaoSair.setBounds(67, 223, 214, 25);
		botaoSair.setBorder(new LineBorder(Color.WHITE));
		botaoSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int opcao = JOptionPane.showConfirmDialog(botaoSair.getParent(), "Deseja sair do sistema?",
						"Sistema de Gerenciamento de Oficina", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (opcao == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		JButton botaoLogar = new JButton("Logar");
		getRootPane().setDefaultButton(botaoLogar);
		botaoLogar.setForeground(new Color(255, 255, 255));
		botaoLogar.setBackground(new Color(0, 0, 0));
		botaoLogar.setFont(new Font("SansSerif", Font.BOLD, 13));
		botaoLogar.setBounds(67, 188, 214, 25);
		botaoLogar.setBorder(new LineBorder(Color.WHITE));
		botaoLogar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String login = textoLogin.getText();
				String senha = new String(passwordSenha.getPassword());

				Conexao conexao = Conexao.Conectar();

				UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

				boolean autenticado = usuarioDAO.autenticar(login, senha);
				if (autenticado) {
					dispose();
					new GOM();
				} else {
					JOptionPane.showMessageDialog(botaoLogar, "Usuário ou senha inválidos.", "Erro de login",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		painelBotao.setLayout(null);

		GridBagConstraints gbc_botaoLogar = new GridBagConstraints();
		gbc_botaoLogar.anchor = GridBagConstraints.NORTHWEST;
		gbc_botaoLogar.insets = new Insets(0, 0, 0, 5);
		gbc_botaoLogar.gridx = 1;
		gbc_botaoLogar.gridy = 0;
		painelBotao.add(botaoLogar, gbc_botaoLogar);
		GridBagConstraints gbc_botaoSair = new GridBagConstraints();
		gbc_botaoSair.anchor = GridBagConstraints.NORTHWEST;
		gbc_botaoSair.gridx = 2;
		gbc_botaoSair.gridy = 0;
		painelBotao.add(botaoSair, gbc_botaoSair);
		painelPrincipal.setBackground(new Color(0, 0, 0));
		painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		painelPrincipal.setLayout(null);
		painelPrincipal.add(painelBotao);
		passwordSenha.setBounds(67, 135, 214, 31);
		painelBotao.add(passwordSenha);
		textoLogin.setBounds(67, 60, 214, 31);
		painelBotao.add(textoLogin);
		labelSenha.setFont(new Font("SansSerif", Font.BOLD, 16));
		labelSenha.setForeground(new Color(255, 255, 255));
		labelSenha.setBounds(67, 114, 68, 19);
		painelBotao.add(labelSenha);
		labelLogin.setFont(new Font("SansSerif", Font.BOLD, 16));
		labelLogin.setForeground(new Color(255, 255, 255));
		labelLogin.setBounds(67, 38, 68, 19);
		painelBotao.add(labelLogin);

		getContentPane().add(painelPrincipal);

		setSize(760, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);

		ImageIcon fav = new ImageIcon("img/favicon.png");
		setIconImage(fav.getImage());

	}

	public static void main(String[] args) {
		new TelaDeLogin_Definitivo();
	}
}

class JPanelComImagem extends JPanel {
	private Image backgroundImage;

	public JPanelComImagem(String caminhoImagem) {
		try {
			backgroundImage = new ImageIcon(getClass().getResource("img/gom2.png")).getImage();
		} catch (Exception e) {
			System.err.println("Erro ao carregar imagem: " + e.getMessage());
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (backgroundImage != null) {

			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}
	}
}
