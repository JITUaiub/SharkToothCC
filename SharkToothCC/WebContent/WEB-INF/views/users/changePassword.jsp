<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="common/header.jsp" />
<jsp:include page="common/topMenu.jsp" />
<body>
	<section class="hero ">
		<div class="hero-body">
		
			<div class="columns">
				<jsp:include page="common/leftMenu.jsp" />
				
				<div class="container has-text-centered">
				<div class="column is-8 is-offset-2">
					<h3 class="title has-text-grey">Change Password</h3>
					<p class="subtitle">&nbsp;</p>
					<p class="subtitle is-small" style="color: RED">${successMessage }</p>
					<div class="box">
						<form:form action="/SharkToothCC/user/profile/changePassword/action"
							method="get" modelAttribute="user">
							<div class="field">
								<div class="control">
									<form:errors path="password" cssClass="error" style="color: RED" />
									<input class="input" type="password" placeholder="New Password"
										name="password"">
								</div>
							</div>

							<div class="field is-grouped">
								<div class="control">
									<input type="submit" class="button is-primary"
										name="submitPasswordChange" value="Change Password" />
								</div>
							</div>
						</form:form>
					</div>
					<p class="title is-link" style="padding-bottom: 20px">Password Help</p>
					<p class="subtitle">1. Password should contains at least 8 character.</p>
					<p class="subtitle">2. Use at lease one uppercase and one lowercase character.</p>
					<p class="subtitle">3. Use at least one Special character, like @$&^.</p>
				</div>
			</div>
			</div>
		</div>
	</section>


	<jsp:include page="common/footer.jsp" />
</body>
</html>