<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨 찾기 목록</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 목록</h1>
		
		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${bookmarkList}" var="bookmark">
				<tr>
					<td>${bookmark.id}</td>
					<td>${bookmark.name}</td>
					<td><a href="${bookmark.url}">${bookmark.url}</a></td>
					<td>
						<%-- 1) value 속성을 이용해서 값 세팅 (한개밖에 세팅 못함)--%>
						<!-- <button type="button" class="del-btn btn btn-danger" value="${bookmark.id}">삭제</button>  -->
						
						<%-- 2) data를 이용해서 태그에 값 세팅: data 뒤에 대문자가 들어가면 안 됨 절 대 로, 여러개 세팅 가능 --%>
						<button type="button" class="del-btn btn btn-danger" data-bookmark-id="${bookmark.id}">삭제</button>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

<script>
$(document).ready(function(){
	// 삭제 버튼 클릭
	$('.del-btn').on('click', function(e){
		//alert("삭제");
		
		// * valueㅇㅔ 대한 거
		// 1) 
		//let id = $(this).val();
		
		// 2)
		//let id = e.target.value; // 지금 클릭된 객체의 아이디를 가져온다 
		
		
		// * data에 대한 거
		// data-bookmark-id => data("bookmark-id") 함수 사용
		let id = $(this).data('bookmark-id');
	
		//alert(id);
		
		$.ajax({
			//request
			type:"DELETE"
			, url:"/lesson06/quiz02/delete-bookmark"
			, data:{"id":id}
		
			//response
			, success:function(data){
				/* result.put("code", 200);
				result.put("result", "성공"); */
				if (data.code == 200){ // data.result == "성공" 도 됨
					location.reload(true); // 새로고침 스크롤 움직임 없움 (true) 넣어도 되고 안 넣어도 됨
				} else { // 성공은 했는데 로직상 실패
					alert("삭제를 하는데 실패했습니다. 다시 시도해주세요.");
				}
			}
			, error:function(request, status, error){ // 진ㅉㅏ 실패
				alert("삭제를 하는데 실패했습니다. 관리자에게 문의해주세요.");
			}
		});
	});
});
</script>
</body>
</html>