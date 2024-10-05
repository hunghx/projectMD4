package ra.project.config;

import org.springframework.web.servlet.HandlerInterceptor;
import ra.project.model.dto.response.UserLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       // kiểm tra quyền
        HttpSession session  =request.getSession();
        UserLogin userLogin = (UserLogin) session.getAttribute("user_login");
        if (userLogin == null){
            response.sendRedirect("/login");
            return false;
        } else if (!userLogin.isRole()) {
            response.sendRedirect("/");
            return  false;
        }
        return true;
    }
}
