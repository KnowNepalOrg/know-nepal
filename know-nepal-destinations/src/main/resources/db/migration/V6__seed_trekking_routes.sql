-- V6: Seed trekking routes, route-destination links, destination tags, and highlights

-- ============================================================
-- 1. TREKKING ROUTES
-- ============================================================

INSERT INTO trekking_routes (slug, name, description, difficulty_level, distance_km, duration_days, max_altitude_meters, best_season, is_popular, created_at) VALUES
('annapurna-circuit', 'Annapurna Circuit', 'Classic Himalayan circuit around the Annapurna massif crossing Thorong La Pass. Diverse landscapes from subtropical forests to high desert.', 'MODERATE', 230, 18, 5416, 'AUTUMN', true, NOW()),
('everest-base-camp', 'Everest Base Camp', 'Classic trek to the foot of Mt Everest through Sherpa heartland. Stunning views of Khumbu Icefall and surrounding 8000m peaks.', 'MODERATE', 130, 14, 5364, 'AUTUMN', true, NOW()),
('langtang-valley', 'Langtang Valley', 'Beautiful valley trek close to Kathmandu through Langtang National Park. Rich forests, glaciers, and Tamang culture.', 'MODERATE', 75, 10, 4984, 'SPRING', true, NOW()),
('manaslu-circuit', 'Manaslu Circuit', 'Remote circuit around Mt Manaslu crossing Larkya La Pass. Untouched nature and Tibetan Buddhist culture.', 'CHALLENGING', 177, 16, 5106, 'AUTUMN', true, NOW()),
('upper-mustang', 'Upper Mustang Trek', 'Forbidden kingdom trek to Lo Manthang through arid Trans-Himalayan landscapes. Ancient caves and Tibetan Buddhist monasteries.', 'MODERATE', 170, 14, 3840, 'SPRING', true, NOW()),
('annapurna-base-camp', 'Annapurna Base Camp Trek', 'Popular trek into the heart of the Annapurna Sanctuary surrounded by towering peaks. Diverse terrain from rice terraces to alpine meadows.', 'MODERATE', 110, 10, 4130, 'AUTUMN', true, NOW()),
('gokyo-lakes', 'Gokyo Lakes Trek', 'Stunning turquoise glacial lakes trek with the best Everest views from Gokyo Ri. Crosses the dramatic Cho La Pass.', 'MODERATE', 132, 13, 5357, 'AUTUMN', true, NOW()),
('kanchenjunga-base-camp-trek', 'Kanchenjunga Base Camp Trek', 'Remote trek to the base of the world''s third highest peak through pristine forests and alpine zones. Rich biodiversity and traditional Limbu culture.', 'STRENUOUS', 220, 22, 5143, 'AUTUMN', true, NOW()),
('mardi-himal', 'Mardi Himal Trek', 'Shorter but spectacular ridge trek with close-up views of Machhapuchhre and Annapurna South. Rhododendron forests and mountain vistas.', 'MODERATE', 50, 6, 4500, 'AUTUMN', true, NOW()),
('poon-hill-trek', 'Poon Hill Short Trek', 'Easy, short trek to the famous Poon Hill sunrise viewpoint. Perfect introduction to Himalayan trekking with panoramic Dhaulagiri-Annapurna views.', 'EASY', 45, 4, 3210, 'ALL_YEAR', true, NOW()),
('khopra-ridge', 'Khopra Ridge Trek', 'Off-the-beaten-path ridge trek offering spectacular views of Dhaulagiri and Annapurna. Visits traditional Magar villages and pristine forests.', 'MODERATE', 75, 8, 3660, 'AUTUMN', false, NOW()),
('tilicho-lake-trek', 'Tilicho Lake Trek', 'Challenging side trek from Annapurna Circuit to one of the world''s highest lakes at 4919 m. Stunning turquoise waters surrounded by towering peaks.', 'CHALLENGING', 85, 9, 4919, 'AUTUMN', false, NOW()),
('mohare-danda', 'Mohare Danda Trek', 'Community-managed eco-trek in Parbat district featuring rhododendron forests and panoramic mountain views. Supports local conservation and homestays.', 'EASY', 35, 4, 3313, 'ALL_YEAR', false, NOW()),
('helambu-trek', 'Helambu Trek', 'Scenic weekend trek near Kathmandu through Sherpa and Hyolmo villages. Dense forests, terraced fields, and Langtang Himalayan views.', 'EASY', 70, 6, 3640, 'ALL_YEAR', true, NOW()),
('tamang-heritage-trail', 'Tamang Heritage Trail', 'Cultural trek through traditional Tamang villages near the Tibetan border. Hot springs, ancient monasteries, and rich ethnic traditions.', 'EASY', 60, 6, 3165, 'SPRING', false, NOW()),
('nar-phu-valley', 'Nar Phu Valley Trek', 'Restricted area trek to remote Nar and Phu villages with unique Tibetan Buddhist culture. Dramatic landscapes and ancient cliff-side monasteries.', 'CHALLENGING', 90, 12, 5416, 'AUTUMN', false, NOW()),
('ruby-valley', 'Ruby Valley Trek', 'Newly opened trek through remote villages and ruby mines in the Ganesh Himal region. Hot springs, waterfalls, and terraced rice paddies.', 'MODERATE', 65, 7, 4100, 'AUTUMN', false, NOW()),
('dhaulagiri-circuit', 'Dhaulagiri Circuit Trek', 'Challenging circuit around the world''s seventh highest peak crossing French Pass at 5360 m. Remote glaciers, ice falls, and alpine terrain.', 'EXTREME', 190, 19, 5360, 'AUTUMN', true, NOW()),
('dolpo-circuit', 'Dolpo Circuit Trek', 'Remote high-altitude trek through the ancient Bon-po Buddhist kingdom of Dolpo. Shey Phoksundo Lake, crystal mountain, and Himalayan shepherds.', 'STRENUOUS', 250, 22, 5190, 'SUMMER', true, NOW()),
('rara-lake-trek', 'Rara Lake Trek', 'Trek to Nepal''s largest lake in the remote far-west. Pristine alpine lake surrounded by pine, spruce, and juniper forests.', 'MODERATE', 80, 9, 2990, 'SPRING', false, NOW()),
('rolwaling-valley', 'Rolwaling Valley Trek', 'Remote Sherpa valley trek crossing the challenging Tashi Lapcha Pass at 5755 m. Glaciers, ice walls, and pristine alpine wilderness.', 'STRENUOUS', 130, 16, 5755, 'AUTUMN', false, NOW()),
('makalu-base-camp', 'Makalu Base Camp Trek', 'Remote trek to the base of the world''s fifth highest peak through pristine forests and alpine zones. Incredible biodiversity and solitude.', 'STRENUOUS', 140, 19, 4870, 'AUTUMN', true, NOW()),
('island-peak', 'Island Peak Climbing', 'Popular trekking peak at 6189 m offering a technical climb with stunning Everest views. Ideal introduction to Himalayan mountaineering.', 'EXTREME', 130, 17, 6189, 'AUTUMN', true, NOW()),
('mera-peak', 'Mera Peak Climbing', 'Nepal''s highest permitted trekking peak at 6476 m with spectacular views of five 8000m peaks. Requires basic mountaineering skills.', 'EXTREME', 135, 19, 6476, 'AUTUMN', true, NOW()),
('pikey-peak', 'Pikey Peak Trek', 'Short trek to a sacred Sherpa peak with some of the best Everest sunrise views in the Khumbu region. Less crowded than EBC.', 'MODERATE', 55, 6, 4065, 'ALL_YEAR', false, NOW())

