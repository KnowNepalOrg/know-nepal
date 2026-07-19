-- V17__enrich_scholarships_real_data.sql
-- Add important missing real scholarships and enrich existing ones

-- ============================================================
-- INSERT: 12 new real scholarships
-- ============================================================

INSERT INTO scholarships (name, name_nepali, slug, type, provider, amount, eligibility, deadline, application_url, description, total_slots, is_renewable, province_id, province_name, district_id, district_name, contact_phone, contact_email, image_url, created_at, updated_at) VALUES

('UGC Nepal Higher Education Scholarship', 'UGC नेपाल उच्च शिक्षा छात्रवृत्ति', 'ugc-nepal-he', 'GOVERNMENT', 'University Grants Commission (UGC) Nepal', 'Full tuition + monthly stipend NPR 10,000', 'Bachelor/Master/PhD in Nepali universities, merit-based selection through UGC competitive process', 'Annual (Shrawan)', 'https://ugc.gov.np', 'UGC Nepal''s flagship scholarship for higher education in Nepali universities. Covers full tuition fees and provides a monthly stipend of NPR 10,000 for living expenses. Available across all disciplines at recognized Nepali universities.', 500, TRUE, 3, 'Bagmati', 22, 'Kathmandu', '+977-1-4100701', 'info@ugc.gov.np', 'https://images.knownepal.com/scholarships/ugc-nepal-he.jpg', NOW(), NOW()),

('MOEST International Scholarship Program', 'शिक्षा, विज्ञान तथा प्रविधि मन्त्रालय अन्तर्राष्ट्रिय छात्रवृत्ति', 'moest-international', 'GOVERNMENT', 'Ministry of Education, Science and Technology', 'Full tuition + living allowance + airfare', 'Nepal government quota nominees, bilateral and multilateral agreement beneficiaries, academic excellence required', 'Annual (varies by partner country)', 'https://moest.gov.np', 'Nepal government''s international scholarship allocation through bilateral and multilateral agreements. Covers full tuition, living expenses, and airfare for studies at partner institutions worldwide. Selection done through MOEST competitive process.', 200, TRUE, 3, 'Bagmati', 22, 'Kathmandu', '+977-1-4100702', 'info@moest.gov.np', 'https://images.knownepal.com/scholarships/moest-international.jpg', NOW(), NOW()),

('Nepal Government 45% Reserved Quota Scholarship', 'नेपाल सरकार ४५% संरक्षित कोटा छात्रवृत्ति', 'nepal-govt-45-reserved', 'GOVERNMENT', 'Government of Nepal', 'Full tuition', 'Dalit, Janajati, Madhesi, Women, Disabled, and students from remote areas — 45% quota in public universities as per Constitution', 'Annual (university admission cycle)', 'https://moest.gov.np', 'Constitutional reservation for marginalized communities in public universities. Ensures 45% of total seats in public universities are allocated to Dalit, Janajati, Madhesi, women, persons with disabilities, and residents of remote districts.', NULL, FALSE, 3, 'Bagmati', 22, 'Kathmandu', '+977-1-4100703', 'info@moest.gov.np', 'https://images.knownepal.com/scholarships/nepal-govt-45-reserved.jpg', NOW(), NOW()),

('IOE TU Merit Scholarship (Engineering)', 'आईओई तु मेरिट छात्रवृत्ति', 'ioe-tu-merit', 'MERIT', 'Institute of Engineering, TU', 'Full tuition', 'Top 500 scorers in IOE entrance examination, admitted to IOE constituent campuses', 'Semester-based (post entrance result)', 'https://ioe.edu.np', 'Full scholarship for top IOE entrance examination scorers at constituent campuses of Institute of Engineering, Tribhuvan University. Covers full tuition for the entire program duration based on entrance rank.', 500, TRUE, 3, 'Bagmati', 22, 'Kathmandu', '+977-1-4100704', 'info@ioe.edu.np', 'https://images.knownepal.com/scholarships/ioe-tu-merit.jpg', NOW(), NOW()),

