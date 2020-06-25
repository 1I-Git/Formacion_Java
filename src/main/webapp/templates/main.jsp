<!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Proyectos ${ parametro }</h1>
            <a href="https://github.com/1I-Git/Formacion_Java" target="_blank" class="d-none d-sm-inline-block btn btn-sm btn-success shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Descargar Proyecto</a>
          </div>

          <!-- Content Row -->
          <div class="row">

            <!-- Earnings (Monthly) Card Example todos(8) -->
            
            <c:forEach items="${proyectoLenguajes}" var="p" begin="1" end="8">
              
	            <div class="col-xl-3 col-md-6 mb-4">
	              <div class="card border-left-success shadow h-100 py-2">
	                <div class="card-body">
	                  <div class="row no-gutters align-items-center">
	                    <div class="col mr-2">
	                      <div class="h5 font-weight-bold text-success text-uppercase mb-1"><a class="text-success" href="#">${ p.nombre }</a></div>
	                      <div class="text-xs mb-0 font-weight-bold text-gray-800">${ p.descripcion }</div>
	                      <c:forEach items="${p.lenguajes}" var="l">
	                      <span class="badge badge-pill badge-${ l.color }">${ l.nombre }</span>
	                      </c:forEach>
	                    </div>
	                    <div class="col-auto">
	                      <i class="fas fa fa-folder fa-2x text-gray-300"></i>
	                    </div>
	                  </div>
	                </div>
	              </div>
	            </div>
            
            </c:forEach>

          <!-- End of Proyect Cards -->
          
          <!-- Earnings (Monthly) Card Example Filtrado por Lenguajes -->
            
            <c:forEach items="${lenguajeProyectos}" var="l">
              
	            <div class="col-xl-3 col-md-6 mb-4">
	              <div class="card border-left-success shadow h-100 py-2">
	                <div class="card-body">
	                  <div class="row no-gutters align-items-center">
	                    <div class="col mr-2">
	                      <div class="h5 font-weight-bold text-success text-uppercase mb-1"><a class="text-success" href="#">${ l.nombre }</a></div>
	                      <div class="text-xs mb-0 font-weight-bold text-gray-800">${ l.descripcion }</div>
	                      
	                      <span class="badge badge-pill badge-${ l.lenguaje.color }">${ l.lenguaje.nombre }</span>
	                      
	                    </div>
	                    <div class="col-auto">
	                      <i class="fas fa fa-folder fa-2x text-gray-300"></i>
	                    </div>
	                  </div>
	                </div>
	              </div>
	            </div>
            
            </c:forEach>

          <!-- End of Proyect Cards -->

          <!-- Informacion -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-gray-800">Informacion</h6>
            </div>
            <div class="card-body">
              <div class="text-center">
                <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;" src="img/undraw_web_developer_p3e5.svg" alt="">
              </div>
              <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. Git-Hub:<a class="text-success" target="_blank" rel="nofollow" href="https://github.com/1I-Git">1I-Git</a>, Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book
              Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book
              Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book
              Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book
              Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book
              Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book
              Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.!</p>
              <a class="text-success" target="_blank" rel="nofollow" href="#">Echa un vistazo al portafolios &rarr;</a>
            </div>
          </div>