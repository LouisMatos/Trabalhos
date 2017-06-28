<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link
	href="https://cdn.datatables.net/r/bs-3.3.5/jq-2.1.4,dt-1.10.8/datatables.min.css"
	rel="stylesheet" type="text/css">
<script
	src="https://cdn.datatables.net/r/bs-3.3.5/jqc-1.11.3,dt-1.10.8/datatables.min.js"
	type="text/javascript"></script>
<title>Programa daora de POO</title>
<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#example').DataTable();
			} );
		</script>
</head>
<body>



	<div class="container-fluid">
		<fieldset>

			<!-- Form Name -->
			<legend>
				<a href="index.html">HOME</a>
			</legend>

			<table width="100%"
				class="table table-striped table-bordered dt-responsive nowrap"
				id="example" cellspacing="0">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOME</th>
						<th>TIPO</th>
						<th>PESO</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ListEquip}" var="ListEquip">
						<tr>
							<c:choose>
								<c:when test="${ListEquip.id == 1}">
									<td><c:out value="MAHALOWWW" /></td>
								</c:when>
								<c:otherwise>
									<td><c:out value="${ListEquip.id}" /></td>
								</c:otherwise>
							</c:choose>


							<td><c:out value="${ListEquip.nome}" /></td>
							<td><c:out value="${ListEquip.tipo}" /></td>
							<td><c:out value="${ListEquip.peso}" /></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

		</fieldset>
	</div>

</body>
</html>