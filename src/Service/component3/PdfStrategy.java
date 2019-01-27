package Service.component3;

import pojo.Book;


/**
 * @ClassNameAuthorizeUser
 * @Describtion TODO
 * @Author
 * @Version 1.0
 **/
public class PdfStrategy implements ReadStrategy {
    @Override
    public String read(Book book) {
        return "阅读pdf";
    }
}
