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
					<p class="subtitle" style="color: RED">${loginErrorMsg }</p>
					<h3 class="title has-text-grey">Login</h3>
					<p class="subtitle has-text-grey">Please enter your credential.</p>
					<div class="box">
						<figure class="avatar">
							<img
								src="https://www.shareicon.net/data/128x128/2016/07/21/799338_user_512x512.png">
						</figure>
						<form:form action="/SharkToothCC/account/login/action"
							method="post" modelAttribute="userLogin">

							<div class="field">
								<div class="control">
									<p class="field" style="color: RED">
										<form:errors path="email" cssClass="error" />
									</p>
									<input class="input is-large" name="email" type="email"
										value="${param.email}"
										placeholder="Your Email" autofocus="">
								</div>
							</div>

							<div class="field">
								<div class="control">
									<p class="field" style="color: RED">
										<form:errors path="password" cssClass="error" />
									</p>
									<input class="input is-large" name="password" type="password"
										placeholder="Your Password">
								</div>
							</div>
							<input type="submit" name="loginSubmit" value="Login"
								class="button is-block is-primary is-large is-fullwidth" />
						</form:form>
					</div>
					<p class="has-text-grey">
						<a href="/SharkToothCC/account/registration">Sign Up</a>
						&nbsp;·&nbsp; <a href="/SharkToothCC/account/recoverPassword">Forgot
							Password</a>
					</p>
				</div>
			</div>
		</div>
	</section>


	<jsp:include page="common/footer.jsp" />
</body>
</html>