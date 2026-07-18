-- V11__seed_emergency_contacts.sql
-- Seed national and regional emergency contacts for Nepal

-- =============================================================================
-- NATIONAL EMERGENCY CONTACTS
-- =============================================================================

INSERT INTO emergency_contacts (name, name_nepali, type, phone, alternate_phone, email, website, description, is_national, slug, available_hours, created_at, updated_at) VALUES
('Nepal Police', 'नेपाल प्रहरी', 'POLICE', '100', '01-4411258', NULL, NULL, 'Nepal Police national emergency hotline. Dial 100 for immediate police assistance anywhere in Nepal.', TRUE, 'nepal-police', '24/7', NOW(), NOW()),
('Police Headquarters', 'प्रहरी मुख्यालय', 'POLICE', '01-4411258', '01-4412385', NULL, 'https://nepalpolice.gov.np', 'Nepal Police Headquarters, Naxal, Kathmandu. For non-emergency inquiries and reports.', TRUE, 'police-headquarters', '24/7', NOW(), NOW()),
('Tourist Police', 'पर्यटकीय प्रहरी', 'POLICE', '01-4247041', '01-4256951', NULL, NULL, 'Tourist Police Bureau for tourist safety, complaints, and assistance. Bhrikutimandap, Kathmandu.', TRUE, 'tourist-police', '24/7', NOW(), NOW()),
('Armed Police Force', 'सशस्त्र प्रहरी बल', 'POLICE', '01-4271498', '01-4271047', NULL, 'https://apf.gov.np', 'Armed Police Force Nepal Headquarters. Handles border security and national emergencies.', TRUE, 'armed-police-force', '24/7', NOW(), NOW()),

('Ambulance', 'एम्बुलेन्स', 'AMBULANCE', '102', '01-4244121', NULL, NULL, 'National ambulance service hotline. Dial 102 for emergency medical transport anywhere in Nepal.', TRUE, 'ambulance-service', '24/7', NOW(), NOW()),
('Red Cross Ambulance', 'रेडक्रस एम्बुलेन्स', 'AMBULANCE', '01-4222928', '01-4228637', NULL, 'https://nrcs.org.np', 'Nepal Red Cross Society ambulance service. Available in major cities.', TRUE, 'red-cross-ambulance', '24/7', NOW(), NOW()),

('Fire Brigade', 'अग्निशमन सेवा', 'FIRE', '101', '01-4411395', NULL, NULL, 'National fire brigade hotline. Dial 101 for fire emergencies across Nepal.', TRUE, 'fire-brigade', '24/7', NOW(), NOW()),

('National Emergency Operation Centre', 'राष्ट्रिय आपतकालीन सञ्चालन केन्द्र', 'DISASTER', '1166', '01-4285738', NULL, NULL, 'National Emergency Operation Centre (NEOC) under the Ministry of Home Affairs. Coordinates disaster response.', TRUE, 'neoc', '24/7', NOW(), NOW()),
('Department of Hydrology and Meteorology', 'जलविज्ञान तथा मौसम विज्ञान विभाग', 'DISASTER', '01-4263913', '01-4263914', NULL, 'https://dhm.gov.np', 'Weather alerts, flood warnings, and hydrological data.', TRUE, 'dhm', '24/7', NOW(), NOW()),
('Nepal Disaster Risk Reduction and Management Authority', 'दुर्घटना जोखिम न्यूनीकरण तथा व्यवस्थापन प्राधिकरण', 'DISASTER', '01-4116188', NULL, NULL, NULL, 'NDRRMA - National authority for disaster preparedness and response coordination.', TRUE, 'ndrrma', 'Mon-Sat 9AM-5PM', NOW(), NOW()),

('Women and Children Service Centre', 'महिला तथा बालबालिका सेवा केन्द्र', 'WOMEN_CHILDREN', '104', '01-4410036', NULL, NULL, 'National women and children helpline. Dial 104 for domestic violence, abuse, and child protection.', TRUE, 'women-children-helpline', '24/7', NOW(), NOW()),
('Child Helpline', 'बाल हेल्पलाइन', 'WOMEN_CHILDREN', '1098', NULL, NULL, NULL, 'National child helpline for children in distress, abuse, or needing immediate help.', TRUE, 'child-helpline', '24/7', NOW(), NOW()),
('Maiti Nepal', 'माइती नेपाल', 'WOMEN_CHILDREN', '01-4263305', '01-4263286', NULL, 'https://maiti.org.np', 'Anti-trafficking organization providing rescue, rehabilitation, and shelter for women and children.', TRUE, 'maiti-nepal', '24/7', NOW(), NOW()),

