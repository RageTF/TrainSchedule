<#ftl encoding="UTF-8">
<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]/>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Train Schedule</title>
    <link rel="shortcut icon" href="favicon.ico">

    <link href='https://fonts.googleapis.com/css?family=PT+Mono' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="../../resources/css/themify-icons.css"/>
    <link rel="stylesheet" href="../../resources/css/icomoon-icons.css">
    <link rel="stylesheet" href="../../resources/css/bootstrap.css"/>
    <link rel="stylesheet" href="../../resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="../../resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="../../resources/css/magnific-popup.css"/>
    <link rel="stylesheet" href="../../resources/css/easy-responsive-tabs.css">
    <link rel="stylesheet" href="../../resources/css/style.css">
    <link rel="stylesheet" href="../../resources/css/form.css">
    <link rel="stylesheet" href="../../resources/css/search_form.css">
    <link rel="stylesheet" href="../../resources/css/item.css">

    <script src="../../resources/js/modernizr-2.6.2.min.js"></script>
    <script src="../../resources/js/respond.min.js"></script>
    <script src="../../resources/js/jquery-1.10.2.min.js"></script>
    <script src="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
    <script>

        function onClickSearch() {
            var form = document.form;
            form.action = "/search";
            form.method = "GET";
            form.submit();
        }

        function onAddCity() {
            var form = document.addCityForm;
            if (form['city'].value != '' && form['country'].value != '') {
                form.action = "/admin/addCity";
                form.method = "POST";
                form.submit();
            } else {
                alert("Fill in all the fields");
            }
        }

        function onAddTrip() {
            var form = document.addTripForm;
            if (form['departureCity'].value != '' && form['departureDay'].value != '' && form['departureMonth'].value != ''
                    && form['departureTime'].value != '' && form['arrivalCity'].value != ''
                    && form['arrivalDay'].value != ''
                    && form['arrivalMonth'].value != '' && form['arrivalTime'].value != '') {
                form.action = "/admin/createTrip";
                form.method = "POST";
                form.submit();
            } else {
                alert("Fill in all the fields");
            }
        }

    </script>

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
            <ul id="fh5co-navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="/">TIMETABLE</a></li>
                </ul>
            <@security.authorize access="isAnonymous()">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/authorization" class="btn btn-calltoaction btn-primary">Authorization</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/registration" class="btn btn-calltoaction btn-primary">Registration</a></li>
                </ul>
            </@security.authorize>
            <@security.authorize access="hasRole('ROLE_USER')">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/j_spring_security_logout" class="btn btn-calltoaction btn-primary">Log out</a></li>
                </ul>
                <div class="navbar-header navbar-right">
                    <div class="navbar-brand">${username}</div>
                </div>

            </@security.authorize>
        </div>
        </div>
    </nav>

</header>

<div id="fh5co-hero" style="background-image: url(/resources/images/hero_2.jpg)">
    <a href="#fh5co-main" class="smoothscroll animated bounce fh5co-arrow"><i class="ti-angle-down"></i></a>
    <div class="container">
        <div class="col-md-8 col-md-offset-2">
            <div class="text">
                <h1><strong>TIMETABLES</strong> <em>OF TRAINS AROUND</em> <strong>THE WORLD</strong></h1>
            </div>
        </div>
    </div>
</div>

<main role="main" id="fh5co-main">


