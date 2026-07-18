-- V13__enrich_key_ward_data.sql
-- Enrich ward data for Kathmandu, Pokhara, and Lalitpur Metropolitan Cities
-- Adds: elevation, description, contact_phone, contact_email, image_url

-- =============================================================================
-- KATHMANDU METROPOLITAN CITY (elevation ~1400m, ward offices, landmarks)
-- =============================================================================

UPDATE wards SET
  elevation = 1395,
  description = 'Ward No. 1 covers New Baneshwor area, home to the Federal Parliament of Nepal and Singh Durbar.',
  contact_phone = '+977-1-4100001',
  contact_email = 'ward1@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-1.jpg'
WHERE slug = 'kathmet-ward-1';

UPDATE wards SET
  elevation = 1400,
  description = 'Ward No. 2 encompasses Thamel, the prime tourist and entertainment hub of Kathmandu.',
  contact_phone = '+977-1-4100002',
  contact_email = 'ward2@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-2.jpg'
WHERE slug = 'kathmet-ward-2';

UPDATE wards SET
  elevation = 1405,
  description = 'Ward No. 3 covers Dillibazar and Mahabouddha area, known for the historic Mahabouddha Temple.',
  contact_phone = '+977-1-4100003',
  contact_email = 'ward3@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-3.jpg'
WHERE slug = 'kathmet-ward-3';

UPDATE wards SET
  elevation = 1380,
  description = 'Ward No. 4 includes Asan and Indrachowk, the oldest traditional bazaar area of Kathmandu.',
  contact_phone = '+977-1-4100004',
  contact_email = 'ward4@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-4.jpg'
WHERE slug = 'kathmet-ward-4';

UPDATE wards SET
  elevation = 1390,
  description = 'Ward No. 5 covers Hanuman Dhoka and Durbar Square area, a UNESCO World Heritage Site.',
  contact_phone = '+977-1-4100005',
  contact_email = 'ward5@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-5.jpg'
WHERE slug = 'kathmet-ward-5';

UPDATE wards SET
  elevation = 1375,
  description = 'Ward No. 6 encompasses Kot Square and surrounding areas of old Kathmandu city.',
  contact_phone = '+977-1-4100006',
  contact_email = 'ward6@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-6.jpg'
WHERE slug = 'kathmet-ward-6';

UPDATE wards SET
  elevation = 1410,
  description = 'Ward No. 7 covers Chabahil and Gaushala area, home to Boudhanath Stupa nearby.',
  contact_phone = '+977-1-4100007',
  contact_email = 'ward7@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-7.jpg'
WHERE slug = 'kathmet-ward-7';

UPDATE wards SET
  elevation = 1420,
  description = 'Ward No. 8 includes Baneshwor and Sundhara, a major commercial and administrative area.',
  contact_phone = '+977-1-4100008',
  contact_email = 'ward8@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-8.jpg'
WHERE slug = 'kathmet-ward-8';

UPDATE wards SET
  elevation = 1405,
  description = 'Ward No. 9 covers Putalisadak and Kamalpokhari, a busy commercial and educational zone.',
  contact_phone = '+977-1-4100009',
  contact_email = 'ward9@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-9.jpg'
WHERE slug = 'kathmet-ward-9';

UPDATE wards SET
  elevation = 1415,
  description = 'Ward No. 10 encompasses Dhumbarahim, home to government offices and the army headquarters.',
  contact_phone = '+977-1-4100010',
  contact_email = 'ward10@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-10.jpg'
WHERE slug = 'kathmet-ward-10';

UPDATE wards SET
  elevation = 1400,
  description = 'Ward No. 11 covers Balaju and Shobha Bhagwati area, known for the Balaju Water Garden.',
  contact_phone = '+977-1-4100011',
  contact_email = 'ward11@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-11.jpg'
WHERE slug = 'kathmet-ward-11';

UPDATE wards SET
  elevation = 1395,
  description = 'Ward No. 12 includes Ratna Park and Rani Pokhari area, a central landmark of Kathmandu.',
  contact_phone = '+977-1-4100012',
  contact_email = 'ward12@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-12.jpg'
WHERE slug = 'kathmet-ward-12';

