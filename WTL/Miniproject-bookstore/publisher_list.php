<?php
	session_start();
	require_once "./functions/database_functions.php";
	$conn = db_connect();

	$query = "SELECT * FROM publisher ORDER BY publisherid";
	$result = mysqli_query($conn, $query);
	if(!$result){
		echo "Can't retrieve data " . mysqli_error($conn);
		exit;
	}
	if(mysqli_num_rows($result) == 0){
		echo "Empty publisher ! Something wrong! check again";
		exit;
	}

	$title = "List Of Publishers";
	require "./template/header.php";
?>
	<p class="lead" style="color: white;font-size:20px;">List of Publishers: </p>
	<ul>
	<?php
		while($row = mysqli_fetch_assoc($result)){
			$count = 0;
			$query = "SELECT publisherid FROM books";
			$result2 = mysqli_query($conn, $query);
			if(!$result2){
				echo "Can't retrieve data " . mysqli_error($conn);
				exit;
			}
			while ($pubInBook = mysqli_fetch_assoc($result2)){
				if($pubInBook['publisherid'] == $row['publisherid']){
					$count++;
				}
			}
	?>
		<li>
			<span class="badge"><?php echo $count; ?></span>
		    <a style="color: white;font-size:18px;" href="bookPerPub.php?pubid=<?php echo $row['publisherid']; ?>"><?php echo $row['publisher_name']; ?></a>
		</li>
	<?php } ?>
		<!-- <li> -->
		</ul><br>
			<a style="color:white;font-size:18px;" href="books.php">Click here to get a list of all books</a>
		<!-- </li> -->

<?php
	mysqli_close($conn);
	require "./template/footer.php";
?>
