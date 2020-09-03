function loginvalidate(){
var password = document.getElementById("password").value;
var n = password.length;
var p = document.login.password.value;
var x = document.getElementById("email").value; 
	var atposition = x.indexOf("@");  
	var dotposition = x.lastIndexOf(".");  
	if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
		alert("PLEASE ENTER A VALID EMAIL ADDRESS IN THE FORMAT OF anyname@example.com ");  
		return false;  
	}  
	else if(p=="") {
		alert("PLEASE ENTER YOUR PASSWORD");
		return false;
	}
	else if(n<6||n>16) {
		alert("PASSWORD SHOULD BE OF 6-16 CHARACTERS");
		return false;
	}
	else {
		return true;
	}
}