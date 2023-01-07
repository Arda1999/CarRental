//---------------------------------------------------------------------------------------------------------------------
//Fatura.java											Author: Zeynep İdil Gül ID: 21894810
//																z_idilgul99@hotmail.com
//
//
//We use this class while invoicing of a car rental.
//---------------------------------------------------------------------------------------------------------------------

//------KULLANILAN KUTUPHANELER--------
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Fatura extends JFrame {

	//değişken tanımları
	private JPanel contentPane;
	private JTextField faturaTcTf;
	private JTextField faturaSoyadTf;
	private JTextField faturaIsımTf;
	private JTextField faturaPlakaTf;
	private JTextField faturaFiyatTf;
	private int odenecekTutar,romork=0,bagaj=0,cocukKoltugu=0,zincir=0,indirim=0,eklemeSonuFiyat=0,fiyat;
	private String tc,soyisim,isim,plaka,tarih;
	private JLabel geriLabel;
	private JLabel faturaTcLabel;
	private JLabel faturaSoyadLabel;
	private JLabel faturaIsimLabel;
	private JLabel faturaMusteriLabel;
	private JLabel faturaAracLabel;
	private JLabel faturaPlakaLabel;
	private JLabel faturaFiyatLabel;
	private JCheckBox zincirCBox;
	private JLabel faturaEklentilerLabel;
	private JCheckBox cocukKoltuguCBox;
	private JCheckBox ustBagajCBox;
	private JCheckBox romorkCBox;
	private JButton faturaButton;
	private JLabel kampanyaLabel;
	private JCheckBox haftasonuCBox;
	private JCheckBox ilkKiralamaCBox;
	private JLabel tutarLabel;
	private JCheckBox surekliMusteriCBox;
	private JButton rezSecButton;
	private JTextArea textArea;
	private JButton tutarButton;
	//değişken tanımları

	//parametresiz ilk constructor
	public Fatura() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); 
	    setResizable(false);

	    //geri label ayarlamaları ve mouse listner ile labelin kontrolü
		geriLabel = new JLabel("Geri");
		geriLabel.setBackground(Color.WHITE);
		geriLabel.setOpaque(true);
		geriLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				Test t = new Test();
				t.setVisible(true);
				dispose();
			}
	
			public void mouseEntered(MouseEvent e) {
				setColor(geriLabel);
			}
			public void mouseExited(MouseEvent e) {
				resetColor(geriLabel);
			}
		});
		geriLabel.setIcon(new ImageIcon(Arabalar.class.getResource("/return.png")));
		geriLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geriLabel.setBounds(16, 400, 116, 59);
		contentPane.add(geriLabel);
		
		 //faturaTC label ayarlamaları
		faturaTcLabel = new JLabel("TC No:");
		faturaTcLabel.setBounds(24, 41, 61, 16);
		contentPane.add(faturaTcLabel);
		
		//faturaTC text field ayarlamaları
		faturaTcTf = new JTextField();
		faturaTcTf.setBounds(97, 36, 130, 26);
		contentPane.add(faturaTcTf);
		faturaTcTf.setColumns(10);
		
		//faturaSoyad label ayarlamaları
		faturaSoyadLabel = new JLabel("Soyisim:");
		faturaSoyadLabel.setBounds(257, 41, 61, 16);
		contentPane.add(faturaSoyadLabel);
		
		//faturaSoyad text field ayarlamaları
		faturaSoyadTf = new JTextField();
		faturaSoyadTf.setBounds(330, 36, 130, 26);
		contentPane.add(faturaSoyadTf);
		faturaSoyadTf.setColumns(10);
		
		//faturaIsim label ayarlamaları
		faturaIsimLabel = new JLabel("Isim:");
		faturaIsimLabel.setBounds(504, 41, 61, 16);
		contentPane.add(faturaIsimLabel);
		
		//faturaIsim text field ayarlamaları
		faturaIsımTf = new JTextField();
		faturaIsımTf.setBounds(577, 36, 130, 26);
		contentPane.add(faturaIsımTf);
		faturaIsımTf.setColumns(10);
		
		//faturaMusteri label ayarlamaları
		faturaMusteriLabel = new JLabel("Musteri Bilgileri");
		faturaMusteriLabel.setBounds(16, 13, 150, 16);
		contentPane.add(faturaMusteriLabel);
		
		//faturaArac label ayarlamaları
		faturaAracLabel = new JLabel("Arac Bilgileri");
		faturaAracLabel.setBounds(16, 70, 141, 16);
		contentPane.add(faturaAracLabel);
		
		//faturaPlaka label ayarlamaları
		faturaPlakaLabel = new JLabel("Plaka:");
		faturaPlakaLabel.setBounds(24, 98, 61, 16);
		contentPane.add(faturaPlakaLabel);
		
		//faturaFiyat label ayarlamaları
		faturaFiyatLabel = new JLabel("Fiyat:");
		faturaFiyatLabel.setBounds(257, 98, 61, 16);
		contentPane.add(faturaFiyatLabel);
		
		//faturaFiyat text field ayarlamaları
		faturaFiyatTf = new JTextField();
		faturaFiyatTf.setEditable(false);
		faturaFiyatTf.setBounds(330, 93, 130, 26);
		contentPane.add(faturaFiyatTf);
		faturaFiyatTf.setColumns(10);
		
		//faturaPlaka label ayarlamaları
		faturaPlakaTf = new JTextField();
		faturaPlakaTf.setBounds(97, 93, 130, 26);
		contentPane.add(faturaPlakaTf);
		faturaPlakaTf.setColumns(10);
		
		faturaFiyatTf.setText("0");//ilk başta 0 olsun çünkü boş
		odenecekTutar=Integer.parseInt(faturaFiyatTf.getText());//degisiklik yapilmamişsa odenecek tutar
		eklemeSonuFiyat=odenecekTutar;
		
		//lastik zinciri eklentisi check Box ayarlamaları ve action listener ile takibi
		zincirCBox = new JCheckBox("Lastik Zinciri +100tl");
		zincirCBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(zincirCBox.isSelected()) {
					odenecekTutar+=100; //lastik zinciri eklendiğinde fiyat artsın
					zincir=100;
					eklemeSonuFiyat+=100;
				}
				else {
					odenecekTutar-=100;;//degisiklik yapilmamişsa odenecek tutar
					eklemeSonuFiyat=odenecekTutar;
					zincir=0;
				}
			}
		});
		zincirCBox.setBounds(17, 156, 172, 23);
		contentPane.add(zincirCBox);
		
		//faturaEklentiler label ayarlamaları
		faturaEklentilerLabel = new JLabel("Arac Eklentileri");
		faturaEklentilerLabel.setBounds(16, 128, 150, 16);
		contentPane.add(faturaEklentilerLabel);
	
		//cocuk koltugu eklentisi check Box ayarlamaları ve action listener ile takibi
		cocukKoltuguCBox = new JCheckBox("Cocuk Koltugu +200tl");
		cocukKoltuguCBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(cocukKoltuguCBox.isSelected()) {
					odenecekTutar+=200; //cocuk koltugu eklendiginde fiyat artsin
					cocukKoltugu=200;
					eklemeSonuFiyat+=200;
				}
				else {
					odenecekTutar-=200;//degisiklik yapilmamişsa odenecek tutar
					eklemeSonuFiyat=odenecekTutar;
					cocukKoltugu=0;
				}
			}
		});
		cocukKoltuguCBox.setBounds(190, 156, 172, 23);
		contentPane.add(cocukKoltuguCBox);
		
		//üst bagaj eklentisi check Box ayarlamaları ve action listener ile takibi
		ustBagajCBox = new JCheckBox("Ust Bagaj +200tl");
		ustBagajCBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(ustBagajCBox.isSelected()) {
					odenecekTutar+=200; //ust bagaj eklendiginde fiyat artsin
					bagaj=200;
					eklemeSonuFiyat+=200;
				}
				else {
					odenecekTutar-=200;//degisiklik yapilmamişsa odenecek tutar
					eklemeSonuFiyat=odenecekTutar;
					bagaj=0;
				}
			}
		});
		ustBagajCBox.setBounds(393, 156, 150, 23);
		contentPane.add(ustBagajCBox);
		
		//römork eklentisi check Box ayarlamaları ve action listener ile takibi
		romorkCBox = new JCheckBox("Romork +500tl");
		romorkCBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(romorkCBox.isSelected()) {
					odenecekTutar+=500; //Römork eklendiginde fiyat artsin
					romork=500;
					eklemeSonuFiyat+=500;
				}
				else {
					odenecekTutar-=500;//degisiklik yapilmamişsa odenecek tutar
					eklemeSonuFiyat=odenecekTutar;
					romork=0;
				}
			}
		});
		romorkCBox.setBounds(555, 156, 128, 23);
		contentPane.add(romorkCBox);
		
		//faturaButton ayarlamaları
		faturaButton = new JButton("Faturayi Yazdir");
		faturaButton.setBounds(627, 416, 117, 29);
		contentPane.add(faturaButton);
		
		//kampanya label ayarlamaları
		kampanyaLabel = new JLabel("Kampanyalar");
		kampanyaLabel.setBounds(16, 191, 141, 16);
		contentPane.add(kampanyaLabel);
		
		eklemeSonuFiyat=odenecekTutar;//ekleme sonunda kayıp yaşamamak için
		
		//haftasonu indirimi Check Box ayarlamaları ve action listener ile takibi
		haftasonuCBox = new JCheckBox("Haftasonu Indirimi %10");
		haftasonuCBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(haftasonuCBox.isSelected()) {
				odenecekTutar = (eklemeSonuFiyat*90)/100; //indirim yapıldıgında fiyat düssün
				indirim=10;
				}
				else {
					indirim=0;
					odenecekTutar=eklemeSonuFiyat;
				}
			}
		});
		haftasonuCBox.setBounds(17, 219, 192, 23);
		contentPane.add(haftasonuCBox);
		
		//surekli musteri indirimi Check Box ayarlamaları ve action listener ile takibi
		surekliMusteriCBox = new JCheckBox("Surekli Musteri Indirimi %10");
		surekliMusteriCBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(surekliMusteriCBox.isSelected()) {
				odenecekTutar = (eklemeSonuFiyat*90)/100; //indirim yapıldıgında fiyat düssün
				indirim=10;
				}
				else {
					indirim=0;
					odenecekTutar=eklemeSonuFiyat;
				}
			}
		});
		surekliMusteriCBox.setBounds(221, 219, 219, 23);
		contentPane.add(surekliMusteriCBox);
		
		//ilk kiralama indirimi Check Box ayarlamaları ve action listener ile takibi
		ilkKiralamaCBox = new JCheckBox("Hosgeldin Indirimi %10");
		ilkKiralamaCBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(ilkKiralamaCBox.isSelected()) {
				odenecekTutar = (eklemeSonuFiyat*90)/100; //indirim yapıldıgında fiyat düssün
				indirim=10;
				}
				else {
					indirim=0;
					odenecekTutar=eklemeSonuFiyat;
				}
			}
		});
		ilkKiralamaCBox.setBounds(452, 219, 185, 23);
		contentPane.add(ilkKiralamaCBox);
		
		//rez sec button ayarlamaları ve action listener ile takibi
		rezSecButton = new JButton("Rezervasyon Sec");
		rezSecButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RezervasyonSec r = new RezervasyonSec();
				r.setVisible(true);
				dispose();
			}
		});
		rezSecButton.setBounds(504, 93, 198, 29);
		contentPane.add(rezSecButton);
		
		//tutar label ayarlamaları
		tutarLabel = new JLabel("Odenecek Tutar");
		tutarLabel.setBounds(16, 270, 116, 16);
		contentPane.add(tutarLabel);
		//textArea ayarlamaları
		textArea = new JTextArea();
		textArea.setBackground(new Color(245, 245, 245));
		textArea.setEditable(false);
		textArea.setBounds(189, 270, 219, 142);
		contentPane.add(textArea);
		
		//tutar button ayarlamaları ve action listener ile takibi
		tutarButton = new JButton("Hesapla");
		tutarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				//hesapla butonuna basıldığında ekrana fatura yazdırma
				textArea.setText("Kiralama Fiyatı: " + faturaFiyatTf.getText() + "tl\n" + "Ek hizmetler: \nLastik Zinciri +" +zincir+"tl\n"+
			"Cocuk Koltugu +"+cocukKoltugu+"tl\n"+"Ust Bagaj +"+bagaj+"tl\n" + "Romork +"+romork+"tl\n"+"Indirim Orani: %"+indirim+
			"\nToplam :"+odenecekTutar +"tl"
		);
				//------------------------------------
			}
		});
		tutarButton.setBounds(15, 298, 117, 29);
		contentPane.add(tutarButton);
	}
	
	//--------------ikinci constructor----------------------------
	public Fatura(String tarih,String tc,String soyisim,String isim,String plaka,int fiyat ) {
		//ilk constructordan tek farkı değerleri önceden alıp text fieldlar içerisine yerleştirilmesi
		this.plaka=plaka;
		this.tc=tc;
		this.isim=isim;
		this.soyisim=soyisim;
		this.fiyat=fiyat;
		this.tarih=tarih;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); 
	    setResizable(false);

		geriLabel = new JLabel("Geri");
		geriLabel.setBackground(Color.WHITE);
		geriLabel.setOpaque(true);
		geriLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				Test t = new Test();
				t.setVisible(true);
				dispose();
			}
	
			public void mouseEntered(MouseEvent e) {
				setColor(geriLabel);
			}
			public void mouseExited(MouseEvent e) {
				resetColor(geriLabel);
			}
		});
		geriLabel.setIcon(new ImageIcon(Arabalar.class.getResource("/return.png")));
		geriLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geriLabel.setBounds(16, 400, 116, 59);
		contentPane.add(geriLabel);
		
		faturaTcLabel = new JLabel("TC No:");
		faturaTcLabel.setBounds(24, 41, 61, 16);
		contentPane.add(faturaTcLabel);
		
		faturaTcTf = new JTextField();
		faturaTcTf.setBounds(97, 36, 130, 26);
		contentPane.add(faturaTcTf);
		faturaTcTf.setColumns(10);
		
		faturaSoyadLabel = new JLabel("Soyisim:");
		faturaSoyadLabel.setBounds(257, 41, 61, 16);
		contentPane.add(faturaSoyadLabel);
		
		faturaSoyadTf = new JTextField();
		faturaSoyadTf.setBounds(330, 36, 130, 26);
		contentPane.add(faturaSoyadTf);
		faturaSoyadTf.setColumns(10);
		
		faturaIsimLabel = new JLabel("Isim:");
		faturaIsimLabel.setBounds(504, 41, 61, 16);
		contentPane.add(faturaIsimLabel);
		
		faturaIsımTf = new JTextField();
		faturaIsımTf.setBounds(577, 36, 130, 26);
		contentPane.add(faturaIsımTf);
		faturaIsımTf.setColumns(10);
		
		faturaMusteriLabel = new JLabel("Musteri Bilgileri");
		faturaMusteriLabel.setBounds(16, 13, 150, 16);
		contentPane.add(faturaMusteriLabel);
		
		faturaAracLabel = new JLabel("Arac Bilgileri");
		faturaAracLabel.setBounds(16, 70, 141, 16);
		contentPane.add(faturaAracLabel);
		
		faturaPlakaLabel = new JLabel("Plaka:");
		faturaPlakaLabel.setBounds(24, 98, 61, 16);
		contentPane.add(faturaPlakaLabel);
		
		faturaFiyatLabel = new JLabel("Fiyat:");
		faturaFiyatLabel.setBounds(257, 98, 61, 16);
		contentPane.add(faturaFiyatLabel);
		
		faturaFiyatTf = new JTextField();
		faturaFiyatTf.setEditable(false);
		faturaFiyatTf.setBounds(330, 93, 130, 26);
		contentPane.add(faturaFiyatTf);
		faturaFiyatTf.setColumns(10);
		
		faturaPlakaTf = new JTextField();
		faturaPlakaTf.setBounds(97, 93, 130, 26);
		contentPane.add(faturaPlakaTf);
		faturaPlakaTf.setColumns(10);
		
		faturaPlakaTf.setText(plaka);
		faturaSoyadTf.setText(soyisim);
		faturaTcTf.setText(tc);
		faturaIsımTf.setText(isim);
		faturaFiyatTf.setText(String.valueOf(fiyat));
		
		
		
		odenecekTutar=Integer.parseInt(faturaFiyatTf.getText());//degisiklik yapilmamişsa odenecek tutar
		eklemeSonuFiyat=odenecekTutar;
		zincirCBox = new JCheckBox("Lastik Zinciri +100tl");
		zincirCBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(zincirCBox.isSelected()) {
					odenecekTutar+=100; //lastik zinciri eklendiğinde fiyat artsın
					zincir=100;
					eklemeSonuFiyat+=100;
				}
				else {
					odenecekTutar-=100;;//degisiklik yapilmamişsa odenecek tutar
					eklemeSonuFiyat=odenecekTutar;
					zincir=0;
				}
			}
		});
		zincirCBox.setBounds(17, 156, 172, 23);
		contentPane.add(zincirCBox);
		
		faturaEklentilerLabel = new JLabel("Arac Eklentileri");
		faturaEklentilerLabel.setBounds(16, 128, 150, 16);
		contentPane.add(faturaEklentilerLabel);
	
		
		cocukKoltuguCBox = new JCheckBox("Cocuk Koltugu +200tl");
		cocukKoltuguCBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(cocukKoltuguCBox.isSelected()) {
					odenecekTutar+=200; //cocuk koltugu eklendiginde fiyat artsin
					cocukKoltugu=200;
					eklemeSonuFiyat+=200;
				}
				else {
					odenecekTutar-=200;//degisiklik yapilmamişsa odenecek tutar
					eklemeSonuFiyat=odenecekTutar;
					cocukKoltugu=0;
				}
			}
		});
		cocukKoltuguCBox.setBounds(190, 156, 172, 23);
		contentPane.add(cocukKoltuguCBox);
		
		ustBagajCBox = new JCheckBox("Ust Bagaj +200tl");
		ustBagajCBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(ustBagajCBox.isSelected()) {
					odenecekTutar+=200; //ust bagaj eklendiginde fiyat artsin
					bagaj=200;
					eklemeSonuFiyat+=200;
				}
				else {
					odenecekTutar-=200;//degisiklik yapilmamişsa odenecek tutar
					eklemeSonuFiyat=odenecekTutar;
					bagaj=0;
				}
			}
		});
		ustBagajCBox.setBounds(393, 156, 150, 23);
		contentPane.add(ustBagajCBox);
		
		romorkCBox = new JCheckBox("Romork +500tl");
		romorkCBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(romorkCBox.isSelected()) {
					odenecekTutar+=500; //Römork eklendiginde fiyat artsin
					romork=500;
					eklemeSonuFiyat+=500;
				}
				else {
					odenecekTutar-=500;//degisiklik yapilmamişsa odenecek tutar
					eklemeSonuFiyat=odenecekTutar;
					romork=0;
				}
			}
		});
		romorkCBox.setBounds(555, 156, 128, 23);
		contentPane.add(romorkCBox);
		
		faturaButton = new JButton("Faturayi Yazdir");
		faturaButton.setBounds(627, 416, 117, 29);
		contentPane.add(faturaButton);
		
		kampanyaLabel = new JLabel("Kampanyalar");
		kampanyaLabel.setBounds(16, 191, 141, 16);
		contentPane.add(kampanyaLabel);
		
		eklemeSonuFiyat=odenecekTutar;
		
		haftasonuCBox = new JCheckBox("Haftasonu Indirimi %10");
		haftasonuCBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(haftasonuCBox.isSelected()) {
				odenecekTutar = (eklemeSonuFiyat*90)/100; //indirim yapıldıgında fiyat düssün
				indirim=10;
				}
				else {
					indirim=0;
					odenecekTutar=eklemeSonuFiyat;
				}
			}
		});
		haftasonuCBox.setBounds(17, 219, 192, 23);
		contentPane.add(haftasonuCBox);
		
		surekliMusteriCBox = new JCheckBox("Surekli Musteri Indirimi %10");
		surekliMusteriCBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(surekliMusteriCBox.isSelected()) {
				odenecekTutar = (eklemeSonuFiyat*90)/100; //indirim yapıldıgında fiyat düssün
				indirim=10;
				}
				else {
					indirim=0;
					odenecekTutar=eklemeSonuFiyat;
				}
			}
		});
		surekliMusteriCBox.setBounds(221, 219, 219, 23);
		contentPane.add(surekliMusteriCBox);
		
		ilkKiralamaCBox = new JCheckBox("Hosgeldin Indirimi %10");
		ilkKiralamaCBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(ilkKiralamaCBox.isSelected()) {
				odenecekTutar = (eklemeSonuFiyat*90)/100; //indirim yapıldıgında fiyat düssün
				indirim=10;
				}
				else {
					indirim=0;
					odenecekTutar=eklemeSonuFiyat;
				}
			}
		});
		ilkKiralamaCBox.setBounds(452, 219, 185, 23);
		contentPane.add(ilkKiralamaCBox);
		
		rezSecButton = new JButton("Rezervasyon Sec");
		rezSecButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RezervasyonSec r = new RezervasyonSec();
				r.setVisible(true);
				dispose();
			}
		});
		rezSecButton.setBounds(504, 93, 198, 29);
		contentPane.add(rezSecButton);
		
		
		tutarLabel = new JLabel("Odenecek Tutar");
		tutarLabel.setBounds(16, 270, 116, 16);
		contentPane.add(tutarLabel);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(245, 245, 245));
		textArea.setEditable(false);
		textArea.setBounds(189, 270, 219, 142);
		contentPane.add(textArea);
		
		tutarButton = new JButton("Hesapla");
		tutarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				textArea.setText("Kiralama Fiyatı: " + faturaFiyatTf.getText() + "tl\n" + "Ek hizmetler: \nLastik Zinciri +" +zincir+"tl\n"+
			"Cocuk Koltugu +"+cocukKoltugu+"tl\n"+"Ust Bagaj +"+bagaj+"tl\n" + "Romork +"+romork+"tl\n"+"Indirim Orani: %"+indirim+
			"\nToplam :"+odenecekTutar +"tl"
		);
			}
		});
		tutarButton.setBounds(15, 298, 117, 29);
		contentPane.add(tutarButton);
	}
	
	//label renkleri ayarlamayı kolaylaştırmak için yazılmış fonksiyonlarım
	public void setColor(JLabel p)
	{
	p.setBackground(new Color(255,204,255));
	}
	public void resetColor(JLabel p)
	{
	p.setBackground(new Color(255,255,255));
	}
}
