-- V5__seed_programs.sql
-- 20 real academic programs across institutions

INSERT INTO programs (name, name_nepali, slug, code, level, faculty, duration_years, total_seats, fee_structure, eligibility, description, institution_type, institution_id, institution_name, created_at, updated_at) VALUES
('Bachelor of Computer Science and Information Technology', 'कम्प्युटर विज्ञान र सूचना प्रविधिमा स्नातक', 'bsc-csit', 'BSC-CSIT', 'BACHELOR', 'Science', 4, 108, 'NPR 5,000-15,000 per semester', 'SEE with GPA 2.0+ and specific subject requirements', 'A comprehensive program covering programming, networking, databases, and software engineering.', 'UNIVERSITY', 1, 'Tribhuvan University', NOW(), NOW()),

('Bachelor of Business Administration', 'व्यवसाय प्रशासनमा स्नातक', 'bba', 'BBA-001', 'BACHELOR', 'Management', 4, 64, 'NPR 25,000-80,000 per semester', 'SEE with GPA 2.0+ or +2 in management', 'An industry-oriented management program developing business leaders and entrepreneurs.', 'COLLEGE', 11, 'Kathmandu College of Management', NOW(), NOW()),

('Bachelor of Medicine and Bachelor of Surgery (MBBS)', 'चिकित्सा विज्ञान र शल्यक्रिया स्नातक', 'mbbs', 'MBBS-001', 'BACHELOR', 'Health Sciences', 5.5, 100, 'NPR 50,000-150,000 per year', 'SEE Science with high merit + entrance exam', 'The primary medical degree program for aspiring doctors in Nepal.', 'UNIVERSITY', 2, 'Kathmandu University', NOW(), NOW()),

('Bachelor of Arts', 'कला स्नातक', 'ba', 'BA-001', 'BACHELOR', 'Humanities', 4, 200, 'NPR 3,000-8,000 per semester', 'SEE with GPA 1.6+', 'A broad-based arts program with majors in English, Nepali, History, Political Science, Economics.', 'UNIVERSITY', 1, 'Tribhuvan University', NOW(), NOW()),

('Bachelor of Education', 'शिक्षा स्नातक', 'bed', 'BEd-001', 'BACHELOR', 'Education', 4, 150, 'NPR 5,000-12,000 per semester', 'SEE with GPA 2.0+ or +2', 'A teacher preparation program covering pedagogy, curriculum, and educational psychology.', 'UNIVERSITY', 1, 'Tribhuvan University', NOW(), NOW()),

('Bachelor of Computer Application', 'कम्प्युटर अनुप्रयोग स्नातक', 'bca', 'BCA-001', 'BACHELOR', 'Computer Science', 4, 48, 'NPR 30,000-60,000 per semester', 'SEE with GPA 2.0+', 'A practical computer applications program covering software development and IT solutions.', 'COLLEGE', 14, 'National College of Computer Studies', NOW(), NOW()),

('Master of Science in Computer Science', 'कम्प्युटर विज्ञानमा स्नातकोत्तर', 'msc-cs', 'MSC-CS', 'MASTER', 'Computer Science', 2, 36, 'NPR 40,000-80,000 per semester', 'BSc CSIT or equivalent with 50%+', 'An advanced program in computer science covering AI, machine learning, and advanced algorithms.', 'UNIVERSITY', 1, 'Tribhuvan University', NOW(), NOW()),

('Master of Business Administration', 'व्यवसाय प्रशासनमा स्नातकोत्तर', 'mba', 'MBA-001', 'MASTER', 'Management', 2, 40, 'NPR 100,000-250,000 per semester', 'BBS/BBA or equivalent with 45%+ and entrance exam', 'A premier management program for developing senior business leaders.', 'UNIVERSITY', 2, 'Kathmandu University', NOW(), NOW()),

('Bachelor of Engineering (Civil)', 'इन्जिनियरिङ (सिभिल) मा स्नातक', 'be-civil', 'BE-CIVIL', 'BACHELOR', 'Engineering', 4, 108, 'NPR 20,000-40,000 per semester', 'SEE Science with strong math/physics + entrance exam', 'Covers structural engineering, transportation, water resources, and construction management.', 'UNIVERSITY', 1, 'Tribhuvan University', NOW(), NOW()),

('Bachelor of Engineering (Computer)', 'इन्जिनियरिङ (कम्प्युटर) मा स्नातक', 'be-computer', 'BE-COMP', 'BACHELOR', 'Engineering', 4, 72, 'NPR 25,000-50,000 per semester', 'SEE Science with strong math + entrance exam', 'Covers computer architecture, networks, software engineering, and embedded systems.', 'UNIVERSITY', 1, 'Tribhuvan University', NOW(), NOW()),

