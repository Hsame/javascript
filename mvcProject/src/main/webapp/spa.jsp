<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX(spa.jsp)</title>
</head>
<body>
	<h3>회원등록</h3>
	<form name="addfrm" action="addMemberAjax.do" name="post">
		아이디 : <input type="text" name="id"><br> 
		이름 : <input type="text" name="name"><br> 
		이메일 : <input type="text" name="mail"><br> 
		비밀번호 : <input type="text" name="passwd"><br>
		<input type="submit" value="저장">
	</form>


	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>삭제</th>
			</tr>
		</thead>

		<tbody id="list"></tbody>

	</table>
	<!-- AJAX(비동기 방식 처리) -->

	<!-- 먼저 실행한 것의 결과가 먼저 나오고 그다음거 그다음거 나오는데 동기방식임 -->
	<script>
	
	let i =0;
	let xhtp = new XMLHttpRequest();
	
	xhtp.open('get', 'memberJson.do');
	xhtp.send();
	
	xhtp.onreadystatechange = callBackThree; 
	

	let fields = ['id', 'passwd', 'name', 'mail']
	function callBackThree(){
		if (this.readyState == 4 && this.status == 200) {
			let data = JSON.parse(this.responseText);
			console.log(data);
			
			//let tbody = document.querySelector("list");
			let tbody = document.getElementById("list");
			
			for(let item of data){
				tr = makeTr(item);
				
				tbody.append(tr);
			}
		}
	} // end of callBackThree
	
	function makeTr(item) {
		//tr td,td,td
		let tr = document.createElement("tr");
		//필드 갯수 반복.
		for(let f of fields){
			let td = document.createElement("td");
			td.innerText = item[f]; // 
			
			tr.append(td);
		}
		
		//삭제버튼
		let td1 = document.createElement("td");
		let btn = document.createElement('button');
		btn.innerText = '삭제';
		//클릭 이벤트
		btn.addEventListener('click',deleteCallBack);
		td1.append(btn);
		tr.append(td1);
		
		return tr;
	}
	
	function deleteCallBack(e) {
		console.log(this); //event의 call함수(이벤트를 받는 대상.)
		let delId = this.parentElement.parentElement.firstElementChild.innerText;
		
		let delAjx = new XMLHttpRequest();
		delAjx.open('post', 'removeMemberAjax.do');
		delAjx.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		delAjx.send('id=' + delId);
		delAjx.onload = function() {
			let result = JSON.parse(delAjx.responseText);
			if(result.retCode == 'Success') {
				alert('삭제완료')
				e.target.parentElement.parentElement.remove();
			}
			else{ 
				alert('처리중 에러 발생.');
			}
		}
		
	}
	
/* 	function callBackTwo(){
		if (this.readyState == 4 && this.status == 200) {
			let data = JSON.parse(this.responseText);
			console.log(data);
			
			let ul = document.createElement("ul");
			for(let i of data){
				let li = document.createElement("li");
				li.innerHTML = i.name + ", " + i.age;
				
				ul.append(li);
			}
			
			document.querySelector('body').append(ul);			
		}
		
	}	

	
	function callBackOne() {
		if (this.readyState == 4 && this.status == 200) {
			let data = JSON.parse(this.responseText);
			
			let name = document.createElement("p");
			name.innerText = data[0].name;
			
			let age = document.createElement("p");
			age.innerText = data.age;
			
			console.log(data);
			console.log(this.responseText);
			
			//document.write(xhtp.responseText);
			document.querySelector('body').append(name, age);
			}
		} */
	
	
	//form 전송이벤트 실행.
	document.forms.addfrm.onsubmit = function(e) {
		//기본기능 차단
		e.preventDefault();
		
		let url = document.forms.addfrm.getAttribute('action');
		let id = document.forms.addfrm.id.value;
		let name = document.forms.addfrm.name.value;
		let pass = document.forms.addfrm.passwd.value;
		let mail = document.forms.addfrm.mail.value;	
		let param = 'id=' + id + '&name=' + name + '&passwd=' + pass + '&mail=' + mail;
		
		let addAjx = new XMLHttpRequest();
		addAjx.open('post',url);
		addAjx.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		addAjx.send(param); //id=user1&passwd=1234&name=Hong&mail=email@.com
		addAjx.onload = function() {
		
		let data = JSON.parse(addAjx.responseText);
		//tbody 태그의 id(list)
		document.getElementById('list').append(makeTr(data));
		}
		
	}
	</script>



</body>
</html>