package com.jeff.tool.adbviewer;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

/**
 * @author Jeff
 * @describe
 * @date 2019/10/23.
 */
public class OptionContainer extends Container implements ActionListener {

    private JButton mBtnUp = new JButton("UP");
    private JButton mBtnDown = new JButton("DOWN");
    private JButton mBtnLeft = new JButton("LEFT");
    private JButton mBtnRight = new JButton("RIGHT");
    private JButton mBtnOk = new JButton("OK");
    private JButton mBtnBack = new JButton("BACK");
    private JButton mBtnHome = new JButton("HOME");
    private JButton mBtnPower = new JButton("POWER");
    private JButton mBtnMenu = new JButton("MENU");
    private JButton mBtnVolAdd = new JButton("VOL+");
    private JButton mBtnVolLess = new JButton("VOL-");
    private JButton mBtnVolMute = new JButton("Mute");

//    private JButton mChooseFileBtn = new JButton("选择文件");
//    private JButton mOutputBtn = new JButton("导出密钥");
//    private JButton mRandomBtn = new JButton("随机生成密钥");
//    private JButton mImportBtn = new JButton("导入密钥");
//    private JButton mEncryptFileBtn = new JButton("加密文件");
    /**
     * 文件选择路径
     */
//    private JTextField mFilePath = new JTextField();
    /**
     * 密钥展示框
     */
//    private JTextArea mKeyText = new JTextArea();

    private ADBEntry mMainEntry;

    public OptionContainer(ADBEntry frame) {
        mMainEntry = frame;
        mBtnUp.addActionListener(this);
        mBtnDown.addActionListener(this);
        mBtnLeft.addActionListener(this);
        mBtnRight.addActionListener(this);
        mBtnOk.addActionListener(this);
        mBtnBack.addActionListener(this);
        mBtnHome.addActionListener(this);
        mBtnPower.addActionListener(this);
        mBtnMenu.addActionListener(this);
        mBtnVolAdd.addActionListener(this);
        mBtnVolLess.addActionListener(this);
        mBtnVolMute.addActionListener(this);

//        JLabel jl1 = new JLabel("加密文件路径");
//        JLabel jl2 = new JLabel("Base64文件密钥");

//        mKeyText.setLineWrap(true);
//
//        JScrollPane scrollPane = new JScrollPane(mKeyText);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//
//        //xz坐标，y坐标，宽度，高度
//        jl1.setBounds(30, 30, 80, 20);
//        mFilePath.setBounds(110, 30, 200, 20);
//        mChooseFileBtn.setBounds(320, 30, 90, 20);
//        jl2.setBounds(30, 60, 120, 20);
//        scrollPane.setBounds(30, 80, 370, 130);
//
//        mRandomBtn.setBounds(25, 232, 120, 20);
//        mImportBtn.setBounds(140, 232, 90, 20);
//        mOutputBtn.setBounds(230, 232, 90, 20);
//        mEncryptFileBtn.setBounds(310, 232, 90, 20);

        mBtnPower.setBounds(105, 25, 60, 20);

        mBtnUp.setBounds(60, 70, 60, 20);
        mBtnDown.setBounds(60, 160, 60, 20);
        mBtnLeft.setBounds(15, 115, 50, 20);
        mBtnOk.setBounds(65, 115, 50, 20);
        mBtnRight.setBounds(115, 115, 50, 20);

        mBtnBack.setBounds(15, 220, 50, 20);
        mBtnHome.setBounds(65, 220, 50, 20);
        mBtnMenu.setBounds(115, 220, 50, 20);

        mBtnVolLess.setBounds(15, 265, 50, 20);
        mBtnVolMute.setBounds(65, 265, 50, 20);
        mBtnVolAdd.setBounds(115, 265, 50, 20);

        add(mBtnUp);
        add(mBtnDown);
        add(mBtnLeft);
        add(mBtnRight);
        add(mBtnOk);
        add(mBtnBack);
        add(mBtnHome);
        add(mBtnMenu);
        add(mBtnPower);
        add(mBtnVolAdd);
        add(mBtnVolLess);
        add(mBtnVolMute);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(mBtnMenu)) {
            inputKeyevent(1);
        } else if (e.getSource().equals(mBtnHome)) {
            inputKeyevent(3);
        } else if (e.getSource().equals(mBtnBack)) {
            inputKeyevent(4);
        } else if (e.getSource().equals(mBtnUp)) {
            inputKeyevent(19);
        } else if (e.getSource().equals(mBtnDown)) {
            inputKeyevent(20);
        } else if (e.getSource().equals(mBtnLeft)) {
            inputKeyevent(21);
        } else if (e.getSource().equals(mBtnRight)) {
            inputKeyevent(22);
        } else if (e.getSource().equals(mBtnOk)) {
            inputKeyevent(23);
        } else if (e.getSource().equals(mBtnVolAdd)) {
            inputKeyevent(24);
        } else if (e.getSource().equals(mBtnVolLess)) {
            inputKeyevent(25);
        } else if (e.getSource().equals(mBtnPower)) {
            inputKeyevent(26);
        }else if (e.getSource().equals(mBtnVolMute)){
            inputKeyevent(164);
        }
    }
    private void inputKeyevent(int keyCode){
        String cmd = "adb shell input keyevent " + keyCode;
        runAdbCmd(cmd);
    }

    private void runAdbCmd(String cmd) {
        try {
            Runtime.getRuntime().exec(cmd);
            //创建IO管道，准备输出命令执行后的显示内容
            System.out.println("exec: " + cmd);
        } catch (IOException e) {
            mMainEntry.showDialog(e.getMessage(),"ERROR");
            e.printStackTrace();
        }
    }

}
