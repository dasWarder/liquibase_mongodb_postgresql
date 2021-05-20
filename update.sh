#!/bin/bash

#update PostgreSQL with maven plugin
mvn liquibase:update

#move to the mongo changelog package
cd src/main/resources/db/changelog/mongo

#update mongo using liquibase.properties on path
liquibase update