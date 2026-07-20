-- V7: Seed destination tags and highlights for popular destinations

-- =============================================
-- PART A: Tag mappings for ~20 major destinations
-- =============================================

-- Kathmandu Durbar Square
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'kathmandu-durbar-square' AND t.slug IN ('unesco-site', 'cultural-experience', 'photography', 'historical-architecture', 'family-friendly')
ON CONFLICT DO NOTHING;

-- Swayambhunath
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'swayambhunath' AND t.slug IN ('buddhist-heritage', 'photography', 'cultural-experience', 'pilgrimage')
ON CONFLICT DO NOTHING;

-- Boudhanath
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'boudhanath' AND t.slug IN ('buddhist-heritage', 'pilgrimage', 'photography', 'meditation')
ON CONFLICT DO NOTHING;

-- Pashupatinath
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'pashupatinath' AND t.slug IN ('hindu-heritage', 'pilgrimage', 'cultural-experience')
ON CONFLICT DO NOTHING;

-- Phewa Lake
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'phewa-lake' AND t.slug IN ('river-lake', 'photography', 'family-friendly', 'couples')
ON CONFLICT DO NOTHING;

-- Sarangkot
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'sarangkot' AND t.slug IN ('sunrise-spot', 'mountain-views', 'photography', 'paragliding')
ON CONFLICT DO NOTHING;

-- Lumbini Sacred Garden
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'lumbini-sacred-garden' AND t.slug IN ('unesco-site', 'pilgrimage', 'buddhist-heritage', 'cultural-experience')
ON CONFLICT DO NOTHING;

-- Muktinath
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'muktinath' AND t.slug IN ('pilgrimage', 'hindu-heritage', 'buddhist-heritage', 'mountain-views')
ON CONFLICT DO NOTHING;

-- Bhaktapur Durbar Square
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'bhaktapur-durbar-square' AND t.slug IN ('unesco-site', 'historical-architecture', 'cultural-experience', 'photography')
ON CONFLICT DO NOTHING;

-- Patan Durbar Square
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'patan-durbar-square' AND t.slug IN ('unesco-site', 'historical-architecture', 'cultural-experience', 'photography')
ON CONFLICT DO NOTHING;

-- Chitwan National Park
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'chitwan-south' AND t.slug IN ('wildlife-spotting', 'family-friendly', 'off-the-beaten-path')
ON CONFLICT DO NOTHING;

-- World Peace Pagoda Pokhara
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'world-peace-pagoda-pokhara' AND t.slug IN ('buddhist-heritage', 'photography', 'sunset-spot')
ON CONFLICT DO NOTHING;

-- Nagarkot
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'nagarkot' AND t.slug IN ('sunrise-spot', 'mountain-views', 'couples')
ON CONFLICT DO NOTHING;

-- Lo Manthang
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'lo-manthang' AND t.slug IN ('off-the-beaten-path', 'cultural-experience', 'buddhist-heritage', 'historical-architecture')
ON CONFLICT DO NOTHING;

-- Bandipur
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'bandipur' AND t.slug IN ('historical-architecture', 'cultural-experience', 'couples', 'local-food')
ON CONFLICT DO NOTHING;

-- Gorkha Durbar
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'gorkha-durbar' AND t.slug IN ('historical-architecture', 'cultural-experience', 'photography')
ON CONFLICT DO NOTHING;

-- Tilicho Lake
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'tilicho-lake' AND t.slug IN ('off-the-beaten-path', 'mountain-views', 'camping')
ON CONFLICT DO NOTHING;

-- Shey Phoksundo Lake
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'shey-phoksundo-lake' AND t.slug IN ('off-the-beaten-path', 'photography', 'camping', 'wildlife-spotting')
ON CONFLICT DO NOTHING;

-- Rara Lake
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'rara-lake' AND t.slug IN ('off-the-beaten-path', 'photography', 'camping', 'river-lake')
ON CONFLICT DO NOTHING;

-- Ilam Tea Garden
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'ilam-tea-garden' AND t.slug IN ('tea-gardens', 'photography', 'couples', 'local-food')
ON CONFLICT DO NOTHING;

-- Thamel
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'thamel' AND t.slug IN ('local-food', 'family-friendly', 'cultural-experience')
ON CONFLICT DO NOTHING;

