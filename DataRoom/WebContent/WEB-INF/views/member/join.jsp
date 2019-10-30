<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<title>Marble &mdash; Free HTML5 Bootstrap Website Template by
	FreeHTML5.co</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Free HTML5 Website Template by FreeHTML5.co" />
<meta name="keywords"
	content="free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
<meta name="author" content="FreeHTML5.co" />

<!-- 
	//////////////////////////////////////////////////////

	FREE HTML5 TEMPLATE 
	DESIGNED & DEVELOPED by FreeHTML5.co
		
	Website: 		http://freehtml5.co/
	Email: 			info@freehtml5.co
	Twitter: 		http://twitter.com/fh5co
	Facebook: 		https://www.facebook.com/fh5co

	//////////////////////////////////////////////////////
	-->

<!-- Facebook and Twitter integration -->
<meta property="og:title" content="" />
<meta property="og:image" content="" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="" />
<meta property="og:description" content="" />
<meta name="twitter:title" content="" />
<meta name="twitter:image" content="" />
<meta name="twitter:url" content="" />
<meta name="twitter:card" content="" />

<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="shortcut icon" href="favicon.ico">

<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700"
	rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet" href="../../css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="../../css/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="../../css/bootstrap.css">
<!-- Flexslider  -->
<link rel="stylesheet" href="../../css/flexslider.css">
<!-- Theme style  -->
<link rel="stylesheet" href="../../css/style.css">

<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
	
	<!-- Bootstrap -->
        <link href="../plugin/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- font awesome -->
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <!-- Custom style -->
        <link rel="stylesheet" href="../plugin/bootstrap/css/style.css" media="screen" title="no title" charset="utf-8">

