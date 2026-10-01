<?php
require_once('../connect.php');

$book_id = filter_input(INPUT_POST, 'id', FILTER_VALIDATE_INT);

$title = trim($_POST['title'] ?? '');
$author = trim($_POST['author'] ?? '');
$price = trim($_POST['price'] ?? '');
$stock_quantity = trim($_POST['stock_quantity'] ?? '');

if (!$book_id || $title === '' || $author === '' || $price === '' || $stock_quantity === '') {
    echo '<p>Valid ID, title,author,price and stock_quantity are required.</p>';
    exit();
}

$query = 'UPDATE book_details
          SET title = :title, author = :author, price = :price, stock_quantity = :stock_quantity
          WHERE id = :id';

$statement = $db->prepare($query);

$statement->execute([
    ':title' => $title,
    ':author' => $author,
    ':price' => $price,
    ':stock_quantity' => $stock_quantity,
    ':id' => $book_id
]);

$update_count = $statement->rowCount();

include('../details/book_details.php');
