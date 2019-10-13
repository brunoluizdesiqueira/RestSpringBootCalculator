﻿CREATE TABLE IF NOT EXISTS public.user_permission (
    id_user BIGSERIAL NOT NULL,
    id_permission bigint NOT NULL,
    PRIMARY KEY (id_user,id_permission),
    CONSTRAINT fk_user_permission FOREIGN KEY (id_user) REFERENCES users (id),
    CONSTRAINT fk_user_permission_permission FOREIGN KEY (id_permission) REFERENCES permission (id)
)