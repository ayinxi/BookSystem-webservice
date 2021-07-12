package booksystem.controller;

import booksystem.pojo.Book;
import booksystem.service.BookService;
import booksystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="*",maxAge = 3600)
@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("/getAllBook")
    public Result getAllBook() {
        return Result.ok().put("data",bookService.getAllBook());
    }

    @RequestMapping("/getBook/{ByShop}")
    public Result getBookByShop(String username) {
        return Result.ok().put("data",bookService.getBookByShop(username));
    }

    @RequestMapping("/getBook/{ByOrder}")
    public Result getBookByOrder(String order_id) {
        return Result.ok().put("data",bookService.getBookByOrder(order_id));
    }

    @RequestMapping("/getBook/{ByCategory}")
    public Result getBookByCategory(String category) {
        return Result.ok().put("data",bookService.getBookByCategory(category));
    }

    @RequestMapping("/getBook/{ByName}")
    public Result getBookByName(String bookname) {
        return Result.ok().put("data",bookService.getBookByName(bookname));
    }

    @RequestMapping("/getBook/{ByPress}")
    public Result getBookByPress(String press) {
        return Result.ok().put("data",bookService.getBookByPress(press));
    }

    @RequestMapping("/mutiAddBook")
    public Result mutiAddBook(List<Book> book_list) {
        return null;
    }

    @RequestMapping("/addBook")
    public Result addBook(Book book) {
        return null;
    }

    @RequestMapping("/deleteBook")
    public Result deleteBook(String book_id) {
        return null;
    }

    @RequestMapping("/mutiDeleteBook")
    public Result mutiDeleteBook(String[] Book_Ids) {
        return null;
    }

    @RequestMapping("/updateBook")
    public Result updateBook(Book book) {
        return null;
    }
}
