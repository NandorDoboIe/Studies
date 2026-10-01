<?php

// DSN = Data Source Name.
// It tells PDO which database server and database to connect to.
//
// mysql              -> database driver
// host=127.0.0.1     -> database server on this computer
// port=3307          -> port used by the database server
// dbname=WebDev3_2026 -> database name
// charset=utf8mb4    -> character encoding
$dsn = 'mysql:host=127.0.0.1;port=3308;dbname=WebDev3_BookStore;charset=utf8mb4';

// Database username.
$username = 'root';

// Database password.
// Empty string means no password is being used.
$password = '';

try {

    // Create the PDO database connection.
    // The connection is stored in $db.
    $db = new PDO($dsn, $username, $password);

    // Configure PDO to report database errors as exceptions.
    $db->setAttribute(
        PDO::ATTR_ERRMODE,
        PDO::ERRMODE_EXCEPTION
    );

    // Return database rows as associative arrays by default.
    // Example: $car['make'] instead of $car[0].
    $db->setAttribute(
        PDO::ATTR_DEFAULT_FETCH_MODE,
        PDO::FETCH_ASSOC
    );

} catch (PDOException $e) {

    // Get the database error message.
    $error_message = $e->getMessage();

    // Display the error safely as text.
    echo '<p>An error occurred while connecting: '
        . htmlspecialchars($error_message)
        . '</p>';

    // Stop the script because the database connection failed.
    exit();
}

