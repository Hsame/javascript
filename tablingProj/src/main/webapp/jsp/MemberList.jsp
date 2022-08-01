<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/StoreCss.css">
</head>
<jsp:include page="../header.jsp" />
<jsp:include page="../sidebar.jsp" />
<body>
	<h2>회원목록</h2>
	<table id=tab>
		<thead>
			<tr>
				<th>아이디</th>
				<th>닉네임</th>
				<th>전화번호</th>
				<th>회원구분</th>
			</tr>
		</thead>
		<tbody id="list">
		
		</tbody>
	</table>	
		<script>
		
		let i =0;
		let xhtp = new XMLHttpRequest();
		
		xhtp.open('get', 'memberList.do');
		xhtp.send();
		
		xhtp.onreadystatechange = callBackThree; 
		

		let fields = ['member_id', 'nickname', 'phone_num', 'role']
		function callBackThree(){
			if (this.readyState == 4 && this.status == 200) {
				let data = JSON.parse(this.responseText);
				console.log(data);
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
			return tr;
		}

	</script>
</body>
</html>