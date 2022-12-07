import java.awt.event.*;
import javax.swing.JOptionPane;
public class BookController implements ActionListener, WindowListener{
    private BookView view;
    private BookModel model;
    private BookAdd add;
    
    public BookController(){
        view = new BookView();
        model = new BookModel();
        add = new BookAdd();
        
        view.getLeft().addActionListener(this);
        view.getRight().addActionListener(this);
        view.getAdd().addActionListener(this);
        view.getUpdate().addActionListener(this);
        view.getDel().addActionListener(this);
        view.getLeft().addActionListener(this);
        view.getFr().addWindowListener(this);
        add.getInsert().addActionListener(this);
        
        model.load();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(view.getAdd())){
            add.getFr().setVisible(true);
        }
        else if(e.getSource().equals(view.getLeft())){
            if(Integer.parseInt(view.getTf3().getText()) > 1){
                int pos = Integer.parseInt(view.getTf3().getText())-1;
                view.getTf1().setText(model.getBook().get(pos).getName());
                view.getTf2().setText(String.valueOf(model.getBook().get(pos).getPrice()));
                view.getCb().setSelectedItem(model.getBook().get(pos).getType());
                view.getTf3().setText(String.valueOf((Integer.parseInt(view.getTf3().getText())-1)));
            }
//            else if(Integer.parseInt(view.getTf3().getText())-1 == 0){
//                view.getTf3().setText(String.valueOf(0));
//            }
//            if(Integer.parseInt(view.getTf3().getText()) <= 0){
//                view.getTf1().setText("");
//                view.getTf2().setText("");
//                view.getCb().setSelectedItem("General");
//            }
        }
        else if(e.getSource().equals(view.getRight())){
            if(Integer.parseInt(view.getTf3().getText()) < model.getBook().size()){
                int pos = Integer.parseInt(view.getTf3().getText());
                view.getTf1().setText(model.getBook().get(pos).getName());
                view.getTf2().setText(String.valueOf(model.getBook().get(pos).getPrice()));
                view.getCb().setSelectedItem(model.getBook().get(pos).getType());
                view.getTf3().setText((pos + 1) + "");
            }
        }
        else if(e.getSource().equals(view.getUpdate())){
                model.getBook().set(Integer.parseInt(view.getTf3().getText())-1, new Book(view.getTf1().getText(),Double.parseDouble(view.getTf2().getText()),view.getCb().getSelectedItem()+""));
                JOptionPane.showMessageDialog(null, "Done it.", "Update Command", JOptionPane.INFORMATION_MESSAGE, null);
        }
        else if(e.getSource().equals(view.getDel())){
                model.getBook().remove(Integer.parseInt(view.getTf3().getText())-1);
                JOptionPane.showMessageDialog(null, "Done it.", "Delete Command", JOptionPane.INFORMATION_MESSAGE, null);
        }
        else if(e.getSource().equals(add.getInsert())){
                model.getBook().add(new Book(add.getTf1().getText(),Double.parseDouble(add.getTf2().getText()),add.getCb().getSelectedItem()+""));
                JOptionPane.showMessageDialog(null, "Done it.", "Insert Command", JOptionPane.INFORMATION_MESSAGE, null);
                add.getFr().setVisible(false);
                add.getTf1().setText("");
                add.getTf2().setText("");
                add.getCb().setSelectedIndex(0);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        model.save();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
    public static void main(String[] args) {
        new BookController();
    }
    
    
}
