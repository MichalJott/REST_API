#!/usr/bin/env sh

URL=http://localhost:8080/crud/v1/task/getTasks

fail() {
  echo "There were errors"
}

runBrowser() {
    open $URL
}

if ./runcrud.sh; then
   runBrowser
else
   fail
fi