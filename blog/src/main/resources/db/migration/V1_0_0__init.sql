CREATE TYPE role_type AS ENUM ('ADMIN', 'AUTHOR', 'SUBSCRIBER');
CREATE TYPE post_status_type AS ENUM ('DRAFT', 'PUBLISHED');

CREATE TABLE users
(
    user_id    INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    username   VARCHAR(100) NOT NULL,
    email      VARCHAR(150) NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,          -- Assuming hashed
    role       role_type DEFAULT 'SUBSCRIBER', -- Basic role management
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE posts
(
    post_id    INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    user_id    INT,                              -- Foreign key to the user who authored the post
    title      VARCHAR(255) NOT NULL,
    slug       VARCHAR(255) NOT NULL UNIQUE,     -- SEO-friendly URL identifier
    body       TEXT         NOT NULL,
    status     post_status_type DEFAULT 'DRAFT', -- For content moderation
    created_at TIMESTAMP        DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP        DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE SET NULL
);
