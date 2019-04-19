package com.apress.projsp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PopulateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {

		Person p = new Person();
		p.setName("Shuvo");
		p.setAge(26);

		Address a = new Address();
		a.setLine1("111 Central Road");
		a.setTown("Dhaka");
		a.setCounty("BD");
		a.setPostcode("1105");

		ArrayList al = new ArrayList();
		PhoneNumber ph = new PhoneNumber();
		ph.setStd("01717");
		ph.setNumber("677451");
		
		al.add(ph);
		
		ph = new PhoneNumber();
		ph.setStd("01521");
		ph.setNumber("252064");		
		al.add(ph);
		a.setPhoneNumbers(al);
		
		p.setAddress(a);

		req.setAttribute("person", p);

		RequestDispatcher rd = req.getRequestDispatcher("complexbean.jsp");
		rd.forward(req, res);

	}
}
