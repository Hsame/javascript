<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="css/header.css" />
    <!-- 아이콘 사용 링크 -->
    <link
      rel="stylesheet"
      href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css"
    />
  </head>
  <body>
    <header>
      <table class="head_table">
        <tr>
          <td>
            <a href="#"><img src="img/logo.PNG" alt="" /></a>
          </td>
          <td class="td_search">
            <i class="uil uil-search"></i>
            <input type="text" placeholder="지역, 식당 또는 음식" />
          </td>
          <td class="td_width">
            <div class="dropdown">
              <button class="dropbtn">
                <span class="dropbtn_icon">게시판</span>
              </button>
              <div class="dropdown-content">
                <a href="#">공지게시판</a>
                <a href="#">자유게시판</a>
              </div>
            </div>
          </td>
          <td class="td_width">
            <div class="dropdown">
              <button class="dropbtn">
                <span class="dropbtn_icon">마이페이지</span>
              </button>
              <div class="dropdown-content">
                <a href="#">정보수정</a>
                <a href="#">찜목록</a>
                <a href="#">예약확인</a>
              </div>
            </div>
          </td>
        </tr>
      </table>
    </header>
  </body>
</html>

