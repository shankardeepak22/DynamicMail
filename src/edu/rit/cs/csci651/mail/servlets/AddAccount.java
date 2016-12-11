package edu.rit.cs.csci651.mail.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.rit.cs.csci651.mail.model.ExchangeServerSettings;
import edu.rit.cs.csci651.mail.model.User;
import edu.rit.cs.csci651.mail.service.IMAPReceiver;

/**
 * Servlet implementation class AddAccount
 */
@WebServlet("/AddAccount")
public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static User user;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("addAccount.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ExchangeServerSettings settings = new ExchangeServerSettings();
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		String serverType = request.getParameter("accountType");
		String serverName = request.getParameter("mailServerName");
		int serverPort = Integer.parseInt(request.getParameter("portMail"));
		String smtpServerName = request.getParameter("smtpServer");
		int smtpServerPort = Integer.parseInt(request.getParameter("smtpPortNum"));

		System.out.println(username);
		System.out.println(password);
		System.out.println(serverType);
		System.out.println(serverName);
		System.out.println(serverPort);
		System.out.println(smtpServerName);
		// System.out.println(smtpServerPort);
		user = new User(username, password);
		settings.setSmtpServerAddress(smtpServerName);
		settings.setSmtpPort(smtpServerPort);
		settings.setSslRequired(true);
		if (serverType.equals("IMAP")) {
			settings.setImapServerAddress(serverName);
			settings.setImapPort(serverPort);
		} else {
			settings.setPopPort(serverPort);
			settings.setPopServerAddress(serverName);
		}
		user.setMailServerSettings(settings);
		if(serverType.equals("IMAP")){
			request.setAttribute("mxtype", "imap");
			IMAPReceiver receiver = new IMAPReceiver(user);
			receiver.getImapFoldersForUser();
			request.setAttribute("user", user);
		}
		else{
			request.setAttribute("mxtype", "pop");
		}
		//System.out.println(user);
		System.out.println(serverType.equals("IMAP"));
		request.setAttribute("User", user);
		request.getRequestDispatcher("mailbox.jsp").forward(request, response);
	}

}