<style type="text/css">
select {
  width: 150px;
  padding: .8em .5em;
  font-family: inherit;
  background: url(https://farm1.staticflickr.com/379/19928272501_4ef877c265_t.jpg) no-repeat 95% 50%;  
  -webkit-appearance: none;
     -moz-appearance: none;
          appearance: none;
  border: 1px solid #999;
  border-radius: 0px;
}

select::-ms-expand { /* for IE 11 */
    display: none;
}

</style>	

</head>
<body>

	<div id="fh5co-page">
		<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
		<aside id="fh5co-aside" role="complementary"
			class="border js-fullheight">

			<h1 id="fh5co-logo">
				<a href="/main">Marble</a>
			</h1>
			<nav id="fh5co-main-menu" role="navigation">
				<ul>
					<li><a href="/main">Home</a></li>
					<li><a href="/board/list">DataRoom</a></li>
				</ul>
			</nav>

			<div class="fh5co-footer">
				<p>
					<small>&copy; 2016 Blend Free HTML5. All Rights Reserved.</span> <span>Designed
							by <a href="http://freehtml5.co/" target="_blank">FreeHTML5.co</a>
					</span> <span>Demo Images: <a href="https://unsplash.com/"
							target="_blank">Unsplash</a></span></small>
				</p>
				<ul>
					<li><a href="#"><i class="icon-facebook2"></i></a></li>
					<li><a href="#"><i class="icon-twitter2"></i></a></li>
					<li><a href="#"><i class="icon-instagram"></i></a></li>
					<li><a href="#"><i class="icon-linkedin2"></i></a></li>
				</ul>
			</div>

		</aside>


		<div id="fh5co-main">
		
			<article class="container">
            <div class="page-header">
                <div class="col-md-6 col-md-offset-3">
                <h3>JOIN</h3>
                </div>
            </div>
            <div class="col-sm-6 col-md-offset-3">
                <form role="form" method="POST" onSubmit="return check()">
                    <div class="form-group">
                        <label for="inputId">아이디</label>
                        <input type="text" class="form-control" required minlength="4" name="mem_id" id="mem_id" placeholder="아이디를 입력해 주세요 (4글자 이상)">
                    	<a class="btn btn-info" onclick="confirmId(this.form)">중복확인</a>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword">비밀번호</label>
                        <input type="password" class="form-control" required minlength="4" name="mem_pw" id="mem_pw" placeholder="비밀번호를 입력해주세요 (4글자 이상)">
                    </div>
                     <div class="form-group">
                        <label for="inputPasswordCheck">비밀번호 확인</label>
                        <input type="password" class="form-control" id="mem_pw_chk" placeholder="비밀번호 확인을 위해 다시한번 입력 해 주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputName">이름</label>
                        <input type="text" class="form-control" required name="mem_name" id="mem_name" placeholder="이름을 입력해 주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputMobile">생년월일</label>
                        <!-- <input type="date" class="form-control" required name="mem_birth" id="mem_birth"> -->
						<div>
						
                        <select name="year">
                        <c:forEach var="num" begin="1930" end="2019" step="1">
						   <option value=${num}>${num}</option>
						</c:forEach>
						</select>
						
						<select name="month">
                        <c:forEach var="num" begin="1" end="12" step="1">
						   <option value=${num}>${num}</option>
						</c:forEach>
						</select>
						
						<select name="day">
                        <c:forEach var="num" begin="1" end="31" step="1">
						   <option value=${num}>${num}</option>
						</c:forEach>
						</select>
						</div>
						
                    </div>
                    <div class="form-group">
                        <label for="inputGender" >성별</label>
                        <div>
						<input type="radio" required name="mem_sex" value="1">남
						<input type="radio" required name="mem_sex" value="2">여
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="InputEmail">이메일</label>
                        <input type="email" class="form-control" required name="mem_email" id="mem_email" placeholder="이메일 주소를 입력해주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputMobile">휴대폰 번호</label>
                        <input type="tel" class="form-control" required name="mem_pn" id="mem_pn" placeholder="휴대폰번호를 입력해 주세요">
                    </div>

                    <div class="form-group text-center">
                        <button type="submit" id="join-submit" class="btn btn-primary">
                            회원가입<i class="fa fa-check spaceLeft"></i>
                        </button>
	                <a href="/member/login" class="btn btn-warning">가입취소<i class="fa fa-times spaceLeft"></i></a>
                    </div>
	                        
                </form>
            
            </div>

        </article>
			
		</div>
	</div>
	
	<script>
		// submit 하기 전에 체크해주는 함수
		function check() {
			// 아이디 글자 수 체크
			if($('#mem_id').val().length < 4) {
				alert("아이디를 4글자 이상 입력해주세요.");
				return false;
			}
			
			
			if($('#mem_id').val().search(/[^a-z0-9]/gi) != -1) {
				alert("아이디는 영문과 숫자만 입력 가능합니다.");
				return false;
			}
			
			// 비밀번호 글자 수 체크
			if($('#mem_pw').val().length < 4) {
				alert("비밀번호를 4글자 이상 입력해주세요.");
				return false;
			}
			
			// 비밀번호 같은지 체크
			if($('#mem_pw').val() != $('#mem_pw_chk').val()) {
			    alert("비밀번호가 서로 다릅니다.");
			    // false를 하면 submit 취소
			    return false;
			}
			
		}
		
		// 아이디 중복확인 해주는 함수
		function confirmId() {
			var engNum = /^[a-zA-Z0-9]*$/;
			
			var mem_id_val = $('#mem_id').val();
			
			// 영어, 숫자만 있는지 체크
			if(engNum.test($('#mem_id').val()) == false) {
				mem_id_val = "fail";
			}
			
			// 길이 체크
			if(mem_id_val.length < 4) {
				mem_id_val = "sizeMiss";
			}
			
			// 아이디 값을 가져와서 파라미터로 넣음
			url = "/member/confirm?id=" + mem_id_val;
			
			open(url, "confirm","width=300, height=200");
		}
	
	</script>
	
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Flexslider -->
	<script src="js/jquery.flexslider-min.js"></script>

	<!-- MAIN JS -->
	<script src="js/main.js"></script>

</body>
</html>

