curl -X POST \
  'http://localhost:8081/api/stocks?Content-Type=application/json' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: bb9268fb-1bad-45a4-9ba0-ed2bb78ca294' \
  -H 'cache-control: no-cache' \
  -d '{
"name" : "mohsen",
"price": 19.9
}'