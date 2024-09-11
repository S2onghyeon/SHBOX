// MVC 컨트롤러 클래스
package com.example.my.domain.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    @GetMapping("/auth/login")
    public ModelAndView loginPage() {
        // model and view 모두 포함하는 객체 : 데이터를 view 에 전달함 과 동시에 어떤 view 렌더링 할지 지정하는데 사용
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth/login");
        return modelAndView;
    } // templates -> login.html 렌더링

    @GetMapping("/auth/join")
    public ModelAndView joinPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth/join");
        return modelAndView;
    }

//    @GetMapping("/auth/logout")
//    public ModelAndView logout(HttpSession session) {
//
//        session.invalidate();
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/auth/login");
//        return modelAndView;
//    }
}
