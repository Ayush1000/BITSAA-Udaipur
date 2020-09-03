function forgotpass2validate() {	
	var answer = document.getElementById("answer").value;
	var a = answer.length;
	var s = document.forgot2.answer.value;
	if(document.forgot2.securityquestion.selectedIndex==0) { 
		alert("PLEASE SELECT YOUR SECURITY QUESTION TYPE");
		document.forgot2.securityquestion.focus();
		return false;
	}
	else if(s=="") 
	{
		alert("PLEASE ENTER YOUR ANSWER");
		return false;
	}
	else if(a>=25) 
	{
		alert("ANSWER SHOULD NOT BE MORE THAN 25 CHARACTERS");
		return false;
	}
	else {
		return true;
	}
}