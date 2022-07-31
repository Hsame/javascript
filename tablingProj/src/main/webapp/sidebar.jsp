<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Curve Outside in Active Tab</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/sidebar.css"/>
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css"/>
  </head>

  <body>
    <div class="navigation">
      <ul>
        <li class="list active">
          <a href="${pageContext.request.contextPath }/jsp/StoreAccept.jsp">
            <span class="icon">
              <i class="input-icon uil uil-user-exclamation"></i>
            </span>
            <span class="title">승인요청 목록</span>
          </a>
        </li>
        <li class="list">
          <a href="${pageContext.request.contextPath }/jsp/StoreAcceptList.jsp">
            <span class="icon">
              <i class="input-icon uil uil-store"></i>
            </span>
            <span class="title">승인 점포 목록</span>
          </a>
        </li>
      </ul>
    </div>
    <script src="${pageContext.request.contextPath }/js/sidebar.js"> 
    </script>
    
    
  </body>
</html>
