<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Make TODO</title>
	<style type="text/css"><!-- Simple Css -->
		html, body{ margin:0; padding:0}
		body{ width:1000px; margin:0 auto; }
	</style>
	
</head>
	
<body>
	<table border="0" cellpadding="0" cellspacing="0" style="margin:auto;">
		<tr><!-- BOARD TITLE -->
			<td align="center"><h2>할일 등록!</h2></td>
		</tr>
		<tr height="40"><!-- BOARD WRITE -->
			<td><b>어떤 일인가요?</b></td>
		</tr>
		<tr height="40">
			<td>
				<input id="regi_title" type="text" size="50" maxlength="50" />
			</td>
		</tr>
		<tr height="40">
			<td><b>누구 할 일 인가요?</b></td>
		</tr>
		<tr height="40">
			<td><input id="regi_name" type="text" size="50" maxlength="50" /></td>
		</tr>
		<tr height="40">
			<td><b>우선순위를 선택하세요</b></td>
		</tr>
		<tr height="40">
			<td>
				<input type="radio" name="chk_info" value="1">1순위
				<input type="radio" name="chk_info" value="2">2순위
				<input type="radio" name="chk_info" value="3">3순위
			</td>
		</tr>
	</table>
	<button type="button" id="bt_register">등록</button>
	<script type="text/javascript">
		document.getElementById("bt_register").onclick=add;
		
		function add(){
			var xhr = new XMLHttpRequest();
			var data = {
					  name: 'zerocho',
					  title: '만만',
					  sequence: '1'
					};
			
			/* xhr.onload = function() {
			  if (xhr.status === 200 || xhr.status === 201) {
			    console.log(xhr.responseText);
			  } else {
			    console.error(xhr.responseText);
			  }
			}; */
			xhr.onreadystatechange = function() { // listen for state changes
				  if (xhr.readyState == 4 && xhr.status == 200) { // when completed we can move away
				    window.location = "/todolist/main";
				 }
			}
			xhr.open('POST', 'http://localhost:8089/todolist/make');
			xhr.setRequestHeader('Content-Type', 'application/json'); // 컨텐츠타입을 json으로
			xhr.send(JSON.stringify(data)); // 데이터를 stringify해서 보냄
			
		}
	
	</script>	
</body>
</html>