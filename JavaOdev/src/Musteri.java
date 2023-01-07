//---------------------------------------------------------------------------------------------------------------------
//Musteri.java											Author: Zeynep İdil Gül ID: 21894810
//																z_idilgul99@hotmail.com
//
//
//We use this class to display customers and easily find them by their id.
//---------------------------------------------------------------------------------------------------------------------

//------KULLANILAN KUTUPHANELER--------
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Musteri extends JFrame {
	//DEĞİŞKEN TANIMLAMALARI
	private JPanel contentPane;
	private JLabel geriLabel;
	private JTable musteriJTable;
	private JLabel musterilerLabel;
	private JLabel musteriGetirLabel;
	private JTextField tcNoTf;
	private JButton getirButton;
	private JLabel soyadLabel;
	private JTextField soyadTextField;
	private JLabel adLabel;
	private JTextField adTextField;
	private JScrollPane scrollPane;
	//DEĞİŞKEN TANIMLAMALARI
	public Musteri() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//çarpıya basıldığında uygulamanın sonlanması için
		setBounds(100, 100, 790, 512);//boyutlandırma ayarları
		contentPane = new JPanel();//JPanel yaratılması
		contentPane.setBackground(Color.WHITE);//arka planın beyaz olarak ayarlanması
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//boyutlandırma ayarları
		setContentPane(contentPane);//contenpane ayarlaması
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null); //çerçeve açıldığında ekranın tam ortasında konumlanması için
	    setResizable(false);//yeniden boyutlandırma kapatıldı

		geriLabel = new JLabel("Geri");
		geriLabel.setBackground(Color.WHITE);
		geriLabel.setOpaque(true);
		geriLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent a) {
				Test t = new Test();//Test sınıfı yaratılması.
				t.setVisible(true);//Test sınıfı yaratıldığında çerçevenin görünür olması için
				dispose();//setVisible(false) yerine sınıfın sonlandırılması için
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
		geriLabel.setBounds(6, 419, 116, 59);
		contentPane.add(geriLabel);
		//geri label ayarlamaları
		scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 122, 694, 297);
		contentPane.add(scrollPane);
		//scrollpane oluşturulup, contentpane'e eklenmesi
		musteriJTable = new JTable(); //JTable oluşturulması
		scrollPane.setViewportView(musteriJTable);
		
		musterilerLabel = new JLabel("MUSTERILER");
		musterilerLabel.setBounds(358, 6, 81, 16);
		contentPane.add(musterilerLabel);
		//musteriler label ayarlamaları
		musteriGetirLabel = new JLabel("Musteri Getir:");
		musteriGetirLabel.setToolTipText("Musteri bilgileri icin TC no giriniz ");
		musteriGetirLabel.setBounds(49, 45, 90, 16);
		contentPane.add(musteriGetirLabel);
		//musteri getir label ayarlamaları
		tcNoTf = new JTextField();
		tcNoTf.setBounds(151, 40, 130, 26);
		contentPane.add(tcNoTf);
		tcNoTf.setColumns(11);
		//TC no text field ayarlamaları
		soyadLabel = new JLabel("Soyisim:");
		soyadLabel.setBounds(51, 82, 61, 16);
		contentPane.add(soyadLabel);
		//soyad label ayarlamaları
		soyadTextField = new JTextField();
		soyadTextField.setEditable(false);
		soyadTextField.setBounds(151, 78, 130, 26);
		contentPane.add(soyadTextField);
		soyadTextField.setColumns(10);
		//soyad text field ayarlamaları
		adLabel = new JLabel("Isim:");
		adLabel.setBounds(331, 82, 61, 16);
		contentPane.add(adLabel);
		//ad label ayarlamaları
		adTextField = new JTextField();
		adTextField.setEditable(false);
		adTextField.setBounds(382, 77, 130, 26);
		contentPane.add(adTextField);
		adTextField.setColumns(10);
		//Ad text field ayarlamaları
		getirButton = new JButton("getir");
		getirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				
				int i=0;
				while (i<musteriJTable.getRowCount()) {
					//getir butonuna basıldığında kullanıcının girdiği TC numarası , JTable'da aranmaya başlıyor, bulunursa ad ve soyad kısmı tablodan alınıp text field'lara aktarılıyor. eğer bulunmazsa aramaya devam ediliyor.
					if(tcNoTf.getText().equals(musteriJTable.getModel().getValueAt(i,0).toString())) {
						adTextField.setText(musteriJTable.getModel().getValueAt(i,1).toString());
						soyadTextField.setText(musteriJTable.getModel().getValueAt(i,2).toString());
							i=-1;
							break;
					}
				
					i++;
				}
				
				if(i!=-1) {//eğer aranan tc numarasında bir müşteri yoksa
					JOptionPane.showMessageDialog(null,"Boyle bir musteri bulunmamaktadir!","",JOptionPane.ERROR_MESSAGE);
					tcNoTf.setText("");// text fieldların içi tekrardan boş olarak set ediliyor
					adTextField.setText("");
					soyadTextField.setText("");
					
				}
				
				}
			
		});
		getirButton.setBounds(291, 40, 55, 29);
		contentPane.add(getirButton);
		
		
		
		
		String[] columnsName = {"TC No","Soyisim","Isim","Arac Kiralama Sayisi","Odenen Toplam Ucret"};
		
		String filePath = "Musteriler.txt";//dosya yolu
        File file = new File(filePath);//dosya oluşturulması
        DefaultTableModel model = (DefaultTableModel)musteriJTable.getModel();
        model.setColumnIdentifiers(columnsName);
        //tablo ayarlamaları
		
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
          
            Object[] tableLines = br.lines().toArray();
            //dosyadan satırlar okunup, dizi içerisine atılıyor
            
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split("/");//dizideki bilgiler '/' göre ayırılıp String dizisine atılıyor
                model.addRow(dataRow);//string dizisinde bulunan bilgiler sırayla tabloya ekleniyor
                
                
            }
            
        } catch (Exception ex) {
        System.out.println("HATA");
        }
     
		
	}
	public void setColor(JLabel p)
	{
	p.setBackground(new Color(255,204,255));
	
	}
	public void resetColor(JLabel p)
	{
	p.setBackground(new Color(255,255,255));
	}//Label'lerin üzerine gelindiğinde arkasının renklenmesi için yazılan iki ayrı method.
}