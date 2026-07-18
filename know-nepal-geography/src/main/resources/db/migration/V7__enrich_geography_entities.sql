-- V7__enrich_geography_entities.sql
-- Add slug, coordinates, description, website, contact, image to geography entities

-- =============================================================================
-- 1. ADD COLUMNS
-- =============================================================================

ALTER TABLE provinces ADD COLUMN slug VARCHAR(150);
ALTER TABLE provinces ADD COLUMN latitude DOUBLE PRECISION;
ALTER TABLE provinces ADD COLUMN longitude DOUBLE PRECISION;
ALTER TABLE provinces ADD COLUMN description TEXT;
ALTER TABLE provinces ADD COLUMN website_url VARCHAR(255);
ALTER TABLE provinces ADD COLUMN contact_phone VARCHAR(50);
ALTER TABLE provinces ADD COLUMN contact_email VARCHAR(100);
ALTER TABLE provinces ADD COLUMN image_url VARCHAR(255);

ALTER TABLE districts ADD COLUMN slug VARCHAR(150);
ALTER TABLE districts ADD COLUMN latitude DOUBLE PRECISION;
ALTER TABLE districts ADD COLUMN longitude DOUBLE PRECISION;
ALTER TABLE districts ADD COLUMN description TEXT;
ALTER TABLE districts ADD COLUMN website_url VARCHAR(255);
ALTER TABLE districts ADD COLUMN contact_phone VARCHAR(50);
ALTER TABLE districts ADD COLUMN contact_email VARCHAR(100);
ALTER TABLE districts ADD COLUMN image_url VARCHAR(255);

ALTER TABLE municipalities ADD COLUMN slug VARCHAR(150);
ALTER TABLE municipalities ADD COLUMN latitude DOUBLE PRECISION;
ALTER TABLE municipalities ADD COLUMN longitude DOUBLE PRECISION;
ALTER TABLE municipalities ADD COLUMN description TEXT;
ALTER TABLE municipalities ADD COLUMN website_url VARCHAR(255);
ALTER TABLE municipalities ADD COLUMN contact_phone VARCHAR(50);
ALTER TABLE municipalities ADD COLUMN contact_email VARCHAR(100);
ALTER TABLE municipalities ADD COLUMN image_url VARCHAR(255);
ALTER TABLE municipalities ADD COLUMN elevation DOUBLE PRECISION;

-- =============================================================================
-- 2. GENERATE SLUGS FROM NAMES
-- =============================================================================

UPDATE provinces SET slug = LOWER(REPLACE(TRIM(name), ' ', '-'));
UPDATE districts SET slug = LOWER(REPLACE(TRIM(name), ' ', '-'));
UPDATE municipalities m
   SET slug = LOWER(REPLACE(TRIM(d.name), ' ', '-')) || '-' || LOWER(REPLACE(TRIM(m.name), ' ', '-'))
  FROM districts d
 WHERE m.district_id = d.id;

-- =============================================================================
-- 3. SEED PROVINCE DATA (coordinates + website + description)
-- =============================================================================

UPDATE provinces SET
    latitude = 27.0,
    longitude = 87.3,
    website_url = 'https://koshi.gov.np',
    description = 'Koshi Province is the easternmost province of Nepal, home to Mount Everest and Kanchenjunga. It spans from the Terai plains to the highest Himalayan peaks, offering extraordinary biodiversity and cultural diversity.'
WHERE id = 1;

UPDATE provinces SET
    latitude = 26.7,
    longitude = 85.9,
    website_url = 'https://madhesh.gov.np',
    description = 'Madhesh Province is the southernmost province, spanning the fertile Terai plains. Known for its rich cultural heritage, agricultural productivity, and vibrant festivals.'
WHERE id = 2;

UPDATE provinces SET
    latitude = 27.9,
    longitude = 85.3,
    website_url = 'https://bagmati.gov.np',
    description = 'Bagmati Province encompasses the Kathmandu Valley, the political and cultural heart of Nepal. Home to seven UNESCO World Heritage Sites and the highest concentration of historical monuments.'
WHERE id = 3;

UPDATE provinces SET
    latitude = 28.3,
    longitude = 84.0,
    website_url = 'https://gandaki.gov.np',
    description = 'Gandaki Province is known for Pokhara, the Annapurna mountain range, and diverse trekking routes. It offers stunning natural beauty and rich cultural experiences across its hill and mountain districts.'
WHERE id = 4;

UPDATE provinces SET
    latitude = 27.9,
    longitude = 83.3,
    website_url = 'https://lumbini.gov.np',
    description = 'Lumbini Province is the birthplace of Lord Buddha, making it one of the most important pilgrimage destinations in the world. It spans from the Chure hills to the Terai plains.'
WHERE id = 5;

UPDATE provinces SET
    latitude = 29.5,
    longitude = 82.1,
    website_url = 'https://karnali.gov.np',
    description = 'Karnali Province is the largest province by area, known for its remote wilderness, Shey Phoksundo Lake, and rich biodiversity. It remains one of the most pristine regions in Nepal.'
WHERE id = 6;

