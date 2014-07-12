package com.tianle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tianle.model.Enroll;

public class EnrollClServlet extends HttpServlet {

	/**
	 * 
	 */

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * response.setContentType("text/html");
		 * response.setCharacterEncoding("utf-8");
		 * 
		 * // String name = request.getParameter("name"); // name = new
		 * String(name.getBytes("utf-8")); String name= new
		 * String(request.getParameter("name").toString().getBytes("iso8859_1"),
		 * "GBK"); String s_num = request.getParameter("num"); String myclass =
		 * request.getParameter("myclass"); String phone =
		 * request.getParameter("phone"); String declaration =
		 * request.getParameter("comment");
		 * 
		 * int num = Integer.parseInt(s_num);
		 * 
		 * Enroll enroll = new Enroll(); if(enroll.enrollDatebase(name, num,
		 * myclass, phone, declaration)) { response.sendRedirect("success.jsp");
		 * } else { response.sendRedirect("error.jsp"); }
		 */
		this.doPost(request, response);

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String name = new String(request.getParameter("name").toString()
				.getBytes("iso8859-1"), "utf-8");
		String s_num = new String(request.getParameter("num").toString()
				.getBytes("iso8859-1"), "utf-8");
		String myclass = new String(request.getParameter("myclass").toString()
				.getBytes("iso8859-1"), "utf-8");
		String phone = new String(request.getParameter("phone").toString()
				.getBytes("iso8859-1"), "utf-8");
		String declaration = new String(request.getParameter("comment")
				.toString().getBytes("iso8859-1"), "utf-8");

		// String name = request.getParameter("name");
		out.println("servlet“≥√Ê" + name);
		out.println();
		/*
		 * String s_num = request.getParameter("num"); String myclass =
		 * request.getParameter("myclass"); String phone =
		 * request.getParameter("phone"); String declaration =
		 * request.getParameter("comment");
		 */

		int num = Integer.parseInt(s_num);
//		String name;
//		String s_num;
//		String myclass;
//		String phone;
//		String declaration;
//		int num;

		Enroll enroll = new Enroll();
		
//		String confirm = request.getParameter("confirm");
		
		if (enroll.enrollDatebase(name, num, myclass, phone, declaration)) {
			response.sendRedirect("success.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}

	}

}
