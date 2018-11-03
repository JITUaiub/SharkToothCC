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
				<div class="column is-6 is-offset-1 has-text-centered">
					<h3 class="title has-text-grey">User Profile</h3>
					<div class="box ">
						<div class="control">
							<table class="table">
								<tbody>
									<tr>
										<td><b>In-Game Username</b></td>
										<td><b>:</b></td>
										<td>${user.password }</td>
									</tr>
									<tr>
										<td><b>IGG ID</b></td>
										<td><b>:</b></td>
										<td>${user.iggId }</td>
									</tr>
									<tr>
										<td><b>Name</b></td>
										<td><b>:</b></td>
										<td>${user.name }</td>
									</tr>
									<tr>
										<td><b>Email</b></td>
										<td><b>:</b></td>
										<td>${user.email }</td>
									</tr>
									<tr>
										<td><b>Gender</b></td>
										<td><b>:</b></td>
										<td>${user.gender }</td>
									</tr>
									<tr>
										<td><b>Country</b></td>
										<td><b>:</b></td>
										<td>${user.country }</td>
									</tr>
									<tr>
										<td><b>Account Type</b></td>
										<td><b>:</b></td>
										<td>${user.accountType }</td>
									</tr>
									<tr>
										<td><b>Account Status</b></td>
										<td><b>:</b></td>
										<td>${user.status }</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<jsp:include page="common/footer.jsp" />
</body>
</html>