CREATE TABLE IF NOT EXISTS vendor
(
  id              SERIAL PRIMARY KEY
  ,vendorname         VARCHAR(255)
  ,createdat    TIMESTAMP

  ,CONSTRAINT ctr_vendor_name UNIQUE (vendorname)
);

CREATE TABLE IF NOT EXISTS vendor_info
(
  id            SERIAL PRIMARY KEY
  ,vendor_id    BIGINT
  ,vendor_info  TEXT
  ,createdat    TIMESTAMP
);

CREATE TABLE IF NOT EXISTS keywords
(
  id            SERIAL PRIMARY KEY
  ,vendor_id    BIGINT
  ,keyword      TEXT
  ,createdat    TIMESTAMP
);