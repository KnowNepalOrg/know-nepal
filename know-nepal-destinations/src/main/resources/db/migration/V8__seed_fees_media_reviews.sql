-- V8: Seed fees, media, and reviews for popular destinations

-- =============================================
-- PART A: Fees for ~30 destinations
-- =============================================

INSERT INTO destination_fees (destination_id, fee_type, amount, currency, description, is_mandatory, created_at) VALUES
-- Kathmandu Durbar Square
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), 'ENTRY', 1000, 'NPR', 'Foreign tourist entry fee', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), 'ENTRY', 150, 'NPR', 'SAARC tourist entry fee', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), 'ENTRY', 100, 'NPR', 'Nepali citizen entry fee', true, NOW()),
-- Patan Durbar Square
((SELECT id FROM tourist_destinations WHERE slug = 'patan-durbar-square'), 'ENTRY', 1000, 'NPR', 'Foreign tourist entry fee', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'patan-durbar-square'), 'ENTRY', 100, 'NPR', 'SAARC tourist entry fee', true, NOW()),
-- Bhaktapur Durbar Square
((SELECT id FROM tourist_destinations WHERE slug = 'bhaktapur-durbar-square'), 'ENTRY', 1500, 'NPR', 'Foreign tourist entry fee', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'bhaktapur-durbar-square'), 'ENTRY', 150, 'NPR', 'SAARC tourist entry fee', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'bhaktapur-durbar-square'), 'GUIDE', 500, 'NPR', 'Licensed local guide (optional)', false, NOW()),
-- Swayambhunath
((SELECT id FROM tourist_destinations WHERE slug = 'swayambhunath'), 'ENTRY', 200, 'NPR', 'Foreign tourist entry fee', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'swayambhunath'), 'ENTRY', 50, 'NPR', 'Nepali citizen entry fee', true, NOW()),
-- Boudhanath
((SELECT id FROM tourist_destinations WHERE slug = 'boudhanath'), 'ENTRY', 400, 'NPR', 'Foreign tourist entry fee', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'boudhanath'), 'ENTRY', 50, 'NPR', 'Nepali citizen entry fee', true, NOW()),
-- Pashupatinath
((SELECT id FROM tourist_destinations WHERE slug = 'pashupatinath'), 'ENTRY', 1000, 'NPR', 'Foreign tourist entry fee', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'pashupatinath'), 'ENTRY', 100, 'NPR', 'SAARC tourist entry fee', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'pashupatinath'), 'GUIDE', 500, 'NPR', 'Licensed local guide (optional)', false, NOW()),
-- Chitwan National Park
((SELECT id FROM tourist_destinations WHERE slug = 'chitwan-south'), 'ENTRY', 2000, 'NPR', 'Foreign tourist entry fee (per day)', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'chitwan-south'), 'ENTRY', 1000, 'NPR', 'SAARC tourist entry fee (per day)', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'chitwan-south'), 'OTHER', 1500, 'NPR', 'Vehicle entry fee per day', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'chitwan-south'), 'GUIDE', 3000, 'NPR', 'Licensed jungle guide per day', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'chitwan-south'), 'TRANSPORT', 4000, 'NPR', 'Jeep safari per person', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'chitwan-south'), 'ACCOMMODATION', 5000, 'NPR', 'Basic lodge per night', false, NOW()),
-- Lumbini Sacred Garden
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), 'ENTRY', 0, 'NPR', 'Free entry to sacred zone', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), 'OTHER', 50, 'NPR', 'Bicycle rental fee', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), 'TRANSPORT', 100, 'NPR', 'Electric bus tour of monastic zone', false, NOW()),
-- Sagarmatha (Everest) National Park
((SELECT id FROM tourist_destinations WHERE slug = 'nagarkot'), 'ENTRY', 3000, 'NPR', 'Sagarmatha National Park foreign entry fee', true, NOW()),
-- Annapurna Conservation Area
((SELECT id FROM tourist_destinations WHERE slug = 'sarangkot'), 'ENTRY', 3000, 'NPR', 'Annapurna Conservation Area foreign entry fee', true, NOW()),
-- Muktinath
((SELECT id FROM tourist_destinations WHERE slug = 'muktinath'), 'ENTRY', 100, 'NPR', 'Temple entry fee', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'muktinath'), 'OTHER', 50, 'NPR', 'Shoe and bag storage', false, NOW()),
-- Lo Manthang
((SELECT id FROM tourist_destinations WHERE slug = 'lo-manthang'), 'ENTRY', 5000, 'NPR', 'Restricted area permit (first 10 days)', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lo-manthang'), 'ENTRY', 1000, 'NPR', 'Additional per day beyond 10 days', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lo-manthang'), 'GUIDE', 3000, 'NPR', 'Mandatory licensed guide per day', true, NOW()),
-- Thamel
((SELECT id FROM tourist_destinations WHERE slug = 'thamel'), 'ENTRY', 0, 'NPR', 'Free entry', true, NOW()),
-- World Peace Pagoda Pokhara
((SELECT id FROM tourist_destinations WHERE slug = 'world-peace-pagoda-pokhara'), 'ENTRY', 0, 'NPR', 'Free entry', true, NOW()),
-- Garden of Dreams
((SELECT id FROM tourist_destinations WHERE slug = 'garden-of-dreams'), 'ENTRY', 200, 'NPR', 'Foreign tourist entry fee', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'garden-of-dreams'), 'ENTRY', 100, 'NPR', 'Nepali citizen entry fee', true, NOW()),
-- Narayanhiti Palace Museum
((SELECT id FROM tourist_destinations WHERE slug = 'narayanhiti-museum'), 'ENTRY', 500, 'NPR', 'Foreign tourist entry fee', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'narayanhiti-museum'), 'ENTRY', 50, 'NPR', 'Nepali citizen entry fee', true, NOW()),
-- Changu Narayan
((SELECT id FROM tourist_destinations WHERE slug = 'changu-narayan'), 'ENTRY', 100, 'NPR', 'Foreign tourist entry fee', true, NOW()),
-- Gorkha Durbar
((SELECT id FROM tourist_destinations WHERE slug = 'gorkha-durbar'), 'ENTRY', 100, 'NPR', 'Foreign tourist entry fee', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'gorkha-durbar'), 'GUIDE', 500, 'NPR', 'Licensed local guide (optional)', false, NOW()),
-- Janaki Temple
((SELECT id FROM tourist_destinations WHERE slug = 'janaki-temple'), 'ENTRY', 50, 'NPR', 'Foreign tourist entry fee', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'janaki-temple'), 'ENTRY', 0, 'NPR', 'Nepali citizen entry fee', true, NOW()),
-- Manakamana Temple
((SELECT id FROM tourist_destinations WHERE slug = 'manakamana-temple'), 'ENTRY', 500, 'NPR', 'Cable car round trip (foreign tourist)', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'manakamana-temple'), 'ENTRY', 100, 'NPR', 'Cable car round trip (Nepali citizen)', true, NOW()),
-- Shivapuri National Park
((SELECT id FROM tourist_destinations WHERE slug = 'shivapuri-national-park'), 'ENTRY', 300, 'NPR', 'Foreign tourist entry fee', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'shivapuri-national-park'), 'ENTRY', 100, 'NPR', 'Nepali citizen entry fee', true, NOW()),
-- Shey Phoksundo Lake / National Park
((SELECT id FROM tourist_destinations WHERE slug = 'shey-phoksundo-lake'), 'ENTRY', 5000, 'NPR', 'Restricted area permit (foreign tourist)', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phoksundo-national-park'), 'ENTRY', 3000, 'NPR', 'National park entry fee (foreign tourist)', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phoksundo-national-park'), 'GUIDE', 3000, 'NPR', 'Mandatory licensed guide per day', true, NOW()),
-- Rara Lake
((SELECT id FROM tourist_destinations WHERE slug = 'rara-lake'), 'ENTRY', 3000, 'NPR', 'National park entry fee (foreign tourist)', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'rara-lake'), 'ACCOMMODATION', 2000, 'NPR', 'Basic lodge per night', false, NOW()),
-- Kanchenjunga Base Camp
((SELECT id FROM tourist_destinations WHERE slug = 'kanchenjunga-base-camp'), 'ENTRY', 2000, 'NPR', 'Restricted area permit (first 4 weeks)', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kanchenjunga-base-camp'), 'ENTRY', 500, 'NPR', 'Additional per week beyond 4 weeks', true, NOW()),
-- International Mountain Museum
((SELECT id FROM tourist_destinations WHERE slug = 'international-mountain-museum'), 'ENTRY', 300, 'NPR', 'Foreign tourist entry fee', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'international-mountain-museum'), 'ENTRY', 100, 'NPR', 'Nepali citizen entry fee', true, NOW()),
-- Davis Falls
((SELECT id FROM tourist_destinations WHERE slug = 'davis-falls'), 'ENTRY', 50, 'NPR', 'Entry fee', true, NOW()),
-- Gupteshwor Cave
((SELECT id FROM tourist_destinations WHERE slug = 'gupteshwor-cave'), 'ENTRY', 50, 'NPR', 'Entry fee', true, NOW()),
-- Tansen
((SELECT id FROM tourist_destinations WHERE slug = 'tansen'), 'ENTRY', 0, 'NPR', 'Free entry to town', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'rani-mahal'), 'ENTRY', 100, 'NPR', 'Palace entry fee', true, NOW()),
-- Shuklaphanta Wildlife Reserve
((SELECT id FROM tourist_destinations WHERE slug = 'shuklaphanta-wildlife-reserve'), 'ENTRY', 2000, 'NPR', 'Foreign tourist entry fee (per day)', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'shuklaphanta-wildlife-reserve'), 'TRANSPORT', 3000, 'NPR', 'Jeep safari per person', false, NOW()),
-- Bandipur
((SELECT id FROM tourist_destinations WHERE slug = 'bandipur'), 'ENTRY', 0, 'NPR', 'Free entry to town', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'bandipur'), 'OTHER', 200, 'NPR', 'Siddha Gufa Cave entry', false, NOW()),
-- Dhulikhel
((SELECT id FROM tourist_destinations WHERE slug = 'dhulikhel'), 'ENTRY', 0, 'NPR', 'Free entry to town', true, NOW()),
-- Tilicho Lake (part of Annapurna Conservation Area)
-- (fee covered under ACA permit above)
-- Phewa Lake
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), 'OTHER', 200, 'NPR', 'Boat rental per hour (non-motorized)', false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), 'OTHER', 800, 'NPR', 'Motorboat rental per hour', false, NOW());


