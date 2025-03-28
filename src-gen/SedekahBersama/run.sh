#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

java -cp aisco.product.sedekahbersama --module-path aisco.product.sedekahbersama -m aisco.product.sedekahbersama &

wait