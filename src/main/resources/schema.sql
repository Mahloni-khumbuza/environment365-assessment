-- Create waste_category Table
CREATE TABLE waste_category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    description VARCHAR(500)
);

-- Create disposal_guideline Table
CREATE TABLE disposal_guideline (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    waste_category_id BIGINT NOT NULL,
    guideline VARCHAR(1000) NOT NULL,
    hazardous BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (waste_category_id) REFERENCES waste_category(id) ON DELETE CASCADE
);


-- Create recycling_tip Table
CREATE TABLE recycling_tip (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    waste_category_id BIGINT NOT NULL,
    tip VARCHAR(1000) NOT NULL,
    FOREIGN KEY (waste_category_id) REFERENCES waste_category(id) ON DELETE CASCADE
);

