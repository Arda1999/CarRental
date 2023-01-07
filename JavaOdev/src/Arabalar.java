//---------------------------------------------------------------------------------------------------------------------
//Arabalar.java											Author: Zeynep İdil Gül ID: 21894810
//																z_idilgul99@hotmail.com
//
//
//We use this class to display cars in our company and find them with their plate number.
//---------------------------------------------------------------------------------------------------------------------

//------KULLANILAN KUTUPHANELER--------
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;


public class Arabalar extends JFrame {
	
	//DEĞİŞKEN TANIMLAMALARI
	private JPanel contentPane;
	private JTable arabalarJTable;
	private JLabel arabalarLabel;
	private JLabel arabaGetirLabel;
	private JTextField plakaTf;
	private JButton getirButton;
	private JLabel markaLabel;
	private JLabel modelLabel;
	private JTextField modelTf;
	private JLabel yilLabel;
	private JTextField yilTField;
	private JLabel vitesLabel;
	private JTextField vitesTField;
	private JLabel yakitLabel;
	private JTextField yakitTField;
	private JLabel fiyatLabel;
	private JTextField sigaraTField;
	private JTextField fiyatTField;
	private JTextField markaTf;
	private JLabel geriLabel;
	private JScrollPane scrollPane_1;
	//DEĞİŞKEN TANIMLAMALARI

