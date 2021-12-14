package frontend;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import contract.MusteriContract;
import dao.MusteriDao;
import frontend.contract.MusteriContract;
import frontend.contract.SehirlerContract;
import frontend.dao.MusteriDao;
import frontend.dao.SehirlerDao;
import interfaces.FEInterface;

public class MusteriEkle extends JDialog implements FEInterface {

    public MusteriEkle() {
        initPencere();
    }

    @Override
    public void initPencere() {

        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Müşteri Ekle"));
        add(panel);
        setModalityType(DEFAULT_MODALITY_TYPE);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel fieldJPanel = new JPanel(new GridLayout(4,2));
        JPanel butonJPanel = new JPanel(new GridLayout(1,2));
        JLabel adisoadiJLabel = new JLabel("Ad Soyad : ",JLabel.RIGHT);
        fieldJPanel.add(adisoadiJLabel);
        JTextField adisoyadiField = new JTextField(15);
        fieldJPanel.add(adisoyadiField);
        JLabel telefonLabel = new JLabel("Telefon Numarası : ",JLabel.RIGHT);
        fieldJPanel.add(telefonLabel);
        JTextField teleField = new JTextField(15);
        fieldJPanel.add(teleField);
        JLabel adresLabel = new JLabel("Adres : ");
        fieldJPanel.add(adresLabel);
        JTextArea adresArea = new JTextArea(6,1);
        JScrollPane pane = new JScrollPane(adresArea);
        pane.setBorder(BorderFactory.createTitledBorder("Adres Bilgisi"));
        JButton kaydetButton = new JButton("Kaydet");
        butonJPanel.add(kaydetButton);
        JButton iptalButton = new JButton("İptal");
        butonJPanel.add(iptalButton);

        panel.add(fieldJPanel,BorderLayout.NORTH);
        panel.add(pane,BorderLayout.CENTER);
        panel.add(butonJPanel,BorderLayout.SOUTH);

        kaydetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                MusteriContract musteriContract = new MusteriContract();

                musteriContract.setAdiSoyadi(adisoadiJLabel.getText());
                musteriContract.setTelefon(teleField.getText());
                musteriContract.setAdres(adresArea.getText());
                musteriContract.setSehirId(castContract.getIsim());


                new MusteriDao().Insert(musteriContract);
                JOptionPane.showMessageDialog(null, musteriContract.getAdiSoyadi()+" Adlı Musteri Başarıyla Kaydedilmiştir.");
            }
        });

        return panel;
    }

    @Override
    public JMenuBar initBar() {

        return null;
    }

    @Override
    public JTabbedPane initTabs() {

        return null;
    }

}
