<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 추가하기</h1>
		
		<div class="form-group">
			<label for="name">제목</label>
			<input type="text" id="name" class="form-control">
		</div>
		<div class="form-group">
			<label for="url">주소</label>
			<input type="text" id="url" class="form-control">
		</div>
		
		<input type="button" id="joinBtn" class="btn btn-success w-100" value="추가">
	</div>
	
<script>
	$(document).ready(function(){
		
		$('#joinBtn').on('click', function(){
			//alert("추가");
			
			// validation
			let name = $("#name").val().trim();
			if (!name){
				alert("제목을 입력하세요");
				return;
			}
			
			let url = $("#url").val().trim();
			if (!url){
				alert("주소를 입력하세요");
			}
			
		
			
			console.log(name);
			console.log(url);
			
			// AJAX: 서버 요청
			$.ajax({
				// request
				type:"POST"
				, url:"/lesson06/quiz01/add-bookmark"
				, data:{"name":name, "url":url}
			
				// response
				, success:function(data){
					// 서버 처리 후 에러가 없을 때 발생 
					if (data == "성공"){
						location.href = "/lesson06/quiz01/bookmark-list-view";
					}
				}
				, error:function(request, status, error){
					alert(request);
					alert(status);
					alert(error);
				}
			});
			
		});
	});
</script>
</body>
</html>