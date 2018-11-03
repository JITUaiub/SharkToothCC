<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="common/header.jsp" />
<jsp:include page="common/topMenu.jsp" />
<body>
	<section class="hero ">
		<div class="hero-body">
			<div class="container has-text-centered">
				<div class="column is-8 is-offset-2">
					<h3 class="title has-text-grey">About Us</h3>
					
					<!-- Guild Information -->
					<p class=" subtitle has-text-primary"
						style="color: hsl(171, 100%, 41%);">Guild Information</p>
					<table class="table is-striped">
						<tbody>
						<tr>
								<td class="has-text-centered"><b>Game Name</b></td>
								<td class="has-text-centered">Castle Clash - A Brave Squad</td>
							</tr>
							<tr>
								<td class="has-text-centered"><b>Guild Name</b></td>
								<td class="has-text-centered">SharkTooth</td>
							</tr>
							<tr>
								<td class="has-text-centered"><b>Game Server</b></td>
								<td class="has-text-centered">Windows</td>
							</tr>
						</tbody>
					</table>
					<!-- Guild Statistics -->
					<p class=" subtitle has-text-primary"
						style="color: hsl(171, 100%, 41%);">Guild Statistics</p>
					<nav class="level">
						<div class="level-item has-text-centered">
							<div>
								<p class="heading">Total Members</p>
								<p class="title">${totalMember }</p>
							</div>
						</div>
						<div class="level-item has-text-centered">
							<div>
								<p class="heading">Active Members</p>
								<p class="title">${activeMember }</p>
							</div>
						</div>
						<div class="level-item has-text-centered">
							<div>
								<p class="heading">Vacancy</p>
								<p class="title">${vacancy }</p>
							</div>
						</div>
					</nav>
					<!-- Latest Scores -->
					<p class=" subtitle has-text-primary"
						style="color: hsl(171, 100%, 41%);">Latest Scores</p>
					<table class="table is-striped">
						<thead><tr>
								<td class="has-text-centered">Game Mode</td>
								<td class="has-text-centered">Ranking</td>
								<td class="has-text-centered">Scores</td>
							</tr></thead>
						<tbody>
							<tr>
								<td class="has-text-centered"><b>Guild Wars</b></td>
								<td class="has-text-centered">1</td>
								<td class="has-text-centered">200000</td>
							</tr>
							<tr>
								<td class="has-text-centered"><b>Fortress Feud</b></td>
								<td class="has-text-centered">1</td>
								<td class="has-text-centered">17000</td>
							</tr>
							<tr>
								<td class="has-text-centered"><b>Torch Battle</b></td>
								<td class="has-text-centered">1</td>
								<td class="has-text-centered">960 Shard</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>


	<jsp:include page="common/footer.jsp" />
</body>
</html>