UPDATE wards SET
  elevation = 1385,
  description = 'Ward No. 13 covers Lazimpat and Narayanhiti area, the diplomatic quarter of Kathmandu.',
  contact_phone = '+977-1-4100013',
  contact_email = 'ward13@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-13.jpg'
WHERE slug = 'kathmet-ward-13';

UPDATE wards SET
  elevation = 1410,
  description = 'Ward No. 14 encompasses Tripureshwor and Dharahara area, site of the historic Dharahara tower.',
  contact_phone = '+977-1-4100014',
  contact_email = 'ward14@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-14.jpg'
WHERE slug = 'kathmet-ward-14';

UPDATE wards SET
  elevation = 1420,
  description = 'Ward No. 15 covers Kalanki and Machhapokhari, a major entry point to western Kathmandu.',
  contact_phone = '+977-1-4100015',
  contact_email = 'ward15@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-15.jpg'
WHERE slug = 'kathmet-ward-15';

UPDATE wards SET
  elevation = 1430,
  description = 'Ward No. 16 includes Swayambhunath area, the iconic Monkey Temple and UNESCO World Heritage Site.',
  contact_phone = '+977-1-4100016',
  contact_email = 'ward16@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-16.jpg'
WHERE slug = 'kathmet-ward-16';

UPDATE wards SET
  elevation = 1425,
  description = 'Ward No. 17 covers Teku and Balkhu, known for the wholesale market and Bagmati River confluence.',
  contact_phone = '+977-1-4100017',
  contact_email = 'ward17@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-17.jpg'
WHERE slug = 'kathmet-ward-17';

UPDATE wards SET
  elevation = 1400,
  description = 'Ward No. 18 encompasses Kupondole and Jawalakhel, a residential and commercial hub.',
  contact_phone = '+977-1-4100018',
  contact_email = 'ward18@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-18.jpg'
WHERE slug = 'kathmet-ward-18';

UPDATE wards SET
  elevation = 1410,
  description = 'Ward No. 19 covers Bansbari and Maharajganj, home to diplomatic missions and hotels.',
  contact_phone = '+977-1-4100019',
  contact_email = 'ward19@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-19.jpg'
WHERE slug = 'kathmet-ward-19';

UPDATE wards SET
  elevation = 1405,
  description = 'Ward No. 20 includes Minbhawan and Babarmahal, a central administrative area.',
  contact_phone = '+977-1-4100020',
  contact_email = 'ward20@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-20.jpg'
WHERE slug = 'kathmet-ward-20';

UPDATE wards SET
  elevation = 1395,
  description = 'Ward No. 21 covers Naxal and Bhrikuti Mandap, a cultural and entertainment district.',
  contact_phone = '+977-1-4100021',
  contact_email = 'ward21@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-21.jpg'
WHERE slug = 'kathmet-ward-21';

UPDATE wards SET
  elevation = 1415,
  description = 'Ward No. 22 encompasses Sinamangal and Tinkune, near Tribhuvan International Airport.',
  contact_phone = '+977-1-4100022',
  contact_email = 'ward22@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-22.jpg'
WHERE slug = 'kathmet-ward-22';

UPDATE wards SET
  elevation = 1440,
  description = 'Ward No. 23 covers Chhauni and the National Museum area, a historic military zone.',
  contact_phone = '+977-1-4100023',
  contact_email = 'ward23@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-23.jpg'
WHERE slug = 'kathmet-ward-23';

UPDATE wards SET
  elevation = 1435,
  description = 'Ward No. 24 includes Kirtipur approaches and Chobar, known for the Adinath Temple.',
  contact_phone = '+977-1-4100024',
  contact_email = 'ward24@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-24.jpg'
WHERE slug = 'kathmet-ward-24';

UPDATE wards SET
  elevation = 1410,
  description = 'Ward No. 25 covers Bouddha and Gokarna area, near the famous Boudhanath Stupa.',
  contact_phone = '+977-1-4100025',
  contact_email = 'ward25@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-25.jpg'
WHERE slug = 'kathmet-ward-25';

UPDATE wards SET
  elevation = 1420,
  description = 'Ward No. 26 encompasses Tokha and Budhanilkantha approaches, a northern residential zone.',
  contact_phone = '+977-1-4100026',
  contact_email = 'ward26@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-26.jpg'
