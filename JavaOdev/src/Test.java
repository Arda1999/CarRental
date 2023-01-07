//---------------------------------------------------------------------------------------------------------------------
//Test.java												Author: Zeynep İdil Gül ID: 21894810
//																z_idilgul99@hotmail.com
//
//
//	This is our main class. We use this to create Rezervasyon,Arabalar,Fatura,Musteri classes and
//to create files that we are going to use.
//---------------------------------------------------------------------------------------------------------------------

//------KULLANILAN KUTUPHANELER--------
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Test extends JFrame {
	//DEĞİŞKEN TANIMLAMALARI
	private JPanel c;
	private JLabel musteriLabel;
	private JLabel faturaLabel;
	private JLabel arabalarLabel;
	private JLabel rezervasyonLabel;
	//DEĞİŞKEN TANIMLAMALARI
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	Test t = new Test(); // Test classından bir obje yaratılıyor.
	t.setVisible(true); // bu classdan yaratılan objenin görünmesini sağlayan fonksiyon.
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Test.class.getResource("/rose.png"))); //Açılan çerçevede sol üst köşede çıkan ikon 
		setTitle("Gul Car Rental Uygulamasi"); //başlık
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Çarpıya basıldığında uygulamanın kapanması
		setBounds(100, 100, 790, 512);//boyutlandırma ayarları
		c = new JPanel();//değişken ismi c olan yeni bir jpanel tanımlandı
		c.setBackground(Color.WHITE);//Arka plan beyaz renk olarak ayarlandı.
		c.setBorder(new EmptyBorder(5, 5, 5, 5));//boyutlandırma ayarları
		setContentPane(c); //Content pane ayarlanması
		c.setLayout(null);
	    setLocationRelativeTo(null); // Açılacak olan görüntünün tam ortada çıkmasını sağlayan fonksiyon
	    setResizable(false); // Yeniden boyutlandırma kapatıldı
		JLabel baslikLabel = new JLabel("GUL CAR RENTAL ");
		baslikLabel.setIcon(new ImageIcon(Test.class.getResource("/rose.png")));//baslik labelinin yanına gül ikonunun eklenmesi
		baslikLabel.setFont(new Font("Charter", Font.BOLD | Font.ITALIC, 20));//Yazı tipi belirlenmesi
		baslikLabel.setBounds(318, 20, 294, 79);//boyutlandırma ayarları
		c.add(baslikLabel);
		//Başlık bilgileri
		
		rezervasyonLabel = new JLabel("Rezervasyon");
		rezervasyonLabel.setIcon(new ImageIcon(Test.class.getResource("/booking.png")));
		rezervasyonLabel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setColor(rezervasyonLabel);
				//label renkleri ayarlamayı kolaylaştırmak için yazılmış fonksiyonlarım
			}
			public void mouseExited(MouseEvent e) {
				resetColor(rezervasyonLabel);
				//label renkleri ayarlamayı kolaylaştırmak için yazılmış fonksiyonlarım
			}
			public void mouseClicked(MouseEvent e) {
				Rezervasyon r = new Rezervasyon();//Rezervasyon classının açılıp, Test classının kapanması için , Rezervasyon classından bir obje yaratılıyor.
				r.setVisible(true);//bu classdan yaratılan objenin görünmesini sağlayan fonksiyon.
				dispose();//setVisible(false) yerine dispose() methodu kullanılmıştır. 
			}
		});
		rezervasyonLabel.setHorizontalAlignment(SwingConstants.CENTER); //oluşturulan label çerçevesinde yazının ortada çıkması için.
		rezervasyonLabel.setOpaque(true);
		rezervasyonLabel.setBackground(new Color(204, 204, 255));
		rezervasyonLabel.setBounds(101, 146, 173, 86);
		c.add(rezervasyonLabel);
		rezervasyonLabel.setToolTipText("Rezervasyon yapmak ve rezervasyonlari goruntulemek icin tiklayin");
		//Rezervasyon label ayarlamaları
		
		arabalarLabel = new JLabel("Arabalar");
		arabalarLabel.setIcon(new ImageIcon(Test.class.getResource("/car.png")));
		arabalarLabel.setOpaque(true);
		arabalarLabel.setHorizontalAlignment(SwingConstants.CENTER);//oluşturulan label çerçevesinde yazının ortada çıkması için.
		arabalarLabel.setBackground(new Color(204, 204, 255));
		arabalarLabel.setBounds(101, 276, 173, 86);
		c.add(arabalarLabel);
		arabalarLabel.setToolTipText("Arabalari gormek icin tiklayin");
		//arabalar label ayarlamaları
		
		faturaLabel = new JLabel("Faturalandir");
		faturaLabel.setIcon(new ImageIcon(Test.class.getResource("/tax.png")));
		faturaLabel.setOpaque(true);
		faturaLabel.setHorizontalAlignment(SwingConstants.CENTER);//oluşturulan label çerçevesinde yazının ortada çıkması için.
		faturaLabel.setBackground(new Color(204, 204, 255));
		faturaLabel.setBounds(519, 146, 157, 86);
		c.add(faturaLabel);
		faturaLabel.setToolTipText("Fatura cikarmak icin tiklayin");
		//fatura label ayarlamaları
		
		musteriLabel = new JLabel("Musteriler");
		musteriLabel.setIcon(new ImageIcon(Test.class.getResource("/customer.png")));
		musteriLabel.setOpaque(true);
		musteriLabel.setHorizontalAlignment(SwingConstants.CENTER);//oluşturulan label çerçevesinde yazının ortada çıkması için.
		musteriLabel.setBackground(new Color(204, 204, 255));
		musteriLabel.setBounds(519, 276, 157, 86);
		c.add(musteriLabel);
		musteriLabel.setToolTipText("Musterileri gormek icin tiklayin");
		//musteri label ayarlamaları
		
		
		arabalarLabel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setColor(arabalarLabel);//label renkleri ayarlamayı kolaylaştırmak için yazılmış fonksiyonlarım
				
			}
			public void mouseExited(MouseEvent e) {
				resetColor(arabalarLabel);//label renkleri ayarlamayı kolaylaştırmak için yazılmış fonksiyonlarım
			}
			public void mouseClicked(MouseEvent e) {
				Arabalar a = new Arabalar();//Arabalar classının açılıp, Test classının kapanması için , Arabalar classından bir obje yaratılıyor.
				a.setVisible(true);
				dispose();//setVisible(false) yerine dispose() methodu kullanılmıştır. 
			}
		});
		faturaLabel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setColor(faturaLabel);//label renkleri ayarlamayı kolaylaştırmak için yazılmış fonksiyonlarım
				
			}
			public void mouseExited(MouseEvent e) {
				resetColor(faturaLabel);//label renkleri ayarlamayı kolaylaştırmak için yazılmış fonksiyonlarım
			}
		
			public void mouseClicked(MouseEvent e) {
				Fatura f = new Fatura();//Fatura classının açılıp, Test classının kapanması için , Fatura classından bir obje yaratılıyor.

				f.setVisible(true);
				dispose();//setVisible(false) yerine dispose() methodu kullanılmıştır. 
			}
		});
		musteriLabel.addMouseListener(new MouseAdapter() {
		
			public void mouseEntered(MouseEvent e) {
				setColor(musteriLabel);
				//label renkleri ayarlamayı kolaylaştırmak için yazılmış fonksiyonlarım
			}
			
			public void mouseExited(MouseEvent e) {
				resetColor(musteriLabel);//label renkleri ayarlamayı kolaylaştırmak için yazılmış fonksiyonlarım
			}
			
			public void mouseClicked(MouseEvent e) {
				
				Musteri m = new Musteri();//Musteri classının açılıp, Test classının kapanması için , Musteri classından bir obje yaratılıyor.
				m.setVisible(true);
				dispose();//setVisible(false) yerine dispose() methodu kullanılmıştır. 
			}
		});
		
		File f = new File("Musteriler.txt"); //Dosya oluşturma
		
		try 
		   {
			   if(!f.exists())
			   { // eger dosya yoksa
		       f.createNewFile(); // dosyayi olusturur.
			   }
			  
		   }
		  catch (IOException ep) 
		   { 	// hata yakalama
			  	ep.printStackTrace();
		   }
		
		File f2 = new File("Rezervayonlar.txt");//Dosya oluşturma
		
		try 
		   {
			   if(!f2.exists())
			   { // eger dosya yoksa
		       f.createNewFile(); // dosyayi olusturur.
			   }
			  
		   }
		  catch (IOException ep) 
		   { 	// hata yakalama
			  	ep.printStackTrace();
		   }
		
	}
	
	
	//Label'lerin üzerine gelindiğinde arkasının renklenmesi için yazılan iki ayrı method.
	public void setColor(JLabel p) 
	{
	p.setBackground(new Color(255,204,255));
	}
	public void resetColor(JLabel p)
	{
	p.setBackground(new Color(204,204,255));
	}
	
}