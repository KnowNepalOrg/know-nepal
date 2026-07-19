-- V7__create_education_extended_tables.sql
-- Create enums and tables for extended education entities

CREATE TYPE board_category AS ENUM ('EXAM_BODY', 'QUALIFICATION_BODY', 'REGULATORY');
CREATE TYPE scholarship_type AS ENUM ('GOVERNMENT', 'INSTITUTIONAL', 'INTERNATIONAL', 'MERIT', 'NEED_BASED');
CREATE TYPE exam_format AS ENUM ('ONLINE', 'OFFLINE', 'BOTH');
CREATE TYPE qualification_level AS ENUM ('BACHELOR', 'MASTER', 'PHD', 'MPHIL', 'DIPLOMA');
CREATE TYPE fee_component AS ENUM ('TUITION', 'LAB', 'LIBRARY', 'EXAM', 'REGISTRATION', 'HOSTEL', 'TRANSPORT', 'MISCELLANEOUS');
CREATE TYPE ranking_source AS ENUM ('NAAB', 'UGC', 'TU', 'KU', 'QS', 'NIRF', 'CUSTOM');

CREATE TABLE exam_boards (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    name_nepali VARCHAR(200),
    slug VARCHAR(250) NOT NULL UNIQUE,
    code VARCHAR(20) NOT NULL UNIQUE,
    category board_category NOT NULL,
    established_year INTEGER,
    headquarters VARCHAR(200),
    website VARCHAR(255),
    description TEXT,
    grading_system TEXT,
    province_id BIGINT,
    province_name VARCHAR(100),
    district_id BIGINT,
    district_name VARCHAR(100),
    phone VARCHAR(50),
    email VARCHAR(100),
    image_url VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE scholarships (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    name_nepali VARCHAR(200),
    slug VARCHAR(250) NOT NULL UNIQUE,
    type scholarship_type NOT NULL,
    provider VARCHAR(200),
    amount VARCHAR(200),
    eligibility TEXT,
    deadline VARCHAR(50),
    application_url VARCHAR(255),
    description TEXT,
    total_slots INTEGER,
    is_renewable BOOLEAN,
    province_id BIGINT,
    province_name VARCHAR(100),
    district_id BIGINT,
    district_name VARCHAR(100),
    contact_phone VARCHAR(50),
    contact_email VARCHAR(100),
    image_url VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE entrance_exams (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    name_nepali VARCHAR(200),
    slug VARCHAR(250) NOT NULL UNIQUE,
    code VARCHAR(20) NOT NULL UNIQUE,
    board_id BIGINT,
    board_name VARCHAR(200),
    format exam_format NOT NULL,
    exam_date VARCHAR(50),
    registration_deadline VARCHAR(50),
    eligibility TEXT,
    syllabus TEXT,
    fee_structure VARCHAR(200),
    total_seats INTEGER,
    duration_hours INTEGER,
    total_marks INTEGER,
    pass_marks INTEGER,
    description TEXT,
    website VARCHAR(255),
    image_url VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE teacher_profiles (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    name_nepali VARCHAR(200),
    slug VARCHAR(250) NOT NULL UNIQUE,
    qualification_level qualification_level NOT NULL,
    qualification_detail VARCHAR(200),
    specialization VARCHAR(200),
    experience_years INTEGER,
    institution_type VARCHAR(30) NOT NULL,
    institution_id BIGINT NOT NULL,
    institution_name VARCHAR(200),
    department VARCHAR(200),
    designation VARCHAR(100),
    province_id BIGINT,
    province_name VARCHAR(100),
    district_id BIGINT,
    district_name VARCHAR(100),
    phone VARCHAR(50),
    email VARCHAR(100),
    bio TEXT,
    image_url VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE academic_calendars (
    id BIGSERIAL PRIMARY KEY,
    institution_type VARCHAR(30) NOT NULL,
    institution_id BIGINT NOT NULL,
    institution_name VARCHAR(200),
    event_title VARCHAR(200) NOT NULL,
    event_description TEXT,
    start_date VARCHAR(50) NOT NULL,
    end_date VARCHAR(50),
    academic_year VARCHAR(20),
    semester VARCHAR(50),
    image_url VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE fee_breakdowns (
    id BIGSERIAL PRIMARY KEY,
    program_id BIGINT,
    program_name VARCHAR(200),
    institution_type VARCHAR(30) NOT NULL,
    institution_id BIGINT NOT NULL,
    institution_name VARCHAR(200),
    component fee_component NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    currency VARCHAR(10),
    semester VARCHAR(50),
    academic_year VARCHAR(20),
    description TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE rankings (
    id BIGSERIAL PRIMARY KEY,
    institution_type VARCHAR(30) NOT NULL,
    institution_id BIGINT NOT NULL,
    institution_name VARCHAR(200),
    source ranking_source NOT NULL,
    rank_position INTEGER NOT NULL,
    score DOUBLE PRECISION,
    category VARCHAR(100),
    year VARCHAR(10) NOT NULL,
    description TEXT,
    website VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_exam_boards_category ON exam_boards(category);
CREATE INDEX idx_exam_boards_province ON exam_boards(province_id);
CREATE INDEX idx_scholarships_type ON scholarships(type);
CREATE INDEX idx_scholarships_province ON scholarships(province_id);
CREATE INDEX idx_entrance_exams_format ON entrance_exams(format);
CREATE INDEX idx_entrance_exams_board ON entrance_exams(board_id);
CREATE INDEX idx_teacher_profiles_qual ON teacher_profiles(qualification_level);
CREATE INDEX idx_teacher_profiles_inst ON teacher_profiles(institution_type, institution_id);
CREATE INDEX idx_teacher_profiles_province ON teacher_profiles(province_id);
CREATE INDEX idx_academic_calendars_inst ON academic_calendars(institution_type, institution_id);
CREATE INDEX idx_academic_calendars_year ON academic_calendars(academic_year);
CREATE INDEX idx_fee_breakdowns_program ON fee_breakdowns(program_id);
CREATE INDEX idx_fee_breakdowns_inst ON fee_breakdowns(institution_type, institution_id);
CREATE INDEX idx_fee_breakdowns_component ON fee_breakdowns(component);
CREATE INDEX idx_rankings_inst ON rankings(institution_type, institution_id);
CREATE INDEX idx_rankings_source ON rankings(source);
CREATE INDEX idx_rankings_year ON rankings(year);
