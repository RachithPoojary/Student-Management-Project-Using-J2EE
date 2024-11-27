<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<link rel="stylesheet" type="text/css" href="loginStyle.css">
<body>
 <div class="container">
    <h2>Welcome!!!</h2>
    <p><%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %></p>
    <h2>Click here if you want to see the Details</h2>
    <form action="DetailsServlet" method="get">
        <input type="hidden" name="email" value="<%= session.getAttribute("email") %>">
        <input type="submit" value="Details">
    </form>
        <h2>Click here if you want to Update the Details</h2>
    
    <form action="update.jsp" method="get">
        <input type="hidden" name="email" value="<%= session.getAttribute("email") %>">
        <input type="submit" value="Update">
    </form>
        <h2>Click here if you want to Delete the Details</h2>
    
    <form action="DeleteServlet" method="post">
        <input type="hidden" name="email" value="<%= session.getAttribute("email") %>">
        <input type="submit" value="Delete">
    </form>
    </div>
</body>
</html>
