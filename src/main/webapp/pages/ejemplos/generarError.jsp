<%@include file="/templates/slidebar.jsp" %>

<%@include file="/templates/topbar.jsp" %>

<%@ page errorPage="pages/ejemplos/verError.jsp" isErrorPage="false"%>   

<h1 class="border-bottom-success text-center text-dark mb-5">Generar Error</h1>
	
	<p>Acordarse de la directiva para indicar <code class="text-success">&lt;%@ page isErrorPage="true" %&gt;</code> </p>
	<p>En todas las JSPs que queramos gestionar los errores, hay que indicar cual es su pagina de error 
   <code class="text-success"> &lt;%@ page errorPage="error.jsp" %&gt;   </code>
   
   <p>Los fallos del tipo 404, se gestionan desde el <b>web.xml</b></p>

	<h3 class="border-bottom-success text-center text-dark mb-5">Ejemplo:</h3>
	<a class="text-success" href="link-falso">Generar Error 404</a>
	<br>
	<a  class="text-success" href="error?valor=true">Generar error jsp</a>
	<br>
	<a class="text-success" href="pages/ejemplos/verError.jsp">Probar Enlace</a>
	
	<c:if test="${bol}">
	
		<p>${ userError }</p>
			
	</c:if>
	


<%@include file="/templates/footer.jsp" %>