-- Janaki Temple
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'janaki-temple' AND t.slug IN ('hindu-heritage', 'pilgrimage', 'historical-architecture')
ON CONFLICT DO NOTHING;

-- Tansen
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'tansen' AND t.slug IN ('historical-architecture', 'cultural-experience', 'local-food', 'couples')
ON CONFLICT DO NOTHING;

-- Dhulikhel
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'dhulikhel' AND t.slug IN ('sunrise-spot', 'mountain-views', 'historical-architecture', 'couples')
ON CONFLICT DO NOTHING;

-- Kanchenjunga Base Camp
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'kanchenjunga-base-camp' AND t.slug IN ('mountain-views', 'off-the-beaten-path', 'camping')
ON CONFLICT DO NOTHING;

-- Thorong La Pass
INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)
SELECT d.id, t.id, NOW()
FROM tourist_destinations d, destination_tags t
WHERE d.slug = 'thorong-la-pass' AND t.slug IN ('mountain-views', 'off-the-beaten-path', 'camping')
ON CONFLICT DO NOTHING;


-- =============================================
-- PART B: Highlights for 20 popular destinations
-- =============================================

-- Kathmandu Durbar Square
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), 'Living Goddess Kumari', 'Witness the ancient tradition of the Living Goddess, a young girl worshipped as the incarnation of Taleju Bhawani, who appears at the Kumari Ghar window.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), 'Hanuman Dhoka Palace', 'Explore the historic royal palace complex with its courtyards, temples, and the throne room of the Malla and Shah kings.', 2, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), 'Taleju Temple', 'Admire the towering pagoda-style temple dedicated to the royal deity Taleju, the tallest structure in the square.', 3, NOW());

-- Swayambhunath
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'swayambhunath'), '365-Step Climb to the Top', 'Ascend the ancient stone staircase through the forested hillside, encountering prayer wheels, shrines, and mischievous monkeys along the way.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'swayambhunath'), 'Ancient Buddhist Stupa', 'Marvel at the iconic white dome with its gilded spire and the all-seeing eyes of Buddha gazing in four directions.', 2, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'swayambhunath'), 'Panoramic Valley Views', 'Enjoy breathtaking 360-degree views of Kathmandu Valley from the hilltop, especially stunning at sunset.', 3, NOW());

-- Boudhanath
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'boudhanath'), 'Largest Stupa in Nepal', 'Stand before the colossal white dome of Boudhanath, one of the largest spherical stupas in the world, with its towering spire reaching 36 meters.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'boudhanath'), 'Tibetan Buddhist Culture', 'Immerse yourself in the vibrant Tibetan Buddhist community with spinning prayer wheels, chanting monks, and the aroma of incense.', 2, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'boudhanath'), 'Kora Circuit', 'Walk the sacred clockwise circumambulation path around the stupa alongside pilgrims, spinning prayer wheels and absorbing the spiritual atmosphere.', 3, NOW());

-- Pashupatinath
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'pashupatinath'), 'Sacred Hindu Cremation Ghats', 'Observe the ancient funeral rites at Arya Ghat along the Bagmati River, where Hindus perform cremation ceremonies for their departed.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'pashupatinath'), 'Shiva Temple Complex', 'Explore the sprawling complex of over 500 temples and shrines dedicated to Lord Shiva, including the golden four-faced lingam.', 2, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'pashupatinath'), 'Evening Aarti Ceremony', 'Witness the spectacular evening aarti ritual with fire, bells, and devotional chanting along the riverbank.', 3, NOW());

-- Phewa Lake
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), 'Boating on Peaceful Waters', 'Glide across the serene lake in a colorful wooden boat, surrounded by reflections of the Annapurna range and lush forests.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), 'Tal Barahi Temple Island', 'Visit the enchanting two-storied pagoda temple perched on an island in the middle of the lake, accessible only by boat.', 2, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), 'Mountain Reflections', 'Capture the perfect photograph of Machhapuchhre and Annapurna reflected in the still waters during early morning.', 3, NOW());

