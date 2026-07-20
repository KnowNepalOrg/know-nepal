-- V10: Seed nearby destination links and weather data

-- =============================================
-- PART A: Nearby destination links
-- =============================================

INSERT INTO nearby_destinations (destination_id, nearby_destination_id, distance_km, travel_time_minutes, travel_mode, created_at) VALUES
-- Kathmandu Valley clusters
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), (SELECT id FROM tourist_destinations WHERE slug = 'patan-durbar-square'), 8.0, 30, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), (SELECT id FROM tourist_destinations WHERE slug = 'bhaktapur-durbar-square'), 13.0, 45, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), (SELECT id FROM tourist_destinations WHERE slug = 'swayambhunath'), 3.0, 15, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), (SELECT id FROM tourist_destinations WHERE slug = 'pashupatinath'), 6.0, 20, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), (SELECT id FROM tourist_destinations WHERE slug = 'thamel'), 1.5, 10, 'WALKING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), (SELECT id FROM tourist_destinations WHERE slug = 'garden-of-dreams'), 1.0, 15, 'WALKING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), (SELECT id FROM tourist_destinations WHERE slug = 'narayanhiti-museum'), 1.2, 15, 'WALKING', NOW()),
-- Patan connections
((SELECT id FROM tourist_destinations WHERE slug = 'patan-durbar-square'), (SELECT id FROM tourist_destinations WHERE slug = 'bhaktapur-durbar-square'), 20.0, 60, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'patan-durbar-square'), (SELECT id FROM tourist_destinations WHERE slug = 'godavari'), 10.0, 30, 'DRIVING', NOW()),
-- Boudhanath and Pashupatinath
((SELECT id FROM tourist_destinations WHERE slug = 'boudhanath'), (SELECT id FROM tourist_destinations WHERE slug = 'pashupatinath'), 5.0, 20, 'DRIVING', NOW()),
-- Swayambhunath connections
((SELECT id FROM tourist_destinations WHERE slug = 'swayambhunath'), (SELECT id FROM tourist_destinations WHERE slug = 'patan-durbar-square'), 6.0, 25, 'DRIVING', NOW()),
-- Nagarkot connections
((SELECT id FROM tourist_destinations WHERE slug = 'nagarkot'), (SELECT id FROM tourist_destinations WHERE slug = 'changu-narayan'), 15.0, 60, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'nagarkot'), (SELECT id FROM tourist_destinations WHERE slug = 'bhaktapur-durbar-square'), 22.0, 60, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'nagarkot'), (SELECT id FROM tourist_destinations WHERE slug = 'dhulikhel'), 18.0, 45, 'DRIVING', NOW()),
-- Dhulikhel connections
((SELECT id FROM tourist_destinations WHERE slug = 'dhulikhel'), (SELECT id FROM tourist_destinations WHERE slug = 'panauti'), 12.0, 30, 'DRIVING', NOW()),
-- Pokhara Valley clusters
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), (SELECT id FROM tourist_destinations WHERE slug = 'sarangkot'), 12.0, 40, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), (SELECT id FROM tourist_destinations WHERE slug = 'world-peace-pagoda-pokhara'), 5.0, 30, 'WALKING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), (SELECT id FROM tourist_destinations WHERE slug = 'davis-falls'), 4.0, 15, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), (SELECT id FROM tourist_destinations WHERE slug = 'gupteshwor-cave'), 4.0, 15, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), (SELECT id FROM tourist_destinations WHERE slug = 'international-mountain-museum'), 3.0, 10, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), (SELECT id FROM tourist_destinations WHERE slug = 'seti-river-gorge'), 6.0, 20, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), (SELECT id FROM tourist_destinations WHERE slug = 'tal-barahi-temple'), 1.0, 20, 'BOATING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), (SELECT id FROM tourist_destinations WHERE slug = 'begnas-lake'), 15.0, 30, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), (SELECT id FROM tourist_destinations WHERE slug = 'rupa-lake'), 13.0, 30, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'sarangkot'), (SELECT id FROM tourist_destinations WHERE slug = 'world-peace-pagoda-pokhara'), 8.0, 45, 'WALKING', NOW()),
-- Lumbini cluster
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), (SELECT id FROM tourist_destinations WHERE slug = 'maya-devi-temple'), 0.2, 5, 'WALKING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), (SELECT id FROM tourist_destinations WHERE slug = 'ashoka-pillar'), 0.3, 5, 'WALKING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), (SELECT id FROM tourist_destinations WHERE slug = 'lumbini-museum'), 2.0, 10, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), (SELECT id FROM tourist_destinations WHERE slug = 'world-peace-pagoda-lumbini'), 3.0, 15, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), (SELECT id FROM tourist_destinations WHERE slug = 'monastic-zone-lumbini'), 1.5, 10, 'DRIVING', NOW()),
-- Mustang cluster
((SELECT id FROM tourist_destinations WHERE slug = 'jomsom'), (SELECT id FROM tourist_destinations WHERE slug = 'kagbeni'), 14.0, 30, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'jomsom'), (SELECT id FROM tourist_destinations WHERE slug = 'muktinath'), 25.0, 60, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kagbeni'), (SELECT id FROM tourist_destinations WHERE slug = 'lo-manthang'), 80.0, 360, 'DRIVING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'muktinath'), (SELECT id FROM tourist_destinations WHERE slug = 'jomsom'), 25.0, 60, 'DRIVING', NOW()),
-- Manang cluster
((SELECT id FROM tourist_destinations WHERE slug = 'thorong-la-pass'), (SELECT id FROM tourist_destinations WHERE slug = 'muktinath'), 30.0, 120, 'TREKKING', NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'ice-lake-manang'), (SELECT id FROM tourist_destinations WHERE slug = 'gangapurna-lake'), 8.0, 240, 'TREKKING', NOW()),
-- Tansen cluster
((SELECT id FROM tourist_destinations WHERE slug = 'tansen'), (SELECT id FROM tourist_destinations WHERE slug = 'rani-mahal'), 10.0, 60, 'WALKING', NOW()),
-- Janaki connections
((SELECT id FROM tourist_destinations WHERE slug = 'janaki-temple'), (SELECT id FROM tourist_destinations WHERE slug = 'ram-mandir-janakpur'), 0.5, 10, 'WALKING', NOW()),
-- Ilam connections
((SELECT id FROM tourist_destinations WHERE slug = 'ilam-tea-garden'), (SELECT id FROM tourist_destinations WHERE slug = 'kanyam-tea-garden'), 15.0, 40, 'DRIVING', NOW());


