CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;
COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';

CREATE TABLE results (
    id uuid DEFAULT uuid_generate_v4() PRIMARY KEY,
    survey_id uuid NOT NULL,
    json json
);

CREATE TABLE surveys (
    id uuid DEFAULT uuid_generate_v4() PRIMARY KEY,
    name character varying,
    json json
);

ALTER TABLE results ADD CONSTRAINT results_survey_id_fkey FOREIGN KEY (survey_id) REFERENCES surveys(id);