-- =============================================
-- PART B: Media for ~20 destinations
-- =============================================

INSERT INTO destination_media (destination_id, url, caption, media_type, display_order, is_primary, created_at) VALUES
-- Phewa Lake
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), 'https://images.knownepal.com/phewa-lake-main.jpg', 'Phewa Lake with Annapurna reflection', 'PHOTO', 1, true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), 'https://images.knownepal.com/phewa-lake-boating.jpg', 'Colorful boats on Phewa Lake at dawn', 'PHOTO', 2, false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), 'https://images.knownepal.com/phewa-lake-panorama.mp4', 'Aerial drone view of Phewa Lake and Pokhara', 'VIDEO', 3, false, NOW()),
-- Kathmandu Durbar Square
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), 'https://images.knownepal.com/kathmandu-durbar-main.jpg', 'Kathmandu Durbar Square temple complex at golden hour', 'PHOTO', 1, true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), 'https://images.knownepal.com/kathmandu-durbar-kumari.jpg', 'Kumari Ghar window of the Living Goddess', 'PHOTO', 2, false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), 'https://images.knownepal.com/kathmandu-durbar-360.mp4', '360-degree view of Kathmandu Durbar Square', 'THREE_60_VIEW', 3, false, NOW()),
-- Swayambhunath
((SELECT id FROM tourist_destinations WHERE slug = 'swayambhunath'), 'https://images.knownepal.com/swayambhunath-main.jpg', 'Swayambhunath stupa with Kathmandu Valley backdrop', 'PHOTO', 1, true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'swayambhunath'), 'https://images.knownepal.com/swayambhunath-monkeys.jpg', 'Monkeys resting on the temple stairs', 'PHOTO', 2, false, NOW()),
-- Boudhanath
((SELECT id FROM tourist_destinations WHERE slug = 'boudhanath'), 'https://images.knownepal.com/boudhanath-main.jpg', 'Boudhanath Stupa illuminated at dusk', 'PHOTO', 1, true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'boudhanath'), 'https://images.knownepal.com/boudhanath-kora.jpg', 'Devotees performing kora around the stupa', 'PHOTO', 2, false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'boudhanath'), 'https://images.knownepal.com/boudhanath-aerial.jpg', 'Aerial view of the massive stupa and surrounding monasteries', 'PHOTO', 3, false, NOW()),
-- Pashupatinath
((SELECT id FROM tourist_destinations WHERE slug = 'pashupatinath'), 'https://images.knownepal.com/pashupatinath-main.jpg', 'Pashupatinath Temple complex across the Bagmati River', 'PHOTO', 1, true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'pashupatinath'), 'https://images.knownepal.com/pashupatinath-ghats.jpg', 'Cremation ghats along the Bagmati River', 'PHOTO', 2, false, NOW()),
-- Sarangkot
((SELECT id FROM tourist_destinations WHERE slug = 'sarangkot'), 'https://images.knownepal.com/sarangkot-sunrise.jpg', 'Sunrise over Annapurna and Machhapuchhre from Sarangkot', 'PHOTO', 1, true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'sarangkot'), 'https://images.knownepal.com/sarangkot-paragliding.jpg', 'Paragliders soaring above Sarangkot with lake view', 'PHOTO', 2, false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'sarangkot'), 'https://images.knownepal.com/sarangkot-panorama.mp4', 'Timelapse of sunrise from Sarangkot viewpoint', 'VIDEO', 3, false, NOW()),
-- Lumbini
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), 'https://images.knownepal.com/lumbini-sacred-garden.jpg', 'Lumbini Sacred Garden with Maya Devi Temple', 'PHOTO', 1, true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), 'https://images.knownepal.com/lumbini-ashoka-pillar.jpg', 'Emperor Ashoka Pillar marking Buddha birthplace', 'PHOTO', 2, false, NOW()),
-- Bhaktapur Durbar Square
((SELECT id FROM tourist_destinations WHERE slug = 'bhaktapur-durbar-square'), 'https://images.knownepal.com/bhaktapur-main.jpg', 'Bhaktapur Durbar Square with Nyatapola Temple', 'PHOTO', 1, true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'bhaktapur-durbar-square'), 'https://images.knownepal.com/bhaktapur-55windows.jpg', 'The famous 55-Window Palace facade', 'PHOTO', 2, false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'bhaktapur-durbar-square'), 'https://images.knownepal.com/bhaktapur-pottery.jpg', 'Artisans at work in Pottery Square', 'PHOTO', 3, false, NOW()),
-- Patan Durbar Square
((SELECT id FROM tourist_destinations WHERE slug = 'patan-durbar-square'), 'https://images.knownepal.com/patan-main.jpg', 'Patan Durbar Square Krishna Mandir at sunset', 'PHOTO', 1, true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'patan-durbar-square'), 'https://images.knownepal.com/patan-museum.jpg', 'Patan Museum courtyard with stone sculptures', 'PHOTO', 2, false, NOW()),
-- Chitwan
((SELECT id FROM tourist_destinations WHERE slug = 'chitwan-south'), 'https://images.knownepal.com/chitwan-rhino.jpg', 'Greater one-horned rhinoceros in Chitwan grasslands', 'PHOTO', 1, true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'chitwan-south'), 'https://images.knownepal.com/chitwan-elephant-safari.jpg', 'Elephant safari through dense sal forest', 'PHOTO', 2, false, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'chitwan-south'), 'https://images.knownepal.com/chitwan-canoe.jpg', 'Canoe ride on the Rapti River at sunset', 'PHOTO', 3, false, NOW()),
-- Nagarkot
((SELECT id FROM tourist_destinations WHERE slug = 'nagarkot'), 'https://images.knownepal.com/nagarkot-sunrise.jpg', 'Himalayan sunrise from Nagarkot observation tower', 'PHOTO', 1, true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'nagarkot'), 'https://images.knownepal.com/nagarkot-panorama.jpg', 'Panoramic view from Langtang to Everest from Nagarkot', 'PHOTO', 2, false, NOW()),
-- Muktinath
((SELECT id FROM tourist_destinations WHERE slug = 'muktinath'), 'https://images.knownepal.com/muktinath-main.jpg', 'Muktinath Temple with 108 water spouts', 'PHOTO', 1, true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'muktinath'), 'https://images.knownepal.com/muktinath-spouts.jpg', 'Pilgrims bathing under the 108 sacred water spouts', 'PHOTO', 2, false, NOW()),
-- Lo Manthang
((SELECT id FROM tourist_destinations WHERE slug = 'lo-manthang'), 'https://images.knownepal.com/lo-manthang-main.jpg', 'Aerial view of the ancient walled city of Lo Manthang', 'PHOTO', 1, true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'lo-manthang'), 'https://images.knownepal.com/lo-manthang-monastery.jpg', 'Interior of Champa Lhakshyil Gompa with ancient frescoes', 'PHOTO', 2, false, NOW()),
-- World Peace Pagoda Pokhara
((SELECT id FROM tourist_destinations WHERE slug = 'world-peace-pagoda-pokhara'), 'https://images.knownepal.com/peace-pagoda-pokhara.jpg', 'World Peace Pagoda with Annapurna range backdrop', 'PHOTO', 1, true, NOW()),
-- Bandipur
((SELECT id FROM tourist_destinations WHERE slug = 'bandipur'), 'https://images.knownepal.com/bandipur-bazaar.jpg', 'Traditional Newari bazaar street in Bandipur', 'PHOTO', 1, true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'bandipur'), 'https://images.knownepal.com/bandipur-panorama.jpg', 'Panoramic view from Bandipur hilltop', 'PHOTO', 2, false, NOW()),
-- Gorkha Durbar
((SELECT id FROM tourist_destinations WHERE slug = 'gorkha-durbar'), 'https://images.knownepal.com/gorkha-durbar-main.jpg', 'Gorkha Durbar palace complex on the hilltop', 'PHOTO', 1, true, NOW()),
-- Shey Phoksundo Lake
((SELECT id FROM tourist_destinations WHERE slug = 'shey-phoksundo-lake'), 'https://images.knownepal.com/phoksundo-main.jpg', 'Turquoise waters of Phoksundo Lake with surrounding cliffs', 'PHOTO', 1, true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'shey-phoksundo-lake'), 'https://images.knownepal.com/phoksundo-waterfall.jpg', 'Phoksundo Waterfall cascading into the lake', 'PHOTO', 2, false, NOW()),
-- Rara Lake
((SELECT id FROM tourist_destinations WHERE slug = 'rara-lake'), 'https://images.knownepal.com/rara-main.jpg', 'Rara Lake with forested hills and snow peaks', 'PHOTO', 1, true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'rara-lake'), 'https://images.knownepal.com/rara-autumn.jpg', 'Rara Lake in autumn colors from the hilltop viewpoint', 'PHOTO', 2, false, NOW()),
-- Ilam Tea Garden
((SELECT id FROM tourist_destinations WHERE slug = 'ilam-tea-garden'), 'https://images.knownepal.com/ilam-tea-main.jpg', 'Rolling green tea terraces of Ilam with Kanchenjunga behind', 'PHOTO', 1, true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'ilam-tea-garden'), 'https://images.knownepal.com/ilam-tea-worker.jpg', 'Tea plucker harvesting leaves at dawn', 'PHOTO', 2, false, NOW()),
-- Thamel
((SELECT id FROM tourist_destinations WHERE slug = 'thamel'), 'https://images.knownepal.com/thamel-night.jpg', 'Thamel street at night with colorful shop lights', 'PHOTO', 1, true, NOW()),
-- Dhulikhel
((SELECT id FROM tourist_destinations WHERE slug = 'dhulikhel'), 'https://images.knownepal.com/dhulikhel-sunrise.jpg', 'Himalayan sunrise from Dhulikhel viewpoint', 'PHOTO', 1, true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'dhulikhel'), 'https://images.knownepal.com/dhulikhel-temple.jpg', 'Ancient temples of old Dhulikhel town', 'PHOTO', 2, false, NOW());


