#!/bin/bash

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR" || exit

response=$(curl -s -X POST \
     -H "Content-Type: application/json" \
     -H "Referer: https://leetcode.com/problemset/all/" \
     -H "User-Agent: Mozilla/5.0" \
     -d '{"query": "{ activeDailyCodingChallengeQuestion { date link question { title difficulty questionFrontendId } } }"}' \
     https://leetcode.com/graphql)

echo "$response" | jq -r '.data.activeDailyCodingChallengeQuestion | "Date: \(.date)\nProblem: [\(.question.difficulty)] \(.question.title)\nLink: https://leetcode.com\(.link)"'

title=$(echo "$response" | jq -r '.data.activeDailyCodingChallengeQuestion | "\(.question.questionFrontendId). \(.question.title)"')
java ./src/main/java/shane/leetcode/util/ClassNameFactory.java "$title"
