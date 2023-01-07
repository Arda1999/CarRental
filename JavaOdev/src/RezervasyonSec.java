//---------------------------------------------------------------------------------------------------------------------
//RezervasyonSec.java										Author: Zeynep İdil Gül ID: 21894810
//																z_idilgul99@hotmail.com
//
//
//We use this class during invoicing of a car rental for choose a reservation.
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


public class RezervasyonSec extends JFrame {

	//değişken tanımlamaları
	private JPanel contentPane;
	private JTable rezTable;
	private int fiyat;
	private String plaka,tc,isim,soyisim,tarih;
	private JLabel geriLabel;
	private JScrollPane scrollPane_1 ;
	private String[] columnsName = {"Tarih","TC No","Soyisim","Isim","Plaka","Gun Sayisi","Kiralama Fiyatı"};
	//değişken tanımlamaları
	
	
	

	public RezervasyonSec() {
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x e basıldığında program çalışmayı durdursun
		setBounds(100, 100, 1094, 596);//çerçeve boyutları
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);//arkaplan beyaz 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); 
	    setResizable(false);//boyut değiştirilemesin

	    //geri label oluşturulması ve mouseListener ile labelin takibi
		geriLabel = new JLabel("Geri");
		geriLabel.setBackground(Color.WHITE);
		geriLabel.setOpaque(true);
		geriLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				Fatura f = new Fatura();
				f.setVisible(true);
				dispose();
			}
			public void mouseEntered(MouseEvent e) {
				setColor(geriLabel);
			}
			public void mouseExited(MouseEvent e) {
				resetColor(geriLabel);
			}
		});
		geriLabel.setIcon(new ImageIcon(RezervasyonSec.class.getResource("/return.png")));
		geriLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geriLabel.setBounds(70, 469, 117, 66);
		contentPane.add(geriLabel);
		
		//scroll pane ayarlamaları
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(24, 20, 1064, 412);
		contentPane.add(scrollPane_1);
		
		//rezTable adi ile rezervasyon tablosu oluşturma ve bunların ayarlamaları
		rezTable = new JTable();
		scrollPane_1.setViewportView(rezTable);
		rezTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
	
		DefaultTableModel model = (DefaultTableModel)rezTable.getModel();
		String filePath = "Rezervasyonlar.txt";
		File file = new File(filePath);
		model.setColumnIdentifiers(columnsName);// sütun isimlerini ayarla
		        
		//tabloya / ile ayırarak yazma
		try {
            BufferedReader br = new BufferedReader(new FileReader(file));
          
            Object[] tableLines = br.lines().toArray();
            
            
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split("/");
                model.addRow(dataRow);
            }
            
        } catch (Exception ex) {
        System.out.println("HATA");
        }
		
		
		        rezTable.addMouseListener(new MouseAdapter() {
		        	//bir satıra tıklandığında oradaki bilgileri alma
					public void mouseClicked(MouseEvent a) {
						int row = rezTable.getSelectedRow();
						tarih =(rezTable.getModel().getValueAt(row, 0).toString());
						plaka =(rezTable.getModel().getValueAt(row, 4).toString());
						fiyat =Integer.parseInt((rezTable.getModel().getValueAt(row, 6).toString()));
						isim =(rezTable.getModel().getValueAt(row, 3).toString());
						soyisim =(rezTable.getModel().getValueAt(row, 2).toString());
						tc =(rezTable.getModel().getValueAt(row, 1).toString());
					}
				});
		      //onaylama butonu oluşturulması ve parametreli fatura nesnesi oluşturulması
		        //onayla butonunun action listener ile takibi
		    	JButton onaylaButton = new JButton("ONAYLA");
		    	onaylaButton.setBounds(867, 491, 97, 25);
				contentPane.add(onaylaButton);
				onaylaButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent a) {
						Fatura f = new Fatura(tarih,tc,soyisim,isim,plaka,fiyat);
						f.setVisible(true);
						dispose();
					}
				});
}
	
	//ilk constructor fatura classından çağırıldığında oraya geri dönmesi için yapıldı
	//bu constructor int bir parametreyle çağırılıyor ve bu sayede önceki rezervasyonu görüntüle tuşuna basıldığında aktif oluyor.
public RezervasyonSec(int a) {
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1094, 596);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); 
	    setResizable(false);

		geriLabel = new JLabel("KAPAT");
		geriLabel.setBackground(Color.WHITE);
		geriLabel.setOpaque(true);
		geriLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				dispose();
			}
			public void mouseEntered(MouseEvent e) {
				setColor(geriLabel);
			}
			public void mouseExited(MouseEvent e) {
				resetColor(geriLabel);
			}
		});
		geriLabel.setIcon(new ImageIcon(RezervasyonSec.class.getResource("/x-button.png")));
		geriLabel.setHorizontalAlignment(SwingConstants.CENTER);
		geriLabel.setBounds(70, 469, 117, 66);
		contentPane.add(geriLabel);
		
		scrollPane_1 = new JScrollPane();
		
		scrollPane_1.setBounds(24, 20, 1064, 412);
		contentPane.add(scrollPane_1);
		
		rezTable = new JTable();
		scrollPane_1.setViewportView(rezTable);
		rezTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		DefaultTableModel model = (DefaultTableModel)rezTable.getModel();
		String filePath = "Rezervasyonlar.txt";
		File file = new File(filePath);
		model.setColumnIdentifiers(columnsName);
		        
		try {
            BufferedReader br = new BufferedReader(new FileReader(file));
          
            Object[] tableLines = br.lines().toArray();
            
            
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split("/");
                model.addRow(dataRow);
            }
            
        } catch (Exception ex) {
        System.out.println("HATA");
        }
		
		
		        rezTable.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent a) {
						int row = rezTable.getSelectedRow();
						plaka =(rezTable.getModel().getValueAt(row, 4).toString());
						fiyat =Integer.parseInt((rezTable.getModel().getValueAt(row, 6).toString()));
						isim =(rezTable.getModel().getValueAt(row, 3).toString());
						soyisim =(rezTable.getModel().getValueAt(row, 2).toString());
						tc =(rezTable.getModel().getValueAt(row, 1).toString());
					}
				});
		        
}
//label renkleri ayarlamak için yazılmış fonksiyonlar
	public void setColor(JLabel p)
	{
	p.setBackground(new Color(255,204,255));
	}
	public void resetColor(JLabel p)
	{
	p.setBackground(new Color(255,255,255));
	}
}