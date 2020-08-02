
CREATE TABLE initiator (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255),
  email VARCHAR(255),
  notify BOOLEAN
);

CREATE TABLE poll (
  id VARCHAR(255) PRIMARY KEY, 
  admin_key VARCHAR(255),
  latest_change TIMESTAMP,
  initiated TIMESTAMP,
  participants_count INTEGER,
  invitees_count INTEGER,
  type VARCHAR(255), 
  hidden BOOLEAN,
  preferences_type VARCHAR(255), 
  state VARCHAR(255), 
  locale VARCHAR(255), 
  title VARCHAR(255), 
  description VARCHAR(255),
  option_hash VARCHAR(255),
  invitees VARCHAR(255),
  device VARCHAR(255), 
  levels VARCHAR(255),
  initiator_id INTEGER
);

ALTER TABLE poll
    ADD FOREIGN KEY (initiator_id) 
    REFERENCES initiator(id);

CREATE TABLE participant (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255),
  preferences VARCHAR(255),
  poll_id VARCHAR(255)
);

ALTER TABLE participant
    ADD FOREIGN KEY (poll_id) 
    REFERENCES poll(id);

CREATE TABLE option (
  id BIGINT PRIMARY KEY,
  text VARCHAR(255),
  start TIMESTAMP,
  end TIMESTAMP,
  allday BOOLEAN,
  start_date TIMESTAMP,
  end_date TIMESTAMP,
  available BOOLEAN,
  type VARCHAR(255),
  poll_id VARCHAR(255)
);

ALTER TABLE option
    ADD FOREIGN KEY (poll_id) 
    REFERENCES poll(id);

insert into initiator(id, name, email, notify) values
(1, 'John Doe', 'mh+sample@doodle.com', false);

INSERT INTO poll (id, admin_key, latest_change, initiated, participants_count, invitees_count, type, hidden, preferences_type, state, locale, title, description, option_hash, invitees, device, levels, initiator_id) VALUES
('xsd4cv89t5f5um4b', 'r44d7piq', '2020-08-01 16:12:28.0', '2020-08-01 16:13:15.0', 4, 0, 'TEXT', true, 'YESNO', 'OPEN', 'fr_CH', 'Qui sont les superhéros Marvel les plus oufs?', null, '509166a0b12ed8e4ec658f0060aaf38e', null, 'WEB', 'YESNO', 1),
('ps5878bwv3eyxkzm', 'sp4xfrkr', '2020-08-02 09:15:55.0', '2020-08-02 09:16:32.0', 4, 0, 'DATE', true, 'YESNO', 'OPEN', 'fr_CH', 'Petit Jay va avoir DEUX ANS! Déjà \\o/', 'Le bébé le plus adorable au monde va avoir 2 ans le 12 janvier. Le temps passe vite. Quand auriez-vous du temps pour fêter avec nous?', '99e3ce6640a4e56362c87b1f8d820291', null, 'WEB', 'YESNO', 1),
('kvckhe3m5xaiw6fa', '2cxgkvk9', '2020-08-02 09:24:21.0', '2020-08-02 09:24:52.0', 1, 0, 'TEXT', true, 'YESNO', 'OPEN', 'fr_CH', 'Who are the most badass Marvel superheroes?', null, '509166a0b12ed8e4ec658f0060aaf38e', null, 'WEB', 'YESNO', 1),
('h75eeaudhf3tf3v3', 'wyemiw4y', '2020-08-02 09:30:37.0', '2020-08-02 09:31:09.0', 3, 0, 'DATE', true, 'YESNO', 'OPEN', 'fr_CH', '小杰伊两岁', '可爱的宝宝世界会变成2岁的1月12日时间过得真快。你什么时候有时间和我们一起庆祝？', '99e3ce6640a4e56362c87b1f8d820291', null, 'WEB', 'YESNO', 1);


insert into participant (id, name, preferences, poll_id) values
(981546885, 'Ringo', '0,1,1,1,0,1,1,0', 'xsd4cv89t5f5um4b'),
(2127452304, 'Ringo', '1,0,0', 'xsd4cv89t5f5um4b'),
(948182187, 'Ringo', '1,1,0', 'xsd4cv89t5f5um4b'),
(1909945479, 'Ringo', '0,0,1,1,1,0,0,0', 'xsd4cv89t5f5um4b'),
(1923029414, 'John', '0,0,1,0,0,0,0,1', 'ps5878bwv3eyxkzm'),
(104345741, 'Ringo', '0,0,1', 'ps5878bwv3eyxkzm'),
(624685408, 'Ringo', '0,1,1', 'ps5878bwv3eyxkzm'),
(422536049, 'Ringo', '0,0,1', 'ps5878bwv3eyxkzm'),
(251375214, 'John', '1', 'kvckhe3m5xaiw6fa'),
(1495351908, 'Ringo', '1,1,1', 'h75eeaudhf3tf3v3'),
(1787688313, 'Ringo', '1', 'h75eeaudhf3tf3v3'),
(1675723511, 'Ringo', '0,0,1,0,1', 'h75eeaudhf3tf3v3');

insert into option (id, text, available, type, poll_id) values
(1, 'Pluto is a planet', true, 'Text', 'xsd4cv89t5f5um4b');

insert into option (id, start, end, allday, start_date, end_date, available, type, poll_id) values
(2, '2020-08-02 10:55:13.0', '2020-08-02 10:52:54.0', true, '2020-08-02 10:53:46.0', '2020-08-02 10:54:37.0', true, 'Date', 'kvckhe3m5xaiw6fa');