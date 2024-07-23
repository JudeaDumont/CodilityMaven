

CREATE TABLE departments(
    id INT PRIMARY KEY,
    name varchar(50)
)

CREATE TABLE employees (
    id INT PRIMARY KEY,
    name varchar(50),
    department_id INT NOT NULL,
    FOREIGN KEY (department_id) references departments(id)
)

SELECT employees.name, departments.name
FROM employees
         INNER JOIN departments ON employees.department_id = departments.department_id;

