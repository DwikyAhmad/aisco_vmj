#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

java -cp aisco.product.bisabisa --module-path aisco.product.bisabisa -m aisco.product.bisabisa &

wait