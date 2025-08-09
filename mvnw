#!/bin/sh
if command -v mvn >/dev/null 2>&1; then
  mvn "$@"
else
  echo "mvn not found. Please install Maven or use a proper Maven Wrapper (.mvn)."
  exit 1
fi
