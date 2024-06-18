-- create a table
CREATE TABLE doggos
(
    id       INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name     TEXT    NOT NULL,
    breed    TEXT NOT NULL
);