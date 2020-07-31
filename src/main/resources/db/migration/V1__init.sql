CREATE TABLE poll (
  id INT, 
  adminKey varchar(255),
  latestChange TIMESTAMP,
  initiated TIMESTAMP,
  participantsCount INTEGER,
  inviteesCount INTEGER,
  type varchar(255), 
  hidden BOOLEAN,
  preferencesType varchar(255), 
  state varchar(255), 
  locale varchar(255), 
  title varchar(255),
  optionHash varchar(255),
  device varchar(255), 
  levels varchar(255)
);


CREATE TABLE participant (
  id INTEGER,
  name varchar(255)
);

CREATE TABLE option (
  id INTEGER,
  text varchar(255),
  available BOOLEAN
);


CREATE TABLE initiator (
  id INTEGER,
  name varchar(255),
  email varchar(255),
  notify BOOLEAN
);