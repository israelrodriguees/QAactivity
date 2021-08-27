/**
 * Confirm the referral exclusion
 *
 *@author Israel Diniz
 * @param idcon
 */

function confirmation(idcon){
	let response = confirm("Do you want to delete this referral?")
	if (response == true){
		window.location.href = "delete?idcon=" + idcon
	}
}