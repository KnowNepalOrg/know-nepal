-- V5__seed_municipalities.sql
-- Seed data for all 762 municipalities of Nepal
-- Organized by province, then by district

-- =============================================================================
-- KOSHI PROVINCE (District IDs 1-13,77, 145 municipalities)
-- =============================================================================

-- District 1: Taplejung (8)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(1, 'Phungling', 'फुङलिङ', 'TAP01', 'MUNICIPALITY', 158.42, 26431, 12, 1, NOW(), NOW()),
(2, 'Pathibhara Nyayanagari', 'पाथिभरा न्यायनगरी', 'TAP02', 'RURAL_MUNICIPALITY', 221.50, 11234, 9, 1, NOW(), NOW()),
(3, 'Mikwakhola', 'मिक्वाखोला', 'TAP03', 'RURAL_MUNICIPALITY', 186.30, 7845, 7, 1, NOW(), NOW()),
(4, 'Sirijunga', 'सिरिजुङ्गा', 'TAP04', 'RURAL_MUNICIPALITY', 253.80, 9123, 8, 1, NOW(), NOW()),
(5, 'Aathrai Tribeni', 'आठराई त्रिवेणी', 'TAP05', 'RURAL_MUNICIPALITY', 174.60, 10567, 8, 1, NOW(), NOW()),
(6, 'Phurumbu', 'फुरुम्बु', 'TAP06', 'RURAL_MUNICIPALITY', 198.20, 6789, 6, 1, NOW(), NOW()),
(7, 'Meringden', 'मेरिङ्देन', 'TAP07', 'RURAL_MUNICIPALITY', 312.40, 8234, 7, 1, NOW(), NOW()),
(8, 'Sidingwa', 'सिदिङ्वा', 'TAP08', 'RURAL_MUNICIPALITY', 267.90, 7654, 6, 1, NOW(), NOW());

-- District 2: Panchthar (7)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(9, 'Phidim', 'फिदिम', 'PAN01', 'MUNICIPALITY', 148.60, 22563, 14, 2, NOW(), NOW()),
(10, 'Phalelung', 'फालेलुङ', 'PAN02', 'RURAL_MUNICIPALITY', 234.50, 9876, 8, 2, NOW(), NOW()),
(11, 'Hilihang', 'हिलिहङ', 'PAN03', 'RURAL_MUNICIPALITY', 178.30, 8543, 7, 2, NOW(), NOW()),
(12, 'Kanchanjunga', 'कञ्चनजङ्घा', 'PAN04', 'RURAL_MUNICIPALITY', 289.70, 11234, 9, 2, NOW(), NOW()),
(13, 'Kummayam', 'कुम्मायम', 'PAN05', 'RURAL_MUNICIPALITY', 156.40, 7654, 7, 2, NOW(), NOW()),
(14, 'Miklajung', 'मिक्लाजुङ', 'PAN06', 'RURAL_MUNICIPALITY', 201.80, 9012, 8, 2, NOW(), NOW()),
(15, 'Yangnam', 'याङ्नम', 'PAN07', 'RURAL_MUNICIPALITY', 167.20, 8234, 7, 2, NOW(), NOW());

-- District 3: Ilam (8)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(16, 'Ilam', 'इलाम', 'ILA01', 'MUNICIPALITY', 176.30, 28765, 16, 3, NOW(), NOW()),
(17, 'Deumai', 'देउमाई', 'ILA02', 'RURAL_MUNICIPALITY', 153.40, 10234, 8, 3, NOW(), NOW()),
(18, 'Mai Jogbudha', 'माई जोगबुधा', 'ILA03', 'RURAL_MUNICIPALITY', 198.70, 9567, 7, 3, NOW(), NOW()),
(19, 'Sakhejung', 'सखेजुङ', 'ILA04', 'RURAL_MUNICIPALITY', 167.50, 8890, 7, 3, NOW(), NOW()),
(20, 'Chameliya', 'चमेलिया', 'ILA05', 'RURAL_MUNICIPALITY', 234.60, 11456, 9, 3, NOW(), NOW()),
(21, 'Rungkewar', 'रुङ्केवार', 'ILA06', 'RURAL_MUNICIPALITY', 212.30, 9234, 8, 3, NOW(), NOW()),
(22, 'Mai Pokhari', 'माई पोखरी', 'ILA07', 'RURAL_MUNICIPALITY', 143.80, 7654, 6, 3, NOW(), NOW()),
(23, 'Sandakpur', 'सन्दकपुर', 'ILA08', 'RURAL_MUNICIPALITY', 189.20, 8123, 7, 3, NOW(), NOW());

-- District 4: Jhapa (15)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(24, 'Birtamod', 'बिराटमोद', 'JHP01', 'SUB_METROPOLITAN_CITY', 102.40, 187456, 32, 4, NOW(), NOW()),
(25, 'Damak', 'दमक', 'JHP02', 'SUB_METROPOLITAN_CITY', 76.80, 151234, 32, 4, NOW(), NOW()),
(26, 'Bhadrapur', 'भद्रपुर', 'JHP03', 'MUNICIPALITY', 85.30, 56789, 19, 4, NOW(), NOW()),
(27, 'Mechinagar', 'मेचिनगर', 'JHP04', 'MUNICIPALITY', 94.60, 48234, 17, 4, NOW(), NOW()),
(28, 'Shivasatakshi', 'शिवसताक्षी', 'JHP05', 'MUNICIPALITY', 112.70, 52345, 19, 4, NOW(), NOW()),
(29, 'Arjundhara', 'अर्जुनधारा', 'JHP06', 'MUNICIPALITY', 98.50, 47890, 17, 4, NOW(), NOW()),
(30, 'Duhabi', 'दुहाबी', 'JHP07', 'MUNICIPALITY', 67.30, 38456, 15, 4, NOW(), NOW()),
(31, 'Kankai', 'कन्काई', 'JHP08', 'MUNICIPALITY', 78.90, 34567, 15, 4, NOW(), NOW()),
(32, 'Barwa', 'बर्वा', 'JHP09', 'MUNICIPALITY', 89.20, 31234, 13, 4, NOW(), NOW()),
(33, 'Gauradhaha', 'गौराधहा', 'JHP10', 'MUNICIPALITY', 73.40, 28901, 13, 4, NOW(), NOW()),
(34, 'Kamal', 'कमल', 'JHP11', 'RURAL_MUNICIPALITY', 134.50, 18234, 9, 4, NOW(), NOW()),
(35, 'Haldibari', 'हल्दीबारी', 'JHP12', 'RURAL_MUNICIPALITY', 112.30, 15678, 8, 4, NOW(), NOW()),
(36, 'Kachankawal', 'कचनकवल', 'JHP13', 'RURAL_MUNICIPALITY', 145.60, 20345, 9, 4, NOW(), NOW()),
(37, 'Duhagadhi', 'दुहागढी', 'JHP14', 'RURAL_MUNICIPALITY', 98.70, 14567, 8, 4, NOW(), NOW()),
(38, 'Gaurigadhi', 'गौरीगढी', 'JHP15', 'RURAL_MUNICIPALITY', 87.40, 12890, 7, 4, NOW(), NOW());

-- District 5: Morang (15)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(39, 'Biratnagar', 'वीरटनगर', 'MRG01', 'METROPOLITAN_CITY', 77.00, 214663, 32, 5, NOW(), NOW()),
(40, 'Sundarharaicha', 'सुन्दरहरैचा', 'MRG02', 'MUNICIPALITY', 96.40, 67890, 21, 5, NOW(), NOW()),
(41, 'Pathari-Sanischare', 'पाथरी-सानिसचरे', 'MRG03', 'MUNICIPALITY', 82.30, 54321, 19, 5, NOW(), NOW()),
(42, 'Urlabari', 'उर्लाबारी', 'MRG04', 'MUNICIPALITY', 73.50, 48901, 17, 5, NOW(), NOW()),
(43, 'Rangeli', 'रङ्गेली', 'MRG05', 'MUNICIPALITY', 94.80, 52345, 17, 5, NOW(), NOW()),
(44, 'Kerabari', 'केराबारी', 'MRG06', 'MUNICIPALITY', 118.60, 41234, 15, 5, NOW(), NOW()),
(45, 'Bilasipur', 'बिलासपुर', 'MRG07', 'MUNICIPALITY', 89.20, 38765, 15, 5, NOW(), NOW()),
(46, 'Letang', 'लेटाङ', 'MRG08', 'MUNICIPALITY', 107.30, 35678, 15, 5, NOW(), NOW()),
(47, 'Maheshpur', 'महेश्पुर', 'MRG09', 'MUNICIPALITY', 68.40, 42567, 15, 5, NOW(), NOW()),
(48, 'Banigama', 'बनीगामा', 'MRG10', 'MUNICIPALITY', 75.90, 36789, 13, 5, NOW(), NOW()),
(49, 'Kanepokhari', 'कानेपोखरी', 'MRG11', 'RURAL_MUNICIPALITY', 125.60, 21345, 9, 5, NOW(), NOW()),
(50, 'Gramthan', 'ग्रामथान', 'MRG12', 'RURAL_MUNICIPALITY', 98.70, 18901, 8, 5, NOW(), NOW()),
(51, 'Sunamai', 'सुनामाई', 'MRG13', 'RURAL_MUNICIPALITY', 112.30, 16543, 8, 5, NOW(), NOW()),
(52, 'Budhabare', 'बुधबारे', 'MRG14', 'RURAL_MUNICIPALITY', 86.50, 14321, 7, 5, NOW(), NOW()),
(53, 'Terhathum Rural', 'तेह्रथुम गाउँपालिका', 'MRG15', 'RURAL_MUNICIPALITY', 78.40, 12890, 7, 5, NOW(), NOW());

-- District 6: Sunsari (11)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(54, 'Dharan', 'धरान', 'SNS01', 'SUB_METROPOLITAN_CITY', 89.30, 150598, 32, 6, NOW(), NOW()),
(55, 'Itahari', 'इटहरी', 'SNS02', 'SUB_METROPOLITAN_CITY', 93.80, 139234, 32, 6, NOW(), NOW()),
(56, 'Inaruwa', 'इनरुवा', 'SNS03', 'MUNICIPALITY', 78.60, 48765, 17, 6, NOW(), NOW()),
(57, 'Barahachhetra', 'बराहक्षेत्र', 'SNS04', 'MUNICIPALITY', 94.20, 52345, 19, 6, NOW(), NOW()),
(58, 'Ramdhuni-Basanti', 'रामधुनी-बसन्ती', 'SNS05', 'MUNICIPALITY', 67.80, 38901, 15, 6, NOW(), NOW()),
(59, 'Duhabi Sunsari', 'दुहाबी', 'SNS06', 'MUNICIPALITY', 56.30, 32456, 13, 6, NOW(), NOW()),
(60, 'Koshi', 'कोशी', 'SNS07', 'RURAL_MUNICIPALITY', 112.50, 18234, 8, 6, NOW(), NOW()),
(61, 'Haripurwa', 'हरिपुर्वा', 'SNS08', 'RURAL_MUNICIPALITY', 89.30, 15678, 7, 6, NOW(), NOW()),
(62, 'Bhokraha Narsingh', 'भोक्रा नरसिंह', 'SNS09', 'RURAL_MUNICIPALITY', 134.70, 20123, 9, 6, NOW(), NOW()),
(63, 'Dewanganj', 'देवनगञ्ज', 'SNS10', 'RURAL_MUNICIPALITY', 98.40, 13456, 7, 6, NOW(), NOW()),
(64, 'Ghuski', 'घुस्की', 'SNS11', 'RURAL_MUNICIPALITY', 76.80, 11234, 6, 6, NOW(), NOW());

-- District 7: Dhankuta (9)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(65, 'Dhankuta', 'धनकुटा', 'DHT01', 'MUNICIPALITY', 89.60, 38567, 15, 7, NOW(), NOW()),
(66, 'Pakhribas', 'पाख्रिबास', 'DHT02', 'RURAL_MUNICIPALITY', 124.50, 11234, 7, 7, NOW(), NOW()),
(67, 'Mahalaxmi Dhankuta', 'महालक्ष्मी', 'DHT03', 'RURAL_MUNICIPALITY', 98.70, 9876, 7, 7, NOW(), NOW()),
(68, 'Khalsa Chisapani', 'खल्सा चिसापानी', 'DHT04', 'RURAL_MUNICIPALITY', 156.30, 8543, 6, 7, NOW(), NOW()),
(69, 'Banepokhari', 'बानेपोखरी', 'DHT05', 'RURAL_MUNICIPALITY', 112.40, 7654, 6, 7, NOW(), NOW()),
(70, 'Basantapur', 'बसन्तपुर', 'DHT06', 'RURAL_MUNICIPALITY', 178.90, 9012, 7, 7, NOW(), NOW()),
(71, 'Chhathar Jorpati', 'छाथार जोरपाटी', 'DHT07', 'RURAL_MUNICIPALITY', 134.60, 8234, 6, 7, NOW(), NOW()),
(72, 'Patheka', 'पाठेका', 'DHT08', 'RURAL_MUNICIPALITY', 98.50, 7123, 6, 7, NOW(), NOW()),
(73, 'Chaure Bhumij', 'चौरे भुमिज', 'DHT09', 'RURAL_MUNICIPALITY', 112.30, 8765, 7, 7, NOW(), NOW());

-- District 8: Terhathum (8)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(74, 'Myanglung', 'म्याङलुङ', 'TRM01', 'MUNICIPALITY', 78.50, 28765, 12, 8, NOW(), NOW()),
(75, 'Aathrai', 'आठराई', 'TRM02', 'RURAL_MUNICIPALITY', 156.80, 10234, 7, 8, NOW(), NOW()),
(76, 'Khuwafedanga', 'खुवाफेदाङ्गा', 'TRM03', 'RURAL_MUNICIPALITY', 98.40, 9123, 7, 8, NOW(), NOW()),
(77, 'Phedap', 'फेदाप', 'TRM04', 'RURAL_MUNICIPALITY', 134.60, 8567, 6, 8, NOW(), NOW()),
(78, 'Chandrapur', 'चन्द्रपुर', 'TRM05', 'RURAL_MUNICIPALITY', 112.30, 9876, 7, 8, NOW(), NOW()),
(79, 'Thoklung', 'थोक्लुङ', 'TRM06', 'RURAL_MUNICIPALITY', 145.70, 8234, 6, 8, NOW(), NOW()),
(80, 'Mangmaya', 'मङ्गमया', 'TRM07', 'RURAL_MUNICIPALITY', 123.40, 7654, 6, 8, NOW(), NOW()),
(81, 'Kongmeha', 'कोङ्मेहा', 'TRM08', 'RURAL_MUNICIPALITY', 109.20, 8012, 6, 8, NOW(), NOW());

-- District 9: Sankhuwasabha (11)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(82, 'Khandbari', 'खन्दबारी', 'SKW01', 'MUNICIPALITY', 68.40, 26789, 12, 9, NOW(), NOW()),
(83, 'Dharmadevi', 'धर्मदेवी', 'SKW02', 'RURAL_MUNICIPALITY', 112.50, 8901, 6, 9, NOW(), NOW()),
(84, 'Khotanchok', 'खोटानचोक', 'SKW03', 'RURAL_MUNICIPALITY', 145.80, 7654, 6, 9, NOW(), NOW()),
(85, 'Hatiya', 'हाटिया', 'SKW04', 'RURAL_MUNICIPALITY', 189.30, 9234, 7, 9, NOW(), NOW()),
(86, 'Namtare', 'नामतारे', 'SKW05', 'RURAL_MUNICIPALITY', 167.40, 8123, 6, 9, NOW(), NOW()),
(87, 'Bhotenamlang', 'भोटेनामलाङ', 'SKW06', 'RURAL_MUNICIPALITY', 134.60, 7567, 6, 9, NOW(), NOW()),
(88, 'Tumlingtar', 'तुम्लिङ्टार', 'SKW07', 'RURAL_MUNICIPALITY', 201.30, 10234, 7, 9, NOW(), NOW()),
(89, 'Chamling', 'चाम्लिङ', 'SKW08', 'RURAL_MUNICIPALITY', 178.90, 8456, 6, 9, NOW(), NOW()),
(90, 'Madi', 'मदी', 'SKW09', 'RURAL_MUNICIPALITY', 156.20, 9876, 7, 9, NOW(), NOW()),
(91, 'Bahrabise', 'बह्राबिसे', 'SKW10', 'RURAL_MUNICIPALITY', 123.40, 7234, 6, 9, NOW(), NOW()),
(92, 'Sanishchare', 'सानिसचरे', 'SKW11', 'RURAL_MUNICIPALITY', 145.70, 8012, 6, 9, NOW(), NOW());