ON CONFLICT (slug) DO NOTHING;

-- ============================================================
-- 2. ROUTE DESTINATIONS (link routes to tourist destinations)
-- ============================================================
-- Note: Requires destination IDs from V4+V5. Uses subqueries on slug.

INSERT INTO route_destinations (route_id, destination_id, sequence_order, is_overnight_stop, created_at)

-- Annapurna Circuit
SELECT r.id, d.id, 1, true, NOW() FROM trekking_routes r, tourist_destinations d WHERE r.slug='annapurna-circuit' AND d.slug='thorong-la-pass' UNION
SELECT r.id, d.id, 2, true, NOW() FROM trekking_routes r, tourist_destinations d WHERE r.slug='annapurna-circuit' AND d.slug='tilicho-lake' UNION
SELECT r.id, d.id, 3, true, NOW() FROM trekking_routes r, tourist_destinations d WHERE r.slug='annapurna-circuit' AND d.slug='jomsom' UNION
SELECT r.id, d.id, 4, true, NOW() FROM trekking_routes r, tourist_destinations d WHERE r.slug='annapurna-circuit' AND d.slug='muktinath' UNION

-- Everest Base Camp
SELECT r.id, d.id, 1, true, NOW() FROM trekking_routes r, tourist_destinations d WHERE r.slug='everest-base-camp' AND d.slug='kala-patthar' UNION
SELECT r.id, d.id, 2, true, NOW() FROM trekking_routes r, tourist_destinations d WHERE r.slug='everest-base-camp' AND d.slug='namo-buddha' UNION

