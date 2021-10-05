module koty.service {

    requires koty.domain;
    requires java.sql;
    requires java.persistence;
    requires spring.beans;
    requires spring.context;
    requires spring.data.jpa;
    requires java.transaction;
    requires spring.data.commons;
    uses pl.kobietydokodu.domain.Kot;
    exports pl.kobietydokodu.service;
    exports pl.kobietydokodu.dao;
}