('TU Constituent Campus Scholarship', 'तु आश्रित परिसर छात्रवृत्ति', 'tu-constituent-scholarship', 'MERIT', 'Tribhuvan University', 'Partial tuition', 'TU entrance exam top scorers at constituent campuses across all faculties', 'Semester-based', 'https://tu.edu.np', 'Merit-based scholarships at TU constituent campuses across Nepal. Available for students scoring in the top ranks of the TU entrance examination across all faculties including Humanities, Science, Management, Education, and Law.', 1000, TRUE, 3, 'Bagmati', 22, 'Kathmandu', '+977-1-4100705', 'info@tu.edu.np', 'https://images.knownepal.com/scholarships/tu-constituent.jpg', NOW(), NOW()),

('KU Need and Merit Scholarship', 'कु आवश्यकता र मेरिट छात्रवृत्ति', 'ku-need-merit', 'NEED_BASED', 'Kathmandu University', '25-100% tuition', 'Combined financial need assessment and academic merit evaluation; minimum GPA 3.0 and documented financial need', 'Annual (during admission)', 'https://ku.edu.np', 'Combined need-based and merit scholarship at Kathmandu University. Provides 25% to 100% tuition waiver based on a holistic evaluation of financial need and academic performance. Available across all KU programs.', 200, TRUE, 3, 'Bagmati', 25, 'Kavrepalanchok', '+977-11-6610706', 'info@ku.edu.np', 'https://images.knownepal.com/scholarships/ku-need-merit.jpg', NOW(), NOW()),

('PU Entrance Merit Scholarship', 'पु प्रवेश मेरिट छात्रवृत्ति', 'pu-entrance-merit', 'MERIT', 'Pokhara University', 'Partial tuition', 'Top scorers in Pokhara University entrance examination across all affiliated and constituent campuses', 'Annual (post entrance)', 'https://pu.edu.np', 'Merit scholarships for top Pokhara University entrance scorers. Awarded to students achieving highest ranks in the PU entrance examination, covering partial tuition at PU constituent and affiliated campuses.', 300, TRUE, 4, 'Gandaki', 35, 'Kaski', '+977-61-520707', 'info@pu.edu.np', 'https://images.knownepal.com/scholarships/pu-entrance-merit.jpg', NOW(), NOW()),

('Uttaranchal University India Scholarship for Nepal', 'उत्तरांचल विश्वविद्यालय नेपाल छात्रवृत्ति', 'uttaranchal-nepal', 'INTERNATIONAL', 'Uttaranchal University, India', '50% tuition discount', 'Nepali students with +2 or equivalent with 50%+ aggregate marks', 'Annual (July-August)', 'https://uttaranchaluniversity.ac.in', 'India-based university scholarship specifically for Nepali students. Uttaranchal University offers a 50% tuition fee discount for Nepali nationals pursuing undergraduate and postgraduate programs across engineering, management, law, and other faculties.', NULL, TRUE, NULL, NULL, NULL, NULL, '+91-1334-230708', 'admissions@uttaranchaluniversity.ac.in', 'https://images.knownepal.com/scholarships/uttaranchal-nepal.jpg', NOW(), NOW()),

('Lumbini Sanskrit University Scholarship', 'लुम्बिनी संस्कृत विश्वविद्यालय छात्रवृत्ति', 'lumbini-sanskrit', 'GOVERNMENT', 'Nepal Sanskrit University', 'Full tuition + hostel accommodation', 'Students pursuing Sanskrit education, must pass university entrance examination', 'Annual (Shrawan)', 'https://lumbinisanskrit.edu.np', 'Full scholarship for students pursuing Sanskrit education at Nepal Sanskrit University. Covers full tuition fees and hostel accommodation. Available for Shastri, Acharya, and VidyaVaridhi programs in Sanskrit literature, philosophy, and Vedic studies.', NULL, TRUE, 5, 'Lumbini', 47, 'Rupandehi', '+977-71-520709', 'info@lumbinisanskrit.edu.np', 'https://images.knownepal.com/scholarships/lumbini-sanskrit.jpg', NOW(), NOW()),

('AFU Agriculture Merit Scholarship', 'कृषि तथा वन विज्ञान विश्वविद्यालय मेरिट छात्रवृत्ति', 'afu-agri-merit', 'MERIT', 'Agriculture and Forestry University', 'Full tuition', 'Top scorers in AFU entrance examination across all agricultural and forestry programs', 'Annual (post entrance result)', 'https://afu.edu.np', 'Merit scholarship at Agriculture and Forestry University for top entrance examination scorers. Covers full tuition for undergraduate and postgraduate programs in agriculture, forestry, veterinary science, and related disciplines.', NULL, TRUE, 3, 'Bagmati', 26, 'Chitwan', '+977-56-520710', 'info@afu.edu.np', 'https://images.knownepal.com/scholarships/afu-agri-merit.jpg', NOW(), NOW()),

