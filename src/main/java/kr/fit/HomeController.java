package kr.fit;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
	
@Controller
public class HomeController {

	public HomeController() {
	System.out.println("home객체 생성");
	}
	
	@RequestMapping("/home.do")
	public ModelAndView home() {
		ModelAndView mav= new ModelAndView();
//		mav.setViewName("redirect:/main.do");
		 // mav.setViewName("/main");
		 // mav.setView(new RedirectView("/main.do", true));
		 
		  mav.setViewName("/main");
		return mav;
	}
	
	
	

	

}