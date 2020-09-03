function forgotpass3validate()
{
	var password = document.getElementById("password").value;
	var password1 = document.getElementById("password1").value;
	var p = password.length;
	var m = password1.length;
	var u = document.forgot3.password.value;
	var v = document.forgot3.password1.value;
	if(u=="") {
	alert("PLEASE ENTER YOUR NEW PASSWORD");
	return false;
	}
	else if(p<6||p>16) {
		alert("NEW PASSWORD SHOULD BE OF 6-16 CHARACTERS");
		return false;
	}
	else if(v=="") {
		alert("PLEASE FILL YOUR RETYPE PASSWORD");
		return false;
		}
		else if(m<6||m>16) {
			alert("RETYPE PASSWORD SHOULD BE OF 6-16 CHARACTERS");
			return false;
		}
	else if(password != password1){
		alert("PASSWORDS DO NOT MATCH")
	return false;
	}
	else{
		return true;
	}

}
