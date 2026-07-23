-- V3: Add location detail columns to lakes table and update existing 30 lake records

-- Add new columns
ALTER TABLE lakes ADD COLUMN municipality VARCHAR(150);
ALTER TABLE lakes ADD COLUMN latitude DOUBLE PRECISION;
ALTER TABLE lakes ADD COLUMN longitude DOUBLE PRECISION;
ALTER TABLE lakes ADD COLUMN how_to_reach TEXT;
ALTER TABLE lakes ADD COLUMN best_season VARCHAR(50);
ALTER TABLE lakes ADD COLUMN entry_fee_npr INTEGER DEFAULT 0;
ALTER TABLE lakes ADD COLUMN contact_info TEXT;
ALTER TABLE lakes ADD COLUMN image_url VARCHAR(500);
ALTER TABLE lakes ADD COLUMN photos TEXT;

-- Update existing 30 lake records with location details
UPDATE lakes SET
    municipality = 'Kanakasundari Municipality',
    latitude = 29.5276, longitude = 82.0855,
    how_to_reach = 'Fly from Nepalgunj to Jumla (25 min), then 3-4 day trek to Rara Lake. Alternatively, trek from Surkhet (5-6 days). Seasonal flights also available from Kathmandu.',
    best_season = 'March-May, September-November',
    entry_fee_npr = 100,
    contact_info = 'Rara National Park Office, Mugu: +977-89-520012',
    image_url = 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/Rara_lake.jpg/1280px-Rara_lake.jpg',
    photos = 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/6d/Rara_lake_%281%29.jpg/1280px-Rara_lake_%281%29.jpg,https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/Rara_National_Park.jpg/1280px-Rara_National_Park.jpg'
WHERE slug = 'rara-lake';

UPDATE lakes SET
    municipality = 'Shey Phoksundo Municipality',
    latitude = 29.1922, longitude = 82.9430,
    how_to_reach = 'Fly from Nepalgunj to Juphal Airport (25 min), then 2-3 day trek to Phoksundo Lake. Or trek from Jiri via Dunai (7-10 days). Inner permit required for Dolpa.',
    best_season = 'March-May, September-November',
    entry_fee_npr = 3000,
    contact_info = 'Shey Phoksundo National Park, Dolpa: +977-89-540023',
    image_url = 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Phoksundo_lake.jpg/1280px-Phoksundo_lake.jpg',
    photos = 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Phoksundo_Lake%2C_Dolpa.jpg/1280px-Phoksundo_Lake%2C_Dolpa.jpg,https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Shey_Phoksundo_National_Park.jpg/1280px-Shey_Phoksundo_National_Park.jpg'
WHERE slug = 'phoksundo-lake';

UPDATE lakes SET
    municipality = 'Mustang Rural Municipality',
    latitude = 28.6833, longitude = 83.9500,
    how_to_reach = 'Trek from Besisahar on the Annapurna Circuit (8-10 days to Tilicho). Permits required: ACAP and TIMS. Alternatively, fly to Jomsom and trek from there.',
    best_season = 'March-May, October-November',
    entry_fee_npr = 3000,
    contact_info = 'Annapurna Conservation Area Project: +977-61-521335',
    image_url = 'https://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/Tilicho_Lake.jpg/1280px-Tilicho_Lake.jpg',
    photos = 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/Tilicho_Lake_Nepal.jpg/1280px-Tilicho_Lake_Nepal.jpg'
WHERE slug = 'tilicho-lake';

UPDATE lakes SET
    municipality = 'Gosaikunda Rural Municipality',
    latitude = 28.0833, longitude = 85.4167,
    how_to_reach = 'Drive from Kathmandu to Dhunche (7-8 hrs), then 4-5 hour trek to Gosaikunda. Or trek from Sundarijal through Langtang route (4-5 days). Open from April to November.',
    best_season = 'March-May, September-November',
    entry_fee_npr = 100,
    contact_info = 'Langtang National Park Office, Rasuwa: +977-10-520045',
    image_url = 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Gosaikunda_Lake.jpg/1280px-Gosaikunda_Lake.jpg',
    photos = 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Gosaikunda_lake_%282%29.jpg/1280px-Gosaikunda_lake_%282%29.jpg'