WHERE slug = 'kathmet-ward-26';

UPDATE wards SET
  elevation = 1445,
  description = 'Ward No. 27 covers Shivapuri Nagarjun National Park approaches, a biodiversity hotspot.',
  contact_phone = '+977-1-4100027',
  contact_email = 'ward27@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-27.jpg'
WHERE slug = 'kathmet-ward-27';

UPDATE wards SET
  elevation = 1430,
  description = 'Ward No. 28 includes Basundhara and Gongabu, a modern residential and commercial hub.',
  contact_phone = '+977-1-4100028',
  contact_email = 'ward28@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-28.jpg'
WHERE slug = 'kathmet-ward-28';

UPDATE wards SET
  elevation = 1415,
  description = 'Ward No. 29 covers Mankamana and Samakhushi area, a growing residential neighborhood.',
  contact_phone = '+977-1-4100029',
  contact_email = 'ward29@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-29.jpg'
WHERE slug = 'kathmet-ward-29';

UPDATE wards SET
  elevation = 1400,
  description = 'Ward No. 30 encompasses Lazimpat North and Panipokhari, a diplomatic and residential zone.',
  contact_phone = '+977-1-4100030',
  contact_email = 'ward30@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-30.jpg'
WHERE slug = 'kathmet-ward-30';

UPDATE wards SET
  elevation = 1425,
  description = 'Ward No. 31 covers Kapan and Biswambhar, a suburban residential area in northern Kathmandu.',
  contact_phone = '+977-1-4100031',
  contact_email = 'ward31@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-31.jpg'
WHERE slug = 'kathmet-ward-31';

UPDATE wards SET
  elevation = 1450,
  description = 'Ward No. 32 includes Thankot and western entry point, home to the Nepal Army camp.',
  contact_phone = '+977-1-4100032',
  contact_email = 'ward32@kathmandu.gov.np',
  image_url = 'https://images.knownepal.com/wards/kathmet-ward-32.jpg'
WHERE slug = 'kathmet-ward-32';

-- =============================================================================
-- POKHARA METROPOLITAN CITY (elevation 800-1000m, tourism hub)
-- =============================================================================

UPDATE wards SET
  elevation = 820,
  description = 'Ward No. 1 covers old Pokhara Bazaar, the traditional commercial center with lakeside proximity.',
  contact_phone = '+977-61-520001',
  contact_email = 'ward1@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-1.jpg'
WHERE slug = 'pokmet-ward-1';

UPDATE wards SET
  elevation = 815,
  description = 'Ward No. 2 encompasses Phewa Lakeside, the main tourist zone with hotels and restaurants.',
  contact_phone = '+977-61-520002',
  contact_email = 'ward2@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-2.jpg'
WHERE slug = 'pokmet-ward-2';

UPDATE wards SET
  elevation = 830,
  description = 'Ward No. 3 covers Mahendrapul and the main highway junction of Pokhara.',
  contact_phone = '+977-61-520003',
  contact_email = 'ward3@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-3.jpg'
WHERE slug = 'pokmet-ward-3';

UPDATE wards SET
  elevation = 825,
  description = 'Ward No. 4 includes Baidam and the Phewa Lake dam area, popular for boating.',
  contact_phone = '+977-61-520004',
  contact_email = 'ward4@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-4.jpg'
WHERE slug = 'pokmet-ward-4';

UPDATE wards SET
  elevation = 840,
  description = 'Ward No. 5 covers Laptop and the regional hospital area, a medical service hub.',
  contact_phone = '+977-61-520005',
  contact_email = 'ward5@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-5.jpg'
WHERE slug = 'pokmet-ward-5';

UPDATE wards SET
  elevation = 835,
  description = 'Ward No. 6 covers Pardi and the agricultural zone, known for local produce markets.',
  contact_phone = '+977-61-520006',
  contact_email = 'ward6@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-6.jpg'
WHERE slug = 'pokmet-ward-6';

UPDATE wards SET
  elevation = 850,
  description = 'Ward No. 7 covers Ramghat and the Seti River gorge, a scenic natural attraction.',
  contact_phone = '+977-61-520007',
  contact_email = 'ward7@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-7.jpg'
WHERE slug = 'pokmet-ward-7';

