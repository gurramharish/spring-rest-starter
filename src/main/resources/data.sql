insert into SRS.REF_MENU(ID, LABEL, LINK, ACTIVE, LINK_TARGET, LINK_LEVEL, LINK_ORDER, PARENT_ID)
VALUES
(1, 'Home', '/home', 'Y', '_self', 1, 1, null);
insert into SRS.REF_MENU(ID, LABEL, LINK, ACTIVE, LINK_TARGET, LINK_LEVEL, LINK_ORDER, PARENT_ID)
VALUES
(2, 'Sub Home 1', '/sub-home1', 'Y', '_self', 2, 1, 1);
insert into SRS.REF_MENU(ID, LABEL, LINK, ACTIVE, LINK_TARGET, LINK_LEVEL, LINK_ORDER, PARENT_ID)
VALUES
(3, 'Sub Home 2', '/sub-home2', 'Y', '_self', 2, 0, 1);

insert into SRS.REF_MENU(ID, LABEL, LINK, ACTIVE, LINK_TARGET, LINK_LEVEL, LINK_ORDER, PARENT_ID)
VALUES
(4, 'News', '/news', 'Y', '_self', 1, 2, null);
insert into SRS.REF_MENU(ID, LABEL, LINK, ACTIVE, LINK_TARGET, LINK_LEVEL, LINK_ORDER, PARENT_ID)
VALUES
(5, 'Sub News 1', '/sub-news1', 'Y', '_self', 2, 1, 4);
insert into SRS.REF_MENU(ID, LABEL, LINK, ACTIVE, LINK_TARGET, LINK_LEVEL, LINK_ORDER, PARENT_ID)
VALUES
(6, 'Sub Sub News 1', '/sub-sub-news1', 'Y', '_self', 3, 1, 5);
insert into SRS.REF_MENU(ID, LABEL, LINK, ACTIVE, LINK_TARGET, LINK_LEVEL, LINK_ORDER, PARENT_ID)
VALUES
(7, 'Sub sub Sub News 1', '/sub-sub-news1', 'Y', '_self', 4, 1, 6);


insert into SRS.REF_ROLES(ID, ROLE_NAME)
VALUES
(1, 'Admin');
insert into SRS.REF_ROLES(ID, ROLE_NAME)
VALUES
(2, 'Manager');
insert into SRS.REF_ROLES(ID, ROLE_NAME)
VALUES
(3, 'Employee');


insert into SRS.REF_ROLES_MENU (ROLE_ID, MENU_ID)
VALUES
(1, 1);
insert into SRS.REF_ROLES_MENU (ROLE_ID, MENU_ID)
VALUES
(1, 2);
insert into SRS.REF_ROLES_MENU (ROLE_ID, MENU_ID)
VALUES
(1, 3);
insert into SRS.REF_ROLES_MENU (ROLE_ID, MENU_ID)
VALUES
(1, 4);
insert into SRS.REF_ROLES_MENU (ROLE_ID, MENU_ID)
VALUES
(1, 5);
insert into SRS.REF_ROLES_MENU (ROLE_ID, MENU_ID)
VALUES
(1, 6);
insert into SRS.REF_ROLES_MENU (ROLE_ID, MENU_ID)
VALUES
(1, 7);


insert into SRS.REF_ROLES_MENU (ROLE_ID, MENU_ID)
VALUES
(2, 1);
insert into SRS.REF_ROLES_MENU (ROLE_ID, MENU_ID)
VALUES
(2, 2);
insert into SRS.REF_ROLES_MENU (ROLE_ID, MENU_ID)
VALUES
(2, 3);
insert into SRS.REF_ROLES_MENU (ROLE_ID, MENU_ID)
VALUES
(2, 4);
insert into SRS.REF_ROLES_MENU (ROLE_ID, MENU_ID)
VALUES
(2, 5);

insert into SRS.REF_ROLES_MENU (ROLE_ID, MENU_ID)
VALUES
(3, 1);
insert into SRS.REF_ROLES_MENU (ROLE_ID, MENU_ID)
VALUES
(3, 2);
insert into SRS.REF_ROLES_MENU (ROLE_ID, MENU_ID)
VALUES
(3, 3);


COMMIT;