('Bachelor of Pharmacy', 'फार्मेसी स्नातक', 'bpharm', 'BPHARM-001', 'BACHELOR', 'Health Sciences', 4, 50, 'NPR 30,000-60,000 per semester', 'SEE Science with biology + entrance exam', 'A program covering pharmaceutical sciences, drug development, and clinical pharmacy.', 'UNIVERSITY', 2, 'Kathmandu University', NOW(), NOW()),

('Bachelor of Science in Nursing', 'नर्सिङमा विज्ञान स्नातक', 'bsc-nursing', 'BSC-NUR', 'BACHELOR', 'Health Sciences', 4, 40, 'NPR 20,000-50,000 per semester', 'SEE Science with biology + entrance exam', 'Prepares professional nurses with clinical skills and healthcare knowledge.', 'UNIVERSITY', 2, 'Kathmandu University', NOW(), NOW()),

('Higher Secondary (+2) Science', 'उच्च माध्यमिक शिक्षा (विज्ञान)', 'plus2-science', '+2-SCI', 'HIGHER_SECONDARY', 'Science', 2, 160, 'NPR 15,000-40,000 per year', 'SEE GPA 2.8+ with specific subject requirements', 'Pre-university science program covering Physics, Chemistry, Biology, and Mathematics.', 'COLLEGE', 4, 'National School of Science', NOW(), NOW()),

('Higher Secondary (+2) Management', 'उच्च माध्यमिक शिक्षा (व्यवस्थापन)', 'plus2-management', '+2-MGT', 'HIGHER_SECONDARY', 'Management', 2, 120, 'NPR 10,000-25,000 per year', 'SEE GPA 2.0+', 'Pre-university management program covering Accountancy, Economics, Business Studies, and Mathematics.', 'COLLEGE', 1, 'St. Xavier''s College', NOW(), NOW()),

('Higher Secondary (+2) Humanities', 'उच्च माध्यमिक शिक्षा (मानविकी)', 'plus2-humanities', '+2-HUM', 'HIGHER_SECONDARY', 'Humanities', 2, 100, 'NPR 8,000-20,000 per year', 'SEE GPA 1.6+', 'Pre-university humanities program covering Nepali, English, History, Political Science, and Sociology.', 'COLLEGE', 1, 'St. Xavier''s College', NOW(), NOW()),

('Diploma in Engineering (Civil)', 'इन्जिनियरिङमा डिप्लोमा (सिभिल)', 'diploma-civil', 'DIP-CIVIL', 'DIPLOMA', 'Engineering', 3, 48, 'NPR 15,000-25,000 per semester', 'SEE with GPA 2.0+', 'A polytechnic program covering practical civil engineering skills for immediate employment.', 'COLLEGE', 16, 'Tribhuvan University Institute of Engineering', NOW(), NOW()),

('Diploma in Pharmacy', 'फार्मेसीमा डिप्लोमा', 'diploma-pharmacy', 'DIP-PHARM', 'DIPLOMA', 'Health Sciences', 3, 40, 'NPR 20,000-35,000 per semester', 'SEE with GPA 2.5+', 'A practical pharmacy program preparing pharmacy technicians for the healthcare industry.', 'COLLEGE', 16, 'Tribhuvan University Institute of Engineering', NOW(), NOW()),

('Bachelor of Laws (LLB)', 'विधि स्नातक', 'llb', 'LLB-001', 'BACHELOR', 'Law', 5, 60, 'NPR 10,000-25,000 per semester', 'Bachelor''s degree with 45%+ and entrance exam', 'A comprehensive law program covering constitutional law, criminal law, civil law, and legal practice.', 'UNIVERSITY', 1, 'Tribhuvan University', NOW(), NOW()),

('Master of Education', 'शिक्षामा स्नातकोत्तर', 'med', 'MEd-001', 'MASTER', 'Education', 2, 30, 'NPR 15,000-30,000 per semester', 'BEd or equivalent with 50%+', 'An advanced program for educators focusing on educational leadership, curriculum development, and research.', 'UNIVERSITY', 1, 'Tribhuvan University', NOW(), NOW()),

('Bachelor of Information Technology', 'सूचना प्रविधिमा स्नातक', 'bit', 'BIT-001', 'BACHELOR', 'Computer Science', 4, 60, 'NPR 20,000-45,000 per semester', 'SEE with GPA 2.0+', 'A technology-focused program covering IT infrastructure, web development, and database management.', 'UNIVERSITY', 3, 'Pokhara University', NOW(), NOW());