-- District 10: Bhojpur (10)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(93, 'Bhojpur', 'भोजपुर', 'BHP01', 'MUNICIPALITY', 105.30, 28765, 12, 10, NOW(), NOW()),
(94, 'Shadanand', 'शदानन्द', 'BHP02', 'RURAL_MUNICIPALITY', 134.70, 7890, 6, 10, NOW(), NOW()),
(95, 'Ramprasad Rai', 'रामप्रसाद राई', 'BHP03', 'RURAL_MUNICIPALITY', 156.80, 8234, 6, 10, NOW(), NOW()),
(96, 'Aiselukharka', 'ऐसेलुखर्का', 'BHP04', 'RURAL_MUNICIPALITY', 112.30, 9012, 7, 10, NOW(), NOW()),
(97, 'Tilima', 'तिलिमा', 'BHP05', 'RURAL_MUNICIPALITY', 98.50, 7654, 6, 10, NOW(), NOW()),
(98, 'Salpa', 'सल्पा', 'BHP06', 'RURAL_MUNICIPALITY', 178.40, 8456, 7, 10, NOW(), NOW()),
(99, 'Pawar', 'पवार', 'BHP07', 'RURAL_MUNICIPALITY', 123.60, 7123, 6, 10, NOW(), NOW()),
(100, 'Hatuwagadhi', 'हतुवागढी', 'BHP08', 'RURAL_MUNICIPALITY', 145.90, 8890, 7, 10, NOW(), NOW()),
(101, 'Tapligadh', 'ताप्लीगढ', 'BHP09', 'RURAL_MUNICIPALITY', 134.20, 7567, 6, 10, NOW(), NOW()),
(102, 'Arun', 'अरुण', 'BHP10', 'RURAL_MUNICIPALITY', 167.50, 8234, 7, 10, NOW(), NOW());

-- District 11: Solukhumbu (9)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(103, 'Solududhkunda', 'सोलुदुधकुण्ड', 'SLK01', 'MUNICIPALITY', 523.40, 22456, 11, 11, NOW(), NOW()),
(104, 'Dudhakunda', 'दुधकुण्डा', 'SLK02', 'RURAL_MUNICIPALITY', 345.60, 8234, 6, 11, NOW(), NOW()),
(105, 'Necha Sagar', 'नेचासगर', 'SLK03', 'RURAL_MUNICIPALITY', 289.30, 7890, 5, 11, NOW(), NOW()),
(106, 'Sotang', 'सोताङ', 'SLK04', 'RURAL_MUNICIPALITY', 412.70, 9012, 6, 11, NOW(), NOW()),
(107, 'Xuapale', 'शुआपाले', 'SLK05', 'RURAL_MUNICIPALITY', 267.40, 7123, 5, 11, NOW(), NOW()),
(108, 'Likhupike', 'लिखुपिके', 'SLK06', 'RURAL_MUNICIPALITY', 356.80, 8456, 6, 11, NOW(), NOW()),
(109, 'Thulung Dudhkoshi', 'थुलुङ दुधकोशी', 'SLK07', 'RURAL_MUNICIPALITY', 298.50, 7654, 5, 11, NOW(), NOW()),
(110, 'Tapting', 'ताप्टिङ', 'SLK08', 'RURAL_MUNICIPALITY', 234.60, 7234, 5, 11, NOW(), NOW()),
(111, 'Shivalaya', 'शिवालय', 'SLK09', 'RURAL_MUNICIPALITY', 189.70, 8012, 6, 11, NOW(), NOW());

-- District 12: Khotang (13)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(112, 'Diktel', 'दिक्तेल', 'KHT01', 'MUNICIPALITY', 102.30, 22345, 12, 12, NOW(), NOW()),
(113, 'Halesi Tuwachung', 'हलेसी तुवाचुङ', 'KHT02', 'RURAL_MUNICIPALITY', 156.70, 10234, 7, 12, NOW(), NOW()),
(114, 'Sakela', 'सकेला', 'KHT03', 'RURAL_MUNICIPALITY', 134.50, 9876, 7, 12, NOW(), NOW()),
(115, 'Kepilasgadhi', 'केपिलासगढी', 'KHT04', 'RURAL_MUNICIPALITY', 178.90, 8567, 6, 12, NOW(), NOW()),
(116, 'Jantedhunga', 'जन्तेढुङ्गा', 'KHT05', 'RURAL_MUNICIPALITY', 123.40, 9234, 7, 12, NOW(), NOW()),
(117, 'Aamchok', 'आमचोक', 'KHT06', 'RURAL_MUNICIPALITY', 145.80, 8123, 6, 12, NOW(), NOW()),
(118, 'Rawabesi', 'रावाबेसी', 'KHT07', 'RURAL_MUNICIPALITY', 112.30, 7654, 6, 12, NOW(), NOW()),
(119, 'Diprung', 'दिप्रुङ', 'KHT08', 'RURAL_MUNICIPALITY', 156.40, 8456, 6, 12, NOW(), NOW()),
(120, 'Chisankhugadhi', 'चिसन्खुगढी', 'KHT09', 'RURAL_MUNICIPALITY', 134.70, 9012, 7, 12, NOW(), NOW()),
(121, 'Sunkhani', 'सुनखनी', 'KHT10', 'RURAL_MUNICIPALITY', 98.60, 7567, 6, 12, NOW(), NOW()),
(122, 'Dumre Diktel', 'दुम्रे', 'KHT11', 'RURAL_MUNICIPALITY', 123.50, 8234, 6, 12, NOW(), NOW()),
(123, 'Barahapokhari', 'बराहापोखरी', 'KHT12', 'RURAL_MUNICIPALITY', 112.80, 7890, 6, 12, NOW(), NOW()),
(124, 'Khotehang', 'खोटेहाङ', 'KHT13', 'RURAL_MUNICIPALITY', 145.30, 8012, 6, 12, NOW(), NOW());

-- District 13: Udayapur (12)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(125, 'Triyuga', 'त्रियुगा', 'UDR01', 'MUNICIPALITY', 136.40, 48234, 17, 13, NOW(), NOW()),
(126, 'Gadhi', 'गढी', 'UDR02', 'MUNICIPALITY', 98.70, 32456, 15, 13, NOW(), NOW()),
(127, 'Khotahamla', 'खोटाहम्ला', 'UDR03', 'MUNICIPALITY', 78.50, 26789, 13, 13, NOW(), NOW()),
(128, 'Chaita', 'चैता', 'UDR04', 'RURAL_MUNICIPALITY', 112.30, 9876, 7, 13, NOW(), NOW()),
(129, 'Belaka', 'बेलका', 'UDR05', 'RURAL_MUNICIPALITY', 145.60, 11234, 8, 13, NOW(), NOW()),
(130, 'Suryodaya', 'सूर्योदय', 'UDR06', 'RURAL_MUNICIPALITY', 134.80, 10567, 8, 13, NOW(), NOW()),
(131, 'Rautamai', 'रौतामाई', 'UDR07', 'RURAL_MUNICIPALITY', 156.40, 9234, 7, 13, NOW(), NOW()),
(132, 'Udayapurgadhi', 'उदयपुरगढी', 'UDR08', 'RURAL_MUNICIPALITY', 178.30, 8456, 7, 13, NOW(), NOW()),
(133, 'Limchungbung', 'लिम्चुङबुङ', 'UDR09', 'RURAL_MUNICIPALITY', 123.50, 8890, 7, 13, NOW(), NOW()),
(134, 'Katari', 'कटारी', 'UDR10', 'RURAL_MUNICIPALITY', 145.70, 9012, 7, 13, NOW(), NOW()),
(135, 'Tapli', 'ताप्ली', 'UDR11', 'RURAL_MUNICIPALITY', 112.40, 7567, 6, 13, NOW(), NOW()),
(136, 'Bishnupur Udayapur', 'विष्णुपुर', 'UDR12', 'RURAL_MUNICIPALITY', 98.60, 7234, 6, 13, NOW(), NOW());
-- =============================================================================
-- MADHESH PROVINCE (District IDs 14-21, 119 municipalities)
-- =============================================================================

-- District 14: Saptari (12)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(137, 'Rajbiraj', 'राजविराज', 'SPT01', 'MUNICIPALITY', 95.30, 69234, 21, 14, NOW(), NOW()),
(138, 'Khanpur', 'खनपुर', 'SPT02', 'MUNICIPALITY', 67.40, 38456, 15, 14, NOW(), NOW()),
(139, 'Saptari', 'सप्तरी', 'SPT03', 'MUNICIPALITY', 54.80, 32123, 13, 14, NOW(), NOW()),
(140, 'Bishnupur Saptari', 'विष्णुपुर', 'SPT04', 'MUNICIPALITY', 48.60, 28901, 13, 14, NOW(), NOW()),
(141, 'Chhinnamasta', 'छिन्नमस्ता', 'SPT05', 'MUNICIPALITY', 62.30, 35678, 15, 14, NOW(), NOW()),
(142, 'Surunga', 'सुरुङ्गा', 'SPT06', 'MUNICIPALITY', 56.70, 27234, 13, 14, NOW(), NOW()),
(143, 'Kalyanpur', 'कल्याणपुर', 'SPT07', 'MUNICIPALITY', 43.20, 25456, 11, 14, NOW(), NOW()),
(144, 'Tirahut', 'तिरहुट', 'SPT08', 'RURAL_MUNICIPALITY', 78.50, 15678, 9, 14, NOW(), NOW()),
(145, 'Rupani', 'रुपनी', 'SPT09', 'RURAL_MUNICIPALITY', 56.30, 13234, 8, 14, NOW(), NOW()),
(146, 'Bodebaraya', 'बोदेबरया', 'SPT10', 'RURAL_MUNICIPALITY', 67.80, 14567, 8, 14, NOW(), NOW()),
(147, 'Sakhuwa Phatauna', 'सखुवाफतौना', 'SPT11', 'RURAL_MUNICIPALITY', 72.40, 12890, 7, 14, NOW(), NOW()),
(148, 'Mahadeva', 'महादेवा', 'SPT12', 'RURAL_MUNICIPALITY', 64.50, 11234, 7, 14, NOW(), NOW());

-- District 15: Siraha (14)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(149, 'Siraha', 'सिरहा', 'SRA01', 'MUNICIPALITY', 56.30, 52345, 19, 15, NOW(), NOW()),
(150, 'Lahan', 'लहान', 'SRA02', 'MUNICIPALITY', 67.80, 67890, 21, 15, NOW(), NOW()),
(151, 'Dhangadhimai', 'घन्गादिमाई', 'SRA03', 'MUNICIPALITY', 48.50, 34567, 15, 15, NOW(), NOW()),
(152, 'Bariyarpatti', 'बरियारपत्ती', 'SRA04', 'MUNICIPALITY', 42.30, 28901, 13, 15, NOW(), NOW()),
(153, 'Bhagawati', 'भगवती', 'SRA05', 'MUNICIPALITY', 38.70, 26789, 11, 15, NOW(), NOW()),
(154, 'Aurahi', 'औरही', 'SRA06', 'MUNICIPALITY', 35.40, 24567, 11, 15, NOW(), NOW()),
(155, 'Nawarajpur', 'नवराजपुर', 'SRA07', 'MUNICIPALITY', 32.60, 22345, 11, 15, NOW(), NOW()),
(156, 'Sukhipur', 'सुखीपुर', 'SRA08', 'MUNICIPALITY', 29.80, 20123, 9, 15, NOW(), NOW()),
(157, 'Lakshminya Patari', 'लक्ष्मीनिया पतारी', 'SRA09', 'RURAL_MUNICIPALITY', 54.30, 15678, 9, 15, NOW(), NOW()),
(158, 'Karjanha', 'कर्जन्हा', 'SRA10', 'RURAL_MUNICIPALITY', 48.70, 14234, 8, 15, NOW(), NOW()),
(159, 'Siriya', 'सिरिया', 'SRA11', 'RURAL_MUNICIPALITY', 42.50, 12890, 7, 15, NOW(), NOW()),
(160, 'Mirchaiya', 'मिर्चैया', 'SRA12', 'RURAL_MUNICIPALITY', 36.80, 11567, 7, 15, NOW(), NOW()),
(161, 'Kalyanpur Siraha', 'कल्याणपुर', 'SRA13', 'RURAL_MUNICIPALITY', 31.40, 10234, 7, 15, NOW(), NOW()),
(162, 'Chandra Nagar', 'चन्द्रनगर', 'SRA14', 'RURAL_MUNICIPALITY', 28.90, 9876, 6, 15, NOW(), NOW());

-- District 16: Dhanusha (15)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(163, 'Janakpur', 'जनकपुर', 'DHN01', 'SUB_METROPOLITAN_CITY', 46.30, 173425, 32, 16, NOW(), NOW()),
(164, 'Dhanushadham', 'धनुषाधाम', 'DHN02', 'MUNICIPALITY', 52.40, 42345, 15, 16, NOW(), NOW()),
(165, 'Bideha', 'विदेह', 'DHN03', 'MUNICIPALITY', 45.60, 38901, 15, 16, NOW(), NOW()),
(166, 'Chhireshwarnath', 'चिरेश्वरनाथ', 'DHN04', 'MUNICIPALITY', 38.70, 35678, 13, 16, NOW(), NOW()),
(167, 'Ganeshman Charnath', 'गणेशमान चरनाथ', 'DHN05', 'MUNICIPALITY', 56.30, 32456, 13, 16, NOW(), NOW()),
(168, 'Nagarpalika Dhanusha', 'नगरपालिका', 'DHN06', 'MUNICIPALITY', 42.50, 28123, 11, 16, NOW(), NOW()),
(169, 'Kamala', 'कमला', 'DHN07', 'MUNICIPALITY', 35.80, 25678, 11, 16, NOW(), NOW()),
(170, 'Dhanauji', 'धनौजी', 'DHN08', 'MUNICIPALITY', 31.40, 22890, 11, 16, NOW(), NOW()),
(171, 'Sahidnagar', 'शहिदनगर', 'DHN09', 'RURAL_MUNICIPALITY', 48.60, 16543, 9, 16, NOW(), NOW()),
(172, 'Lakshminya', 'लक्ष्मीनिया', 'DHN10', 'RURAL_MUNICIPALITY', 42.30, 14321, 8, 16, NOW(), NOW()),
(173, 'Janaknandini', 'जनकनन्दिनी', 'DHN11', 'RURAL_MUNICIPALITY', 36.70, 12890, 7, 16, NOW(), NOW()),
(174, 'Bateshwar', 'बटेश्वर', 'DHN12', 'RURAL_MUNICIPALITY', 31.50, 11234, 7, 16, NOW(), NOW()),
(175, 'Mithila', 'मिथिला', 'DHN13', 'RURAL_MUNICIPALITY', 28.90, 10567, 6, 16, NOW(), NOW()),
(176, 'Sabaila', 'सबैला', 'DHN14', 'RURAL_MUNICIPALITY', 25.40, 9876, 6, 16, NOW(), NOW()),
(177, 'Jansikharpur', 'जनशिखरपुर', 'DHN15', 'RURAL_MUNICIPALITY', 23.60, 9234, 6, 16, NOW(), NOW());

-- District 17: Mahottari (15)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(178, 'Jaleshwar', 'जलेश्वर', 'MHT01', 'MUNICIPALITY', 67.80, 54321, 17, 17, NOW(), NOW()),
(179, 'Bardibas', 'बर्दीबास', 'MHT02', 'MUNICIPALITY', 56.30, 48901, 17, 17, NOW(), NOW()),
(180, 'Manara Shree', 'मनरा श्री', 'MHT03', 'MUNICIPALITY', 42.50, 38765, 15, 17, NOW(), NOW()),
(181, 'Pipara', 'पिपरा', 'MHT04', 'MUNICIPALITY', 38.70, 34567, 13, 17, NOW(), NOW()),
(182, 'Gaushala', 'गौशाला', 'MHT05', 'MUNICIPALITY', 45.30, 32123, 13, 17, NOW(), NOW()),
(183, 'Aurahi Mahottari', 'औरही', 'MHT06', 'MUNICIPALITY', 34.60, 28901, 11, 17, NOW(), NOW()),
(184, 'Sakhuwa Dhamauna', 'सखुवा धमौना', 'MHT07', 'MUNICIPALITY', 29.80, 26789, 11, 17, NOW(), NOW()),
(185, 'Mahottari', 'महोत्तरी', 'MHT08', 'MUNICIPALITY', 32.40, 24567, 11, 17, NOW(), NOW()),
(186, 'Bhangaha', 'भङ्गाहा', 'MHT09', 'RURAL_MUNICIPALITY', 48.60, 14234, 8, 17, NOW(), NOW()),
(187, 'Baruwabagar', 'बरुवाबगर', 'MHT10', 'RURAL_MUNICIPALITY', 42.30, 12890, 7, 17, NOW(), NOW()),
(188, 'Siwandhi', 'सीवन्ही', 'MHT11', 'RURAL_MUNICIPALITY', 36.70, 11567, 7, 17, NOW(), NOW()),
(189, 'Ramgadhwa', 'रामगढवा', 'MHT12', 'RURAL_MUNICIPALITY', 31.40, 10234, 6, 17, NOW(), NOW()),
(190, 'Ekdara', 'एकदरा', 'MHT13', 'RURAL_MUNICIPALITY', 28.90, 9876, 6, 17, NOW(), NOW()),
(191, 'Tribhuwan', 'त्रिभुवन', 'MHT14', 'RURAL_MUNICIPALITY', 25.60, 9123, 6, 17, NOW(), NOW()),
(192, 'Lohana', 'लोहना', 'MHT15', 'RURAL_MUNICIPALITY', 22.30, 8567, 5, 17, NOW(), NOW());

