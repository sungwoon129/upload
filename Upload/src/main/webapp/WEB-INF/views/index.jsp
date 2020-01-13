<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<form action="upload" method="post" enctype="multipart/form-data">
		<div>
			<label>첨부파일: </label>
			<input name="uploadFile" type="file">
		</div>
		<div>
			<input type="submit" value="등록">
		</div>
	</form>
	<div>
		<ul>
			<c:choose>
				<c:when test="${list.size() > 0}">
					<c:forEach var="item" items="${list}">
						<li>${item.filename} &lt;${item.size}&gt;</li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<li>등록 된 파일이 없습니다</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</body>
</html>