-- =============================================
-- PART B: Weather data for 20 destinations across altitudes
-- =============================================

-- ===== LOW ALTITUDE (100-800m): Warm temps =====

-- Kathmandu (1,400m - borderline low)
INSERT INTO destination_weather (destination_id, weather_season, avg_temp_celsius, min_temp_celsius, max_temp_celsius, rainfall_mm, conditions, is_recommended, created_at) VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), 'SPRING', 22.0, 14.0, 29.0, 50.0, 'Warm days with blooming rhododendrons', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), 'SUMMER', 27.0, 22.0, 32.0, 300.0, 'Hot and humid, pre-monsoon showers', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), 'AUTUMN', 21.0, 13.0, 28.0, 35.0, 'Clear skies, comfortable temperatures', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), 'WINTER', 13.0, 4.0, 20.0, 10.0, 'Cool mornings, sunny days', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), 'MONSOON', 25.0, 21.0, 29.0, 350.0, 'Heavy daily rains, lush greenery', false, NOW());

-- Pokhara / Phewa Lake (790m)
INSERT INTO destination_weather (destination_id, weather_season, avg_temp_celsius, min_temp_celsius, max_temp_celsius, rainfall_mm, conditions, is_recommended, created_at) VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), 'SPRING', 18.5, 12.0, 25.0, 80.0, 'Pleasant with blooming rhododendrons', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), 'SUMMER', 25.0, 20.0, 30.0, 350.0, 'Hot and humid, monsoon rains', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), 'AUTUMN', 17.0, 10.0, 24.0, 40.0, 'Clear skies, best visibility', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), 'WINTER', 10.0, 3.0, 17.0, 15.0, 'Cold mornings, clear days', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), 'MONSOON', 23.0, 18.0, 28.0, 500.0, 'Heavy rains, lush greenery', false, NOW());

