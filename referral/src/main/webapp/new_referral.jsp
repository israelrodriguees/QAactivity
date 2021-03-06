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
				<div>
					<h1>Create new referral</h1>
				</div>
				<form name="frmReferral" action="insert">
					<table>
						<tr>
							<td><input type="text" name="txt_firstname"
								placeholder="Insert the first name" class="Box1"></td>
						</tr>
						<tr>
							<td><input type="text" name="txt_lastname"
								placeholder="Insert the last name" class="Box1"></td>
						</tr>

						<tr>
							<td><label class="Box3">Role:</label>&nbsp; <select
								name="txt_role">
									<option value="Family">Family member</option>
									<option value="Advocate">Advocate</option>
									<option value="Social Worker">Social worker</option>
									<option value="Other">Other</option>
							</select></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_phone"
								placeholder="Insert your phone number" class="Box1"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_email"
								placeholder="Insert your email" class="Box1"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_refnumber"
								placeholder="Insert the reference number" class="Box1"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_hear"
								placeholder="Heard about us on" class="Box1"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_dbirth"
								placeholder="Date of birth(YYYY/MM/DD)" class="Box1"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_todo"
								placeholder="What does the individual love to do?" class="Box2"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_pdiagnosis"
								placeholder="Primary Diagnosis" class="Box1"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_sdiagnosis"
								placeholder="Secondary Diagnosis" class="Box1"></td>
						</tr>


						<tr>
							<td><input type="number" name="float_hours"
								placeholder="Currently weekly support hours(E.g.: 4.5)"
								class="Box1"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_reasonref"
								placeholder="Insert all the reasons for the referral."
								class="Box2"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_fundingbody"
								placeholder="Write the funding body" class="Box1"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_draty"
								placeholder="What is the tiered raty?" class="Box1"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_preflocation"
								placeholder="Preferred service locations" class="Box1"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_acomneeds"
								placeholder="Acommodation needs - Will adaptions be required?"
								class="Box2"></td>
						</tr>

						<tr>
							<td><input type="text" name="txt_dstart"
								placeholder="The preferred start date(YYYY/MM/DD)" class="Box1"></td>
						</tr>
					</table>
					<input type="button" value="Add" class="button1"
						onclick="validate()">
				</form>
			</div>

			<script src="scripts/Validate.js"></script>

		</main>
		<footer style="background-color: #4d4d4d;">
			<div class="divHP">
				<small> Copyright ? 2021. Transforming Support - Company
					Number: 10339398 </small>
			</div>
		</footer>
	</div>
</body>
</html>