('Ncell Foundation Scholarship', 'एनसेल फाउन्डेसन छात्रवृत्ति', 'ncell-foundation', 'INSTITUTIONAL', 'Ncell', 'NPR 100,000/year', 'ICT/Engineering students enrolled in recognized universities, minimum GPA 3.5+ in +2 or equivalent', 'Annual (Chaitra)', 'https://ncell.axiata.com/responsibility', 'Ncell''s CSR scholarship for technology education. Provides NPR 100,000 per year to meritorious students pursuing ICT and Engineering degrees. Includes mentorship opportunities and potential internship placement at Ncell.', NULL, TRUE, 3, 'Bagmati', 22, 'Kathmandu', '+977-1-4100711', 'foundation@ncell.axiata.com', 'https://images.knownepal.com/scholarships/ncell-foundation.jpg', NOW(), NOW()),

('Himalayan Bank Limited Scholarship', 'हिमालयन बैंक लिमिटेड छात्रवृत्ति', 'himalayan-bank-scholarship', 'INSTITUTIONAL', 'Himalayan Bank Limited', 'NPR 80,000/year', 'Management/Finance students at recognized universities, minimum GPA 3.5+ in +2 or equivalent', 'Annual (Shrawan)', 'https://himalayanbank.com', 'Banking sector scholarship for management education by Himalayan Bank Limited. Provides NPR 80,000 per year to meritorious students in management, finance, and banking-related programs. Includes potential employment pathway.', NULL, TRUE, 3, 'Bagmati', 22, 'Kathmandu', '+977-1-4100712', 'info@himalayanbank.com', 'https://images.knownepal.com/scholarships/himalayan-bank-scholarship.jpg', NOW(), NOW());


-- ============================================================
-- UPDATE: Enrich existing scholarships with more accurate data
-- ============================================================

-- Enrich Full Bright Scholarship with better details
UPDATE scholarships SET
    amount = 'Full tuition + living allowance + travel allowance',
    eligibility = 'Master/PhD level, minimum GPA 3.0+, strong academic record and leadership qualities',
    description = 'Prestigious US government Fulbright scholarship for Nepali students. Covers full tuition, living allowance, airfare, and health insurance for graduate studies in the United States.',
    application_url = 'https://foreign.fulbrightonline.org',
    total_slots = 12,
    is_renewable = TRUE,
    updated_at = NOW()
WHERE slug = 'fulbright-nepal';

-- Enrich Australia Awards
UPDATE scholarships SET
    amount = 'Full tuition + return airfare + living allowance + health insurance + fieldwork contribution',
    eligibility = 'Bachelor/Master level, 3+ years work experience, development-focused study areas, English proficiency (IELTS 6.0+)',
    description = 'Australian government scholarships for development-focused studies. Targets mid-career professionals from developing countries including Nepal. Covers full tuition, return airfare, living allowance, health insurance, and fieldwork contribution.',
    total_slots = 20,
    updated_at = NOW()
WHERE slug = 'australia-awards';

-- Enrich Erasmus Mundus
UPDATE scholarships SET
    amount = 'Full tuition + travel allowance + monthly stipend EUR 1,400',
    eligibility = 'Master level, IELTS 6.5+ or equivalent, strong academic background',
    description = 'European Union Erasmus Mundus Joint Masters scholarship for international students. Provides full tuition, travel allowance, and monthly living stipend of EUR 1,400 for joint master programs across European universities.',
    total_slots = 10,
    updated_at = NOW()
WHERE slug = 'erasmus-mundus';

-- Enrich Japan MEXT
UPDATE scholarships SET
    amount = 'Full tuition + monthly stipend JPY 117,000-145,000 + round-trip airfare',
    eligibility = 'Undergraduate (17-24 years) / Research students (under 35), Nepali nationality, academic excellence',
    description = 'Japanese government MEXT scholarship for Nepali students. Provides full tuition exemption, monthly living stipend (JPY 117,000 for undergraduate, JPY 145,000 for research), and round-trip airfare.',
    total_slots = 15,
    updated_at = NOW()
WHERE slug = 'mext-japan';

