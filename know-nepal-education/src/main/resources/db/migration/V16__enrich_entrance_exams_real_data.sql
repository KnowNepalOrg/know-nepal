-- V16__enrich_entrance_exams_real_data.sql
-- Enrich existing 16 entrance exams with real data and add missing important exams

-- ============================================================
-- UPDATES to existing entrance exams
-- ============================================================

-- 1. UPDATE CMAT - Replace the generic MBS entrance with the real CMAT
UPDATE entrance_exams
SET name = 'CMAT - Central Management Admission Test',
    name_nepali = 'केन्द्रीय व्यवस्थापन प्रवेश परीक्षा',
    slug = 'cmat-entrance',
    code = 'CMAT-001',
    board_name = 'Tribhuvan University Examination Controller',
    format = 'BOTH',
    eligibility = '+2 or equivalent in any stream with minimum 45% marks or CGPA 2.0',
    syllabus = 'Quantitative Methods, Verbal Ability, Logical Reasoning, General Knowledge',
    fee_structure = 'NPR 2,000',
    total_seats = 3000,
    duration_hours = 3,
    total_marks = 200,
    pass_marks = 80,
    description = 'Nepal''s most popular management entrance examination conducted by Tribhuvan University for MBA, MBS, BBS admissions across 60+ management campuses. Approximately 20,000 students appear annually.',
    website = 'https://tuexam.tu.edu.np'
WHERE slug = 'mbs-entrance';

-- 2. UPDATE MECEE-BL - Replace the old MBBS-only entrance with unified medical entrance
UPDATE entrance_exams
SET name = 'MECEE-BL - Medical Education Common Entrance Examination (Bachelor Level)',
    name_nepali = 'चिकित्सा शिक्षा साझा प्रवेश परीक्षा (स्नातक तह)',
    slug = 'mecee-bl-entrance',
    code = 'MCEEBL-001',
    board_name = 'Medical Education Commission',
    format = 'ONLINE',
    exam_date = 'October-November',
    registration_deadline = 'September-October',
    eligibility = '+2 Science (PCB/PCM) with minimum 50% aggregate or CGPA 2.4',
    syllabus = 'Physics (50 marks), Chemistry (50 marks), Biology (60 marks), English (20 marks), Logical Reasoning & Aptitude (20 marks)',
    fee_structure = 'NPR 3,000',
    total_seats = 7500,
    duration_hours = 3,
    total_marks = 200,
    pass_marks = 100,
    description = 'Unified medical entrance examination conducted by Medical Education Commission for all bachelor-level health science programs including MBBS, BDS, BSc Nursing, BPharm, BPH, BASLP, BOptometry, and others. Over 30,000 students apply annually. Computer Based Test (CBT) format.',
    website = 'https://mec.gov.np'
WHERE slug = 'mbbs-entrance';

-- 3. UPDATE IOE Entrance - more accurate data
UPDATE entrance_exams
SET name = 'IOE Entrance Examination - Institute of Engineering',
    name_nepali = 'इन्जिनियरिङ अध्ययन संस्थान प्रवेश परीक्षा',
    slug = 'ioe-entrance',
    code = 'IOE-EE-005',
    board_name = 'Tribhuvan University Examination Controller',
    format = 'OFFLINE',
    exam_date = 'August',
    registration_deadline = 'July',
    eligibility = '+2 Science (PCM) with minimum 50% aggregate marks or CGPA 2.4',
    syllabus = 'Physics (60 MCQ), Chemistry (60 MCQ), Mathematics (80 MCQ) - total 200 MCQs. Covers entire +2 level syllabus for science stream.',
    fee_structure = 'NPR 1,500',
    total_seats = 5000,
    duration_hours = 3,
    total_marks = 200,
    pass_marks = 80,
    description = 'Institute of Engineering (IOE) entrance examination under Tribhuvan University for admission to BE/BArch programs at Pulchowk, Thapathali, Purwanchal, and Pokhara campuses. Over 25,000 students appear annually for approximately 5,000 seats across all campuses.',
    website = 'https://ioe.tu.edu.np',
    image_url = 'https://images.knownepal.com/exams/ioe-entrance.jpg'
