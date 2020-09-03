function signupvalidate() {
	
	/*VALIDATION FOR FIRST NAME*/
	var fname = document.getElementById("fname").value;
	var f = fname.length;
	var f1 = document.registration.fname.value;
	if(f1=="") {
		alert("PLEASE ENTER YOUR FIRST NAME");
		return false;} 
	else if(f>=25) {
		alert("FIRST NAME SHOULD NOT BE MORE THAN 25 CHARACTERS");
		return false;
	}
	
	/*VALIDATION FOR LAST NAME*/
	var lname = document.getElementById("lname").value;
	var l = lname.length;
	var l1 = document.registration.lname.value;
	if(l1=="") {
		alert("PLEASE ENTER YOUR LAST NAME");
		return false;} 
	else if(l>=25) {
		alert("LAST NAME SHOULD NOT BE MORE THAN 25 CHARACTERS");
		return false;
	}
	
	/*VALIDATION FOR PASSWORD*/
	var password = document.getElementById("password").value;
	var p1= password.length;
	var p2 = document.registration.password.value;
	if(p2=="") {
		alert("PLEASE ENTER YOUR PASSWORD");
		return false;
	}
	else if(p1<6||p1>16) {
		alert("PASSWORD SHOULD BE OF 4-16 CHARACTERS");
		return false;
	}
		
	/*VALIDATION FOR EMAIL*/
	var x =  document.getElementById("email").value;
	var atposition = x.indexOf("@");    
	if (atposition<1){  
		alert("PLEASE ENTER A VALID EMAIL ADDRESS IN THE FORMAT OF anyname@example.com ");  
		return false;  
	}  
	
	/*VALIDATION FOR PHONE NUMBER*/
	var phonenumber = document.getElementById("phonenumber").value;
	var pn1 = phonenumber.length;
	var pn2 = document.registration.phonenumber.value;
	if(pn2=="")
	{
		alert("PLEASE ENTER YOUR PHONE NUMBER");
		return false;
	}
	else if(pn1!=10)
	{
		alert("PLEASE ENTER A VALID PHONE NUMBER");
		return false;
	}
	
}