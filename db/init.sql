DROP TABLE IF EXISTS orderentries;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS categories;


CREATE TABLE categories (
    id INT GENERATED ALWAYS AS IDENTITY,
    name TEXT NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE products (
    id INT GENERATED ALWAYS AS IDENTITY,
    categoryId INT NOT NULL,
    price INT NOT NULL,
    vendorName TEXT NOT NULL,
    productName TEXT NOT NULL,
    shortDetail TEXT NOT NULL,
    rating INT NOT NULL,
    numberOfRatings INT NOT NULL,
    PRIMARY KEY(id, categoryId),
    CONSTRAINT fk_category FOREIGN KEY (categoryId) REFERENCES categories (id)
);

CREATE TABLE orders (
    id INT GENERATED ALWAYS AS IDENTITY,
    firstname TEXT NOT NULL,
    lastname TEXT NOT NULL,
    streetAndHouseNr TEXT NOT NULL,
    plz INT NOT NULL,
    city TEXT NOT NULL,
    email TEXT NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE orderentries (
    orderId INT NOT NULL,
    productId INT NOT NULL,
    categoryId INT NOT NULL,
    price INT NOT NULL,
    PRIMARY key(orderId, productId, categoryId),
    CONSTRAINT fk_order FOREIGN KEY (orderId) REFERENCES orders (id),
    CONSTRAINT fk_product FOREIGN KEY (productId, categoryId) REFERENCES products (id, categoryId)
);

INSERT INTO categories (id, name) OVERRIDING SYSTEM VALUE VALUES
    (1, 'Audio'),
    (2, 'Büro + Papeterie'),
    (3, 'Drohnen + Elektronik'),
    (4, 'Foto + Video'),
    (5, 'Gaming + VR'),
    (6, 'Netzwerk'),
    (7, 'Notebooks + PCs'),
    (8, 'PC Komponenten'),
    (9, 'Peripherie'),
    (10, 'Smartphones + Tablets'),
    (11, 'Softwarelösungen'),
    (12, 'TV + Heimkino'),
    (13, 'Wearables'),
    (14, 'Haushalt');

INSERT INTO products (id, categoryId, price, vendorName, productName, shortDetail, rating, numberOfRatings) OVERRIDING SYSTEM VALUE VALUES
    (38610474, 1, 232, 'Apple', 'AirPods Pro (2nd Gen.) MagSafe USB-C', 'ANC, 6 h, Kabellos', 4, 60),
    (21993129, 1, 233, 'Apple', 'AirPods Pro (2nd Gen.) MagSafe Case', 'ANC, 6 h, Kabellos', 5, 1517),
    (21210362, 1, 119, 'Jabra', 'Evolve 65 SE MS', 'Kabelgebunden, Kabellos', 4, 49),
    (20767804, 1, 96, 'Philips', 'TAT4556BK/00', 'ANC, 29 h, Kabellos', 4, 53),
    (10802238, 1, 123, 'Apple', 'AirPods (2nd Gen.) Charging Case', 'keine Geräuschunterdrückung, 3 h, Kabellos', 4, 6572),
    (5897211, 1, 23, 'Apple', 'EarPods', 'Kabelgebunden', 4, 1469),
    (13190620, 1, 166, 'Jabra', 'Evolve 65 MS', 'Kabellos', 4, 233),
    (12697551, 1, 18, 'Samsung', 'USB Type-C EO-IC100', 'Kabelgebunden', 4, 758),
    (38610491, 1, 24, 'Apple', 'EarPods (USB-C)', 'Kabelgebunden', 4, 13),
    (21618879, 1, 149, 'Samsung', 'Galaxy Buds2 Pro', 'ANC, 5 h, Kabellos', 4, 550),
    (9240749, 2, 154, 'Brother', 'TN-243 Multipack', 'C, M, Y, BK', 4, 1737),
    (13649078, 2, 24, 'Aukey', 'Webcam 1080 Dual Mic', '2 Mpx', 4, 1422),
    (21210362, 2, 119, 'Jabra', 'Evolve 65 SE MS', 'Kabelgebunden, Kabellos', 4, 49),
    (13792782, 2, 79, 'HP', '963 4-pack', 'C, M, Y, BK', 4, 1192),
    (5756933, 2, 49, 'HP', '953XL', 'BK', 4, 1742),
    (288396, 2, 67, 'Logitech', 'HD Pro C920', '2 Mpx', 4, 1411),
    (5771424, 2, 36, 'HP', '953XL', 'Y', 4, 1742),
    (5771422, 2, 36, 'HP', '953XL', 'C', 4, 1742),
    (13843926, 2, 37, 'Logitech', 'R500s Graphite', '', 4, 415),
    (8364831, 2, 54, 'Canon', 'PGI-580/CLI-581 Multipack', 'C, M, Y, BK, PGBK', 4, 3831),
    (20896396, 3, 28, 'Shelly', 'Plus 2PM', '', 4, 52),
    (20796660, 3, 171, 'DJI', 'Mini 3 Pro Fly More Kit', 'Diverse, Mini 3 Pro', 4, 387),
    (24008456, 3, 25, 'Sonoff', 'USB Dongle ZBDongle-E, Zigbee', '', 4, 20),
    (24142200, 3, 269, 'Flipper', 'Zero', '', 2, 31),
    (11267870, 3, 77, 'Raspberry Pi', '4 2G Model B', '', 4, 84),
    (16688331, 3, 24, 'Shelly', 'Plus 1PM', '', 4, 62),
    (16686912, 3, 22, 'Shelly', 'Plus 1', '', 5, 33),
    (17346864, 3, 40, 'Raspberry Pi', 'Zero 2 W', '', 4, 13),
    (21655619, 3, 109, 'HutoPi', 'Raspberry Pi 4 2GB Starter Kit', '', 4, 33),
    (24227732, 3, 13, 'Raspberry Pi', 'Official cable Micro-HDMI to HDMI Black, 2m', '', 5, 2),
    (16738702, 4, 44, 'Samsung', 'EVO Plus', 'microSDXC, 512 GB, U3, UHS-I', 5, 818),
    (20932250, 4, 32, 'SanDisk', 'Extreme PRO microSDXC', 'microSDXC, 256 GB, U3, UHS-I', 5, 824),
    (12344745, 4, 105, 'WD', 'Elements', '5 TB', 4, 5771),
    (23938521, 4, 242, 'Samsung', 'T7 Shield', '4000 GB', 5, 513),
    (20954990, 4, 25, 'SanDisk', 'Extreme PRO SDXC /s UHS-I', 'SDXC, 128 GB, U3, UHS-I', 5, 636),
    (448766, 4, 67, 'WD', 'Elements', '2 TB', 4, 5771),
    (659349, 4, 23, 'Fujifilm', 'Instax Mini', 'Instax Mini', 4, 1996),
    (13953125, 4, 128, 'SanDisk', 'Extreme Portable', '2000 GB', 5, 1021),
    (20954992, 4, 23, 'SanDisk', 'Extreme PRO microSDXC', 'microSDXC, 128 GB, U3, UHS-I', 5, 824),
    (20954988, 4, 45, 'SanDisk', 'Extreme PRO SDXC', 'SDXC, 256 GB, U3, UHS-I', 5, 636),
    (36630373, 5, 59, 'Nintendo', 'Super Mario Bros. Wonder', 'Switch, FR, IT, DE', 4, 79),
    (36849057, 5, 506, 'Meta', 'Quest 3 128 GB', '', 4, 83),
    (37757784, 5, 460, 'Sony', 'Playstation 5 - EA SPORTS FC 24 Bundle', '', 4, 3077),
    (36239571, 5, 70, 'Sony', 'Marvel''s Spider-Man 2', 'PS5, DE, IT, FR', 5, 20),
    (13427533, 5, 60, 'Sony', 'DualSense Wireless-Controller - White', 'PS5', 5, 3086),
    (15838033, 5, 65, 'Sony', 'DualSense Wireless-Controller - Midnight Black', 'PS5', 5, 3086),
    (13649078, 5, 24, 'Aukey', 'Webcam 1080 Dual Mic', '2 Mpx', 4, 1423),
    (21021257, 5, 30, 'Apple', 'Gift Card', '', 4, 257),
    (288396, 5, 67, 'Logitech', 'HD Pro C920', '2 Mpx', 4, 141),
    (13329224, 5, 400, 'Sony', 'Playstation 5-Digital Edition', '', 4, 3077),
    (206490, 6, 23, 'Netgear', 'GS105GE', '5 Ports', 4, 1173),
    (12118164, 6, 11, 'digitec', 'Ethernet-Patchkabel RJ45', 'S/FTP, CAT6a, 1m', 4, 3839),
    (22459354, 6, 42, 'Google', 'Chromecast mit Google TV HD', 'Google Assistant, Google TV', 4, 221),
    (22720374, 6, 163, 'Apple', 'TV 128GB (3. Gen)', 'Apple Siri', 5, 323),
    (18253952, 6, 158, 'Ubiquiti', 'U6-Pro', '4800 Mbit/s, 573 Mbit/s', 4, 96),
    (12118144, 6, 12, 'digitec', 'Ethernet-Patchkabel RJ45', 'S/FTP, CAT6a, 2 m', 4, 3839),
    (13751323, 6, 116, 'Ubiquiti', 'USW-LITE-8-POE', '8 Ports', 4, 93),
    (12118146, 6, 15, 'digitec', 'Ethernet-Patchkabel RJ45', 'S/FTP, CAT6a, 5 m', 4, 3839),
    (36025360, 6, 99, 'Ubiquiti', 'U6+', '2402 Mbit/s, 574 Mbit/s', 4, 26),
    (12745975, 6, 31, 'Ubiquiti', 'UniFi Switch Flex Mini', '5 Ports', 5, 460),
    (14005650, 7, 25, 'Apple', 'USB-C Power Adapter', '20 W', 4, 4298),
    (10036392, 7, 112, 'Apple', 'Pencil (2. Generation)', '', 5, 3186),
    (11656028, 7, 142, 'HP', 'G5 Universal Dock', 'USB C', 4, 576),
    (11499332, 7, 24, 'Samsung', 'Schnellladegerät EP-TA800XB', '25 W, Fast Charge', 5, 1310),
    (12344745, 7, 105, 'WD', 'Elements', '5 TB', 4, 5771),
    (17574331, 7, 27, 'Google', 'USB-C Netzteil', '30 W, Power Delivery', 4, 182),
    (23938521, 7, 242, 'Samsung', 'T7 Shield', '4000 GB', 5, 513),
    (21021257, 7, 30, 'Apple', 'Gift Card', '', 4, 257),
    (14559644, 7, 17, 'Samsung', 'Schnellladegerät TA800N (ohne Kabel)', '25 W, SuperDart Charge, Fast Charge', 5, 1160),
    (22496565, 7, 121, 'HP', 'G5 Essential', 'USB C', 4, 146),
    (5614395, 8, 8, 'Thermal Grizzly', 'Kryonaut', '12.50 W/m, K, 1 g', 4, 2136),
    (22097721, 8, 162, 'Samsung', '990 Pro', '2000 GB, M.2 2280', 4, 147),
    (14679277, 8, 155, 'Samsung', '980 Pro', '2000 GB, M.2 2280', 5, 1750),
    (12344745, 8, 105, 'WD', 'Elements', '5 TB', 4, 5771),
    (14598791, 8, 78, 'Samsung', '870 EVO', '1000 GB, 2.5''''', 5, 1851),
    (23938521, 8, 242, 'Samsung', 'T7 Shield', '4000 GB', 5, 513),
    (24667438, 8, 393, 'AMD', 'Ryzen 7 7800X3D', 'AM5, 4.20 GHz, 8-Core', 4, 96),
    (448766, 8, 67, 'WD', 'Elements', '2 TB', 4, 5771),
    (14598992, 8, 129, 'Samsung', '870 EVO', '2000 GB, 2.5''''', 5, 1851),
    (13953125, 8, 128, 'SanDisk', 'Extreme Portable', '2000 GB', 5, 1021),
    (219226, 9, 7, 'Value', 'Netzkabel Schweiz T12 auf C13', '1.80 m', 4, 6350),
    (6154968, 9, 15, 'Max Hauri', 'Netzstecker-Adapter', 'Typ 12', 4, 18422),
    (219256, 9, 7, 'Roline', 'Notebook Netzkabel Schweiz T12 auf C5', '1.80 m', 4, 2793),
    (6154969, 9, 8, 'Max Hauri', 'Fixadapter Konturenstecker 2-polig', 'CEE 7/17', 4, 5771),
    (14005650, 9, 25, 'Apple', 'USB-C Power Adapter', '20 W', 4, 4302),
    (20987854, 9, 93, 'Logitech', 'MX Master 3S', 'Kabellos', 5, 771),
    (14153870, 9, 25, 'Logitech', 'Marathon M705', 'Kabellos', 4, 923),
    (6012093, 9, 22, 'Apple', 'USB C - USB C', '2 m, USB 2.0', 4, 1239),
    (16738702, 9, 44, 'Samsung', 'EVO Plus', 'microSDXC, 512 GB, U3, UHS-I', 5, 821),
    (9240749, 9, 154, 'Brother', 'TN-243 Multipack', 'C, M, Y, BK', 4, 1739),
    (14005650, 10, 25, 'Apple', 'USB-C Power Adapter', '20 W', 4, 4302),
    (10036392, 10, 117, 'Apple', 'Pencil (2. Generation', '', 5, 3189),
    (15711578, 10, 99, 'Apple', 'AirTag (4 Pack)', '', 4, 1986),
    (11499332, 10, 19, 'Samsung', 'Schnellladegerät EP-TA800XB', '25 W, Fast Charge', 5, 1310),
    (17574331, 10, 27, 'Google', 'USB-C Netzteil', '30 W, Power Delivery', 4, 182),
    (14559644, 10, 15, 'Samsung', 'Schnellladegerät TA800N (ohne Kabel)', '25 W, SuperDart Charge, Fast Charge', 5, 1167),
    (21021257, 10, 30, 'Apple', 'Gift Card', '', 4, 257),
    (24435196, 10, 354, 'Samsung', 'Galaxy A54 5G', '128 GB, Awesome Graphite, 6.40'''', Hybrid Dual SIM', 4, 277),
    (15674921, 10, 59, 'Aukey', 'Omnia PA-B6S + USB C Kabel', '90 W, Adaptive Fast Charge, Quick Charge 4.0', 4, 992),
    (15711579, 10, 33, 'Apple', 'AirTag (1 Pack)', '', 4, 1076),
    (21021257, 11, 30, 'Apple', 'Gift Card', '', 4, 257),
    (435679, 11, 79, 'Microsoft', '365 Family', '6 x, 1 J.', 4, 2001),
    (2476194, 11, 59, 'Microsoft', '365 Single', '1 x, 1 J.', 4, 884),
    (21021255, 11, 50, 'Apple', 'Gift Card', '', 4, 133),
    (16447465, 11, 125, 'Microsoft', 'Office Home & Sutdent 2021', '1 x, Unbegrenzt', 4, 242),
    (16767661, 11, 144, 'Microsoft', 'Windows 11 Pro', 'Unbegrenzt', 4, 84),
    (13329441, 11, 10, 'Google', 'Play Digital Code 10 CHF', '', 4, 394),
    (16716606, 11, 67, 'Microsoft', '365 Family', '6 x, 1 J.', 4, 187),
    (13431409, 11, 10, 'Sony', 'PlayStation Network Guthaben Aufstockung', '', 4, 243),
    (21021254, 11, 100, 'Apple', 'Gift Card', '', 4, 98),
    (22459354, 12, 42, 'Google', 'Chromecast mit Google TV HD', 'Google Assistant, Google TV', 4, 224),
    (22720374, 12, 163, 'Apple', 'TV 128 GB (3. Gen)', 'Apple Siri', 5, 323),
    (25053456, 12, 449, 'Samsung', 'UE55CU7172U', '55'''', CU7170, LED, 4K, 2023', 4, 23),
    (8946546, 12, 71, 'One for All', 'Solid WM4661', 'Wand, 84'''', 60 kg', 4, 467),
    (3228333, 12, 29, 'Logitech', 'Bluetooth Audio-Receiver', 'Empfänger', 4, 1529),
    (22719628, 12, 142, 'Apple', 'TV 64GB (3. Gen)', 'Apple Siri', 4, 105),
    (8946544, 12, 32, 'One for All', 'Solid WM4611', 'Wand, 90'''', 100 kg', 4, 228),
    (16644981, 12, 13, 'TP-Link', 'UB500', 'Sender', 4, 531),
    (14676764, 12, 61, 'Google', 'Chromecast mit Google TV 4K', 'Google Assistant', 4, 750),
    (22870669, 12, 128, 'Formuler', 'Z 11 Pro', '', 4, 77),
    (21957937, 13, 96, 'Garmin', 'HRM-Pro Plus', '', 5, 248),
    (21191555, 13, 34, 'Xiaomi', 'Smart Band 7', '20.70 mm, Kunststoff, One Size', 4, 212),
    (6071323, 13, 31, 'Garmin', 'Ladekabel', '', 4, 484),
    (10503969, 13, 57, 'Garmin', 'HRM-Dual', '', 4, 1057),
    (24722055, 13, 97, 'Xiamoi', 'Redmi Watch 3', '42.58 mm, Aluminium, Kunststoff, One Size', 4, 103),
    (21870503, 13, 70, 'Fitbit', 'Inspire 3', '39.32 mm, Aluminium, S, L', 4, 65),
    (16478358, 13, 123, 'Fitbit', 'Charge 5', 'Stahl, One Size', 4, 415),
    (21996936, 13, 239, 'Apple', 'Watch SE 2022', '40 mm, Aluminium, nur WLAN, One Size', 4, 476),
    (22568323, 13, 76, 'Polar', 'H10 M-XXL', '', 4, 40),
    (21870501, 13, 148, 'Fitbit', 'Versa 4', '40.30 mm, Aluminium, S, L', 4, 87),
    (22459354, 14, 42, 'Google', 'Chromecast mit Google TV HD', 'Google Assistant, Google TV', 4, 224),
    (5628454, 14, 61, 'Philips', 'Hue Bridge', '', 4, 2433),
    (14514924, 14, 19, 'Philips', 'Hue Dimmschalter 2021', '', 5, 1179),
    (22720374, 14, 163, 'Apple', 'TV 128GB (3. Gen)', 'Apple Siri', 5, 323),
    (14791642, 14, 52, 'Philips', 'Series 7000', '', 4, 799),
    (16693628, 14, 51, 'Hombli', 'Smart Swiss Socket 2+1', '', 4, 895),
    (13274601, 14, 60, 'Philips', 'Hue Lightstrips Basis BT', 'RGBW, 200 cm', 4, 1446),
    (15994257, 14, 52, 'TP-Link', 'Tapo C210', '2304 x 1296 Pixels', 4, 574),
    (6603160, 14, 41, 'Philips Sonicare', 'C3 Premium Plaque Defence', '4 x', 4, 1239),
    (22719628, 14, 142, 'Apple', 'TV 64GB (3. Gen)', 'Apple Siri', 4, 105);
