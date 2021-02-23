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

          <c:if test="${blackSquare[i.index][j.index] == '●'}">

              <c:set var="blackchange" value="false"></c:set>
              <c:forEach var = "changelist" items="${changeSquareList2}">
                      <c:if test = "${changelist[0] == i.index && changelist[1] == j.index}" var="result1">
                        <td class="blackToWhiteChange" id="(${i.index},${j.index})" width="60px" height="60px"><font size="6">${blackSquare[i.index][j.index]}</font></td>
                        <c:set var="blackchange" value="true"></c:set>
                      </c:if>
              </c:forEach>
                      <c:if test="${blackchange == false}" >
                        <td class="noneChange" width="60px" height="60px"><font size="6">${blackSquare[i.index][j.index]}</font></td>
                      </c:if>


          </c:if>

          <c:if test="${whiteSquare[i.index][j.index] == '○'}">

              <c:set var="whitechange" value="false"></c:set>
              <c:forEach var = "changelist" items="${changeSquareList2}">
                    <c:if test = "${changelist[0] == i.index && changelist[1] == j.index}" var="result2">
                      <td class="whiteToBlackChange" id="(${i.index},${j.index})" width="60px" height="60px"><font size="6">${whiteSquare[i.index][j.index]}</font></td>
                      <c:set var="whitechange" value="true"></c:set>
                    </c:if>
              </c:forEach>
                    <c:if test="${whitechange == false}" >
                      <td class="noneChange" width="60px" height="60px"><font size="6">${whiteSquare[i.index][j.index]}</font></td>
                    </c:if>
          </c:if>


          <c:if test="${nullSquare[i.index][j.index] == 'empty'}" var="result3">

              <c:set var="nullCanPut" value="false"></c:set>
              <c:forEach var = "canPutSquare" items="${canPutSquareList}">
                    <c:if test = "${canPutSquare[0] == i.index && canPutSquare[1] == j.index}" var="result3">
                      <td class="canPutSquare" id="(${i.index},${j.index})" width="60px" height="60px"><font size="6"><a href="">　</a></font></td>
                      <c:set var="nullCanPut" value="true"></c:set>
                    </c:if>
              </c:forEach>
                    <c:if test="${nullCanPut == false}" >
                      <td class="noneChange" width="60px" height="60px"><font size="6"></font></td>
                    </c:if>
          </c:if>


    </c:forEach>
    </tr>
  </c:forEach>
</table>

</body>
</html>