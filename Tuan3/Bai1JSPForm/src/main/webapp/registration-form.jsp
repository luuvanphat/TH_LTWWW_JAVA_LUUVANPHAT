<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/7/2025
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration Form</title>
    <style>
        body {
            background-color: #aee3f7;
            font-family: Arial, sans-serif;
        }

        .container {
            background-color: #d0edf7;
            width: 800px;
            margin: 30px auto;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
        }

        h2 {
            text-align: center;
            color: #333;
        }

        table {
            width: 100%;
        }

        td {
            padding: 8px;
            vertical-align: top;
        }

        input[type="text"],
        input[type="email"],
        select,
        textarea {
            width: 95%;
            padding: 6px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        textarea {
            resize: vertical;
        }

        .hobbies input,
        .gender input,
        .course input {
            width: auto;
            margin-right: 5px;
        }

        .qualification-table {
            border: 2px solid #0051a2;
            border-collapse: collapse;
            width: 100%;
            margin-top: 10px;
        }

        .qualification-table th,
        .qualification-table td {
            border: 1px solid #0051a2;
            padding: 8px;
            text-align: center;
        }

        .buttons {
            text-align: center;
            margin-top: 20px;
        }

        input[type="submit"],
        input[type="reset"] {
            padding: 10px 20px;
            margin: 5px;
            border: none;
            border-radius: 5px;
            background-color: #0288d1;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #0277bd;
        }

        small {
            color: #555;
            font-style: italic;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Student Registration Form</h2>
    <form action="registration-form" method="get">

        <table>
            <tr>
                <td>First name:</td>
                <td>
                    <input type="text" name="txtFName" maxlength="30" required />
                    <small>(max 30 characters a-z and A-Z)</small>
                </td>
            </tr>

            <tr>
                <td>Last name:</td>
                <td>
                    <input type="text" name="txtLName" maxlength="30" required />
                    <small>(max 30 characters a-z and A-Z)</small>
                </td>
            </tr>

            <tr>
                <td>Date of birth:</td>
                <td>
                    <select name="day">
                        <% for (int i = 1; i <= 31; i++) { %>
                        <option value="<%=i%>"><%=i%></option>
                        <% } %>
                    </select>
                    <select name="month">
                        <% for (int i = 1; i <= 12; i++) { %>
                        <option value="<%=i%>"><%=i%></option>
                        <% } %>
                    </select>
                    <select name="year">
                        <% for (int i = 1980; i <= 2010; i++) { %>
                        <option value="<%=i%>"><%=i%></option>
                        <% } %>
                    </select>
                </td>
            </tr>

            <tr>
                <td>Email:</td>
                <td><input type="email" name="txtEmail" required /></td>
            </tr>

            <tr>
                <td>Mobile number:</td>
                <td>
                    <input type="text" name="txtMobileNumber" maxlength="10" />
                    <small>(10 digit number)</small>
                </td>
            </tr>

            <tr>
                <td>Gender:</td>
                <td class="gender">
                    <input type="radio" name="gender" value="Male" checked /> Male
                    <input type="radio" name="gender" value="Female" /> Female
                </td>
            </tr>

            <tr>
                <td>Address:</td>
                <td><textarea name="txtAddress" rows="3" cols="30"></textarea></td>
            </tr>

            <tr>
                <td>City:</td>
                <td>
                    <input type="text" name="txtCity" maxlength="30" />
                    <small>(max 30 characters a-z and A-Z)</small>
                </td>
            </tr>

            <tr>
                <td>Pin code:</td>
                <td>
                    <input type="text" name="txtPincode" maxlength="6" />
                    <br>
                    <small>(6 digit number)</small>
                </td>
            </tr>

            <tr>
                <td>State:</td>
                <td>
                    <input type="text" name="txtState" maxlength="30" />
                    <small>(max 30 characters a-z and A-Z)</small>
                </td>
            </tr>

            <tr>
                <td>Country:</td>
                <td>
                    <input type="text" name="txtCountry" maxlength="40" />
                </td>
            </tr>

            <tr>
                <td>Hobbies:</td>
                <td class="hobbies">
                    <input type="checkbox" name="chkHobbies" value="Drawing" /> Drawing
                    <input type="checkbox" name="chkHobbies" value="Singing" /> Singing
                    <input type="checkbox" name="chkHobbies" value="Dancing" /> Dancing
                    <input type="checkbox" name="chkHobbies" value="Sketching" /> Sketching
                    <input type="checkbox" name="chkHobbies" value="Others" /> Others
                    <input type="text" name="txtOtherHobby" />
                </td>
            </tr>

            <tr>
                <td>Qualification:</td>
                <td>
                    <table class="qualification-table">
                        <tr>
                            <th>Sl.No.</th>
                            <th>Examination</th>
                            <th>Board</th>
                            <th>Percentage</th>
                            <th>Year of Passing</th>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Class X</td>
                            <td><input type="text" name="board1" maxlength="10" /></td>
                            <td><input type="text" name="percent1" /></td>
                            <td><input type="text" name="year1" /></td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>Class XII</td>
                            <td><input type="text" name="board2" maxlength="10" /></td>
                            <td><input type="text" name="percent2" /></td>
                            <td><input type="text" name="year2" /></td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>Graduation</td>
                            <td><input type="text" name="board3" maxlength="10" /></td>
                            <td><input type="text" name="percent3" /></td>
                            <td><input type="text" name="year3" /></td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>Masters</td>
                            <td><input type="text" name="board4" maxlength="10" /></td>
                            <td><input type="text" name="percent4" /></td>
                            <td><input type="text" name="year4" /></td>
                        </tr>
                    </table>
                </td>
            </tr>

            <tr>
                <td>Course applies for:</td>
                <td class="course">
                    <input type="radio" name="txtCourse" value="BCA" /> BCA
                    <input type="radio" name="txtCourse" value="B.Com" /> B.Com
                    <input type="radio" name="txtCourse" value="B.Sc" /> B.Sc
                    <input type="radio" name="txtCourse" value="B.Sc" /> B.Sc
                    <input type="radio" name="txtCourse" value="B.A" /> B.A
                </td>
            </tr>

            <tr>
                <td colspan="2" class="buttons">
                    <input type="submit" value="Submit" />
                    <input type="reset" value="Reset" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>




