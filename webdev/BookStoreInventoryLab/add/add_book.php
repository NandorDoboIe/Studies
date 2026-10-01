<?php

require_once('../connect.php');

$title = trim($_POST['title'] ?? '');
$author = trim($_POST['author'] ?? '');
$price = trim($_POST['price'] ?? '');
$stock_quantity = trim($_POST['stock_quantity'] ?? '');

if ($title === '' || $author === '' || $price === '' || $stock_quantity === '') {

    echo '<p>Title,Author,Price and Stock Quanitity are required.</p>';
    echo '<p><a href="add_book_form.php">Go back</a></p>';

    exit();
}

$query = 'INSERT INTO book_details (title,author,price,stock_quantity)
          VALUES (:title, :author, :price, :stock_quantity)';

$statement = $db->prepare($query);

$statement->execute([
    ':title' => $title,
    ':author' => $author,
    ':price' => $price,
    ':stock_quantity' => $stock_quantity
]);

$insert_count = $statement->rowCount();

include('../details/book_details.php');