-- Sarangkot
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'sarangkot'), 'Annapurna Sunrise View', 'Wake before dawn to witness one of the world''s most spectacular sunrises as golden light paints the Annapurna and Dhaulagiri ranges.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'sarangkot'), 'Paragliding Launch Point', 'Take off from the hillside tandem paragliding for an unforgettable aerial view of Phewa Lake, Pokhara city, and the Himalayan backdrop.', 2, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'sarangkot'), 'Himalayan Panorama', 'Enjoy an unobstructed 180-degree panorama stretching from Dhaulagiri in the west to Machhapuchhre and the Annapurna range in the east.', 3, NOW());

-- Lumbini Sacred Garden
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), 'Birthplace of Buddha', 'Stand at the exact spot where Queen Mayadevi gave birth to Prince Siddhartha Gautama in 623 BC, marked by the sacred marker stone.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), 'Ashoka Pillar', 'See the ancient stone pillar erected by Emperor Ashoka in 249 BC, bearing one of the oldest inscriptions confirming Lumbini as Buddha''s birthplace.', 2, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), 'Sacred Garden', 'Wander through the tranquil garden dotted with ancient ruins, the Puskarini pond, and the Maya Devi Temple surrounded by centuries of history.', 3, NOW());

-- Muktinath
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'muktinath'), 'Sacred Vishnu Temple', 'Visit the ancient temple of Lord Vishnu at 3,710 meters, one of the highest-altitude temples in the world and sacred to both Hindus and Buddhists.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'muktinath'), '108 Water Spouts', 'Walk through the wall of 108 bull-head water spouts releasing icy water from the sacred Kali Gandaki river, a deeply spiritual experience.', 2, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'muktinath'), 'Eternal Flame', 'Witness the natural gas flame that burns perpetually from the rock face, a geological marvel revered as a divine manifestation.', 3, NOW());

-- Bhaktapur Durbar Square
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'bhaktapur-durbar-square'), '55-Window Palace', 'Marvel at the magnificent 15th-century palace featuring 55 intricately carved wooden windows, a masterpiece of Newari architecture.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'bhaktapur-durbar-square'), 'Nyatapola Temple', 'Look up at Nepal''s tallest pagoda temple, a five-storied masterpiece towering 30 meters that has withstood centuries of earthquakes.', 2, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'bhaktapur-durbar-square'), 'Pottery Square', 'Watch skilled artisans shaping clay into traditional pottery in the open square, continuing a centuries-old craft.', 3, NOW());

-- Patan Durbar Square
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'patan-durbar-square'), 'Krishna Mandir', 'Admire the stunning stone temple with its 21 spires, featuring intricate carvings depicting scenes from the Mahabharata and Ramayana.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'patan-durbar-square'), 'Golden Temple', 'Discover the hidden Hiranya Varna Mahavihar, a stunning gilded Buddhist monastery with exquisite metalwork and peaceful courtyards.', 2, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'patan-durbar-square'), 'Patan Museum', 'Explore one of South Asia''s finest museums housed in the old royal palace, showcasing centuries of Nepali metalwork and stone sculpture.', 3, NOW());

-- Chitwan National Park
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'chitwan-south'), 'One-Horned Rhino Safari', 'Spot the endangered greater one-horned rhinoceros grazing in the grasslands during an early morning jeep safari.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'chitwan-south'), 'Jungle Safari on Elephant Back', 'Ride through dense sal forests and grasslands on elephant back for a unique vantage point to spot wildlife.', 2, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'chitwan-south'), 'Tharu Cultural Show', 'Experience the vibrant culture of the indigenous Tharu people with traditional dances, stick fights, and fire walking performances.', 3, NOW());

-- World Peace Pagoda Pokhara
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'world-peace-pagoda-pokhara'), 'Panoramic Mountain Views', 'Take in sweeping views of the Annapurna range, Machhapuchhre, Phewa Lake, and Pokhara city from the hilltop.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'world-peace-pagoda-pokhara'), 'Peaceful Meditation Spot', 'Find tranquility in the serene atmosphere surrounding the gleaming white stupa, ideal for quiet reflection.', 2, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'world-peace-pagoda-pokhara'), 'Sunset Viewing', 'Watch the sun set behind the Himalayan peaks, painting the sky in vivid oranges and purples from this prime viewpoint.', 3, NOW());