-- Lumbini (150m)
INSERT INTO destination_weather (destination_id, weather_season, avg_temp_celsius, min_temp_celsius, max_temp_celsius, rainfall_mm, conditions, is_recommended, created_at) VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), 'SPRING', 28.0, 18.0, 35.0, 30.0, 'Hot days, warm nights, clear skies', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), 'SUMMER', 33.0, 26.0, 38.0, 250.0, 'Very hot and humid before monsoon', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), 'AUTUMN', 26.0, 17.0, 32.0, 60.0, 'Warm and pleasant, good visibility', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), 'WINTER', 18.0, 7.0, 25.0, 5.0, 'Cool and dry, pleasant for sightseeing', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), 'MONSOON', 30.0, 24.0, 34.0, 400.0, 'Heavy monsoon rains, very humid', false, NOW());

-- Chitwan (150m)
INSERT INTO destination_weather (destination_id, weather_season, avg_temp_celsius, min_temp_celsius, max_temp_celsius, rainfall_mm, conditions, is_recommended, created_at) VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'chitwan-south'), 'SPRING', 30.0, 20.0, 37.0, 40.0, 'Hot days, warm nights, clear mornings ideal for safaris', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'chitwan-south'), 'SUMMER', 34.0, 26.0, 40.0, 300.0, 'Very hot and humid, pre-monsoon', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'chitwan-south'), 'AUTUMN', 28.0, 18.0, 34.0, 80.0, 'Warm and pleasant, excellent wildlife visibility', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'chitwan-south'), 'WINTER', 20.0, 8.0, 26.0, 5.0, 'Cool and dry, best season for safari', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'chitwan-south'), 'MONSOON', 31.0, 24.0, 35.0, 500.0, 'Heavy rains, dense vegetation, trails may flood', false, NOW());


-- ===== MEDIUM ALTITUDE (1,000-2,000m): Moderate =====

-- Nagarkot (2,175m)
INSERT INTO destination_weather (destination_id, weather_season, avg_temp_celsius, min_temp_celsius, max_temp_celsius, rainfall_mm, conditions, is_recommended, created_at) VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'nagarkot'), 'SPRING', 16.0, 8.0, 23.0, 70.0, 'Pleasant days, cool nights, clear mountain views', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'nagarkot'), 'SUMMER', 20.0, 15.0, 25.0, 280.0, 'Warm and misty, monsoon clouds', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'nagarkot'), 'AUTUMN', 14.0, 6.0, 21.0, 30.0, 'Crisp mornings, spectacular clear views', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'nagarkot'), 'WINTER', 7.0, -2.0, 15.0, 8.0, 'Cold with frost, crystal-clear Himalayan views', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'nagarkot'), 'MONSOON', 18.0, 14.0, 22.0, 400.0, 'Cloud-covered, limited visibility', false, NOW());

-- Bandipur (1,030m)
INSERT INTO destination_weather (destination_id, weather_season, avg_temp_celsius, min_temp_celsius, max_temp_celsius, rainfall_mm, conditions, is_recommended, created_at) VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'bandipur'), 'SPRING', 20.0, 12.0, 27.0, 55.0, 'Warm days, blooming flowers, clear mountain views', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'bandipur'), 'SUMMER', 25.0, 19.0, 30.0, 250.0, 'Warm and humid, pre-monsoon showers', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'bandipur'), 'AUTUMN', 18.0, 10.0, 25.0, 35.0, 'Pleasant and dry, excellent visibility', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'bandipur'), 'WINTER', 12.0, 3.0, 19.0, 8.0, 'Cool mornings, clear skies, cozy evenings', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'bandipur'), 'MONSOON', 23.0, 18.0, 27.0, 380.0, 'Heavy rains, lush green landscapes', false, NOW());

