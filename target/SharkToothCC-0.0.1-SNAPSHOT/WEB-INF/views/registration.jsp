<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="common/header.jsp" />
<jsp:include page="common/topMenu.jsp" />
<body>
	<section class="hero ">
		<div class="hero-body">
			<div class="container has-text-centered">
				<div class="column is-6 is-offset-3">
				<p class="subtitle is-smaill" style="color: RED">${regSuccessMsg1 }</p>
					<h3 class="title has-text-grey">Sign up for a account</h3>
					<p class="subtitle has-text-grey">Please fill all informations.</p>
					<div class="box">
						<form:form action="/SharkToothCC/account/registration/action"
							method="post" modelAttribute="user">
							<div class="field">
								<div class="control">
									<p class="field" style="color: RED">
										<form:errors path="username" cssClass="error" />
									</p>
									<input class="input is-large" name="username" type="text"
										value="${param.username}"
										placeholder="In-Game Username" autofocus="">
									<p class="menu-label is-small" style="color: Green">You can
										change it any time.</p>
								</div>
							</div>
							<div class="field">
								<div class="control">
									<p class="field" style="color: RED">
										<form:errors path="iggId" cssClass="error" />
									</p>
									<input class="input is-large" name="iggId" type="text"
										value="${param.iggId}"
										placeholder="IGG ID">
								</div>
							</div>
							<div class="field">
								<div class="control">
									<p class="field" style="color: RED">
										<form:errors path="name" cssClass="error" />
									</p>
									<input class="input is-large" name="name" type="text"
										value="${param.name}"
										placeholder="Full Name">
								</div>
							</div>
							<div class="field">
								<div class="control">
									<p class="field" style="color: RED">
										<form:errors path="email" cssClass="error" />
									</p>
									<input class="input is-large" name="email" type="email"
										value="${param.email}"
										placeholder="Email">
								</div>
							</div>

							<div class="field">
								<div class="control">
									<p class="field" style="color: RED">
										<form:errors path="password" cssClass="error" />
									</p>
									<input class="input is-large" name="password" type="password"
										placeholder="Password">
									<p class="menu-label is-small" style="color: RED">Don't use
										in-game or email password for safety.</p>
								</div>
							</div>
							<input type="submit" name="registrationSubmit"
								value="Finish Sign Up"
								class="button is-block is-primary is-large is-fullwidth" />
						</form:form>
					</div>

					<p class="has-text-grey">
						Already have an account? <a href="/SharkToothCC/account/login">Login
							Now</a>
					</p>
				</div>
			</div>
		</div>
	</section>


	<jsp:include page="common/footer.jsp" />
</body>
</html>