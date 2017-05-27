CREATE TABLE IF NOT EXISTS employees (
  employee_id   INT AUTO_INCREMENT PRIMARY KEY,
  firstName     VARCHAR(20),
  lastName      VARCHAR(20),
  email         VARCHAR(20) UNIQUE,
  password      VARCHAR(20),
  vacantionDays INT
);
CREATE TABLE IF NOT EXISTS hrs (
  hr_id     INT AUTO_INCREMENT PRIMARY KEY,
  firstName VARCHAR(20),
  lastName  VARCHAR(20),
  email     VARCHAR(20) UNIQUE,
  password  VARCHAR(20)
);
CREATE TABLE IF NOT EXISTS vacantiondays (
  id          INT AUTO_INCREMENT PRIMARY KEY,
  employee_id INT,
  day         DATE,
  FOREIGN KEY (employee_id) REFERENCES employees (employee_id)
);
    
    
	