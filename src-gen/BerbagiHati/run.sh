#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

java -cp aisco.product.berbagihati --module-path aisco.product.berbagihati -m aisco.product.berbagihati &

wait