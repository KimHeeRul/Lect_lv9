

function loginCheck(form) {
	let cnt = 0;
	if (form.id.value == "") {
		cnt++;
		document.getElementById("error_1").style.display = "block";
	} else {
		document.getElementById("error_1").style.display = "none";
	}
	if (form.pw.value == "") {
		cnt++;
		document.getElementById("error_2").style.display = "block";
	} else {
		document.getElementById("error_2").style.display = "none";
	}

	if (cnt == 0) {
		form.submit();
	}
}



function checkJoinVal(form) {
	let cnt = 0;
	if (form.id.value == "") {
		cnt++;
		document.getElementById("error_1").style.display = "block";
	} else {
		document.getElementById("error_1").style.display = "none";
	}
	if (form.pw.value == "") {
		cnt++;
		document.getElementById("error_2").style.display = "block";
	} else {
		document.getElementById("error_2").style.display = "none";
	}


	if (form.pw.value != form.pwcheck.value || form.pwcheck.value == "") {
		cnt++;
		document.getElementById("error_3").style.display = "block";
	} else {
		document.getElementById("error_3").style.display = "none";
	}


	if (form.name.value == "") {
		cnt++;
		document.getElementById("error_4").style.display = "block";
	} else {
		document.getElementById("error_4").style.display = "none";
	}

	if (cnt == 0) {
		form.submit();
	}
}


function writeCheck(form) {
	if (form.title.value == "") {
		alert("제목을 작성해주세요")
	} else if (form.content.value == "") {
		alert("내용을작성해주세요")
	} else if (form.pw.value == "") {
		alert("비밀번호를 입력해주세요")
	} else {
		form.submit();
	}
}
