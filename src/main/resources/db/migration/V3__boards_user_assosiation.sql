ALTER TABLE boards
    ADD created_by_id UUID;

ALTER TABLE boards
    ALTER COLUMN created_by_id SET NOT NULL;

ALTER TABLE boards
    ADD CONSTRAINT FK_BOARDS_ON_CREATED_BY FOREIGN KEY (created_by_id) REFERENCES users (id);