package edu.uclm.esi.http;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("/")
    public String start(HttpServletRequest request, @RequestParam(required = false) String name, @RequestParam(required = false) String pwd) {
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String s = headers.nextElement();
            System.out.println(s + "=" + request.getHeader(s));
        }
        return "Hola " + name;
    }
}
