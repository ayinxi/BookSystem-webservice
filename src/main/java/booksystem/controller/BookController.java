package booksystem.controller;

import booksystem.pojo.Book;
import booksystem.pojo.User;
import booksystem.service.BookService;
import booksystem.utils.Result;
import booksystem.utils.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins="*",maxAge = 3600)
@RestController
public class BookController {
    @Autowired
    BookService bookService;
//
//    @RequestMapping("/book/getAll")
//    public Result getAllBook() {
//        List<Book> result=bookService.getAllBook();
//        if(!result.isEmpty())
//        {
//            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
//        }else{
//            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
//        }
//    }
//
//    @RequestMapping("/book/getByShop")
//    public Result getBookByShop(@RequestParam("username") String username) {
//        return Result.ok().put("data",bookService.getBookByShop(username));
//    }

//    @RequestMapping("/getBook/{ByOrder}")
//    public Result getBookByOrder(String order_id) {
//        return Result.ok().put("data",bookService.getBookByOrder(order_id));
//    }
//
//    @RequestMapping("/getBook/{ByCategory}")
//    public Result getBookByCategory(String category) {
//        return Result.ok().put("data",bookService.getBookByCategory(category));
//    }
//
//    @RequestMapping("/getBook/{ByName}")
//    public Result getBookByName(String bookname) {
//        return Result.ok().put("data",bookService.getBookByName(bookname));
//    }
//
//    @RequestMapping("/getBook/{ByPress}")
//    public Result getBookByPress(String press) {
//        return Result.ok().put("data",bookService.getBookByPress(press));
//    }
//
//    @RequestMapping("/mutiAddBook")
//    public Result mutiAddBook(List<Book> book_list) {
//        return null;
//    }
//
    @RequestMapping("/book/addBook")
    public Result addBook(@RequestParam("username")String book_name,
                          @RequestParam("username")String author,
                          @RequestParam("username")double price,
                          @RequestParam("username")int volume,
                          @RequestParam("username")int repertory,
                          @RequestParam("username")String press,
                          @RequestParam("username")int edition,
                          @RequestParam("username")String print_time,
                          @RequestParam("username")String category_id,
                          @RequestParam("username")String shop_id,
                          @RequestParam("img") MultipartFile img) {
        return null;
    }
//
//    @RequestMapping("/deleteBook")
//    public Result deleteBook(String book_id) {
//        return null;
//    }
//
//    @RequestMapping("/mutiDeleteBook")
//    public Result mutiDeleteBook(String[] Book_Ids) {
//        return null;
//    }
//
//    @RequestMapping("/updateBook")
//    public Result updateBook(Book book) {
//        return null;
//    }
}
