<?php
require_once('../connect.php');

$book_id = filter_input(INPUT_GET, 'id', FILTER_VALIDATE_INT);

if (!$book_id) {
    echo '<p>Invalid book ID.</p>';
    exit();
}

$query = 'SELECT id, title, author,price,stock_quantity FROM book_details WHERE id = :id';
$statement = $db->prepare($query);
$statement->execute([':id' => $book_id]);

$book = $statement->fetch();

if (!$book) {
    echo '<p>Book not found.</p>';
    exit();
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Book</title>
</head>
<body>

<h1>Edit Book</h1>

<form action="edit_book.php" method="post">

    <!-- Hidden ID identifies which book will be updated. -->
    <input type="hidden" name="id" value="<?php echo htmlspecialchars((string) $book['id']); ?>">

    <p>
        <label for="title">Title</label><br>
        <!-- Pre-fill with the current database value. -->
        <input type="text" id="title" name="title" value="<?php echo htmlspecialchars($book['title']); ?>" required>
    </p>

    <p>
        <label for="author">author</label><br>
        <!-- Pre-fill with the current database value. -->
        <input type="text" id="author" name="author" value="<?php echo htmlspecialchars($book['author']); ?>" required>
    </p>

    <p>
        <label for="price">Price</label><br>
        <!-- Pre-fill with the current database value. -->
        <input type="text" id="price" name="price" value="<?php echo htmlspecialchars($book['price']); ?>" required>
    </p>

    <p>
        <label for="stock_quantity">Stock Quantity</label><br>
        <!-- Pre-fill with the current database value. -->
        <input type="text" id="stock_quantity" name="stock_quantity" value="<?php echo htmlspecialchars($book['stock_quantity']); ?>" required>
    </p>

    <input type="submit" value="Update Book">
</form>

<p><a href="book_details.php">Back to book list</a></p>

</body>
</html>