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


				<div class="column is-6 is-offset-1">
					<p class="subtitle is-smaill" style="color: RED">${updateSuccessMsg }</p>
					<h3 class="title has-text-grey has-text-centered">Edit Profile</h3>

					<div class="box">
						<form:form action="/SharkToothCC/user/profile/edit/action"
							method="post" modelAttribute="user">
							<p class="subtitle">In-Game Username</p>
							<div class="field">
								<div class="control">
									<p class="field" style="color: RED">
										<form:errors path="username" cssClass="error" />
									</p>
									<input class="input is-large" name="username" type="text"
										value="${user.username}" placeholder="In-Game Username"
										autofocus="">
								</div>
							</div>
							<p class="subtitle">Full Name</p>
							<div class="field">
								<div class="control">
									<p class="field" style="color: RED">
										<form:errors path="name" cssClass="error" />
									</p>
									<input class="input is-large" name="name" type="text"
										value="${user.name}" placeholder="Full Name">
								</div>
							</div>
							<p class="subtitle">IGG ID</p>
							<div class="field">
								<div class="control">
									<p class="field" style="color: RED">
										<form:errors path="iggId" cssClass="error" />
									</p>
									<input class="input is-large" name="iggId" type="text"
										value="${user.iggId}" placeholder="IGG ID">
								</div>
							</div>
							<p class="subtitle">Gender</p>
							<div class="select is-fullwidth">
								<select name="gender">
									<option value="Male">Male</option>
									<option value="Female">Female</option>
									<option value="Other">Other</option>
								</select>
							</div>
							<p class="subtitle">Country</p>
							<div class="field">
								<div class="control">
									<p class="field" style="color: RED">
										<form:errors path="country" cssClass="error" />
									</p>
									<input class="input is-large" name="country" type="text"
										value="${user.country}" placeholder="Country">
								</div>
							</div>

							<input type="submit" name="updateSubmit" value="Update Profile"
								class="button is-block is-primary is-large is-fullwidth" />
						</form:form>
					</div>

				</div>

			</div>
		</div>
	</section>


	<jsp:include page="common/footer.jsp" />
</body>
</html>