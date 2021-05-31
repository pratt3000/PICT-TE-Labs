<?php
	session_start();
	require_once "./functions/admin.php";
	$title = "Edit book";
	require_once "./template/header.php";
	require_once "./functions/database_functions.php";
	$conn = db_connect();

	if(isset($_GET['bookisbn'])){
		$book_isbn = $_GET['bookisbn'];
	} else {
		echo "Empty query!";
		exit;
	}

	if(!isset($book_isbn)){
		echo "Empty isbn! check again!";
		exit;
	}

	// get book data
	$query = "SELECT * FROM books WHERE book_isbn = '$book_isbn'";
	$result = mysqli_query($conn, $query);
	if(!$result){
		echo "Can't retrieve data " . mysqli_error($conn);
		exit;
	}
	$row = mysqli_fetch_assoc($result);
?>
<style>
body{
	color:white;
}
input{
	color:black;
}
th{
	font-size: 18px;
}
</style>
<body>
	<br>
	<form method="post" action="edit_book.php" enctype="multipart/form-data">
		<table class="table">
			<tr>
				<th>ISBN</th>
				<td><input type="text" name="isbn" value="<?php echo $row['book_isbn'];?>" style="width:250px;height:30px;" readOnly="true"></td>
			</tr>
			<tr>
				<th>Title</th>
				<td><input type="text" name="title" value="<?php echo $row['book_title'];?>" style="width:400px;height:40px;" required></td>
			</tr>
			<tr>
				<th>Author</th>
				<td><input type="text" name="author" value="<?php echo $row['book_author'];?>" style="width:400px;height:40px;" required></td>
			</tr>
			<tr>
				<th>Image</th>
				<td><input type="file" name="image"></td>
			</tr>
			<tr>
				<th>Description</th>
				<td><textarea name="descr" cols="40" rows="5"><?php echo $row['book_descr'];?></textarea>
			</tr>
			<tr>
				<th>Price</th>
				<td><input type="text" name="price" value="<?php echo $row['book_price'];?>" style="width:100px;height:30px;" required></td>
			</tr>
			<tr>
				<th>Publisher</th>
				<td><input type="text" name="publisher" value="<?php echo getPubName($conn, $row['publisherid']); ?>" style="width:300px;height:40px;" required></td>
			</tr>
		</table>
		<input type="submit" name="save_change" value="Save Changes" class="btn btn-primary">
		<a href="admin_book.php"><input type="reset" value="Cancel" class="btn btn-default"></a>
	</form>
	<br/>
	<p style="text-align:center"><a href="admin_book.php" class="btn btn-success">CONFIRM</a></p>
</body>
<?php
	if(isset($conn)) {mysqli_close($conn);}
	require "./template/footer.php"
?>