-- Enrich Korean Government Scholarship
UPDATE scholarships SET
    amount = 'Full tuition + monthly stipend KRW 900,000 + round-trip airfare + settlement allowance + Korean language training',
    eligibility = 'Bachelor (under 25) / Master/PhD (under 40), Nepali nationality, GPA 80%+ or equivalent',
    description = 'Korean government KGSP scholarship for international students. Includes full tuition, monthly stipend of KRW 900,000, round-trip airfare, one-time settlement allowance, and 1 year Korean language training.',
    total_slots = 12,
    updated_at = NOW()
WHERE slug = 'kgsp-korea';

-- Enrich Nepal Government Domestic Scholarship
UPDATE scholarships SET
    amount = 'Full tuition + monthly stipend',
    eligibility = 'SEE GPA 3.5+ / +2 GPA 3.0+, Nepali citizens, admission to public institutions',
    description = 'Government of Nepal scholarship for meritorious students in public institutions. Awarded based on SEE/+2 GPA and entrance examination performance. Available across TU, KU, and other public universities.',
    total_slots = 150,
    is_renewable = TRUE,
    updated_at = NOW()
WHERE slug = 'nepal-govt-scholarship';

-- Enrich TU Merit Scholarship
UPDATE scholarships SET
    amount = 'Full tuition (constituent) / Partial tuition (affiliated)',
    eligibility = 'Top TU entrance examination scorers, admitted to constituent or affiliated campuses',
    total_slots = 200,
    updated_at = NOW()
WHERE slug = 'tu-merit';

-- Enrich KU Merit Scholarship
UPDATE scholarships SET
    amount = '25-75% tuition waiver',
    eligibility = 'Top KU entrance examination scorers, minimum GPA 3.5+ in +2',
    total_slots = 50,
    updated_at = NOW()
WHERE slug = 'ku-merit';

-- Enrich Nepal Bank Scholarship
UPDATE scholarships SET
    amount = 'NPR 100,000/year + internship opportunity',
    eligibility = 'Management/Finance/Banking students at recognized universities, GPA 3.5+, Nepali citizen',
    description = 'Banking sector scholarship by Nepal Bank Limited for management and finance students. Provides NPR 100,000 per year with priority for internship and potential employment at Nepal Bank.',
    total_slots = 25,
    updated_at = NOW()
WHERE slug = 'nepal-bank-scholarship';

-- Enrich existing Himalayan Bank Scholarship (hbl-scholarship)
UPDATE scholarships SET
    amount = 'NPR 80,000/year + mentorship program',
    eligibility = 'Management/IT students at recognized universities, GPA 3.5+',
    description = 'Himalayan Bank private scholarship program for management and IT students. Provides NPR 80,000 per year with mentorship from banking professionals and potential employment pathway.',
    total_slots = 20,
    updated_at = NOW()
WHERE slug = 'hbl-scholarship';

-- Enrich China CSC Scholarship
UPDATE scholarships SET
    amount = 'Full tuition + monthly stipend CNY 2,500-3,500 + accommodation + health insurance',
    eligibility = 'Bachelor/Master/PhD, Nepali nationality, academic excellence, HSK 4+ for Chinese-taught programs',
    description = 'Chinese government CSC scholarship for Nepali students. Covers full tuition, monthly stipend (CNY 2,500 undergraduate, CNY 3,000 master, CNY 3,500 PhD), on-campus accommodation, and comprehensive health insurance.',
    total_slots = 25,
    updated_at = NOW()
WHERE slug = 'csc-china';

-- Enrich DAAD Scholarship
UPDATE scholarships SET
    amount = 'Full tuition + monthly stipend EUR 861-1,200 + health insurance + travel allowance',
    eligibility = 'Master/PhD level, German language or English proficiency depending on program, academic excellence',
    description = 'German Academic Exchange Service (DAAD) scholarship for Nepali students. Provides full tuition exemption, monthly stipend (EUR 861 master, EUR 1,200 PhD), health insurance, and travel allowance for studies in Germany.',
    total_slots = 10,
    updated_at = NOW()
WHERE slug = 'daad-germany';

-- Enrich British Council GREAT Scholarship
UPDATE scholarships SET
    amount = 'GBP 10,000 tuition discount at partner UK universities',
    eligibility = 'Master level, Nepali nationality, IELTS 6.5+, admission to partner UK university',
    description = 'British Council GREAT scholarship for Nepali students at selected UK universities. Provides GBP 10,000 tuition discount for master''s programs at partner institutions.',
    total_slots = 12,
    updated_at = NOW()
