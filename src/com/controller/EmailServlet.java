package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.configurations.AppConfig;
import com.model.EmailModel;

/**
 * Servlet implementation class EmailServlet
 */
@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmailServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fromName = request.getParameter("fromMail");
        String toName = request.getParameter("toMail");
        String subject = request.getParameter("subject");
        String keywords = request.getParameter("keywords");
        String dept = request.getParameter("dept");
        String body = request.getParameter("body");

        // Create email model
        EmailModel em = AppConfig.getEmailModel();
        em.setFromEmail(fromName);
        em.setToEmail(toName);
        em.setSubject(subject);
        em.setDept(dept);
        em.setBody(body);
        em.setKeywords(keywords);

        // Send email via SMTP server
        boolean emailSent = sendEmail(fromName, toName, subject, body);

        try {
            boolean status = AppConfig.getEmailService().insertEmail(em);
            if (status && emailSent) {
                String info = "<div class=\"alert alert-success wrap-input100\">\n" +
                        "    <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center; color:#000;\">\n" +
                        "        Email sent Successfully!\n" +
                        "    </p>\n" +
                        "</div>";
                request.setAttribute("info", info);
                request.getRequestDispatcher("sendemail.jsp?page=send").forward(request, response);
            } else {
                String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
                        "    <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
                        "        Something went wrong! Email not sent or Invalid email address.\n" +
                        "    </p>\n" +
                        "</div>";
                request.setAttribute("alert", alert);
                request.getRequestDispatcher("sendemail.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Method to send email using SMTP
    private boolean sendEmail(String fromEmail, String toEmail, String subject, String body) {
        String host = "smtp.gmail.com";  // SMTP server host
        final String username = "testcheck639@gmail.com"; // Your email
        final String password = "gogbyinyorfdahiw"; // Your email password

        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        try {
            Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
