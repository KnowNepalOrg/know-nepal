-- V1: Create all culture tables

-- Languages table (created first, referenced by ethnic_groups)
CREATE TABLE languages (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(150) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    language_family VARCHAR(30) NOT NULL CHECK (language_family IN ('INDO_ARYAN','DRAVIDIAN','SINO_TIBETAN','MONGOLIAN','KUSUNDA','OTHER')),
    language_status VARCHAR(35) NOT NULL CHECK (language_status IN ('SAFE','VULNERABLE','DEFINITELY_ENDANGERED','SEVERELY_ENDANGERED','CRITICALLY_ENDANGERED','EXTINCT')),
    speakers_count BIGINT,
    script VARCHAR(100),
    writing_system VARCHAR(100),
    dialects TEXT,
    is_official BOOLEAN DEFAULT FALSE,
    is_lingua_franca BOOLEAN DEFAULT FALSE,
    region_type VARCHAR(20) CHECK (region_type IN ('HIMALAYAN','HILL','TERAI','URBAN')),
    province VARCHAR(100),
    origin_history TEXT,
    cultural_significance TEXT,
    endangered_details TEXT,
    preservation_efforts TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

-- Ethnic groups table (references languages)
CREATE TABLE ethnic_groups (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(150) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    population_estimate BIGINT,
    language_id BIGINT REFERENCES languages(id),
    region_type VARCHAR(20) CHECK (region_type IN ('HIMALAYAN','HILL','TERAI','URBAN')),
    province VARCHAR(100),
    sub_region VARCHAR(150),
    traditional_occupation VARCHAR(200),
    social_structure TEXT,
    religion VARCHAR(100),
    customs TEXT,
    rituals TEXT,
    festivals TEXT,
    is_indigenous BOOLEAN DEFAULT FALSE,
    is_deprived BOOLEAN DEFAULT FALSE,
    origin TEXT,
    migration_history TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

-- Festivals table
CREATE TABLE festivals (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(150) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    festival_type VARCHAR(20) NOT NULL CHECK (festival_type IN ('HINDU','BUDDHIST','KIRAT','MUSLIM','CHRISTIAN','NEWAR','SECULAR','OTHER')),
    culture_season VARCHAR(20) NOT NULL CHECK (culture_season IN ('SPRING','SUMMER','AUTUMN','WINTER','MONSOON','ALL_YEAR')),
    month VARCHAR(50),
    day VARCHAR(50),
    duration_days INTEGER,
    region_type VARCHAR(20) CHECK (region_type IN ('HIMALAYAN','HILL','TERAI','URBAN')),
    is_national_holiday BOOLEAN DEFAULT FALSE,
    is_public_holiday BOOLEAN DEFAULT FALSE,
    significance TEXT,
    rituals TEXT,
    modern_celebrations TEXT,
    ethnic_groups_involved TEXT,
    province VARCHAR(100),
    district VARCHAR(100),
    is_popular BOOLEAN DEFAULT FALSE,
    is_featured BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

-- Art forms table (references ethnic_groups)
CREATE TABLE art_forms (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(150) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    art_type VARCHAR(20) NOT NULL CHECK (art_type IN ('CLASSICAL','FOLK','TRIBAL','RELIGIOUS','CONTEMPORARY','REGIONAL','OTHER')),
    ethnic_group_id BIGINT REFERENCES ethnic_groups(id),
    region_type VARCHAR(20) CHECK (region_type IN ('HIMALAYAN','HILL','TERAI','URBAN')),
    province VARCHAR(100),
    historical_significance TEXT,
    techniques TEXT,
    materials TEXT,
    significance TEXT,
    contemporary_relevance TEXT,
    is_intangible_heritage BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

-- Traditional attires table (references ethnic_groups)
CREATE TABLE traditional_attires (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(150) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    gender_type VARCHAR(20) NOT NULL CHECK (gender_type IN ('MALE','FEMALE','UNISEX','OTHER')),
    attire_occasion VARCHAR(20) NOT NULL CHECK (attire_occasion IN ('DAILY','FESTIVAL','WEDDING','RELIGIOUS','CEREMONIAL','RITUAL','OTHER')),
    ethnic_group_id BIGINT REFERENCES ethnic_groups(id),
    region_type VARCHAR(20) CHECK (region_type IN ('HIMALAYAN','HILL','TERAI','URBAN')),
    province VARCHAR(100),
    fabric_material VARCHAR(200),
    colors TEXT,
    patterns TEXT,
    significance TEXT,
    wearing_occasion TEXT,
    historical_origin TEXT,
    regional_variations TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

-- Indexes for common queries
CREATE INDEX idx_languages_slug ON languages(slug);
CREATE INDEX idx_languages_family ON languages(language_family);
CREATE INDEX idx_languages_status ON languages(language_status);
CREATE INDEX idx_languages_province ON languages(province);

CREATE INDEX idx_ethnic_groups_slug ON ethnic_groups(slug);
CREATE INDEX idx_ethnic_groups_language ON ethnic_groups(language_id);
CREATE INDEX idx_ethnic_groups_province ON ethnic_groups(province);
CREATE INDEX idx_ethnic_groups_region ON ethnic_groups(region_type);

CREATE INDEX idx_festivals_slug ON festivals(slug);
CREATE INDEX idx_festivals_type ON festivals(festival_type);
CREATE INDEX idx_festivals_season ON festivals(culture_season);
CREATE INDEX idx_festivals_popular ON festivals(is_popular);

CREATE INDEX idx_art_forms_slug ON art_forms(slug);
CREATE INDEX idx_art_forms_type ON art_forms(art_type);
CREATE INDEX idx_art_forms_ethnic ON art_forms(ethnic_group_id);
CREATE INDEX idx_art_forms_province ON art_forms(province);

CREATE INDEX idx_traditional_attires_slug ON traditional_attires(slug);
CREATE INDEX idx_traditional_attires_gender ON traditional_attires(gender_type);
CREATE INDEX idx_traditional_attires_ethnic ON traditional_attires(ethnic_group_id);
CREATE INDEX idx_traditional_attires_province ON traditional_attires(province);