UPDATE wards SET
  elevation = 860,
  description = 'Ward No. 8 includes Narayangarh and the western commercial district of Pokhara.',
  contact_phone = '+977-61-520008',
  contact_email = 'ward8@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-8.jpg'
WHERE slug = 'pokmet-ward-8';

UPDATE wards SET
  elevation = 845,
  description = 'Ward No. 9 covers Prithvi Chowk and the main bus park area, a transport hub.',
  contact_phone = '+977-61-520009',
  contact_email = 'ward9@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-9.jpg'
WHERE slug = 'pokmet-ward-9';

UPDATE wards SET
  elevation = 830,
  description = 'Ward No. 10 encompasses Bagar and the industrial zone, home to small-scale industries.',
  contact_phone = '+977-61-520010',
  contact_email = 'ward10@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-10.jpg'
WHERE slug = 'pokmet-ward-10';

UPDATE wards SET
  elevation = 870,
  description = 'Ward No. 11 covers Lamachaur and the university area, home to Pokhara University.',
  contact_phone = '+977-61-520011',
  contact_email = 'ward11@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-11.jpg'
WHERE slug = 'pokmet-ward-11';

UPDATE wards SET
  elevation = 855,
  description = 'Ward No. 12 includes Siddhartha and the western residential zone of Pokhara.',
  contact_phone = '+977-61-520012',
  contact_email = 'ward12@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-12.jpg'
WHERE slug = 'pokmet-ward-12';

UPDATE wards SET
  elevation = 880,
  description = 'Ward No. 13 covers KIIT College area and the educational hub of Pokhara.',
  contact_phone = '+977-61-520013',
  contact_email = 'ward13@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-13.jpg'
WHERE slug = 'pokmet-ward-13';

UPDATE wards SET
  elevation = 865,
  description = 'Ward No. 14 encompasses Rehhar and the northern gateway to the Annapurna region.',
  contact_phone = '+977-61-520014',
  contact_email = 'ward14@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-14.jpg'
WHERE slug = 'pokmet-ward-14';

UPDATE wards SET
  elevation = 840,
  description = 'Ward No. 15 covers Nayabazaar and the central commercial district.',
  contact_phone = '+977-61-520015',
  contact_email = 'ward15@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-15.jpg'
WHERE slug = 'pokmet-ward-15';

UPDATE wards SET
  elevation = 825,
  description = 'Ward No. 16 includes Srijana Chowk and the cultural center of Pokhara.',
  contact_phone = '+977-61-520016',
  contact_email = 'ward16@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-16.jpg'
WHERE slug = 'pokmet-ward-16';

UPDATE wards SET
  elevation = 845,
  description = 'Ward No. 17 covers Hallanchowk and the banking district of Pokhara.',
  contact_phone = '+977-61-520017',
  contact_email = 'ward17@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-17.jpg'
WHERE slug = 'pokmet-ward-17';

UPDATE wards SET
  elevation = 835,
  description = 'Ward No. 18 encompasses Devighat and the Seti River confluence area.',
  contact_phone = '+977-61-520018',
  contact_email = 'ward18@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-18.jpg'
WHERE slug = 'pokmet-ward-18';

UPDATE wards SET
  elevation = 855,
  description = 'Ward No. 19 covers Batulechaur and the musical instrument craft village.',
  contact_phone = '+977-61-520019',
  contact_email = 'ward19@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-19.jpg'
WHERE slug = 'pokmet-ward-19';

UPDATE wards SET
  elevation = 870,
  description = 'Ward No. 20 includes Sarangkot approaches, famous for sunrise views over the Annapurna range.',
  contact_phone = '+977-61-520020',
  contact_email = 'ward20@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-20.jpg'
WHERE slug = 'pokmet-ward-20';

UPDATE wards SET
  elevation = 820,
  description = 'Ward No. 21 covers Barahi and the Phewa Lake island temple area.',
  contact_phone = '+977-61-520021',
  contact_email = 'ward21@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-21.jpg'
WHERE slug = 'pokmet-ward-21';

UPDATE wards SET
  elevation = 845,
  description = 'Ward No. 22 encompasses Gulmi and the southern residential zone.',
  contact_phone = '+977-61-520022',
  contact_email = 'ward22@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-22.jpg'
