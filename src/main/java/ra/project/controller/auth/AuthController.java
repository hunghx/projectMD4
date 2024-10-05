package ra.project.controller.auth;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ra.project.exception.AuthenticationException;
import ra.project.model.dto.request.FormLogin;
import ra.project.model.dto.request.FormRegister;
import ra.project.model.dto.response.UserLogin;
import ra.project.service.auth.IAuthService;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {
    @Autowired
    private IAuthService authService;
    @GetMapping("/register")
    public String showFormRegister(){
        return "auth/register";
    }
    @PostMapping("/sign-up")
    public String handleRegister(@ModelAttribute FormRegister request){
        // xử lí đăng kí
        authService.register(request);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String login(){
        return "auth/login";
    }
    @PostMapping("/sign-in")
    public String doLogin(@ModelAttribute FormLogin request, HttpSession session, Model model){
        try {
            UserLogin userLogin = authService.login(request);
            if (userLogin.isStatus()){
                // lưu len session
                session.setAttribute("user_login", userLogin);
                if (userLogin.isRole()){
                    return  "redirect:/admin";
                }else {
                    return "redirect:/";
                }
            }else {
                model.addAttribute("error","Tai khoan bị khoa");
                return "auth/login";
            }

        }catch (AuthenticationException e){
            model.addAttribute("error","Thong tin đăng nhập không đúng");
            return "auth/login";
        }
        // cử li ket qua
    }
    @GetMapping("/logout")
    public  String logout(HttpSession session){
        session.removeAttribute("user_login");
        return "redirect:/login";
    }


}