-- Annapurna Base Camp
SELECT r.id, d.id, 1, true, NOW() FROM trekking_routes r, tourist_destinations d WHERE r.slug='annapurna-base-camp' AND d.slug='poon-hill' UNION
SELECT r.id, d.id, 2, true, NOW() FROM trekking_routes r, tourist_destinations d WHERE r.slug='annapurna-base-camp' AND d.slug='chhomrung' UNION
SELECT r.id, d.id, 3, true, NOW() FROM trekking_routes r, tourist_destinations d WHERE r.slug='annapurna-base-camp' AND d.slug='sinuwa-falls' UNION

-- Langtang Valley
SELECT r.id, d.id, 1, true, NOW() FROM trekking_routes r, tourist_destinations d WHERE r.slug='langtang-valley' AND d.slug='gosainkunda-lake' UNION

-- Mardi Himal
SELECT r.id, d.id, 1, true, NOW() FROM trekking_routes r, tourist_destinations d WHERE r.slug='mardi-himal' AND d.slug='australian-camp' UNION
SELECT r.id, d.id, 2, true, NOW() FROM trekking_routes r, tourist_destinations d WHERE r.slug='mardi-himal' AND d.slug='dhampus-village' UNION

-- Poon Hill Trek
SELECT r.id, d.id, 1, true, NOW() FROM trekking_routes r, tourist_destinations d WHERE r.slug='poon-hill-trek' AND d.slug='poon-hill' UNION
SELECT r.id, d.id, 2, false, NOW() FROM trekking_routes r, tourist_destinations d WHERE r.slug='poon-hill-trek' AND d.slug='australian-camp' UNION

-- Gokyo Lakes
SELECT r.id, d.id, 1, true, NOW() FROM trekking_routes r, tourist_destinations d WHERE r.slug='gokyo-lakes' AND d.slug='gosainkunda-lake'
ON CONFLICT (route_id, destination_id) DO NOTHING;

-- ============================================================
-- 3. DESTINATION TAGS (tag 25 most popular destinations)
-- ============================================================
-- Tags IDs from V3: 1=mountain-views, 2=unesco-site, 3=pilgrimage, 4=photography,
-- 5=family-friendly, 6=budget-friendly, 7=luxury, 8=off-the-beaten-path, 9=beginner-friendly,
-- 10=solo-travel, 11=couples, 12=spring-season, 13=autumn-season, 14=monsoon-avoid,
-- 15=winter-destination, 16=tea-gardens, 17=river-lake, 18=historical-architecture,
-- 19=buddhist-heritage, 20=hindu-heritage, 21=sunset-spot, 22=sunrise-spot,
-- 23=wildlife-spotting, 24=rafting, 25=paragliding, 26=cultural-experience, 27=local-food, 28=meditation

INSERT INTO destination_tag_mappings (destination_id, tag_id, created_at)

