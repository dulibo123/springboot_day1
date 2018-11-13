<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ems1.0/css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							<fmt:formatDate value="<%=new Date() %>" pattern="yyyy-MM-dd"/>
							<br />
							安全退出
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Salary
							</td>
							<td>
								Age
							</td>
							<td>
								Operation
							</td>
						</tr>
					<c:forEach items="${requestScope.queryAllEmployees}" var="q">
						<tr class="row1">
							<td>
								${q.id}
							</td>
							<td>
								${q.name}
							</td>
							<td>
								${q.salary}
							</td>
							<td>
								${q.age}
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/employees/delete?id=${q.id}&pageNum=${requestScope.page1}">delete emp</a>&nbsp;<a href="${pageContext.request.contextPath}/ems1.0/updateEmp.jsp?id=${q.id}&name=${q.name}&salary=${q.salary}&age=${q.age}">update emp</a>
							</td>
						</tr>
					</c:forEach>
						
					</table>
					<p>
						<a href="${pageContext.request.contextPath}/ems1.0/addEmp.jsp"><input type="button" class="button" value="Add Employee" onclick=""/></a>
					</p>
				</div>
				<c:forEach items="${requestScope.pageAmount }" var="page">
			
				<c:if test="${requestScope.page1==page }">
				${page }
				</c:if>
				<c:if test="${requestScope.page1!=page }">
					<a href="${pageContext.request.contextPath}/employees/showAllEmployees?pageNum=${page }">${page }</a>
				</c:if>
				</c:forEach>
				
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
