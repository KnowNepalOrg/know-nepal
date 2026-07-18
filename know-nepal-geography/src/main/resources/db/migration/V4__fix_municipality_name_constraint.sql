ALTER TABLE municipalities DROP CONSTRAINT IF EXISTS municipalities_name_key;
DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM pg_constraint WHERE conname = 'uq_municipality_name_district'
    ) THEN
        ALTER TABLE municipalities ADD CONSTRAINT uq_municipality_name_district UNIQUE (name, district_id);
    END IF;
END $$;