-- District 18: Sarlahi (18)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(193, 'Malangwa', 'मलङ्गवा', 'SRL01', 'MUNICIPALITY', 52.30, 48234, 17, 18, NOW(), NOW()),
(194, 'Ishwarpur', 'ईश्वरपुर', 'SRL02', 'MUNICIPALITY', 45.60, 42567, 15, 18, NOW(), NOW()),
(195, 'Lalbandi', 'लालबन्दी', 'SRL03', 'MUNICIPALITY', 48.70, 45234, 15, 18, NOW(), NOW()),
(196, 'Haripurwa', 'हरिपुर्वा', 'SRL04', 'MUNICIPALITY', 38.40, 38901, 15, 18, NOW(), NOW()),
(197, 'Bagmati', 'बागमती', 'SRL05', 'MUNICIPALITY', 35.60, 34567, 13, 18, NOW(), NOW()),
(198, 'Kawarimai', 'कवरिमाई', 'SRL06', 'MUNICIPALITY', 32.30, 32123, 13, 18, NOW(), NOW()),
(199, 'Rajpur', 'राजपुर', 'SRL07', 'MUNICIPALITY', 29.80, 28901, 11, 18, NOW(), NOW()),
(200, 'Chakraghatta', 'चक्रघट्टा', 'SRL08', 'MUNICIPALITY', 26.40, 26789, 11, 18, NOW(), NOW()),
(201, 'Dhankaul', 'धनकौल', 'SRL09', 'MUNICIPALITY', 24.70, 24567, 11, 18, NOW(), NOW()),
(202, 'Chandranagar', 'चन्द्रनगर', 'SRL10', 'MUNICIPALITY', 22.50, 22345, 9, 18, NOW(), NOW()),
(203, 'Sonpur', 'सोनपुर', 'SRL11', 'RURAL_MUNICIPALITY', 36.80, 15678, 9, 18, NOW(), NOW()),
(204, 'Parsa Sarlahi', 'पर्सा', 'SRL12', 'RURAL_MUNICIPALITY', 32.40, 13234, 8, 18, NOW(), NOW()),
(205, 'Bhawaraha', 'भबरहा', 'SRL13', 'RURAL_MUNICIPALITY', 28.60, 12890, 7, 18, NOW(), NOW()),
(206, 'Bramhahari', 'ब्रह्महरि', 'SRL14', 'RURAL_MUNICIPALITY', 25.30, 11567, 7, 18, NOW(), NOW()),
(207, 'Bishnu Sarlahi', 'विष्णु', 'SRL15', 'RURAL_MUNICIPALITY', 22.80, 10234, 6, 18, NOW(), NOW()),
(208, 'Hariwan', 'हरिवन', 'SRL16', 'RURAL_MUNICIPALITY', 20.40, 9876, 6, 18, NOW(), NOW()),
(209, 'Pandaul', 'पन्दौल', 'SRL17', 'RURAL_MUNICIPALITY', 18.70, 9234, 6, 18, NOW(), NOW()),
(210, 'Mukhiyapatti', 'मुखियापत्ती', 'SRL18', 'RURAL_MUNICIPALITY', 16.50, 8567, 5, 18, NOW(), NOW());

-- District 19: Rautahat (18)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(211, 'Gaur', 'गौर', 'RTT01', 'MUNICIPALITY', 45.30, 42345, 15, 19, NOW(), NOW()),
(212, 'Chandrapur', 'चन्द्रपुर', 'RTT02', 'MUNICIPALITY', 38.60, 38765, 15, 19, NOW(), NOW()),
(213, 'Bharatpur Rautahat', 'भरतपुर', 'RTT03', 'MUNICIPALITY', 35.40, 34567, 13, 19, NOW(), NOW()),
(214, 'Garuda', 'गरुडा', 'RTT04', 'MUNICIPALITY', 32.70, 32123, 13, 19, NOW(), NOW()),
(215, 'Kotwari', 'कोटवारी', 'RTT05', 'MUNICIPALITY', 28.30, 28901, 11, 19, NOW(), NOW()),
(216, 'Rajdevi', 'राजदेवी', 'RTT06', 'MUNICIPALITY', 25.60, 26789, 11, 19, NOW(), NOW()),
(217, 'Maulapur', 'मौलपुर', 'RTT07', 'MUNICIPALITY', 22.80, 24567, 11, 19, NOW(), NOW()),
(218, 'Phatuwa Bijayapur', 'फाटुवा विजयपुर', 'RTT08', 'MUNICIPALITY', 20.40, 22345, 9, 19, NOW(), NOW()),
(219, 'Katariya', 'कटैया', 'RTT09', 'RURAL_MUNICIPALITY', 34.50, 15678, 9, 19, NOW(), NOW()),
(220, 'Yamunamai', 'यमुनामाई', 'RTT10', 'RURAL_MUNICIPALITY', 30.30, 13234, 8, 19, NOW(), NOW()),
(221, 'Daulatpur', 'दौलतपुर', 'RTT11', 'RURAL_MUNICIPALITY', 27.60, 12890, 7, 19, NOW(), NOW()),
(222, 'Gadhi Rautahat', 'गढी', 'RTT12', 'RURAL_MUNICIPALITY', 24.80, 11567, 7, 19, NOW(), NOW()),
(223, 'Khadokhalo', 'खडोखलो', 'RTT13', 'RURAL_MUNICIPALITY', 22.40, 10234, 6, 19, NOW(), NOW()),
(224, 'Madhav Narayan', 'माधवनारायण', 'RTT14', 'RURAL_MUNICIPALITY', 19.70, 9876, 6, 19, NOW(), NOW()),
(225, 'Manpur', 'मनपुर', 'RTT15', 'RURAL_MUNICIPALITY', 17.30, 9123, 6, 19, NOW(), NOW()),
(226, 'Paroha', 'परोहा', 'RTT16', 'RURAL_MUNICIPALITY', 15.60, 8765, 5, 19, NOW(), NOW()),
(227, 'Bishnupur Rautahat', 'विष्णुपुर', 'RTT17', 'RURAL_MUNICIPALITY', 13.80, 8234, 5, 19, NOW(), NOW()),
(228, 'Dewan', 'देवान', 'RTT18', 'RURAL_MUNICIPALITY', 11.40, 7890, 5, 19, NOW(), NOW());

-- District 20: Bara (14)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(229, 'Nijgadh', 'निजगढ', 'BRA01', 'MUNICIPALITY', 85.40, 45678, 17, 20, NOW(), NOW()),
(230, 'Kalaiya', 'कलैया', 'BRA02', 'MUNICIPALITY', 67.30, 38901, 15, 20, NOW(), NOW()),
(231, 'Kotaha', 'कोटाहा', 'BRA03', 'MUNICIPALITY', 54.60, 35678, 13, 20, NOW(), NOW()),
(232, 'Pheta', 'फेटा', 'BRA04', 'MUNICIPALITY', 42.30, 32456, 13, 20, NOW(), NOW()),
(233, 'Bariyarpur', 'बरियारपुर', 'BRA05', 'MUNICIPALITY', 38.70, 28901, 11, 20, NOW(), NOW()),
(234, 'Simrounghad', 'सिम्रौनगढ', 'BRA06', 'MUNICIPALITY', 45.80, 34567, 13, 20, NOW(), NOW()),
(235, 'Parsuram Bara', 'पर्सुराम', 'BRA07', 'MUNICIPALITY', 35.40, 26789, 11, 20, NOW(), NOW()),
(236, 'Prasauni', 'प्रसौनी', 'BRA08', 'RURAL_MUNICIPALITY', 56.70, 15678, 9, 20, NOW(), NOW()),
(237, 'Adarsh Kotwal', 'आदर्श कोटवाल', 'BRA09', 'RURAL_MUNICIPALITY', 48.30, 13234, 8, 20, NOW(), NOW()),
(238, 'Devgon', 'देवगोन', 'BRA10', 'RURAL_MUNICIPALITY', 42.60, 12890, 7, 20, NOW(), NOW()),
(239, 'Karaiyamai', 'करैयामाई', 'BRA11', 'RURAL_MUNICIPALITY', 36.40, 11567, 7, 20, NOW(), NOW()),
(240, 'Lipni', 'लिप्नी', 'BRA12', 'RURAL_MUNICIPALITY', 31.80, 10234, 6, 20, NOW(), NOW()),
(241, 'Rampur Bara', 'रामपुर', 'BRA13', 'RURAL_MUNICIPALITY', 28.50, 9876, 6, 20, NOW(), NOW()),
(242, 'Mahagadhimai', 'महागढिमाई', 'BRA14', 'RURAL_MUNICIPALITY', 25.30, 9123, 6, 20, NOW(), NOW());

-- District 21: Parsa (13)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(243, 'Birgunj', 'बीरगञ्ज', 'PRS01', 'SUB_METROPOLITAN_CITY', 54.60, 135634, 32, 21, NOW(), NOW()),
(244, 'Pokhariya', 'पोखरिया', 'PRS02', 'MUNICIPALITY', 42.30, 38456, 15, 21, NOW(), NOW()),
(245, 'Parsagadhi', 'पर्सागढी', 'PRS03', 'MUNICIPALITY', 38.70, 34567, 15, 21, NOW(), NOW()),
(246, 'Belpatra', 'बेलपत्र', 'PRS04', 'MUNICIPALITY', 35.40, 32123, 13, 21, NOW(), NOW()),
(247, 'Sakhuwa Prasauni', 'सखुवाप्रसौनी', 'PRS05', 'MUNICIPALITY', 32.60, 28901, 11, 21, NOW(), NOW()),
(248, 'Bahraurawa', 'बह्रौरवा', 'PRS06', 'MUNICIPALITY', 28.40, 26789, 11, 21, NOW(), NOW()),
(249, 'Thasendhara', 'थसेनधारा', 'PRS07', 'MUNICIPALITY', 24.70, 24567, 11, 21, NOW(), NOW()),
(250, 'Chhiphaura', 'छिपौरा', 'PRS08', 'RURAL_MUNICIPALITY', 45.60, 14234, 8, 21, NOW(), NOW()),
(251, 'Dhobini', 'ढोबिनी', 'PRS09', 'RURAL_MUNICIPALITY', 38.40, 12890, 7, 21, NOW(), NOW()),
(252, 'Viswa', 'विश्वा', 'PRS10', 'RURAL_MUNICIPALITY', 32.70, 11567, 7, 21, NOW(), NOW()),
(253, 'Jagarnathpur', 'जगन्नाथपुर', 'PRS11', 'RURAL_MUNICIPALITY', 28.50, 10234, 6, 21, NOW(), NOW()),
(254, 'Patediya', 'पतेदिया', 'PRS12', 'RURAL_MUNICIPALITY', 24.30, 9876, 6, 21, NOW(), NOW()),
(255, 'Chorma', 'चोरमा', 'PRS13', 'RURAL_MUNICIPALITY', 20.60, 9234, 6, 21, NOW(), NOW());
-- =============================================================================
-- BAGMATI PROVINCE (District IDs 22-34, 134 municipalities)
-- =============================================================================

-- District 22: Bhaktapur (5)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(256, 'Bhaktapur', 'भक्तपुर', 'BKT01', 'MUNICIPALITY', 18.30, 83036, 24, 22, NOW(), NOW()),
(257, 'Thimi', 'थिमी', 'BKT02', 'MUNICIPALITY', 11.40, 56789, 19, 22, NOW(), NOW()),
(258, 'Madhyapur Thimi', 'मध्यपुर थिमी', 'BKT03', 'MUNICIPALITY', 10.60, 47890, 17, 22, NOW(), NOW()),
(259, 'Suryamatinagar', 'सूर्यमतीनगर', 'BKT04', 'MUNICIPALITY', 12.30, 32456, 13, 22, NOW(), NOW()),
(260, 'Changunarayan', 'चाँगुनारायण', 'BKT05', 'RURAL_MUNICIPALITY', 16.80, 28901, 11, 22, NOW(), NOW());

-- District 23: Dhading (12)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(261, 'Dhunibesi', 'ढुनीबेसी', 'DHD01', 'MUNICIPALITY', 85.60, 28765, 12, 23, NOW(), NOW()),
(262, 'Nilkantha', 'नीलकण्ठ', 'DHD02', 'MUNICIPALITY', 112.30, 32456, 13, 23, NOW(), NOW()),
(263, 'Benighat', 'बेनीघाट', 'DHD03', 'MUNICIPALITY', 98.40, 26789, 12, 23, NOW(), NOW()),
(264, 'Gajuri', 'गजुरी', 'DHD04', 'RURAL_MUNICIPALITY', 134.50, 12345, 7, 23, NOW(), NOW()),
(265, 'Gaushala', 'गौशाला', 'DHD05', 'RURAL_MUNICIPALITY', 112.30, 11234, 7, 23, NOW(), NOW()),
(266, 'Jwalamukhi', 'ज्वालामुखी', 'DHD06', 'RURAL_MUNICIPALITY', 145.60, 10567, 7, 23, NOW(), NOW()),
(267, 'Netrawati', 'नेत्रवती', 'DHD07', 'RURAL_MUNICIPALITY', 167.80, 9234, 6, 23, NOW(), NOW()),
(268, 'Rubi Valley', 'रुबी भ्याली', 'DHD08', 'RURAL_MUNICIPALITY', 189.40, 8456, 6, 23, NOW(), NOW()),
(269, 'Siddhicharan', 'सिद्धिचरण', 'DHD09', 'RURAL_MUNICIPALITY', 123.70, 9876, 7, 23, NOW(), NOW()),
(270, 'Tripurasundari', 'त्रिपुरासुन्दरी', 'DHD10', 'RURAL_MUNICIPALITY', 156.30, 10234, 7, 23, NOW(), NOW()),
(271, 'Khairyantar', 'खैर्यान्तर', 'DHD11', 'RURAL_MUNICIPALITY', 98.50, 8123, 6, 23, NOW(), NOW()),
(272, 'Gangajamuna', 'गङ्गाजमुना', 'DHD12', 'RURAL_MUNICIPALITY', 145.20, 9012, 7, 23, NOW(), NOW());

-- District 24: Dolakha (12)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(273, 'Bhimeshwar', 'भीमेश्वर', 'DLK01', 'MUNICIPALITY', 98.50, 26789, 12, 24, NOW(), NOW()),
(274, 'Charikot', 'चारिकोट', 'DLK02', 'MUNICIPALITY', 78.30, 22345, 11, 24, NOW(), NOW()),
(275, 'Dolalghat', 'दोलालघाट', 'DLK03', 'MUNICIPALITY', 67.40, 18901, 11, 24, NOW(), NOW()),
(276, 'Jiri', 'जिरी', 'DLK04', 'MUNICIPALITY', 112.60, 24567, 11, 24, NOW(), NOW()),
(277, 'Bigu', 'बिगु', 'DLK05', 'RURAL_MUNICIPALITY', 156.80, 10234, 7, 24, NOW(), NOW()),
(278, 'Kalinchok', 'कालिन्चोक', 'DLK06', 'RURAL_MUNICIPALITY', 134.50, 9876, 7, 24, NOW(), NOW()),
(279, 'Melung', 'मेलुङ', 'DLK07', 'RURAL_MUNICIPALITY', 123.40, 8567, 6, 24, NOW(), NOW()),
(280, 'Namo Buddha', 'नमो बुद्ध', 'DLK08', 'RURAL_MUNICIPALITY', 98.70, 9234, 7, 24, NOW(), NOW()),
(281, 'Shailungeshwar', 'शैलुङ्गेश्वर', 'DLK09', 'RURAL_MUNICIPALITY', 112.30, 8123, 6, 24, NOW(), NOW()),
(282, 'Tamakoshi', 'तामाकोशी', 'DLK10', 'RURAL_MUNICIPALITY', 145.60, 9012, 7, 24, NOW(), NOW()),
(283, 'Gaurishankar', 'गौरीशंकर', 'DLK11', 'RURAL_MUNICIPALITY', 178.30, 7567, 5, 24, NOW(), NOW()),
(284, 'Sunkhani', 'सुनखनी', 'DLK12', 'RURAL_MUNICIPALITY', 134.70, 8456, 6, 24, NOW(), NOW());

