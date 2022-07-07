package kr.fit.login;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import net.nurigo.java_sdk.Coolsms;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import net.utility.Utility;

@Controller
public class LoginCont {

	UserDAO dao = null;
	CalDAO c_dao = null;
	public LoginCont() {
		dao = new UserDAO();
		c_dao = new CalDAO();
		System.out.println("Create LoginCont");
	}

	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {

		return "login/loginForm";

	}

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public ModelAndView loginProc(@ModelAttribute UserDTO dto, HttpSession session, HttpServletRequest req,
			HttpServletResponse resp) throws IOException {

		String id = req.getParameter("id").trim();
		String password = req.getParameter("password").trim();

		dto.setId(id);
		dto.setPassword(password);

		String rating = dao.loginProc(dto);

		ModelAndView mav = new ModelAndView();

		if (rating == null) {
			mav.setViewName("login/msgView");
			req.setAttribute("message", "<p>아이디 비번 불일치</p>");
			req.setAttribute("link", "<a href='javascript:history.back()'>[다시시도]</a>");
		} else {
			session.setAttribute("s_id", id);
			session.setAttribute("s_password", password);
			session.setAttribute("s_rating", rating);
			
		



			req.setAttribute("message", "<h3>환영합니다 </h3>");
			String c_id = Utility.checkNull(req.getParameter("c_id"));
			Cookie cookie = null;
			if (c_id.equals("SAVE")) {

				cookie = new Cookie("c_id", id);
				cookie.setMaxAge(60 * 60 * 24 * 30);

			} else {

				cookie = new Cookie("c_id", "");
				cookie.setMaxAge(0);
			}
			resp.addCookie(cookie);
			String root = Utility.getRoot();
			resp.sendRedirect(root + "/home.do");

		}

		return mav;

	}
	
	@RequestMapping(value = "searchID.do", method = RequestMethod.GET)
	public String searchID() {
			
		
		return "login/searchID";	
	}
	
	@RequestMapping(value = "findIdProc.do", method = RequestMethod.POST)
	public ModelAndView searchIDProc(UserDTO dto, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ModelAndView mav = new ModelAndView();
		
		String u_name = req.getParameter("u_name").trim();
		String email = req.getParameter("email").trim();
		
		dto.setU_name(u_name);
		dto.setEmail(email);
		
		PrintWriter out = resp.getWriter();
		System.out.println(dto);
		
		boolean flag = dao.findID(dto);
		mav.addObject("dto", dto);
		if (flag==false) {
			out.println("<p>이름과 이메일을 다시 한번 확인해주세요.</p>");
			out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");	
		} else {
			String message = "";
			message += "아이디와 임시 비밀번호가 이메일로 전송 되었습니다.\\n";
			message += "임시 비밀번호는 로그인 후 회원정보 수정에서 수정하시기 바랍니다.";
			out.println("<script>");
			out.println("alert('" + message + "');");
			out.println("location.href='loginForm.jsp'");
			out.println("</script>");
			mav.setViewName("login/resultID");
			
		}
	
		
		
		return mav;
	}

	@RequestMapping(value = "/phoneCheck", method = RequestMethod.GET)
	@ResponseBody
	public String sendSMS(@RequestParam("phone") String userPhoneNumber) { // 휴대폰 문자보내기
		int randomNumber = (int)((Math.random()* (9999 - 1000 + 1)) + 1000);//난수 생성

		testService testService = new testService();
		testService.certifiedPhoneNumber(userPhoneNumber, randomNumber);
		
		return Integer.toString(randomNumber);
	}



	
	@RequestMapping(value = "calendar.do", method = RequestMethod.GET)
	public String calendar() {
		
		
		return "login/calendar";

	}
	
//
	
	
	
	
	
	@RequestMapping(value = "cal_add.do", method = RequestMethod.GET)
	public ModelAndView cal(CalDTO dto, HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		String id = session.getAttribute("s_id").toString();

		dto.setC_id(id);
		
		
		int cnt = c_dao.create(dto);

		if (cnt == 0) {
			mav.setViewName("login/msgView");
			req.setAttribute("message", "<p>회원가입 등록 실패</p>");
			req.setAttribute("link", "<a href='javascript:history.back()'>[다시시도]</a>");
		} else {
			session.setAttribute("s_id", id);
			mav.setViewName("login/calendar");

		}
		
		return mav;
	}
	
