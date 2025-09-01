package iuh.fit.se.bai2uploadfiles;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet("/upload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class UploadServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Tạo thư mục lưu file trên server (nếu chưa có)
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Uploaded Files:</h2>");

        // Lấy danh sách các file từ form
        Collection<Part> parts = request.getParts();
        for (Part part : parts) {
            if (part.getSubmittedFileName() != null && !part.getSubmittedFileName().isEmpty()) {
                String fileName = part.getSubmittedFileName();
                part.write(uploadPath + File.separator + fileName);
                out.println("<p>Uploaded: " + fileName + "</p>");
            }
        }

        out.println("<p>Files are saved at: " + uploadPath + "</p>");
    }
}
