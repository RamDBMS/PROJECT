<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "addUser">
Enter ID <input type ="text" name="id"> <br>
Enter Name <input type="text" name="name"> <br>
<input type = "submit"> <br>
</form>

<h2> Display User Information</h2>
<form action ="getUser">
Enter ID<input type="text" name="id"> <br>
<input type ="submit"> <br>
</form>

<h2>Enter Details to Delete</h2>
<form action = "deleteUser">
Enter Id <input type = "text" name ="id"> <br>
<input type ="submit"> <br>
</form>


<form action ="updateUser">

Enter Id <input type = "text" name = "id"> <br>
<input type ="submit"> <br>


</form>

</body>
</html>