-- Sarangkot (1,592m)
INSERT INTO destination_weather (destination_id, weather_season, avg_temp_celsius, min_temp_celsius, max_temp_celsius, rainfall_mm, conditions, is_recommended, created_at) VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'sarangkot'), 'SPRING', 17.0, 9.0, 24.0, 75.0, 'Pleasant mornings, clear sunrise views', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'sarangkot'), 'SUMMER', 22.0, 17.0, 27.0, 300.0, 'Warm, monsoon clouds often obscure views', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'sarangkot'), 'AUTUMN', 15.0, 7.0, 22.0, 35.0, 'Crystal-clear sunrises, best season for views', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'sarangkot'), 'WINTER', 8.0, 0.0, 16.0, 10.0, 'Cold but very clear, stunning mountain visibility', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'sarangkot'), 'MONSOON', 20.0, 15.0, 25.0, 450.0, 'Cloud-covered, limited sunrise views', false, NOW());

-- Dhulikhel (1,550m)
INSERT INTO destination_weather (destination_id, weather_season, avg_temp_celsius, min_temp_celsius, max_temp_celsius, rainfall_mm, conditions, is_recommended, created_at) VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'dhulikhel'), 'SPRING', 17.0, 9.0, 24.0, 65.0, 'Pleasant with blooming flowers and mountain views', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'dhulikhel'), 'SUMMER', 22.0, 17.0, 27.0, 280.0, 'Warm and misty', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'dhulikhel'), 'AUTUMN', 15.0, 7.0, 22.0, 30.0, 'Clear skies, excellent Himalayan panorama', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'dhulikhel'), 'WINTER', 8.0, -1.0, 16.0, 8.0, 'Cold mornings, crisp clear days', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'dhulikhel'), 'MONSOON', 20.0, 15.0, 24.0, 380.0, 'Rainy with limited visibility', false, NOW());


-- ===== HIGH ALTITUDE (3,500-5,500m): Cold, snow =====

-- Muktinath (3,710m)
INSERT INTO destination_weather (destination_id, weather_season, avg_temp_celsius, min_temp_celsius, max_temp_celsius, rainfall_mm, conditions, is_recommended, created_at) VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'muktinath'), 'SPRING', 5.0, -5.0, 14.0, 25.0, 'Cold but clear, snow still on high passes', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'muktinath'), 'SUMMER', 12.0, 3.0, 20.0, 100.0, 'Mild days, cold nights, some cloud', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'muktinath'), 'AUTUMN', 4.0, -6.0, 13.0, 15.0, 'Cold and dry, exceptional clarity', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'muktinath'), 'WINTER', -5.0, -15.0, 5.0, 10.0, 'Extreme cold, heavy snowfall, roads often closed', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'muktinath'), 'MONSOON', 10.0, 2.0, 18.0, 150.0, 'Cloudy with afternoon rain, landslides possible', false, NOW());

-- Tilicho Lake (4,919m)
INSERT INTO destination_weather (destination_id, weather_season, avg_temp_celsius, min_temp_celsius, max_temp_celsius, rainfall_mm, conditions, is_recommended, created_at) VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'tilicho-lake'), 'SPRING', -2.0, -12.0, 7.0, 20.0, 'Very cold, snow-covered trails, limited access', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'tilicho-lake'), 'SUMMER', 5.0, -4.0, 13.0, 80.0, 'Mild but windy, snowmelt feeds the lake', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'tilicho-lake'), 'AUTUMN', -3.0, -14.0, 6.0, 10.0, 'Very cold, stunningly clear, best season', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'tilicho-lake'), 'WINTER', -12.0, -25.0, -3.0, 5.0, 'Extreme cold, frozen lake, completely inaccessible', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'tilicho-lake'), 'MONSOON', 3.0, -6.0, 11.0, 120.0, 'Snow, rain, and rockfall danger', false, NOW());

-- Thorong La Pass (5,416m)
INSERT INTO destination_weather (destination_id, weather_season, avg_temp_celsius, min_temp_celsius, max_temp_celsius, rainfall_mm, conditions, is_recommended, created_at) VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'thorong-la-pass'), 'SPRING', -8.0, -20.0, 2.0, 15.0, 'Deep snow, extremely dangerous, closed', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'thorong-la-pass'), 'SUMMER', 0.0, -10.0, 8.0, 50.0, 'Snowmelt, afternoon clouds, risky', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'thorong-la-pass'), 'AUTUMN', -6.0, -18.0, 4.0, 8.0, 'Cold but clear, main crossing season', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'thorong-la-pass'), 'WINTER', -18.0, -35.0, -8.0, 3.0, 'Impossible conditions, completely closed', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'thorong-la-pass'), 'MONSOON', -2.0, -12.0, 7.0, 80.0, 'Snow, ice, and avalanche danger', false, NOW());