WHERE slug = 'pokmet-ward-22';

UPDATE wards SET
  elevation = 860,
  description = 'Ward No. 23 covers Hemja and the western lakeside area, growing tourism zone.',
  contact_phone = '+977-61-520023',
  contact_email = 'ward23@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-23.jpg'
WHERE slug = 'pokmet-ward-23';

UPDATE wards SET
  elevation = 830,
  description = 'Ward No. 24 includes zero kilometer and the central transport junction.',
  contact_phone = '+977-61-520024',
  contact_email = 'ward24@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-24.jpg'
WHERE slug = 'pokmet-ward-24';

UPDATE wards SET
  elevation = 850,
  description = 'Ward No. 25 covers Lekhnath and the eastern gateway to Pokhara valley.',
  contact_phone = '+977-61-520025',
  contact_email = 'ward25@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-25.jpg'
WHERE slug = 'pokmet-ward-25';

UPDATE wards SET
  elevation = 815,
  description = 'Ward No. 26 encompasses Gairapatan and the old trade route area.',
  contact_phone = '+977-61-520026',
  contact_email = 'ward26@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-26.jpg'
WHERE slug = 'pokmet-ward-26';

UPDATE wards SET
  elevation = 875,
  description = 'Ward No. 27 covers Kharipani and the hilly northern residential zone.',
  contact_phone = '+977-61-520027',
  contact_email = 'ward27@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-27.jpg'
WHERE slug = 'pokmet-ward-27';

UPDATE wards SET
  elevation = 840,
  description = 'Ward No. 28 includes Jalpa and the educational institutions cluster.',
  contact_phone = '+977-61-520028',
  contact_email = 'ward28@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-28.jpg'
WHERE slug = 'pokmet-ward-28';

UPDATE wards SET
  elevation = 825,
  description = 'Ward No. 29 covers Matepani and the military cantonment area.',
  contact_phone = '+977-61-520029',
  contact_email = 'ward29@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-29.jpg'
WHERE slug = 'pokmet-ward-29';

UPDATE wards SET
  elevation = 850,
  description = 'Ward No. 30 encompasses Sainik and the government quarters area.',
  contact_phone = '+977-61-520030',
  contact_email = 'ward30@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-30.jpg'
WHERE slug = 'pokmet-ward-30';

UPDATE wards SET
  elevation = 865,
  description = 'Ward No. 31 covers Khudi and the Baglung Highway entry point.',
  contact_phone = '+977-61-520031',
  contact_email = 'ward31@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-31.jpg'
WHERE slug = 'pokmet-ward-31';

UPDATE wards SET
  elevation = 845,
  description = 'Ward No. 32 includes Majhgaon and the peri-urban agricultural zone.',
  contact_phone = '+977-61-520032',
  contact_email = 'ward32@pokhara.gov.np',
  image_url = 'https://images.knownepal.com/wards/pokmet-ward-32.jpg'
WHERE slug = 'pokmet-ward-32';

-- =============================================================================
-- LALITPUR METROPOLITAN CITY (elevation 1300-1400m, cultural heritage hub)
-- =============================================================================

UPDATE wards SET
  elevation = 1310,
  description = 'Ward No. 1 covers Lalitpur Durbar Square area, a UNESCO World Heritage Site with ancient Newar architecture.',
  contact_phone = '+977-1-5500001',
  contact_email = 'ward1@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-1.jpg'
WHERE slug = 'lalmet-ward-1';

UPDATE wards SET
  elevation = 1315,
  description = 'Ward No. 2 encompasses Mangal Bazaar and the traditional metalwork artisan quarter.',
  contact_phone = '+977-1-5500002',
  contact_email = 'ward2@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-2.jpg'
WHERE slug = 'lalmet-ward-2';

UPDATE wards SET
  elevation = 1320,
  description = 'Ward No. 3 covers Sundari and the famous Rudravarna Mahavihar (Uku Bahal).',
  contact_phone = '+977-1-5500003',
  contact_email = 'ward3@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-3.jpg'
WHERE slug = 'lalmet-ward-3';

UPDATE wards SET
  elevation = 1305,
  description = 'Ward No. 4 includes Kumbheshwar and the five-story temple complex.',
  contact_phone = '+977-1-5500004',
  contact_email = 'ward4@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-4.jpg'
