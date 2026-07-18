-- V8__create_wards_table.sql
-- Create wards table for Nepal's municipal wards

CREATE TABLE IF NOT EXISTS wards (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    name_nepali VARCHAR(200),
    number INTEGER NOT NULL,
    municipality_id BIGINT NOT NULL,
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    elevation DOUBLE PRECISION,
    area DOUBLE PRECISION,
    population BIGINT,
    description TEXT,
    slug VARCHAR(200) NOT NULL,
    contact_phone VARCHAR(50),
    contact_email VARCHAR(100),
    image_url VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW(),
    CONSTRAINT fk_ward_municipality FOREIGN KEY (municipality_id) REFERENCES municipalities(id),
    CONSTRAINT uq_ward_number_municipality UNIQUE (number, municipality_id),
    CONSTRAINT uq_ward_slug UNIQUE (slug)
);

CREATE INDEX IF NOT EXISTS idx_wards_municipality_id ON wards(municipality_id);
CREATE INDEX IF NOT EXISTS idx_wards_number ON wards(number);