WHERE slug = 'ioe-entrance';

-- 4. UPDATE B.Ed Entrance - more accurate data
UPDATE entrance_exams
SET name = 'TU B.Ed Entrance Examination',
    name_nepali = 'तु बी.एड प्रवेश परीक्षा',
    slug = 'bed-entrance',
    code = 'BED-EE-014',
    board_name = 'Tribhuvan University Examination Controller',
    format = 'OFFLINE',
    eligibility = '+2 or Bachelor degree with minimum 45% marks',
    syllabus = 'English (20), Nepali (20), Education (30), General Knowledge & Current Affairs (20), Logical Reasoning (10)',
    fee_structure = 'NPR 1,000',
    total_seats = 5000,
    duration_hours = 3,
    total_marks = 100,
    pass_marks = 40,
    description = 'Tribhuvan University entrance examination for Bachelor of Education (B.Ed) programs across affiliated campuses. Required for admission to 4-year B.Ed and 2-year B.Ed programs.',
    website = 'https://tuexam.tu.edu.np'
WHERE slug = 'bed-entrance';

-- 5. UPDATE PU Entrance - more accurate management data
UPDATE entrance_exams
SET name = 'PU Management Entrance Examination',
    name_nepali = 'पोखरा विश्वविद्यालय व्यवस्थापन प्रवेश परीक्षा',
    slug = 'pu-entrance',
    code = 'PUEE-003',
    board_name = 'Pokhara University Examination Division',
    format = 'OFFLINE',
    exam_date = 'September',
    registration_deadline = 'August',
    eligibility = '+2 or equivalent with minimum 45% marks',
    syllabus = 'Verbal Ability (25), Quantitative Ability (25), Logical Reasoning (25), General Knowledge (25)',
    fee_structure = 'NPR 1,500',
    total_seats = 2000,
    duration_hours = 3,
    total_marks = 150,
    pass_marks = 60,
    description = 'Pokhara University entrance examination for management programs (BBA, MBA, MBS) and other undergraduate/postgraduate programs at PU-affiliated campuses.',
    website = 'https://pu.edu.np/admission'
WHERE slug = 'pu-entrance';

-- ============================================================
-- INSERT new entrance exams
-- ============================================================

-- 6. KUCAT-CBT - Kathmandu University Common Admission Test
INSERT INTO entrance_exams (name, name_nepali, slug, code, board_id, board_name, format, exam_date, registration_deadline, eligibility, syllabus, fee_structure, total_seats, duration_hours, total_marks, pass_marks, description, website, image_url, created_at, updated_at)
VALUES
('KUCAT-CBT - Kathmandu University Common Admission Test',
 'काठमाडौं विश्वविद्यालय साझा प्रवेश परीक्षा',
 'kucat-cbt-entrance',
 'KUCAT-001',
 5,
 'Kathmandu University',
 'ONLINE',
 'July-August',
 'June-July',
 '+2 or equivalent with minimum 50% marks or CGPA 2.4',
 'Program-specific modules: Engineering (Physics, Chemistry, Math), Management (Verbal, Quantitative, Logical, GK), Science (Biology, Chemistry, Physics)',
 'NPR 2,500',
 3000,
 3,
 200,
 80,
 'Kathmandu University unified computer-based admission test (CBT) for engineering, management, science, law, and other programs. Seats vary by faculty and program. Approximately 15,000 students appear annually.',
 'https://ku.edu.np/admission',
 'https://images.knownepal.com/exams/kucat-cbt.jpg',
 NOW(),
 NOW());