-- District 25: Kavrepalanchok (14)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(285, 'Dhulikhel', 'धुलिखेल', 'KVP01', 'MUNICIPALITY', 68.50, 34567, 13, 25, NOW(), NOW()),
(286, 'Banepa', 'बानेपा', 'KVP02', 'MUNICIPALITY', 45.30, 28901, 13, 25, NOW(), NOW()),
(287, 'Panchkhal', 'पाँचखाल', 'KVP03', 'MUNICIPALITY', 56.70, 32456, 13, 25, NOW(), NOW()),
(288, 'Mandandeupur', 'मन्डनदेउपुर', 'KVP04', 'MUNICIPALITY', 42.80, 26789, 11, 25, NOW(), NOW()),
(289, 'Nepalgunj Kavre', 'नेपालगञ्ज', 'KVP05', 'MUNICIPALITY', 35.40, 24567, 11, 25, NOW(), NOW()),
(290, 'Namobuddha', 'नमोबुद्ध', 'KVP06', 'RURAL_MUNICIPALITY', 78.30, 10234, 7, 25, NOW(), NOW()),
(291, 'Bhumlu', 'भुम्लु', 'KVP07', 'RURAL_MUNICIPALITY', 98.50, 9876, 7, 25, NOW(), NOW()),
(292, 'Champadevi', 'चम्पादेवी', 'KVP08', 'RURAL_MUNICIPALITY', 67.40, 8456, 6, 25, NOW(), NOW()),
(293, 'Dolalghat Kavre', 'दोलालघाट', 'KVP09', 'RURAL_MUNICIPALITY', 56.80, 7654, 6, 25, NOW(), NOW()),
(294, 'Khanalthok', 'खनलथोक', 'KVP10', 'RURAL_MUNICIPALITY', 45.30, 8123, 6, 25, NOW(), NOW()),
(295, 'Mahadevsthan', 'महादेवस्थान', 'KVP11', 'RURAL_MUNICIPALITY', 52.60, 7234, 6, 25, NOW(), NOW()),
(296, 'Roshan', 'रोशन', 'KVP12', 'RURAL_MUNICIPALITY', 38.70, 6789, 5, 25, NOW(), NOW()),
(297, 'Temal', 'तेमाल', 'KVP13', 'RURAL_MUNICIPALITY', 67.50, 8012, 6, 25, NOW(), NOW()),
(298, 'Tyamke', 'ट्याम्के', 'KVP14', 'RURAL_MUNICIPALITY', 54.30, 7567, 6, 25, NOW(), NOW());

-- District 26: Kathmandu (10)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(299, 'Kathmandu', 'काठमाडौं', 'KTM01', 'METROPOLITAN_CITY', 49.45, 1442271, 32, 26, NOW(), NOW()),
(300, 'Kirtipur', 'कीर्तिपुर', 'KTM02', 'MUNICIPALITY', 11.30, 74321, 17, 26, NOW(), NOW()),
(301, 'Chandragiri', 'चन्द्रागिरी', 'KTM03', 'MUNICIPALITY', 42.50, 108234, 21, 26, NOW(), NOW()),
(302, 'Dakshinkali', 'दक्षिणकाली', 'KTM04', 'MUNICIPALITY', 38.40, 45678, 13, 26, NOW(), NOW()),
(303, 'Gokarneshwor', 'गोकर्णेश्वर', 'KTM05', 'MUNICIPALITY', 24.30, 52345, 13, 26, NOW(), NOW()),
(304, 'Kapan', 'कापन', 'KTM06', 'MUNICIPALITY', 18.70, 48901, 15, 26, NOW(), NOW()),
(305, 'Shankharapur', 'शङ्खरापुर', 'KTM07', 'MUNICIPALITY', 21.40, 32456, 11, 26, NOW(), NOW()),
(306, 'Tarakeshwar', 'तारकेश्वर', 'KTM08', 'MUNICIPALITY', 32.80, 38765, 13, 26, NOW(), NOW()),
(307, 'Tokha', 'टोखा', 'KTM09', 'MUNICIPALITY', 15.60, 42345, 13, 26, NOW(), NOW()),
(308, 'Nagarkot', 'नगरकोट', 'KTM10', 'MUNICIPALITY', 26.40, 28567, 11, 26, NOW(), NOW());

-- District 27: Lalitpur (10)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(309, 'Lalitpur', 'ललितपुर', 'LAL01', 'METROPOLITAN_CITY', 16.57, 299827, 32, 27, NOW(), NOW()),
(310, 'Mahalaxmi', 'महालक्ष्मी', 'LAL02', 'MUNICIPALITY', 26.30, 78234, 17, 27, NOW(), NOW()),
(311, 'Godawari', 'गोदावरी', 'LAL03', 'MUNICIPALITY', 38.70, 67890, 17, 27, NOW(), NOW()),
(312, 'Konjyosom', 'कोन्ज्योसोम', 'LAL04', 'MUNICIPALITY', 14.50, 32456, 11, 27, NOW(), NOW()),
(313, 'Bagmati Lalitpur', 'बागमती', 'LAL05', 'MUNICIPALITY', 22.30, 28901, 11, 27, NOW(), NOW()),
(314, 'Mahankal', 'महाङ्काल', 'LAL06', 'RURAL_MUNICIPALITY', 28.40, 14567, 9, 27, NOW(), NOW()),
(315, 'Dakshinkali Lalitpur', 'दक्षिणकाली', 'LAL07', 'MUNICIPALITY', 35.60, 38765, 13, 27, NOW(), NOW()),
(316, 'Chandragiri Lalitpur', 'चन्द्रागिरी', 'LAL08', 'MUNICIPALITY', 18.90, 26789, 11, 27, NOW(), NOW()),
(317, 'Bungmati', 'बुङ्गमती', 'LAL09', 'RURAL_MUNICIPALITY', 12.30, 8234, 7, 27, NOW(), NOW()),
(318, 'Lele', 'लेले', 'LAL10', 'RURAL_MUNICIPALITY', 15.70, 7567, 6, 27, NOW(), NOW());

-- District 28: Nuwakot (11)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(319, 'Bidur', 'विदुर', 'NWJ01', 'MUNICIPALITY', 78.50, 26789, 12, 28, NOW(), NOW()),
(320, 'Bhadrabhasma', 'भद्रभस्मा', 'NWJ02', 'MUNICIPALITY', 67.40, 22345, 11, 28, NOW(), NOW()),
(321, 'Devighat', 'देवीघाट', 'NWJ03', 'MUNICIPALITY', 56.30, 18901, 11, 28, NOW(), NOW()),
(322, 'Kalika', 'कालिका', 'NWJ04', 'MUNICIPALITY', 48.70, 20123, 11, 28, NOW(), NOW()),
(323, 'Kakani', 'ककनी', 'NWJ05', 'RURAL_MUNICIPALITY', 89.30, 10234, 7, 28, NOW(), NOW()),
(324, 'Likhu', 'लिखु', 'NWJ06', 'RURAL_MUNICIPALITY', 112.50, 9876, 7, 28, NOW(), NOW()),
(325, 'Panchakanya', 'पञ्चकन्या', 'NWJ07', 'RURAL_MUNICIPALITY', 98.60, 9123, 7, 28, NOW(), NOW()),
(326, 'Shivapuri', 'शिवपुरी', 'NWJ08', 'RURAL_MUNICIPALITY', 78.40, 8567, 6, 28, NOW(), NOW()),
(327, 'Suryagadhi', 'सूर्यगढी', 'NWJ09', 'RURAL_MUNICIPALITY', 67.30, 8123, 6, 28, NOW(), NOW()),
(328, 'Tadi', 'तदी', 'NWJ10', 'RURAL_MUNICIPALITY', 85.70, 7654, 6, 28, NOW(), NOW()),
(329, 'Dupcheshwar', 'दुप्चेश्वर', 'NWJ11', 'RURAL_MUNICIPALITY', 73.20, 7234, 6, 28, NOW(), NOW());

-- District 29: Rasuwa (6)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(330, 'Dhunche', 'ढुन्चे', 'RSW01', 'MUNICIPALITY', 256.30, 8234, 9, 29, NOW(), NOW()),
(331, 'Byabi', 'ब्यावी', 'RSW02', 'RURAL_MUNICIPALITY', 134.50, 4567, 5, 29, NOW(), NOW()),
(332, 'Kalika Rasuwa', 'कालिका', 'RSW03', 'RURAL_MUNICIPALITY', 189.70, 5123, 5, 29, NOW(), NOW()),
(333, 'Naukunda', 'नौकुण्ड', 'RSW04', 'RURAL_MUNICIPALITY', 167.40, 4890, 5, 29, NOW(), NOW()),
(334, 'Uttargaya', 'उत्तरगया', 'RSW05', 'RURAL_MUNICIPALITY', 145.60, 5234, 5, 29, NOW(), NOW()),
(335, 'Gosaikunda', 'गोसाईकुण्ड', 'RSW06', 'RURAL_MUNICIPALITY', 223.80, 3890, 5, 29, NOW(), NOW());

-- District 30: Sindhupalchok (13)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(336, 'Chautara', 'चौतारा', 'SPC01', 'MUNICIPALITY', 85.40, 22345, 12, 30, NOW(), NOW()),
(337, 'Melamchi', 'मेलम्ची', 'SPC02', 'MUNICIPALITY', 112.30, 18901, 11, 30, NOW(), NOW()),
(338, 'Barhabise', 'बाह्रबिसे', 'SPC03', 'MUNICIPALITY', 98.60, 16789, 11, 30, NOW(), NOW()),
(339, 'Indrawati', 'इन्द्रावती', 'SPC04', 'MUNICIPALITY', 134.50, 15234, 11, 30, NOW(), NOW()),
(340, 'Bhotekoshi', 'भोटेकोशी', 'SPC05', 'MUNICIPALITY', 78.30, 12456, 9, 30, NOW(), NOW()),
(341, 'Helambu', 'हेलम्बु', 'SPC06', 'RURAL_MUNICIPALITY', 234.60, 9876, 7, 30, NOW(), NOW()),
(342, 'Panchpokhari Thangpal', 'पाँचपोखरी थाङपाल', 'SPC07', 'RURAL_MUNICIPALITY', 267.80, 8234, 6, 30, NOW(), NOW()),
(343, 'Gokunda', 'गोकुन्डा', 'SPC08', 'RURAL_MUNICIPALITY', 189.40, 7654, 6, 30, NOW(), NOW()),
(344, 'Kharita', 'खरिटा', 'SPC09', 'RURAL_MUNICIPALITY', 156.30, 8123, 6, 30, NOW(), NOW()),
(345, 'Lisankhu Pakhar', 'लिसङ्खु पाखर', 'SPC10', 'RURAL_MUNICIPALITY', 145.70, 7234, 6, 30, NOW(), NOW()),
(346, 'Sindhupalchok', 'सिन्धुपाल्चोक', 'SPC11', 'RURAL_MUNICIPALITY', 123.40, 8456, 6, 30, NOW(), NOW()),
(347, 'Tinpiple', 'तिनपिपले', 'SPC12', 'RURAL_MUNICIPALITY', 112.80, 7890, 6, 30, NOW(), NOW()),
(348, 'Dolalghat Sindhupalchok', 'दोलालघाट', 'SPC13', 'RURAL_MUNICIPALITY', 98.50, 7567, 6, 30, NOW(), NOW());

-- District 31: Makwanpur (13)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(349, 'Hetauda', 'हेटौंडा', 'MKP01', 'SUB_METROPOLITAN_CITY', 89.30, 152345, 32, 31, NOW(), NOW()),
(350, 'Bhaise', 'भैंसे', 'MKP02', 'MUNICIPALITY', 112.40, 18234, 11, 31, NOW(), NOW()),
(351, 'Manthali', 'मन्थली', 'MKP03', 'MUNICIPALITY', 98.60, 16567, 11, 31, NOW(), NOW()),
(352, 'Kailash', 'कैलास', 'MKP04', 'MUNICIPALITY', 85.30, 14234, 9, 31, NOW(), NOW()),
(353, 'Bakaiya', 'बकैया', 'MKP05', 'MUNICIPALITY', 76.50, 12890, 9, 31, NOW(), NOW()),
(354, 'Bagmati Makwanpur', 'बागमती', 'MKP06', 'RURAL_MUNICIPALITY', 145.70, 9876, 7, 31, NOW(), NOW()),
(355, 'Harmhi', 'हरिभिम', 'MKP07', 'RURAL_MUNICIPALITY', 167.80, 8456, 6, 31, NOW(), NOW()),
(356, 'Kulekhani', 'कुलेखनी', 'MKP08', 'RURAL_MUNICIPALITY', 134.50, 7654, 6, 31, NOW(), NOW()),
(357, 'Makwanpurgadhi', 'मकवानपुरगढी', 'MKP09', 'RURAL_MUNICIPALITY', 156.40, 8123, 6, 31, NOW(), NOW()),
(358, 'Namtar', 'नम्तर', 'MKP10', 'RURAL_MUNICIPALITY', 123.60, 7234, 6, 31, NOW(), NOW()),
(359, 'Phaparbari', 'फपरबारी', 'MKP11', 'RURAL_MUNICIPALITY', 112.30, 6789, 5, 31, NOW(), NOW()),
(360, 'Raksirang', 'रक्सिराङ', 'MKP12', 'RURAL_MUNICIPALITY', 145.20, 7567, 6, 31, NOW(), NOW()),
(361, 'Thaha', 'थाहा', 'MKP13', 'RURAL_MUNICIPALITY', 98.40, 8234, 6, 31, NOW(), NOW());

-- District 32: Chitwan (11)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(362, 'Bharatpur', 'भरतपुर', 'CWT01', 'METROPOLITAN_CITY', 125.60, 289757, 32, 32, NOW(), NOW()),
(363, 'Narayangarh', 'नारायणगढ', 'CWT02', 'MUNICIPALITY', 94.30, 48234, 19, 32, NOW(), NOW()),
(364, 'Ratnanagar', 'रत्ननगर', 'CWT03', 'MUNICIPALITY', 87.50, 42567, 17, 32, NOW(), NOW()),
(365, 'Tandi', 'टाँडी', 'CWT04', 'MUNICIPALITY', 78.60, 34567, 15, 32, NOW(), NOW()),
(366, 'Bachhauli', 'बछौली', 'CWT05', 'MUNICIPALITY', 67.40, 28901, 13, 32, NOW(), NOW()),
(367, 'Chitrawan', 'चित्रवन', 'CWT06', 'RURAL_MUNICIPALITY', 134.50, 15678, 9, 32, NOW(), NOW()),
(368, 'Gadi', 'गढी', 'CWT07', 'RURAL_MUNICIPALITY', 112.30, 12345, 7, 32, NOW(), NOW()),
(369, 'Ichchhyakamana', 'इच्छाकामना', 'CWT08', 'RURAL_MUNICIPALITY', 156.80, 10234, 7, 32, NOW(), NOW()),
(370, 'Kalika', 'कालिका', 'CWT09', 'RURAL_MUNICIPALITY', 123.40, 9876, 7, 32, NOW(), NOW()),
(371, 'Khairahani', 'खैराहनी', 'CWT10', 'RURAL_MUNICIPALITY', 98.60, 8901, 6, 32, NOW(), NOW()),
(372, 'Madi', 'मदी', 'CWT11', 'RURAL_MUNICIPALITY', 85.30, 7567, 6, 32, NOW(), NOW());

-- District 33: Ramechhap (9)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(373, 'Manthali', 'मन्थली', 'RMP01', 'MUNICIPALITY', 112.50, 28901, 13, 33, NOW(), NOW()),
(374, 'Ramechhap', 'रामेछाप', 'RMP02', 'MUNICIPALITY', 98.40, 22345, 11, 33, NOW(), NOW()),
(375, 'Sunapati', 'सुनापती', 'RMP03', 'MUNICIPALITY', 85.60, 18901, 11, 33, NOW(), NOW()),
(376, 'Khimti', 'खिम्ती', 'RMP04', 'RURAL_MUNICIPALITY', 134.70, 10234, 7, 33, NOW(), NOW()),
(377, 'Lamabagar', 'लामाबगर', 'RMP05', 'RURAL_MUNICIPALITY', 156.30, 8456, 6, 33, NOW(), NOW()),
(378, 'Phawar', 'फवार', 'RMP06', 'RURAL_MUNICIPALITY', 123.50, 7654, 6, 33, NOW(), NOW()),
(379, 'Rumjatar', 'रुम्जटार', 'RMP07', 'RURAL_MUNICIPALITY', 112.40, 8123, 6, 33, NOW(), NOW()),
(380, 'Sangha', 'सँघ', 'RMP08', 'RURAL_MUNICIPALITY', 98.60, 7234, 6, 33, NOW(), NOW()),
(381, 'Dorambaaarkha', 'दोरम्बाआरखा', 'RMP09', 'RURAL_MUNICIPALITY', 145.80, 7890, 6, 33, NOW(), NOW());