WHERE slug = 'gosaikunda-lake';

UPDATE lakes SET
    municipality = 'Pokhara Metropolitan City',
    latitude = 28.2500, longitude = 83.9500,
    how_to_reach = 'Located 6 km from Pokhara city center. Fly to Pokhara from Kathmandu (25 min) or drive (5-6 hrs). Boats available from lakeside area.',
    best_season = 'Year-round',
    entry_fee_npr = 50,
    contact_info = 'Pokhara Tourism Office: +977-61-521202',
    image_url = 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/Begnas_Lake.jpg/1280px-Begnas_Lake.jpg',
    photos = 'https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Begnas_Lake_Pokhara.jpg/1280px-Begnas_Lake_Pokhara.jpg'
WHERE slug = 'begnas-lake';

UPDATE lakes SET
    municipality = 'Pokhara Metropolitan City',
    latitude = 28.2100, longitude = 83.9500,
    how_to_reach = 'Located 3 km from Pokhara city center. Fly to Pokhara from Kathmandu (25 min) or drive (5-6 hrs). Boating from Lakeside area.',
    best_season = 'Year-round',
    entry_fee_npr = 50,
    contact_info = 'Pokhara Tourism Office: +977-61-521202',
    image_url = 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Phewa_Lake.jpg/1280px-Phewa_Lake.jpg',
    photos = 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/Phewa_Lake_Pokhara_Nepal.jpg/1280px-Phewa_Lake_Pokhara_Nepal.jpg,https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Fewa_lake_view_from_talbarahi_temple.jpg/1280px-Fewa_lake_view_from_talbarahi_temple.jpg'
WHERE slug = 'pokhara-phewa-lake';

UPDATE lakes SET
    municipality = 'Solukhumbu Municipality',
    latitude = 27.4500, longitude = 86.5500,
    how_to_reach = 'Fly from Kathmandu to Lukla (30 min), then trek through Namche Bazaar area. Located off the main Everest trail. Requires special trekking permit.',
    best_season = 'March-May, September-November',
    entry_fee_npr = 3000,
    contact_info = 'Sagarmatha National Park: +977-10-540042',
    image_url = 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/Solukhumbu_landscape.jpg/1280px-Solukhumbu_landscape.jpg',
    photos = NULL
WHERE slug = 'kumayun-lake';

UPDATE lakes SET
    municipality = 'Langtang National Park Area',
    latitude = 28.2167, longitude = 85.5667,
    how_to_reach = 'Drive from Kathmandu to Syabrubesi (7-8 hrs), then trek 3-4 days through Langtang Valley. Near the glacial moraine above Kyanjin Gompa.',
    best_season = 'March-May, October-November',
    entry_fee_npr = 3000,
    contact_info = 'Langtang National Park Office: +977-10-520045',
    image_url = 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Langtang_valley.jpg/1280px-Langtang_valley.jpg',
    photos = 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Tsho_Lapma_Langtang.jpg/1280px-Tsho_Lapma_Langtang.jpg'
WHERE slug = 'tsho-lapma';

UPDATE lakes SET
    municipality = 'Baraha Kshetra Municipality',
    latitude = 26.5500, longitude = 87.9833,
    how_to_reach = 'Drive from Kathmandu to Birtamod (10-12 hrs) or fly to Bhadrapur, then 30 min drive. Located near Baraha temple complex.',
    best_season = 'Year-round',
    entry_fee_npr = 20,
    contact_info = 'Jhapa District Tourism Office: +977-23-520156',
    image_url = NULL,
    photos = NULL
WHERE slug = 'baraha-kshetra-lake';

