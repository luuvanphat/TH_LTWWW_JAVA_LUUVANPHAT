package iuh.fit.se.bai7javamail;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.servlet.http.Part;

import java.io.*;
import java.util.Properties;

@WebServlet("/sendMail")
@MultipartConfig
public class SendMailServlet extends HttpServlet {

    // Thay bằng email + app password của bạn
    private static final String SENDER_EMAIL = "your-email@gmail.com";
    private static final String SENDER_PASSWORD = "your-app-password"; // dùng App Password, không dùng password Gmail thường

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String to = req.getParameter("to");
        String subject = req.getParameter("subject");
        String body = req.getParameter("body");
        Part filePart = req.getPart("file");

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(SENDER_EMAIL, SENDER_PASSWORD);
                    }
                });

        try {
            MimeMessage message = new MimeMessage(session);

            // from, to
            message.setFrom(new InternetAddress(SENDER_EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // subject
            message.setSubject(subject);

            // body + attachment
            Multipart multipart = new MimeMultipart();

            // text body
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(body);
            multipart.addBodyPart(textPart);

            // file attachment
            if (filePart != null && filePart.getSize() > 0) {
                MimeBodyPart attachPart = new MimeBodyPart();
                attachPart.setFileName(filePart.getSubmittedFileName());
                attachPart.setDataHandler(new javax.activation.DataHandler(
                        new javax.activation.DataSource() {
                            @Override
                            public InputStream getInputStream() throws IOException {
                                return filePart.getInputStream();
                            }

                            @Override
                            public OutputStream getOutputStream() throws IOException {
                                throw new IOException("Read-only data");
                            }

                            @Override
                            public String getContentType() {
                                return filePart.getContentType();
                            }

                            @Override
                            public String getName() {
                                return filePart.getSubmittedFileName();
                            }
                        }
                ));
                multipart.addBodyPart(attachPart);
            }

            message.setContent(multipart);

            // gửi mail
            Transport.send(message);

            resp.getWriter().println("Email sent successfully!");
        } catch (MessagingException e) {
            throw new ServletException(e);
        }
    }
}
