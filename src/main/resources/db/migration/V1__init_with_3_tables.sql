CREATE TABLE boards
(
    id         UUID                        NOT NULL,
    name       VARCHAR(255)                NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_boards PRIMARY KEY (id)
);

CREATE TABLE columns
(
    id         UUID                        NOT NULL,
    name       VARCHAR(255)                NOT NULL,
    position   INTEGER                     NOT NULL,
    board_id   UUID,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_columns PRIMARY KEY (id)
);

CREATE TABLE tasks
(
    id          UUID                        NOT NULL,
    title       VARCHAR(255)                NOT NULL,
    description VARCHAR(255),
    priority    SMALLINT,
    column_id   UUID,
    board_id    UUID,
    created_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_tasks PRIMARY KEY (id)
);

ALTER TABLE columns
    ADD CONSTRAINT FK_COLUMNS_ON_BOARD FOREIGN KEY (board_id) REFERENCES boards (id);

ALTER TABLE tasks
    ADD CONSTRAINT FK_TASKS_ON_BOARD FOREIGN KEY (board_id) REFERENCES boards (id);

ALTER TABLE tasks
    ADD CONSTRAINT FK_TASKS_ON_COLUMN FOREIGN KEY (column_id) REFERENCES columns (id);