-- Nagarkot
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'nagarkot'), 'Everest Sunrise View', 'On clear mornings, witness the golden rays of dawn illuminating Mount Everest and the eastern Himalayan range from the observation tower.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'nagarkot'), 'Himalayan Panorama', 'Enjoy an uninterrupted vista stretching from Annapurna in the west to Kanchenjunga in the east, spanning nearly the entire Nepal Himalaya.', 2, NOW());

-- Lo Manthang
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'lo-manthang'), 'Ancient Walled City', 'Pass through the medieval gates into the walled capital of the former Kingdom of Mustang, frozen in time since the 14th century.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lo-manthang'), 'Tibetan Buddhist Monasteries', 'Explore the four ancient gompas with their remarkable frescoes, thangka paintings, and centuries-old religious artifacts.', 2, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lo-manthang'), 'Royal Palace', 'Visit the four-story Royal Palace built in Tibetan style, once home to the Kings of Mustang, with its ornate courtyards and throne room.', 3, NOW());

-- Bandipur
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'bandipur'), 'Newari Architecture Heritage', 'Stroll through the beautifully preserved cobblestone bazaar lined with traditional Newari buildings, temples, and merchant houses.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'bandipur'), 'Panoramic Hill Views', 'Gaze out over the Terai plains to the south and the towering Himalayan peaks to the north from the hilltop town.', 2, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'bandipur'), 'Siddha Gufa Cave', 'Descend into Nepal''s largest cave, home to impressive stalactites, stalagmites, and an underground stream.', 3, NOW());

-- Gorkha Durbar
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'gorkha-durbar'), 'Birthplace of Unified Nepal', 'Stand where King Prithvi Narayan Shah planned the unification of Nepal, a defining moment in the nation''s history.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'gorkha-durbar'), 'Hilltop Palace Fortress', 'Climb to the hilltop palace and enjoy commanding views of the Gorkha valley and surrounding Himalayan ranges.', 2, NOW());

-- Tilicho Lake
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'tilicho-lake'), 'One of the World''s Highest Lakes', 'Reach the breathtaking Tilicho Lake at 4,919 meters, a record-holder for being one of the highest lakes on Earth.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'tilicho-lake'), 'Dramatic Alpine Scenery', 'Trek through stark, dramatic landscapes of scree slopes, glacial moraines, and towering vertical walls of rock and ice.', 2, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'tilicho-lake'), 'Glacial Mountain Backdrop', 'Witness the lake''s surreal turquoise waters set against the massive north face of Tilicho Peak and the Great Barrier wall.', 3, NOW());

-- Shey Phoksundo Lake
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'shey-phoksundo-lake'), 'Turquoise Deep Blue Waters', 'Behold Nepal''s deepest lake with its mesmerizing deep turquoise color, so clear that visibility extends to 20 meters.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'shey-phoksundo-lake'), 'Remote Himalayan Wilderness', 'Experience the pristine isolation of the Dolpa region, one of the most remote and untouched areas in the Himalayas.', 2, NOW());

-- Rara Lake
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'rara-lake'), 'Nepal''s Largest Lake', 'Discover the grandeur of Rara Lake, the largest lake in Nepal spanning 10.8 km in circumference at 2,990 meters.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'rara-lake'), 'Crystal-Clear Alpine Waters', 'Marvel at the pristine waters that shift from deep blue to emerald green depending on the light and season.', 2, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'rara-lake'), 'Pristine Forest Surroundings', 'Walk through dense forests of blue pine, black juniper, and west Himalayan spruce surrounding the sacred lake.', 3, NOW());

-- Ilam Tea Garden
INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
VALUES
((SELECT id FROM tourist_destinations WHERE slug = 'ilam-tea-garden'), 'Rolling Green Tea Plantations', 'Walk through emerald-green terraces of tea bushes stretching across the hills, one of Nepal''s most photogenic landscapes.', 1, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'ilam-tea-garden'), 'Kanchenjunga Mountain Views', 'Enjoy stunning views of the world''s third-highest mountain rising behind the pastoral tea estate.', 2, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'ilam-tea-garden'), 'Tea Tasting Experience', 'Sample freshly processed orthodox tea at the factory and learn about the centuries-old tea production process.', 3, NOW());
