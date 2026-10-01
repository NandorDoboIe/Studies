<?php
// Load the PDO database connection from connect.php.
require_once('../connect.php');

// Retrieve book records from the database, ordered by ID.
$query = 'SELECT id, title, author,price,stock_quantity FROM book_details ORDER BY id';

// Execute the SELECT query.
// $books is a PDOStatement that can be looped through with foreach.
$books = $db->query($query);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Management</title>
</head>
<body>

<h1>Book Management</h1>

<!-- Show how many rows were inserted, if available. -->
<?php if (isset($insert_count)) : ?>
    <p>Insert count: <?php echo htmlspecialchars((string) $insert_count); ?></p>
<?php endif; ?>

<!-- Show how many rows were updated, if available. -->
<?php if (isset($update_count)) : ?>
    <p>Update count: <?php echo htmlspecialchars((string) $update_count); ?></p>
<?php endif; ?>

<!-- Show how many rows were deleted, if available. -->
<?php if (isset($delete_count)) : ?>
    <p>Delete count: <?php echo htmlspecialchars((string) $delete_count); ?></p>
<?php endif; ?>

<p><a href="../add/add_book_form.php">Add a new book</a></p>

<h2>Book Inventory</h2>

<table border="1" cellpadding="8">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Price</th>
        <th>Stock</th>
    </tr>

    <!-- Loop through each book returned by the SELECT query. -->
    <?php foreach ($books as $book) : ?>
        <tr>
            <!-- Display database values safely as text. -->
            <td><?php echo htmlspecialchars((string) $book['id']); ?></td>
            <td><?php echo htmlspecialchars($book['title']); ?></td>
            <td><?php echo htmlspecialchars($book['author']); ?></td>
            <td><?php echo htmlspecialchars($book['price']); ?></td>
            <td><?php echo htmlspecialchars($book['stock_quantity']); ?></td>

            <td>
                <!-- Send the book ID to the edit page using GET. -->
                <a href="../edit/edit_book_form.php?id=<?php echo urlencode((string) $book['id']); ?>">
                    Edit
                </a>

                <!-- Send the book ID to delete_book.php using POST. -->
                <form action="../delete/delete_book.php" method="post" style="display:inline;">
                    <!-- Hidden field becomes $_POST['id']. -->
                    <input type="hidden" name="id"
                           value="<?php echo htmlspecialchars((string) $book['id']); ?>">

                    <!-- Ask for confirmation before submitting the delete form. -->
                    <input type="submit" value="Delete"
                           onclick="return confirm('Delete this book?');">
                </form>
            </td>
        </tr>
    <?php endforeach; ?>
</table>

</body>
</html>