-- =============================================
-- PART C: Reviews for ~15 destinations
-- =============================================

INSERT INTO destination_reviews (destination_id, reviewer_name, rating, title, content, visit_date, is_verified, created_at) VALUES
-- Kathmandu Durbar Square
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), 'John Smith', 5, 'Incredible Heritage', 'The Durbar Square is a living museum. The architecture is breathtaking and seeing the Kumari was a truly unique experience. Every corner reveals another carved window or ancient temple.', '2024-10-15', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'kathmandu-durbar-square'), 'Maria Garcia', 4, 'Beautiful but Crowded', 'Stunning Newari architecture and rich history everywhere. The square can get quite crowded which detracts from the experience. Go early morning for the best atmosphere.', '2024-11-02', true, NOW()),
-- Swayambhunath
((SELECT id FROM tourist_destinations WHERE slug = 'swayambhunath'), 'David Chen', 5, 'Worth Every Step', 'The 365-step climb is rewarded with incredible panoramic views of Kathmandu Valley. The stupa is magnificent and the monkeys add character. Arrived at sunset and it was magical.', '2024-09-20', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'swayambhunath'), 'Sophie Laurent', 4, 'Spiritual and Scenic', 'A wonderful mix of spirituality and natural beauty. Watch out for the monkeys who are quite bold! The views from the top are among the best in Kathmandu.', '2024-12-08', true, NOW()),
-- Boudhanath
((SELECT id FROM tourist_destinations WHERE slug = 'boudhanath'), 'James Wilson', 5, 'Deeply Moving Experience', 'The atmosphere around Boudhanath is unlike anywhere else. The sound of chanting, the smell of incense, and the sight of thousands of prayer wheels creates an unforgettable spiritual experience.', '2024-10-01', true, NOW()),
-- Pashupatinath
((SELECT id FROM tourist_destinations WHERE slug = 'pashupatinath'), 'Akira Tanaka', 5, 'Sacred and Powerful', 'Pashupatinath is a place of profound spiritual significance. The evening aarti ceremony was mesmerizing. A deeply moving experience that gives insight into Hindu traditions and beliefs.', '2024-11-15', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'pashupatinath'), 'Emma Johnson', 4, 'Fascinating Cultural Site', 'A complex and emotionally challenging site. The cremation ghats are confronting but deeply respectful. The temple architecture is beautiful and the sadhus are fascinating.', '2024-08-22', true, NOW()),
-- Phewa Lake
((SELECT id FROM tourist_destinations WHERE slug = 'phewa-lake'), 'Marco Rossi', 5, 'Pokhara Paradise', 'Phewa Lake is the heart of Pokhara. Boating with the Annapurna range reflected in the water is a bucket-list moment. The Tal Barahi Temple on the island is charming.', '2024-10-10', true, NOW()),
-- Sarangkot
((SELECT id FROM tourist_destinations WHERE slug = 'sarangkot'), 'Hans Mueller', 5, 'Best Sunrise of My Life', 'Waking up at 4am was completely worth it. The sunrise over Annapurna and Machhapuchhre was the most spectacular natural display I have ever witnessed. Absolutely unmissable.', '2024-09-28', true, NOW()),
((SELECT id FROM tourist_destinations WHERE slug = 'sarangkot'), 'Lisa Park', 5, 'Perfect for Paragliding', 'Did a tandem paraglide from Sarangkot and it was the highlight of my Nepal trip. Flying above the lake with the Himalayas in the background is indescribable.', '2024-11-05', true, NOW()),
-- Lumbini
((SELECT id FROM tourist_destinations WHERE slug = 'lumbini-sacred-garden'), 'Raj Patel', 5, 'Sacred and Serene', 'Standing at the exact birthplace of Lord Buddha was profoundly moving. The Ashoka Pillar, the sacred garden, and the Maya Devi Temple are all deeply significant. A must-visit for any Buddhist or history enthusiast.', '2024-12-25', true, NOW()),
-- Bhaktapur
((SELECT id FROM tourist_destinations WHERE slug = 'bhaktapur-durbar-square'), 'Anna Kowalski', 5, 'Best Preserved Medieval City', 'Bhaktapur is by far the best-preserved medieval city in Nepal. The 55-Window Palace and Nyatapola Temple are extraordinary. The pottery square is wonderfully atmospheric. Allow a full day.', '2024-10-20', true, NOW()),
-- Chitwan
((SELECT id FROM tourist_destinations WHERE slug = 'chitwan-south'), 'Tom Anderson', 4, 'Wildlife Wonderland', 'Saw rhinos, crocodiles, and a tiger pugmark during our two-day safari. The elephant ride through the jungle was incredible. The Tharu cultural show was a wonderful bonus.', '2024-11-10', true, NOW()),
-- Muktinath
((SELECT id FROM tourist_destinations WHERE slug = 'muktinath'), 'Karma Sherpa', 5, 'Spiritual Journey Complete', 'Reaching Muktinath after days of trekking was the most rewarding experience. The 108 water spouts are incredible and the eternal flame is mesmerizing. Sacred to both Hindus and Buddhists.', '2024-10-05', true, NOW()),
-- Lo Manthang
((SELECT id FROM tourist_destinations WHERE slug = 'lo-manthang'), 'Pierre Dubois', 5, 'Time Travel to Medieval Tibet', 'Lo Manthang feels like stepping back centuries in time. The ancient monasteries with their incredible frescoes, the walled city, and the warmth of the local people made this the highlight of my three months in Asia.', '2024-09-15', true, NOW()),
-- Nagarkot
((SELECT id FROM tourist_destinations WHERE slug = 'nagarkot'), 'Yuki Sato', 4, 'Stunning Mountain Views', 'Nagarkot delivers on its promise of Himalayan views. We could see Everest on a clear morning. The resort was comfortable and the hiking trails around the area are lovely. Best visited in autumn.', '2024-11-18', true, NOW()),
-- Bandipur
((SELECT id FROM tourist_destinations WHERE slug = 'bandipur'), 'Clara Nilsson', 5, 'Hidden Gem of Nepal', 'Bandipur exceeded all expectations. The perfectly preserved Newari bazaar, the stunning mountain views, and the cave exploration made for an unforgettable stay. Far fewer tourists than Kathmandu or Pokhara.', '2024-10-25', true, NOW()),
-- World Peace Pagoda
((SELECT id FROM tourist_destinations WHERE slug = 'world-peace-pagoda-pokhara'), 'Michael Brown', 4, 'Peaceful Panorama', 'A beautiful stupa with the best panoramic view of Pokhara and the Annapurna range. The climb up is moderate and the peaceful atmosphere at the top is perfect for meditation or quiet reflection.', '2024-11-12', true, NOW());
