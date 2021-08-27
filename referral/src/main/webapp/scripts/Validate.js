/**
 * Validation required fields from referral form
 * @Israel Diniz
 */

function validate() {
	let fnome = frmReferral.txt_firstname.value
	let lnome = frmReferral.txt_lastname.value
	let role = frmReferral.txt_role.value
	let phone = frmReferral.txt_phone.value
	let email = frmReferral.txt_email.value
	let refnumber = frmReferral.txt_refnumber.value
	let hearabout = frmReferral.txt_hear.value
	let datebirth = frmReferral.txt_dbirth.value
	let todo = frmReferral.txt_todo.value
	let pdiag = frmReferral.txt_pdiagnosis.value
	let sdiag = frmReferral.txt_sdiagnosis.value
	let weekhours = frmReferral.float_hours.value;
	let reason = frmReferral.txt_reasonref.value
	let funding = frmReferral.txt_fundingbody.value
	let draty = frmReferral.txt_draty.value
	let location = frmReferral.txt_preflocation.value
	let acomneeds = frmReferral.txt_acomneeds.value
	let dstart = frmReferral.txt_dstart.value

	if (fnome === "" || lnome === "") {
		alert('Please insert a first name and a last name')
	} else if (isNaN(phone)) {
		alert('Please insert a valid phone number')
	} else if (refnumber === "") {
		alert('Please insert a reference number')
	} else if (datebirth === "") {
		alert('Please insert the date birth')
	} else if (todo === "") {
		alert('Please insert what the individual likes to do')
	} else if (pdiag === "") {
		alert('Please insert the individual primary diagnosis')
	} else if (sdiag === "") {
		alert('Please insert the individual secondary diagnosis')
	} else if (weekhours === 0 || weekhours === "") {
		alert('Please insetr the weekly hours necessarily')
	} else if (weekhours === 0 || weekhours === "") {
		alert('Please insert the weekly hours necessarily')
	} else if (reason === "") {
		alert('Please insert the reason for referral')
	} else if (funding === "") {
		alert('Please insert the funding body')
	} else if (draty === "") {
		alert('Please insert the tierred raty')
	} else if (location === "") {
		alert('Please insert the preferred service locations')
	} else if (acomneeds === "") {
		alert('Please insert the accomodation needs. Will adaptations be required?')
	} else if (dstart === "") {
		alert('Please insert the preferred service start date')
	} else{
		document.forms["frmReferral"].submit()
	}
}