<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=yes;">
        <link href="${path}/resources/css/groupHome.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        <div class="group-info">
            <h1 class="group-name">${groupInfo.g_name}</h1>
            <div class="group-details-top">
                <span class="group-requiredTag">#${groupInfo.g_requiredTag}</span>
                <span class="group-members">${groupInfo.memberCount}/${groupInfo.g_maxpeople}명</span>
                <span class="group-leader">${groupInfo.g_leaderName}</span>
            </div>
            <hr>
                <div class="group-details-bottom">
                    <div class="group-tag"># ${groupInfo.g_tag}</div>
                    <div class="group-description">${groupInfo.g_content}</div>
                </div>
        </div>
        <button class="signupButton" onclick="groupJoin(${groupInfo.g_no})">가입하기</button>

        <script>
            function groupJoin(gNo) {
                var groupNo = gNo;
                var form = document.createElement("form");
                form.method = "POST";
                form.action = "/group/join";

                var input = document.createElement("input");
                input.type = "hidden";
                input.name = "groupNo";
                input.value = groupNo;
                form.appendChild(input);

                document.body.appendChild(form);
                form.submit();
            }
        </script>
    </body>
</html>