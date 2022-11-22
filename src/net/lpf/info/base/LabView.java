package net.lpf.info.base;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LabView extends JFrame {
    
    private final JButton encode = new JButton("Encode"),
                          decode = new JButton("Decode");
    private final JTextField passEncode = new JTextField(),
                             passDecode = new JTextField();;
    private final JLabel pEncode = new JLabel("Password:"),
                         mEncode = new JLabel("Open text:"),
                         pDecode = new JLabel("Password:"),
                         mDecode = new JLabel("Encrypted text:");
    private final JTextArea openTextEncode = new JTextArea(),
                          encryptionEncode = new JTextArea(),
                            openTextDecode = new JTextArea(),
                          encryptionDecode = new JTextArea();
    private final JComboBox algorhythm = new JComboBox();
    
    public LabView(){
        super("Overencrypting-Machine-9000-1.0.3");
        initWindow();
    }
    
    private void initWindow() {
        JScrollPane openTextScrolle = new JScrollPane(
                openTextEncode, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        ),encryptionScrolle = new JScrollPane(
                encryptionEncode, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        ),openTextScrolld = new JScrollPane(
                openTextDecode, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        ),encryptionScrolld = new JScrollPane(
                encryptionDecode, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );
        encryptionEncode.setEditable(false);
        openTextDecode.setEditable(false);
        algorhythm.setEditable(false);
        JPanel layer0 = new JPanel();
        layer0.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        BorderLayout frame = new BorderLayout();
        frame.setHgap(10);
        frame.setVgap(10);
        layer0.setLayout(frame);
        JTabbedPane layer1 = new JTabbedPane();
        JPanel layer2 = new JPanel();
        GroupLayout layout0 = new GroupLayout(layer2);
        layer2.setLayout(layout0);
        layout0.setAutoCreateGaps(true);
        layout0.setAutoCreateContainerGaps(true);
        layout0.setHorizontalGroup(layout0.createSequentialGroup()
                .addGroup(layout0.createParallelGroup()
                        .addComponent(mEncode)
                        .addComponent(pEncode)
                )
                .addGroup(layout0.createParallelGroup()
                        .addComponent(openTextScrolle)
                        .addGroup(layout0.createSequentialGroup()
                                .addComponent(passEncode)
                                .addComponent(encode)
                        )
                        .addComponent(encryptionScrolle)
                )
        );
        layout0.setVerticalGroup(layout0.createSequentialGroup()
                .addGroup(layout0.createParallelGroup(Alignment.CENTER)
                        .addComponent(mEncode)
                        .addComponent(openTextScrolle)
                ).addGroup(layout0.createParallelGroup(Alignment.CENTER)
                        .addComponent(pEncode)
                        .addComponent(passEncode)
                        .addComponent(encode)
                )
                .addComponent(encryptionScrolle)
        );
        layout0.linkSize(SwingConstants.VERTICAL, encode, passEncode);
        JPanel layer3 = new JPanel();
        GroupLayout layout1 = new GroupLayout(layer3);
        layer3.setLayout(layout1);
        layout1.setAutoCreateGaps(true);
        layout1.setAutoCreateContainerGaps(true);
        layout1.setHorizontalGroup(layout1.createSequentialGroup()
                .addGroup(layout1.createParallelGroup()
                        .addComponent(mDecode)
                        .addComponent(pDecode)
                )
                .addGroup(layout1.createParallelGroup()
                        .addComponent(encryptionScrolld)
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(passDecode)
                                .addComponent(decode)
                        )
                        .addComponent(openTextScrolld)
                )
        );
        layout1.setVerticalGroup(layout1.createSequentialGroup()
                .addGroup(layout1.createParallelGroup(Alignment.CENTER)
                        .addComponent(mDecode)
                        .addComponent(encryptionScrolld)
                ).addGroup(layout1.createParallelGroup(Alignment.CENTER)
                        .addComponent(pDecode)
                        .addComponent(passDecode)
                        .addComponent(decode)
                )
                .addComponent(openTextScrolld)
        );
        layout1.linkSize(SwingConstants.VERTICAL, decode, passDecode);
        layer1.addTab("Encoding", layer2);
        layer1.addTab("Decoding", layer3);
        layer0.add(algorhythm, BorderLayout.NORTH);
        layer0.add(layer1, BorderLayout.CENTER);
        add(layer0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    JButton getEncodeButton() {
        return encode;
    }
    JTextArea getInputEncode() {
        return openTextEncode;
    }
    JTextField getPassEncode() {
        return passEncode;
    }
    JTextArea getOutputEncode() {
        return encryptionEncode;
    }
    JButton getDecodeButton() {
        return this.decode;
    }
    JTextArea getOutputDecode() {
        return this.openTextDecode;
    }
    JTextArea getInputDecode() {
        return this.encryptionDecode;
    }
    JTextField getPassDecode() {
        return this.passDecode;
    }
    JComboBox getAlgSelection(){
        return this.algorhythm;
    }
}
