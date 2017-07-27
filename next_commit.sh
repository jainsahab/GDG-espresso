#!/usr/bin/env bash
echo "moving towards $1's head"
git checkout $(git rev-list --topo-order HEAD..$(git rev-parse --short "$1") | tail -1)
