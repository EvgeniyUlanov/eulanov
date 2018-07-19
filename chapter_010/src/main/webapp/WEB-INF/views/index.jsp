<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Items</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="resources/js/myScript.js"></script>
</head>
<body>
<div class="container">
    <label for="itemName">Item name:</label>
    <input id="itemName" placeholder="enter item name">
    <label for="itemDescription">Item description</label>
    <input id="itemDescription" placeholder="enter item description">
    <button class="btn btn-primary"
            onclick="AddItem($('#itemName').val(), $('#itemDescription').val())">Add new Item
    </button>
</div>
<div class="container">
    <button class="btn btn-primary" onclick="GetAllItems()">Get items</button>
    <label for="isDone">All items</label>
    <input id="isDone" type="checkbox" onclick="HideIsDone()" checked>
</div>
<div class="container">
    <h1>Items</h1>
    <div>
        <table class="table" id="table">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Created</th>
                <th>Is done</th>
                <th>Finish</th>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
