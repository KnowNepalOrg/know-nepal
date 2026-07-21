-- V3: Add missing festivals (35-40) and art forms (29-30)
-- V2 had 34 festivals and 28 art forms; this补充 completes to 40 and 30

-- =============================================
-- ADDITIONAL FESTIVALS (IDs 35-40)
-- =============================================
INSERT INTO festivals (slug, name, description, festival_type, culture_season, month, day, duration_days, region_type, is_national_holiday, is_public_holiday, significance, rituals, modern_celebrations, ethnic_groups_involved, province, district, is_popular, is_featured, created_at) VALUES

('ghode-jatra', 'Ghode Jatra', 'Horse racing festival at Tundikhel commemorating the subduing of a demon.', 'HINDU', 'SPRING', 'Chaitra', 'Chaitra Krishna Pratipada', 1, 'URBAN', false, false, 'Legend says horses race over the buried demon to prevent its resurrection.', 'Horse racing at Tundikhel, military parade, chariot procession', 'Military display, government officials watching, public holiday in Kathmandu', 'All communities in Kathmandu', 'Bagmati', 'Kathmandu', true, false, NOW()),

('sama-jaatra', 'Sama Jatra', 'Festival at Swayambhunath commemorating the self-sacrifice of a woman to protect her children.', 'BUDDHIST', 'MONSOON', 'Shravan', 'Shravan Krishna Pratipada', 1, 'URBAN', false, false, 'Commemorates a mother who sacrificed her life for her children at Swayambhunath.', 'Animal sacrifice at Swayambhunath, processions, prayers', 'Swayambhunath visits, community feasts, cultural events', 'Newar Buddhist', 'Bagmati', 'Kathmandu', true, false, NOW()),

('ropain-jatra', 'Ropain Jatra', 'Rice planting festival celebrating the start of the monsoon agricultural season.', 'OTHER', 'MONSOON', 'Ashad', 'Ashad Purnima', 1, 'HILL', false, false, 'Celebrates the beginning of rice planting season with communal farming.', 'Rice planting in paddy fields, folk songs, mud play', 'Community rice planting events, traditional songs, tourism events', 'Various farming communities', 'Multiple', 'Various', true, false, NOW()),

('swanti', 'Swanti (Newar Tihar)', 'Newar version of Tihar with Mha Puja (self-worship) and unique Newar rituals.', 'NEWAR', 'AUTUMN', 'Kartik', 'Kartik Krishna Pratipada to Panchami', 5, 'URBAN', false, false, 'Newar Tihar featuring Mha Puja (self-worship) and Deusi-Bhailo traditions.', 'Mha Puja, Deusi-Bhailo, oil bathing, Lakshmi Puja', 'Community gatherings, feasts, traditional games, lights', 'Newar', 'Bagmati', 'Kathmandu', true, false, NOW()),

('sindur-jatra', 'Sindur Jatra', 'Vibrant vermillion festival celebrated in Bhaktapur during Bisket Jatra.', 'NEWAR', 'SPRING', 'Chaitra', 'Chaitra (during Bisket Jatra)', 2, 'URBAN', false, false, 'Celebrated during Bisket Jatra where people throw vermillion powder.', 'Throwing sindur (vermillion), chariot procession, music', 'Colorful public celebration, music, street festivities', 'Newar', 'Bagmati', 'Bhaktapur', true, false, NOW()),

('sithi-nakha', 'Sithi Nakha', 'Newar festival for water source cleaning and environmental conservation.', 'NEWAR', 'MONSOON', 'Jestha', 'Jestha Shukla Shashthi', 1, 'URBAN', false, false, 'Traditional Newar festival for cleaning and worshipping water sources.', 'Cleaning community water spouts, prayers, environmental rituals', 'Community water source cleaning, environmental awareness programs', 'Newar', 'Bagmati', 'Kathmandu', false, false, NOW());

-- =============================================
-- ADDITIONAL ART FORMS (IDs 29-30)
-- =============================================
INSERT INTO art_forms (slug, name, description, art_type, ethnic_group_id, region_type, province, historical_significance, techniques, materials, significance, contemporary_relevance, is_intangible_heritage, created_at) VALUES

('tharu-tattoo-art', 'Tharu Tattoo Art (Sutuli)', 'Traditional geometric tattoo art of the Tharu women with deep cultural symbolism.', 'FOLK', 4, 'TERAI', 'Lumbini', 'Ancient Tharu body art tradition where tattoos mark life stages and provide spiritual protection.', 'Hand-poking technique with needle and natural ink, geometric patterns', 'Natural plant-based ink, thorn needles', 'Tattoos mark milestones: puberty, marriage, motherhood. Provide spiritual protection against evil spirits.', 'Declining among younger generation. Cultural revival efforts by Tharu organizations.', true, NOW()),

('lokta-paper-craft', 'Lokta Paper Making', 'Traditional Nepali handmade paper craft using bark of the Daphne plant from Himalayan forests.', 'FOLK', 1, 'HIMALAYAN', 'Multiple', 'Ancient papermaking tradition dating back over 1,000 years. Paper was used for religious manuscripts and government records.', 'Hand-pounding bark, spreading pulp on screens, sun drying', 'Daphne (lokta) bark, water, wooden screens', 'Produces durable, eco-friendly paper used for religious texts, official documents, and art. UNESCO recognition potential.', 'Thriving export industry. Used in stationery, lampshades, and art. Major craft cooperatives in Bhaktapur and Kathmandu.', true, NOW());
