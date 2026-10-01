<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
</head>
<body>
    <h1>Add Book</h1>

    <form action="add_book.php" method="post">
        <p>
            <label for="title">Title</label><br>
            <input type="text" id="title" name="title" required>
        </p>

        <p>
            <label for="author">Author</label><br>
            <input type="text" id="author" name="author" required>
        </p>

        <p>
            <label for="price">Price</label><br>
            <input type="text" id="price" name="price" required>
        </p>

        <p>
            <label for="stock_quantity">Stock</label><br>
            <input type="text" id="stock_quantity" name="stock_quantity" required>
        </p>

        <input type="submit" value="Add Book">
    </form>

    <p><a href="book_details.php">Back to book list</a></p>
</body>
</html>
