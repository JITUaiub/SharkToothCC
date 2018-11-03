<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="common/header.jsp" />
<jsp:include page="common/topMenu.jsp" />
<body>
	<section class="hero ">
		<div class="hero-body">
			<div class="columns">
				<jsp:include page="common/leftMenu.jsp" />

				<div class="column is-9" style="padding-right: 40px;">
				<div class="block">
							<div class="notification is-warning">Your account seems
								inactive. Please contact Guild admin to use all features , or you can wait until
								they make your account active.</div>
						</div>
					<section class="hero is-info welcome is-small">
						
						<div class="hero-body">
							<div class="container">
								<h1 class="title" style="padding-left: 20px">Hello,
									${loggedUser.name }.</h1>
								<h2 class="subtitle" style="padding-left: 20px">I hope you
									are having a great day!</h2>
							</div>
						</div>
					</section>
					<section class="info-tiles"
						style="padding-top: 20px; padding-bottom: 20px;">
						<div class="tile is-ancestor has-text-centered">
							<div class="tile is-parent">
								<article class="tile is-child box">
									<p class="title">
										<a href="#">0</a>
									</p>
									<p class="subtitle">Joining Request</p>
								</article>
							</div>
							<div class="tile is-parent">
								<article class="tile is-child box">
									<p class="title">
										<a href="#">3</a>
									</p>
									<p class="subtitle">Scores Added</p>
								</article>
							</div>
							<div class="tile is-parent">
								<article class="tile is-child box">
									<p class="title">
										<a href="#">5</a>
									</p>
									<p class="subtitle">Query From Public</p>
								</article>
							</div>
							<div class="tile is-parent">
								<article class="tile is-child box">
									<p class="title">
										<a href="#">1</a>
									</p>
									<p class="subtitle">Score Update Request</p>
								</article>
							</div>
						</div>
					</section>
					<div class="columns">
						<div class="column is-6">
							<div class="card events-card">
								<header class="card-header">
									<p class="card-header-title">Notifications</p>
									<a href="#" class="card-header-icon" aria-label="more options">
										<span class="icon"> <i class="fa fa-angle-down"
											aria-hidden="true"></i>
									</span>
									</a>
								</header>
								<div class="card-table">
									<div class="content">
										<table class="table is-fullwidth is-striped">
											<tbody>
												<tr>
													<td width="5%"><i class="fa fa-bell-o"></i></td>
													<td>ABC changed his username</td>
													<td><a class="button is-small is-primary" href="#">Action</a></td>
												</tr>
												<tr>
													<td width="5%"><i class="fa fa-bell-o"></i></td>
													<td>New Guild Wars Score Added</td>
													<td><a class="button is-small is-primary" href="#">Action</a></td>
												</tr>
												<tr>
													<td width="5%"><i class="fa fa-bell-o"></i></td>
													<td>XYZ claimed his scores are wrong.</td>
													<td><a class="button is-small is-primary" href="#">Action</a></td>
												</tr>
												
											</tbody>
										</table>
									</div>
								</div>
								<footer class="card-footer">
									<a href="#" class="card-footer-item">View All</a>
								</footer>
							</div>
						</div>
						<div class="column is-6">
							<div class="card">
								<header class="card-header">
									<p class="card-header-title">User Search</p>
								</header>
								<div class="card-content">
									<div class="content">
										<div class="control has-icons-left has-icons-right">
											<input class="input is-large" placeholder="username"
												type="text"> <span class="icon is-medium is-left">
												<i class="fa fa-search"></i>
											</span>
										</div>
									</div>
								</div>
							</div>

							<div class="card">
								<header class="card-header">
									<p class="card-header-title">User Details</p>
								</header>
								<div class="card-content">
									<div class="content">
										<table class="table is-striped">
											<tbody>
												<tr>
													<td><b>Name</b></td>
													<td>Md. Nashid Kamal</td>
												</tr>
												<tr>
													<td><b>Might</b></td>
													<td>102354</td>
												</tr>
												<tr>
													<td><b>Donation</b></td>
													<td>45684</td>
												</tr>
												<tr>
													<td><b>Average Guild Wars Score</b></td>
													<td>3456</td>
												</tr>
												<tr>
													<td><b>Overall Performance</b></td>
													<td>Good</td>
												</tr>
												<tr>
													<td><b>Last Torch Battle Haul</b></td>
													<td>15</td>
												</tr>
												<tr>
													<td><b>Last Fortress Feud Score</b></td>
													<td>125</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</section>


	<jsp:include page="common/footer.jsp" />
</body>
</html>

