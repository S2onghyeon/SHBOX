package kr.co.busan.great;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // todo: Responsebody 내장되어있음.
@RequestMapping("/v2/hello")
public class HelloControllerApiV2 {
    @GetMapping
    public Map<String, Object> getMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("이름", "홍길동");
        map.put("나이", 15);
        map.put("취미", "순간이동");
        return map;

    }
}