-- Lo Manthang (3,810m)
INSERT INTO destination_weather (destination_id, weather_season, avg_temp_celsius, min_temp_celsius, max_temp_celsius, rainfall_mm, conditions, is_recommended, created_at) VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'lo-manthang'), 'SPRING', 6.0, -4.0, 15.0, 15.0, 'Cold mornings, pleasant days, dust storms possible', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lo-manthang'), 'SUMMER', 14.0, 5.0, 22.0, 80.0, 'Monsoon shadow, relatively dry, mild', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lo-manthang'), 'AUTUMN', 5.0, -5.0, 14.0, 8.0, 'Cold and dry, crystal-clear mountain views', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lo-manthang'), 'WINTER', -5.0, -18.0, 5.0, 5.0, 'Very cold, snow possible, few visitors', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lo-manthang'), 'MONSOON', 12.0, 3.0, 20.0, 100.0, 'In Mustang rain shadow, relatively dry', false, NOW());

-- Shey Phoksundo Lake (3,611m)
INSERT INTO destination_weather (destination_id, weather_season, avg_temp_celsius, min_temp_celsius, max_temp_celsius, rainfall_mm, conditions, is_recommended, created_at) VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'shey-phoksundo-lake'), 'SPRING', 4.0, -6.0, 13.0, 20.0, 'Cold but clear, trails opening up', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'shey-phoksundo-lake'), 'SUMMER', 11.0, 2.0, 19.0, 120.0, 'Mild days, afternoon clouds, some rain', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'shey-phoksundo-lake'), 'AUTUMN', 3.0, -7.0, 12.0, 10.0, 'Cold and dry, stunning lake colors', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'shey-phoksundo-lake'), 'WINTER', -8.0, -20.0, 3.0, 8.0, 'Frozen lake, extreme cold, very difficult access', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'shey-phoksundo-lake'), 'MONSOON', 9.0, 0.0, 17.0, 100.0, 'In rain shadow, drier than other areas', false, NOW());

-- Kanchenjunga Base Camp (5,143m)
INSERT INTO destination_weather (destination_id, weather_season, avg_temp_celsius, min_temp_celsius, max_temp_celsius, rainfall_mm, conditions, is_recommended, created_at) VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'kanchenjunga-base-camp'), 'SPRING', -5.0, -15.0, 4.0, 40.0, 'Cold with heavy snow, pass closures possible', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kanchenjunga-base-camp'), 'SUMMER', 2.0, -8.0, 10.0, 200.0, 'Monsoon rain and cloud, very wet', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kanchenjunga-base-camp'), 'AUTUMN', -6.0, -17.0, 4.0, 25.0, 'Cold and dry, exceptional mountain views', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kanchenjunga-base-camp'), 'WINTER', -18.0, -30.0, -5.0, 10.0, 'Extreme cold and snow, completely closed', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kanchenjunga-base-camp'), 'MONSOON', -1.0, -10.0, 8.0, 250.0, 'Heavy monsoon, landslide and flood risk', false, NOW());

-- Rara Lake (2,990m)
INSERT INTO destination_weather (destination_id, weather_season, avg_temp_celsius, min_temp_celsius, max_temp_celsius, rainfall_mm, conditions, is_recommended, created_at) VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'rara-lake'), 'SPRING', 8.0, -2.0, 17.0, 40.0, 'Pleasant with rhododendrons blooming', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'rara-lake'), 'SUMMER', 15.0, 7.0, 22.0, 180.0, 'Warm days, afternoon showers', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'rara-lake'), 'AUTUMN', 7.0, -3.0, 16.0, 20.0, 'Cool and clear, stunning autumn colors', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'rara-lake'), 'WINTER', -3.0, -14.0, 6.0, 15.0, 'Frozen lake, heavy snow, very remote', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'rara-lake'), 'MONSOON', 13.0, 5.0, 20.0, 250.0, 'Cloudy and rainy, leeches on trails', false, NOW());
