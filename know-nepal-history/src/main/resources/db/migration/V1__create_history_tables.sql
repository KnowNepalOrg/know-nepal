-- V1: Create all history tables

-- Historical Eras table (created first, referenced by dynasties and events)
CREATE TABLE historical_eras (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(150) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    start_year INTEGER NOT NULL,
    end_year INTEGER,
    key_characteristics TEXT,
    is_featured BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

-- Historical Figures table (created before dynasties for founder reference)
CREATE TABLE historical_figures (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(150) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    figure_type VARCHAR(20) NOT NULL CHECK (figure_type IN ('KING','WARRIOR','SCHOLAR','SAINT','ACTIVIST','DIPLOMAT','REFORM','OTHER')),
    birth_year INTEGER,
    death_year INTEGER,
    birth_place VARCHAR(200),
    known_for TEXT,
    key_achievements TEXT,
    dynasty_affiliation VARCHAR(150),
    era_name VARCHAR(150),
    is_featured BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

-- Dynasties table (references eras and figures)
CREATE TABLE dynasties (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(150) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    era_id BIGINT NOT NULL REFERENCES historical_eras(id),
    founder_id BIGINT REFERENCES historical_figures(id),
    start_year INTEGER,
    end_year INTEGER,
    capital VARCHAR(150),
    key_achievements TEXT,
    number_of_rulers INTEGER,
    is_featured BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

-- Historical Events table (references eras and dynasties)
CREATE TABLE historical_events (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(150) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    event_type VARCHAR(20) NOT NULL CHECK (event_type IN ('BATTLE','TREATY','REVOLUTION','CORONATION','REFORM','OTHER')),
    era_id BIGINT NOT NULL REFERENCES historical_eras(id),
    dynasty_id BIGINT REFERENCES dynasties(id),
    event_year INTEGER NOT NULL,
    end_year INTEGER,
    location VARCHAR(200),
    significance TEXT,
    key_figures_involved TEXT,
    outcome TEXT,
    is_featured BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);
