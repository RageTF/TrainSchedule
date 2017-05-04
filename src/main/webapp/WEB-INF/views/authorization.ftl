<#--Created by IntelliJ IDEA.
User: Rage
Date: 25.04.2017
Time: 14:06
To change this template use File | Settings | File Templates.-->
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<html>
<head>
    <title>Train Schedule</title>

    <link href='https://fonts.googleapis.com/css?family=PT+Mono' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="/resources/css/themify-icons.css"/>
    <link rel="stylesheet" href="/resources/css/icomoon-icons.css">
    <link rel="stylesheet" href="/resources/css/bootstrap.css"/>
    <link rel="stylesheet" href="/resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="/resources/css/magnific-popup.css"/>
    <link rel="stylesheet" href="/resources/css/easy-responsive-tabs.css">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/form.css">
    <link rel="stylesheet" href="/resources/css/search_form.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>


    <script src="/resources/js/modernizr-2.6.2.min.js"></script>
    <script src="/resources/js/respond.min.js"></script>


</head>

<body class="fh5co-outer">
<header id="fh5co-header" role="banner">

    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle" data-toggle="collapse"
                   data-target="#fh5co-navbar" aria-expanded="false" aria-controls="navbar"><i></i></a>
                <div class="navbar-brand">TRAIN SCHEDULE</div>
            </div>
            <div id="fh5co-navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="/">TIMETABLE</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/registration" class="btn btn-calltoaction btn-primary">Registration</a></li>
                </ul>
            </div>
        </div>
    </nav>

</header>

<main role="main" id="fh5co-main">

    <div class="container">
        <div class="row main">
            <div class="main-login main-center">
                <form class="form-horizontal" method="post" action="/j_spring_security_check">

                    <div class="form-group">
                        <label for="username" class="cols-sm-2 control-label">Username</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="j_username" id="username"
                                       placeholder="Enter your Username"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password" class="cols-sm-2 control-label">Password</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg"
                                                                   aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="j_password" id="password"
                                       placeholder="Enter your Password"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group ">
                        <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Log in</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</main>

<footer role="contentinfo" id="fh5co-footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="text-center">
                    <h3 class="footer-heading">About Us</h3>
                    <p>We provide you with train timetables from around the world.</p>
                    <p class="text-right">
                        <small>Khan Yuri 11-504<br> &copy;
                            2017 Kazan
                        </small>
                    </p>
                </div>
            </div>
        </div>
    </div>
</footer>

<script src="/resources/js/jquery-1.10.2.min.js"></script>
<script src="/resources/js/jquery.easing.1.3.js"></script>
<script src="/resources/js/bootstrap.js"></script>
<script src="/resources/js/owl.carousel.min.js"></script>
<script src="/resources/js/jquery.magnific-popup.min.js"></script>
<script src="/resources/js/easyResponsiveTabs.js"></script>
<script src="/resources/js/fastclick.js"></script>
<script src="/resources/js/main.js"></script>

</body>
</html>
