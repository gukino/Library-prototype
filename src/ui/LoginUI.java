package ui;

import pojo.User.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class LoginUI extends JFrame{

    private JLabel userLabel = new JLabel("用户名称");
    private JLabel passwordLabel = new JLabel("密        码");
    private JTextField jt1 = new JTextField(10);
    private JPasswordField jt2 = new JPasswordField(10);
    private JButton loginButton = new JButton("登录");
    private JButton cancelButton = new JButton("取消");
    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2 = new JPanel();
    private JPanel jPanel3 = new JPanel();

    public LoginUI(){
        this.setTitle("用户登录");
        this.setSize(280, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponent();
        addEvent();

        this.setVisible(true);
    }
    public void addComponent(){
        this.setLayout(new GridLayout(3, 1));
        jPanel1.add(userLabel);
        jPanel1.add(jt1);
        jPanel2.add(passwordLabel);
        jPanel2.add(jt2);
        jPanel3.add(loginButton);
        jPanel3.add(cancelButton);
        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
    }
    public void addEvent(){
        loginButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                doLogin();
            }
        });
        jt1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    jt2.requestFocus();
                }
            }
        });
        jt2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    doLogin();
                }
            }
        });
        cancelButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jt1.setText("");
                jt2.setText("");
            }
        });
    }

    public void doLogin(){
        String username = jt1.getText().trim();
        String pwd = new String(jt2.getPassword());

        if(username.equals("")){
            JOptionPane.showMessageDialog(null, "用户名称不能为空！", "警告提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(pwd.equals("")){
            JOptionPane.showMessageDialog(null, "密码不能为空！", "警告提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (username.equals("admin") && pwd.equals("admin")){
            System.out.println("login success");
            User user = new Administrator("admin", "admin");
            JOptionPane.showMessageDialog(null, "欢迎，用户：" + user.getUsername(), "信息提示", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new MainUI(user);
        }

        if (username.equals("teacher") && pwd.equals("teacher")){
            User user = new Teacher(username, pwd);
            JOptionPane.showMessageDialog(null, "欢迎，用户：" + user.getUsername(), "信息提示", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new MainUI(user);
        }

        if (username.equals("graduate") && pwd.equals("graduate")){
            User user = new Graduate(username, pwd);
            JOptionPane.showMessageDialog(null, "欢迎，用户：" + user.getUsername(), "信息提示", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new MainUI(user);
        }

        if (username.equals("undergraduate") && pwd.equals("undergraduate")){
            User user = new Undergraduate(username, pwd);
            JOptionPane.showMessageDialog(null, "欢迎，用户：" + user.getUsername(), "信息提示", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new MainUI(user);
        }

    }
 /*   public void doLogin(){
        //1.获取录入的数据，并进行校验(校验为选作内容)
        String username = jt1.getText().trim();
        String pwd = new String(jt2.getPassword());

        if(username.equals("")){
            JOptionPane.showMessageDialog(null, "用户名称不能为空！", "警告提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(pwd.equals("")){
            JOptionPane.showMessageDialog(null, "密码不能为空！", "警告提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //2.通过封装好Dao，进行登陆操作
        ManagerDao dao = new ManagerDao();
        Manager manager = dao.login(username, pwd);
        if(manager!=null){
            JOptionPane.showMessageDialog(null, "欢迎，用户：" + manager.getUsername(), "信息提示", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new MainUI(manager);
        }else{
            JOptionPane.showMessageDialog(null, "登录失败，用户名或密码错误！", "错误提示", JOptionPane.ERROR_MESSAGE);
        }
    }*/
}
