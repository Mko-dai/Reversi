<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.text.NumberFormat, java.util.ArrayList"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Playing</title>
<link rel="stylesheet" href="css/view.css">
</head>
<body>
<h1>オセロ</h1>
<p>

  <c:if test="${color == 'black'}">
    ●の番です
  </c:if>
  <c:if test="${color == 'white'}">
    ○の番です
  </c:if>

</p>

<table class="table2">
  <c:forEach begin="0" end="7" varStatus="i">
    <tr>
    <c:forEach begin="0" end="7" varStatus="j">
      <td width="60px" height="60px">
          <font size="6">${blackSquare[i.index][j.index]}${whiteSquare[i.index][j.index]}</font>
      </td>
    </c:forEach>
    </tr>
  </c:forEach>
</table>

</body>
</html>