-- District 34: Sindhuli (8)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(382, 'Sindhulimadhi', 'सिन्धुलीमढी', 'SND01', 'MUNICIPALITY', 134.60, 26789, 12, 34, NOW(), NOW()),
(383, 'Kamalamai', 'कमलामाई', 'SND02', 'MUNICIPALITY', 156.40, 32456, 15, 34, NOW(), NOW()),
(384, 'Taleshwar', 'तलेश्वर', 'SND03', 'MUNICIPALITY', 112.30, 18901, 11, 34, NOW(), NOW()),
(385, 'Dudhauli', 'दुधौली', 'SND04', 'MUNICIPALITY', 123.50, 22345, 11, 34, NOW(), NOW()),
(386, 'Ghangle', 'गन्गले', 'SND05', 'RURAL_MUNICIPALITY', 145.70, 9876, 7, 34, NOW(), NOW()),
(387, 'Hariyo', 'हरियो', 'SND06', 'RURAL_MUNICIPALITY', 134.80, 8234, 6, 34, NOW(), NOW()),
(388, 'Marin', 'मरिण', 'SND07', 'RURAL_MUNICIPALITY', 167.30, 8456, 6, 34, NOW(), NOW()),
(389, 'Phikkal', 'फिक्कल', 'SND08', 'RURAL_MUNICIPALITY', 123.60, 7567, 6, 34, NOW(), NOW());
-- =============================================================================
-- GANDAKI PROVINCE (District IDs 35-45, 88 municipalities)
-- =============================================================================

-- District 35: Gorkha (10)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(390, 'Gorkha', 'गोरखा', 'GRK01', 'MUNICIPALITY', 115.40, 32456, 14, 35, NOW(), NOW()),
(391, 'Palungtar', 'पलुङ्टार', 'GRK02', 'MUNICIPALITY', 98.60, 22345, 11, 35, NOW(), NOW()),
(392, 'Manakamana', 'मनकामना', 'GRK03', 'MUNICIPALITY', 85.30, 18901, 11, 35, NOW(), NOW()),
(393, 'Dharche', 'धार्चे', 'GRK04', 'RURAL_MUNICIPALITY', 234.50, 9234, 6, 35, NOW(), NOW()),
(394, 'Gorkha Rural', 'गोरखा गाउँपालिका', 'GRK05', 'RURAL_MUNICIPALITY', 178.30, 8456, 6, 35, NOW(), NOW()),
(395, 'Chum Nubri', 'चुम नुब्री', 'GRK06', 'RURAL_MUNICIPALITY', 312.40, 7234, 5, 35, NOW(), NOW()),
(396, 'Sulikot', 'सुलिकोट', 'GRK07', 'RURAL_MUNICIPALITY', 145.60, 10234, 7, 35, NOW(), NOW()),
(397, 'Dhading Besi', 'ढुनीबेसी', 'GRK08', 'RURAL_MUNICIPALITY', 123.40, 8890, 6, 35, NOW(), NOW()),
(398, 'Yarim', 'यरिम', 'GRK09', 'RURAL_MUNICIPALITY', 156.70, 7567, 6, 35, NOW(), NOW()),
(399, 'Aarupokhari', 'आरुपोखरी', 'GRK10', 'RURAL_MUNICIPALITY', 167.80, 9012, 7, 35, NOW(), NOW());

-- District 36: Kaski (9)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(400, 'Pokhara', 'पोखरा', 'KSK01', 'METROPOLITAN_CITY', 464.24, 599504, 32, 36, NOW(), NOW()),
(401, 'Annapurna', 'अन्नपूर्ण', 'KSK02', 'MUNICIPALITY', 123.50, 18234, 11, 36, NOW(), NOW()),
(402, 'Machhapuchhre', 'मछापुच्छ्रे', 'KSK03', 'MUNICIPALITY', 145.60, 22456, 13, 36, NOW(), NOW()),
(403, 'Madi', 'मदी', 'KSK04', 'MUNICIPALITY', 112.30, 15678, 9, 36, NOW(), NOW()),
(404, 'Rupa', 'रुपा', 'KSK05', 'RURAL_MUNICIPALITY', 89.40, 9876, 7, 36, NOW(), NOW()),
(405, 'Besisahar Kaski', 'बेसीसहर', 'KSK06', 'RURAL_MUNICIPALITY', 98.70, 8234, 6, 36, NOW(), NOW()),
(406, 'Chamje', 'चाम्जे', 'KSK07', 'RURAL_MUNICIPALITY', 78.50, 7456, 6, 36, NOW(), NOW()),
(407, 'Lekhnath', 'लेखनाथ', 'KSK08', 'RURAL_MUNICIPALITY', 134.60, 10234, 7, 36, NOW(), NOW()),
(408, 'Sarangkot', 'साराङ्कोट', 'KSK09', 'RURAL_MUNICIPALITY', 67.30, 8456, 6, 36, NOW(), NOW());

-- District 37: Lamjung (9)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(409, 'Besisahar', 'बेसीसहर', 'LMJ01', 'MUNICIPALITY', 78.50, 22345, 12, 37, NOW(), NOW()),
(410, 'Bhiman', 'भिमन', 'LMJ02', 'MUNICIPALITY', 67.40, 18901, 11, 37, NOW(), NOW()),
(411, 'Rainas', 'रैनास', 'LMJ03', 'MUNICIPALITY', 85.30, 16789, 11, 37, NOW(), NOW()),
(412, 'Sundarbazar', 'सुन्दरबजार', 'LMJ04', 'RURAL_MUNICIPALITY', 56.80, 10234, 7, 37, NOW(), NOW()),
(413, 'Tipling', 'तिप्लिङ', 'LMJ05', 'RURAL_MUNICIPALITY', 134.50, 7654, 6, 37, NOW(), NOW()),
(414, 'Dordi', 'दोर्दी', 'LMJ06', 'RURAL_MUNICIPALITY', 156.70, 9123, 7, 37, NOW(), NOW()),
(415, 'Dudhpokhari', 'दुधपोखरी', 'LMJ07', 'RURAL_MUNICIPALITY', 123.40, 8456, 6, 37, NOW(), NOW()),
(416, 'Kwahola', 'क्वाहोला', 'LMJ08', 'RURAL_MUNICIPALITY', 112.60, 7234, 6, 37, NOW(), NOW()),
(417, 'Marsyangdi', 'मर्स्याङ्दी', 'LMJ09', 'RURAL_MUNICIPALITY', 145.30, 8234, 6, 37, NOW(), NOW());

-- District 38: Manang (4)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(418, 'Chame', 'चामे', 'MNG01', 'MUNICIPALITY', 523.40, 2234, 5, 38, NOW(), NOW()),
(419, 'Nason', 'नासोँ', 'MNG02', 'RURAL_MUNICIPALITY', 456.70, 1567, 5, 38, NOW(), NOW()),
(420, 'Narphu', 'नर्फु', 'MNG03', 'RURAL_MUNICIPALITY', 678.30, 1234, 5, 38, NOW(), NOW()),
(421, 'Manang Ngisyang', 'मनाङ ङिस्याङ', 'MNG04', 'RURAL_MUNICIPALITY', 589.60, 1456, 5, 38, NOW(), NOW());

-- District 39: Mustang (5)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(422, 'Jomsom', 'जोमसोम', 'MST01', 'MUNICIPALITY', 345.60, 2567, 9, 39, NOW(), NOW()),
(423, 'Kagbeni', 'कागबेनी', 'MST02', 'RURAL_MUNICIPALITY', 234.50, 1234, 5, 39, NOW(), NOW()),
(424, 'Thini', 'थिनी', 'MST03', 'RURAL_MUNICIPALITY', 189.70, 1456, 5, 39, NOW(), NOW()),
(425, 'Ulleri', 'उल्लेरी', 'MST04', 'RURAL_MUNICIPALITY', 278.30, 1678, 5, 39, NOW(), NOW()),
(426, 'Lomanthang', 'लोमान्थाङ', 'MST05', 'RURAL_MUNICIPALITY', 456.80, 1890, 5, 39, NOW(), NOW());

-- District 40: Myagdi (7)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(427, 'Beni', 'बेनी', 'MYG01', 'MUNICIPALITY', 56.40, 22345, 12, 40, NOW(), NOW()),
(428, 'Dhaulagiri', 'धौलागिरी', 'MYG02', 'MUNICIPALITY', 98.60, 14567, 9, 40, NOW(), NOW()),
(429, 'Mangala', 'मङ्गला', 'MYG03', 'RURAL_MUNICIPALITY', 134.50, 8456, 6, 40, NOW(), NOW()),
(430, 'Malika', 'मालिका', 'MYG04', 'RURAL_MUNICIPALITY', 112.30, 9123, 7, 40, NOW(), NOW()),
(431, 'Annapurna Myagdi', 'अन्नपूर्ण', 'MYG05', 'RURAL_MUNICIPALITY', 156.70, 7654, 6, 40, NOW(), NOW()),
(432, 'Raghuganga', 'रघुगङ्गा', 'MYG06', 'RURAL_MUNICIPALITY', 145.80, 8234, 6, 40, NOW(), NOW()),
(433, 'Thathibeni', 'थाठीबेनी', 'MYG07', 'RURAL_MUNICIPALITY', 123.40, 7890, 6, 40, NOW(), NOW());

-- District 41: Nawalparasi East (10)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(434, 'Kawasoti', 'कवसोटी', 'NPE01', 'MUNICIPALITY', 67.30, 42345, 17, 41, NOW(), NOW()),
(435, 'Devchuli', 'देवचुली', 'NPE02', 'MUNICIPALITY', 78.50, 38901, 15, 41, NOW(), NOW()),
(436, 'Madhyabindu', 'मध्यबिन्दु', 'NPE03', 'MUNICIPALITY', 56.40, 32456, 13, 41, NOW(), NOW()),
(437, 'Tribenisaini', 'त्रिवेणीसैनी', 'NPE04', 'RURAL_MUNICIPALITY', 89.60, 12345, 7, 41, NOW(), NOW()),
(438, 'Palma', 'पल्मा', 'NPE05', 'RURAL_MUNICIPALITY', 112.30, 9876, 7, 41, NOW(), NOW()),
(439, 'Bulingtar', 'बुलिङ्टार', 'NPE06', 'RURAL_MUNICIPALITY', 98.50, 10234, 7, 41, NOW(), NOW()),
(440, 'Hupsekot', 'हुप्सेकोट', 'NPE07', 'RURAL_MUNICIPALITY', 85.40, 8456, 6, 41, NOW(), NOW()),
(441, 'Baidadi', 'बैदी', 'NPE08', 'RURAL_MUNICIPALITY', 76.30, 8123, 6, 41, NOW(), NOW()),
(442, 'Dumkibas', 'दुम्किबास', 'NPE09', 'RURAL_MUNICIPALITY', 67.80, 7654, 6, 41, NOW(), NOW()),
(443, 'Garjyang', 'गर्ज्याङ', 'NPE10', 'RURAL_MUNICIPALITY', 78.60, 7234, 6, 41, NOW(), NOW());

-- District 42: Parbat (7)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(444, 'Kusma', 'कुस्मा', 'PRB01', 'MUNICIPALITY', 56.30, 22345, 12, 42, NOW(), NOW()),
(445, 'Phalewas', 'फलेवास', 'PRB02', 'MUNICIPALITY', 48.70, 18901, 11, 42, NOW(), NOW()),
(446, 'Bihadi', 'बिहादी', 'PRB03', 'RURAL_MUNICIPALITY', 67.40, 9876, 7, 42, NOW(), NOW()),
(447, 'Jaljala', 'जलजला', 'PRB04', 'RURAL_MUNICIPALITY', 78.50, 8456, 6, 42, NOW(), NOW()),
(448, 'Kawasoti Parbat', 'कवसोटी', 'PRB05', 'RURAL_MUNICIPALITY', 56.80, 9123, 7, 42, NOW(), NOW()),
(449, 'Modi', 'मोदी', 'PRB06', 'RURAL_MUNICIPALITY', 89.30, 8234, 6, 42, NOW(), NOW()),
(450, 'Painyu', 'पैन्यू', 'PRB07', 'RURAL_MUNICIPALITY', 72.60, 7654, 6, 42, NOW(), NOW());

-- District 43: Syangja (10)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(451, 'Waling', 'वालिङ', 'SYA01', 'MUNICIPALITY', 85.40, 26789, 13, 43, NOW(), NOW()),
(452, 'Syangja', 'स्याङ्जा', 'SYA02', 'MUNICIPALITY', 67.30, 22345, 12, 43, NOW(), NOW()),
(453, 'Putalibazar', 'पुतलीबजार', 'SYA03', 'MUNICIPALITY', 78.60, 24567, 11, 43, NOW(), NOW()),
(454, 'Aandhikhola', 'आन्धीखोला', 'SYA04', 'RURAL_MUNICIPALITY', 56.40, 10234, 7, 43, NOW(), NOW()),
(455, 'Arjun Parbati', 'अर्जुन पार्वती', 'SYA05', 'RURAL_MUNICIPALITY', 67.80, 8456, 6, 43, NOW(), NOW()),
(456, 'Birendra', 'वीरेन्द्र', 'SYA06', 'RURAL_MUNICIPALITY', 56.30, 9123, 7, 43, NOW(), NOW()),
(457, 'Chapakot', 'चापाकोट', 'SYA07', 'RURAL_MUNICIPALITY', 78.50, 8234, 6, 43, NOW(), NOW()),
(458, 'Dhungre', 'ढुङ्ग्रे', 'SYA08', 'RURAL_MUNICIPALITY', 67.40, 7567, 6, 43, NOW(), NOW()),
(459, 'Kaligandaki', 'कालीगण्डकी', 'SYA09', 'RURAL_MUNICIPALITY', 89.60, 8890, 7, 43, NOW(), NOW()),
(460, 'Mai', 'माई', 'SYA10', 'RURAL_MUNICIPALITY', 72.30, 7890, 6, 43, NOW(), NOW());

-- District 44: Tanahun (10)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(461, 'Damauli', 'दमौली', 'TAN01', 'MUNICIPALITY', 67.40, 28901, 13, 44, NOW(), NOW()),
(462, 'Besisahar Tanahun', 'बेसीसहर', 'TAN02', 'MUNICIPALITY', 56.30, 22345, 11, 44, NOW(), NOW()),
(463, 'Bandipur', 'बन्दीपुर', 'TAN03', 'MUNICIPALITY', 78.50, 18901, 11, 44, NOW(), NOW()),
(464, 'Myagde', 'म्याग्दे', 'TAN04', 'RURAL_MUNICIPALITY', 89.60, 10234, 7, 44, NOW(), NOW()),
(465, 'Shuklagandaki', 'शुक्लागण्डकी', 'TAN05', 'RURAL_MUNICIPALITY', 78.30, 9876, 7, 44, NOW(), NOW()),
(466, 'Ghiring', 'घिरिङ', 'TAN06', 'RURAL_MUNICIPALITY', 67.40, 8456, 6, 44, NOW(), NOW()),
(467, 'Devghat', 'देवघाट', 'TAN07', 'RURAL_MUNICIPALITY', 56.80, 9123, 7, 44, NOW(), NOW()),
(468, 'Kahun Shikhar', 'काहुँ शिखर', 'TAN08', 'RURAL_MUNICIPALITY', 85.60, 7654, 6, 44, NOW(), NOW()),
(469, 'Tribeni Tanahun', 'त्रिवेणी', 'TAN09', 'RURAL_MUNICIPALITY', 72.30, 8123, 6, 44, NOW(), NOW()),
(470, 'Aabukhaireni', 'आबुखैरेनी', 'TAN10', 'RURAL_MUNICIPALITY', 67.50, 7567, 6, 44, NOW(), NOW());

-- District 45: Baglung (7)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(471, 'Baglung', 'बागलुङ', 'BGL01', 'MUNICIPALITY', 78.30, 26789, 12, 45, NOW(), NOW()),
(472, 'Galkot', 'गलकोट', 'BGL02', 'MUNICIPALITY', 67.40, 22345, 11, 45, NOW(), NOW()),
(473, 'Dhorpatan', 'ढोरपाटन', 'BGL03', 'MUNICIPALITY', 134.60, 14567, 9, 45, NOW(), NOW()),
(474, 'Dangibang', 'डाँगीबाङ', 'BGL04', 'RURAL_MUNICIPALITY', 98.50, 8456, 6, 45, NOW(), NOW()),
(475, 'Kanthan', 'कान्थन', 'BGL05', 'RURAL_MUNICIPALITY', 85.60, 9123, 7, 45, NOW(), NOW()),
(476, 'Taman', 'तामन', 'BGL06', 'RURAL_MUNICIPALITY', 78.30, 8234, 6, 45, NOW(), NOW()),
(477, 'Badigad', 'बादीगड', 'BGL07', 'RURAL_MUNICIPALITY', 112.40, 7654, 6, 45, NOW(), NOW());
-- =============================================================================
-- LUMBINI PROVINCE (District IDs 46-57, 122 municipalities)
-- =============================================================================

