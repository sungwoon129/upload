<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(function() {
		$("button").click(function() {
			var data = new FormData();
			
			data.append("uploadFile", $("#upload").prop("files")[0]);
			//jquery에서 file을 가져올 방법이 없어서 
			$.ajax("ajax/upload",{
				method:"POST",
				contentType:false,
				processData:false, //파일을 
				enctype: "multipart/form-data", //form태그로 할때처럼 파일업로드를 할때는 enctype을 써야한다
				data: data,
				success:function(result){
					$("ul").append("<li>" + result.filename + " (" + result.size + ")</li>");
				}
			});
		});
	});
</script>
</head>
<body>
	<div>
		<label>첨부파일: </label>
		<input id="upload" type="file">
		<button>등록</button>
	</div>
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