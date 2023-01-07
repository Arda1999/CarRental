//---------------------------------------------------------------------------------------------------------------------
//ArabaSec.java											Author: Zeynep İdil Gül ID: 21894810
//																z_idilgul99@hotmail.com
//
//
//We use this class to choose a car while making a reservation.
//---------------------------------------------------------------------------------------------------------------------

//------KULLANILAN KUTUPHANELER--------
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class ArabaSec extends JFrame {

	//Değişken tanımlamaları
	private JPanel contentPane;
	private JTable table;
	private JTextField ucretField,plakaField;
	private int ucret;
	private String plaka,tarih;
	private String secilenTarih;
	private JLabel geriLabel;
	private JScrollPane scrollPane_1;
	private JLabel kiralamaLabel;
	private JLabel plakaLabel;
	private JButton onaylaButton;
	//Değişken tanımlamaları
	

	public ArabaSec(String tarih) {
		
		this.tarih=tarih; //gönderilen tarihi tutmak ve geri döndürmek için
		
		setVisible(true);//cerceve gorunmesi icin
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x tuşuna basıldığında programın durması için
		setBounds(100, 100, 1094, 596);//çerçeve boyutları
		contentPane = new JPanel();//panel oluşturma
		contentPane.setBackground(Color.WHITE);//panel arka planı
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//boyutlandırma
		setContentPane(contentPane); //content pane ayarlaması
		contentPane.setLayout(null);
		setLocationRelativeTo(null); // Açılacak olan görüntünün tam ortada çıkmasını sağlayan fonksiyon
	    setResizable(false);//ekran boyutu değiştirilemez
	    
	    
	    

		geriLabel = new JLabel("Geri");//geri başlıklı label oluşturma
		geriLabel.setBackground(Color.WHITE);//label arka plan rengi beyaz
		geriLabel.setOpaque(true);//görünür olması sağlanır
		geriLabel.addMouseListener(new MouseAdapter() {//geri labelına yapılan işlemleri görebilmek için
			@Override
			public void mouseClicked(MouseEvent a) {
				Rezervasyon t = new Rezervasyon();//geri labelına basılırsa rezervasyon ekranına geri dönmek için
				t.setVisible(true);//rezervayon çerçevesi göürünür olsun
				dispose();//mevcut cerceveyi yoketmek için
			}
			public void mouseEntered(MouseEvent e) {
				setColor(geriLabel);//renk için
			}
			public void mouseExited(MouseEvent e) {
				resetColor(geriLabel);//renk için
			}
		});
		
		geriLabel.setIcon(new ImageIcon(ArabaSec.class.getResource("/return.png")));//geri labela küçük resim ekleme
		geriLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geriLabel.setBounds(12, 142, 117, 66);//geri label boyutları
		contentPane.add(geriLabel);//panele geri label ekleme
		
		scrollPane_1 = new JScrollPane();//scroll pane oluşturuldu
		
		scrollPane_1.setBounds(12, 211, 1064, 337);//boyutlar ayarlandı
		contentPane.add(scrollPane_1);//panele eklendi
		
		table = new JTable();//tablo oluşturulfu
		scrollPane_1.setViewportView(table);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
		
			}
		));
		
		kiralamaLabel = new JLabel("Kiralama ucreti");//label oluşturuldu isim verildi
		kiralamaLabel.setBounds(150, 54, 151, 16);//boyutlar ayarlandıldı
		contentPane.add(kiralamaLabel);//panele eklendi
		
		plakaLabel = new JLabel("Plaka");//label oluşturuldu isim verildi
		plakaLabel.setBounds(683, 54, 56, 16);//boyutlar ayarlandıldı
		contentPane.add(plakaLabel);//panele eklendi
		
		ucretField = new JTextField();
		ucretField.setBounds(329, 51, 116, 22);//boyutlar ayarlandıldı
		contentPane.add(ucretField);//panele eklendi
		ucretField.setColumns(10);
		
		plakaField = new JTextField();
		plakaField.setBounds(772, 51, 116, 22);//boyutlar ayarlandıldı
		contentPane.add(plakaField);//panele eklendi
		plakaField.setColumns(10);
		
	
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
	
				String filePath = "Arabalar.txt";//arabalar dosyası oluşturulması
		        File file = new File(filePath);
		        
		        
		        //----------------------Arabalar dosyasına yazma--------------------------
		        try {
		            BufferedReader br = new BufferedReader(new FileReader(file));
		            // get the first line
		            // get the columns name from the first line
		            // set columns name to the jtable model
		            String firstLine = br.readLine().trim();
		            String[] columnsName = firstLine.split(",");
		            model.setColumnIdentifiers(columnsName);
		        
		            
		            // get lines from txt file
		            Object[] tableLines = br.lines().toArray();
		            
		            // extratct data from lines
		            // set data to jtable model
		            for(int i = 0; i < tableLines.length; i++)
		            {
		                String line = tableLines[i].toString().trim();
		                String[] dataRow = line.split("/");
		                model.addRow(dataRow);
		            }
		            
		            
		        } catch (Exception ex) {
		        System.out.println("HATA HATA");
		        }
		        //--------------------------------------------------------------------------
		        
		        //table da bir rowa tıklanıldığında o rowun text fieldları doldurması için yazılan kod
		        table.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent a) {
						int row = table.getSelectedRow();
						plaka =(table.getModel().getValueAt(row, 0).toString());
						ucret =Integer.parseInt((table.getModel().getValueAt(row, 11).toString()));
						plakaField.setText(plaka);
						ucretField.setText(String.valueOf(ucret));
						
					}
				});
		        
		        //---------------------------------------------------------------------------------------
		        
		        //onayla butonu ayarlamaları ve tıklandığında yapılacaklar
		    	onaylaButton = new JButton("ONAYLA");
		    	onaylaButton.setBounds(459, 142, 97, 25);//boyutlar ayarlandıldı
				contentPane.add(onaylaButton);
				onaylaButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent a) {
						Rezervasyon r = new Rezervasyon(plaka,ucret,tarih);//parametreli const. ile rezervasyon nesnesi oluştur
						r.setVisible(true);//rezervasyon cercevesini aç
						dispose();//varolan ekranı kapat
						
					}
				});
				
       
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