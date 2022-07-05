package kr.fit.login;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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

//	@PostMapping("/memberPhoneCheck")
//	public @ResponseBody String memberPhoneCheck(@RequestParam(value="to") String to) throws CoolsmsException {
//			
//		return paymentService.PhoneNumberCheck(to);
//	}

	
	
//	@RequestMapping(value = "/sendSms.do")
//	  public String sendSms(HttpServletRequest request) throws Exception {
//
//	    String api_key = "NCSWA6JF3ZIAZEZQ";
//	    String api_secret = "UCLVBF51YFVWUX63PFQKLBTUBBVNZWBU";
//	    Coolsms coolsms = new Coolsms(api_key, api_secret);
//
//	    HashMap<String, String> set = new HashMap<String, String>();
//	    set.put("to", "01040742070"); // 수신번호
//
//	    set.put("from", (String)request.getParameter("from")); // 발신번호
//	    set.put("text", (String)request.getParameter("text")); // 문자내용
//	    set.put("type", "sms"); // 문자 타입
//
//	    System.out.println(set);
//
//	    JSONObject result =(JSONObject)coolsms.send(set); // 보내기&전송결과받기
//
//	    if ((boolean)result.get("status") == true) {
//	      // 메시지 보내기 성공 및 전송결과 출력
//	      System.out.println("성공");
//	      System.out.println(result.get("group_id")); // 그룹아이디
//	      System.out.println(result.get("result_code")); // 결과코드
//	      System.out.println(result.get("result_message")); // 결과 메시지
//	      System.out.println(result.get("success_count")); // 메시지아이디
//	      System.out.println(result.get("error_count")); // 여러개 보낼시 오류난 메시지 수
//	    } else {
//	      // 메시지 보내기 실패
//	      System.out.println("실패");
//	      System.out.println(result.get("code")); // REST API 에러코드
//	      System.out.println(result.get("message")); // 에러메시지
//	    }
//
//	    return "redirect:main.do";
//	  }

	
	@RequestMapping(value = "calendar.do", method = RequestMethod.GET)
	public String calendar() {
		
		
		return "login/calendar";

	}
	