UPDATE provinces SET
    latitude = 29.3,
    longitude = 81.1,
    website_url = 'https://sudurpashchim.gov.np',
    description = 'Sudurpashchim Province is the westernmost province, known for Mahakali Temple, Khaptad National Park, and the Sudurpashchim hills. It offers unexplored natural beauty and cultural richness.'
WHERE id = 7;

-- =============================================================================
-- 4. SEED DISTRICT DATA (coordinates)
-- =============================================================================

-- Koshi Province (14 districts)
UPDATE districts SET latitude = 27.35, longitude = 87.67 WHERE id = 1;   -- Taplejung
UPDATE districts SET latitude = 27.35, longitude = 87.75 WHERE id = 2;   -- Panchthar
UPDATE districts SET latitude = 26.92, longitude = 87.93 WHERE id = 3;   -- Ilam
UPDATE districts SET latitude = 26.54, longitude = 87.99 WHERE id = 4;   -- Jhapa
UPDATE districts SET latitude = 26.50, longitude = 87.30 WHERE id = 5;   -- Morang
UPDATE districts SET latitude = 26.63, longitude = 87.00 WHERE id = 6;   -- Sunsari
UPDATE districts SET latitude = 26.98, longitude = 87.34 WHERE id = 7;   -- Dhankuta
UPDATE districts SET latitude = 27.20, longitude = 87.32 WHERE id = 8;   -- Terhathum
UPDATE districts SET latitude = 27.55, longitude = 87.20 WHERE id = 9;   -- Sankhuwasabha
UPDATE districts SET latitude = 27.55, longitude = 86.95 WHERE id = 10;  -- Bhojpur
UPDATE districts SET latitude = 27.50, longitude = 86.58 WHERE id = 11;  -- Solukhumbu
UPDATE districts SET latitude = 27.20, longitude = 86.60 WHERE id = 12;  -- Khotang
UPDATE districts SET latitude = 26.90, longitude = 86.40 WHERE id = 13;  -- Udayapur
UPDATE districts SET latitude = 26.70, longitude = 86.70 WHERE id = 77;  -- Okhaldhunga

-- Madhesh Province (8 districts)
UPDATE districts SET latitude = 26.53, longitude = 86.75 WHERE id = 14;  -- Saptari
UPDATE districts SET latitude = 26.72, longitude = 86.05 WHERE id = 15;  -- Siraha
UPDATE districts SET latitude = 26.53, longitude = 86.00 WHERE id = 16;  -- Dhanusha
UPDATE districts SET latitude = 26.65, longitude = 85.62 WHERE id = 17;  -- Mahottari
UPDATE districts SET latitude = 26.85, longitude = 85.60 WHERE id = 18;  -- Sarlahi
UPDATE districts SET latitude = 27.00, longitude = 85.08 WHERE id = 19;  -- Rautahat
UPDATE districts SET latitude = 27.13, longitude = 85.05 WHERE id = 20;  -- Bara
UPDATE districts SET latitude = 27.25, longitude = 84.78 WHERE id = 21;  -- Parsa

-- Bagmati Province (13 districts)
UPDATE districts SET latitude = 27.67, longitude = 85.43 WHERE id = 22;  -- Bhaktapur
UPDATE districts SET latitude = 27.87, longitude = 84.93 WHERE id = 23;  -- Dhading
UPDATE districts SET latitude = 27.63, longitude = 86.05 WHERE id = 24;  -- Dolakha
UPDATE districts SET latitude = 27.55, longitude = 85.60 WHERE id = 25;  -- Kavrepalanchok
UPDATE districts SET latitude = 27.72, longitude = 85.32 WHERE id = 26;  -- Kathmandu
UPDATE districts SET latitude = 27.67, longitude = 85.32 WHERE id = 27;  -- Lalitpur
UPDATE districts SET latitude = 28.02, longitude = 85.15 WHERE id = 28;  -- Nuwakot
UPDATE districts SET latitude = 28.10, longitude = 85.28 WHERE id = 29;  -- Rasuwa
UPDATE districts SET latitude = 27.85, longitude = 85.60 WHERE id = 30;  -- Sindhupalchok
UPDATE districts SET latitude = 27.42, longitude = 85.02 WHERE id = 31;  -- Makwanpur
UPDATE districts SET latitude = 27.53, longitude = 84.40 WHERE id = 32;  -- Chitwan
UPDATE districts SET latitude = 27.35, longitude = 85.98 WHERE id = 33;  -- Ramechhap
UPDATE districts SET latitude = 27.20, longitude = 85.97 WHERE id = 34;  -- Sindhuli

