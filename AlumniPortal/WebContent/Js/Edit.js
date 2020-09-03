function Editprofilevalidate() {
	/*VALIDATION FOR FIRSTNAME*/
	var fname = document.getElementById("fname").value;
	var f = fname.length;
	var f1 = document.Editprofile.fname.value;
	if(f1=="") {
		alert("PLEASE ENTER YOUR FIRST NAME");
		return false;
	}
	else if(f>=25) {
	alert("FIRST NAME SHOULD NOT BE MORE THAN 25 CHARACTERS");
	return false;
	}
	/*VALIDATION FOR LASTNAME*/
	var lname = document.getElementById("lname").value;
	var l = lname.length;
	var l1 = document.Editprofile.lname.value;
	if(l1=="") {
		alert("PLEASE ENTER YOUR LAST NAME");
		return false;
	}
	else if(l>=25) {
	alert("LAST NAME SHOULD NOT BE MORE THAN 25 CHARACTERS");
	return false;
	}
	/*VALIDATION FOR PHONE NUMBER*/
	var phonenumber = document.getElementById("phonenumber").value;
	var pn1 = phonenumber.length;
	var pn2 = document.Editprofile.phonenumber.value;
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