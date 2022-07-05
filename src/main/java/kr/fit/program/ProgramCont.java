package kr.fit.program;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ProgramCont {
	
	ProgramDAO dao = null;
	
	public ProgramCont() {
		dao = new ProgramDAO();
		System.out.println("----ProgramCont() 객체 생성됨");
	}
//
//	@RequestMapping(value = "program.do")
//	public ModelAndView list() {
//		ModelAndView mav=new ModelAndView();
//		mav.setViewName("program/program");
//		mav.addObject("list", dao.list());		
//		return mav;
//	}//list() end
//	
	
	@RequestMapping(value = "program.do")
	public ModelAndView list() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("program/program");
		mav.addObject("list", dao.list());		
		return mav;
	}//list() end

	
	
//	@RequestMapping("/program/read.do")
//	public ModelAndView read(String c_code) {
//		ModelAndView mav=new ModelAndView();
//		ProgramDTO dto=dao.read(c_code);
//		mav.addObject("dto",dto);
//		
//		//mav.setViewName("program/program");
//		//mav.addObject("list", dao.list());
//		return mav;
//	}//read() end
//	
	
	
//	@RequestMapping(value="read.do", method=RequestMethod.GET)
//	public String getread() {
//		return "program/read";
//	}
//
	
	@RequestMapping(value="read.do")
	public ModelAndView read(String c_code) {
		ModelAndView mav = new ModelAndView();
		ProgramDTO dto = dao.read(c_code);
		
		mav.addObject("dto", dto);
		mav.setViewName("program/read");
		return mav;
	}
	
	
}//class end
