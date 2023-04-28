<html>
<head>
    <title>Employee Details</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<style>
    .badge{
        padding: 20px;
        font-size: 1rem;
        font-weight: 500;
        margin: 10px 10px 0 20px;
    }
</style>
<body>

<form method="POST" action="employee" class="d-flex p-2 justify-content-center align-items-center">

    <table width="400px" border="1" class="table table-striped">
        <thead class="thead-dark">
            <th colspan="2"><h1>Student Registation</h1> </th>
        </thead>

        <tr>
            <td>Student ID</td>
            <td><input type="text" name="id" id="id"  placeholder="Enrollment No"></td>
        </tr>

        <tr>
            <td>Firstname</td>
            <td><input type="text" name="Fname" id="Fname" placeholder="Enter your First Name"></td>
        </tr>

        <tr>
            <td>Lastname</td>
            <td><input type="text" name="lname" id="lname" placeholder="Enter your last name"></td>
        </tr>

        <tr>
            <td>Branch</td>
            <td><input type="text" name="branch" id="branch" placeholder="Enter your branch"></td>
        </tr>

        <tr>
            <td>Mobile No</td>
            <td><input type="number" name="mno" id="mno" placeholder="Enter your mobile number"></td>
        </tr>

        <tr>
            <td>Email ID</td>
            <td><input type="email" name="email" id="email" placeholder="Enter your email id"></td>
        </tr>

        <tr>
            <td colspan="2"> <input type="submit" value="submit" class="btn btn-primary btn-block"></td>

        </tr>


    </table>


</form>
<a class="badge badge-primary" href="viewemployee">View Students</a>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>