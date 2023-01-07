<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="./css/home.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Chi Siamo</title>
</head>
<body>
<%@ include file="header.html" %>
<!--Slider-->
      <section class="slider mb-5">
        <div class="container">
          <div class="row text-center">
            <div class="row">
            
              <h1> About</h1>
              <h3><a href="home.html">Home</a></h3>
            </div>
            </div>
          </div>
      </section>
          <!--end Slider section-->


          <!-- Main Section-->
          <section id="content">
            <div class="content-wrap" style="overflow: visible;">

              <div class="section bg-transparent p-5">
                <div class="container ">
                  <div class="row text-center mt-3">
                    <div class="col-md-8 offset-md-2 center">
                      <h2 class="text-title-light text-uppercase mb-2 ">La nostra Storia.</h2>
                      <p>Benvenuti nella nostra pagina "About"! Siamo un gruppo di quattro studenti che sta lavorando a questo progetto come parte del nostro corso di studi. Siamo entusiasti di condividere con voi il nostro lavoro e speriamo che vi piaccia.

                        Ognuno di noi ha portato le proprie competenze e il proprio entusiasmo alla creazione di questo progetto, speriamo che possa risultare utile e interessante per voi. Grazie per averci visitato e speriamo di avere presto vostre notizie!"
                      </p>
                    </div>
                  </div>
                  </section>
                    
      
            <!-- ======= Our Team Section ======= -->
    <section id="team" class="team ">
        <section class="main mt-3" >
  
          <div class="section-header">
            <h2 class="text-center">Il nostro Team</h2>
          </div>
  
          <div class="row gy-5 mt-4">
            
            <div class="col-lg-6 col-md-6 member" >
              <div class="member-img">
                <img src="./img/team-1.jpg" class="img-fluid" alt="">
              </div>
              <div class="member-info text-center">
                <h4>Davide</h4>
                <p>Il backend lo conosce come le sue tasche. La leggenda narra che Java sia nato da una costola di Davide</p>
              </div>
            </div><!-- End Team Member -->
            

          <div class="col-lg-6 col-md-6 member" >
            <div class="member-img">
              <img src="./img/team-3.jpg" class="img-fluid" alt="">
              
            </div>
            <div class="member-info text-center">
              <h4>Daniele</h4>
              <p>Naviga tra front-end e back-end, apprende ogni giorno nuove nozioni</p>
            </div>
          </div><!-- End Team Member -->
          
          <div class="row gy-5">
          <div class="col-lg-6 col-md-6 member" >
            <div class="member-img">
              <img src="./img/team-4.jpg" class="img-fluid" alt="">
              
            </div>
            <div class="member-info text-center">
              <h4>Salvatore</h4>
              <p>Backender puro, innamorato degli algoritmi dell'AI e della vita</p>
            </div>
          </div><!-- End Team Member -->

          <div class="col-lg-6 col-md-6 member" >
            <div class="member-img">
              <img src="./img/team-5.jpg" class="img-fluid" alt="">
              
            </div>
            <div class="member-info text-center">
              <h4>Wei</h4>
              <p>Non smette di programmare nemmeno quando dorme, capace in tutti i fronti</p>
            </div>
          </div><!-- End Team Member -->
          </div>
        </div>
      </section>
      </section>
          <!-- End Team Section-->
 <div id="logindemo" class="modal fade">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"></button>
                <div class="my-form bg-dark">
                    <h1 class="text-center modal-h1">Login</h1>
                    <form action="#" >
                        <div class="mb-3 mt-3">
                            <label for="email">Email</label>
                            <input type="email" class="form-control">
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="password">Password</label>
                            <input type="password" class="form-control">
                        </div>
                        <button type="button" class="btn btn-light mt-3">LOGIN</button>
                        <p class="login-form-p">Non sei registrato?<a href="#"> Registrati</a></p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="Footer.html" %>

</body>
</html>