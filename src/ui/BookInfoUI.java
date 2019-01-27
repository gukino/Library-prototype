package ui;

import Service.component2.AdminService;
import pojo.Book;
import utils.MyTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class BookInfoUI extends JFrame{
    private JLabel jl = new JLabel("图书信息", JLabel.CENTER);
    private JTable table = new MyTable();
    private JScrollPane jsp = new JScrollPane(table);
    private Vector<String> head = new Vector<String>();
    private JPanel jp = new JPanel();
    private JButton save = new JButton("新增");
    private JButton edit = new JButton("修改");
    private JButton del = new JButton("删除");

    public BookInfoUI(){
        this.setTitle("查询图书信息");
        this.setSize(860, 360);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addComponent();
        addEvent();
        setTableData();

        this.setVisible(true);
    }
    public void addComponent(){
        jl.setFont(new Font("楷体_GB2312",Font.BOLD,28));
        this.add(jl, BorderLayout.NORTH);

        head.add("图书编号");
        head.add("图书名称");
        head.add("图书类型");
        head.add("简介");
        head.add("状态");
        this.add(jsp);

        jp.add(save);
        jp.add(edit);
        jp.add(del);
        this.add(jp, BorderLayout.SOUTH);
    }
    public void addEvent(){
        save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminService().addtLiteratureInfo();
                JOptionPane.showMessageDialog(null, "原型阶段，尚未完成", "提示", JOptionPane.WARNING_MESSAGE);
            }
        });
        edit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(null, "请选择一条要修改的数据", "警告提示", JOptionPane.WARNING_MESSAGE);
                }else{
                    int id = (Integer)table.getValueAt(row, 0);
                    JOptionPane.showMessageDialog(null, "原型阶段，仅提供界面展示", "提示", JOptionPane.WARNING_MESSAGE);
                    new AdminService().editLiteratureInfo();
                    // new BookInfoEditUI(BookInfoUI.this, id);
                }
            }
        });
        del.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(null, "请选择一条要删除的数据", "警告提示", JOptionPane.WARNING_MESSAGE);
                }else{
                        JOptionPane.showMessageDialog(null, "删除成功！", "信息提示", JOptionPane.INFORMATION_MESSAGE);
                        new AdminService().deleteLiteratureInfo();
                        setTableData();
                }
            }
        });
    }
    public void setTableData(){
        Vector<Vector<Object>> body = new Vector<Vector<Object>>();
        //将数据库中数据取出，放入到表格所需的集合中
        Book b1 = new Book(1, "《代码大全》","计算机", "代码大全第2版", "可借");
        Book b2 = new Book(2, "《他改变了中国》","人物传记", "必读书目", "已借出");

        List<Book> list = new ArrayList<>();
        list.add(b1);
        list.add(b2);
        //将List中的数据复制到表格所需的Vector中即可
        for (Book Bookinfo : list) {
            //创建小Vector对象，并把POJO对象中数据放入
            Vector<Object> v = new Vector<Object>();
            v.add(Bookinfo.getId());
            v.add(Bookinfo.getName());
            v.add(Bookinfo.getType());
            v.add(Bookinfo.getDescription());
            v.add(Bookinfo.getState());

            //小V放入大V中
            body.add(v);
        }
        DefaultTableModel model = new DefaultTableModel(body, head);
        table.setModel(model);
    }
}
