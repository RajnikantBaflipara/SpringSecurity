package com.rajnish.example.controller;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import org.springframework.security.core.Authentication;  
import org.springframework.security.core.context.SecurityContextHolder;  
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;   


@Controller  
public class HomeController {    
      
//    @RequestMapping(value="/logout", method=RequestMethod.GET)  
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
//        if (auth != null){      
//           new SecurityContextLogoutHandler().logout(request, response, auth);  
//        }  
//         return "redirect:/";  
//     }  

	
    @RequestMapping(value={"/","/index"}, method=RequestMethod.GET)    
    public String index() {    
            
        return "index";    
    }    
    @RequestMapping(value="/login", method=RequestMethod.GET)    
    public String login() {    
            
        return "login";    
    }    
    @RequestMapping(value="/admin", method=RequestMethod.GET)    
    public String admin() {    
            
        return "admin";    
    }   
    @RequestMapping(value="/403", method=RequestMethod.GET)    
    public String accesssDenied() {    
            
        return "403";    
    }   
}  
