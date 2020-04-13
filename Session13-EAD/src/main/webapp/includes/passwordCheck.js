function checkPassword() {

	if(document.getElementById("Password").value == document.getElementById("confirmPassword").value){
		document.getElementById("Submit").disabled = false;	
	} 
	else
	{
		document.getElementById("Submit").disabled = true;
	}
}