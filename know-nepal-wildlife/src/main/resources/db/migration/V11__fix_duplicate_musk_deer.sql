-- V11: Fix duplicate musk deer record
-- V2 seed created two musk deer entries: 'musk-deer' and 'himalayan-musk-deer'
-- Remove the duplicate 'himalayan-musk-deer', keep the original 'musk-deer'
DELETE FROM wildlife_species WHERE slug = 'himalayan-musk-deer';
