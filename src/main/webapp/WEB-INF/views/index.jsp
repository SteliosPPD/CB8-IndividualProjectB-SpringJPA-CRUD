<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <style>
            body {background-color: #ccffff;}

            .button {
                display: inline-block;
                padding: 15px 25px;
                font-size: 24px;
                cursor: pointer;
                text-align: center;
                text-decoration: none;
                outline: none;
                color: #fff;
                background-color: #99ccff;
                border: none;
                border-radius: 15px;
                box-shadow: 0 9px #999;
                position: fixed;
                top:30%;
                left: 50%;
                transform: translate(-50%, -50%);
            }

            .button:hover {background-color: #3399ff}

            .button:active {
                background-color: #3e8e41;

            }
        </style>
    </head>
    <body>

        <button class="button">
            <a href="trainerlist" class="page-link">CRUD Trainers</a>
        </button>

    </body>
</html>