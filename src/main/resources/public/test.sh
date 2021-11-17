#!/bin/bash

for f in *py
do
    mv $f ${f%.py}.txt
done
