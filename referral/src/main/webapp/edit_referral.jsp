<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Referral Form</title>
<link rel="icon" href="images/form.png">
<link rel="stylesheet" href="style.css">
<style>
tr {
	display: block;
	text-align: center;
	margin: auto;
}

#form-container {
	display: flex;
	flex-direction: column;
	text-align: center;
	justify-content: center;
	align-items: center;
	border-color: #4d4d4d;
	border-width: 2px;
	border-style: solid;
	margin: 0 auto;
}

footer {
	background-color: #4d4d4d;
	grid-area: footer;
	color: #ffffff;
	text-align: center;
	padding-top: 20px;
}
</style>
</head>
<body>
	<div id="page">
		<header>
			<div class="image-container">
				<img id="TS" src="images/transforming-support-horizontal.png">
			</div>
		</header>
		<main>
			<div id="form-container">
				<h1>Edit Referral</h1>
				<form name="frmReferral" action="update">
					<table>
						<tr>
							<td><input type="text" name="enquiryno" id="Box3" readonly
								value="<%out.print(request.getAttribute("enquiryno"));%>"></td>
						</tr>
						<tr>
							<td><input type="text" name="txt_firstname" class="Box1"
								value="<%out.print(request.getAttribute("txt_firstname"));%>"></td>
						</tr>
						<tr>
							<td><input type="text" name="txt_lastname" class="Box1"
								value="<%out.print(request.getAttribute("txt_lastname"));%>"></td>
						</tr>

						<tr>
							<td><label>Role:</label>&nbsp; <select name="txt_role"
								class="Box3">
									<option value="Family">Family member</option>
									<option value="Advocate">Advocate</option>
									<option value="Social Worker">Social worker</option>
									<option value="Other">Other</option>
							</select></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_phone" class="Box1"
								value="<%out.print(request.getAttribute("txt_phone"));%>"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_email" class="Box1"
								value="<%out.print(request.getAttribute("txt_email"));%>"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_refnumber" class="Box1"
								value="<%out.print(request.getAttribute("txt_refnumber"));%>"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_hear" class="Box1"
								value="<%out.print(request.getAttribute("txt_hear"));%>"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_dbirth" class="Box1"
								value="<%out.print(request.getAttribute("txt_dbirth"));%>"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_todo" class="Box2"
								value="<%out.print(request.getAttribute("txt_todo"));%>"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_pdiagnosis" class="Box1"
								value="<%out.print(request.getAttribute("txt_pdiagnosis"));%>">></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_sdiagnosis" class="Box1"
								value="<%out.print(request.getAttribute("txt_sdiagnosis"));%>"></td>
						</tr>


						<tr>
							<td><input type="number" name="float_hours" class="Box1"
								value="<%out.print(request.getAttribute("float_hours"));%>"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_reasonref" class="Box2"
								value="<%out.print(request.getAttribute("txt_reasonref"));%>"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_fundingbody" class="Box1"
								value="<%out.print(request.getAttribute("txt_fundingbody"));%>"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_draty" class="Box1"
								value="<%out.print(request.getAttribute("txt_draty"));%>"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_preflocation" class="Box1"
								value="<%out.print(request.getAttribute("txt_preflocation"));%>"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_acomneeds" class="Box2"
								value="<%out.print(request.getAttribute("txt_acomneeds"));%>"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_dstart" class="Box1"
								value="<%out.print(request.getAttribute("txt_dstart"));%>"></td>
						</tr>
					</table>
					<input type="button" value="Save" class="button1"
						onclick="validate()">
				</form>

				<script src="scripts/Validate.js"></script>
			</div>
		</main>
		<footer style="background-color: #4d4d4d;">
			<div class="divHP">
				<small> Copyright ? 2019. Pathway for Care Ltd - Company
					Number: 10339398 </small>
			</div>
		</footer>
	</div>
</body>
</html>