<%@page import="java.util.Calendar"%>
<!-- Footer -->
<div style="background-color: RED;"><div class="block">
	<nav class="nav">
		<div class="nav-left">
			<div class="nav-item">
				<h1 class="title is-4">Follow Us on</h1>
			</div>
		</div>

		<div class="nav-center">
			<a href="https://www.facebook.com/SharkToothCC" class="nav-item" target="_blank"> <span class="icon is-medium">
					<i class="fa fa-facebook" style="color: BLACK"></i>
			</span>
			</a> <a href="https://www.twitter.com/SharkToothCC" class="nav-item" target="_blank"> <span class="icon is-medium">
					<i class="fa fa-twitter" style="color: BLACK"></i>
			</span>
			</a> <a href="https://sharktoothworkspace.slack.com/" class="nav-item" target="_blank"> <span class="icon is-medium">
					<i class="fa fa-slack" style="color: BLACK"></i>
			</span>
			</a>
		</div>

		<div class="nav-right is-active">
			<div style="margin-right: 15px">
				<a href="/SharkToothCC/home">Home</a>
			</div>
			<div style="margin-right: 15px">
				<a href="/SharkToothCC/about" class="/SharkToothCC/about">About Us</a>
			</div>
			<div style="margin-right: 15px">
				<a href="/SharkToothCC/contact" class="">Contact Us</a>
			</div>
		</div>
	</nav>
</div></div>

<div class="block">
	<div class="box is-green">
		<div class="columns is-centered">
			Copyright &copy;<%
			out.print(Calendar.getInstance().get(Calendar.YEAR));
		%>
			SharkTooth - Castle Clash
		</div>
		<div class="columns is-centered">
			Developed by - <a href="#">Nashid Kamal (Jitu)</a>
		</div>
	</div>

</div>
<div style="margin-top: 50px"></div>