package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import service.CredentialSave;


@SuppressWarnings("serial")
public class ImpostazioniAltroGUI  extends JFrame implements ActionListener {

    private JTextField oggetto = new JTextField();
    private JLabel oggettoLabel = new JLabel();
    private JButton submit = new JButton();
    private JLabel titolo = new JLabel();;
    private JFrame frame = new JFrame();
	
	
	public ImpostazioniAltroGUI() {
		
		
		// carica oggetto
		oggetto.setText(CredentialSave.getOggetto());
				
		// pannello
    	JPanel panel = new JPanel();
    	panel.setBackground(new Color(255, 255, 255));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel.setLayout(new GridLayout(0, 1));
        
        //label password
        oggettoLabel.setFont(new Font("Dialog", 1, 18)); 
        oggettoLabel.setText("Iniziale Oggetto:");
        panel.add(oggettoLabel);
		

        // bottone salva
        submit.setFont(new Font("Dialog", 1, 18)); 
        submit.setText("Salva");
        submit.setForeground(new Color(255,255,255));
        submit.setBackground(new Color(22,158,255));
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                salvaActionPerformed(evt);
            }
        });
        panel.add(submit);
        

        
        // label titolo
        titolo.setFont(new Font("Dialog", 1, 24)); 
        titolo.setHorizontalAlignment(SwingConstants.CENTER);
        titolo.setText("IMPOSTAZIONI");
        titolo.setForeground(new Color(22,158,255));
        panel.add(titolo);
        
        // layout
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(oggettoLabel)
                        .addGap(18, 18, 18)
                        .addComponent(oggetto)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titolo, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(titolo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(oggettoLabel)
                    .addComponent(oggetto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submit)
                .addGap(14, 14, 14))
        );
        panel.setLayout(layout);
		
        // set icona
        ImageIcon img = new ImageIcon();
        try {
        	img = new ImageIcon(getClass().getResource("/resources/logo.png")); 
            
        }catch(NullPointerException e) {
        	img = new ImageIcon(".\\src\\main\\resources\\logo.png"); 
        }
        frame.setIconImage(img.getImage());
           
        
        // set up frame
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Buste Paga - Impostazioni");
        frame.pack();
        frame.setVisible(true);
        
	}
	
	
	
	// bottone salva premuto
	protected void salvaActionPerformed(ActionEvent evt) {
		Properties p = new Properties();
		
		
		try {
			p.setProperty("oggetto", oggetto.getText());
			
			p.store(new FileWriter(System.getenv("APPDATA") + "/bp3em.properties"), "");
			JOptionPane.showMessageDialog(null, "Impostazioni Salvate");
			CredentialSave.setOther();
			frame.dispose();
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Errore nel salvare le impostazioni.");
		}
	}





	// azione generale eseguita
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