UPDATE lakes SET
    municipality = 'Manang Ngisyang Municipality',
    latitude = 28.6167, longitude = 84.0500,
    how_to_reach = 'Trek from Besisahar on Annapurna Circuit route. Located between Chame and Manang. ACAP permit required.',
    best_season = 'April-May, September-October',
    entry_fee_npr = 3000,
    contact_info = 'ACAP Manang Office: +977-61-521335',
    image_url = NULL,
    photos = NULL
WHERE slug = 'machen-lake';

UPDATE lakes SET
    municipality = 'Gosaikunda Rural Municipality',
    latitude = 28.1000, longitude = 85.4000,
    how_to_reach = 'Trek from Dhunche or from Gosaikunda trail. 6-7 hours from Kathmandu by road to trailhead, then 5-6 hours trek.',
    best_season = 'April-May, September-November',
    entry_fee_npr = 100,
    contact_info = 'Langtang National Park Office: +977-10-520045',
    image_url = NULL,
    photos = NULL
WHERE slug = 'hara-muksin-lake';

UPDATE lakes SET
    municipality = 'Solukhumbu Municipality',
    latitude = 27.5500, longitude = 86.5000,
    how_to_reach = 'Fly to Lukla, then trek 4-5 days. Sacred to Sherpa people, located in a remote area of lower Solukhumbu.',
    best_season = 'March-May, September-November',
    entry_fee_npr = 3000,
    contact_info = 'Sagarmatha National Park: +977-10-540042',
    image_url = NULL,
    photos = NULL
WHERE slug = 'dudh-kunda-lake';

UPDATE lakes SET
    municipality = 'Dhankuta Municipality',
    latitude = 26.9833, longitude = 87.3333,
    how_to_reach = 'Fly to Dhangadhi or Bhadrapur, then drive 5-6 hours to Dhankuta. Or drive from Kathmandu (12-14 hrs). Short hike from Bhedetar viewpoint.',
    best_season = 'Year-round',
    entry_fee_npr = 0,
    contact_info = 'Dhankuta District Tourism Office: +977-26-520234',
    image_url = NULL,
    photos = NULL
WHERE slug = 'bhedetar-lake';

UPDATE lakes SET
    municipality = 'Ilam Municipality',
    latitude = 26.9167, longitude = 87.9333,
    how_to_reach = 'Fly to Bhadrapur, then drive 3-4 hours to Ilam Bazaar, then short hike. Or drive from Kathmandu (14-16 hrs).',
    best_season = 'March-May, October-November',
    entry_fee_npr = 0,
    contact_info = 'Ilam District Tourism Office: +977-27-520123',
    image_url = NULL,
    photos = NULL
WHERE slug = 'maipokhari-lake';

UPDATE lakes SET
    municipality = 'Dharan Sub-Metropolitan City',
    latitude = 26.8167, longitude = 87.2667,
    how_to_reach = 'Fly to Biratnagar, then 2-3 hour drive to Dharan. Or drive from Kathmandu (10-12 hrs). Short hike to the lake.',
    best_season = 'Year-round',
    entry_fee_npr = 0,
    contact_info = 'Sunsari District Tourism Office: +977-25-520456',
    image_url = NULL,
    photos = NULL
WHERE slug = 'tallo-jharna-lake';

UPDATE lakes SET
    municipality = 'Ilam Municipality',
    latitude = 26.9000, longitude = 87.9200,
    how_to_reach = 'Fly to Bhadrapur, then drive 3-4 hours to Ilam. Located near famous tea gardens. Short walk from main road.',
    best_season = 'Year-round',
    entry_fee_npr = 0,
    contact_info = 'Ilam District Tourism Office: +977-27-520123',
    image_url = NULL,
    photos = NULL
WHERE slug = 'ilam-pokhari';