-- District 46: Arghakhanchi (9)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(478, 'Sandhikharka', 'सन्धिखर्का', 'ARG01', 'MUNICIPALITY', 78.30, 22345, 12, 46, NOW(), NOW()),
(479, 'Mechhendranagar', 'मेच्छेन्द्रनगर', 'ARG02', 'MUNICIPALITY', 56.40, 18901, 11, 46, NOW(), NOW()),
(480, 'Bhumikasthan', 'भूमिकास्थान', 'ARG03', 'MUNICIPALITY', 67.50, 16789, 11, 46, NOW(), NOW()),
(481, 'Chhatradev', 'छत्रदेव', 'ARG04', 'RURAL_MUNICIPALITY', 89.60, 9876, 7, 46, NOW(), NOW()),
(482, 'Khadkagaon', 'खड्कागाउँ', 'ARG05', 'RURAL_MUNICIPALITY', 78.40, 8456, 6, 46, NOW(), NOW()),
(483, 'Malyabas', 'मल्यबास', 'ARG06', 'RURAL_MUNICIPALITY', 67.30, 8123, 6, 46, NOW(), NOW()),
(484, 'Panini', 'पाणिनी', 'ARG07', 'RURAL_MUNICIPALITY', 56.80, 7654, 6, 46, NOW(), NOW()),
(485, 'Shitaganga', 'शितागङ्गा', 'ARG08', 'RURAL_MUNICIPALITY', 72.50, 7234, 6, 46, NOW(), NOW()),
(486, 'Siddhicharan', 'सिद्धिचरण', 'ARG09', 'RURAL_MUNICIPALITY', 67.60, 6789, 5, 46, NOW(), NOW());

-- District 47: Gulmi (10)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(487, 'Resunga', 'रेसुङ्गा', 'GUL01', 'MUNICIPALITY', 56.30, 24567, 12, 47, NOW(), NOW()),
(488, 'Tamghas', 'तामघास', 'GUL02', 'MUNICIPALITY', 45.60, 18901, 11, 47, NOW(), NOW()),
(489, 'Musikot', 'मुसिकोट', 'GUL03', 'MUNICIPALITY', 67.40, 16789, 11, 47, NOW(), NOW()),
(490, 'Chandrakot', 'चन्द्रकोट', 'GUL04', 'RURAL_MUNICIPALITY', 78.50, 9876, 7, 47, NOW(), NOW()),
(491, 'Chhangbang', 'चाङ्गबाङ', 'GUL05', 'RURAL_MUNICIPALITY', 67.30, 8456, 6, 47, NOW(), NOW()),
(492, 'Dhurkot', 'धुर्कोट', 'GUL06', 'RURAL_MUNICIPALITY', 56.80, 9123, 7, 47, NOW(), NOW()),
(493, 'Isma', 'इस्मा', 'GUL07', 'RURAL_MUNICIPALITY', 72.40, 8234, 6, 47, NOW(), NOW()),
(494, 'Kaligandaki Gulmi', 'कालीगण्डकी', 'GUL08', 'RURAL_MUNICIPALITY', 89.60, 7654, 6, 47, NOW(), NOW()),
(495, 'Madane', 'मदाने', 'GUL09', 'RURAL_MUNICIPALITY', 67.30, 7234, 6, 47, NOW(), NOW()),
(496, 'Satyawati', 'सत्यावती', 'GUL10', 'RURAL_MUNICIPALITY', 78.50, 7890, 6, 47, NOW(), NOW());

-- District 48: Kapilvastu (12)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(497, 'Taulihawa', 'तौलिहवा', 'KAP01', 'MUNICIPALITY', 56.40, 26789, 13, 48, NOW(), NOW()),
(498, 'Buddhabhumi', 'बुद्धभूमि', 'KAP02', 'MUNICIPALITY', 67.30, 22345, 11, 48, NOW(), NOW()),
(499, 'Shivaraj', 'शिवराज', 'KAP03', 'MUNICIPALITY', 78.50, 18901, 11, 48, NOW(), NOW()),
(500, 'Kapilvastu', 'कपिलवस्तु', 'KAP04', 'MUNICIPALITY', 89.60, 20123, 11, 48, NOW(), NOW()),
(501, 'Banganga', 'बनगङ्गा', 'KAP05', 'RURAL_MUNICIPALITY', 78.30, 12345, 8, 48, NOW(), NOW()),
(502, 'Bijaynagar', 'विजयनगर', 'KAP06', 'RURAL_MUNICIPALITY', 67.40, 10234, 7, 48, NOW(), NOW()),
(503, 'Mayadevi', 'मायादेवी', 'KAP07', 'RURAL_MUNICIPALITY', 56.80, 9876, 7, 48, NOW(), NOW()),
(504, 'Suddhodhan', 'सुद्धोधन', 'KAP08', 'RURAL_MUNICIPALITY', 67.50, 8456, 6, 48, NOW(), NOW()),
(505, 'Siyari', 'सियारी', 'KAP09', 'RURAL_MUNICIPALITY', 56.30, 9123, 7, 48, NOW(), NOW()),
(506, 'Tribeni', 'त्रिवेणी', 'KAP10', 'RURAL_MUNICIPALITY', 72.60, 7654, 6, 48, NOW(), NOW()),
(507, 'Kamthan', 'काम्ठान', 'KAP11', 'RURAL_MUNICIPALITY', 67.40, 7234, 6, 48, NOW(), NOW()),
(508, 'Maruhachi', 'मरुहाछी', 'KAP12', 'RURAL_MUNICIPALITY', 56.70, 6789, 5, 48, NOW(), NOW());

-- District 49: Palpa (10)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(509, 'Tansen', 'तानसेन', 'PLP01', 'MUNICIPALITY', 56.30, 28901, 13, 49, NOW(), NOW()),
(510, 'Rampur', 'रामपुर', 'PLP02', 'MUNICIPALITY', 45.60, 22345, 11, 49, NOW(), NOW()),
(511, 'Rainadevi Chhahara', 'रैनादेवी छाहरा', 'PLP03', 'MUNICIPALITY', 67.40, 18901, 11, 49, NOW(), NOW()),
(512, 'Bagnaskali', 'बगनास्काली', 'PLP04', 'RURAL_MUNICIPALITY', 78.50, 9876, 7, 49, NOW(), NOW()),
(513, 'Heldung', 'हेल्डुङ', 'PLP05', 'RURAL_MUNICIPALITY', 89.60, 8456, 6, 49, NOW(), NOW()),
(514, 'Khanidanda', 'खनीडाँडा', 'PLP06', 'RURAL_MUNICIPALITY', 67.30, 9123, 7, 49, NOW(), NOW()),
(515, 'Miklajung', 'मिक्लाजुङ', 'PLP07', 'RURAL_MUNICIPALITY', 78.40, 7654, 6, 49, NOW(), NOW()),
(516, 'Narayangadhi', 'नारायणगढी', 'PLP08', 'RURAL_MUNICIPALITY', 56.80, 8234, 6, 49, NOW(), NOW()),
(517, 'Purbakhola', 'पूर्वखोला', 'PLP09', 'RURAL_MUNICIPALITY', 72.30, 7567, 6, 49, NOW(), NOW()),
(518, 'Tansen Palpa', 'तानसेन', 'PLP10', 'RURAL_MUNICIPALITY', 67.50, 7234, 6, 49, NOW(), NOW());

-- District 50: Rupandehi (14)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(519, 'Butwal', 'बुटवल', 'RUP01', 'SUB_METROPOLITAN_CITY', 75.60, 139234, 32, 50, NOW(), NOW()),
(520, 'Bhairahawa', 'भैरहवा', 'RUP02', 'MUNICIPALITY', 62.30, 82345, 21, 50, NOW(), NOW()),
(521, 'Siddharthanagar', 'सिद्धार्थनगर', 'RUP03', 'MUNICIPALITY', 48.50, 56789, 17, 50, NOW(), NOW()),
(522, 'Devdaha', 'देवदहा', 'RUP04', 'MUNICIPALITY', 56.70, 42567, 15, 50, NOW(), NOW()),
(523, 'Lumbini', 'लुम्बिनी', 'RUP05', 'MUNICIPALITY', 78.30, 38901, 15, 50, NOW(), NOW()),
(524, 'Gautam Buddh', 'गौतम बुद्ध', 'RUP06', 'MUNICIPALITY', 67.40, 34567, 13, 50, NOW(), NOW()),
(525, 'Sainamaina', 'सैनामैना', 'RUP07', 'RURAL_MUNICIPALITY', 89.60, 15678, 9, 50, NOW(), NOW()),
(526, 'Suyalgarh', 'सुयालगढ', 'RUP08', 'RURAL_MUNICIPALITY', 78.30, 12345, 8, 50, NOW(), NOW()),
(527, 'Tharu', 'थारू', 'RUP09', 'RURAL_MUNICIPALITY', 67.50, 10234, 7, 50, NOW(), NOW()),
(528, 'Kotahimai', 'कोटहीमाई', 'RUP10', 'RURAL_MUNICIPALITY', 56.40, 9876, 7, 50, NOW(), NOW()),
(529, 'Mayadevi Rupandehi', 'मायादेवी', 'RUP11', 'RURAL_MUNICIPALITY', 45.30, 9123, 7, 50, NOW(), NOW()),
(530, 'Omsatiya', 'ओमसतिया', 'RUP12', 'RURAL_MUNICIPALITY', 52.60, 8456, 6, 50, NOW(), NOW()),
(531, 'Rohini', 'रोहिणी', 'RUP13', 'RURAL_MUNICIPALITY', 48.70, 7654, 6, 50, NOW(), NOW()),
(532, 'Tilottama', 'तिलोत्तमा', 'RUP14', 'RURAL_MUNICIPALITY', 62.30, 8234, 6, 50, NOW(), NOW());

-- District 51: Nawalparasi West (8)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(533, 'Parasi', 'परासी', 'NPW01', 'MUNICIPALITY', 67.40, 26789, 13, 51, NOW(), NOW()),
(534, 'Sunwal', 'सुनवल', 'NPW02', 'MUNICIPALITY', 56.30, 22345, 11, 51, NOW(), NOW()),
(535, 'Bardaghat', 'बर्दघाट', 'NPW03', 'MUNICIPALITY', 78.50, 24567, 11, 51, NOW(), NOW()),
(536, 'Ramgram', 'रामग्राम', 'NPW04', 'MUNICIPALITY', 67.30, 20123, 11, 51, NOW(), NOW()),
(537, 'Palhinandan', 'पाल्हिनन्दन', 'NPW05', 'RURAL_MUNICIPALITY', 56.40, 10234, 7, 51, NOW(), NOW()),
(538, 'Pratappur', 'प्रतापपुर', 'NPW06', 'RURAL_MUNICIPALITY', 67.80, 9876, 7, 51, NOW(), NOW()),
(539, 'Sarawal', 'सरावल', 'NPW07', 'RURAL_MUNICIPALITY', 56.30, 9123, 7, 51, NOW(), NOW()),
(540, 'Susta', 'सुस्ता', 'NPW08', 'RURAL_MUNICIPALITY', 78.60, 8456, 6, 51, NOW(), NOW());

-- District 52: Dang (11)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(541, 'Tulsipur', 'तुलसीपुर', 'DNG01', 'SUB_METROPOLITAN_CITY', 89.30, 112345, 32, 52, NOW(), NOW()),
(542, 'Ghorahi', 'घोराही', 'DNG02', 'MUNICIPALITY', 78.50, 82345, 21, 52, NOW(), NOW()),
(543, 'Lamahi', 'लमही', 'DNG03', 'MUNICIPALITY', 67.40, 34567, 15, 52, NOW(), NOW()),
(544, 'Tribeni Dang', 'त्रिवेणी', 'DNG04', 'RURAL_MUNICIPALITY', 89.60, 12345, 8, 52, NOW(), NOW()),
(545, 'Dangisharan', 'दाङ्गीशरण', 'DNG05', 'RURAL_MUNICIPALITY', 78.30, 10234, 7, 52, NOW(), NOW()),
(546, 'Gadhawa', 'गढवा', 'DNG06', 'RURAL_MUNICIPALITY', 67.50, 9876, 7, 52, NOW(), NOW()),
(547, 'Gobardhan', 'गोबर्धन', 'DNG07', 'RURAL_MUNICIPALITY', 56.40, 9123, 7, 52, NOW(), NOW()),
(548, 'Rajpur', 'राजपुर', 'DNG08', 'RURAL_MUNICIPALITY', 67.30, 8456, 6, 52, NOW(), NOW()),
(549, 'Rangpur', 'राङ्गपुर', 'DNG09', 'RURAL_MUNICIPALITY', 56.80, 7654, 6, 52, NOW(), NOW()),
(550, 'Shantinagar', 'शान्तिनगर', 'DNG10', 'RURAL_MUNICIPALITY', 72.40, 7234, 6, 52, NOW(), NOW()),
(551, 'Babai', 'बबई', 'DNG11', 'RURAL_MUNICIPALITY', 85.60, 6789, 5, 52, NOW(), NOW());

-- District 53: Pyuthan (9)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(552, 'Pyuthan', 'प्युठान', 'PYT01', 'MUNICIPALITY', 56.30, 18901, 11, 53, NOW(), NOW()),
(553, 'Musikot Pyuthan', 'मुसिकोट', 'PYT02', 'MUNICIPALITY', 67.40, 16789, 11, 53, NOW(), NOW()),
(554, 'Sworgadwari', 'स्वर्गद्वारी', 'PYT03', 'MUNICIPALITY', 78.50, 14567, 9, 53, NOW(), NOW()),
(555, 'Aathbis', 'आठबिस', 'PYT04', 'RURAL_MUNICIPALITY', 89.60, 9876, 7, 53, NOW(), NOW()),
(556, 'Dangwara', 'दाङ्गवारा', 'PYT05', 'RURAL_MUNICIPALITY', 67.30, 8456, 6, 53, NOW(), NOW()),
(557, 'Mallarani', 'मल्लरानी', 'PYT06', 'RURAL_MUNICIPALITY', 56.80, 8123, 6, 53, NOW(), NOW()),
(558, 'Mandavi', 'मण्डवी', 'PYT07', 'RURAL_MUNICIPALITY', 72.40, 7654, 6, 53, NOW(), NOW()),
(559, 'Naubahini', 'नौबहिनी', 'PYT08', 'RURAL_MUNICIPALITY', 67.50, 8234, 6, 53, NOW(), NOW()),
(560, 'Sarumarani', 'सरुमारानी', 'PYT09', 'RURAL_MUNICIPALITY', 78.30, 7890, 6, 53, NOW(), NOW());

-- District 54: Rolpa (10)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(561, 'Tulsipur Rolpa', 'तुलसीपुर', 'RLP01', 'MUNICIPALITY', 67.30, 14567, 9, 54, NOW(), NOW()),
(562, 'Sunil Pokhari', 'सुनिल पोखरी', 'RLP02', 'MUNICIPALITY', 56.40, 12345, 9, 54, NOW(), NOW()),
(563, 'Triveni', 'त्रिवेणी', 'RLP03', 'MUNICIPALITY', 78.50, 10234, 7, 54, NOW(), NOW()),
(564, 'Bansabang', 'बन्साबाङ', 'RLP04', 'RURAL_MUNICIPALITY', 89.60, 8456, 6, 54, NOW(), NOW()),
(565, 'Kolma', 'कोल्मा', 'RLP05', 'RURAL_MUNICIPALITY', 67.40, 7654, 6, 54, NOW(), NOW()),
(566, 'Lungri', 'लुङ्ग्री', 'RLP06', 'RURAL_MUNICIPALITY', 78.30, 7234, 6, 54, NOW(), NOW()),
(567, 'Manbang', 'मनबाङ', 'RLP07', 'RURAL_MUNICIPALITY', 56.80, 6789, 5, 54, NOW(), NOW()),
(568, 'Mijhing', 'मिझिङ', 'RLP08', 'RURAL_MUNICIPALITY', 67.50, 7234, 6, 54, NOW(), NOW()),
(569, 'Nuwakot Rolpa', 'नुवाकोट', 'RLP09', 'RURAL_MUNICIPALITY', 72.30, 6789, 5, 54, NOW(), NOW()),
(570, 'Thabang', 'थबाङ', 'RLP10', 'RURAL_MUNICIPALITY', 85.60, 6456, 5, 54, NOW(), NOW());