<@security.authorize access="hasRole('ROLE_ADMIN')">
    <div class="form-container">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="input-group" id="adv-search">
                        <div class="input-group-btn">
                            <div class="btn-group" role="group">
                                <div class="dropdown dropdown-lg">
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                                            aria-expanded="false"><span>Add city</span></button>
                                    <div class="dropdown-menu dropdown-menu-right" role="menu">
                                        <form class="form-horizontal" role="form" name="addCityForm">
                                            <div class="form-group">
                                                <label for="contain">City</label>
                                                <input name="city" class="form-control" type="text"/>
                                            </div>
                                            <div class="form-group">
                                                <label for="contain">Country</label>
                                                <input name="country" list="country" class="form-control" type="text"/>
                                                <datalist id="country">
                                                    <#list countries as country>
                                                        <option value="${country.countryName}"/>
                                                    </#list>
                                                </datalist>
                                            </div>
                                            <button id="addCity" onclick="onAddCity()" type="button"
                                                    class="btn btn-primary"><span class="glyphicon"
                                                                                  aria-hidden="true">+</span></button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="input-group" id="adv-search">
                        <div class="input-group-btn">
                            <div class="btn-group" role="group">
                                <div class="dropdown dropdown-lg">
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                                            aria-expanded="false"><span>Add trip</span></button>
                                    <div class="dropdown-menu dropdown-menu-right" role="menu">
                                        <form class="form-horizontal" role="form" name="addTripForm">
                                            <div class="form-group">
                                                <label for="contain">Departure city</label>
                                                <input list="city" name="departureCity" class="form-control"
                                                       type="text"/>
                                                <datalist id="city">
                                                    <#list cities as city>
                                                        <option value="${city.cityName}"/>
                                                    </#list>
                                                </datalist>
                                            </div>
                                            <div class="form-group">
                                                <label for="contain">Departure time</label>
                                                <input name="departureDay" type='text' maxlength="2"
                                                       class="form-control" placeholder="Day"/>
                                                <input name="departureMonth" type='text' maxlength="2"
                                                       class="form-control" placeholder="Month"/>
                                                <input name="departureTime" type='text' maxlength="5"
                                                       class="form-control" placeholder="HH:MM"/>
                                            </div>
                                            <div class="form-group">
                                                <label for="contain">Arrival city</label>
                                                <input list="city" name="arrivalCity" class="form-control" type="text"/>
                                                <datalist id="city">
                                                    <#list cities as city>
                                                        <option value="${city.cityName}"/>
                                                    </#list>
                                                </datalist>
                                            </div>
                                            <div class="form-group">
                                                <label for="contain">Arrival time</label>
                                                <input name="arrivalDay" type='number' maxlength="2"
                                                       class="form-control" placeholder="Day"/>
                                                <input name="arrivalMonth" type='number' maxlength="2"
                                                       class="form-control" placeholder="Month"/>
                                                <input name="arrivalTime" type='text' maxlength="5" class="form-control"
                                                       placeholder="HH:MM"/>
                                            </div>
                                            <div class="form-group">
                                                <label for="contain">Arrival city</label>
                                                <select name="type" class="form-control">
                                                    <option value="2">Бизнес</option>
                                                    <option value="1">Комфорт</option>
                                                    <option value="0">Эконом</option>
                                                </select>
                                            </div>
                                            <button id="addCity" onclick="onAddTrip()" type="button"
                                                    class="btn btn-primary"><span class="glyphicon"
                                                                                  aria-hidden="true">+</span></button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</@security.authorize>


    <form class="form-horizontal" role="form" name="form">
        <div class="container form-container">
            <div class="row">
                <div class="col-md-6">
                    <div class="input-group" id="adv-search">
                        <div class="form-group">
                            <label for="contain">Departure city</label>
                            <input list="debCity" name="departureCity" class="form-control" type="<text"
                                   <#if depCity??>value="${depCity}"</#if>/>
                            <datalist id="debCity">
                            <#list cities as city>
                                <option value="${city.cityName}"/>
                            </#list>
                            </datalist>
                        </div>
                        <div class="form-group">
                            <label for="contain">Arrival city</label>
                            <input list="arrCity" name="arrivalCity" class="form-control" type="text"
                                   <#if arrCity??>value="${arrCity}"</#if>/>
                            <datalist id="arrCity">
                            <#list cities as city>
                                <option value="${city.cityName}"/>
                            </#list>
                            </datalist>
                        </div>
                        <button type="button" id="search" onclick="onClickSearch()" class="btn btn-primary"><span
                                class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="input-group" id="adv-search">
                        <div class="form-group">
                            <label for="contain">Departure country</label>
                            <input list="debCountry" name="departureCountry" class="form-control" type="text"
                                   <#if depCountry??>value="${depCountry}"</#if>/>
                            <datalist id="debCountry">
                            <#list countries as country>
                                <option value="${country.countryName}"/>
                            </#list>
                            </datalist>
                        </div>
                        <div class="form-group">
                            <label for="contain">Arrival country</label>
                            <input list="arrCountry" name="arrivalCountry" class="form-control" type="text"
                                   <#if arrCountry??>value="${arrCountry}"</#if>/>
                            <datalist id="arrCountry">
                            <#list countries  as country>
                                <option value="${country.countryName}"/>
                            </#list>
                            </datalist>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>

</main>

<#if search??>
<div class="panel-body">
    <ul class="list-group">
        <#list  search as trip>
            <li class="list-group-item">
                <div class="checkbox">
                    <label for="checkbox">
                        <strong>Departure:</strong> ${trip.tableCityDepartureEntity.cityName}
                        , ${trip.tripDepartureTime}
                    </label>
                    <label for="checkbox">
                        <strong>Arrival:</strong> ${trip.tableCityArrivalEntity.cityName} , ${trip.tripArrivalTime}
                    </label>
                </div>
                <div class="pull-right action">

                    <@security.authorize access="hasRole('ROLE_ADMIN')">
                        <form name="delete" action="/admin/delete" method="post">
                            <input name="tripId" value="${trip.tripId}" hidden/>
                            <button type="submit" class="trash"><span class="glyphicon glyphicon-trash"></span></button>
                        </form>
                    </@security.authorize>
                </div>
            </li>
        </#list>
    </ul>
</div>
</#if>


<footer role="contentinfo" id="fh5co-footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="text-center">
                    <h3 class="footer-heading">About Us</h3>
                    <p>We provide you train timetables from around the world.</p>
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

<script src="../../resources/js/jquery.easing.1.3.js"></script>
<script src="../../resources/js/bootstrap.js"></script>
<script src="../../resources/js/owl.carousel.min.js"></script>
<script src="../../resources/js/jquery.magnific-popup.min.js"></script>
<script src="../../resources/js/easyResponsiveTabs.js"></script>
<script src="../../resources/js/fastclick.js"></script>
<script src="../../resources/js/main.js"></script>

</body>
</html>

