//---------------------------------------------------------------------------------------------------------------------
//Rezervasyon.java										Author: Zeynep İdil Gül ID: 21894810
//																z_idilgul99@hotmail.com
//
//
//We use this class to make a reservation using some text fields, buttons and labels.
//---------------------------------------------------------------------------------------------------------------------

//------KULLANILAN KUTUPHANELER--------
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class Rezervasyon extends JFrame {

	//degisken tanımlamaları
	private JPanel contentPane;
	private JTextField plakaTf;
	private JTextField ucretTf;
	private String plaka,tarih;
	private int ucret;
	private JTextField soyadTf;
	private JTextField isimTf;
	private JTextField tcTf;
	private JTextField kiraSuresiTf;
	private JTextField adresTf;
	private JTextField tarihTf;
	private JLabel geriLabel;
	private JLabel rezTarihLabel;
	private JLabel plakaLabel;
	private JLabel ucretLabel;
	private JLabel eskiRezGoruntuleLabel;
	private JButton arabaListeleButton;
	private JLabel sifirlaLabel;
	private JLabel musteriBilgiLabel;
	private JLabel soyadLabel;
	private JLabel adLabel;
	private JLabel tcLabel;
	private JLabel gunSayisiLabel;
	private JLabel adresLabel;
	private JButton hesaplaButton;
	private JLabel rezYapLabel;
	//degisken tanımlamaları

	
	public Rezervasyon() {
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x e basıldığında program sonlanması
		setBounds(100, 100, 790, 512);//çerçeve sınırları ayarlamaları
		contentPane = new JPanel();//panel oluşturma
		contentPane.setBackground(Color.WHITE);//arkaplan rengi
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null); //cerceve ortadan açılsın
	    setResizable(false);//boyut degismesin

	    //geri label ayarlamaları
		geriLabel = new JLabel("Geri");
		geriLabel.setBackground(Color.WHITE);
		geriLabel.setOpaque(true);
		
		//geri labelına yapılan mouse işlemleri takibi için
		geriLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg) {
				Test t = new Test(); //test classına geri dönemek için yapılan şeyler
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
		//geri label için baska ayarlamalar
		geriLabel.setIcon(new ImageIcon(Arabalar.class.getResource("/return.png")));
		geriLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geriLabel.setBounds(99, 391, 116, 59);
		contentPane.add(geriLabel);
		//rezTarihi labeli ayarlama
		rezTarihLabel = new JLabel("Rezervasyon tarihi: ");
		rezTarihLabel.setBounds(99, 39, 135, 29);
		contentPane.add(rezTarihLabel);
		//plaka labeli ayarlamalrı
		plakaLabel = new JLabel("Plaka: ");
		plakaLabel.setBounds(99, 80, 61, 16);
		contentPane.add(plakaLabel);
		//ucret labeli ayarlamaları
		ucretLabel = new JLabel("Kiralama ucreti: ");
		ucretLabel.setBounds(99, 315, 135, 16);
		contentPane.add(ucretLabel);
		
		//önceki rezervasyonlaru görüntülemek için label oluşturma
		//bu labelin ayarlamaları
		//mouse listener ile labele yapılan işlemlerin takibi
		eskiRezGoruntuleLabel = new JLabel("Onceki rezervasyonlari goruntule");
		eskiRezGoruntuleLabel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setColor(eskiRezGoruntuleLabel);
			}
			public void mouseExited(MouseEvent e) {
				resetColor(eskiRezGoruntuleLabel);
			}
			public void mouseClicked(MouseEvent e) {
				RezervasyonSec r = new RezervasyonSec(1);
				r.setVisible(true);
			}
		});
		eskiRezGoruntuleLabel.setBackground(Color.WHITE);
		eskiRezGoruntuleLabel.setOpaque(true);
		eskiRezGoruntuleLabel.setIcon(new ImageIcon(Arabalar.class.getResource("/note.png")));
		eskiRezGoruntuleLabel.setBounds(481, 402, 270, 37);
		contentPane.add(eskiRezGoruntuleLabel);
		
		//tarih text fieldı ayarlama
		tarihTf = new JTextField();
		tarihTf.setBounds(263, 40, 135, 26);
		contentPane.add(tarihTf);
		tarihTf.setColumns(10);
		
		//plaka text fieldı ayarlama
		plakaTf = new JTextField();
		plakaTf.setBounds(263, 75, 135, 26);
		contentPane.add(plakaTf);
		plakaTf.setColumns(9);
		//ucret text fieldı ayarlama
		ucretTf = new JTextField();
		ucretTf.setEditable(false);
		ucretTf.setBounds(263, 310, 135, 26);
		contentPane.add(ucretTf);
		ucretTf.setColumns(10);
		
		//araba listelemek için button oluşturma
		//bu buttonun ayarlamaları
		//actionlistener ile button takibi
		arabaListeleButton = new JButton("Araba Listele");
		arabaListeleButton.setToolTipText("Tum arabalari gormek icin tiklayiniz");
		arabaListeleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArabaSec a = new ArabaSec(tarihTf.getText());
				a.setVisible(true);
				dispose();
			}
		});
		arabaListeleButton.setBounds(480, 75, 117, 29);
		contentPane.add(arabaListeleButton);
		
		//sifirla label oluşturma ve ayarlamaları
		//mouse listener ile label işlemlerini kontrol etme
		
		sifirlaLabel = new JLabel("Sifirla");
		sifirlaLabel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				sifirlaLabel.setBackground(new Color(250,128,114));
			}
			public void mouseExited(MouseEvent e) {
				resetColor(sifirlaLabel);
			}
			public void mouseClicked(MouseEvent e) {
				//tüm text fieldları boşaltmak için boş stringe eşitleme
				kiraSuresiTf.setText("");
				adresTf.setText("");
				isimTf.setText("");
				soyadTf.setText("");
				tcTf.setText("");
				ucretTf.setText("");
				plakaTf.setText("");
				tarihTf.setText("");
			}
		});
		sifirlaLabel.setBackground(Color.WHITE);
		sifirlaLabel.setOpaque(true);
		sifirlaLabel.setIcon(new ImageIcon(Arabalar.class.getResource("/x-button.png")));
		sifirlaLabel.setBounds(481, 348, 72, 29);
		contentPane.add(sifirlaLabel);
		
		//müsteri bilgi label ayarlamaları
		musteriBilgiLabel = new JLabel("Musteri Bilgileri:");
		musteriBilgiLabel.setBounds(99, 135, 135, 16);
		contentPane.add(musteriBilgiLabel);
		
		//soyad label ayarlamalrı
		soyadLabel = new JLabel("Soyisim");
		soyadLabel.setBounds(284, 113, 61, 16);
		contentPane.add(soyadLabel);
		
		//ad label ayarlamaları
		adLabel = new JLabel("Isim");
		adLabel.setBounds(439, 114, 61, 14);
		contentPane.add(adLabel);
		
		//tc label ayarlamaları
		tcLabel = new JLabel("TC No");
		tcLabel.setBounds(573, 116, 61, 16);
		contentPane.add(tcLabel);
		
		//soyad text field ayarlamaları
		soyadTf = new JTextField();
		soyadTf.setBounds(263, 130, 135, 26);
		contentPane.add(soyadTf);
		soyadTf.setColumns(30);
		
		//ad text field ayarlamaları
		isimTf = new JTextField();
		isimTf.setBounds(405, 130, 130, 26);
		contentPane.add(isimTf);
		isimTf.setColumns(40);
		
		//tc text field ayarlamaları
		tcTf = new JTextField();
		tcTf.setBounds(547, 130, 130, 26);
		contentPane.add(tcTf);
		tcTf.setColumns(11);
		
		//gün sayısı label ayarlamaları
		gunSayisiLabel = new JLabel("Kiralama Suresi (gun):");
		gunSayisiLabel.setBounds(99, 287, 152, 16);
		contentPane.add(gunSayisiLabel);
		
		//kira süresi text field ayarlamaları
		kiraSuresiTf = new JTextField();
		kiraSuresiTf.setBounds(263, 282, 135, 26);
		contentPane.add(kiraSuresiTf);
		kiraSuresiTf.setColumns(10);
		
		//adres label ayarlamaları
		adresLabel = new JLabel("Arac teslim noktasi:");
		adresLabel.setBounds(99, 173, 152, 16);
		contentPane.add(adresLabel);
		
		//adres text field ayarlamaları
		adresTf = new JTextField();
		adresTf.setBounds(263, 168, 414, 99);
		contentPane.add(adresTf);
		adresTf.setColumns(200);
		
		//gün sayısına bakılarak fiyat hesaplaması yapılabilmesi için gerekli olan butonun ayarlamaları
		//action listener ile buton hareketleri takibi
		hesaplaButton = new JButton("Toplam Fiyat Hesapla");
		hesaplaButton.setToolTipText("Kiralama suresine gore son fiyat goruntulemek icin tiklayiniz");
		hesaplaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(!ucretTf.getText().equals("") && !kiraSuresiTf.getText().equals("") && !kiraSuresiTf.getText().equals("0") ) {
					int kiraSureInt = Integer.parseInt(kiraSuresiTf.getText());
					int ucretInt = Integer.parseInt(ucretTf.getText());
					ucretTf.setText(String.valueOf(ucretInt*kiraSureInt));
				}
			}
		});
		hesaplaButton.setBounds(410, 282, 187, 29);
		contentPane.add(hesaplaButton);
		
		//rezYap labeli ayarlamaları ve mouse listener ile işlemlerin takibi
		
		rezYapLabel =new JLabel("Rezervasyon Yap");
		rezYapLabel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				rezYapLabel.setBackground(new Color(144,238,144));
			}
			public void mouseExited(MouseEvent e) {
				resetColor(rezYapLabel);

			}
			
			public void mouseClicked(MouseEvent e) {
				//eğer hiç bir field boş değilse rezervasyon yap olmasını sağlamak için
				if(!tarihTf.getText().equals("") && !ucretTf.getText().equals("") && !kiraSuresiTf.getText().equals("") && !plakaTf.getText().equals("")
						&& !adresTf.getText().equals("") && !isimTf.getText().equals("")
						&& !soyadTf.getText().equals("") && !tcTf.getText().equals("") ) 
				{
					//kullanıcıya geribildirim vermek amaçlı mesaj
				JOptionPane.showMessageDialog(null,"Rezervasyon basariyla tamamlandi","",JOptionPane.INFORMATION_MESSAGE);
				
				//text fieldlardaki değerleri tutma
				String tarih = tarihTf.getText();
				String name =  isimTf.getText();
				String surname =  soyadTf.getText();
				String id =  tcTf.getText();
				String plakaStr = plakaTf.getText();
				String gun = kiraSuresiTf.getText();
				
				
				//dosyalara yazna
				try {
					FileWriter yazar = new FileWriter("Musteriler.txt",true);
					yazar.write(""+id+"/"+surname+"/"+name);
					yazar.write(System.getProperty("line.separator"));
					yazar.close();
					
					FileWriter yazar2 = new FileWriter("Rezervasyonlar.txt",true);
					yazar2.write(tarih+"/"+id+"/"+surname+"/"+name+"/"+plakaStr+"/"+gun);
					yazar2.write(System.getProperty("line.separator"));
					yazar2.close();
					
					setVisible(false);
					new Rezervasyon().setVisible(true);
					
				}
				catch(Exception exp){
					JOptionPane.showMessageDialog(null,"Rezervasyon yapilamadi","",JOptionPane.ERROR_MESSAGE);
				}
				
				
				}	
				else {
					JOptionPane.showMessageDialog(null,"Lütfen tüm alanları doldurunuz","",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}); 
		rezYapLabel.setBackground(Color.WHITE);
		rezYapLabel.setOpaque(true);
		rezYapLabel.setIcon(new ImageIcon(Arabalar.class.getResource("/ok-2.png")));
		rezYapLabel.setBounds(252, 348, 157, 29);
		contentPane.add(rezYapLabel);
		
	
		
	}
	
	//--------------ikinci constructor----------------------------
	
	public Rezervasyon(String plaka, int ucret,String tarih) {
		//ilk constructordan farklı olarak plaka ucret ve tarih bilgilerini alarak işlem yapar
		this.plaka=plaka;
		this.ucret=ucret;
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
			
			public void mouseClicked(MouseEvent arg0) {
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
		geriLabel.setBounds(99, 391, 116, 59);
		contentPane.add(geriLabel);
		
		rezTarihLabel = new JLabel("Rezervasyon tarihi: ");
		rezTarihLabel.setBounds(99, 39, 135, 29);
		contentPane.add(rezTarihLabel);
		
		plakaLabel = new JLabel("Plaka: ");
		plakaLabel.setBounds(99, 80, 61, 16);
		contentPane.add(plakaLabel);
		
		ucretLabel = new JLabel("Kiralama ucreti: ");
		ucretLabel.setBounds(99, 315, 135, 16);
		contentPane.add(ucretLabel);
		
		
		eskiRezGoruntuleLabel = new JLabel("Onceki rezervasyonlari goruntule");
		eskiRezGoruntuleLabel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setColor(eskiRezGoruntuleLabel);
			}
			public void mouseExited(MouseEvent e) {
				resetColor(eskiRezGoruntuleLabel);
			}
			public void mouseClicked(MouseEvent e) {
				RezervasyonSec r = new RezervasyonSec(1);
				r.setVisible(true);
			}
		});
		eskiRezGoruntuleLabel.setBackground(Color.WHITE);
		eskiRezGoruntuleLabel.setOpaque(true);
		eskiRezGoruntuleLabel.setIcon(new ImageIcon(Arabalar.class.getResource("/note.png")));
		eskiRezGoruntuleLabel.setBounds(481, 402, 270, 37);
		contentPane.add(eskiRezGoruntuleLabel);
		
		tarihTf = new JTextField();
		tarihTf.setBounds(263, 40, 135, 26);
		contentPane.add(tarihTf);
		tarihTf.setColumns(10);
		
		
		plakaTf = new JTextField();
		plakaTf.setBounds(263, 75, 135, 26);
		contentPane.add(plakaTf);
		plakaTf.setColumns(9);
		
		ucretTf = new JTextField();
		ucretTf.setEditable(false);
		ucretTf.setBounds(263, 310, 135, 26);
		contentPane.add(ucretTf);
		ucretTf.setColumns(10);
		
		arabaListeleButton = new JButton("Araba Listele");
		arabaListeleButton.setToolTipText("Tum arabalari gormek icin tiklayiniz");
		arabaListeleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArabaSec a = new ArabaSec(tarihTf.getText());
				a.setVisible(true);
				dispose();
			}
		});
		arabaListeleButton.setBounds(480, 75, 117, 29);
		contentPane.add(arabaListeleButton);
		
		sifirlaLabel = new JLabel("Sifirla");
		sifirlaLabel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				sifirlaLabel.setBackground(new Color(250,128,114));
			}
			public void mouseExited(MouseEvent e) {
				resetColor(sifirlaLabel);
			}
			public void mouseClicked(MouseEvent e) {
				kiraSuresiTf.setText("");
				adresTf.setText("");
				isimTf.setText("");
				soyadTf.setText("");
				tcTf.setText("");
				ucretTf.setText("");
				plakaTf.setText("");
				tarihTf.setText("");
			}
		});
	
		
		sifirlaLabel.setBackground(Color.WHITE);
		sifirlaLabel.setOpaque(true);
		sifirlaLabel.setIcon(new ImageIcon(Arabalar.class.getResource("/x-button.png")));
		sifirlaLabel.setBounds(481, 348, 72, 29);
		contentPane.add(sifirlaLabel);
		
		musteriBilgiLabel = new JLabel("Musteri Bilgileri:");
		musteriBilgiLabel.setBounds(99, 135, 135, 16);
		contentPane.add(musteriBilgiLabel);
		
		soyadLabel = new JLabel("Soyisim");
		soyadLabel.setBounds(284, 113, 61, 16);
		contentPane.add(soyadLabel);
		
		adLabel = new JLabel("Isim");
		adLabel.setBounds(439, 114, 61, 14);
		contentPane.add(adLabel);
		
		tcLabel = new JLabel("TC No");
		tcLabel.setBounds(573, 116, 61, 16);
		contentPane.add(tcLabel);
		
		soyadTf = new JTextField();
		soyadTf.setBounds(263, 130, 135, 26);
		contentPane.add(soyadTf);
		soyadTf.setColumns(30);
		
		isimTf = new JTextField();
		isimTf.setBounds(405, 130, 130, 26);
		contentPane.add(isimTf);
		isimTf.setColumns(40);
		
		tcTf = new JTextField();
		tcTf.setBounds(547, 130, 130, 26);
		contentPane.add(tcTf);
		tcTf.setColumns(11);
		
		gunSayisiLabel = new JLabel("Kiralama Suresi (gun):");
		gunSayisiLabel.setBounds(99, 287, 152, 16);
		contentPane.add(gunSayisiLabel);
		
		kiraSuresiTf = new JTextField();
		kiraSuresiTf.setBounds(263, 282, 135, 26);
		contentPane.add(kiraSuresiTf);
		kiraSuresiTf.setColumns(10);
		
		adresLabel = new JLabel("Arac teslim noktasi:");
		adresLabel.setBounds(99, 173, 152, 16);
		contentPane.add(adresLabel);
		
		adresTf = new JTextField();
		adresTf.setBounds(263, 168, 414, 99);
		contentPane.add(adresTf);
		adresTf.setColumns(200);
		
		
		tarihTf.setText(tarih);
		plakaTf.setText(plaka);
		ucretTf.setText(String.valueOf(ucret));
		
		hesaplaButton = new JButton("Toplam Fiyat Hesapla");
		hesaplaButton.setToolTipText("Kiralama suresine gore son fiyat goruntulemek icin tiklayiniz");
		hesaplaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(!ucretTf.getText().equals("") && !kiraSuresiTf.getText().equals("")&& !kiraSuresiTf.getText().equals("0")) {
					ucretTf.setText(String.valueOf(ucret));
					int kiraSureInt = Integer.parseInt(kiraSuresiTf.getText());
					int ucretInt = Integer.parseInt(ucretTf.getText());
					ucretTf.setText(String.valueOf(ucretInt*kiraSureInt));
				}
			}
		});
		hesaplaButton.setBounds(410, 282, 187, 29);
		contentPane.add(hesaplaButton);
		
		rezYapLabel = new JLabel("Rezervasyon Yap");
		rezYapLabel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				rezYapLabel.setBackground(new Color(144,238,144));
			}
			public void mouseExited(MouseEvent e) {
				resetColor(rezYapLabel);

			}
			public void mouseClicked(MouseEvent e) {
				if(!tarihTf.getText().equals("") &&!ucretTf.getText().equals("") && !kiraSuresiTf.getText().equals("") && !plakaTf.getText().equals("")
						&& !adresTf.getText().equals("") && !isimTf.getText().equals(""))
						{		
				JOptionPane.showMessageDialog(null,"Rezervasyon basariyla tamamlandi","",JOptionPane.INFORMATION_MESSAGE);
				
				String tarih = tarihTf.getText();
				String name =  isimTf.getText();
				String surname =  soyadTf.getText();
				String id =  tcTf.getText();
				String plakaStr = plakaTf.getText();
				String gun = kiraSuresiTf.getText();
				String ucret = ucretTf.getText();

				
				try {
					FileWriter yazar = new FileWriter("Musteriler.txt",true);
					
					
					yazar.write(""+id+"/"+surname+"/"+name);
					yazar.write(System.getProperty("line.separator"));
					yazar.close();
					
					FileWriter yazar2 = new FileWriter("Rezervasyonlar.txt",true);
					yazar2.write(tarih+"/"+id+"/"+surname+"/"+name+"/"+plakaStr+"/"+gun+"/"+ucret+"/");
					yazar2.write(System.getProperty("line.separator"));
					yazar2.close();
					
					setVisible(false);
					new Rezervasyon().setVisible(true);
					
				}
				catch(Exception exp){
					JOptionPane.showMessageDialog(null,"Rezervasyon yapilamadi","",JOptionPane.ERROR_MESSAGE);
				}
			    }
				else {
					JOptionPane.showMessageDialog(null,"Lütfen tüm alanları doldurunuz","",JOptionPane.INFORMATION_MESSAGE);

				}

			}
		}); 
		rezYapLabel.setBackground(Color.WHITE);
		rezYapLabel.setOpaque(true);
		rezYapLabel.setIcon(new ImageIcon(Arabalar.class.getResource("/ok-2.png")));
		rezYapLabel.setBounds(252, 348, 157, 29);
		contentPane.add(rezYapLabel);
		
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
