package Mybatisfw.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mybatisfw.ex01.MemberVO;


@WebServlet("/member3.do")
public class MemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	private void doHandle (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberDAO memberDAO=new MemberDAO();
		MemberVO memberVO=new MemberVO();
		String action=request.getParameter("action");
		String nextPage="";
		if (action == null || action.equals("listMembers")) {
			List<MemberVO> memberList=memberDAO.selectAllMemberList();
			request.setAttribute("memberList", memberList);
			nextPage="memberinfo/listMembers.jsp";
		}else if (action.equals("selectMemberById")) {
			String id=request.getParameter("value");
			memberVO=memberDAO.selectMemberById(id);
			request.setAttribute("member", memberVO);
			nextPage="memberinfo/member.jsp";
		}else if (action.equals("selectMemberByName")) {
			String name=request.getParameter("value");
			List<MemberVO> memberList=memberDAO.selectAllMemberList();
			request.setAttribute("memberList", memberList);
			nextPage="memberinfo/listMembers.jsp";
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
}
