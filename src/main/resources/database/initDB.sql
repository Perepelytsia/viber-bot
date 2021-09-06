/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  sith
 * Created: Sep 5, 2021
 */

CREATE TABLE IF NOT EXISTS question
(
    id    BIGSERIAL PRIMARY KEY,
    day DATE NOT NULL,
    at TIME NOT NULL,
    name  VARCHAR(28) NOT NULL,
    token  VARCHAR(100) NOT NULL,
    data TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS answer
(
    id    BIGSERIAL PRIMARY KEY,
    day DATE NOT NULL,
    at TIME NOT NULL,
    token  VARCHAR(100) NOT NULL,
    data TEXT NOT NULL
);