-- 7. BSc CSIT Entrance - TU
INSERT INTO entrance_exams (name, name_nepali, slug, code, board_id, board_name, format, exam_date, registration_deadline, eligibility, syllabus, fee_structure, total_seats, duration_hours, total_marks, pass_marks, description, website, image_url, created_at, updated_at)
VALUES
('BSc CSIT Entrance Examination - TU',
 'बी.एस.सी. सीएसआईटी प्रवेश परीक्षा',
 'bsc-csit-entrance',
 'BSCCSIT-001',
 4,
 'Tribhuvan University Examination Controller',
 'OFFLINE',
 'August-September',
 'July-August',
 '+2 or equivalent with minimum 45% marks and studied Science or equivalent',
 'Physics (20), Chemistry (15), Mathematics (25), Biology (10), English (15), General Knowledge (15) - total 100 marks MCQ',
 'NPR 1,000',
 2000,
 3,
 100,
 40,
 'Entrance examination for Bachelor of Science in Computer Science and Information Technology (BSc CSIT) under Tribhuvan University. One of the most sought-after IT undergraduate programs in Nepal with limited seats across affiliated colleges.',
 'https://tuexam.tu.edu.np',
 'https://images.knownepal.com/exams/bsc-csit-entrance.jpg',
 NOW(),
 NOW());

-- 8. BIT Entrance - TU
INSERT INTO entrance_exams (name, name_nepali, slug, code, board_id, board_name, format, exam_date, registration_deadline, eligibility, syllabus, fee_structure, total_seats, duration_hours, total_marks, pass_marks, description, website, image_url, created_at, updated_at)
VALUES
('BIT Entrance Examination - TU',
 'बी.आई.टी. प्रवेश परीक्षा',
 'bit-entrance',
 'BIT-001',
 4,
 'Tribhuvan University Examination Controller',
 'OFFLINE',
 'August-September',
 'July-August',
 '+2 or equivalent with minimum 45% marks',
 'Mathematics (30), Computer Science Fundamentals (20), English (20), General Knowledge & Logical Reasoning (30) - total 100 marks MCQ',
 'NPR 1,000',
 1500,
 3,
 100,
 40,
 'Entrance examination for Bachelor of Information Technology (BIT) programs under Tribhuvan University. Admission to BIT programs at TU-affiliated colleges across Nepal.',
 'https://tuexam.tu.edu.np',
 'https://images.knownepal.com/exams/bit-entrance.jpg',
 NOW(),
 NOW());

-- 9. TU LLB Entrance
INSERT INTO entrance_exams (name, name_nepali, slug, code, board_id, board_name, format, exam_date, registration_deadline, eligibility, syllabus, fee_structure, total_seats, duration_hours, total_marks, pass_marks, description, website, image_url, created_at, updated_at)
VALUES
('TU LLB Entrance Examination',
 'तु एल.एल.बी. प्रवेश परीक्षा',
 'tu-llb-entrance',
 'LLB-ENT-001',
 4,
 'Tribhuvan University Examination Controller',
 'OFFLINE',
 'August',
 'July',
 'Bachelor degree in any discipline with minimum 45% marks or CGPA 2.0',
 'General Knowledge & Current Affairs (25), Legal Aptitude & Reasoning (25), English Language (25), Nepal Polity & Constitution (25) - total 100 marks MCQ',
 'NPR 1,000',
 3000,
 3,
 100,
 40,
 'Entrance examination for Bachelor of Laws (LLB) programs under Tribhuvan University. Required for admission to 5-year BA LLB and 3-year LLB programs at TU-affiliated law colleges.',
 'https://tuexam.tu.edu.np',
 'https://images.knownepal.com/exams/tu-llb-entrance.jpg',
 NOW(),
 NOW());

