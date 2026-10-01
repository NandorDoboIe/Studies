<?php
require_once('../connect.php');

$book_id = filter_input(INPUT_POST, 'id', FILTER_VALIDATE_INT);

if (!$book_id) {
    echo '<p>Invalid book ID.</p>';
    exit();
}

$query = 'DELETE FROM book_details WHERE id = :id';

$statement = $db->prepare($query);

$statement->execute([':id' => $book_id]);

$delete_count = $statement->rowCount();

include('../details/book_details.php');
