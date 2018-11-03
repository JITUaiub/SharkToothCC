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
					<h3 class="title has-text-grey">Contact Us</h3>
					<p class="subtitle has-text-grey">Feel free to contact with us.</p>
					<p class="subtitle is-small" style="color: RED">${contactSuccess }</p>
					<div class="box">
						<form:form action="/SharkToothCC/contact/action" method="post" modelAttribute="usersQuery">
							<div class="field">
								<div class="control">
									<form:errors path="name" cssClass="error"  style="color: RED"/>
									<input class="input" type="text" placeholder="Your Name"
										name="name" autofocus="" value="${param.name }">
								</div>
							</div>

							<div class="field">
								<div class="control">
									<form:errors path="email" cssClass="error"  style="color: RED"/>
									<input class="input" type="email" placeholder="Your Email"
										name="email"  value="${param.email }"> 
								</div>
							</div>

							<div class="field">
								<div class="control">
									<div class="select is-fullwidth">
										<select name="subject">
											<option>Guild Joining</option>
											<option>Guild Information</option>
											<option>Others</option>
										</select>
									</div>
								</div>
							</div>

							<div class="field">
								<div class="control">
								<form:errors path="message" cssClass="error"  style="color: RED"/>
									<textarea class="textarea" name="message"
										placeholder="Enter Message here" value="${param.message }"></textarea>
								</div>
							</div>
							<div class="field is-grouped">
								<div class="control">
									<input type="submit" class="button is-primary"
										name="submitContact" href="/SharkToothCC/contact-success"
										value="Submit Query" />
								</div>
								<div class="control">
									<a class="button is-text" href="/SharkToothCC/home">Home</a>
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