package kr.co.busan.great;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // todo: Responsebody 내장되어있음.
@RequestMapping("/v1/hello")
public class HelloControllerApiV1 {
    @GetMapping
    public List<String> getList() {
        List<String> stringList = new ArrayList<>();
        stringList.add("감자");
        stringList.add("고구마");
        stringList.add("카사바");
        return stringList;
    }
}

