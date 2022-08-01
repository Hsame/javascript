<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>점포 관리</title>
<link rel="stylesheet" href="../css/StoreCss.css">
</head>
<jsp:include page="../header.jsp"/>
<jsp:include page="../sidebar.jsp"/>
<body>
<h2>승인 요청 목록</h2>
	<table id=tab> 
		<thead>
			<tr>
				<th>점포명</th>
				<th>점포주소</th>
				<th>전화번호</th>
				<th>이용시간</th>
				<th>업태</th>
				<th>수락여부</th>
			</tr>
		</thead>

		<tbody id="list"></tbody>

	</table>
	<!-- AJAX(비동기 방식 처리) -->

	<!-- 먼저 실행한 것의 결과가 먼저 나오고 그다음거 그다음거 나오는데 동기방식임 -->
	<script>
	
	let i =0;
	let xhtp = new XMLHttpRequest();
	
	xhtp.open('get', 'storeJson.do');
	xhtp.send();
	
	xhtp.onreadystatechange = callBackThree; 
	

	let fields = ['store_name', 'store_address', 'telephone', 'AVAILABLE_TIME','food_category']
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
		let btn2 = document.createElement('button')
		btn2.innerText='수락';
		btn.innerText = '거절';
		//클릭 이벤트
		btn.addEventListener('click',deleteCallBack);
		btn2.addEventListener('click',updateCallBack);
		td1.append(btn2);
		td1.append(btn);
		tr.append(td1);
		
		return tr;
	}
	
	function deleteCallBack(e) {
		console.log(this); //event의 call함수(이벤트를 받는 대상.)
		let delstname = this.parentElement.parentElement.firstElementChild.innerText;
		
		let delAjx = new XMLHttpRequest();
		delAjx.open('post', 'degreeStoreAjax.do');
		delAjx.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		delAjx.send('store_name=' + delstname);
		delAjx.onload = function() {
			let result = JSON.parse(delAjx.responseText);
			if(result.retCode == 'Success') {
				alert('신청을 거절하였습니다.')
				e.target.parentElement.parentElement.remove();
			}
			else{ 
				alert('처리중 에러 발생.');
			}
		}
		
	}
	
	function updateCallBack(e) {
		console.log(this);
		let upname = this.parentElement.parentElement.firstElementChild.innerText;
		let upAjx = new XMLHttpRequest();
		upAjx.open('post', 'updateStoreAjax.do');
		upAjx.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		upAjx.send('store_name=' + upname);
		upAjx.onload = function() {
			let result = JSON.parse(upAjx.responseText);
			if(result.retCode == 'Success') {
				alert('신청을 수락하였습니다.')
				e.target.parentElement.parentElement.remove();
			}
			else{ 
				alert('처리중 에러 발생.');
			}
		}
	}
</script>
</body>
</html>