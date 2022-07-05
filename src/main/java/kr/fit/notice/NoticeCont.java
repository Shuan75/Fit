package kr.fit.notice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.utility.Paging;
import net.utility.Utility;



@Controller
public class NoticeCont {
	NoticeDAO dao=null;
	
	public NoticeCont() {
		dao = new NoticeDAO();
		System.out.println("----NoticeCont() 객체 생성됨");
	}
	
	
	
	@RequestMapping(value = "noticeList.do")
	public ModelAndView list(HttpServletRequest req) {		
	
		/////////////////////////////////////////////////////////////////////
        String word=req.getParameter("word");	//검색어
    	String col=req.getParameter("col");		//검색칼럼
    	//System.out.println("#"+word+"#");
    	//System.out.println("#"+col+"#");
    	
    	word=Utility.checkNull(word);	//문자열값이 null이면 빈문자열로 치환
    	col	=Utility.checkNull(col);			
		/////////////////////////////////////////////////////////////////////
    	
		ModelAndView mav=new ModelAndView();
		mav.setViewName("notice/noticeList");	
		
		//int totalRowCount=dao.totalRowCount(); //검색하지 않았을 경우 글갯 
		int totalRowCount=dao.count2(col, word); //검색한 경우 글갯
		//System.out.println("--------------"+totalRowCount);
		
        
        //페이징
        int numPerPage   = 5;    // 한 페이지당 레코드 갯수
        int pagePerBlock = 10;   // 페이지 리스트
       
        String pageNum=req.getParameter("pageNum");
        if(pageNum==null){
              pageNum="1";
        }
       
        int currentPage=Integer.parseInt(pageNum);
        int startRow   =(currentPage-1)*numPerPage+1;
        int endRow     =currentPage*numPerPage;
       
        //페이지 수
        double totcnt = (double)totalRowCount/numPerPage;
        int totalPage = (int)Math.ceil(totcnt);
         
        double d_page = (double)currentPage/pagePerBlock;
        int Pages     = (int)Math.ceil(d_page)-1;
        int startPage = Pages*pagePerBlock;
        int endPage   = startPage+pagePerBlock+1;
       
       
        List list=null;     
        if(totalRowCount>0){           
              list=dao.list2(startRow, endRow, col, word);          
        } else {           
              list=Collections.EMPTY_LIST;           
        }//if end
         
        int number=0;
        number=totalRowCount-(currentPage-1)*numPerPage;
         
        mav.addObject("number",    number);
        mav.addObject("pageNum",   currentPage);
        mav.addObject("startRow",  startRow);
        mav.addObject("endRow",    endRow);
        mav.addObject("count",     totalRowCount);
        mav.addObject("pageSize",  pagePerBlock);
        mav.addObject("totalPage", totalPage);
        mav.addObject("startPage", startPage);
        mav.addObject("endPage",   endPage);
        mav.addObject("list", list);
        return mav;
		
		
		
	}//list2() end
	
	


	
	@RequestMapping(value="create.do", method=RequestMethod.GET)
	public ModelAndView noticeForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("notice/noticeForm");
		return mav;
	}//noticeForm() end
	
	
	@RequestMapping(value="create.do", method=RequestMethod.POST)
	public ModelAndView createProc(@ModelAttribute NoticeDTO dto,HttpServletRequest req) {
							
		String bbs_title=req.getParameter("bbs_title");
		String bbs_diff=req.getParameter("bbs_diff");
		String bbs_contents=req.getParameter("bbs_contents");
		String bbs_id=req.getParameter("bbs_id");

		dto.setBbs_title(bbs_title);
		dto.setBbs_diff(bbs_diff);
		dto.setBbs_contents(bbs_contents);
		dto.setBbs_id(bbs_id);		

		int cnt=dao.create(dto);

		ModelAndView mav=new ModelAndView();
	
		if(cnt==0) {

			mav.setViewName("notice/noticeForm");
		}else {
		
			mav.setViewName("redirect:/noticeList.do");
		}//if end
		
		return mav;
		
	}//creatProc() end
	
	
	
	
	@RequestMapping(value = "noticeRead.do")
	public ModelAndView read(int bbs_num) {
		ModelAndView mav = new ModelAndView();
		NoticeDTO dto = dao.read(bbs_num);
		
		mav.addObject("dto", dto);
		mav.setViewName("notice/noticeRead");		
		return mav;
	}
	

	@RequestMapping(value="noticeUpdate.do", method=RequestMethod.GET)
	public ModelAndView update(HttpServletRequest req, HttpSession session) {

		ModelAndView mav=new ModelAndView();
		int bbs_num = Integer.parseInt(req.getParameter("bbs_num"));
		
		NoticeDTO dto = dao.read(bbs_num);
		
		//System.out.println(dto);

		mav.setViewName("notice/noticeUpdate");
		mav.addObject("dto", dto);

		return mav;
	}//update() end
	
	
	@RequestMapping(value="noticeUpdate.do", method=RequestMethod.POST)
	public ModelAndView updateproc(@ModelAttribute NoticeDTO dto, HttpServletRequest req) {
		
		ModelAndView mav=new ModelAndView();
		
		int cnt = dao.updateproc(dto);
		
		//System.out.println(dto);
		
		if(cnt==0) {
			System.out.println(cnt);
			mav.setViewName("notice/noticeUpdate");
		}else {
			System.out.println(cnt);
			//mav.setViewName("notice/noticeList");
			mav.setViewName("redirect:/noticeList.do");
		}//if end
		
		return mav;
	}//updateProc() end
	
	
	
	
	
	
	@RequestMapping(value="noticeDel.do", method=RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest req, HttpSession session) {
		System.out.println("ddd");
		ModelAndView mav=new ModelAndView();
		int bbs_num = Integer.parseInt(req.getParameter("bbs_num"));
		
		NoticeDTO dto = dao.read(bbs_num);

		mav.setViewName("notice/noticeDel");
		mav.addObject("dto", dto);
	
		

		return mav;
	}//delete() end

	
	
	@RequestMapping(value="noticeDel.do", method=RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute NoticeDTO dto, HttpServletRequest req) {
		
		ModelAndView mav=new ModelAndView();
		
		int cnt = dao.delete(dto);
		
		//System.out.println(dto);
		
		if(cnt==0) {
			System.out.println(cnt);
			mav.setViewName("notice/noticeDel");
		}else {
			System.out.println(cnt);
			mav.setViewName("redirect:/noticeList.do");
		}//if end
		
		return mav;
	}//deleteproc() end
	
	


	
	
	
	
	
	
	
	
	
	
}//class end
