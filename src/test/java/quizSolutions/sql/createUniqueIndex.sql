-- an index is a table adjacent data structure organized for performant search operations.

CREATE TABLE employees(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50)
);

CREATE UNIQUE INDEX unique_name_idx_employees on employees(name);