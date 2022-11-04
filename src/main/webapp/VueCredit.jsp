<%@page import="web.CreditModel"%>
<%
CreditModel model = (CreditModel) request.getAttribute("creditModel");
%>

<!DOCTYPE html>
<html>
<head>
<title>Credit Bancaire</title>
<meta charset="utf-8">
<!-- CSS only -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
	crossorigin="anonymous" />
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<p></p>

	<div>
		<div class="container">
			<div class="col-md-6 col-xm-12 col-sm-6 col-md-offset-3">
				<div class="panel panel-primary">
					<div class="panel-heading">Simulation du credit</div>
					<div class="panel-body">
						<form action="CalculerMentionalite.php" method="post">
							<div class="form-group">
								<label class="control-label">Montant:</label> <input
									class="form-control" type="text" name="montant"
									value="<%=model.getMontant()%>" />
							</div>
							<div class="form-group">
								<label class="control-label">Taux:</label> <input
									class="form-control" type="text" name="taux"
									value="<%=model.getTaux()%>" />
							</div>
							<div class="form-group">
								<label class="control-label">Durée:</label> <input
									class="form-control" type="text" name="duree"
									value="<%=model.getDuree()%>" />
							</div>
							<br>
							<button class="btn btn-danger" type="submit">Calculer</button>
						</form>
						<div class="spacer">
							<label>Mensualité: </label> <label><%=model.getMensualite()%></label>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

</body>
</html>