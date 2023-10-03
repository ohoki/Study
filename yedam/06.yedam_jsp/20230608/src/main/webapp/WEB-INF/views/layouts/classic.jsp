<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Personal - Start Bootstrap Theme</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Custom Google font-->
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@100;200;300;400;500;600;700;800;900&amp;display=swap" rel="stylesheet" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
			<!-- Navigation-->
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
			<!-- Header-->
			<tiles:insertAttribute name="body"></tiles:insertAttribute>	            
	        <!-- About Section-->
	        <section class="bg-light py-5">
	            <div class="container px-5">
	                <div class="row gx-5 justify-content-center">
	                    <div class="col-xxl-8">
	                        <div class="text-center my-5">
	                            <h2 class="display-5 fw-bolder"><span class="text-gradient d-inline">About Me</span></h2>
	                            <p class="lead fw-light mb-4">My name is Start Bootstrap and I help brands grow.</p>
	                            <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugit dolorum itaque qui unde quisquam consequatur autem. Eveniet quasi nobis aliquid cumque officiis sed rem iure ipsa! Praesentium ratione atque dolorem?</p>
	                            <div class="d-flex justify-content-center fs-2 gap-4">
	                                <a class="text-gradient" href="#!"><i class="bi bi-twitter"></i></a>
	                                <a class="text-gradient" href="#!"><i class="bi bi-linkedin"></i></a>
	                                <a class="text-gradient" href="#!"><i class="bi bi-github"></i></a>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </section>
     	</main>
        <!-- Footer-->
        <tiles:insertAttribute name="footer"></tiles:insertAttribute>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>