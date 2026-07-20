-- V1: Create all destinations tables and enums

CREATE TYPE destination_type AS ENUM ('NATURE','CULTURAL','RELIGIOUS','ADVENTURE','HERITAGE','URBAN','WILDLIFE','SCENIC','HISTORICAL');
CREATE TYPE difficulty_level AS ENUM ('EASY','MODERATE','CHALLENGING','STRENUOUS','EXTREME');
CREATE TYPE best_season AS ENUM ('SPRING','SUMMER','AUTUMN','WINTER','ALL_YEAR');
CREATE TYPE tag_type AS ENUM ('ACTIVITY','THEME','ACCESSIBILITY','SEASON','CUSTOM');
CREATE TYPE media_type AS ENUM ('PHOTO','VIDEO','DOCUMENT','THREE_60_VIEW');
CREATE TYPE fee_type AS ENUM ('ENTRY','PARKING','GUIDE','EQUIPMENT','TRANSPORT','ACCOMMODATION','OTHER');
CREATE TYPE travel_mode AS ENUM ('WALKING','DRIVING','FLYING','BOATING','TREKKING');
CREATE TYPE weather_season AS ENUM ('SPRING','SUMMER','AUTUMN','WINTER','MONSOON');
CREATE TYPE meals AS ENUM ('BREAKFAST','LUNCH','DINNER','ALL');

