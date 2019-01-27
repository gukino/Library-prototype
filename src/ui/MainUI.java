package ui;

import pojo.User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 主菜单
 * @author Administrator
 *
 */
public class MainUI extends JFrame{

    /**
     * 将窗体中组件定义为该窗体类属性
     */
    //菜单栏
    private JMenuBar bar = new JMenuBar();
    //菜单
    private JMenu userManagementMenu = new JMenu("读者管理");
    private JMenu bookManagementMenu = new JMenu("图书管理");
  //  private JMenu borrowManagementMenu = new JMenu("图书借还");
    private JMenu booksMenu = new JMenu("图书借还");
    private JMenu userMenu = new JMenu("个人信息");
    //菜单项
    private JMenuItem userTypeMenuItem = new JMenuItem("读者类型管理");
    private JMenuItem userInfoMenuItem = new JMenuItem("读者信息管理");
    private JMenuItem bookTypeMenuItem = new JMenuItem("图书类型管理");
    private JMenuItem bookInfoMenuItem = new JMenuItem("图书信息管理");
    private JMenuItem booksMenuItem = new JMenuItem("图书档案查询");
    private JMenu borrowConditionMenu = new JMenu("借阅情况查询");
    private JMenuItem borrowedMenuItem = new JMenuItem("已借查询");
    private JMenuItem overtimeMenuItem = new JMenuItem("逾期查询");

    private JMenuItem userManagementMenuItem = new JMenuItem("个人信息");
    private JMenuItem passwordManagementMenuItem = new JMenuItem("修改密码");
    private JMenuItem exitMenuItem = new JMenuItem("退出系统");
    private JLabel jl1 = new JLabel("欢迎使用图书管理系统");
    private JLabel jl2 = new JLabel();
    private JPanel jp = new JPanel();
    //当前登录的用户
    private User user;

    public MainUI(User user){
        this.user = user;
        this.setTitle("图书馆管理系统");
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponent();
        addListener();

        this.setVisible(true);
    }
    public void addComponent(){
        //权限判断
        if(user.getTypeId() == 1){
            adminRole();
        } else{
            userRole();
        }
        //将菜单栏加入到窗体中
        this.setJMenuBar(bar);

        jp.setLayout(new GridLayout(1,2));
        jp.add(jl1);
        jp.add(jl2);
        jl2.setText(user.getTypeName() + ":" + user.getUsername());
        this.add(jp, BorderLayout.SOUTH);
    }
    /**
     * 在组件中加入事件
     */
    public void addListener(){
        userInfoMenuItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new UserInfoUI();
            }
        });
        userTypeMenuItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new UserTypeUI();
            }
        });
        bookInfoMenuItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new BookInfoUI();
            }
        });
        bookTypeMenuItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        booksMenuItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new BooksUI(user);
            }
        });
        booksMenuItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        borrowedMenuItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        overtimeMenuItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        userManagementMenuItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new UserUI(user);
            }
        });

        passwordManagementMenuItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new ChangePwdUI(user);
            }
        });
        exitMenuItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "您是否要退出系统呢?", "退出提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(n == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
    }
    public void adminRole(){
        //先将菜单项加入到相应的菜单
        userManagementMenu.add(userInfoMenuItem);
        userManagementMenu.add(userTypeMenuItem);
        bookManagementMenu.add(bookInfoMenuItem);
        bookManagementMenu.add(bookTypeMenuItem);
        borrowConditionMenu.add(borrowedMenuItem);
        borrowConditionMenu.add(overtimeMenuItem);


        //再将所有的菜单加入到菜单栏中
        bar.add(userManagementMenu);
        bar.add(bookManagementMenu);
        bar.add(borrowConditionMenu);
    }

    public void userRole(){
        booksMenu.add(booksMenuItem);
        borrowConditionMenu.add(borrowedMenuItem);
        borrowConditionMenu.add(overtimeMenuItem);
        userMenu.add(userManagementMenuItem);
        userMenu.add(passwordManagementMenuItem);
        userMenu.add(exitMenuItem);

        bar.add(booksMenu);
        bar.add(borrowConditionMenu);
        bar.add(userMenu);
    }

}
