-- V1__create_education_tables.sql
-- Create enums and tables for Education service

CREATE TYPE school_type AS ENUM ('GOVERNMENT', 'PRIVATE', 'COMMUNITY', 'MONASTIC');
CREATE TYPE education_level AS ENUM ('PRIMARY', 'SECONDARY', 'HIGHER_SECONDARY');
CREATE TYPE college_type AS ENUM ('GOVERNMENT', 'PRIVATE', 'AFFILIATED');
CREATE TYPE college_level AS ENUM ('HIGHER_SECONDARY', 'BACHELOR', 'MASTER');
CREATE TYPE university_type AS ENUM ('NATIONAL', 'COMMUNITY', 'TECHNICAL', 'CONSTITUENT', 'DEEMED');
CREATE TYPE program_level AS ENUM ('SLC', 'SEE', 'HIGHER_SECONDARY', 'BACHELOR', 'MASTER', 'PHD', 'DIPLOMA', 'CERTIFICATE');
CREATE TYPE institution_type AS ENUM ('SCHOOL', 'COLLEGE', 'UNIVERSITY');

CREATE TABLE schools (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    name_nepali VARCHAR(200),
    slug VARCHAR(250) NOT NULL UNIQUE,
    code VARCHAR(20) NOT NULL UNIQUE,
    type school_type NOT NULL,
    level education_level NOT NULL,
    established_year INTEGER,
    affiliation VARCHAR(200),
    student_count INTEGER,
    teacher_count INTEGER,
    area_sq_km DOUBLE PRECISION,
    description TEXT,
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    elevation DOUBLE PRECISION,
    province_id BIGINT,
    province_name VARCHAR(100),
    district_id BIGINT,
    district_name VARCHAR(100),
    municipality_id BIGINT,
    municipality_name VARCHAR(100),
    ward_id BIGINT,
    ward_name VARCHAR(100),
    address VARCHAR(500),
    phone VARCHAR(50),
    email VARCHAR(100),
    website VARCHAR(255),
    image_url VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE colleges (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    name_nepali VARCHAR(200),
    slug VARCHAR(250) NOT NULL UNIQUE,
    code VARCHAR(20) NOT NULL UNIQUE,
    type college_type NOT NULL,
    level college_level NOT NULL,
    established_year INTEGER,
    affiliation VARCHAR(200),
    student_count INTEGER,
    teacher_count INTEGER,
    facilities TEXT,
    description TEXT,
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    elevation DOUBLE PRECISION,
    province_id BIGINT,
    province_name VARCHAR(100),
    district_id BIGINT,
    district_name VARCHAR(100),
    municipality_id BIGINT,
    municipality_name VARCHAR(100),
    ward_id BIGINT,
    ward_name VARCHAR(100),
    address VARCHAR(500),
    phone VARCHAR(50),
    email VARCHAR(100),
    website VARCHAR(255),
    image_url VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE universities (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    name_nepali VARCHAR(200),
    slug VARCHAR(250) NOT NULL UNIQUE,
    code VARCHAR(20) NOT NULL UNIQUE,
    type university_type NOT NULL,
    established_year INTEGER,
    vice_chancellor VARCHAR(200),
    student_count INTEGER,
    faculty_count INTEGER,
    campus_count INTEGER,
    affiliated_colleges INTEGER,
    faculties TEXT,
    description TEXT,
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    elevation DOUBLE PRECISION,
    province_id BIGINT,
    province_name VARCHAR(100),
    district_id BIGINT,
    district_name VARCHAR(100),
    municipality_id BIGINT,
    municipality_name VARCHAR(100),
    ward_id BIGINT,
    ward_name VARCHAR(100),
    address VARCHAR(500),
    phone VARCHAR(50),
    email VARCHAR(100),
    website VARCHAR(255),
    image_url VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE programs (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    name_nepali VARCHAR(200),
    slug VARCHAR(250) NOT NULL UNIQUE,
    code VARCHAR(20) NOT NULL UNIQUE,
    level program_level NOT NULL,
    faculty VARCHAR(100),
    duration_years INTEGER,
    total_seats INTEGER,
    fee_structure TEXT,
    eligibility TEXT,
    description TEXT,
    institution_type institution_type NOT NULL,
    institution_id BIGINT NOT NULL,
    institution_name VARCHAR(200),
    image_url VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_schools_province ON schools(province_id);
CREATE INDEX idx_schools_district ON schools(district_id);
CREATE INDEX idx_schools_type ON schools(type);
CREATE INDEX idx_schools_level ON schools(level);
CREATE INDEX idx_colleges_province ON colleges(province_id);
CREATE INDEX idx_colleges_district ON colleges(district_id);
CREATE INDEX idx_colleges_type ON colleges(type);
CREATE INDEX idx_colleges_level ON colleges(level);
CREATE INDEX idx_universities_province ON universities(province_id);
CREATE INDEX idx_universities_district ON universities(district_id);
CREATE INDEX idx_universities_type ON universities(type);
CREATE INDEX idx_programs_institution ON programs(institution_type, institution_id);
CREATE INDEX idx_programs_level ON programs(level);
CREATE INDEX idx_programs_faculty ON programs(faculty);
