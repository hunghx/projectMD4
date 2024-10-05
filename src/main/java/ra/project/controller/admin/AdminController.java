package ra.project.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {
   @GetMapping
    public String index(){
       return "admin/index";
   }
   @GetMapping("/user")
   public String users(){
       return "admin/user";
   }
}
