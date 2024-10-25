CREATE TABLE hello(
    id          SERIAL PRIMARY KEY,
    messages    VARCHAR NOT NULL
);

INSERT INTO hello (messages) VALUES
    ('Hello World');