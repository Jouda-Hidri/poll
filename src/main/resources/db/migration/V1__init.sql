
CREATE TABLE initiator (
  id INTEGER,
  name varchar(255),
  email varchar(255),
  notify BOOLEAN
);

CREATE TABLE poll (
  id INT, 
  admin_key varchar(255),
  latest_change TIMESTAMP,
  initiated TIMESTAMP,
  participants_count INTEGER,
  invitees_count INTEGER,
  type varchar(255), 
  hidden BOOLEAN,
  preferences_type varchar(255), 
  state varchar(255), 
  locale varchar(255), 
  title varchar(255),
  option_hash varchar(255),
  invitees varchar(255),
  device varchar(255), 
  levels varchar(255),
  initiator_id INTEGER
);

ALTER TABLE poll
    ADD FOREIGN KEY (initiator_id) 
    REFERENCES initiator(id);

CREATE TABLE participant (
  id INTEGER,
  name varchar(255),
  preferences varchar(255),
  poll_id INT
);

ALTER TABLE participant
    ADD FOREIGN KEY (poll_id) 
    REFERENCES poll(id);

CREATE TABLE option (
  id INTEGER,
  text varchar(255),
  available BOOLEAN,
  poll_id INT
);

ALTER TABLE option
    ADD FOREIGN KEY (poll_id) 
    REFERENCES poll(id);

insert into initiator(id, name, email, notify) values
(1, 'John Doe', 'mh+sample@doodle.com', false);

INSERT INTO poll (id, admin_key, latest_change, initiated, participants_count, invitees_count, type, hidden, preferences_type, state, locale, title, option_hash, invitees, device, levels, initiator_id) VALUES
(1, 'r44d7piq', '2020-08-01 16:12:28.0', '2020-08-01 16:13:15.0', 4, 0, 'TEXT', true, 'YESNO', 'OPEN', 'fr_CH', 'Qui sont les superhéros Marvel les plus oufs?', '509166a0b12ed8e4ec658f0060aaf38e', '', 'WEB', 'YESNO', 1);

insert into participant (id, name, preferences, poll_id) values
(981546885, 'Ringo', '0,1,1,1,0,1,1,0', 1),
(2127452304, 'Ringo', '1,0,0', 1),
(948182187, 'Ringo', '1,1,0', 1),
(1909945479, 'Ringo', '0,0,1,1,1,0,0,0', 1),
(1923029414, 'John', '0,0,1,0,0,0,0,1', 1),
(104345741, 'Ringo', '0,0,1', 1),
(624685408, 'Ringo', '0,1,1', 1),
(422536049, 'Ringo', '0,0,1', 1),
(251375214, 'John', '1', 1),
(1495351908, 'Ringo', '1,1,1', 1),
(1787688313, 'Ringo', '1', 1),
(1675723511, 'Ringo', '0,0,1,0,1', 1); -- todo the other participants

insert into option (id, text, available, poll_id) values
(1, 'Pluto is a planet', true, 1); -- todo the other options