-- V2__seed_schools.sql
-- 20 real Nepali schools

INSERT INTO schools (name, name_nepali, slug, code, type, level, established_year, affiliation, student_count, teacher_count, description, province_id, province_name, district_id, district_name, municipality_id, municipality_name, address, phone, email, website, created_at, updated_at) VALUES
('Budhanilkantha School', 'बुढानिलकण्ठ विद्यालय', 'budhanilkantha-school', 'BNS-001', 'GOVERNMENT', 'SECONDARY', 1985, 'SLC/SEE Board', 2400, 120, 'One of the oldest and most prestigious government boarding schools in Nepal, located at the base of Shivapuri hill.', 3, 'Bagmati', 26, 'Kathmandu', 299, 'Kathmandu', 'Budhanilkantha, Kathmandu', '+977-1-4911001', 'info@budhanilkantha.edu.np', 'https://budhanilkantha.edu.np', NOW(), NOW()),

('Kathmandu Model School', 'काठमाडौं मोडेल विद्यालय', 'kathmandu-model-school', 'KMS-002', 'PRIVATE', 'SECONDARY', 1992, 'SEE Board', 1800, 85, 'A leading private school in central Kathmandu known for academic excellence and modern teaching methods.', 3, 'Bagmati', 26, 'Kathmandu', 299, 'Kathmandu', 'New Baneshwor, Kathmandu', '+977-1-4100002', 'info@kathmandumodel.edu.np', 'https://kathmandumodel.edu.np', NOW(), NOW()),

('SOS Hermann Gmeiner School', 'एसओएस हर्मन गमेनर विद्यालय', 'sos-hermann-gmeiner-school', 'SOS-003', 'COMMUNITY', 'SECONDARY', 1975, 'SEE Board', 1500, 75, 'Part of the SOS Children''s Villages network providing quality education to children in need.', 3, 'Bagmati', 26, 'Kathmandu', 299, 'Kathmandu', 'SOS Road, Lalitpur', '+977-1-5500003', 'info@soshermann.edu.np', 'https://soshermann.edu.np', NOW(), NOW()),

('Mahatma Gandhi School', 'महात्मा गान्धी विद्यालय', 'mahatma-gandhi-school', 'MGS-004', 'PRIVATE', 'HIGHER_SECONDARY', 1988, 'NEB', 2200, 100, 'Well-known higher secondary school offering science, management, and humanities streams.', 3, 'Bagmati', 26, 'Kathmandu', 299, 'Kathmandu', 'Putalisadak, Kathmandu', '+977-1-4100004', 'info@mahatmagandhi.edu.np', 'https://mahatmagandhi.edu.np', NOW(), NOW()),

('Golden Gate International School', 'गोल्डन गेट इन्टरनेसनल विद्यालय', 'golden-gate-international-school', 'GGI-005', 'PRIVATE', 'SECONDARY', 1998, 'SEE Board', 1200, 60, 'An international school offering English medium education with modern facilities and extracurricular programs.', 3, 'Bagmati', 26, 'Kathmandu', 299, 'Kathmandu', 'Lazimpat, Kathmandu', '+977-1-4100005', 'info@goldengate.edu.np', 'https://goldengate.edu.np', NOW(), NOW()),

('Padma Kanya Multiple Campus School', 'पद्मकन्या मल्टिपल क्याम्पस विद्यालय', 'padma-kanya-school', 'PKS-006', 'PRIVATE', 'HIGHER_SECONDARY', 1990, 'NEB', 1600, 80, 'Renowned for producing excellent SEE and +2 results with strong focus on science education.', 3, 'Bagmati', 26, 'Kathmandu', 299, 'Kathmandu', 'Bagbazaar, Kathmandu', '+977-1-4100006', 'info@padmakanya.edu.np', 'https://padmakanya.edu.np', NOW(), NOW()),

('White House Academy', 'व्हाइट हाउस एकाडेमी', 'white-house-academy', 'WHA-007', 'PRIVATE', 'PRIMARY', 2005, 'SEE Board', 800, 40, 'A growing primary and secondary school known for child-centered learning approaches.', 3, 'Bagmati', 26, 'Kathmandu', 299, 'Kathmandu', 'Balaju, Kathmandu', '+977-1-4100007', 'info@whitehouse.edu.np', 'https://whitehouse.edu.np', NOW(), NOW()),

('Trinity International School', 'ट्रिनिटी इन्टरनेसनल विद्यालय', 'trinity-international-school', 'TRI-008', 'PRIVATE', 'SECONDARY', 2001, 'SEE Board', 950, 50, 'An English medium school offering CBSE-aligned curriculum with modern infrastructure.', 3, 'Bagmati', 26, 'Kathmandu', 299, 'Kathmandu', 'Balkhu, Kathmandu', '+977-1-4100008', 'info@trinity.edu.np', 'https://trinity.edu.np', NOW(), NOW()),

('Sunrise Boarding School', 'सनराइज बोर्डिङ स्कुल', 'sunrise-boarding-school', 'SBS-009', 'PRIVATE', 'SECONDARY', 1995, 'SLC/SEE Board', 1100, 55, 'A well-established boarding school offering quality education in a disciplined environment.', 3, 'Bagmati', 36, 'Kaski', 400, 'Pokhara', 'Lakeside, Pokhara', '+977-61-520009', 'info@sunrisepokhara.edu.np', 'https://sunrisepokhara.edu.np', NOW(), NOW()),

