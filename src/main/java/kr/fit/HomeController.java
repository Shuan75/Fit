package kr.fit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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