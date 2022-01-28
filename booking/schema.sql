CREATE TABLE book(
    isbn VARCHAR(13) NOT NULL PRIMARY KEY,
    title VARCHAR(80) NOT NULL,
    author VARCHAR(50) NOT NULL,
    summary VARCHAR(250),
    release_date DATE
);

INSERT INTO book(isbn, title, author, summary, release_date) VALUES
('9788533613409', 'Lord Of The Rings', 'J.R.R. Tolkien', 'The entire trilogy', '2001-01-01'),
('9780393312836', 'Clockwork Orange', 'Anthony Burgess', NULL, NULL),
('97804411727', 'Dune', 'Frank Herbert', 'War on Drugs', NULL);