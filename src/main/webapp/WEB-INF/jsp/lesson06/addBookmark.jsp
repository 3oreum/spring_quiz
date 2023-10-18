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
			<div class="d-flex">	
				<input type="text" id="url" class="form-control">
				<input type="button" id="urlCheckBtn" class="btn btn-info ml-3" value="중복확인">
			</div>
			<small class="text-danger d-none" id="duplicatedText">중복된 url입니다.</small>
			<small class="text-success d-none" id="availableText">저장 가능한 url입니다.</small>
		</div>
		
		<input type="button" id="joinBtn" class="btn btn-success w-100" value="추가">
	</div>
	
<script>
	$(document).ready(function(){
		// Quiz2) 중복 확인 버튼 클릭
		$('#urlCheckBtn').on('click', function(){
			//alert("클릭");
			let url = $('#url').val().trim();
			if (!url){
				alert("검사할 url을 입력하세요.");
				return;
			}
			
			// DB에서 url 중복 확인 - AJAX 통신으로
			$.ajax({
				// request
				type:"POST" // url이 길 수도 있기 때문에 post
				, url:"/lesson06/quiz02/is-duplicated-url"
				, data:{"url":url}
			
				// response
				, success:function(data){
					// {"code":200, "is_duplication":true} true이면 중복
					if (data.is_duplication){
						// 여기 오면 중복
						$('#duplicatedText').removeClass('d-none');
						$('#availableText').addClass('d-none');
					} else {
						// 중복 아님
						$('#duplicatedText').addClass('d-none');
						$('#availableText').removeClass('d-none');
					}
				}
				, error:function(request, status, error){
					alert("중복 확인에 실패했습니다.");
				}
			});
		});
		
		
		
		// 추가 버튼 클릭
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
				return;
			}
			
			// 둘 다 아니어야 해서 또는은 안 됨
			if (!url.startsWith('http://') && !url.startsWith('https://')){
				alert("주소 형식이 잘못되었습니다");
				return;
			}

			console.log(name);
			console.log(url);
			
			// Quiz02) 저장 가능한 url인지 체크
			if ($('#availableText').hasClass('d-none')){ // availableText d-none이 있으면 가입 불가
				alert("URL 중복 확인을 다시 해주세요.");
				return;
			}
			
			
			// AJAX: 서버 요청
			$.ajax({
				// request
				type:"POST"
				, url:"/lesson06/quiz01/add-bookmark"
				, data:{"name":name, "url":url}
			
				// response
				, success:function(data){ // data: response 응답값(JSON String) => Dictory Object
					// data는 JSON String => Object 변환된 형태로 사용할 수 있다
					// jquery의 ajax 함수 기능
					/* alert(data.code);
					alert(data.result); */
					
					if (data.code == 200){ // data.result == "success" 이렇게 해도 됨
						location.href = "/lesson06/quiz01/bookmark-list-view";
					}
				}
				, error:function(request, status, error){ // 사용자가 볼 수 있기 때문에 저렇게 함
					alert("추가에 실패했습니다. 관리자에게 문의해주세요.");
					//alert(status);
					//alert(error);
				}
			});
			
			
		});
		
	});
</script>
</body>
</html>