('CIAA', 'भ्रष्टाचार अनुसन्धान आयोग', 'GOVERNMENT', '01-4235500', '01-4235501', NULL, 'https://ciaa.gov.np', 'Commission for the Investigation of Abuse of Authority. Report corruption and abuse of power.', TRUE, 'ciaa', 'Mon-Fri 9AM-5PM', NOW(), NOW()),
('Department of Passports', 'नागरिकता तथा पासपोर्ट विभाग', 'GOVERNMENT', '01-4215290', '01-4215315', NULL, 'https://dop.gov.np', 'Passport office. For passport applications, renewals, and travel documents.', TRUE, 'department-passports', 'Mon-Fri 9AM-5PM', NOW(), NOW()),
('Labour Advisory and Information Service', 'श्रम सल्लाह तथा सूचना सेवा', 'GOVERNMENT', '1660-1066000', NULL, NULL, NULL, 'Labour advisory hotline for Nepali migrant workers. Free of charge.', TRUE, 'labour-advisory', 'Mon-Fri 9AM-5PM', NOW(), NOW()),

('Nepal Electricity Authority Customer Service', 'नेपाल बिद्युत प्राधिकरण ग्राहक सेवा', 'UTILITY', '01-4246516', '01-4244466', NULL, 'https://nea.org.np', 'Electricity outage reporting and general electricity queries.', TRUE, 'nea-customer-service', '24/7', NOW(), NOW()),
('Nepal Telecom Customer Care', 'नेपाल टेलिकम ग्राहक सेवा', 'UTILITY', '1498', '01-5321042', NULL, 'https://ntc.net.np', 'Nepal Telecom customer support for mobile, broadband, and landline services.', TRUE, 'ntc-customer-care', '24/7', NOW(), NOW()),
('Kathmandu Drinking Water Utility', 'काठमाडौं पेयजल उपत्यका वितरण प्रणाली', 'UTILITY', '01-4255151', '01-4255069', NULL, 'https://kukl.com.np', 'Borehole water supply for Kathmandu valley. For water supply complaints and new connections.', TRUE, 'kukl', '24/7', NOW(), NOW()),

('Nepal Tourism Board', 'नेपाल पर्यटन बोर्ड', 'TOURISM', '01-4256911', '01-4256329', NULL, 'https://ntb.org.np', 'Nepal Tourism Board. Tourist information, visa guidance, and travel advisories.', TRUE, 'ntb', 'Mon-Fri 9AM-5PM', NOW(), NOW()),
('Trekking Agencies Association of Nepal', 'नेपाल पदयात्रा प्रतिनिधि संघ', 'TOURISM', '01-4427886', '01-4440509', NULL, 'https://taan.org.np', 'TAAN - For trekking permits, porter/guide registration, and mountain safety.', TRUE, 'taan', 'Mon-Fri 9AM-5PM', NOW(), NOW()),
('Himalayan Rescue Association', 'हिमालय उद्धार संघ', 'TOURISM', '01-4440298', NULL, NULL, 'https://himalayanrescue.org', 'HRA provides mountain rescue, medical care on trekking routes, and safety advisories.', TRUE, 'hra', '24/7 (seasonal)', NOW(), NOW()),

('Bir Hospital', 'वीर अस्पताल', 'HOSPITAL', '01-4221119', '01-4222664', NULL, 'https://birhospital.gov.np', 'Oldest government hospital in Nepal. Mahabouddha, Kathmandu. Emergency and specialty services.', TRUE, 'bir-hospital', '24/7', NOW(), NOW()),
('TU Teaching Hospital', 'त्रिभुवन विश्वविद्यालय शिक्षण अस्पताल', 'HOSPITAL', '01-4412303', '01-4412305', NULL, 'https://tuth.edu.np', 'Tribhuvan University Teaching Hospital, Maharajgunj. Major teaching and referral hospital.', TRUE, 'tu-teaching-hospital', '24/7', NOW(), NOW()),
('Patan Hospital', 'पाटन अस्पताल', 'HOSPITAL', '01-5522278', '01-5522296', NULL, 'https://patanhospital.org.np', 'Patan Hospital and Research Centre, Lalitpur. Known for trauma care and general services.', TRUE, 'patan-hospital', '24/7', NOW(), NOW()),
('BP Koirala Institute of Health Sciences', 'बी.पी. कोइराला स्वास्थ्य विज्ञान संस्थान', 'HOSPITAL', '021-465115', '021-465280', NULL, 'https://bpkihs.edu.np', 'Major medical college and hospital in Dharan, Eastern Nepal. Tertiary care centre.', TRUE, 'bpkihs', '24/7', NOW(), NOW()),
('Bharatpur Hospital', 'भरतपुर अस्पताल', 'HOSPITAL', '056-526157', '056-524640', NULL, 'https://bharatpurhospital.gov.np', 'Government hospital in Bharatpur, Chitwan. Major referral hospital for central Nepal.', TRUE, 'bharatpur-hospital', '24/7', NOW(), NOW()),
('Lumbini Provincial Hospital', 'लुम्बिनी प्रादेशिक अस्पताल', 'HOSPITAL', '071-522555', '071-522556', NULL, NULL, 'Lumbini Provincial Hospital, Butwal. Major government hospital in Lumbini Province.', TRUE, 'lumbini-provincial-hospital', '24/7', NOW(), NOW());
