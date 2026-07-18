-- V12__fix_sudurpashchim_population.sql
-- Fix Sudurpashchim Province population (was incorrectly copied from Lumbini)
UPDATE provinces SET population = 2552517 WHERE id = 7;
