package kr.fit.trainer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrainerCont {

	TrainerDAO dao = null;

	public TrainerCont() {
		dao = new TrainerDAO();
		System.out.println("trainerCont 생성");
	}

//	@RequestMapping(value = "list.do")
//	public ModelAndView list() {	
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("trainer/trainerList");
//		mav.addObject("list", dao.list());
//		return mav;
//	}

	@RequestMapping(value = "list.do")
	public ModelAndView read(TrainerDTO dto) {
		ModelAndView mav = new ModelAndView();
		dto = dao.read(dto);
		mav.setViewName("trainer/trainerList");
		mav.addObject("list", dto);
		return mav;
	}

}