-- Gandaki Province (11 districts)
UPDATE districts SET latitude = 28.15, longitude = 84.63 WHERE id = 35;  -- Gorkha
UPDATE districts SET latitude = 28.22, longitude = 83.98 WHERE id = 36;  -- Kaski
UPDATE districts SET latitude = 28.23, longitude = 84.38 WHERE id = 37;  -- Lamjung
UPDATE districts SET latitude = 28.55, longitude = 84.23 WHERE id = 38;  -- Manang
UPDATE districts SET latitude = 28.80, longitude = 83.87 WHERE id = 39;  -- Mustang
UPDATE districts SET latitude = 28.40, longitude = 83.48 WHERE id = 40;  -- Myagdi
UPDATE districts SET latitude = 27.75, longitude = 83.95 WHERE id = 41;  -- Nawalparasi East
UPDATE districts SET latitude = 28.22, longitude = 83.62 WHERE id = 42;  -- Parbat
UPDATE districts SET latitude = 28.08, longitude = 83.82 WHERE id = 43;  -- Syangja
UPDATE districts SET latitude = 27.92, longitude = 84.25 WHERE id = 44;  -- Tanahu
UPDATE districts SET latitude = 28.22, longitude = 83.45 WHERE id = 45;  -- Baglung

-- Lumbini Province (12 districts)
UPDATE districts SET latitude = 28.18, longitude = 83.27 WHERE id = 46;  -- Arghakhanchi
UPDATE districts SET latitude = 28.08, longitude = 83.55 WHERE id = 47;  -- Gulmi
UPDATE districts SET latitude = 27.75, longitude = 83.02 WHERE id = 48;  -- Kapilvastu
UPDATE districts SET latitude = 27.85, longitude = 83.53 WHERE id = 49;  -- Palpa
UPDATE districts SET latitude = 27.62, longitude = 83.47 WHERE id = 50;  -- Rupandehi
UPDATE districts SET latitude = 27.78, longitude = 83.85 WHERE id = 51;  -- Nawalparasi West
UPDATE districts SET latitude = 28.02, longitude = 82.58 WHERE id = 52;  -- Dang
UPDATE districts SET latitude = 28.22, longitude = 82.55 WHERE id = 53;  -- Pyuthan
UPDATE districts SET latitude = 28.35, longitude = 82.45 WHERE id = 54;  -- Rolpa
UPDATE districts SET latitude = 28.50, longitude = 82.25 WHERE id = 55;  -- Rukum West
UPDATE districts SET latitude = 28.10, longitude = 81.55 WHERE id = 56;  -- Banke
UPDATE districts SET latitude = 28.35, longitude = 81.48 WHERE id = 57;  -- Bardiya

-- Karnali Province (10 districts)
UPDATE districts SET latitude = 28.88, longitude = 81.70 WHERE id = 58;  -- Dailekh
UPDATE districts SET latitude = 29.05, longitude = 82.95 WHERE id = 59;  -- Dolpa
UPDATE districts SET latitude = 29.97, longitude = 81.83 WHERE id = 60;  -- Humla
UPDATE districts SET latitude = 28.95, longitude = 82.10 WHERE id = 61;  -- Jajarkot
UPDATE districts SET latitude = 29.28, longitude = 82.18 WHERE id = 62;  -- Jumla
UPDATE districts SET latitude = 29.12, longitude = 81.98 WHERE id = 63;  -- Kalikot
UPDATE districts SET latitude = 29.50, longitude = 82.08 WHERE id = 64;  -- Mugu
UPDATE districts SET latitude = 28.80, longitude = 82.38 WHERE id = 65;  -- Rukum East
UPDATE districts SET latitude = 28.60, longitude = 82.10 WHERE id = 66;  -- Salyan
UPDATE districts SET latitude = 28.52, longitude = 81.62 WHERE id = 67;  -- Surkhet

-- Sudurpashchim Province (9 districts)
UPDATE districts SET latitude = 29.12, longitude = 80.93 WHERE id = 68;  -- Achham
UPDATE districts SET latitude = 29.42, longitude = 80.58 WHERE id = 69;  -- Baitadi
UPDATE districts SET latitude = 29.55, longitude = 80.85 WHERE id = 70;  -- Bajhang
UPDATE districts SET latitude = 29.55, longitude = 81.18 WHERE id = 71;  -- Bajura
UPDATE districts SET latitude = 29.30, longitude = 80.55 WHERE id = 72;  -- Dadeldhura
UPDATE districts SET latitude = 29.87, longitude = 80.55 WHERE id = 73;  -- Darchula
UPDATE districts SET latitude = 29.13, longitude = 80.75 WHERE id = 74;  -- Doti
UPDATE districts SET latitude = 28.70, longitude = 80.93 WHERE id = 75;  -- Kailali
UPDATE districts SET latitude = 28.88, longitude = 80.18 WHERE id = 76;  -- Kanchanpur

-- =============================================================================
-- 5. ADD NOT NULL + UNIQUE CONSTRAINTS
-- =============================================================================

ALTER TABLE provinces ALTER COLUMN slug SET NOT NULL;
ALTER TABLE provinces ADD CONSTRAINT uk_province_slug UNIQUE (slug);

ALTER TABLE districts ALTER COLUMN slug SET NOT NULL;
ALTER TABLE districts ADD CONSTRAINT uk_district_slug UNIQUE (slug);

ALTER TABLE municipalities ALTER COLUMN slug SET NOT NULL;
ALTER TABLE municipalities ADD CONSTRAINT uk_municipality_slug UNIQUE (slug);
