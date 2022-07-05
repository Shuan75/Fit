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
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}
//	
//	@ResponseBody
//	@RequestMapping(value = "VerifyRecaptcha", method = RequestMethod.POST)
//	public int VerifyRecaptcha(HttpServletRequest request) {
//		VerifyRecaptcha.setSecretKey("6LcqeqIgAAAAAIqVuvMDuHsT6r8xNx4G1JZaj0B3");
//		String gRecaptchaResponse = request.getParameter("recaptcha");
//		System.out.println(gRecaptchaResponse);
//		//0 = 성공, 1 = 실패, -1 = 오류
//		try {
//			if(VerifyRecaptcha.verify(gRecaptchaResponse))
//				return 0;
//			else return 1;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return -1;
//		}
//	}
//	
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