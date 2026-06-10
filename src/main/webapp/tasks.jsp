<%@ page import="java.util.*, model.ToDo" %>

<html>
<head>
    <title>To-Do List</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            margin: 0;
            padding: 0;
        }

        /* Header */
        .header {
            background: #2c3e50;
            color: white;
            padding: 15px 25px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header b {
            font-size: 18px;
        }

        .header a {
            color: #ffcc00;
            text-decoration: none;
            margin-left: 10px;
        }

        .container {
            width: 80%;
            margin: 30px auto;
        }

        /* Form Card */
        .card {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            margin-bottom: 20px;
        }

        input[type="text"], select {
            padding: 8px;
            margin: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"], button {
            padding: 8px 12px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"] {
            background: #3498db;
            color: white;
        }

        input[type="submit"]:hover {
            background: #2980b9;
        }

        /* Table */
        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            border-radius: 10px;
            overflow: hidden;
        }

        th {
            background: #34495e;
            color: white;
            padding: 12px;
            text-align: left;
        }

        td {
            padding: 12px;
            border-bottom: 1px solid #eee;
        }

        tr:hover {
            background: #f9f9f9;
        }

        /* Buttons */
        .delete-btn {
            background: #e74c3c;
            color: white;
        }

        .delete-btn:hover {
            background: #c0392b;
        }

        .status-btn {
            color: black;
        }

        .done {
            text-decoration: line-through;
            color: gray;
        }
    </style>
</head>

<body>

<div class="header">
    <div><b>To-Do List</b></div>
    <div>
        Welcome, <%= session.getAttribute("username") %> |
        userId: <%= session.getAttribute("userId") %>
        <a href="logout">Logout</a>
    </div>
</div>

<div class="container">

    <div class="card">
        <h3>Add New To-Do</h3>

        <form action="todo" method="post">
            <input type="hidden" name="action" value="add" />

            <input type="text" name="title" placeholder="Enter To-Do" required />

            <select name="status">
                <option value="pending">Pending</option>
                <option value="done">Done</option>
            </select>

            <input type="submit" value="Add To-Do" />
        </form>
    </div>

    <table>
        <tr>
            <th >ID</th>
            <th>Title</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>

        <%
            List<ToDo> list = (List<ToDo>) request.getAttribute("taskList");

            if (list != null && !list.isEmpty()) {
                for (ToDo t : list) {
        %>

        <tr>
            <td><%= t.getId() %></td>

            <td>
                <span class="<%= "done".equals(t.getStatus()) ? "done" : "" %>">
                    <%= t.getTitle() %>
                </span>
            </td>

            <td>
                <form action="todo" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="updateStatus" />
                    <input type="hidden" name="id" value="<%= t.getId() %>" />
                    <input type="hidden" name="status"
                        value="<%= "done".equals(t.getStatus()) ? "pending" : "done" %>" />

                    <button class="status-btn"
                        style="background:<%= "done".equals(t.getStatus()) ? "#2ecc71" : "#f1c40f" %>;">
                        <%= t.getStatus() %>
                    </button>
                </form>
            </td>

            <td>
                <form action="todo" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete" />
                    <input type="hidden" name="id" value="<%= t.getId() %>" />
                    <input type="submit" value="Delete" class="delete-btn"
                           onclick="return confirm('Are you sure?');"/>
                </form>
            </td>
        </tr>

        <%
                }
            } else {
        %>

        <tr>
            <td colspan="4" style="text-align:center;">No To-Do's found</td>
        </tr>

        <%
            }
        %>

    </table>

</div>

</body>
</html>