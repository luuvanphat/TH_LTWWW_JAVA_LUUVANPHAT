package iuh.fit.se.bai1jspform;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/registration-form")
public class RegistrationForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegistrationForm() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8"); // Đảm bảo nhận Unicode từ form

        // 1. Lấy dữ liệu cá nhân
        String fname = request.getParameter("txtFName");
        String lname = request.getParameter("txtLName");
        String email = request.getParameter("txtEmail");
        String mobileNumber = request.getParameter("txtMobileNumber");
        String gender = request.getParameter("gender");

        // 2. Ngày sinh từ dropdown
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String birthdate = day + "/" + month + "/" + year;

        // 3. Địa chỉ liên hệ
        String address = request.getParameter("txtAddress");
        String city = request.getParameter("txtCity");
        String pincode = request.getParameter("txtPincode");
        String state = request.getParameter("txtState");
        String country = request.getParameter("txtCountry");

        // 4. Course apply
        String course = request.getParameter("txtCourse");

        // 5. Hobbies: checkbox
        String[] hobbiesArray = request.getParameterValues("chkHobbies");
        String otherHobby = request.getParameter("txtOtherHobby");
        StringBuilder hobbiesBuilder = new StringBuilder();
        if (hobbiesArray != null) {
            for (String hobby : hobbiesArray) {
                hobbiesBuilder.append(hobby).append(", ");
            }
        }
        if (otherHobby != null && !otherHobby.isBlank()) {
            hobbiesBuilder.append(otherHobby);
        }
        String hobbies = hobbiesBuilder.toString().replaceAll(", $", "");
        String[] exams = {"Class X", "Class XII", "Graduation", "Masters"};
        List<Qualification> qualifications = new ArrayList<>();

        for (int i = 0; i < exams.length; i++) {
            String board = request.getParameter("board" + i);
            String percent = request.getParameter("percent" + i);
            String yearQualification = request.getParameter("year" + i);

            Qualification q = new Qualification(exams[i], board, percent, yearQualification);
            qualifications.add(q);
        }
        // 6. Tạo đối tượng Student
        Student sv = new Student();
        sv.setFirstName(fname);
        sv.setLastName(lname);
        sv.setEmail(email);
        sv.setMobileNumber(mobileNumber);
        sv.setGender(gender);
        sv.setBirthdate(birthdate);
        sv.setAddress(address);
        sv.setCity(city);
        sv.setPincode(pincode);
        sv.setState(state);
        sv.setCountry(country);
        sv.setCourse(course);
        sv.setHobbies(hobbies);
        sv.setQualifications(qualifications);

        // 7. Đưa vào request
        request.setAttribute("student", sv);

        // 8. Forward đến kết quả
        RequestDispatcher rd = request.getRequestDispatcher("result-form.jsp");
        rd.forward(request, response);
    }
}
