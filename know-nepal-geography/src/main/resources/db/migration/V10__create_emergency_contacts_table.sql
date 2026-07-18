-- V10__create_emergency_contacts_table.sql
-- Create emergency contacts table for Nepal emergency services

CREATE TYPE emergency_contact_type AS ENUM (
    'POLICE',
    'AMBULANCE',
    'FIRE',
    'HOSPITAL',
    'GOVERNMENT',
    'UTILITY',
    'TOURISM',
    'WOMEN_CHILDREN',
    'DISASTER',
    'OTHER'
);

CREATE TABLE IF NOT EXISTS emergency_contacts (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    name_nepali VARCHAR(200),
    type emergency_contact_type NOT NULL,
    phone VARCHAR(50) NOT NULL,
    alternate_phone VARCHAR(50),
    email VARCHAR(100),
    website VARCHAR(255),
    address VARCHAR(500),
    description TEXT,
    is_national BOOLEAN NOT NULL DEFAULT FALSE,
    district_id BIGINT,
    province_id BIGINT,
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    slug VARCHAR(200) NOT NULL,
    contact_person VARCHAR(200),
    available_hours VARCHAR(200),
    image_url VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW(),
    CONSTRAINT fk_emergency_district FOREIGN KEY (district_id) REFERENCES districts(id),
    CONSTRAINT fk_emergency_province FOREIGN KEY (province_id) REFERENCES provinces(id),
    CONSTRAINT uq_emergency_slug UNIQUE (slug)
);

CREATE INDEX IF NOT EXISTS idx_emergency_contacts_type ON emergency_contacts(type);
CREATE INDEX IF NOT EXISTS idx_emergency_contacts_district_id ON emergency_contacts(district_id);
CREATE INDEX IF NOT EXISTS idx_emergency_contacts_province_id ON emergency_contacts(province_id);
CREATE INDEX IF NOT EXISTS idx_emergency_contacts_is_national ON emergency_contacts(is_national);
CREATE INDEX IF NOT EXISTS idx_emergency_contacts_phone ON emergency_contacts(phone);