SELECT d.id, 1, NOW() FROM tourist_destinations d WHERE d.slug='pashupatinath-temple' UNION
SELECT d.id, 3, NOW() FROM tourist_destinations d WHERE d.slug='pashupatinath-temple' UNION
SELECT d.id, 20, NOW() FROM tourist_destinations d WHERE d.slug='pashupatinath-temple' UNION
SELECT d.id, 4, NOW() FROM tourist_destinations d WHERE d.slug='pashupatinath-temple' UNION
SELECT d.id, 23, NOW() FROM tourist_destinations d WHERE d.slug='chitwan-national-park' UNION
SELECT d.id, 5, NOW() FROM tourist_destinations d WHERE d.slug='chitwan-national-park' UNION
SELECT d.id, 15, NOW() FROM tourist_destinations d WHERE d.slug='chitwan-national-park' UNION
SELECT d.id, 4, NOW() FROM tourist_destinations d WHERE d.slug='chitwan-national-park' UNION
SELECT d.id, 2, NOW() FROM tourist_destinations d WHERE d.slug='kathmandu-durbar-square-alt' UNION
SELECT d.id, 18, NOW() FROM tourist_destinations d WHERE d.slug='kathmandu-durbar-square-alt' UNION
SELECT d.id, 4, NOW() FROM tourist_destinations d WHERE d.slug='kathmandu-durbar-square-alt' UNION
SELECT d.id, 26, NOW() FROM tourist_destinations d WHERE d.slug='kathmandu-durbar-square-alt' UNION
SELECT d.id, 1, NOW() FROM tourist_destinations d WHERE d.slug='poon-hill' UNION
SELECT d.id, 4, NOW() FROM tourist_destinations d WHERE d.slug='poon-hill' UNION
SELECT d.id, 22, NOW() FROM tourist_destinations d WHERE d.slug='poon-hill' UNION
SELECT d.id, 7, NOW() FROM tourist_destinations d WHERE d.slug='poon-hill' UNION
SELECT d.id, 9, NOW() FROM tourist_destinations d WHERE d.slug='poon-hill' UNION
SELECT d.id, 23, NOW() FROM tourist_destinations d WHERE d.slug='bardia-national-park' UNION
SELECT d.id, 5, NOW() FROM tourist_destinations d WHERE d.slug='bardia-national-park' UNION
SELECT d.id, 8, NOW() FROM tourist_destinations d WHERE d.slug='bardia-national-park' UNION
SELECT d.id, 15, NOW() FROM tourist_destinations d WHERE d.slug='bardia-national-park' UNION
SELECT d.id, 1, NOW() FROM tourist_destinations d WHERE d.slug='kala-patthar' UNION
SELECT d.id, 4, NOW() FROM tourist_destinations d WHERE d.slug='kala-patthar' UNION
SELECT d.id, 22, NOW() FROM tourist_destinations d WHERE d.slug='kala-patthar' UNION
SELECT d.id, 10, NOW() FROM tourist_destinations d WHERE d.slug='kala-patthar' UNION
SELECT d.id, 14, NOW() FROM tourist_destinations d WHERE d.slug='kala-patthar' UNION
SELECT d.id, 1, NOW() FROM tourist_destinations d WHERE d.slug='gosainkunda-lake' UNION
SELECT d.id, 3, NOW() FROM tourist_destinations d WHERE d.slug='gosainkunda-lake' UNION
SELECT d.id, 19, NOW() FROM tourist_destinations d WHERE d.slug='gosainkunda-lake' UNION
SELECT d.id, 20, NOW() FROM tourist_destinations d WHERE d.slug='gosainkunda-lake' UNION
SELECT d.id, 28, NOW() FROM tourist_destinations d WHERE d.slug='gosainkunda-lake' UNION
SELECT d.id, 3, NOW() FROM tourist_destinations d WHERE d.slug='dakshinkali-temple' UNION
SELECT d.id, 20, NOW() FROM tourist_destinations d WHERE d.slug='dakshinkali-temple' UNION
SELECT d.id, 4, NOW() FROM tourist_destinations d WHERE d.slug='dakshinkali-temple' UNION
SELECT d.id, 1, NOW() FROM tourist_destinations d WHERE d.slug='chandragiri-hill' UNION
SELECT d.id, 4, NOW() FROM tourist_destinations d WHERE d.slug='chandragiri-hill' UNION
SELECT d.id, 5, NOW() FROM tourist_destinations d WHERE d.slug='chandragiri-hill' UNION
SELECT d.id, 22, NOW() FROM tourist_destinations d WHERE d.slug='chandragiri-hill' UNION
SELECT d.id, 1, NOW() FROM tourist_destinations d WHERE d.slug='halesi-mahadev-temple' UNION
SELECT d.id, 3, NOW() FROM tourist_destinations d WHERE d.slug='halesi-mahadev-temple' UNION
SELECT d.id, 20, NOW() FROM tourist_destinations d WHERE d.slug='halesi-mahadev-temple' UNION
SELECT d.id, 19, NOW() FROM tourist_destinations d WHERE d.slug='halesi-mahadev-temple' UNION
SELECT d.id, 8, NOW() FROM tourist_destinations d WHERE d.slug='halesi-mahadev-temple' UNION
SELECT d.id, 2, NOW() FROM tourist_destinations d WHERE d.slug='tilaurakot' UNION
SELECT d.id, 18, NOW() FROM tourist_destinations d WHERE d.slug='tilaurakot' UNION
SELECT d.id, 19, NOW() FROM tourist_destinations d WHERE d.slug='tilaurakot' UNION
SELECT d.id, 26, NOW() FROM tourist_destinations d WHERE d.slug='tilaurakot' UNION
SELECT d.id, 1, NOW() FROM tourist_destinations d WHERE d.slug='badimalika-temple' UNION
SELECT d.id, 3, NOW() FROM tourist_destinations d WHERE d.slug='badimalika-temple' UNION
SELECT d.id, 20, NOW() FROM tourist_destinations d WHERE d.slug='badimalika-temple' UNION
SELECT d.id, 8, NOW() FROM tourist_destinations d WHERE d.slug='badimalika-temple' UNION
SELECT d.id, 23, NOW() FROM tourist_destinations d WHERE d.slug='khaptad-national-park' UNION
SELECT d.id, 4, NOW() FROM tourist_destinations d WHERE d.slug='khaptad-national-park' UNION
SELECT d.id, 28, NOW() FROM tourist_destinations d WHERE d.slug='khaptad-national-park' UNION
SELECT d.id, 5, NOW() FROM tourist_destinations d WHERE d.slug='khaptad-national-park' UNION
SELECT d.id, 1, NOW() FROM tourist_destinations d WHERE d.slug='swargadwari-temple' UNION
SELECT d.id, 3, NOW() FROM tourist_destinations d WHERE d.slug='swargadwari-temple' UNION
SELECT d.id, 20, NOW() FROM tourist_destinations d WHERE d.slug='swargadwari-temple' UNION
SELECT d.id, 28, NOW() FROM tourist_destinations d WHERE d.slug='swargadwari-temple' UNION
SELECT d.id, 18, NOW() FROM tourist_destinations d WHERE d.slug='indreshwar-temple' UNION
SELECT d.id, 20, NOW() FROM tourist_destinations d WHERE d.slug='indreshwar-temple' UNION
SELECT d.id, 4, NOW() FROM tourist_destinations d WHERE d.slug='indreshwar-temple' UNION
SELECT d.id, 1, NOW() FROM tourist_destinations d WHERE d.slug='namo-buddha' UNION
SELECT d.id, 19, NOW() FROM tourist_destinations d WHERE d.slug='namo-buddha' UNION
SELECT d.id, 28, NOW() FROM tourist_destinations d WHERE d.slug='namo-buddha' UNION
SELECT d.id, 4, NOW() FROM tourist_destinations d WHERE d.slug='namo-buddha' UNION
SELECT d.id, 23, NOW() FROM tourist_destinations d WHERE d.slug='koshi-tappu-wildlife-reserve' UNION
SELECT d.id, 5, NOW() FROM tourist_destinations d WHERE d.slug='koshi-tappu-wildlife-reserve' UNION
SELECT d.id, 15, NOW() FROM tourist_destinations d WHERE d.slug='koshi-tappu-wildlife-reserve' UNION
SELECT d.id, 4, NOW() FROM tourist_destinations d WHERE d.slug='koshi-tappu-wildlife-reserve' UNION
SELECT d.id, 3, NOW() FROM tourist_destinations d WHERE d.slug='chandeshwori-temple' UNION
SELECT d.id, 20, NOW() FROM tourist_destinations d WHERE d.slug='chandeshwori-temple' UNION
SELECT d.id, 4, NOW() FROM tourist_destinations d WHERE d.slug='chandeshwori-temple' UNION
SELECT d.id, 8, NOW() FROM tourist_destinations d WHERE d.slug='chandeshwori-temple' UNION
SELECT d.id, 7, NOW() FROM tourist_destinations d WHERE d.slug='birendranagar' UNION
SELECT d.id, 9, NOW() FROM tourist_destinations d WHERE d.slug='birendranagar' UNION
SELECT d.id, 26, NOW() FROM tourist_destinations d WHERE d.slug='birendranagar' UNION
SELECT d.id, 6, NOW() FROM tourist_destinations d WHERE d.slug='nepalgunj-bazaar' UNION
SELECT d.id, 7, NOW() FROM tourist_destinations d WHERE d.slug='nepalgunj-bazaar' UNION
SELECT d.id, 26, NOW() FROM tourist_destinations d WHERE d.slug='nepalgunj-bazaar' UNION
SELECT d.id, 18, NOW() FROM tourist_destinations d WHERE d.slug='kirtipur' UNION
SELECT d.id, 26, NOW() FROM tourist_destinations d WHERE d.slug='kirtipur' UNION
SELECT d.id, 27, NOW() FROM tourist_destinations d WHERE d.slug='kirtipur' UNION
SELECT d.id, 4, NOW() FROM tourist_destinations d WHERE d.slug='kirtipur' UNION
SELECT d.id, 1, NOW() FROM tourist_destinations d WHERE d.slug='dhampus-village' UNION
SELECT d.id, 4, NOW() FROM tourist_destinations d WHERE d.slug='dhampus-village' UNION
SELECT d.id, 9, NOW() FROM tourist_destinations d WHERE d.slug='dhampus-village' UNION
SELECT d.id, 22, NOW() FROM tourist_destinations d WHERE d.slug='dhampus-village' UNION
SELECT d.id, 26, NOW() FROM tourist_destinations d WHERE d.slug='dhampus-village' UNION
SELECT d.id, 1, NOW() FROM tourist_destinations d WHERE d.slug='sinuwa-falls' UNION
SELECT d.id, 4, NOW() FROM tourist_destinations d WHERE d.slug='sinuwa-falls' UNION
SELECT d.id, 17, NOW() FROM tourist_destinations d WHERE d.slug='sinuwa-falls' UNION
SELECT d.id, 14, NOW() FROM tourist_destinations d WHERE d.slug='sinuwa-falls' UNION
SELECT d.id, 3, NOW() FROM tourist_destinations d WHERE d.slug='baraha-kshetra' UNION
SELECT d.id, 20, NOW() FROM tourist_destinations d WHERE d.slug='baraha-kshetra' UNION
SELECT d.id, 17, NOW() FROM tourist_destinations d WHERE d.slug='baraha-kshetra' UNION
SELECT d.id, 3, NOW() FROM tourist_destinations d WHERE d.slug='bageshwari-temple' UNION
SELECT d.id, 20, NOW() FROM tourist_destinations d WHERE d.slug='bageshwari-temple' UNION
SELECT d.id, 18, NOW() FROM tourist_destinations d WHERE d.slug='bageshwari-temple'
ON CONFLICT (destination_id, tag_id) DO NOTHING;