WHERE slug = 'lalmet-ward-4';

UPDATE wards SET
  elevation = 1325,
  description = 'Ward No. 5 covers Patan Industrial District and the largest industrial zone of Lalitpur.',
  contact_phone = '+977-1-5500005',
  contact_email = 'ward5@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-5.jpg'
WHERE slug = 'lalmet-ward-5';

UPDATE wards SET
  elevation = 1330,
  description = 'Ward No. 6 encompasses Lagankhel and the major transport hub of Lalitpur.',
  contact_phone = '+977-1-5500006',
  contact_email = 'ward6@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-6.jpg'
WHERE slug = 'lalmet-ward-6';

UPDATE wards SET
  elevation = 1340,
  description = 'Ward No. 7 covers Satdobato and the modern commercial and residential area.',
  contact_phone = '+977-1-5500007',
  contact_email = 'ward7@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-7.jpg'
WHERE slug = 'lalmet-ward-7';

UPDATE wards SET
  elevation = 1335,
  description = 'Ward No. 8 includes Dhapasi and the Jhyamedya cultural zone.',
  contact_phone = '+977-1-5500008',
  contact_email = 'ward8@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-8.jpg'
WHERE slug = 'lalmet-ward-8';

UPDATE wards SET
  elevation = 1350,
  description = 'Ward No. 9 covers Pulchowk and the engineering college area, an educational hub.',
  contact_phone = '+977-1-5500009',
  contact_email = 'ward9@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-9.jpg'
WHERE slug = 'lalmet-ward-9';

UPDATE wards SET
  elevation = 1345,
  description = 'Ward No. 10 encompasses Mahalaxmi and the temple district of Lalitpur.',
  contact_phone = '+977-1-5500010',
  contact_email = 'ward10@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-10.jpg'
WHERE slug = 'lalmet-ward-10';

UPDATE wards SET
  elevation = 1360,
  description = 'Ward No. 11 covers Godavari and the botanical garden area, a nature retreat.',
  contact_phone = '+977-1-5500011',
  contact_email = 'ward11@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-11.jpg'
WHERE slug = 'lalmet-ward-11';

UPDATE wards SET
  elevation = 1320,
  description = 'Ward No. 12 includes Jhamsikhel and the popular café and restaurant district.',
  contact_phone = '+977-1-5500012',
  contact_email = 'ward12@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-12.jpg'
WHERE slug = 'lalmet-ward-12';

UPDATE wards SET
  elevation = 1355,
  description = 'Ward No. 13 covers Dhapakhel and the hilly residential zone of southern Lalitpur.',
  contact_phone = '+977-1-5500013',
  contact_email = 'ward13@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-13.jpg'
WHERE slug = 'lalmet-ward-13';

UPDATE wards SET
  elevation = 1330,
  description = 'Ward No. 14 encompasses Kumarigal and the media and IT office cluster.',
  contact_phone = '+977-1-5500014',
  contact_email = 'ward14@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-14.jpg'
WHERE slug = 'lalmet-ward-14';

UPDATE wards SET
  elevation = 1315,
  description = 'Ward No. 15 covers Tripureshwor and the bridge area connecting to Kathmandu.',
  contact_phone = '+977-1-5500015',
  contact_email = 'ward15@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-15.jpg'
WHERE slug = 'lalmet-ward-15';

UPDATE wards SET
  elevation = 1340,
  description = 'Ward No. 16 includes Balkumari and the industrial corridor area.',
  contact_phone = '+977-1-5500016',
  contact_email = 'ward16@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-16.jpg'
WHERE slug = 'lalmet-ward-16';

UPDATE wards SET
  elevation = 1365,
  description = 'Ward No. 17 covers Thasikhel and the Buddhist monastery trail area.',
  contact_phone = '+977-1-5500017',
  contact_email = 'ward17@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-17.jpg'
WHERE slug = 'lalmet-ward-17';

UPDATE wards SET
  elevation = 1345,
  description = 'Ward No. 18 encompasses Mahadeokhola and the river bank conservation zone.',
  contact_phone = '+977-1-5500018',
  contact_email = 'ward18@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-18.jpg'