	public Arabalar() {
		
		setVisible(true);//bu sınıfdan bir obje yaratıldığında açılan pencerenin görünmesi için
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Çarpıya basıldığında programın sonlanması için.
		setBounds(100, 100, 1094, 596);//Boyutlandırma ayarları
		contentPane = new JPanel();//Content pane tanımlaması
		contentPane.setBackground(Color.WHITE);//arka planın beyaz renk olarak ayarlanması
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//boyutlandırma ayarları
		setContentPane(contentPane);//contentpane'in set edilmesi
		contentPane.setLayout(null);
		setLocationRelativeTo(null); 
	    setResizable(false);//Yeniden boyutlandırma kapatıldı.

		geriLabel = new JLabel("Geri");
		geriLabel.setBackground(Color.WHITE);
		geriLabel.setOpaque(true);
		geriLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent a) {
				Test t = new Test();
				t.setVisible(true);
				dispose();
			}
			public void mouseEntered(MouseEvent e) {
				setColor(geriLabel);//label renkleri ayarlamayı kolaylaştırmak için yazılmış fonksiyonlarım
			}
			public void mouseExited(MouseEvent e) {
				resetColor(geriLabel);//label renkleri ayarlamayı kolaylaştırmak için yazılmış fonksiyonlarım
			}
		});
		geriLabel.setIcon(new ImageIcon(Arabalar.class.getResource("/return.png")));
		geriLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geriLabel.setBounds(6, 482, 117, 66);
		contentPane.add(geriLabel);
		//geri label ayarlamaları
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(24, 139, 1064, 337);
		contentPane.add(scrollPane_1);
		
		arabalarJTable = new JTable();
		scrollPane_1.setViewportView(arabalarJTable);
		
		
		arabalarLabel = new JLabel("ARABALAR");
		arabalarLabel.setBounds(524, 6, 81, 16);
		contentPane.add(arabalarLabel);
		
		arabaGetirLabel = new JLabel("Araba Getir:");
		arabaGetirLabel.setToolTipText("Araba bilgileri icin plaka giriniz ");
		arabaGetirLabel.setBounds(49, 45, 90, 16);
		contentPane.add(arabaGetirLabel);
		//arabagetir label ayarlamaları
		plakaTf = new JTextField();
		plakaTf.setBounds(151, 40, 130, 26);
		contentPane.add(plakaTf);
		plakaTf.setColumns(11);
		//plaka textfield  ayarlamaları
		markaLabel = new JLabel("Marka: ");
		markaLabel.setBounds(51, 82, 61, 16);
		contentPane.add(markaLabel);
		//marka label ayarlamaları
		modelLabel = new JLabel("Model:");
		modelLabel.setBounds(213, 82, 61, 16);
		contentPane.add(modelLabel);
		//model label ayarlamaları
		modelTf = new JTextField();
		modelTf.setEditable(false);
		modelTf.setBounds(263, 77, 67, 26);
		contentPane.add(modelTf);
		modelTf.setColumns(10);
		//model textfield ayarlamaları
		yilLabel = new JLabel("Yil:");
		yilLabel.setBounds(342, 82, 23, 16);
		contentPane.add(yilLabel);
		//yıl label ayarlamaları
		vitesLabel = new JLabel("Vites:");
		vitesLabel.setBounds(435, 82, 35, 16);
		contentPane.add(vitesLabel);
		//vites label ayarlamaları
		yakitLabel = new JLabel("Yakit Turu:");
		yakitLabel.setBounds(590, 82, 75, 16);
		contentPane.add(yakitLabel);
		//yakıt label ayarlamaları
		fiyatLabel = new JLabel("Fiyat:");
		fiyatLabel.setBounds(898, 82, 61, 16);
		contentPane.add(fiyatLabel);
		//fiyat label ayarlamaları
		
		
		yilLabel = new JLabel("Yil:");
		yilLabel.setBounds(342, 82, 23, 16);
		contentPane.add(yilLabel);
		
		yilTField = new JTextField();
		yilTField.setEditable(false);
		yilTField.setBounds(377, 77, 46, 26);
		contentPane.add(yilTField);
		yilTField.setColumns(10);
		
	
		vitesTField = new JTextField();
		vitesTField.setEditable(false);
		vitesTField.setBounds(482, 77, 96, 26);
		contentPane.add(vitesTField);
		vitesTField.setColumns(10);
		//vites text field ayarlamaları
		
		
		yakitTField = new JTextField();
		yakitTField.setEditable(false);
		yakitTField.setBounds(677, 77, 67, 26);
		contentPane.add(yakitTField);
		yakitTField.setColumns(10);
		//yakıt text field ayarlamaları
		
	
		
		sigaraTField = new JTextField();
		sigaraTField.setEditable(false);
		sigaraTField.setBounds(756, 77, 130, 26);
		contentPane.add(sigaraTField);
		sigaraTField.setColumns(10);
		//sigara text field ayarlamaları
		
		fiyatTField = new JTextField();
		fiyatTField.setEditable(false);
		fiyatTField.setBounds(941, 77, 103, 26);
		contentPane.add(fiyatTField);
		fiyatTField.setColumns(10);
		//fiyat text field ayarlamaları

		markaTf = new JTextField();
		markaTf.setEditable(false);
		markaTf.setBounds(97, 77, 90, 26);
		contentPane.add(markaTf);
		markaTf.setColumns(10);
		
		//marka text field ayarlamaları
		arabalarJTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
		
			}
		));
		
		DefaultTableModel model = (DefaultTableModel)arabalarJTable.getModel();
	
		String filePath = "Arabalar.txt";//dosya yolu belirlenmesi
		File file = new File(filePath); //dosya yaratılması
		        
		try {
		     BufferedReader br = new BufferedReader(new FileReader(file));
		            
		     String firstLine = br.readLine().trim();
		     String[] columnsName = firstLine.split(","); //kolonları virgül ile ayıra ayıra tespit etme
		     model.setColumnIdentifiers(columnsName);//tespit edilen kolon isimlerinin set edilmesi
		        
		            
		            
		     Object[] tableLines = br.lines().toArray(); //satırların tablodan alınması
		            
		            // extratct data from lines
		            // set data to jtable model
		     for(int i = 0; i < tableLines.length; i++)
		     {
		                String line = tableLines[i].toString().trim();
		                String[] dataRow = line.split("/"); //alınan satırların '/' göre ayırılması ve satırlara eklenmesi
		                model.addRow(dataRow);
		            }    
		            
		        } catch (Exception ex) {
		        System.out.println("HATA");
		        }


		getirButton = new JButton("getir");
		getirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				
				int i=0;
				while (i<arabalarJTable.getRowCount()) {// kullanıcı getir butonuna bastığı an girdiği plakaya göre yarattığım JTable üzerinde bilgileri tespit edip, JTable'ın üstünde tasarlamış olduğum textfieldların içine aktarıyor.
					
					if(plakaTf.getText().equals(arabalarJTable.getModel().getValueAt(i,0).toString())) {// if içerisindeki koşul, kullanıcının girdiği plaka ile jtable da bulunan plaka eşleşirse çalışıyor.Eğer eşleşmezse arama devam ediyor.
						modelTf.setText(arabalarJTable.getModel().getValueAt(i,3).toString());
						markaTf.setText(arabalarJTable.getModel().getValueAt(i,1).toString());
						yilTField.setText(arabalarJTable.getModel().getValueAt(i,2).toString());
						fiyatTField.setText(arabalarJTable.getModel().getValueAt(i,11).toString());
						sigaraTField.setText("Sigara " + arabalarJTable.getModel().getValueAt(i,10).toString());
						yakitTField.setText(arabalarJTable.getModel().getValueAt(i,5).toString());
						vitesTField.setText(arabalarJTable.getModel().getValueAt(i,4).toString());
						i=-1;
						break;	
					}
					i++;
				}

				if(i!=-1) { // eğer araç bulunamazsa tüm textfieldların içi boş olarak ayarlansın.
					JOptionPane.showMessageDialog(null,"Boyle bir araba bulunmamaktadir!","",JOptionPane.ERROR_MESSAGE);
					plakaTf.setText("");
					modelTf.setText("");
					markaTf.setText("");
					yilTField.setText("");
					fiyatTField.setText("");
					sigaraTField.setText("");
					yakitTField.setText("");
					vitesTField.setText("");
					
			}
				
				}
			
		});
		getirButton.setBounds(291, 40, 55, 29);
		contentPane.add(getirButton);
		
		
       
}
	public void setColor(JLabel p)
	{
	p.setBackground(new Color(255,204,255));
	}
	public void resetColor(JLabel p)
	{
	p.setBackground(new Color(255,255,255));
	}	//Label'lerin üzerine gelindiğinde arkasının renklenmesi için yazılan iki ayrı method.
}