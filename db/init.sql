DROP TABLE IF EXISTS categories;
CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

INSERT INTO categories (name) VALUES
    ('Audio'),
    ('Büro + Papeterie'),
    ('Drohnen + Elektronik'),
    ('Foto + Video'),
    ('Gaming + VR'),
    ('Netzwerk'),
    ('Notebooks + PCs'),
    ('PC Komponenten'),
    ('Peripherie'),
    ('Smartphones + Tablets'),
    ('Softwarelösungen'),
    ('TV + Heimkino'),
    ('Wearables'),
    ('Haushalt');
