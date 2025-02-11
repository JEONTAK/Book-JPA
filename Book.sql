CREATE TABLE author
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE book
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    title       TEXT     NOT NULL,
    created_at  DATETIME NOT NULL,
    modified_at DATETIME NOT NULL,
);

CREATE TABLE book_author
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    book_id   BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE CASCADE,
    CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES author (id) ON DELETE CASCADE,
    UNIQUE (book_id, author_id)
);

CREATE TABLE user
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);