-- Core tables
CREATE TABLE destination_categories (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(100) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(500),
    icon VARCHAR(50),
    display_order INTEGER,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

CREATE TABLE tourist_destinations (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(150) NOT NULL UNIQUE,
    name VARCHAR(200) NOT NULL,
    description TEXT,
    destination_type destination_type NOT NULL,
    category_id BIGINT REFERENCES destination_categories(id),
    province_id BIGINT,
    province_name VARCHAR(100),
    district_id BIGINT,
    district_name VARCHAR(100),
    municipality_id BIGINT,
    municipality_name VARCHAR(150),
    latitude DECIMAL(10,7),
    longitude DECIMAL(10,7),
    altitude_meters INTEGER,
    difficulty_level difficulty_level,
    best_season best_season,
    entry_fee_npr DECIMAL(10,2),
    visit_duration VARCHAR(50),
    is_popular BOOLEAN DEFAULT FALSE,
    is_featured BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

CREATE TABLE destination_tags (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(100) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    tag_type tag_type NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

CREATE TABLE destination_tag_mappings (
    id BIGSERIAL PRIMARY KEY,
    destination_id BIGINT NOT NULL REFERENCES tourist_destinations(id) ON DELETE CASCADE,
    tag_id BIGINT NOT NULL REFERENCES destination_tags(id) ON DELETE CASCADE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP,
    UNIQUE(destination_id, tag_id)
);

CREATE TABLE trekking_routes (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(150) NOT NULL UNIQUE,
    name VARCHAR(200) NOT NULL,
    description TEXT,
    difficulty_level difficulty_level NOT NULL,
    distance_km DECIMAL(8,2),
    duration_days INTEGER,
    max_altitude_meters INTEGER,
    best_season best_season,
    is_popular BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

CREATE TABLE route_destinations (
    id BIGSERIAL PRIMARY KEY,
    route_id BIGINT NOT NULL REFERENCES trekking_routes(id) ON DELETE CASCADE,
    destination_id BIGINT NOT NULL REFERENCES tourist_destinations(id) ON DELETE CASCADE,
    sequence_order INTEGER NOT NULL,
    is_overnight_stop BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP,
    UNIQUE(route_id, destination_id)
);

CREATE TABLE destination_highlights (
    id BIGSERIAL PRIMARY KEY,
    destination_id BIGINT NOT NULL REFERENCES tourist_destinations(id) ON DELETE CASCADE,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    display_order INTEGER,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

CREATE TABLE destination_reviews (
    id BIGSERIAL PRIMARY KEY,
    destination_id BIGINT NOT NULL REFERENCES tourist_destinations(id) ON DELETE CASCADE,
    reviewer_name VARCHAR(150) NOT NULL,
    rating INTEGER NOT NULL CHECK (rating >= 1 AND rating <= 5),
    title VARCHAR(200),
    content TEXT,
    visit_date DATE,
    is_verified BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

CREATE TABLE destination_media (
    id BIGSERIAL PRIMARY KEY,
    destination_id BIGINT NOT NULL REFERENCES tourist_destinations(id) ON DELETE CASCADE,
    url VARCHAR(500) NOT NULL,
    caption VARCHAR(300),
    media_type media_type NOT NULL,
    display_order INTEGER,
    is_primary BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

CREATE TABLE destination_fees (
    id BIGSERIAL PRIMARY KEY,
    destination_id BIGINT NOT NULL REFERENCES tourist_destinations(id) ON DELETE CASCADE,
    fee_type fee_type NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    currency VARCHAR(10) DEFAULT 'NPR',
    description VARCHAR(300),
    is_mandatory BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

CREATE TABLE destination_itineraries (
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(150) NOT NULL UNIQUE,
    name VARCHAR(200) NOT NULL,
    description TEXT,
    duration_days INTEGER NOT NULL,
    difficulty_level difficulty_level,
    best_season best_season,
    is_popular BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

CREATE TABLE itinerary_days (
    id BIGSERIAL PRIMARY KEY,
    itinerary_id BIGINT NOT NULL REFERENCES destination_itineraries(id) ON DELETE CASCADE,
    day_number INTEGER NOT NULL,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    accommodation VARCHAR(200),
    meals meals,
    distance_km DECIMAL(8,2),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

CREATE TABLE itinerary_day_destinations (
    id BIGSERIAL PRIMARY KEY,
    itinerary_day_id BIGINT NOT NULL REFERENCES itinerary_days(id) ON DELETE CASCADE,
    destination_id BIGINT NOT NULL REFERENCES tourist_destinations(id) ON DELETE CASCADE,
    sequence_order INTEGER NOT NULL,
    notes VARCHAR(500),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);

CREATE TABLE nearby_destinations (
    id BIGSERIAL PRIMARY KEY,
    destination_id BIGINT NOT NULL REFERENCES tourist_destinations(id) ON DELETE CASCADE,
    nearby_destination_id BIGINT NOT NULL REFERENCES tourist_destinations(id) ON DELETE CASCADE,
    distance_km DECIMAL(8,2),
    travel_time_minutes INTEGER,
    travel_mode travel_mode,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP,
    UNIQUE(destination_id, nearby_destination_id)
);

CREATE TABLE destination_weather (
    id BIGSERIAL PRIMARY KEY,
    destination_id BIGINT NOT NULL REFERENCES tourist_destinations(id) ON DELETE CASCADE,
    weather_season weather_season NOT NULL,
    avg_temp_celsius DECIMAL(5,1),
    min_temp_celsius DECIMAL(5,1),
    max_temp_celsius DECIMAL(5,1),
    rainfall_mm DECIMAL(8,1),
    conditions VARCHAR(300),
    is_recommended BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP,
    UNIQUE(destination_id, weather_season)
);

-- Indexes
CREATE INDEX idx_destinations_slug ON tourist_destinations(slug);
CREATE INDEX idx_destinations_type ON tourist_destinations(destination_type);
CREATE INDEX idx_destinations_province ON tourist_destinations(province_id);
CREATE INDEX idx_destinations_district ON tourist_destinations(district_id);
CREATE INDEX idx_destinations_category ON tourist_destinations(category_id);
CREATE INDEX idx_destinations_popular ON tourist_destinations(is_popular);
CREATE INDEX idx_destinations_featured ON tourist_destinations(is_featured);
CREATE INDEX idx_routes_slug ON trekking_routes(slug);
CREATE INDEX idx_routes_difficulty ON trekking_routes(difficulty_level);
CREATE INDEX idx_reviews_destination ON destination_reviews(destination_id);
CREATE INDEX idx_highlights_destination ON destination_highlights(destination_id);
CREATE INDEX idx_media_destination ON destination_media(destination_id);
CREATE INDEX idx_fees_destination ON destination_fees(destination_id);
CREATE INDEX idx_nearby_destination ON nearby_destinations(destination_id);
CREATE INDEX idx_weather_destination ON destination_weather(destination_id);