//
//	@RequestMapping(value = "calList.do", method = RequestMethod.GET)
//	public ModelAndView calendar(HttpServletRequest req, ArrayList<CalDTO> dto) {
//		
//		JSONObject jsonObj = new JSONObject();
//        JSONArray jsonArr = new JSONArray();
//		ModelAndView mav=new ModelAndView();
//	    HttpSession session = req.getSession();
//    	String id = session.getAttribute("s_id").toString();
// 		
//    	HashMap<String, Object> hash = new HashMap<>();
//    
//    	dto = c_dao.list(id);
//    	   for (int i = 0; i < dto.size(); i++) {
//               hash.put("title", dto.get(i).getC_title());
//               hash.put("start", dto.get(i).getC_start());
//               hash.put("end", dto.get(i).getC_end());
//               hash.put("con", dto.get(i).getC_con());
//               
//               jsonObj = new JSONObject(hash);
//               jsonArr.add(jsonObj);
//           }
//    	   
//    	mav.addObject(hash);
//    	mav.addObject("list", hash);
//    	req.setAttribute("list", dto);
//        mav.addObject(jsonArr);
//    	mav.addObject("list", dto);
//    	mav.addObject("list", jsonArr);
//    	
//    	System.out.println("1111"+hash);
//    	System.out.println("2222"+dto);
//    	System.out.println("3333"+jsonArr);
//		
//    	mav.setViewName("login/calendar");
//
//		return mav;
//
//	}
//	
	
    
	@RequestMapping(value = "calList.do", method = RequestMethod.GET)
	public ModelAndView calendar(HttpServletRequest req, ArrayList<CalDTO> dto) {
		ModelAndView mav=new ModelAndView();
		HttpSession session = req.getSession();
		String id = session.getAttribute("s_id").toString();
		dto = c_dao.list(id);
		System.out.println(dto);
		
		mav.setViewName("login/calendar");
		mav.addObject("dto", dto);
		
		return mav;

	}
	
	
	/*
	@RequestMapping(value = "calList.do", method = RequestMethod.GET)
	public void calendar(HttpServletRequest req, HttpServletResponse resp) {
        try {
		     HttpSession session = req.getSession();
		     String id = session.getAttribute("s_id").toString();
		     ArrayList<CalDTO> list=new ArrayList<CalDTO>();
		     list = c_dao.list(id);
		     //System.out.println(dto);
		
		     resp.setContentType("text/html; charset=UTF-8");
		     PrintWriter out=resp.getWriter();
		     //out.println("test");
		     
		     String table="<table border='1'>";
		     if(list==null) {
		    	 table+="<tr><td>NONE</td></tr>";
		     }else {
		    	 for(int i=0; i<list.size(); i++) {
		    	     CalDTO dto=new CalDTO();
		    		 table+="<tr>";
		    		 table+="<th>TITLE</th>"; 
		    		 table+="<td>" + dto.getC_title() + "</td>";
		    	     table+="</tr>";			 
		    	 }//for end
		     }//if end
		     
		     table+="</table>";
		     out.println(table);		     
		     out.flush();
		     out.close();
        }catch(Exception e) {
        	
        }//end
		
	}//end
	
	*/
	
	
	
	@RequestMapping(value = "cal_add.do", method = RequestMethod.POST)
	public ModelAndView cal(CalDTO dto, HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		String id = req.getParameter("id");

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
		

//	@PostMapping()
//	public reCAPTCHA_DTO reCAPTCHA_TEST(@RequestParam(name="g-recaptcha-response") String recaptchaResponse , HttpServletRequest request) {
//		String ip = request.getRemoteAddr();
//		String url = "https://www.google.com/recaptcha/api/siteverify";
//		String params="?secret=6LcqeqIgAAAAAIqVuvMDuHsT6r8xNx4G1JZaj0B3&response=" + recaptchaResponse;
//		RestTemplate restTemplate = new RestTemplate();
//		reCAPTCHA_DTO re = restTemplate.exchange(url+params, HttpMethod.POST, null, reCAPTCHA_DTO.class).getBody();
//		if(re.isSuccess()) {
//			System.out.println("성공");	
//		}
//		else {
//			System.out.println("실패");
//		}
//		return re;
//	}
	

//	@RequestMapping(value="reCAPTCHA_URL", method=RequestMethod.POST)
//	public ModelAndView reCAPTCHA_URL(HttpServletRequest request , HttpServletResponse response, Model model )
//			throws Exception {
//		ModelAndView mav= new ModelAndView();
//		try { 
//			String token = request.getParameter("token");
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//			MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
//			map.add("secret", "6LcqeqIgAAAAAIqVuvMDuHsT6r8xNx4G1JZaj0B3");
//			map.add("response", token);
//			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
//			RecaptchaDTOEntity entity = restTemplate.postForObject(CommonCode.SITE_VERIFY_URL, request, RecaptchaDTOEntity.class);
//			if(entity != null) { String score = entity.getScore(); 
//			// 점수
//			String success = entity.getSuccess();
//			// true, false 
//			} 
//			return mav; 
//			} catch (Exception e) {
//				
//			}
//		}
//	@Controller
//	public class testController {
//
//    public static final String SECRET_KEY = "6LcqeqIgAAAAABD4zRQ2TLa89dnbKtSIznikl2T3";
//    public static final String SITE_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";
//
//    @Autowired
//    RestTemplateBuilder builder;
//
//    @RequestMapping(value = "/validation", method = RequestMethod.POST)
//    public @ResponseBody String ajax(String token){
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
//        map.add("secret", SECRET_KEY);
//        map.add("response", token);
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
//
//        ResponseEntity<String> response = builder.build().postForEntity( SITE_VERIFY_URL, request , String.class );
//
//        return response.getBody();
//    }
//
//}

//	@Service
//	public class RecaptchaService {
//
//	    public CaptchaSettings token(String token) {
//	        String url = "https://www.google.com/recaptcha/api/siteverify";
//
//	        RestTemplate restTemplate = new RestTemplate();
//
//	        HttpHeaders headers = new HttpHeaders();
//	        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//	        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
//	        map.add("secret", "secret-key");
//	        map.add("response", token);
//
//	        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
//
//	        CaptchaSettings response = restTemplate.postForObject( url, request, CaptchaSettings.class );
//
//	        return response;
//	    }
//
//	}

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

