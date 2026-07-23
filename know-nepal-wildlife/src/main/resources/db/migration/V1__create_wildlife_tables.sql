-- V1: Create all wildlife tables

-- National Parks and Protected Areas table
CREATE TABLE national_parks (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(150) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    area_type VARCHAR(30) NOT NULL CHECK (area_type IN ('NATIONAL_PARK','WILDLIFE_RESERVE','HUNTING_RESERVE','CONSERVATION_AREA','BUFFER_ZONE')),
    district VARCHAR(150),
    province VARCHAR(100),
    area_sq_km DOUBLE PRECISION,
    buffer_zone_sq_km DOUBLE PRECISION,
    established_year INTEGER,
    elevation_min_m INTEGER,
    elevation_max_m INTEGER,
    key_species TEXT,
    notable_features TEXT,
    visitor_count INTEGER,
    is_featured BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

-- Wildlife Species table
CREATE TABLE wildlife_species (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(150) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    scientific_name VARCHAR(200),
    description TEXT,
    class_type VARCHAR(20) NOT NULL CHECK (class_type IN ('MAMMAL','BIRD','REPTILE','AMPHIBIAN','FISH','BUTTERFLY')),
    conservation_status VARCHAR(30) NOT NULL CHECK (conservation_status IN ('CRITICALLY_ENDANGERED','ENDANGERED','VULNERABLE','NEAR_THREATENED','LEAST_CONCERN','DATA_DEFICIENT')),
    nepal_status VARCHAR(20) CHECK (nepal_status IN ('ENDANGERED','VULNERABLE','PROTECTED','COMMON','RARE')),
    habitat VARCHAR(200),
    elevation_range VARCHAR(100),
    estimated_population VARCHAR(100),
    is_endemic BOOLEAN DEFAULT FALSE,
    is_featured BOOLEAN DEFAULT FALSE,
    fun_facts TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

-- Flora Species table
CREATE TABLE flora_species (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(150) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    scientific_name VARCHAR(200),
    description TEXT,
    plant_type VARCHAR(100),
    family_name VARCHAR(100),
    habitat VARCHAR(200),
    elevation_range VARCHAR(100),
    is_endemic BOOLEAN DEFAULT FALSE,
    is_medicinal BOOLEAN DEFAULT FALSE,
    medicinal_uses TEXT,
    conservation_status VARCHAR(30),
    is_featured BOOLEAN DEFAULT FALSE,
    fun_facts TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

-- Lakes table
CREATE TABLE lakes (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(150) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    lake_type VARCHAR(20) NOT NULL CHECK (lake_type IN ('NATURAL','GLACIAL','TECTONIC','CRATER','ARTIFICIAL','RIVERINE')),
    district VARCHAR(150),
    province VARCHAR(100),
    elevation_m INTEGER,
    area_sq_km DOUBLE PRECISION,
    max_depth_m INTEGER,
    length_km DOUBLE PRECISION,
    width_km DOUBLE PRECISION,
    notable_features TEXT,
    is_featured BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);
