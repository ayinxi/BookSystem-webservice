package booksystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping("/test/{lala}")
    public String test(@PathVariable String lala){
        return lala+"5201314";
    }
}
