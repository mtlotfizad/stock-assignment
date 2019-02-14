curl -X POST \
  'http://localhost:8080/api/stocks?Content-Type=application/json' \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' \
  -d '{
"name" : "mohsen",
"price": 19.9
}'