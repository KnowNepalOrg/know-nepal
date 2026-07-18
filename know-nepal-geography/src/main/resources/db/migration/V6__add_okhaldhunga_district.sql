UPDATE provinces SET number_of_districts = 14 WHERE id = 1 AND number_of_districts = 13;

INSERT INTO districts (id, name, name_nepali, code, area, population, headquarters, province_id)
VALUES (77, 'Okhaldhunga', 'ओखलढुंगा', 'OKH', 1074.00, 147987, 'Siddhicharan', 1)
ON CONFLICT (id) DO NOTHING;

INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(754, 'Okhaldhunga', 'ओखलढुंगा', 'OKH01', 'MUNICIPALITY', 178.20, 32145, 11, 77, NOW(), NOW()),
(755, 'Rumjatar', 'रुम्जाटार', 'OKH02', 'MUNICIPALITY', 123.40, 18678, 9, 77, NOW(), NOW()),
(756, 'Chisankhugadhi', 'चिसङ्खुगढी', 'OKH03', 'RURAL_MUNICIPALITY', 145.60, 12345, 8, 77, NOW(), NOW()),
(757, 'Khiji Chandeshwari', 'खिजी चण्डेश्वरी', 'OKH04', 'RURAL_MUNICIPALITY', 134.50, 9876, 7, 77, NOW(), NOW()),
(758, 'Khoplang', 'खोप्लाङ', 'OKH05', 'RURAL_MUNICIPALITY', 156.30, 11234, 8, 77, NOW(), NOW()),
(759, 'Likhu', 'लिखु', 'OKH06', 'RURAL_MUNICIPALITY', 112.80, 8765, 7, 77, NOW(), NOW()),
(760, 'Sunkoshi', 'सुनकोशी', 'OKH07', 'RURAL_MUNICIPALITY', 128.40, 10543, 7, 77, NOW(), NOW()),
(761, 'Tapli', 'तप्ली', 'OKH08', 'RURAL_MUNICIPALITY', 98.60, 7654, 6, 77, NOW(), NOW()),
(762, 'Yamkhem', 'यामखेम', 'OKH09', 'RURAL_MUNICIPALITY', 105.30, 6543, 6, 77, NOW(), NOW())
ON CONFLICT (id) DO NOTHING;
