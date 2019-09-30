package ReadWriteFile;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class ReadFile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadFile frame = new ReadFile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReadFile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea taContent = new JTextArea();
		taContent.setBounds(56, 11, 450, 309);
		contentPane.add(taContent);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc;
				FileReader fr=null;
				BufferedReader br=null;
				String s;
				try {
					fc = new JFileChooser();
					int openDialog = fc.showOpenDialog(null);
					if(openDialog==JFileChooser.APPROVE_OPTION) {
						String path = fc.getSelectedFile().getAbsolutePath();
						fr = new FileReader(path);
						br = new BufferedReader(fr);
						while((s=br.readLine())!=null) {
							taContent.append(s+"\n");
						}
					}
					br.close();
					fr.close();
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("Error"+e2.getMessage());
				}
			}
		});
		btnOpen.setBounds(91, 353, 89, 23);
		contentPane.add(btnOpen);
		
		JButton btnSaveAs = new JButton("Save As");
		btnSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc;
				FileWriter fw =null;
				BufferedWriter bw=null;
				try {
					fc = new JFileChooser();
					int openDialog = fc.showOpenDialog(null);
					if(openDialog==JFileChooser.APPROVE_OPTION) {
						String path = fc.getSelectedFile().getAbsolutePath();
						fw = new FileWriter(path);
						bw = new BufferedWriter(fw);
						bw.write(taContent.getText());
						bw.flush();						
					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("Error"+e2.getMessage());
				}
			}
		});
		btnSaveAs.setBounds(201, 353, 89, 23);
		contentPane.add(btnSaveAs);
	}
}