	@RequestMapping(value = "chart.do", method = RequestMethod.GET)
	public String chart() {

		return "login/chart";

	}
	
	@RequestMapping(value = "pay.do", method = RequestMethod.GET)
	public String pay() {

		return "login/cominfo_pay";

	}
	@RequestMapping(value = "chat.do", method = RequestMethod.GET)
	public String chat() {

		return "login/chat";

	}
		

	@RequestMapping(value = "logout.do")
	public String logout(UserDTO dto, HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		session.removeAttribute("s_id");
		session.removeAttribute("s_password");
		session.removeAttribute("s_rating");
		String root = Utility.getRoot();
		resp.sendRedirect(root + "/home.do");

		return "login/logout";
	}

	@RequestMapping(value = "idCheckForm.do")
	public String idCheck() {

		return "login/idCheckForm";
	}

	@RequestMapping(value = "idCheckProc.do")
	public String idCheckProc() {
		return "login/idCheckProc";
	}

	@RequestMapping(value = "emailCheckForm.do")
	public String emailCheck() {

		return "login/emailCheckForm";
	}

	@RequestMapping(value = "emailCheckProc.do")
	public String emailCheckProc() {
		return "login/emailCheckProc";
	}

	@RequestMapping(value = "member.do", method = RequestMethod.GET)
	public String member() {

		return "login/memberForm";

	}

	@RequestMapping(value = "member.do", method = RequestMethod.POST)
	public ModelAndView memberProc(@ModelAttribute UserDTO dto, HttpSession session, HttpServletRequest req,
			HttpServletResponse resp) throws IOException {

		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String u_name = req.getParameter("u_name");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String pnum = req.getParameter("pnum");
		int birth = Integer.parseInt(req.getParameter("birth"));
		String addr = req.getParameter("addr");
		String addr2 = req.getParameter("addr2");
		String postal = req.getParameter("postal");

		dto.setU_name(u_name);
		dto.setId(id);
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setGender(gender);
		dto.setAddr(addr);
		dto.setAddr2(addr2);
		dto.setPostal(postal);
		dto.setBirth(birth);
		dto.setPnum(pnum);

		int cnt = dao.create(dto);

		ModelAndView mav = new ModelAndView();

		if (cnt == 0) {
			mav.setViewName("login/msgView");
			req.setAttribute("message", "<p>회원가입 등록 실패</p>");
			req.setAttribute("link", "<a href='javascript:history.back()'>[다시시도]</a>");
		} else {
			session.setAttribute("s_id", id);
			session.setAttribute("s_password", password);
			req.setAttribute("message", "<h3>환영합니다 </h3>");
			mav.setViewName("login/memberResult");

		}

		return mav;
	}

	@RequestMapping(value = "modify.do", method = RequestMethod.GET)
	public ModelAndView update(HttpServletRequest req, HttpSession session) {

		ModelAndView mav = new ModelAndView();

		String id = req.getParameter("id");
//
		session.getAttribute("s_id");
		UserDTO dto = dao.read(id);

		
		mav.addObject("dto", dto);

		mav.setViewName("login/memberModify");

		return mav;
	}// update() end

	@RequestMapping(value = "modify.do", method = RequestMethod.POST)
	public ModelAndView updateProc(@ModelAttribute UserDTO dto, HttpServletRequest req, HttpSession session) {

		ModelAndView mav = new ModelAndView();
		int cnt = dao.updateProc(dto);

		if (cnt == 0) {
			mav.setViewName("login/failModify");
			req.setAttribute("message", "<p>회원 정보 수정 실패</p>");
			req.setAttribute("link", "<a href='javascript:history.back()'>[다시시도]</a>");
		} else {

			mav.setViewName("redirect:/home.do");
		}

		return mav;
	}// update() end

		

}

