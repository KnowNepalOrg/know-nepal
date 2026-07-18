CREATE TABLE IF NOT EXISTS provinces (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    name_nepali VARCHAR(100),
    code VARCHAR(10) NOT NULL UNIQUE,
    area DOUBLE PRECISION,
    population BIGINT,
    capital VARCHAR(100),
    number_of_districts INTEGER,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS districts (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    name_nepali VARCHAR(100),
    code VARCHAR(10) NOT NULL UNIQUE,
    area DOUBLE PRECISION,
    population BIGINT,
    headquarters VARCHAR(100),
    province_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW(),
    CONSTRAINT fk_district_province FOREIGN KEY (province_id) REFERENCES provinces(id)
);

CREATE TABLE IF NOT EXISTS municipalities (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    name_nepali VARCHAR(150),
    code VARCHAR(10) NOT NULL UNIQUE,
    type VARCHAR(30) NOT NULL,
    area DOUBLE PRECISION,
    population BIGINT,
    ward_count INTEGER,
    district_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW(),
    CONSTRAINT fk_municipality_district FOREIGN KEY (district_id) REFERENCES districts(id),
    CONSTRAINT uq_municipality_name_district UNIQUE (name, district_id)
);

CREATE INDEX IF NOT EXISTS idx_districts_province_id ON districts(province_id);
CREATE INDEX IF NOT EXISTS idx_municipalities_district_id ON municipalities(district_id);
CREATE INDEX IF NOT EXISTS idx_municipalities_type ON municipalities(type);
