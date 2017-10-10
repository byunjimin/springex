package cafe.jjdev.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.web.service.Member;
import cafe.jjdev.web.service.MemberDao;
import cafe.jjdev.web.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberService memberService;
	
	//회원전용 페이지
	@RequestMapping(value="/test")
	public String test(HttpSession session) {
		if(session.getAttribute("loginmember") == null) {
			return "redirect:/login";
		}
		return "test";
	}
	
	//로그아웃
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	
	//로그인폼
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginform(HttpSession session) {
		if(session.getAttribute("loginmember") == null) {
		return "login";
		}else {
		return "redirect:/test";
		}
	}
	
	//로그인처리
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginform(Member member, HttpSession session) {
		Member loginmember = memberDao.login(member);
		System.out.println("loginmember>>>>>>>" + loginmember);
		if(loginmember == null) {
			
			return "redirect:/login";
		}else{
			//session 로그인 정보를 저장
			session.setAttribute("loginmember", loginmember);
			return "redirect:/test";
		}

	}
	
	
	
	@RequestMapping(value="/memberList")
	public String memberList(Model model) {
		System.out.println("List!!!!!!!");
		List<Member> list = memberDao.selectMemberList();
		model.addAttribute("list", list);
		return "memberList";
		//db에서 리스트 가져오기
	}
	
	@RequestMapping(value="/addMember", method = RequestMethod.POST)
	public String addMember(MemberRequest memberRequest) {
		System.out.println(memberRequest);
		memberService.addMember(memberRequest);
		return "redirect:/memberList"; // request.sendRedirect("/memberList") 
		//redirect: ~ 여기로 재요청하겠다.
		
	}
	/*
	public String addMember(@RequestParam(value="memberId") String memberId,
							@RequestParam(value="memberPw") String memberPw,
							@RequestParam(value="memberName") String memberName) {
		return "";
	}
	*/
	
	@RequestMapping(value="/addMember", method = RequestMethod.GET)
	public String addMember() {
		return "addMember";
	}
	
	@RequestMapping("/getMember")
	public String getMember(Model model) {
		Member member = memberDao.selectMemberOne(2);
		model.addAttribute("member", member);
		return "getMember";
	}
}
