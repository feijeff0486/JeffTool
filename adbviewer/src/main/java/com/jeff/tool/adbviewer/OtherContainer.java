package com.jeff.tool.adbviewer;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

/**
 * @author Jeff
 * @describe
 * @date 2019/10/23.
 */
public class OtherContainer extends Container implements ActionListener {

    private JButton mChooseFileBtn = new JButton("选择文件");
    private JButton mOutputBtn = new JButton("导出密钥");
    private JButton mRandomBtn = new JButton("随机生成密钥");
    private JButton mImportBtn = new JButton("导入密钥");
    private JButton mEncryptFileBtn = new JButton("加密文件");
    /**
     * 文件选择路径
     */
    private JTextField mFilePath = new JTextField();
    /**
     * 密钥展示框
     */
    private JTextArea mKeyText = new JTextArea();

    private ADBEntry mMainEntry;

    private JFileChooser mJFileChooser;

    public OtherContainer(ADBEntry frame) {
        mJFileChooser = new JFileChooser();
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File home = fsv.getHomeDirectory();
        mJFileChooser.setCurrentDirectory(home);
        // 设定只能选择到文件
        mJFileChooser.setFileSelectionMode(0);

        mMainEntry = frame;
        mChooseFileBtn.addActionListener(this);
        mImportBtn.addActionListener(this);
        mRandomBtn.addActionListener(this);
        mEncryptFileBtn.addActionListener(this);
        mOutputBtn.addActionListener(this);

        JLabel jl1 = new JLabel("加密文件路径");
        JLabel jl2 = new JLabel("Base64文件密钥");

        mKeyText.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(mKeyText);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        //xz坐标，y坐标，宽度，高度
        jl1.setBounds(30, 30, 80, 20);
        mFilePath.setBounds(110, 30, 200, 20);
        mChooseFileBtn.setBounds(320, 30, 90, 20);
        jl2.setBounds(30, 60, 120, 20);
        scrollPane.setBounds(30, 80, 370, 130);

        mRandomBtn.setBounds(25, 232, 120, 20);
        mImportBtn.setBounds(140, 232, 90, 20);
        mOutputBtn.setBounds(230, 232, 90, 20);
        mEncryptFileBtn.setBounds(310, 232, 90, 20);


        add(mFilePath);
        add(mChooseFileBtn);
        add(jl2);
        add(jl1);
        add(scrollPane);
        add(mEncryptFileBtn);
        add(mOutputBtn);
        add(mImportBtn);
        add(mRandomBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(mChooseFileBtn)) {
            mJFileChooser.setDialogTitle("选择要加密的文件");
            // 此句是打开文件选择器界面的触发语句
            int state = mJFileChooser.showOpenDialog(null);
            // 撤销则返回
            if (state == 1) {
                return;
            } else {
                // f为选择到的文件
                File f = mJFileChooser.getSelectedFile();
                mFilePath.setText(f.getAbsolutePath());
            }
        } else if (e.getSource().equals(mEncryptFileBtn)) {
        } else if (e.getSource().equals(mOutputBtn)) {
        } else if (e.getSource().equals(mRandomBtn)) {
        } else if (e.getSource().equals(mImportBtn)) {
        }
    }

}
