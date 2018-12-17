<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container" style="text-align: center">

    <div style="text-align: right; margin-bottom: 15px;">
        <form method="GET" action="${contextPath}/viewAll" style="display: inline; width: 200px;">
            <button class="btn btn-view-all" type="submit">Back</button>
        </form>
    </div>

    <div class="row">

        <div class="col-xs-12">
            <div class="panel panel-default">

                <div class="panel-heading" style="background-color:#abeabe"> ${image.image_name}</div>
                <div class="panel-body">
                    ${image.description}
                </div>
                <div class="panel-footer" style="background-color:#33bf71; color: #fff"> ${image.author}</div>
            </div>
        </div>

    </div>

    <div class="row">
        <div class="col-xs-12 ">
            <div class="panel panel-default">
                <div class="panel-heading" style="background-color:#abeabe">Tags</div>
                <c:forEach var="tag" items="${image.tags}">
                    <div class="panel-body">
                            ${tag.tagName}
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

    <form method="POST" action="${contextPath}/addRating">

        <div style="margin-top: 15px;">

            <h2>Put your assessment</h2>

            <div class="row" style="margin-bottom: 15px;">

                <div class="col-xs-12">
                    <input type="radio" id="1" style="margin: 15px;" name="mark" value="1" checked>
                    <label for="1">1</label>

                    <input type="radio" id="2" style="margin: 15px;" name="mark" value="2">
                    <label for="2">2</label>

                    <input type="radio" id="3" style="margin: 15px;" name="mark" value="3">
                    <label for="3">3</label>

                    <input type="radio" id="4" style="margin: 15px;" name="mark" value="4">
                    <label for="4">4</label>

                    <input type="radio" id="5" style="margin: 15px;" name="mark" value="5">
                    <label for="5">5</label>
                </div>


            </div>

            <div class="row">
                <div class="col-xs-12">
                    <textarea type="text" class="form-control" placeholder="Rating comment"
                              autofocus="true" name="reviewText" style="height:150px;resize:none"></textarea>

                </div>
            </div>

            <div class="row">
                <div class="col-xs-12" style="margin-top: 10px;">
                    <input type="text" class="form-control" placeholder="Your login" name="login"/>
                </div>
            </div>

            <input type="hidden" name="imageID" class="form-control" value="${image.imageID}"/>

            <div class="${error != null ? 'has-error' : ''}">
                <span>${error}</span>
            </div>
            <div class="row" style="margin-top: 15px;">

                <div class="col-xs-12">
                    <button type="submit" class="btn btn-default" style="background-color:#33bf71; color: #fff">Add
                        review
                    </button>
                </div>
            </div>
        </div>
    </form>

    <div style="margin-top: 60px">
        <c:forEach var="rating" items="${ratings}">

            <div class="panel panel-default" style="margin: 20px;">
                <div class="panel-body" style="background-color:#abeabe">
                    Mark: ${rating.mark}
                </div>
                <div class="panel-body">
                        ${rating.comment}
                </div>
                <div class="panel-footer" style="background-color:#33bf71; color: #fff">
                        ${rating.account.firstName}
                        ${rating.account.surname}</div>
            </div>
        </c:forEach>
    </div>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
