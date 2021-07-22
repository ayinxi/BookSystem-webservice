package booksystem.controller;

import booksystem.dao.BookDao;
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
    @Autowired
    BookDao bookDao;

    /**
     * @param page_num 第几页
     * @param book_num 每页多少书
     * @param style 排序方式 1:总销量,2:上架时间(所有),
     * @param main_category_id 一级目录id
     * @param second_category_id 二级目录id
     * @param year 年份筛选
     * @return
     */
    @RequestMapping("/book/getPage")
    public Result getPage(@RequestParam("page_num")String page_num,
                          @RequestParam("book_num")String book_num,
                          @RequestParam("style")String style,
                          @RequestParam("main_category_id") String main_category_id,//可缺省
                          @RequestParam("second_category_id") String second_category_id,//可缺省
                          @RequestParam("year") String year   //可缺省
                          ) {
        if(page_num.isEmpty()||book_num.isEmpty()||style.isEmpty()){
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
        return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",bookService.getPage(
                Integer.parseInt(page_num),Integer.parseInt(book_num),Integer.parseInt(style),
                main_category_id,second_category_id,year
        ));
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
                          @RequestParam("main_category_id")String main_category_id,
                          @RequestParam("second_category_id")String second_category_id,
                          @RequestParam("shop_id")String shop_id,
                          @RequestParam("img") MultipartFile img) {
        String book_id=bookService.selectBook(book_name,author,Double.parseDouble(price),press,edition,print_time,main_category_id,second_category_id,shop_id);
        if(!(book_id==null)){
            return Result.error(ResultEnum.REPEAT_ADD.getCode(),ResultEnum.REPEAT_ADD.getMsg());
        }
        if(Double.parseDouble(price)<0||Integer.parseInt(repertory)<0){
            return Result.error(ResultEnum.NUM_LOWER_ZERO.getCode(),ResultEnum.NUM_LOWER_ZERO.getMsg());
        }
        bookService.addBook(book_name,author,Double.parseDouble(price),Integer.parseInt(repertory),
                press,edition,print_time,main_category_id,second_category_id,shop_id);
        book_id=bookService.selectBook(book_name,author,Double.parseDouble(price),press,edition,
                print_time,main_category_id,second_category_id,shop_id);
        uploadImgService.uploadBookImg(img,book_id);

        return Result.ok(ResultEnum.SUCCESS.getMsg()).put("book_id",book_id);
    }

    @DeleteMapping("/book/delete")
    public Result deleteBook(@RequestParam("book_id") String book_id) {
        if(book_id.isEmpty()){
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
        uploadImgService.deleteBookImg(book_id);
        bookService.deleteBook(book_id);
        return Result.ok(ResultEnum.SUCCESS.getMsg());
    }

    @DeleteMapping("/book/multiDelete")
    public Result mutiDeleteBook(@RequestParam("book_id") List<String> book_ids) {
        if(book_ids.isEmpty()){
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
        for(int i=0;i<book_ids.size();i++){
            uploadImgService.deleteBookImg(book_ids.get(i));
        }
        bookDao.deleteBooks(book_ids);
        return Result.ok(ResultEnum.SUCCESS.getMsg());
    }

    @PostMapping("/book/updateBook")
    public Result updateBook(@RequestParam("book_id")String book_id,
                             @RequestParam("book_name")String book_name,
                             @RequestParam("author")String author,
                             @RequestParam("price")String price,
                             @RequestParam("repertory")String repertory,
                             @RequestParam("press")String press,
                             @RequestParam("edition")String edition,
                             @RequestParam("print_time")String print_time,
                             @RequestParam("main_category_id")String main_category_id,
                             @RequestParam("second_category_id")String second_category_id,
                             @RequestParam("shop_id")String shop_id) {
        if(book_id.isEmpty()){
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
        if(Double.parseDouble(price)<0||Integer.parseInt(repertory)<0){
            return Result.error(ResultEnum.NUM_LOWER_ZERO.getCode(),ResultEnum.NUM_LOWER_ZERO.getMsg());
        }
        bookDao.updateBook(book_id,book_name,author,Double.parseDouble(price),Integer.parseInt(repertory),
                press,edition,print_time,main_category_id,second_category_id,shop_id);
        return Result.ok(ResultEnum.SUCCESS.getMsg());
    }
    @PostMapping("/book/updateImg")
    public Result updateBook(@RequestParam("book_id")String book_id,
                             @RequestParam("img") MultipartFile img) {
        if(book_id.isEmpty()){
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }

        uploadImgService.uploadBookImg(img,book_id);
        return Result.ok(ResultEnum.SUCCESS.getMsg());
    }


    //添加修改书籍详情
    @PostMapping("/book/updateDetail")
    public Result updateDetail(@RequestParam("book_id")String book_id,
                            @RequestParam("detail") String detail) {
        if(book_id.isEmpty()){
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
        bookDao.updateDetail(book_id,detail);
        return Result.ok(ResultEnum.SUCCESS.getMsg());
    }

}
