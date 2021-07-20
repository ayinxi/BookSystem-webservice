package booksystem.controller;

import booksystem.pojo.Book;
import booksystem.pojo.User;
import booksystem.service.BookService;
import booksystem.service.UploadImgService;
import booksystem.utils.Result;
import booksystem.utils.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins="*",maxAge = 3600)
@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    UploadImgService uploadImgService;

    @RequestMapping("/book/getAll")
    public Result getAllBook() {
        Map<String,Object> result=bookService.getAllBook();
        if(!result.isEmpty())
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
        }else{
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
    }
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
    @PostMapping("/book/addBook")
    public Result addBook(@RequestParam("book_name")String book_name,
                          @RequestParam("author")String author,
                          @RequestParam("price")String price,
                          @RequestParam("repertory")String repertory,
                          @RequestParam("press")String press,
                          @RequestParam("edition")String edition,
                          @RequestParam("print_time")String print_time,
                          @RequestParam("category_id")String category_id,
                          @RequestParam("shop_id")String shop_id,
                          @RequestParam("img") MultipartFile img) {
        String book_id=bookService.selectBook(book_name,author,Double.parseDouble(price),press,edition,print_time,category_id,shop_id);
        if(!(book_id==null)){
            return Result.error(ResultEnum.REPEAT_ADD.getCode(),ResultEnum.REPEAT_ADD.getMsg());
        }
        bookService.addBook(book_name,author,Double.parseDouble(price),Integer.parseInt(repertory),press,edition,print_time,category_id,shop_id);
        book_id=bookService.selectBook(book_name,author,Double.parseDouble(price),press,edition,print_time,category_id,shop_id);
        uploadImgService.uploadBookImg(img,book_id);

        return Result.ok(ResultEnum.SUCCESS.getMsg());
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
