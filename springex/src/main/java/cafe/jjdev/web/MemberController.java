package cafe.jjdev.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.web.service.Member;
import cafe.jjdev.web.service.MemberDao;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value="/memberList")
	public String memberList() {
		System.out.println("List!!!!!!!");
		return "memberList";
		//db���� ����Ʈ ��������
	}
	
	@RequestMapping(value="/addMember", method = RequestMethod.POST)
	public String addMember(MemberRequest memberRequest) {
		System.out.println(memberRequest);
		//db�� �ֱ�
		return "redirect:/memberList"; // request.sendRedirect("/memberList") 
		//redirect: ~ ����� ���û�ϰڴ�.
		
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
