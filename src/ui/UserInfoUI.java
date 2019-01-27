package ui;

import pojo.User.Graduate;
import pojo.User.Teacher;
import pojo.User.Undergraduate;
import pojo.User.User;
import utils.MyTable;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class UserInfoUI extends JFrame{

    private JLabel jl = new JLabel("读者信息", JLabel.CENTER);
    private JTable table = new MyTable();
    private JScrollPane jsp = new JScrollPane(table);
    private Vector<String> head = new Vector<String>();
    private JPanel jp = new JPanel();
    private JButton save = new JButton("新增");
    private JButton edit = new JButton("修改");
    private JButton del = new JButton("删除");

    public UserInfoUI(){
        this.setTitle("查询读者信息");
        this.setSize(860, 360);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addComponent();
        setTableData();

        this.setVisible(true);
    }
    public void addComponent(){
        jl.setFont(new Font("楷体_GB2312",Font.BOLD,28));
        this.add(jl, BorderLayout.NORTH);

        head.add("读者姓名");
        head.add("读者类型");
        head.add("可借状态");
        this.add(jsp);

    }

    public void setTableData(){
        User u1 = new Teacher("Tom", "Tom");
        User u2 = new Undergraduate("Jerry", "jerry");
        User u3 = new Graduate("Jack", "1");

        Vector<Vector<Object>> body = new Vector<Vector<Object>>();
        //将数据库中数据取出，放入到表格所需的集合中
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);

        //将List中的数据复制到表格所需的Vector中即可
        for (User reader : list) {
            //创建小Vector对象，并把POJO对象中数据放入
            Vector<Object> v = new Vector<Object>();
            v.add(reader.getUsername());
            v.add(reader.getType());
            v.add(reader.getBorrowState());

            //小V放入大V中
            body.add(v);
        }
        DefaultTableModel model = new DefaultTableModel(body, head);
        table.setModel(model);
    }
}
