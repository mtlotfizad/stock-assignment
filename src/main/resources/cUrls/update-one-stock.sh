curl -X PUT \
  http://localhost:8080/api/stocks/2 \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' \
  -d '{
    "newPrice": 29.9
}'