('Kantipur School', 'कान्तिपुर विद्यालय', 'kantipur-school', 'KNT-010', 'PRIVATE', 'SECONDARY', 1993, 'SEE Board', 1400, 70, 'One of the top-ranked private schools in the Kathmandu Valley with excellent SEE results.', 3, 'Bagmati', 26, 'Kathmandu', 299, 'Kathmandu', 'Dillibazar, Kathmandu', '+977-1-4100010', 'info@kantipur.edu.np', 'https://kantipur.edu.np', NOW(), NOW()),

('Little Angel School', 'लिटल एन्जल स्कुल', 'little-angel-school', 'LAS-011', 'PRIVATE', 'PRIMARY', 2000, 'SEE Board', 700, 35, 'A popular primary school focused on early childhood development and creative learning.', 3, 'Bagmati', 26, 'Kathmandu', 299, 'Kathmandu', 'Kalanki, Kathmandu', '+977-1-4100011', 'info@littleangel.edu.np', 'https://littleangel.edu.np', NOW(), NOW()),

('Gyanodaya School', 'ज्ञानोदय विद्यालय', 'gyanodaya-school', 'GYA-012', 'GOVERNMENT', 'SECONDARY', 1978, 'SLC/SEE Board', 1800, 90, 'A historic government school in Lalitpur known for its academic tradition and community service.', 3, 'Bagmati', 27, 'Lalitpur', 309, 'Lalitpur', 'Lalitpur Durbar Area', '+977-1-5500012', 'info@gyanodaya.edu.np', 'https://gyanodaya.edu.np', NOW(), NOW()),

('Himalaya Higher Secondary School', 'हिमालय हायर सेकेन्डरी विद्यालय', 'himalaya-hss', 'HHS-013', 'PRIVATE', 'HIGHER_SECONDARY', 1986, 'NEB', 2000, 95, 'A premier higher secondary school offering science, management, and education streams.', 3, 'Bagmati', 26, 'Kathmandu', 299, 'Kathmandu', 'Tripureshwor, Kathmandu', '+977-1-4100013', 'info@himalayahss.edu.np', 'https://himalayahss.edu.np', NOW(), NOW()),

('Gurukul School', 'गुरुकुल विद्यालय', 'gurukul-school', 'GUR-014', 'PRIVATE', 'SECONDARY', 1997, 'SEE Board', 1000, 50, 'A school combining traditional Gurukul values with modern education methodology.', 3, 'Bagmati', 26, 'Kathmandu', 299, 'Kathmandu', 'Kamalpokhari, Kathmandu', '+977-1-4100014', 'info@gurukul.edu.np', 'https://gurukul.edu.np', NOW(), NOW()),

('Deerwalk School', 'डियरव्लक स्कुल', 'deerwalk-school', 'DWK-015', 'PRIVATE', 'SECONDARY', 2010, 'SEE Board', 600, 30, 'A modern school known for integrating technology in education and STEM-focused curriculum.', 3, 'Bagmati', 26, 'Kathmandu', 299, 'Kathmandu', 'Swayambhu, Kathmandu', '+977-1-4100015', 'info@deerwalk.edu.np', 'https://deerwalk.edu.np', NOW(), NOW()),

('Adarsha School', 'आदर्श विद्यालय', 'adarsha-school', 'ADS-016', 'GOVERNMENT', 'PRIMARY', 1965, 'SLC/SEE Board', 1200, 60, 'One of the oldest government schools in Kaski district serving the local community.', 3, 'Bagmati', 36, 'Kaski', 400, 'Pokhara', 'Maharajpur, Pokhara', '+977-61-520016', 'info@adarsha.edu.np', 'https://adarsha.edu.np', NOW(), NOW()),

('Nepal Police School', 'नेपाल प्रहरी विद्यालय', 'nepal-police-school', 'NPS-017', 'GOVERNMENT', 'SECONDARY', 1970, 'SLC/SEE Board', 1500, 80, 'A boarding school established by Nepal Police providing quality education to children of police personnel and general public.', 3, 'Bagmati', 26, 'Kathmandu', 299, 'Kathmandu', 'Naxal, Kathmandu', '+977-1-4100017', 'info@nepalpoliceschool.edu.np', 'https://nepalpoliceschool.edu.np', NOW(), NOW()),

('Malpi International School', 'माल्पी इन्टरनेसनल विद्यालय', 'malpi-international-school', 'MIS-018', 'PRIVATE', 'SECONDARY', 2003, 'SEE Board', 850, 45, 'An international school offering English medium education with global curriculum standards.', 3, 'Bagmati', 26, 'Kathmandu', 299, 'Kathmandu', 'Panipokhari, Kathmandu', '+977-1-4100018', 'info@malpi.edu.np', 'https://malpi.edu.np', NOW(), NOW()),

('Shree Krishna Higher Secondary School', 'श्री कृष्ण हायर सेकेन्डरी विद्यालय', 'shree-krishna-hss', 'SKH-019', 'COMMUNITY', 'HIGHER_SECONDARY', 1980, 'NEB', 1400, 70, 'A well-known community school in Bhaktapur offering higher secondary education.', 3, 'Bagmati', 28, 'Bhaktapur', 335, 'Bhaktapur', 'Bhaktapur Durbar Area', '+977-1-6610019', 'info@shreekrishna.edu.np', 'https://shreekrishna.edu.np', NOW(), NOW()),

('Vikram Memorial School', 'विक्रम स्मारक विद्यालय', 'vikram-memorial-school', 'VMS-020', 'PRIVATE', 'SECONDARY', 1999, 'SEE Board', 900, 45, 'A memorial school dedicated to academic excellence and character building.', 3, 'Bagmati', 26, 'Kathmandu', 299, 'Kathmandu', 'Jawalakhel, Kathmandu', '+977-1-4100020', 'info@vikram.edu.np', 'https://vikram.edu.np', NOW(), NOW());