UPDATE lakes SET
    municipality = 'Annapurna Rural Municipality',
    latitude = 28.5300, longitude = 83.8783,
    how_to_reach = 'Trek from Nayapul through Ghorepani-Jhinu route to Annapurna Base Camp (4-5 days). ACAP and TIMS permits required.',
    best_season = 'March-May, October-November',
    entry_fee_npr = 3000,
    contact_info = 'ACAP Office Pokhara: +977-61-521335',
    image_url = 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Annapurna_Base_Camp.jpg/1280px-Annapurna_Base_Camp.jpg',
    photos = 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Annapurna_Base_Camp_Trek.jpg/1280px-Annapurna_Base_Camp_Trek.jpg'
WHERE slug = 'annapurna-base-camp-lake';

UPDATE lakes SET
    municipality = 'Khumbu Pasang Lhamu Municipality',
    latitude = 28.0025, longitude = 86.8528,
    how_to_reach = 'Fly from Kathmandu to Lukla (30 min), then 8-10 day trek to Everest Base Camp. Sagarmatha National Park permit required.',
    best_season = 'March-May, October-November',
    entry_fee_npr = 3000,
    contact_info = 'Sagarmatha National Park: +977-10-540042',
    image_url = 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Everest_Base_Camp_trekkers.jpg/1280px-Everest_Base_Camp_trekkers.jpg',
    photos = 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Khumbu_Glacier_and_Everest_Base_Camp.jpg/1280px-Khumbu_Glacier_and_Everest_Base_Camp.jpg'
WHERE slug = 'everest-base-camp-lake';

UPDATE lakes SET
    municipality = 'Chandragiri Municipality',
    latitude = 27.6167, longitude = 85.2333,
    how_to_reach = 'Take the Chandragiri cable car from Thankot, 7 km from Kathmandu city center. 15-minute cable car ride to the top.',
    best_season = 'Year-round',
    entry_fee_npr = 200,
    contact_info = 'Chandragiri Hills Resort: +977-1-4311491',
    image_url = NULL,
    photos = NULL
WHERE slug = 'chandragiri-lake';

UPDATE lakes SET
    municipality = 'Nagarkot Municipality',
    latitude = 27.7167, longitude = 85.5167,
    how_to_reach = 'Drive from Kathmandu to Nagarkot (32 km, 1.5 hours). Located near the main viewpoint. Short walk from road.',
    best_season = 'Year-round',
    entry_fee_npr = 0,
    contact_info = 'Nagarkot Tourism Development Committee: +977-1-6610109',
    image_url = NULL,
    photos = NULL
WHERE slug = 'nagarkot-lake';

UPDATE lakes SET
    municipality = 'Pokhara Metropolitan City',
    latitude = 28.2500, longitude = 83.9500,
    how_to_reach = 'Located 6 km from Pokhara city center. Drive or cycle from Lakeside area. Less crowded than Phewa Lake.',
    best_season = 'Year-round',
    entry_fee_npr = 50,
    contact_info = 'Pokhara Tourism Office: +977-61-521202',
    image_url = NULL,
    photos = NULL
WHERE slug = 'pokhara-begnas-lake';

UPDATE lakes SET
    municipality = 'Manang Ngisyang Municipality',
    latitude = 28.6500, longitude = 84.0667,
    how_to_reach = 'Trek from Chame or Manang on the Annapurna Circuit. Located at high altitude, requires acclimatization. ACAP permit required.',
    best_season = 'April-May, October-November',
    entry_fee_npr = 3000,
    contact_info = 'ACAP Manang Office: +977-61-521335',
    image_url = NULL,
    photos = NULL
WHERE slug = 'manang-ice-lake';

UPDATE lakes SET
    municipality = 'Thasang Rural Municipality',
    latitude = 29.1833, longitude = 83.9500,
    how_to_reach = 'Fly to Jomsom from Pokhara (20 min), then 1-2 day trek. Inner Mustang permit required (currently $500 for 10 days).',
    best_season = 'April-May, September-October',
    entry_fee_npr = 3000,
    contact_info = 'Upper Mustang Tourism Office, Jomsom: +977-61-521335',
    image_url = NULL,
    photos = NULL
