import java.io.*;
import java.util.*;
public class BookModel {
    private ArrayList<Book> book = new ArrayList<Book>();
    
    public void load(){
        File f = new File("Book.data");
        if (f.exists()){
            try(FileInputStream fin = new FileInputStream(f);
            ObjectInputStream in = new ObjectInputStream(fin);){
                book = (ArrayList<Book>)in.readObject();
            }catch(Exception i){
                System.out.println(i);
            }
        }
    }
    public void save(){
        File f = new File("Book.data");
        try(FileOutputStream fout = new FileOutputStream(f);
        ObjectOutputStream oout = new ObjectOutputStream(fout);){
            oout.writeObject(book);
        }catch(Exception i){
            System.out.println(i);
        }
    }

    public ArrayList<Book> getBook() {
        return book;
    }

    public void setBook(ArrayList<Book> book) {
        this.book = book;
    }

}
