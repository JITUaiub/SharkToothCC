<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="common/header.jsp" />
<jsp:include page="common/topMenu.jsp" />
<body>
	<section class="hero ">
		<div class="hero-body">
			<div class="container has-text-centered">
				<div class="column is-4 is-offset-4">
					<h3 class="title has-text-grey">Recover Password</h3>
					<p class="subtitle has-text-grey">Enter email to recover
						password.</p>
					<p class="subtitle is-small" style="color: RED">${successMessage }</p>
					<div class="box">
						<form:form action="/SharkToothCC/account/recoverPassword/action"
							method="post" modelAttribute="user">
							<div class="field">
								<div class="control">
									<form:errors path="email" cssClass="error" style="color: RED" />
									<input class="input" type="email" placeholder="Your Email"
										name="email" value="${param.email }">
								</div>
							</div>

							<div class="field is-grouped">
								<div class="control">
									<input type="submit" class="button is-primary"
										name="submitContact" value="Submit Query" />
								</div>
								<div class="control">
									<a class="button is-text" href="/SharkToothCC/account/login">Login</a>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</section>


	<jsp:include page="common/footer.jsp" />
</body>
</html>