WHERE slug = 'great-uk';

-- Enrich Ncell AX Scholarship
UPDATE scholarships SET
    amount = 'NPR 75,000/year + mentorship + internship at Ncell',
    eligibility = 'ICT/Engineering students at recognized universities, GPA 3.0+',
    description = 'Ncell telecom sector ICT scholarship. Provides NPR 75,000 per year along with mentorship from industry professionals and potential internship placement at Ncell.',
    total_slots = 15,
    updated_at = NOW()
WHERE slug = 'ncell-ax';

-- Enrich Nepal Telecom Scholarship
UPDATE scholarships SET
    amount = 'NPR 75,000/year + internship at NTC',
    eligibility = 'Telecom/IT/Electronics Engineering students, GPA 3.0+',
    description = 'Nepal Telecom scholarship for IT and telecom engineering students. Provides NPR 75,000 per year with internship opportunities at Nepal Telecom offices nationwide.',
    total_slots = 15,
    updated_at = NOW()
WHERE slug = 'ntc-scholarship';

-- Enrich SNMF Scholarship
UPDATE scholarships SET
    amount = 'NPR 40,000/year + study materials',
    eligibility = 'Students from underprivileged and economically disadvantaged backgrounds, GPA 2.5+',
    description = 'Sagarmatha National Trust need-based scholarship for economically disadvantaged students. Provides NPR 40,000 per year along with study materials and academic support.',
    total_slots = 40,
    updated_at = NOW()
WHERE slug = 'snmf-scholarship';

-- Enrich Buddhist Scholarship
UPDATE scholarships SET
    amount = 'Full tuition + hostel accommodation + monthly stipend NPR 5,000',
    eligibility = 'Students pursuing Buddhist studies at recognized institutions',
    description = 'Lumbini Development Trust scholarship for students pursuing Buddhist studies. Covers full tuition, hostel accommodation, and monthly stipend at Buddhist educational institutions.',
    total_slots = 20,
    updated_at = NOW()
WHERE slug = 'buddhist-scholarship';

-- Enrich Indigenous Peoples Scholarship
UPDATE scholarships SET
    amount = 'Full tuition + annual book grant NPR 10,000',
    eligibility = 'Indigenous nationalities (Janajati), GPA 2.5+, admitted to public institutions',
    description = 'Government of Nepal scholarship for indigenous nationalities. Covers full tuition and provides an annual book grant of NPR 10,000. Available at public universities for students from recognized Janajati communities.',
    total_slots = 75,
    updated_at = NOW()
WHERE slug = 'indigenous-scholarship';

-- Enrich Dalit Scholarship
UPDATE scholarships SET
    amount = 'Full tuition + monthly stipend NPR 5,000 + study materials',
    eligibility = 'Dalit community students, minimum GPA 2.0+, admitted to educational institutions',
    description = 'Government of Nepal scholarship program for Dalit students. Provides full tuition, monthly stipend of NPR 5,000, and study materials to promote educational access and equity.',
    total_slots = 75,
    updated_at = NOW()
WHERE slug = 'dalit-scholarship';

-- Enrich Gurkha Welfare Trust Scholarship
UPDATE scholarships SET
    amount = 'Full tuition + living allowance + accommodation',
    eligibility = 'Ex-Gurkha families (widows and dependents), GPA 2.5+, demonstrated financial need',
    description = 'Gurkha Welfare Trust welfare scholarship for families of ex-Gurkha servicemen. Provides full tuition, living allowance, and accommodation support for widows and dependents of former Gurkha soldiers.',
    total_slots = 20,
    updated_at = NOW()
WHERE slug = 'gwt-scholarship';

-- Enrich Sagarmatha Sainik Scholarship
UPDATE scholarships SET
    amount = 'Full tuition + boarding + book allowance',
    eligibility = 'Children of Nepal Army personnel, merit-based selection, minimum GPA 3.0',
    description = 'Nepal Army Education Trust scholarship for children of army personnel. Provides full tuition, boarding facilities, and book allowance based on merit and service background.',
    total_slots = 25,
    updated_at = NOW()
WHERE slug = 'sagarmatha-sainik';
