<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz05</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

</head>
<body>
	<div>
		<div class="d-flex">
			<div class="col-2">
				<nav>
					<ul class="nav">
						<li class="nav-item"><a href="#" class="nav-link"></a></li>
					</ul>
				</nav>
			</div>
			<div clss="col-10">
				<h2>과거 날짜</h2>
				
				<table class="table text-center">
					<thead>
						<tr>
							<th>날짜</th>
							<th>날씨</th>
							<th>기온</th>
							<th>강수량</th>
							<th>미세먼지</th>
							<th>풍속</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${weatherHistory}" var="history">
						<tr>
							<td>${history.date}
								<fmt:parseDate value="${history.date}" pattern="yyyy-MM-dd" var="date" />
								<fmt:formatDate vlaue="${date}" pattern="yyyy년 M월 d일" />
							</td>
							<td>${history.weather}
								<c:choose>
									<c:when test="${history.weather eq '맑음'}">
										<img src="맑음" alt="/img/sunny.jpg">
									</c:when>
									<c:when test="${history.weather eq '구름조금'}">
										<img src="/img/partlyCloudy.jpg" alt="구름조금">
									</c:when>
									<c:when test="${history.weather eq '흐림'}">
										<img src="/img/cloudy.jpg" alt="흐림">
									</c:when>
									<c:otherwise>
										<img src="/img/rainy.jpg" alt="비">
									</c:otherwise>
								</c:choose>
							</td>
							<td>${history.temperatures}</td>
							<td>${history.precipitation}mm</td>
							<td>${history.microDust}</td>
							<td>${history.windSpeed}km/h</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<footer>
			<div></div>
			<div>
			(07062) 서울시 동작구 여의대방로16길 61
			</div>
		</footer>
	</div>
</body>
</html>