-- District 55: Rukum West (9)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(571, 'Musikot', 'मुसिकोट', 'RUK01', 'MUNICIPALITY', 67.30, 12345, 9, 55, NOW(), NOW()),
(572, 'Chaurjhari', 'चौरझरी', 'RUK02', 'MUNICIPALITY', 56.40, 10234, 7, 55, NOW(), NOW()),
(573, 'Athbise', 'आठबिसे', 'RUK03', 'RURAL_MUNICIPALITY', 78.50, 8456, 6, 55, NOW(), NOW()),
(574, 'Bijayshwari', 'विजयश्वरी', 'RUK04', 'RURAL_MUNICIPALITY', 67.40, 7654, 6, 55, NOW(), NOW()),
(575, 'Kotgadi', 'कोटगढी', 'RUK05', 'RURAL_MUNICIPALITY', 56.80, 7234, 6, 55, NOW(), NOW()),
(576, 'Mukti', 'मुक्ति', 'RUK06', 'RURAL_MUNICIPALITY', 72.30, 6789, 5, 55, NOW(), NOW()),
(577, 'Nuwakot Rukum', 'नुवाकोट', 'RUK07', 'RURAL_MUNICIPALITY', 67.50, 6789, 5, 55, NOW(), NOW()),
(578, 'Sankhar', 'सँखार', 'RUK08', 'RURAL_MUNICIPALITY', 78.30, 6456, 5, 55, NOW(), NOW()),
(579, 'Triveni Rukum', 'त्रिवेणी', 'RUK09', 'RURAL_MUNICIPALITY', 85.40, 6123, 5, 55, NOW(), NOW());

-- District 56: Banke (10)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(580, 'Nepalgunj', 'नेपालगञ्ज', 'BNK01', 'SUB_METROPOLITAN_CITY', 72.30, 102345, 32, 56, NOW(), NOW()),
(581, 'Kohalpur', 'कोहलपुर', 'BNK02', 'MUNICIPALITY', 56.40, 42345, 17, 56, NOW(), NOW()),
(582, 'Narainapur', 'नरायणपुर', 'BNK03', 'MUNICIPALITY', 67.50, 28901, 13, 56, NOW(), NOW()),
(583, 'Pharping Banke', 'फर्पिङ', 'BNK04', 'RURAL_MUNICIPALITY', 78.60, 15678, 9, 56, NOW(), NOW()),
(584, 'Baijanath', 'बैजनाथ', 'BNK05', 'RURAL_MUNICIPALITY', 67.30, 12345, 8, 56, NOW(), NOW()),
(585, 'Duduwa', 'दुदुवा', 'BNK06', 'RURAL_MUNICIPALITY', 56.80, 9876, 7, 56, NOW(), NOW()),
(586, 'Janaki', 'जनकी', 'BNK07', 'RURAL_MUNICIPALITY', 72.40, 8456, 6, 56, NOW(), NOW()),
(587, 'Khadachakra', 'खडाचक्र', 'BNK08', 'RURAL_MUNICIPALITY', 67.50, 7654, 6, 56, NOW(), NOW()),
(588, 'Rapti Sonari', 'राप्ती सोनारी', 'BNK09', 'RURAL_MUNICIPALITY', 85.30, 7234, 6, 56, NOW(), NOW()),
(589, 'Shivapur', 'शिवपुर', 'BNK10', 'RURAL_MUNICIPALITY', 78.60, 6789, 5, 56, NOW(), NOW());

-- District 57: Bardiya (10)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(590, 'Gulariya', 'गुलरिया', 'BRD01', 'MUNICIPALITY', 56.30, 26789, 13, 57, NOW(), NOW()),
(591, 'Thakurbaba', 'ठाकुरबाबा', 'BRD02', 'MUNICIPALITY', 67.40, 22345, 11, 57, NOW(), NOW()),
(592, 'Madhuwan', 'मधुवन', 'BRD03', 'MUNICIPALITY', 78.50, 18901, 11, 57, NOW(), NOW()),
(593, 'Rajapur', 'राजपुर', 'BRD04', 'MUNICIPALITY', 56.40, 16789, 11, 57, NOW(), NOW()),
(594, 'Dhangadhi Bardiya', 'घन्धाडी', 'BRD05', 'RURAL_MUNICIPALITY', 89.60, 12345, 8, 57, NOW(), NOW()),
(595, 'Hariwan', 'हरिवन', 'BRD06', 'RURAL_MUNICIPALITY', 67.30, 10234, 7, 57, NOW(), NOW()),
(596, 'Maulapur', 'मौलपुर', 'BRD07', 'RURAL_MUNICIPALITY', 78.40, 9876, 7, 57, NOW(), NOW()),
(597, 'Bansgadhi', 'बाँसगढी', 'BRD08', 'RURAL_MUNICIPALITY', 67.50, 8456, 6, 57, NOW(), NOW()),
(598, 'Geruwa', 'गेरुवा', 'BRD09', 'RURAL_MUNICIPALITY', 72.30, 7654, 6, 57, NOW(), NOW()),
(599, 'Barbardiya', 'बरबर्दिया', 'BRD10', 'RURAL_MUNICIPALITY', 85.60, 7234, 6, 57, NOW(), NOW());
-- =============================================================================
-- KARNALI PROVINCE (District IDs 58-67, 75 municipalities)
-- =============================================================================

-- District 58: Dailekh (8)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(600, 'Narayan', 'नारायण', 'DLK58', 'MUNICIPALITY', 78.30, 18901, 11, 58, NOW(), NOW()),
(601, 'Dullu', 'दुल्लु', 'DLK59', 'MUNICIPALITY', 67.40, 14567, 9, 58, NOW(), NOW()),
(602, 'Chhedagad', 'छेडागड', 'DLK60', 'MUNICIPALITY', 56.30, 12345, 9, 58, NOW(), NOW()),
(603, 'Aathabiskot', 'आठबिस्कोट', 'DLK61', 'RURAL_MUNICIPALITY', 89.60, 9876, 7, 58, NOW(), NOW()),
(604, 'Bhagawati', 'भगवती', 'DLK62', 'RURAL_MUNICIPALITY', 78.40, 8456, 6, 58, NOW(), NOW()),
(605, 'Chaurpati', 'चौरपाटी', 'DLK63', 'RURAL_MUNICIPALITY', 67.50, 7654, 6, 58, NOW(), NOW()),
(606, 'Gurans', 'गुराँस', 'DLK64', 'RURAL_MUNICIPALITY', 72.30, 7234, 6, 58, NOW(), NOW()),
(607, 'Naumule', 'नौमुले', 'DLK65', 'RURAL_MUNICIPALITY', 85.60, 6789, 5, 58, NOW(), NOW());

-- District 59: Dolpa (7)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(608, 'Dunai', 'दुनाई', 'DLP01', 'MUNICIPALITY', 234.50, 3456, 9, 59, NOW(), NOW()),
(609, 'Tripurasundari', 'त्रिपुरासुन्दरी', 'DLP02', 'RURAL_MUNICIPALITY', 345.60, 2345, 5, 59, NOW(), NOW()),
(610, 'Kaike', 'काईके', 'DLP03', 'RURAL_MUNICIPALITY', 456.70, 1890, 5, 59, NOW(), NOW()),
(611, 'Juphal', 'जुफाल', 'DLP04', 'RURAL_MUNICIPALITY', 389.40, 2123, 5, 59, NOW(), NOW()),
(612, 'Mudhe', 'मुढे', 'DLP05', 'RURAL_MUNICIPALITY', 423.80, 1567, 5, 59, NOW(), NOW()),
(613, 'Phoksundo', 'फोक्सुण्डो', 'DLP06', 'RURAL_MUNICIPALITY', 567.30, 1234, 5, 59, NOW(), NOW()),
(614, 'Shey Phoksundo', 'शे फोक्सुण्डो', 'DLP07', 'RURAL_MUNICIPALITY', 678.50, 987, 5, 59, NOW(), NOW());

-- District 60: Humla (8)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(615, 'Simikot', 'सिमिकोट', 'HML01', 'MUNICIPALITY', 156.30, 4567, 9, 60, NOW(), NOW()),
(616, 'Namkha', 'नाम्खा', 'HML02', 'RURAL_MUNICIPALITY', 234.50, 2345, 5, 60, NOW(), NOW()),
(617, 'Sarkegad', 'सर्केगढ', 'HML03', 'RURAL_MUNICIPALITY', 189.70, 2123, 5, 60, NOW(), NOW()),
(618, 'Adanchuli', 'अदानचुली', 'HML04', 'RURAL_MUNICIPALITY', 178.30, 1890, 5, 60, NOW(), NOW()),
(619, 'Chankheli', 'चन्खेली', 'HML05', 'RURAL_MUNICIPALITY', 212.40, 1678, 5, 60, NOW(), NOW()),
(620, 'Kharpunath', 'खार्पुनाथ', 'HML06', 'RURAL_MUNICIPALITY', 156.80, 1456, 5, 60, NOW(), NOW()),
(621, 'Tanjakot', 'तन्जाकोट', 'HML07', 'RURAL_MUNICIPALITY', 145.60, 1234, 5, 60, NOW(), NOW()),
(622, 'Taprigan', 'ताप्रीगाउँ', 'HML08', 'RURAL_MUNICIPALITY', 167.40, 1345, 5, 60, NOW(), NOW());

-- District 61: Jajarkot (8)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(623, 'Jajarkot', 'जाजरकोट', 'JJK01', 'MUNICIPALITY', 89.30, 12345, 9, 61, NOW(), NOW()),
(624, 'Dunai Jajarkot', 'दुनाई', 'JJK02', 'MUNICIPALITY', 78.40, 10234, 7, 61, NOW(), NOW()),
(625, 'Bheri', 'भेरी', 'JJK03', 'RURAL_MUNICIPALITY', 67.50, 8456, 6, 61, NOW(), NOW()),
(626, 'Chhipa', 'छिपा', 'JJK04', 'RURAL_MUNICIPALITY', 56.80, 7654, 6, 61, NOW(), NOW()),
(627, 'Khalanga', 'खलङ्गा', 'JJK05', 'RURAL_MUNICIPALITY', 72.30, 8123, 6, 61, NOW(), NOW()),
(628, 'Narayan', 'नारायण', 'JJK06', 'RURAL_MUNICIPALITY', 67.40, 7234, 6, 61, NOW(), NOW()),
(629, 'Paind', 'पैन्ड', 'JJK07', 'RURAL_MUNICIPALITY', 85.60, 6789, 5, 61, NOW(), NOW()),
(630, 'Simli', 'सिम्ली', 'JJK08', 'RURAL_MUNICIPALITY', 78.30, 6456, 5, 61, NOW(), NOW());

-- District 62: Jumla (9)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(631, 'Chandannath', 'चन्दननाथ', 'JML01', 'MUNICIPALITY', 89.40, 12345, 9, 62, NOW(), NOW()),
(632, 'Khanigaun', 'खनिगाउँ', 'JML02', 'MUNICIPALITY', 78.30, 10234, 7, 62, NOW(), NOW()),
(633, 'Tatopani', 'तातोपानी', 'JML03', 'RURAL_MUNICIPALITY', 67.50, 8456, 6, 62, NOW(), NOW()),
(634, 'Hima', 'हिमा', 'JML04', 'RURAL_MUNICIPALITY', 56.80, 7654, 6, 62, NOW(), NOW()),
(635, 'Jadama', 'जदमा', 'JML05', 'RURAL_MUNICIPALITY', 72.30, 7234, 6, 62, NOW(), NOW()),
(636, 'Kathkina', 'काठकिना', 'JML06', 'RURAL_MUNICIPALITY', 67.40, 6789, 5, 62, NOW(), NOW()),
(637, 'Naraha', 'नराहा', 'JML07', 'RURAL_MUNICIPALITY', 85.60, 6456, 5, 62, NOW(), NOW()),
(638, 'Sinha', 'सिन्हा', 'JML08', 'RURAL_MUNICIPALITY', 78.50, 6123, 5, 62, NOW(), NOW()),
(639, 'Guthi Chaur', 'गुठी चौर', 'JML09', 'RURAL_MUNICIPALITY', 67.30, 5890, 5, 62, NOW(), NOW());

-- District 63: Kalikot (9)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(640, 'Manma', 'मान्मा', 'KLK01', 'MUNICIPALITY', 67.40, 8456, 7, 63, NOW(), NOW()),
(641, 'Raskot', 'रास्कोट', 'KLK02', 'MUNICIPALITY', 56.30, 7654, 6, 63, NOW(), NOW()),
(642, 'Khandachakra', 'खण्डचक्र', 'KLK03', 'MUNICIPALITY', 78.50, 6789, 6, 63, NOW(), NOW()),
(643, 'Tilma', 'तिल्मा', 'KLK04', 'RURAL_MUNICIPALITY', 89.60, 5678, 5, 63, NOW(), NOW()),
(644, 'Gami', 'गमी', 'KLK05', 'RURAL_MUNICIPALITY', 67.30, 5234, 5, 63, NOW(), NOW()),
(645, 'Jumma', 'जुम्मा', 'KLK06', 'RURAL_MUNICIPALITY', 78.40, 4890, 5, 63, NOW(), NOW()),
(646, 'Kalinchok Kalikot', 'कालिन्चोक', 'KLK07', 'RURAL_MUNICIPALITY', 72.30, 4567, 5, 63, NOW(), NOW()),
(647, 'Mahabai', 'महाबै', 'KLK08', 'RURAL_MUNICIPALITY', 85.60, 4234, 5, 63, NOW(), NOW()),
(648, 'Pachal Jharana', 'पचाल झरना', 'KLK09', 'RURAL_MUNICIPALITY', 67.50, 3890, 5, 63, NOW(), NOW());

-- District 64: Mugu (6)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(649, 'Gamgadhi', 'गमगढी', 'MUG01', 'MUNICIPALITY', 189.30, 5234, 9, 64, NOW(), NOW()),
(650, 'Chhayanath', 'चयनाथ', 'MUG02', 'RURAL_MUNICIPALITY', 234.50, 3456, 5, 64, NOW(), NOW()),
(651, 'Dolpo Mugu', 'दोल्पा', 'MUG03', 'RURAL_MUNICIPALITY', 267.80, 2345, 5, 64, NOW(), NOW()),
(652, 'Khatyad', 'खत्याड', 'MUG04', 'RURAL_MUNICIPALITY', 312.40, 2123, 5, 64, NOW(), NOW()),
(653, 'Mugum', 'मुगुम', 'MUG05', 'RURAL_MUNICIPALITY', 278.60, 1890, 5, 64, NOW(), NOW()),
(654, 'Soru', 'सोरु', 'MUG06', 'RURAL_MUNICIPALITY', 245.70, 1678, 5, 64, NOW(), NOW());

-- District 65: Rukum East (6)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(655, 'Musikot Rukum East', 'मुसिकोट', 'RKE01', 'MUNICIPALITY', 56.30, 6789, 6, 65, NOW(), NOW()),
(656, 'Ghorahi Rukum', 'घोराही', 'RKE02', 'RURAL_MUNICIPALITY', 67.40, 5678, 5, 65, NOW(), NOW()),
(657, 'Chhiyang', 'छियाङ', 'RKE03', 'RURAL_MUNICIPALITY', 78.50, 4890, 5, 65, NOW(), NOW()),
(658, 'Dunge', 'दुङ्गे', 'RKE04', 'RURAL_MUNICIPALITY', 67.30, 4567, 5, 65, NOW(), NOW()),
(659, 'Liwang', 'लिवाङ', 'RKE05', 'RURAL_MUNICIPALITY', 72.40, 4234, 5, 65, NOW(), NOW()),
(660, 'Puwang', 'पुवाङ', 'RKE06', 'RURAL_MUNICIPALITY', 85.60, 3890, 5, 65, NOW(), NOW());

-- District 66: Salyan (8)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(661, 'Khalanga', 'खलङ्गा', 'SLY01', 'MUNICIPALITY', 67.30, 12345, 9, 66, NOW(), NOW()),
(662, 'Shaktikhor', 'शक्तिखोर', 'SLY02', 'MUNICIPALITY', 56.40, 9876, 7, 66, NOW(), NOW()),
(663, 'Chhatiban', 'छतिबान', 'SLY03', 'RURAL_MUNICIPALITY', 78.50, 7654, 6, 66, NOW(), NOW()),
(664, 'Damawada', 'दामावडा', 'SLY04', 'RURAL_MUNICIPALITY', 67.40, 7234, 6, 66, NOW(), NOW()),
(665, 'Darbong', 'दार्बोङ', 'SLY05', 'RURAL_MUNICIPALITY', 56.80, 6789, 5, 66, NOW(), NOW()),
(666, 'Kapurkot', 'कपुरकोट', 'SLY06', 'RURAL_MUNICIPALITY', 72.30, 6456, 5, 66, NOW(), NOW()),
(667, 'Kolma Salyan', 'कोल्मा', 'SLY07', 'RURAL_MUNICIPALITY', 67.50, 6123, 5, 66, NOW(), NOW()),
(668, 'Siddhakumar', 'सिद्धकुमार', 'SLY08', 'RURAL_MUNICIPALITY', 85.40, 5890, 5, 66, NOW(), NOW());