WHERE slug = 'mustang-lake';

UPDATE lakes SET
    municipality = 'Shey Phoksundo Municipality',
    latitude = 29.2200, longitude = 82.9300,
    how_to_reach = 'Same as Phoksundo Lake access. Remote area requiring multi-day trek from Juphal or Dunai.',
    best_season = 'March-May, September-November',
    entry_fee_npr = 3000,
    contact_info = 'Shey Phoksundo National Park: +977-89-540023',
    image_url = NULL,
    photos = NULL
WHERE slug = 'dolpa-phoksundo';

UPDATE lakes SET
    municipality = 'Phungling Municipality',
    latitude = 27.4167, longitude = 87.7000,
    how_to_reach = 'Fly to Taplejung airstrip or drive from Kathmandu (2-3 days via Birtamod). Multi-day trek to Kanchenjunga base camp area.',
    best_season = 'March-May, October-November',
    entry_fee_npr = 2000,
    contact_info = 'Kanchenjunga Conservation Area: +977-27-460123',
    image_url = NULL,
    photos = NULL
WHERE slug = 'taplejung-lake';

UPDATE lakes SET
    municipality = 'Kamalamai Municipality',
    latitude = 27.4167, longitude = 85.9833,
    how_to_reach = 'Drive from Kathmandu to Sindhuli Madhi (4-5 hrs), then short hike. Located near the Siddheshwor temple complex.',
    best_season = 'Year-round',
    entry_fee_npr = 0,
    contact_info = 'Sindhuli District Tourism Office: +977-47-520345',
    image_url = NULL,
    photos = NULL
WHERE slug = 'sindhuli-lake';

UPDATE lakes SET
    municipality = 'Tulsipur Sub-Metropolitan City',
    latitude = 28.1333, longitude = 82.3000,
    how_to_reach = 'Drive from Kathmandu to Tulsipur (8-10 hrs) or fly to Nepalgunj then drive 5-6 hours. Located in Dang Valley.',
    best_season = 'Year-round',
    entry_fee_npr = 0,
    contact_info = 'Dang District Tourism Office: +978-82-520234',
    image_url = NULL,
    photos = NULL
WHERE slug = 'dang-lake';

UPDATE lakes SET
    municipality = 'Kohalpur Municipality',
    latitude = 28.3833, longitude = 81.7000,
    how_to_reach = 'Drive from Nepalgunj (30 km, 45 min) or from Kathmandu (14-16 hrs). Located in Banke district lowlands.',
    best_season = 'Year-round',
    entry_fee_npr = 0,
    contact_info = 'Banke District Tourism Office: +978-51-520456',
    image_url = NULL,
    photos = NULL
WHERE slug = 'banke-lake';

UPDATE lakes SET
    municipality = 'Godawari Municipality',
    latitude = 27.5833, longitude = 85.3833,
    how_to_reach = 'Located 14 km from Kathmandu city center. Drive or take local bus to Godavari. Adjacent to National Botanical Garden.',
    best_season = 'Year-round',
    entry_fee_npr = 50,
    contact_info = 'Godavari Botanical Garden: +977-1-520045',
    image_url = NULL,
    photos = NULL
WHERE slug = 'kailali-lake';

UPDATE lakes SET
    municipality = 'Pokhara Metropolitan City',
    latitude = 28.2033, longitude = 83.9644,
    how_to_reach = 'Located 2 km from Pokhara city center. Walk or cycle from Lakeside. Adjacent to Gupteshwor Mahadev Cave.',
    best_season = 'Year-round',
    entry_fee_npr = 100,
    contact_info = 'Pokhara Tourism Office: +977-61-521202',
    image_url = 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/22/Davi%27s_Falls.jpg/800px-Davi%27s_Falls.jpg',
    photos = 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Devis_Falls_Pokhara.jpg/800px-Devis_Falls_Pokhara.jpg'
WHERE slug = 'kaski-davids-lake';
