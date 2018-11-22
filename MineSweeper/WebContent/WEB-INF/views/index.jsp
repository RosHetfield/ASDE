<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
.row.content {
	height: 1500px
}

/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>

	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h4>John's Blog</h4>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#section1">Home</a></li>
					<li><a href="#section2">Friends</a></li>
					<li><a href="#section3">Family</a></li>
					<li><a href="#section3">Photos</a></li>
				</ul>
				<br>
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search Blog..">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
				<div>
					<h4>${user}</h4>
					<form action="logout">
						<input type="submit" class="btn btn-danger" value="logout">
					</form>
				</div>
			</div>

			<div class="col-sm-9">

				<c:forEach items="${posts}" var="post">

					<h4>
						<small>RECENT POSTS</small>
					</h4>
					<hr>
					<h2>${post.title}</h2>
					<h5>
						<span class="glyphicon glyphicon-time"></span> Post by ${post.poster.username},
						${post.creationDate}
					</h5>
					<h5>
						<span class="label label-danger">Food</span> <span
							class="label label-primary">Ipsum</span>
					</h5>
					<br>
					<p>${post.corpus}</p>
					<br>
					<br>
					<h4>Leave a Comment:</h4>
				<form role="form">
					<div class="form-group">
						<textarea class="form-control" rows="3" required></textarea>
					</div>
					<button type="submit" class="btn btn-success">Submit</button>
				</form>
				<br>
				<br>

				<p>
					<span class="badge">${post.comments.size()}</span> Comments:
				</p>
				<br>

				<div class="row">
					<c:forEach items="${post.comments}" var="comment">
						<div class="col-sm-2 text-center">
							<img src="resources/avatar.svg" class="img-circle" height="65"
								width="65" alt="Avatar">
						</div>
						<div class="col-sm-10">
							<h4>
								${comment.commenter.username} <small>${comment.creationDate}</small>
							</h4>
							<p>${comment.corpus}</p>
							<br>
						</div>
					</c:forEach>


				
				

				</div>

				
				</c:forEach>
				
			</div>
		</div>
	</div>

	<footer class="container-fluid">
		<p>Footer Text</p>
	</footer>

</body>
</html>
