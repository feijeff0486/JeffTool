package com.jeff.tool.adbviewer;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class ADBEntry {
    /**
     * 界面对象
     */
    private JFrame mSurface;
    private static JFrame mainFrame;
    private static Container optionView;
    private static Container otherView;

    private ADBEntry(JFrame mainFrame) {
        mSurface = mainFrame;
    }

    public void showDialog(String message, String title) {
        JOptionPane.showMessageDialog(mSurface, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        mainFrame = new JFrame();
        ADBEntry mainEntry = new ADBEntry(mainFrame);

        mainFrame.setTitle("ADB小工具");
        mainFrame.setSize(200, 500);
        mainFrame.setLocationRelativeTo(null);
        // 创建选项卡面板
        JTabbedPane tabPane = new JTabbedPane();
        optionView = new OptionContainer(mainEntry);
//        otherView = new OtherContainer(mainEntry);
        tabPane.add(optionView, "遥控器");
//        tabPane.add(otherView, "更多操作");
        mainFrame.setContentPane(tabPane);
        //显示窗口
        mainFrame.setVisible(true);
    }
}