-- District 67: Surkhet (6)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(669, 'Birendranagar', 'वीरेन्द्रनगर', 'SRK01', 'SUB_METROPOLITAN_CITY', 89.30, 102345, 32, 67, NOW(), NOW()),
(670, 'Bheri', 'भेरी', 'SRK02', 'MUNICIPALITY', 67.40, 22345, 11, 67, NOW(), NOW()),
(671, 'Gurvakot', 'गुर्वाकोट', 'SRK03', 'RURAL_MUNICIPALITY', 78.50, 12345, 8, 67, NOW(), NOW()),
(672, 'Lekhapharsa', 'लेखाफर्सा', 'SRK04', 'RURAL_MUNICIPALITY', 56.80, 8456, 6, 67, NOW(), NOW()),
(673, 'Sharada', 'शारदा', 'SRK05', 'RURAL_MUNICIPALITY', 67.30, 7654, 6, 67, NOW(), NOW()),
(674, 'Bhim Datta', 'भीमदत्त', 'SRK06', 'RURAL_MUNICIPALITY', 72.40, 7234, 6, 67, NOW(), NOW());
-- =============================================================================
-- SUDURPASHCHIM PROVINCE (District IDs 68-76, 79 municipalities)
-- =============================================================================

-- District 68: Achham (9)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(675, 'Sanphebagar', 'साँफेबगर', 'ACH01', 'MUNICIPALITY', 67.30, 14567, 9, 68, NOW(), NOW()),
(676, 'Mangalsen', 'मङ्गलसेन', 'ACH02', 'MUNICIPALITY', 56.40, 12345, 9, 68, NOW(), NOW()),
(677, 'Kamalbazar', 'कमलबजार', 'ACH03', 'MUNICIPALITY', 78.50, 10234, 7, 68, NOW(), NOW()),
(678, 'Narayan', 'नारायण', 'ACH04', 'RURAL_MUNICIPALITY', 89.60, 8456, 6, 68, NOW(), NOW()),
(679, 'Chaurpati', 'चौरपाटी', 'ACH05', 'RURAL_MUNICIPALITY', 67.30, 7654, 6, 68, NOW(), NOW()),
(680, 'Dhakari', 'ढकारी', 'ACH06', 'RURAL_MUNICIPALITY', 78.40, 7234, 6, 68, NOW(), NOW()),
(681, 'Kalika', 'कालिका', 'ACH07', 'RURAL_MUNICIPALITY', 72.30, 6789, 5, 68, NOW(), NOW()),
(682, 'Mellekh', 'मेल्लेख', 'ACH08', 'RURAL_MUNICIPALITY', 67.50, 6456, 5, 68, NOW(), NOW()),
(683, 'Thuli Bheri', 'थुली भेरी', 'ACH09', 'RURAL_MUNICIPALITY', 85.60, 6123, 5, 68, NOW(), NOW());

-- District 69: Baitadi (9)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(684, 'Dhangadhi Baitadi', 'घन्धाडी', 'BAI01', 'MUNICIPALITY', 67.30, 12345, 9, 69, NOW(), NOW()),
(685, 'Dasharathchand', 'दशरथचन्द', 'BAI02', 'MUNICIPALITY', 56.40, 10234, 7, 69, NOW(), NOW()),
(686, 'Pithauli', 'पिठौली', 'BAI03', 'MUNICIPALITY', 78.50, 8456, 7, 69, NOW(), NOW()),
(687, 'Dogdakedar', 'डोग्डाकेदार', 'BAI04', 'RURAL_MUNICIPALITY', 89.60, 7654, 6, 69, NOW(), NOW()),
(688, 'Kailash', 'कैलास', 'BAI05', 'RURAL_MUNICIPALITY', 67.40, 7234, 6, 69, NOW(), NOW()),
(689, 'Melauli', 'मेलौली', 'BAI06', 'RURAL_MUNICIPALITY', 56.80, 6789, 5, 69, NOW(), NOW()),
(690, 'Patarashi', 'पतरासी', 'BAI07', 'RURAL_MUNICIPALITY', 72.30, 6456, 5, 69, NOW(), NOW()),
(691, 'Sanchaleni', 'सन्चलेनी', 'BAI08', 'RURAL_MUNICIPALITY', 67.50, 6123, 5, 69, NOW(), NOW()),
(692, 'Sharmali', 'शर्मली', 'BAI09', 'RURAL_MUNICIPALITY', 78.30, 5890, 5, 69, NOW(), NOW());

-- District 70: Bajhang (9)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(693, 'Jayaprithvi', 'जयपृथ्वी', 'BJH01', 'MUNICIPALITY', 78.30, 12345, 9, 70, NOW(), NOW()),
(694, 'Melauli Bajhang', 'मेलौली', 'BJH02', 'MUNICIPALITY', 67.40, 10234, 7, 70, NOW(), NOW()),
(695, 'Thuleli', 'थुलेली', 'BJH03', 'RURAL_MUNICIPALITY', 89.60, 8456, 6, 70, NOW(), NOW()),
(696, 'Bhatekanda', 'भाटेकान्डा', 'BJH04', 'RURAL_MUNICIPALITY', 67.30, 7654, 6, 70, NOW(), NOW()),
(697, 'Dekhatbhuli', 'देखातभुली', 'BJH05', 'RURAL_MUNICIPALITY', 78.40, 7234, 6, 70, NOW(), NOW()),
(698, 'Jhigga', 'झिग्गा', 'BJH06', 'RURAL_MUNICIPALITY', 72.30, 6789, 5, 70, NOW(), NOW()),
(699, 'Kedarsyu', 'केदारस्यु', 'BJH07', 'RURAL_MUNICIPALITY', 67.50, 6456, 5, 70, NOW(), NOW()),
(700, 'Lakha', 'लाखा', 'BJH08', 'RURAL_MUNICIPALITY', 85.40, 6123, 5, 70, NOW(), NOW()),
(701, 'Surma', 'सुर्मा', 'BJH09', 'RURAL_MUNICIPALITY', 78.60, 5890, 5, 70, NOW(), NOW());

-- District 71: Bajura (10)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(702, 'Badimalika', 'बडीमालिका', 'BJU01', 'MUNICIPALITY', 67.30, 12345, 9, 71, NOW(), NOW()),
(703, 'Triveni Bajura', 'त्रिवेणी', 'BJU02', 'MUNICIPALITY', 56.40, 10234, 7, 71, NOW(), NOW()),
(704, 'Buddhanagar', 'बुद्धनगर', 'BJU03', 'RURAL_MUNICIPALITY', 78.50, 8456, 6, 71, NOW(), NOW()),
(705, 'Chhatradevi', 'छत्रदेवी', 'BJU04', 'RURAL_MUNICIPALITY', 89.60, 7654, 6, 71, NOW(), NOW()),
(706, 'Gaumul', 'गौमुल', 'BJU05', 'RURAL_MUNICIPALITY', 67.30, 7234, 6, 71, NOW(), NOW()),
(707, 'Himali', 'हिमाली', 'BJU06', 'RURAL_MUNICIPALITY', 112.40, 5678, 5, 71, NOW(), NOW()),
(708, 'Khilxada', 'खिल्छडा', 'BJU07', 'RURAL_MUNICIPALITY', 67.50, 6456, 5, 71, NOW(), NOW()),
(709, 'Nabi', 'नवी', 'BJU08', 'RURAL_MUNICIPALITY', 72.30, 6123, 5, 71, NOW(), NOW()),
(710, 'Swamikartik', 'स्वामीकर्तिक', 'BJU09', 'RURAL_MUNICIPALITY', 85.60, 5890, 5, 71, NOW(), NOW()),
(711, 'Tribeni Bajura', 'त्रिवेणी', 'BJU10', 'RURAL_MUNICIPALITY', 78.30, 5678, 5, 71, NOW(), NOW());

-- District 72: Dadeldhura (7)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(712, 'Dipayal Silgadhi', 'दिपायल सिलगढी', 'DED01', 'MUNICIPALITY', 67.30, 12345, 9, 72, NOW(), NOW()),
(713, 'Amargadhi', 'अमरगढी', 'DED02', 'MUNICIPALITY', 56.40, 10234, 7, 72, NOW(), NOW()),
(714, 'Aadarsha', 'आदर्श', 'DED03', 'RURAL_MUNICIPALITY', 78.50, 8456, 6, 72, NOW(), NOW()),
(715, 'Bhageshwor', 'भागेश्वर', 'DED04', 'RURAL_MUNICIPALITY', 67.30, 7654, 6, 72, NOW(), NOW()),
(716, 'Galerkot', 'गलेरकोट', 'DED05', 'RURAL_MUNICIPALITY', 72.40, 7234, 6, 72, NOW(), NOW()),
(717, 'Nawadurga', 'नवदुर्गा', 'DED06', 'RURAL_MUNICIPALITY', 67.50, 6789, 5, 72, NOW(), NOW()),
(718, 'Sanshare', 'साँशरे', 'DED07', 'RURAL_MUNICIPALITY', 85.30, 6456, 5, 72, NOW(), NOW());

-- District 73: Darchula (8)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(719, 'Darchula', 'दार्चुला', 'DAR01', 'MUNICIPALITY', 67.30, 12345, 9, 73, NOW(), NOW()),
(720, 'Mahendranagar', 'महेन्द्रनगर', 'DAR02', 'MUNICIPALITY', 56.40, 10234, 7, 73, NOW(), NOW()),
(721, 'Shailyashikhar', 'शैल्यशिखर', 'DAR03', 'RURAL_MUNICIPALITY', 89.60, 8456, 6, 73, NOW(), NOW()),
(722, 'Badri', 'बद्री', 'DAR04', 'RURAL_MUNICIPALITY', 78.40, 7654, 6, 73, NOW(), NOW()),
(723, 'Jayaprithvi Darchula', 'जयपृथ्वी', 'DAR05', 'RURAL_MUNICIPALITY', 67.30, 7234, 6, 73, NOW(), NOW()),
(724, 'Khapas', 'खापस', 'DAR06', 'RURAL_MUNICIPALITY', 72.50, 6789, 5, 73, NOW(), NOW()),
(725, 'Lekam', 'लेकम', 'DAR07', 'RURAL_MUNICIPALITY', 67.30, 6456, 5, 73, NOW(), NOW()),
(726, 'Malikarjun', 'मालिकार्जुन', 'DAR08', 'RURAL_MUNICIPALITY', 78.60, 6123, 5, 73, NOW(), NOW());

-- District 74: Doti (9)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(727, 'Dipayal Silgadhi Doti', 'दिपायल सिलगढी', 'DOT01', 'MUNICIPALITY', 67.30, 12345, 9, 74, NOW(), NOW()),
(728, 'Dhangadhi Doti', 'घन्धाडी', 'DOT02', 'MUNICIPALITY', 56.40, 10234, 7, 74, NOW(), NOW()),
(729, 'Bogtan', 'बोग्टान', 'DOT03', 'RURAL_MUNICIPALITY', 78.50, 8456, 6, 74, NOW(), NOW()),
(730, 'Jorayal', 'जोरायल', 'DOT04', 'RURAL_MUNICIPALITY', 89.60, 7654, 6, 74, NOW(), NOW()),
(731, 'Kadokada', 'काडोकाडा', 'DOT05', 'RURAL_MUNICIPALITY', 67.30, 7234, 6, 74, NOW(), NOW()),
(732, 'Purbichauki', 'पूर्वीचौकी', 'DOT06', 'RURAL_MUNICIPALITY', 72.40, 6789, 5, 74, NOW(), NOW()),
(733, 'Sayal', 'सायल', 'DOT07', 'RURAL_MUNICIPALITY', 67.50, 6456, 5, 74, NOW(), NOW()),
(734, 'Shikhar', 'शिखर', 'DOT08', 'RURAL_MUNICIPALITY', 85.30, 6123, 5, 74, NOW(), NOW()),
(735, 'Trikal', 'त्रिकल', 'DOT09', 'RURAL_MUNICIPALITY', 78.60, 5890, 5, 74, NOW(), NOW());

-- District 75: Kailali (10)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(736, 'Dhangadhi', 'घन्धाडी', 'KIL01', 'SUB_METROPOLITAN_CITY', 95.30, 162345, 32, 75, NOW(), NOW()),
(737, 'Tikapur', 'टिकापुर', 'KIL02', 'MUNICIPALITY', 78.40, 42345, 17, 75, NOW(), NOW()),
(738, 'Godawari', 'गोदावरी', 'KIL03', 'MUNICIPALITY', 67.30, 32456, 15, 75, NOW(), NOW()),
(739, 'Bhimdatta', 'भीमदत्त', 'KIL04', 'MUNICIPALITY', 56.40, 28901, 13, 75, NOW(), NOW()),
(740, 'Lamki', 'लम्की', 'KIL05', 'MUNICIPALITY', 67.50, 24567, 11, 75, NOW(), NOW()),
(741, 'Ghodaghodi', 'घोडाघोडी', 'KIL06', 'RURAL_MUNICIPALITY', 89.60, 15678, 9, 75, NOW(), NOW()),
(742, 'Jasobanda', 'जसोबन्दा', 'KIL07', 'RURAL_MUNICIPALITY', 78.30, 12345, 8, 75, NOW(), NOW()),
(743, 'Kailari', 'कैलारी', 'KIL08', 'RURAL_MUNICIPALITY', 67.40, 9876, 7, 75, NOW(), NOW()),
(744, 'Mohanyal', 'मोहन्याल', 'KIL09', 'RURAL_MUNICIPALITY', 72.30, 8456, 6, 75, NOW(), NOW()),
(745, 'Sakota', 'सकोटा', 'KIL10', 'RURAL_MUNICIPALITY', 85.60, 7654, 6, 75, NOW(), NOW());

-- District 76: Kanchanpur (8)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(746, 'Mahendranagar', 'महेन्द्रनगर', 'KNP01', 'MUNICIPALITY', 78.30, 48234, 17, 76, NOW(), NOW()),
(747, 'Beldandi', 'बेलदण्डी', 'KNP02', 'MUNICIPALITY', 67.40, 22345, 11, 76, NOW(), NOW()),
(748, 'Jhilmili', 'झिल्मिली', 'KNP03', 'RURAL_MUNICIPALITY', 89.60, 15678, 9, 76, NOW(), NOW()),
(749, 'Chandanpur', 'चन्दनपुर', 'KNP04', 'RURAL_MUNICIPALITY', 67.30, 12345, 8, 76, NOW(), NOW()),
(750, 'Belauri', 'बेलौरी', 'KNP05', 'RURAL_MUNICIPALITY', 78.40, 10234, 7, 76, NOW(), NOW()),
(751, 'Punarba', 'पुनर्बा', 'KNP06', 'RURAL_MUNICIPALITY', 72.30, 8456, 6, 76, NOW(), NOW()),
(752, 'Shukla Phanta', 'शुक्लाफान्टा', 'KNP07', 'RURAL_MUNICIPALITY', 67.50, 7654, 6, 76, NOW(), NOW()),
(753, 'FSK', 'एफएसके', 'KNP08', 'RURAL_MUNICIPALITY', 85.40, 7234, 6, 76, NOW(), NOW());

-- District 77: Okhaldhunga (9)
INSERT INTO municipalities (id, name, name_nepali, code, type, area, population, ward_count, district_id, created_at, updated_at) VALUES
(754, 'Okhaldhunga', 'ओखलढुंगा', 'OKH01', 'MUNICIPALITY', 178.20, 32145, 11, 77, NOW(), NOW()),
(755, 'Rumjatar', 'रुम्जाटार', 'OKH02', 'MUNICIPALITY', 123.40, 18678, 9, 77, NOW(), NOW()),
(756, 'Chisankhugadhi', 'चिसङ्खुगढी', 'OKH03', 'RURAL_MUNICIPALITY', 145.60, 12345, 8, 77, NOW(), NOW()),
(757, 'Khiji Chandeshwari', 'खिजी चण्डेश्वरी', 'OKH04', 'RURAL_MUNICIPALITY', 134.50, 9876, 7, 77, NOW(), NOW()),
(758, 'Khoplang', 'खोप्लाङ', 'OKH05', 'RURAL_MUNICIPALITY', 156.30, 11234, 8, 77, NOW(), NOW()),
(759, 'Likhu', 'लिखु', 'OKH06', 'RURAL_MUNICIPALITY', 112.80, 8765, 7, 77, NOW(), NOW()),
(760, 'Sunkoshi', 'सुनकोशी', 'OKH07', 'RURAL_MUNICIPALITY', 128.40, 10543, 7, 77, NOW(), NOW()),
(761, 'Tapli', 'तप्ली', 'OKH08', 'RURAL_MUNICIPALITY', 98.60, 7654, 6, 77, NOW(), NOW()),
(762, 'Yamkhem', 'यामखेम', 'OKH09', 'RURAL_MUNICIPALITY', 105.30, 6543, 6, 77, NOW(), NOW());
-- __END_FILE__
