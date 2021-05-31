<?php
	session_start();
	require_once "./functions/admin.php";
	$title = "List book";
	require_once "./template/header.php";
	require_once "./functions/database_functions.php";
	$conn = db_connect();
	$result = getAll($conn);
?>
<style>
body{
	color: white;
}
.btn{
	margin-left: 90%;
	margin-top: 2%;
}
</style>
<body>

<a href="admin_signout.php" class="btn btn-primary">Sign out!</a>
	<p class="lead" style="text-align:left;"><a style="color:black;" href="admin_add.php">Add new book</a></p>
	<table class="table" style="margin-top: 20px">
		<tr>
			<th>ISBN</th>
			<th>TITLE</th>
			<th>AUTHOR</th>
			<th>DESCRIPTION</th>
			<th>PRICE</th>
			<th>PUBLISHER</th>
			<th>&nbsp;&nbsp;</th>
			<th>&nbsp;&nbsp;</th>
		</tr>
		<?php while($row = mysqli_fetch_assoc($result)){ ?>
		<tr>
			<td><?php echo $row['book_isbn']; ?></td>
			<td><?php echo $row['book_title']; ?></td>
			<td><?php echo $row['book_author']; ?></td>
			<td><?php echo $row['book_descr']; ?></td>
			<td><?php echo $row['book_price']; ?></td>
			<td><?php echo getPubName($conn, $row['publisherid']); ?></td>
			<td><a style="color:#33ff77;font-weight:bold;" href="admin_edit.php?bookisbn=<?php echo $row['book_isbn']; ?>">EDIT</a></td>
			<td><a style="color:#ff4d4d;font-weight:bold;" href="admin_delete.php?bookisbn=<?php echo $row['book_isbn']; ?>">DELETE</a></td>
		</tr>
		<?php } ?>
	</table>
</body>
<?php
	if(isset($conn)) {mysqli_close($conn);}
	require_once "./template/footer.php";
?>