-- ============================================================
-- 4. DESTINATION HIGHLIGHTS (2-3 each for top 15 destinations)
-- ============================================================

INSERT INTO destination_highlights (destination_id, title, description, display_order, created_at)
SELECT d.id, 'Main Temple Architecture', 'The golden spire and silver doors of the main Pashupatinath temple, accessible only to Hindus, showcasing exquisite Nepali craftsmanship.', 1, NOW() FROM tourist_destinations d WHERE d.slug='pashupatinath-temple' UNION
SELECT d.id, 'Arya Ghat Cremation Ceremonies', 'Witness the sacred Hindu cremation rituals along the Bagmati River, a profound cultural experience that reveals deep spiritual traditions.', 2, NOW() FROM tourist_destinations d WHERE d.slug='pashupatinath-temple' UNION
SELECT d.id, 'Evening Aarti Ceremony', 'The daily evening prayer ritual on the Bagmati banks with chanting, fire offerings, and hundreds of oil lamps creating a mystical atmosphere.', 3, NOW() FROM tourist_destinations d WHERE d.slug='pashupatinath-temple' UNION
SELECT d.id, 'Elephant Safari', 'Ride through tall grasslands and dense forests on elephant back to spot one-horned rhinos, deer, and wild boar in their natural habitat.', 1, NOW() FROM tourist_destinations d WHERE d.slug='chitwan-national-park' UNION
SELECT d.id, 'Canoe Ride on Rapti River', 'Glide silently past crocodiles and exotic birds on a traditional dugout canoe, experiencing the park''s rich aquatic ecosystem.', 2, NOW() FROM tourist_destinations d WHERE d.slug='chitwan-national-park' UNION
SELECT d.id, 'Tiger Tracking', 'Join expert naturalists on foot to track the elusive Bengal tiger, the park''s most famous resident and apex predator.', 3, NOW() FROM tourist_destinations d WHERE d.slug='chitwan-national-park' UNION
SELECT d.id, 'Hanuman Dhoka Palace', 'The ancient royal palace featuring the stone inscription of King Pratap Malla and the 17th-century Hanuman statue guarding the entrance.', 1, NOW() FROM tourist_destinations d WHERE d.slug='kathmandu-durbar-square-alt' UNION
SELECT d.id, 'Kumari Bahal', 'The living goddess Kumari appears at the window of her palace residence, a unique living tradition of Nepal''s Newar culture.', 2, NOW() FROM tourist_destinations d WHERE d.slug='kathmandu-durbar-square-alt' UNION
SELECT d.id, 'Kasthamandap', 'The legendary pavilion built from a single tree that gave Kathmandu its name, standing at the heart of the old city.', 3, NOW() FROM tourist_destinations d WHERE d.slug='kathmandu-durbar-square-alt' UNION
SELECT d.id, 'Sunrise Panorama', 'Watch the first golden rays illuminate the entire Annapurna and Dhaulagiri ranges from Dhaulagiri to Machhapuchhre in a breathtaking spectacle.', 1, NOW() FROM tourist_destinations d WHERE d.slug='poon-hill' UNION
SELECT d.id, 'Mountain Photography', 'Capture the iconic layered mountain views with rhododendron forests in the foreground, especially stunning during spring bloom.', 2, NOW() FROM tourist_destinations d WHERE d.slug='poon-hill' UNION
SELECT d.id, 'Sacred Kunda', 'The holy lake surrounded by 108 smaller ponds, considered the abode of Lord Shiva, turns emerald green in summer against stark mountains.', 1, NOW() FROM tourist_destinations d WHERE d.slug='gosainkunda-lake' UNION
SELECT d.id, 'Janai Purnima Festival', 'Thousands of pilgrims bathe in the icy waters during the August full moon festival, creating a vibrant cultural spectacle at 4380 meters.', 2, NOW() FROM tourist_destinations d WHERE d.slug='gosainkunda-lake' UNION
SELECT d.id, 'Bengal Tiger Safari', 'Bardia offers the highest probability in Nepal of spotting wild Bengal tigers in their natural habitat through guided jungle safaris.', 1, NOW() FROM tourist_destinations d WHERE d.slug='bardia-national-park' UNION
SELECT d.id, 'Tharu Cultural Village', 'Visit traditional Tharu villages with unique mud-walled, cow-dung floored houses and experience the indigenous community''s rich traditions.', 2, NOW() FROM tourist_destinations d WHERE d.slug='bardia-national-park' UNION
SELECT d.id, 'Closest Everest Viewpoint', 'Stand at 5643 m and witness the majestic south face of Everest up close, with Khumbu Icefall and Nuptse forming a dramatic foreground.', 1, NOW() FROM tourist_destinations d WHERE d.slug='kala-patthar' UNION
SELECT d.id, 'Sunrise from the Top', 'The most dramatic sunrise in Nepal as the first light hits Everest''s summit pyramid, turning the world''s highest peak into a golden beacon.', 2, NOW() FROM tourist_destinations d WHERE d.slug='kala-patthar' UNION
SELECT d.id, 'Animal Sacrifice Ritual', 'Observe the ancient Shakta tradition of animal sacrifice on Tuesdays and Saturdays, a controversial but deeply important Hindu practice.', 1, NOW() FROM tourist_destinations d WHERE d.slug='dakshinkali-temple' UNION
SELECT d.id, 'Kali Goddess Shrine', 'The fearsome black stone idol of goddess Kali adorned with red vermillion and marigolds, with offerings of coconuts and sweets.', 2, NOW() FROM tourist_destinations d WHERE d.slug='dakshinkali-temple' UNION
SELECT d.id, 'Cable Car Ride', 'Enjoy a 2.5 km cable car journey over dense forests with ever-expanding views of the Kathmandu Valley and Himalayan range.', 1, NOW() FROM tourist_destinations d WHERE d.slug='chandragiri-hill' UNION
SELECT d.id, 'Bhaleshwor Temple', 'The ancient Shiva temple at the summit with a massive brass bell, offering 360-degree views of 13 Himalayan peaks on clear days.', 2, NOW() FROM tourist_destinations d WHERE d.slug='chandragiri-hill' UNION
SELECT d.id, 'Natural Shiva Cave', 'A naturally formed cave deep in Khotang hills containing a self-emerged Shiva lingam, drawing pilgrims from across eastern Nepal.', 1, NOW() FROM tourist_destinations d WHERE d.slug='halesi-mahadev-temple' UNION
SELECT d.id, 'Subterranean Stream', 'An underground river flowing through the cave system, its sound creating a meditative atmosphere within the sacred chambers.', 2, NOW() FROM tourist_destinations d WHERE d.slug='halesi-mahadev-temple' UNION
SELECT d.id, 'Shakya Palace Ruins', 'Archaeological excavations revealing the foundations of Prince Siddhartha''s palace, with ancient brick walls and courtyard layouts.', 1, NOW() FROM tourist_destinations d WHERE d.slug='tilaurakot' UNION
SELECT d.id, 'Eastern Gate', 'The historic eastern gate through which Prince Siddhartha left his palace and began his spiritual journey as an ascetic.', 2, NOW() FROM tourist_destinations d WHERE d.slug='tilaurakot' UNION
SELECT d.id, 'Khaptad Baba Ashram', 'The meditation cave and simple ashram of the revered saint Khaptad Baba, a peaceful spiritual retreat in pristine meadows.', 1, NOW() FROM tourist_destinations d WHERE d.slug='khaptad-national-park' UNION
SELECT d.id, 'Flower Meadows', 'Vast high-altitude meadows carpeted with wildflowers in summer, including 100+ species of medicinal herbs unique to the region.', 2, NOW() FROM tourist_destinations d WHERE d.slug='khaptad-national-park' UNION
SELECT d.id, '3300 m Mountain Temple', 'Perched at an elevation of 3300 meters with spectacular views of the Himalayan range, this Shakti Peetha is one of Nepal''s highest temples.', 1, NOW() FROM tourist_destinations d WHERE d.slug='badimalika-temple' UNION
SELECT d.id, 'Annual Mela Festival', 'The grand festival during August full moon draws thousands of pilgrims who trek for days to offer sacrifices and receive blessings.', 2, NOW() FROM tourist_destinations d WHERE d.slug='badimalika-temple' UNION
SELECT d.id, 'Wild Water Buffalo', 'Home to the last remaining population of wild Arna (water buffalo) in Nepal, a critically endangered species found nowhere else.', 1, NOW() FROM tourist_destinations d WHERE d.slug='koshi-tappu-wildlife-reserve' UNION
SELECT d.id, '500+ Bird Species', 'A paradise for birdwatchers with species from Siberian cranes to Bengal florican, especially during the winter migration season.', 2, NOW() FROM tourist_destinations d WHERE d.slug='koshi-tappu-wildlife-reserve'

ON CONFLICT DO NOTHING;
