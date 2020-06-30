<%@include file="/../templates/slidebar.jsp" %>

<%@include file="/templates/topbar.jsp" %>

	<!-- Informacion -->
	          <div class="card shadow mb-4 ml-3">
	            <div class="card-header py-3">
	              <h3 class="m-0 font-weight-bold text-gray-800">Como hacer un C.R.U.D</h3>
	            </div>
	            <p>Ejemplo sobre como crear un C.R.U.D con Java y MySQL.
					 Para este ejemplo utilizaremos una tabla de guitarras: id,nombre,marca,información,precio,img_guitarra,img_marca. <br>
					 <span class="bg-warning text-dark">Seria mas correcto almacenar los datos de la marca en otra tabla, pero para este ejemplo me vale.</span></p>
					 <a class="text-success" target="_blank" rel="nofollow" href="#">Echar un vistazo en la Wikipedia &rarr;</a>
	            <div class="card-body">
	              <div class="text-center">
	                <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;" src="img/undraw_code_review_l1q9.svg" alt="imagen-undraw-codigo">
	              </div>
	              
				 <ul class="list-group">
				  <li class="list-group-item">Tabla Guitarras</li>
				  <li class="list-group-item list-group-item-dark">id</li>
				  <li class="list-group-item list-group-item-ligth">nombre</li>
				  <li class="list-group-item list-group-item-dark">marca</li>
				  <li class="list-group-item list-group-item-ligth">información</li>
				  <li class="list-group-item list-group-item-dark">precio</li>
				  <li class="list-group-item list-group-item-ligth">img_guitarra</li>
				  <li class="list-group-item list-group-item-dark">img_marca</li>
				</ul>	 
	              
	            </div>
	          </div>

	<h3 class="font-weight-bold text-gray-800 border border-bottom-success text-center ml-3  mt-5">Probar funcionamiento del C.R.U.D</h3>
	
	<!-- Tabla CRUD -->
	 <div class="container mb-5">
	        <div class="table-wrapper">
	            <div class="table-title">
	                <div class="row">
	                    <div class="col-sm-6">
							<h2>C.R.U.D <b>Guitarras</b></h2>
						</div>
						<div class="col-sm-6">
							<a id="añadirUsuario" href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Añadir Nueva Guitarra</span></a>						
						</div>
	                </div>
	            </div>
	            <table class="table table-striped table-hover">
	                <thead>
	                    <tr>
							<th>
								<span class="custom-checkbox">
									<input type="checkbox" id="selectAll">
									<label for="selectAll"></label>
								</span>
							</th>
							<th>#ID</th>
	                        <th>Nombre</th>
	                        <th>Marca</th>
							<th>Informacion</th>
	                        <th>Precio</th>
	                        <th>Img-Guitarra</th>
	                        <th>Img-Marca</th>
	                        <th>Editar/Eliminar</th>
	                    </tr>
	                </thead>
	                <tbody>
					<c:forEach items="${guitarras}" var="g">
						<tr>
							<td><span class="custom-checkbox"> <input
									type="checkbox" id="checkbox1" name="options[]" value="1">
									<label for="checkbox1"></label>
							</span></td>
							<td>${ g.id }</td>
							<td>${ g.nombre }</td>
							<td>${ g.marca }</td>
							<td>${ g.informacion }</td>
							<td>${ g.precio }</td>
							<td><img class="img-tabla" alt="logo de la marca" src="${ g.img_guitarra }"></td>
							<td><img class="img-tabla" alt="logo de la marca" src="${ g.img_marca }"></td>
							<td><a href="editar?id=${u.id }" class="edit"
								data-toggle="modal"><i class="material-icons"
									data-toggle="tooltip" title="Editar">&#xE254;</i></a> <a
								href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i
									class="material-icons eliminarUsuario" data-toggle="tooltip"
									title="Eliminar">&#xE872;</i></a></td>
						</tr>
					</c:forEach>
				</tbody>
	            </table>
				<div class="clearfix">
	                <ul class="pagination">
	                    <li class="page-item text-success"><a href="#" class="page-link text-success">Anterior</a></li>
	                    <li class="page-item"><a href="#" class="page-link text-success">1</a></li>
	                    <li class="page-item"><a href="#" class="page-link text-success">2</a></li>
	                    <li class="page-item active"><a href="#" class="page-link text-ligth">3</a></li>
	                    <li class="page-item"><a href="#" class="page-link text-success">4</a></li>
	                    <li class="page-item"><a href="#" class="page-link text-success">5</a></li>
	                    <li class="page-item"><a href="#" class="page-link text-success">Siguiente</a></li>
	                </ul>
	            </div>
	        </div>
	    </div>
		<!-- Edit Modal HTML -->
		<div id="addEmployeeModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="crearGuitarra" method="post">
						<div class="modal-header">						
							<h4 class="modal-title text-dark">Añadir Guitarra</h4>
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">					
							<div class="form-group">
								<label>Nombre</label>
								<input type="text" name="nombre" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Marca</label>
								<input type="text" name="marca" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Informacion</label>
								<input type="text" name="informacion" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Precio</label>
								<input type="text" name="precio" class="form-control" required>
							</div>
							<div class="form-group">
								<label>URL:IMG-Guitarra</label>
								<input type="text" name="img_guitarra" class="form-control" required>
							</div>	
							<div class="form-group">
								<label>URL:IMG-Marca</label>
								<input type="text" name="img_marca" class="form-control" required>
							</div>						
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal" value="Salir">
							<input type="submit" class="btn btn-success" value="Añadir">
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- Delete Modal HTML -->
		<div id="deleteEmployeeModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="eliminar" method="post">
						<div class="modal-header">						
							<h4 class="modal-title text-danger">Eliminar Guitarra</h4>
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">					
							<p>Si estas seguro de querer eliminar esta guitarra introduce el Id</p>
							<div class="form-group">
								<input type="text" name="id" class="form-control" placeholder="Introduce el ID" required>
							</div>
							<p class="text-danger"><small>Esta accion no puede ser modificada.</small></p>
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
							<input type="submit" class="btn btn-danger" value="Eliminar">
						</div>
					</form>
				</div>
			</div>
		</div>

<%@include file="/templates/footer.jsp" %>