-- 10. Nepal Engineering Council Licensing Exam
INSERT INTO entrance_exams (name, name_nepali, slug, code, board_id, board_name, format, exam_date, registration_deadline, eligibility, syllabus, fee_structure, total_seats, duration_hours, total_marks, pass_marks, description, website, image_url, created_at, updated_at)
VALUES
('Nepal Engineering Council Licensing Examination',
 'नेपाल इन्जिनियरिङ परिषद् इजाजतपत्र परीक्षा',
 'nec-licensing-exam',
 'NEC-LIC-001',
 8,
 'Nepal Engineering Council',
 'OFFLINE',
 'Twice a year (Chaitra and Ashwin)',
 'One month before exam',
 'BE/BArch or equivalent degree from recognized university',
 'Engineering Professional Practice & Ethics (20), Nepal Engineering Codes & Standards (20), Structural Engineering (15), General Engineering Knowledge (15), Project Management & Contracts (15), Environmental Engineering (15)',
 'NPR 3,000',
 0,
 3,
 100,
 50,
 'Professional licensing examination conducted by Nepal Engineering Council (NEC) mandatory for all engineering graduates to practice as licensed engineers in Nepal. Engineers must pass this exam to obtain NEC registration and stamp privileges.',
 'https://nec.org.np',
 'https://images.knownepal.com/exams/nec-licensing.jpg',
 NOW(),
 NOW());

-- 11. LOCEB Entrance - Lumbini Buddhist University
INSERT INTO entrance_exams (name, name_nepali, slug, code, board_id, board_name, format, exam_date, registration_deadline, eligibility, syllabus, fee_structure, total_seats, duration_hours, total_marks, pass_marks, description, website, image_url, created_at, updated_at)
VALUES
('LOCEB Entrance Examination',
 'लुम्बिनी ओपन क्याम्पस प्रवेश परीक्षा',
 'loceb-entrance',
 'LOCEB-001',
 10,
 'Lumbini Buddhist University',
 'OFFLINE',
 'November-December',
 'October-November',
 '+2 or equivalent with minimum 40% marks',
 'General Knowledge (30), English (20), Nepali (20), Program-specific subjects (30) - total 100 marks MCQ',
 'NPR 500',
 500,
 3,
 100,
 40,
 'Local entrance examination for admission to various programs at Lumbini Open Campus under Lumbini Buddhist University. Located in Rupandehi district, offering undergraduate programs in management, humanities, and Buddhist studies.',
 'https://lbu.edu.np',
 'https://images.knownepal.com/exams/loceb-entrance.jpg',
 NOW(),
 NOW());

-- 12. PSC - Public Service Commission (Nayab Subba/Kharidar)
INSERT INTO entrance_exams (name, name_nepali, slug, code, board_id, board_name, format, exam_date, registration_deadline, eligibility, syllabus, fee_structure, total_seats, duration_hours, total_marks, pass_marks, description, website, image_url, created_at, updated_at)
VALUES
('PSC Civil Service Entrance Examination (Nayab Subba/Kharidar)',
 'लोक सेवा आयोग प्रवेश परीक्षा (नायब सुबा/खरिदार)',
 'psc-civil-service-entrance',
 'PSC-NASU-001',
 NULL,
 'Public Service Commission',
 'BOTH',
 'Multiple times per year',
 'As announced by PSC',
 'SLC/SEE for Kharidar (+2 for Nayab Subba), Nepali citizenship, age 18-35',
 'General Knowledge (25), Nepali Language & Grammar (20), English Language (15), Nepal Polity & Governance (15), Current Affairs (10), Mental Ability & Reasoning (15)',
 'NPR 500-1,000',
 0,
 3,
 100,
 50,
 'Civil service entrance examination conducted by Lok Sewa Aayog (Public Service Commission) for recruitment to Nayab Subba (non-gazetted) and Kharidar (clerical) positions in Nepal government offices. One of the most competitive government examinations in Nepal with hundreds of thousands of applicants.',
 'https://psc.gov.np',
 'https://images.knownepal.com/exams/psc-civil-service.jpg',
 NOW(),
 NOW());