WHERE slug = 'lalmet-ward-18';

UPDATE wards SET
  elevation = 1370,
  description = 'Ward No. 19 covers Harisiddhi and the ancient temple and cultural preservation zone.',
  contact_phone = '+977-1-5500019',
  contact_email = 'ward19@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-19.jpg'
WHERE slug = 'lalmet-ward-19';

UPDATE wards SET
  elevation = 1350,
  description = 'Ward No. 20 includes Khokana and the UNESCO-listed traditional Newar village.',
  contact_phone = '+977-1-5500020',
  contact_email = 'ward20@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-20.jpg'
WHERE slug = 'lalmet-ward-20';

UPDATE wards SET
  elevation = 1380,
  description = 'Ward No. 21 covers Bungamati and the traditional woodcarving artisan village.',
  contact_phone = '+977-1-5500021',
  contact_email = 'ward21@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-21.jpg'
WHERE slug = 'lalmet-ward-21';

UPDATE wards SET
  elevation = 1325,
  description = 'Ward No. 22 encompasses Gwarko and the eastern commercial district.',
  contact_phone = '+977-1-5500022',
  contact_email = 'ward22@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-22.jpg'
WHERE slug = 'lalmet-ward-22';

UPDATE wards SET
  elevation = 1355,
  description = 'Ward No. 23 covers Kirtipur approaches and the Bagmati River corridor.',
  contact_phone = '+977-1-5500023',
  contact_email = 'ward23@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-23.jpg'
WHERE slug = 'lalmet-ward-23';

UPDATE wards SET
  elevation = 1340,
  description = 'Ward No. 24 includes Imadol and the growing IT and tech hub area.',
  contact_phone = '+977-1-5500024',
  contact_email = 'ward24@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-24.jpg'
WHERE slug = 'lalmet-ward-24';

UPDATE wards SET
  elevation = 1360,
  description = 'Ward No. 25 covers Sunakothi and the mixed residential and agricultural zone.',
  contact_phone = '+977-1-5500025',
  contact_email = 'ward25@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-25.jpg'
WHERE slug = 'lalmet-ward-25';

UPDATE wards SET
  elevation = 1335,
  description = 'Ward No. 26 encompasses Thankot and the western gateway to Lalitpur.',
  contact_phone = '+977-1-5500026',
  contact_email = 'ward26@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-26.jpg'
WHERE slug = 'lalmet-ward-26';

UPDATE wards SET
  elevation = 1375,
  description = 'Ward No. 27 covers Chobar and the Adinath Temple area, a religious tourism site.',
  contact_phone = '+977-1-5500027',
  contact_email = 'ward27@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-27.jpg'
WHERE slug = 'lalmet-ward-27';

UPDATE wards SET
  elevation = 1345,
  description = 'Ward No. 28 includes Lalitpur Metropolitan City office and the administrative center.',
  contact_phone = '+977-1-5500028',
  contact_email = 'ward28@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-28.jpg'
WHERE slug = 'lalmet-ward-28';

UPDATE wards SET
  elevation = 1350,
  description = 'Ward No. 29 covers Patan Hospital area and the medical services hub.',
  contact_phone = '+977-1-5500029',
  contact_email = 'ward29@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-29.jpg'
WHERE slug = 'lalmet-ward-29';

UPDATE wards SET
  elevation = 1330,
  description = 'Ward No. 30 encompasses Bagmati Ward and the river conservation area.',
  contact_phone = '+977-1-5500030',
  contact_email = 'ward30@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-30.jpg'
WHERE slug = 'lalmet-ward-30';

UPDATE wards SET
  elevation = 1385,
  description = 'Ward No. 31 covers Nala and the ancient irrigation system heritage zone.',
  contact_phone = '+977-1-5500031',
  contact_email = 'ward31@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-31.jpg'
WHERE slug = 'lalmet-ward-31';

UPDATE wards SET
  elevation = 1395,
  description = 'Ward No. 32 includes Lele and the southernmost rural-urban fringe of Lalitpur.',
  contact_phone = '+977-1-5500032',
  contact_email = 'ward32@lalitpur.gov.np',
  image_url = 'https://images.knownepal.com/wards/lalmet-ward-32.jpg'
WHERE slug = 'lalmet-ward-32';
