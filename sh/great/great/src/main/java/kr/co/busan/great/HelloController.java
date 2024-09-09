package kr.co.busan.great;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller // 클래스 위에 Controller 어노테이션 작성 // 화면 뿌리기
@RequestMapping("/") // 경로 // 주소 연결
public class HelloController {

    @GetMapping // 주소값을 보내는것
    public String firstPage(){
        return "/first";
    }

    @GetMapping("/second")
    public String secondPage(){
        return "/second";
    }

}

