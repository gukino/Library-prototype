package ui;

import Service.component1.BorrowStrategy;
import Service.component3.ReadStrategy;
import factory.BorrowFactory;
import factory.StrategyFactory;
import pojo.Book;
import pojo.User.User;
import utils.MyTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class BooksUI extends JFrame{
    Book b1 = new Book(1, "《代码大全》","计算机", "代码大全第2版", "可借");
    Book b2 = new Book(2, "《他改变了中国》","人物传记", "必读书目", "已借出");

    List<Book> list = new ArrayList<>();
    private ReadStrategy readStrategy = null;

    private JLabel jl = new JLabel("图书信息", JLabel.CENTER);
    private JTable table = new MyTable();
    private JScrollPane jsp = new JScrollPane(table);
    private Vector<String> head = new Vector<String>();
    private JPanel jp = new JPanel();
    private JButton borrow = new JButton("借阅");
    private JButton pdfRead = new JButton("pdf");
    private JButton docRead = new JButton("doc");
    private JButton epubRead = new JButton("epub");


    private BorrowStrategy borrowStrategy = null;

    public BooksUI(User user){
        list.add(b1);
        list.add(b2);
        borrowStrategy = BorrowFactory.createStrategy(user.getTypeName());
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

        jp.add(borrow);
        jp.add(pdfRead);
        jp.add(docRead);
        jp.add(epubRead);
        this.add(jp, BorderLayout.SOUTH);
    }
    public void addEvent(){
        borrow.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(null, "请选择一本要借阅的书", "警告提示", JOptionPane.WARNING_MESSAGE);
                }else{
                    String state = (String)table.getValueAt(row, 4);
                    if(state == "已借出"){
                        JOptionPane.showMessageDialog(null, "本书已借出", "警告提示", JOptionPane.WARNING_MESSAGE);
                    }else {
                        JOptionPane.showMessageDialog(null, "借阅成功，" + borrowStrategy.borrow() , "提示", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            }
        });
        pdfRead.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(null, "请选择要读的书", "警告提示", JOptionPane.WARNING_MESSAGE);
                }else{
                    int id = (Integer)table.getValueAt(row, 0);
                    String name = (String)table.getValueAt(row, 1);
                    String type = (String)table.getValueAt(row, 2);
                    String description = (String)table.getValueAt(row, 3);
                    String state = (String)table.getValueAt(row, 4);

                    Book book = new Book(id, name, type, description, state);
                    readStrategy = StrategyFactory.createStrategy("pdf");
                    JOptionPane.showMessageDialog(null, readStrategy.read(book) + book.getName(), "在线阅读", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        docRead.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(null, "请选择要读的书", "警告提示", JOptionPane.WARNING_MESSAGE);
                }else{
                    int id = (Integer)table.getValueAt(row, 0);
                    String name = (String)table.getValueAt(row, 1);
                    String type = (String)table.getValueAt(row, 2);
                    String description = (String)table.getValueAt(row, 3);
                    String state = (String)table.getValueAt(row, 4);

                    Book book = new Book(id, name, type, description, state);
                    readStrategy = StrategyFactory.createStrategy("doc");
                    JOptionPane.showMessageDialog(null, readStrategy.read(book) + book.getName(), "在线阅读", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        epubRead.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(null, "请选择要读的书", "警告提示", JOptionPane.WARNING_MESSAGE);
                }else{
                    int id = (Integer)table.getValueAt(row, 0);
                    String name = (String)table.getValueAt(row, 1);
                    String type = (String)table.getValueAt(row, 2);
                    String description = (String)table.getValueAt(row, 3);
                    String state = (String)table.getValueAt(row, 4);

                    Book book = new Book(id, name, type, description, state);
                    readStrategy = StrategyFactory.createStrategy("epub");
                    JOptionPane.showMessageDialog(null, readStrategy.read(book) + book.getName(), "在线阅读", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        });
    }


    public void setTableData(){
        Vector<Vector<Object>> body = new Vector<Vector<Object>>();
        //将数据库中数据取出，放入到表格所需的集合中

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
