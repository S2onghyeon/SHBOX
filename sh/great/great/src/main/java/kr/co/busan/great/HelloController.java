package kr.co.busan.great;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller // 클래스 위에 Controller 어노테이션 작성 // 화면 뿌리기
@RequestMapping("/") // 경로 // 주소 연결
public class HelloController {


    @GetMapping // 주소값을 보내는것
    public String firstPage(
            @RequestParam(required = false, defaultValue = "카리나") String name,// RequestParm 특정 쿼리스트링 가져옴
            Model model // html 파일에 데이터를 집어넣을때 사용
            //@RequestParam(required = false) String name // null
            //@RequestParam(defaultValue = "카리나") String name // 카리나
    ){
        model.addAttribute("name", name);
        return "/first";

    }

    @GetMapping("/second") //http://localhost:8080/second?hobby=
    public ModelAndView secondPage(
        @RequestParam(required = false, defaultValue = "유튜브보기") String hobby
    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hobby",hobby);
        modelAndView.setViewName("/second");
        return modelAndView;
    }

}

