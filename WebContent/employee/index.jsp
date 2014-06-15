<!DOCTYPE HTML>

<html>
<head>
<title>Add Employee</title>
</head>
<body>
	${notice}
	<form action="/estudo-cdi/employeeServlet">
		<input type="hidden" name="action" value="add" /><br />
		Name: <input type="text" name="name" /><br />
		Age: <input type="text" name="age" /><br />
		
		<input type="submit" value ="Save" />
	</form>

	<form action="/estudo-cdi/employeeServlet">
		<input type="hidden" name="action" value="show" /><br />
		Id Employee: <input type="text" name="id" /><br />
		
		<input type="submit" value ="Show" />
	</form>
	
</body>
</html>