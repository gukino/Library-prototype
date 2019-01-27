package ui;

import pojo.User.User;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ChangePwdUI extends JFrame{

    private JLabel jl1 = new JLabel("原始密码");
    private JLabel jl2 = new JLabel("新  密  码");
    private JLabel jl3 = new JLabel("确认密码");
    private JPasswordField jt1 = new JPasswordField(10);
    private JPasswordField jt2 = new JPasswordField(10);
    private JPasswordField jt3 = new JPasswordField(10);
    private JButton ok = new JButton("确定");
    private JButton cancel = new JButton("取消");
    private JPanel jp1 = new JPanel();
    private JPanel jp2 = new JPanel();
    private JPanel jp3 = new JPanel();
    private JPanel jp4 = new JPanel();
    private User user;

    public ChangePwdUI(User user){
        this.user = user;
        this.setTitle("修改密码");
        this.setSize(280, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addComponent();
        addEvent();

        this.setVisible(true);
    }
    public void addComponent(){
        this.setLayout(new GridLayout(4, 1));
        jp1.add(jl1);
        jp1.add(jt1);
        jp2.add(jl2);
        jp2.add(jt2);
        jp3.add(jl3);
        jp3.add(jt3);
        jp4.add(ok);
        jp4.add(cancel);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
    }
    public void addEvent(){
        ok.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //1.获取录入的数据，并进行校验(校验为选作内容)
                String oldpwd = new String(jt1.getPassword());
                String pwd = new String(jt2.getPassword());
                String repwd = new String(jt3.getPassword());
                /**
                 * 非空校验
                 */
                if(oldpwd.equals("")){
                    JOptionPane.showMessageDialog(null, "原始密码不能为空！", "警告提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(!oldpwd.equals(user.getPassword())){
                    JOptionPane.showMessageDialog(null, "原始密码有误！", "警告提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(pwd.equals("")){
                    JOptionPane.showMessageDialog(null, "新密码不能为空！", "警告提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(repwd.equals("")){
                    JOptionPane.showMessageDialog(null, "确认密码不能为空！", "警告提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(!pwd.equals(repwd)){
                    JOptionPane.showMessageDialog(null, "新密码与确认密码不一致！", "警告提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                //todo 连接数据库进行真实的修改操作
                //暂时默认修改成功
                user.update(user.getUsername(), pwd);
                JOptionPane.showMessageDialog(null, "修改成功,已通知管理员", "信息提示", JOptionPane.INFORMATION_MESSAGE);
                //关闭添加窗口
                dispose();
            }
        });
        cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jt1.setText("");
                jt2.setText("");
                jt3.setText("");
            }
        });
    }
}
