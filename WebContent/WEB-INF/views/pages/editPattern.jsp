<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>EDIT</h1>
<form:form method="POST" action="${pageContext.request.contextPath}/editPattern/${pattern.id }" modelAttribute="pattern">
	<div class="form-group">
		<form:label path="name" >Name</form:label>
		<form:input path="name" class="form-control" placeholder="name" />
	</div>
	<div class="form-group">
		<form:label path="group" >Group</form:label>
		<form:input path="group" class="form-control" placeholder="group" />
	</div>
	<div class="form-group">
		<form:label path="implementation" >Implementation</form:label>
		<form:input path="implementation" class="form-control" placeholder="implementation"/>
	</div>
	<button type="submit" class="btn btn-default">Save</button>
</form:form>