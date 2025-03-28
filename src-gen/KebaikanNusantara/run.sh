#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

java -cp aisco.product.kebaikannusantara --module-path aisco.product.kebaikannusantara -m aisco.product.kebaikannusantara &

wait