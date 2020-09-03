function changepassvalidate()
{
	var password = document.getElementById("password").value;
	var password1 = document.getElementById("password1").value;
	var password2 = document.getElementById("password2").value;
	var p = password.length;
	var m = password1.length;
	var n = password2.length;
	var u = document.Changepassword.password.value;
	var v = document.Changepassword.password1.value;
	var w = document.Changepassword.password2.value;
	if(u=="") 
	{
		alert("PLEASE ENTER YOUR CURRENT PASSWORD");
		return false;
	}
	else if(p<6||p>16) 
	{
		alert("CURRENT PASSWORD SHOULD BE OF 6-16 CHARACTERS");
		return false;
	}
	else if(v=="") 
	{
		alert("PLEASE ENTER YOUR NEW PASSWORD");
		return false;
	}
	else if(m<6||m>16) 
	{
		alert("NEW PASSWORD SHOULD BE OF 6-16 CHARACTERS");
		return false;
	}
	else if(w=="") 
	{
		alert("PLEASE ENTER YOUR RE-TYPE PASSWORD");
		return false;
	}
	else if(n<6||n>16) 
	{
		alert("RE-TYPE PASSWORD SHOULD BE OF 6-16 CHARACTERS");
		return false;
	}
	else if (password1 != password2)
	{
        alert("YOUR NEW PASSWORD MUST MATCH WITH YOUR RETYPE PASSWORD");
		return false;
	}
	else
	{
		return true;
	}
}