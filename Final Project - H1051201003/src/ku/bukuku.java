package ku;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class bukuku {
	public JFrame frmDataBuku;
	public JFrame tampilan;
	public JTextField judul;
	public JTextField penerbit;
	public static JTable table;
	public static DefaultTableModel tabel;
	public static JScrollPane scpane;
	public final ButtonGroup buttonGroup = new ButtonGroup();
	public JLabel jb;
	public JLabel idku;
	private JComboBox<String> jenis;
	private JSpinner jml;
	private JButton hapus;
	private JButton hapust;
	private JButton edit;
	private JTextField tfCari;
	private JTextField jtthn;
	int bukuss = 0;
	int pbuku = 0;

	public ArrayList<buku> bukus = new ArrayList<buku>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bukuku window = new bukuku();
					window.frmDataBuku.setVisible(true);
					window.frmDataBuku.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void tabelbuku() {
		tabel.setRowCount(0);
		for (int i = 0; i < bukus.size(); i++) {
			Object[] isi = { bukus.get(i).idbuku, bukus.get(i).judul, bukus.get(i).penerbit, bukus.get(i).Jenis,
					bukus.get(i).tahun, bukus.get(i).jumlah };
			tabel.addRow(isi);
		}
		table.setModel(tabel);
		scpane.setViewportView(table);
	}

	public void refresh() {
		idku.setText(null);
		judul.setText(null);
		penerbit.setText(null);
		jenis.setSelectedItem("--Jenis Buku--");
		jtthn.setText(null);
		jml.setValue(0);
	}

	/**
	 * Create the application.
	 */
	public bukuku() {
		initialize();
		String atas[] = new String[] { "ID Buku", "Judul", "Penerbit", "Jenis Buku", "Tahun", "Jumlah" };
		bukuss = 0;
		pbuku = 0;
		tabel = new DefaultTableModel(atas, 0);
		table.setModel(tabel);

		hapus.setEnabled(false);
		hapust.setEnabled(false);
		edit.setEnabled(false);

		JLabel lblNewLabel_1 = new JLabel("Jumlah Data :  ");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(838, 629, 111, 21);
		frmDataBuku.getContentPane().add(lblNewLabel_1);

		jb = new JLabel("0");
		jb.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		jb.setForeground(new Color(0, 0, 0));
		jb.setBounds(958, 629, 16, 21);
		frmDataBuku.getContentPane().add(jb);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Tabel Penyimpanan", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(47, 79, 79)));
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(359, 108, 615, 510);
		frmDataBuku.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnRefreshTabel = new JButton("Refresh Tabel");
		btnRefreshTabel.setBounds(10, 22, 128, 29);
		panel.add(btnRefreshTabel);
		btnRefreshTabel.setForeground(new Color(47, 79, 79));
		btnRefreshTabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelbuku();
			}
		});
		btnRefreshTabel.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnRefreshTabel.setBackground(Color.WHITE);

		tfCari = new JTextField();
		tfCari.setBounds(344, 22, 171, 29);
		panel.add(tfCari);
		tfCari.setForeground(new Color(47, 79, 79));
		tfCari.setHorizontalAlignment(SwingConstants.CENTER);
		tfCari.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		tfCari.setColumns(10);

		JButton btnCariData = new JButton("Cari");
		btnCariData.setBounds(522, 22, 78, 29);
		panel.add(btnCariData);
		btnCariData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = tfCari.getText();
				tabel.setRowCount(0);
				for (int i = 0; i < bukus.size(); i++) {
					if (bukus.get(i).idbuku.equals(a)) {
						Object[] isi = { bukus.get(i).idbuku, bukus.get(i).judul, bukus.get(i).penerbit,
								bukus.get(i).Jenis, bukus.get(i).tahun, bukus.get(i).jumlah };
						tabel.addRow(isi);
					} else if (bukus.get(i).judul.equals(a)) {
						Object[] isi = { bukus.get(i).idbuku, bukus.get(i).judul, bukus.get(i).penerbit,
								bukus.get(i).Jenis, bukus.get(i).tahun, bukus.get(i).jumlah };
						tabel.addRow(isi);
					} else if (bukus.get(i).Jenis.equals(a)) {
						Object[] isi = { bukus.get(i).idbuku, bukus.get(i).judul, bukus.get(i).penerbit,
								bukus.get(i).Jenis, bukus.get(i).tahun, bukus.get(i).jumlah };
						tabel.addRow(isi);
					}
				}
			}
		});
		btnCariData.setForeground(new Color(47, 79, 79));
		btnCariData.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnCariData.setBackground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Input",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setBounds(10, 11, 251, 86);
		frmDataBuku.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Data Buku");
		lblNewLabel_2.setBounds(10, 11, 231, 64);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmDataBuku = new JFrame();
		frmDataBuku.getContentPane().setForeground(new Color(0, 0, 0));
		frmDataBuku.getContentPane().setBackground(new Color(175, 238, 238));
		frmDataBuku.setTitle("Data Buku");
		frmDataBuku.setBounds(100, 100, 1000, 700);
		frmDataBuku.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDataBuku.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Data Buku",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(47, 79, 79)));
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(10, 108, 339, 252);
		frmDataBuku.getContentPane().add(panel);
		panel.setLayout(null);

		judul = new JTextField();
		judul.setForeground(new Color(47, 79, 79));
		judul.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				idku();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				idku();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				idku();
			}

			public void idku() {
				try {
					String ko = judul.getText();
					char koo = ko.charAt(0);
					String kooo = String.valueOf(koo);
					idku.setText(kooo.toUpperCase() + "-" + (pbuku + 1));
				} catch (Exception e) {
				}
			}
		});
		judul.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		judul.setBounds(84, 58, 234, 31);
		panel.add(judul);
		judul.setColumns(10);

		penerbit = new JTextField();
		penerbit.setForeground(new Color(47, 79, 79));
		penerbit.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		penerbit.setBounds(84, 96, 234, 31);
		panel.add(penerbit);
		penerbit.setColumns(10);

		JLabel lblTahun = new JLabel("Tahun");
		lblTahun.setForeground(new Color(47, 79, 79));
		lblTahun.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblTahun.setBounds(10, 179, 72, 31);
		panel.add(lblTahun);

		JLabel lblStatus = new JLabel("Jumlah");
		lblStatus.setForeground(new Color(47, 79, 79));
		lblStatus.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblStatus.setBounds(10, 221, 72, 21);
		panel.add(lblStatus);

		idku = new JLabel("");
		idku.setForeground(new Color(47, 79, 79));
		idku.setBounds(84, 21, 176, 26);
		panel.add(idku);
		idku.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		idku.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblJudul = new JLabel("Judul");
		lblJudul.setForeground(new Color(47, 79, 79));
		lblJudul.setBounds(10, 64, 72, 21);
		panel.add(lblJudul);
		lblJudul.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JLabel lblPenerbit = new JLabel("Penerbit");
		lblPenerbit.setForeground(new Color(47, 79, 79));
		lblPenerbit.setBounds(10, 102, 72, 21);
		panel.add(lblPenerbit);
		lblPenerbit.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		jml = new JSpinner();
		jml.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
		jml.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		jml.setBounds(84, 220, 65, 21);
		panel.add(jml);

		JLabel lblNewLabel = new JLabel("ID Buku");
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setBounds(10, 26, 54, 21);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		jenis = new JComboBox<String>();
		jenis.setModel(new DefaultComboBoxModel<String>(
				new String[] { "--Jenis Buku--", "Pendidikan", "Novel", "Komik", "Dongeng", "Majalah" }));
		jenis.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		jenis.setBackground(Color.WHITE);
		jenis.setBounds(84, 138, 120, 30);
		panel.add(jenis);

		JLabel btnjenis = new JLabel("Jenis");
		btnjenis.setForeground(new Color(47, 79, 79));
		btnjenis.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnjenis.setBounds(10, 147, 72, 21);
		panel.add(btnjenis);

		jtthn = new JTextField();
		jtthn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (jtthn.getText().trim().length() == 4 || e.getKeyChar() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
					e.consume();
				}
				char id = e.getKeyChar();
				if (!(Character.isDigit(id))) {
					e.consume();
				}
			}
		});
		jtthn.setForeground(new Color(47, 79, 79));
		jtthn.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		jtthn.setColumns(10);
		jtthn.setBounds(84, 183, 65, 21);
		panel.add(jtthn);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setBounds(10, 377, 339, 241);
		frmDataBuku.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton input = new JButton("Input");
		input.setForeground(new Color(47, 79, 79));
		input.setBackground(new Color(255, 255, 255));
		input.setFont(new Font("Century Gothic", Font.BOLD, 20));
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (judul.getText().isEmpty() && penerbit.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Judul dan Penerbit tidak boleh kosong");
				} else if (judul.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "judul tidak boleh kosong");
				} else if (penerbit.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Penerbit tidak boleh kosong");
				} else if (jenis.getSelectedItem().toString().equals("--Jenis Buku--")) {
					JOptionPane.showMessageDialog(null, "Silakan pilih jenis buku");
				} else if (jtthn.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Silakan isi tahun buku");
				} else {
					String ko = judul.getText().toUpperCase();
					char koo = ko.charAt(0);
					pbuku = pbuku + 1;
					String id = koo + "-" + pbuku;
					String jd = judul.getText();
					String pn = penerbit.getText();
					String jn = jenis.getSelectedItem().toString();
					int thn = Integer.parseInt(jtthn.getText().toString());
					int jumlah = Integer.parseInt(jml.getValue().toString());

					buku data = new buku(id, jd, pn, jn, thn, jumlah);

					bukus.add(data);
					tabelbuku();

					int v = tabel.getRowCount();
					String b = String.valueOf(v);
					jb.setText(b);
					refresh();

					hapust.setEnabled(true);
				}
			}
		});
		input.setBounds(10, 11, 319, 35);
		panel_1.add(input);

		hapus = new JButton("Hapus");
		hapus.setForeground(new Color(47, 79, 79));
		hapus.setBackground(new Color(255, 255, 255));
		hapus.setFont(new Font("Century Gothic", Font.BOLD, 20));
		hapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.YES_NO_OPTION;
				int b = JOptionPane.showConfirmDialog(null, "Hapus Data ini", null, a);
				try {
					if (b == 0) {
						int bris = table.getSelectedRow();
						int klom = 0;
						String dipilih = (String) tabel.getValueAt(bris, klom);

						for (int i = 0; i < bukus.size(); i++) {
							if (bukus.get(i).idbuku.equals(dipilih)) {
								bukus.remove(i);
							}
						}
						tabelbuku();

						int v = tabel.getRowCount();
						String bb = String.valueOf(v);
						jb.setText(bb);

					} else {
						JOptionPane.showMessageDialog(null, "Data tidak dihapus");
					}
				} catch (Exception n) {
					JOptionPane.showMessageDialog(null, "Data Kosong");
				}
				input.setEnabled(true);
				hapus.setEnabled(false);
				refresh();
			}
		});
		hapus.setBounds(10, 57, 319, 35);
		panel_1.add(hapus);

		JButton refresh = new JButton("Refresh");
		refresh.setForeground(new Color(47, 79, 79));
		refresh.setBackground(new Color(255, 255, 255));
		refresh.setFont(new Font("Century Gothic", Font.BOLD, 20));
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
				input.setEnabled(true);
			}
		});
		refresh.setBounds(10, 103, 319, 35);
		panel_1.add(refresh);

		edit = new JButton("Edit");
		edit.setBounds(10, 149, 319, 35);
		panel_1.add(edit);
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				pbuku = bukuss;
				String id = idku.getText();
				String jd = judul.getText();
				String pn = penerbit.getText();
				String jn = jenis.getSelectedItem().toString();
				int thn = Integer.parseInt(jtthn.getText().toString());
				int jumlah = Integer.parseInt(jml.getValue().toString());

				bukus.get(bukuss).setIdbuku(id);
				bukus.get(bukuss).setJudul(jd);
				bukus.get(bukuss).setPenerbit(pn);
				bukus.get(bukuss).setJenis(jn);
				bukus.get(bukuss).setTahun(thn);
				bukus.get(bukuss).setJumlah(jumlah);
				tabelbuku();
				refresh();
				input.setEnabled(true);
				} catch (Exception a){
				}
			}
		});
		edit.setForeground(new Color(47, 79, 79));
		edit.setFont(new Font("Century Gothic", Font.BOLD, 20));
		edit.setBackground(Color.WHITE);

		hapust = new JButton("Hapus Total");
		hapust.setBounds(10, 195, 319, 35);
		panel_1.add(hapust);
		hapust.setForeground(new Color(47, 79, 79));
		hapust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pbuku = 0;
				bukus.clear();
				tabelbuku();
				int row = tabel.getRowCount();
				String bariss = String.valueOf(row);
				jb.setText(bariss);
				hapust.setEnabled(false);
				
			}
		});
		hapust.setBackground(new Color(255, 255, 255));
		hapust.setFont(new Font("Century Gothic", Font.BOLD, 20));

		scpane = new JScrollPane();
		scpane.setBackground(new Color(255, 255, 255));
		scpane.setEnabled(false);
		scpane.setBounds(369, 169, 592, 435);
		frmDataBuku.getContentPane().add(scpane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String pilih = String.valueOf(tabel.getValueAt(table.getSelectedRow(), 0));
				for (int i = 0; i < bukus.size(); i++) {
					pbuku = table.getSelectedRow();
					buku p = (buku) bukus.get(i);
					if (p.getIdbuku().equals(pilih)) {
						idku.setText(p.idbuku);
						judul.setText(p.judul);
						penerbit.setText(p.penerbit);
						jenis.setSelectedItem(p.Jenis);
						jtthn.setText(String.valueOf(p.tahun));
						jml.setValue(p.jumlah);
						bukuss = i;
					}
				}
				hapus.setEnabled(true);
				edit.setEnabled(true);
				input.setEnabled(false);
			}
		});
		table.setBorder(new LineBorder(new Color(0, 206, 209)));
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		scpane.setViewportView(table);

	}
}

