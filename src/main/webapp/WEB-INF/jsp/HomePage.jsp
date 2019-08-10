<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
</head>
<style>
    .button {
        background-color: white;
        border: ;
        color: black;
        padding: 10px 20px;
        text-align: center;
        font-size: 16px;
        font-family: Comic sans MS;
        cursor: pointer;
    }

    .button:hover {
        background-color: lightgrey;
    }

    .button:active {
        background-color: grey;
    }

</style>

<title>Log Analyzer</title>
</head>

<body style="background-color:black;color:white;text-align:center;padding:200px 200px;">


<h1><i>LOG ANALYZER</i></h1>
<form action="/output" method="post" enctype="multipart/form-data">
<input class="btn btn1" type="file" name="files">Upload File Here</input>
    <button class="btn btn2" type="submit">Submit</button>
</form>
</body>
</html>
