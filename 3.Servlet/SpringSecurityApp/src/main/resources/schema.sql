
CREATE TABLE `Employees` (
     `username` varchar(20) NOT NULL DEFAULT '',
     `password` varchar(20) NOT NULL DEFAULT '',
     `enabled` tinyint(1) NOT NULL DEFAULT '1',
     PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Roles` (
     `username` varchar(20) NOT NULL DEFAULT '',
     `role` varchar(20) NOT NULL DEFAULT '',
     PRIMARY KEY (`username`,`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `Employees` (`username`, `password`, `enabled`)
VALUES
    ('pankaj', 'pankaj123', 1);

INSERT INTO `Roles` (`username`, `role`)
VALUES
    ('pankaj', 'Admin'),
    ('pankaj', 'CEO');

commit;
