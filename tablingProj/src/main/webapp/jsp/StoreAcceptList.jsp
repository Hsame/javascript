<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>점포 관리</title>
<link rel="stylesheet" href="../css/StoreCss.css">
</head>
<body>
<jsp:include page="../sidebar.jsp"/>
	<table>
		<thead>
			<tr>
				<th>점포명</th>
				<th>점포주소</th>
				<th>전화번호</th>
				<th>이용시간</th>
				<th>업태</th>
			</tr>
		</thead>

		<tbody id="list"></tbody>

	</table>
	
		<script>
		
		let i =0;
		let xhtp = new XMLHttpRequest();
		
		xhtp.open('get', 'acceptstoreJson.do');
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
			return tr;
		}

	</script>

</body>
</html>