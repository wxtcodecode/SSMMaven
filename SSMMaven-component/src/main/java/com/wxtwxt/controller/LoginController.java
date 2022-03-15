package com.wxtwxt.controller;

import com.wxtwxt.pojo.Emp;
import com.wxtwxt.service.LoginService;
import com.wxtwxt.util.ImperialCourtConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.xml.ws.ResponseWrapper;

/**
 * @author Wxt
 * @create 2022-03-14 19:04
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/auth/login")
    public String checkEmpByLoginAccount(@RequestParam String loginAccount, @RequestParam String loginPassword, HttpSession session, Model model) {
        Emp emp = loginService.selectEmpByLoginAccount(loginAccount, loginPassword);
        System.out.println(emp);
        if(emp == null) {
            model.addAttribute("message", ImperialCourtConst.LOGIN_FAILED_MESSAGE);
            return "index";
        }else {
            session.setAttribute("emp", emp);
            return "target";
        }

    }
}
