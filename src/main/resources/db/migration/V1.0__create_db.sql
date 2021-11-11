create table cms_messages
(
    id     varchar(255) not null,
    answer varchar(400) not null,
    primary key (id)
);

create table cms_settings
(
    id      varchar(255) not null,
    scripts varchar(8000),
    styles  varchar(8000),
    primary key (id)
);

create table components
(
    id int8 not null,
    css   varchar(8000),
    model varchar(8000),
    position int4,
    template_id int8 not null,
    primary key (id)
);

create table page_components
(
    page_id int8 not null,
    component_id int8 not null,
    primary key (page_id, component_id)
);

create table pages
(
    id int8 not null,
    css   varchar(8000),
    path  varchar(255) not null,
    title varchar(255) not null ,
    primary key (id)
);

create table templates
(
    id int8 not null,
    css   varchar(8000),
    html  varchar(8000) not null,
    name  varchar(255) not null,
    primary key (id)
);

alter table pages
    add constraint UK_pages_path unique (path);
alter table components
    add constraint FK_components_templates foreign key (template_id) references templates;
alter table page_components
    add constraint FK_page_components_components foreign key (component_id) references components;
alter table page_components
    add constraint FK_page_components_pages foreign key (page_id) references pages;